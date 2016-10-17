package com.spring.mvc.web.common;


import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.ModelMap;
import org.springframework.validation.DataBinder;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;

import com.fasterxml.jackson.databind.ObjectMapper;

public abstract class BaseController {
	protected final Logger logger = LoggerFactory.getLogger(this.getClass());
	private static final ObjectMapper MAPPER = new ObjectMapper();

	/** 获取当前用户Id 
	protected Integer getCurrUser() {
		return WebUtil.getCurrentUser();
	}*/

	/**绑定用户验证器*/
	@InitBinder
	public void initBinder(DataBinder binder){
	    //注解代替手动写验证器
	    //binder.setValidator(new UserNewValidator());
	    DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
	    df.setLenient(false);
	    binder.registerCustomEditor(Date.class, new CustomDateEditor(df, true));
	}
	
	/** 设置成功响应代码 */
	protected ResponseEntity<ModelMap> setSuccessModelMap(ModelMap modelMap) {
		return setSuccessModelMap(modelMap, null);
	}

	/** 设置成功响应代码 */
	protected ResponseEntity<ModelMap> setSuccessModelMap(ModelMap modelMap, Object data) {
		return setModelMap(modelMap, HttpStatus.OK, data);
	}

	/** 设置响应代码 */
	protected ResponseEntity<ModelMap> setModelMap(ModelMap modelMap, HttpStatus code) {
		return setModelMap(modelMap, code, null);
	}

	/** 设置响应代码 */
	protected ResponseEntity<ModelMap> setModelMap(ModelMap modelMap, HttpStatus code, Object data) {
		modelMap.remove("void");
		if (data != null) {
			modelMap.put("data", data);
		}
		modelMap.put("httpCode", code.value());
		modelMap.put("msg", code.getReasonPhrase());
		modelMap.put("timestamp", System.currentTimeMillis());
		return ResponseEntity.ok(modelMap);
	}

	/** 异常处理 */
	@ExceptionHandler(Exception.class)
	protected void exceptionHandler(HttpServletRequest request, HttpServletResponse response, Exception ex) throws Exception {
		logger.error("throws exceptions : ", ex);
		ModelMap modelMap = new ModelMap();
		if (ex instanceof RuntimeException) {
		    logger.error("throws exceptions : ", ex.getMessage());
		    modelMap.put("msg", ex.getMessage());
		}
		/*} else if (ex instanceof IllegalArgumentException) {
			new IllegalParameterException(ex.getMessage()).handler(modelMap);
		} else if (ex instanceof UnauthorizedException) {
			setModelMap(modelMap, HttpStatus.FORBIDDEN);
		} else {*/
		//}
		/*request.setAttribute("msg", modelMap.get("msg"));
		byte[] bytes = JSON.toJSONBytes(modelMap, SerializerFeature.DisableCircularReferenceDetect);
		response.getOutputStream().write(bytes);*/
		
		setModelMap(modelMap, HttpStatus.INTERNAL_SERVER_ERROR);
		response.setContentType("application/json;charset=UTF-8");
		MAPPER.writeValue(response.getOutputStream(), modelMap);
	}
}