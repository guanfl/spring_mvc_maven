<#import "/spring.ftl" as spring />
<#import "/templates/mod.ftl" as base/>

<@base.loginpage >
<#assign context=rc.getContextPath()/>
<div class="login-box">
  <img src="${context}/static/images/logo_login.png" />

  <form action="${context}/j_spring_security_check" method="post">
     <#if Session.SPRING_SECURITY_LAST_EXCEPTION?? && Session.SPRING_SECURITY_LAST_EXCEPTION.message?has_content>
      <div class="error">
        ${Session.SPRING_SECURITY_LAST_EXCEPTION.message}
      </div>
    </#if>

   <div class="linput">
   		<input  name="j_username" autocomplete="off" value="请输入用户名" onfocus="if(value=='请输入用户名') {value=''}" onblur="if (value=='') {value='请输入用户名'}"  />
      	<input type="password" name="j_password" autocomplete="off" value="请输入密码" />
   </div>
    <!--
    <div class="lcheckbox">
    	<input id="_spring_security_remember_me" name="_spring_security_remember_me" type="checkbox" />
    	两周之内不必登陆
    </div>
    -->
    <input type="submit" value="确  定" />
	
  </form>
</div>
<style>
input:-webkit-autofill {  
    background:none;  
    background-image: none;  
    color: #000000;  
}  
</style>
<script>
$(document).ready(function() {
   $('#name').focusout(
    function() {
     var params;
     if (params == null)params = {};
     params["name"] = $('#name').val();
     $.get('${context}/isNameDuplicate',params,function(data){
       if(data){
        $('#nameDupliate').show();
       }else{
        $('#nameDupliate').hide();
       }
     })
   });

   $('#nickname').focusout(
    function() {
     var params;
     if (params == null)params = {};
     params["nickname"] = $('#nickname').val();
     $.get('${context}/isNickNameDuplicate',params,function(data){
       if(data){
         $('#nicknameDupliate').show();
        }else{
         $('#nicknameDupliate').hide();
        }
     })
   });
});



</script>

</@base.loginpage >