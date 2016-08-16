<#import "/spring.ftl" as spring />
<#import "/templates/mod.ftl" as w/>
<#import "/templates/mod.ftl" as base/>
<#assign context=rc.getContextPath()/>
<#assign security=JspTaglibs["/WEB-INF/security.tld"] />
<@base.page title="user">


  <div id="bd" class="home">
    <div class="user" id="right"></div>

  
<div id="addform" style="<#if error??><#else>display:none</#if>">
<h3>新增用户</h3>
<form action="${context}/user/addUser" method="post">
<table cellpadding="0" cellspacing="0">
	<tr>
		<th>用户名：</th>
		<td><@spring.formInput "userForm.loginName" /><span>* (以字母开头，长度 在6-20之间，只能包含字符、数字和下划线)<@spring.showErrors "<br>"/></span></td>
	</tr>
	<tr>
		<th>密  码：</th>
		<td><@spring.formPasswordInput "userForm.pass" /><span>* (以字母开头，长度 在6-20之间，只能包含字符、数字和下划线)<@spring.showErrors "<br>"/></span></td>
	</tr>
	<tr>
		<th>重复密码：</th>
		<td><@spring.formPasswordInput "userForm.pass2" /><span>* <@spring.showErrors "<br>"/></span></td>
	</tr>
	<tr>
		<th>用户类型：</th>
		<td>
			<select name="role" id="role">
             <option VALUE="ROLE_USER">普通用户</option>
             <@security.authorize ifAllGranted="ROLE_SUPER_ADMIN"><option VALUE="ROLE_ADMIN">管理员</option></@security.authorize>
            </select>
        </td>
    </tr>
    <tr>
    	<th style="border-bottom:none;">激活</th>
    	<td style="border-bottom:none;"><input type="radio" name="enable" value="1" checked> 可用 
    <input type="radio" name="enable" value="0"> 不可用 </td>
    </tr>
</table>

 <div region="south" class="box_b">
   <input type="submit" value="确  定" class="ok">
   <input onclick="hiddenform();" type="button" value="取  消" class="cancel">
 </div>
</form> 
</div>
  </div>
<script type="text/javascript">

	$(document).ready(function(){
	   //获得当前系统用户列表
	   $.get('${context}/user/userlist',null,function(data){
	      $('#right').html(data);
	   }); 
	});
	
	
  function showaddform(){
     $("#addform").show();
  }
  
  function hiddenform(){
     $("#addform").hide();
  }		
    
    
  //设置用户是否可用
  function enableUser(userid,flag){
	var params;
	if (params == null)params = {};
	params["flag"] = flag;
    $.post('${context}/user/enableUser/'+userid,params,function(data){
      $.get('${context}/user/userlist',null,function(data){
  	      $('#right').html(data);
  	   });
    });
   }
   
   //修改用户级别(用户类型)
   function updateRole(userid,role){
	var params;
	if (params == null)params = {};
	params["id"] = userid;
	params["role"] = role;
    $.post('${context}/user/updateRole/',params,function(data){
      $.get('${context}/user/userlist',null,function(data){
  	      $('#right').html(data);
  	   });
    });
   }
   
  //永久删除用户
  function removeUserById(userid){
   if(confirm("确定要永久性删除该用户吗？")){
     $.post('${context}/user/delUser/'+userid,null,function(data){
      $.get('${context}/user/userlist',null,function(data){
  	      $('#right').html(data);
  	   });
     });
    }
   }

 </script>


</@base.page >
