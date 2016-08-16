 <#assign context=rc.getContextPath()/>
 <a class="add" href="javascript:showaddform();" >新  增</a>
 <table cellspacing="0" cellpadding="0">
  <tr>
  	<th>脚本名称</th>
  	<th>脚本路径</th>
  	<th>所属系统</th>
  	<th>时间表达式</th>
  	<th>运行状态</th>
  	<th>下次触发时间</th>
  	<th>操作</th>
  </tr>
<#list scriptlist as script>
  <tr id="${script.id}">
   <td>${script.jobname} </td>
   <td>${script.scriptpath}</td>
   <td>${script.system}</td>
   <td id="cronExpression_${script.id}">
     ${script.jobMessage.cronExpression}
     <input style="vertical-align:middle;" class="button_g" onclick="showeditform('${script.id}','${script.jobname}','${script.jobMessage.cronExpression}');" type="button" value="修改" name="button"/>
   </td>
   <td><#if script.jobMessage.jobState=='NORMAL'>运行<#else>停止</#if></td>
   <td>${script.jobMessage.nextFireTime?string("yyyy-MM-dd HH:mm:ss")}</td>
   <td>
      <#if script.jobMessage.jobState=='NORMAL'>
       <a href="javascript:pauseScheduler('${script.jobname}','script_group','scriptlist');" class="paused" style="width:40px;"></a>
      <#else> 
       <a href="javascript:resumeScheduler('${script.jobname}','script_group','scriptlist');" class="start" style="width:40px;"></a>
      </#if>
      <a href="javascript:removeScript('${script.jobname}','${script.id}');" class="del">删除</a>
    </td>
  </tr> 
</#list>
 </tabel> 
