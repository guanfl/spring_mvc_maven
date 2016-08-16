<#import "/spring.ftl" as spring />
<#import "/templates/mod.ftl" as base/>
<#assign context=rc.getContextPath()/>
<@base.page title="password">
<div id="tcontent" class="home">
<h3>修改当前用户密码</h3>
<form action="${context}/pwd/changPwd" method="post">
<table cellpadding="0" cellspacing="0">
	<tr>
		<th>新密码：</th>
		<td><@spring.formPasswordInput "userPwdForm.pass" /><span>* (以字母开头，长度 在6-20之间，只能包含字符、数字和下划线)<@spring.showErrors "<br>"/></span></td>
	</tr>
	<tr>
		<th>重复密码：</th>
		<td><@spring.formPasswordInput "userPwdForm.pass2" /><span>* <@spring.showErrors "<br>"/></span></td>
	</tr>
</table>
 <div region="south" class="box_b" >
   <input type="submit" value="确  定" class="ok">
 </div>
 <div style="text-align:center;height:30px;line-height:10px;">
  <#if result??><#if result==true>密码修改成功！<#else>密码修改失败！</#if></#if>
 </div>
</form> 
</div>


</@base.page >