 <#assign context=rc.getContextPath()/>
 <a class="add" href="javascript:showaddform();" >新  增</a>
 <table cellspacing="0" cellpadding="0">
  <tr>
  	<th>用户名</th>
  	<th>状态</th>
  	<th>级别</th>
  	<th>登录时间</th>
  	<th>创建时间</th>
  	<th>操作</th>
  </tr>
<#list userlist as u>
  <tr id="${u.userid}">
   <td>${u.loginName} </td>
   <td><#if u.enable==1>可用<#else>不可用</#if></td>
   <td>${u.role}</td>
   <td><#if u.loginDate??>${u.loginDate?string("yyyy-MM-dd HH:mm:ss")}</#if></td>
   <td><#if u.createDate??>${u.createDate?string("yyyy-MM-dd HH:mm:ss")}</#if></td>
   <td>
     <#if u.enable==1>
       <a href="javascript:enableUser(${u.userid},0);" class="paused">关闭</a>
     <#else>
       <a href="javascript:enableUser(${u.userid},1);" class="start">激活</a>
     </#if>
     <!--
     <#if u.role=='ROLE_ADMIN'>
       <a href="javascript:updateRole(${u.userid},'ROLE_USER');" class="down">降级</a>
     <#else>
       <a href="javascript:updateRole(${u.userid},'ROLE_ADMIN');" class="up">升级</a>
     </#if>
     -->
	   <a href="javascript:removeUserById(${u.userid});" class="del_user">删除</a>
    </td>
  </tr> 
</#list>
 </tabel> 
