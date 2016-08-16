  <#import "/templates/mod.ftl" as w/>
  <@w.process title="${system}"/>
  
  <table cellspacing="0" cellpadding="0" style="width:70%">
  <tr>
  	<th>进程名称</th>
  	<th>所属系统</th>
  	<th>描述</th>
  	<th>操作</th>
  </tr>
  <#list processes as p>
  <tr>
   <td>${p.processname}</td>
   <td>${p.system}</td>
   <td>${p.describe}</td>
   <td>报警风格：
       <select name="alertpattern" id="alertpattern_${p.id}" style="vertical-align:middle;">
          <option VALUE="0" <#if 0==p.alertpattern>selected</#if>>不报警</option>
          <option VALUE="1" <#if 1==p.alertpattern>selected</#if>>报警不出声</option>
          <option VALUE="2" <#if 2==p.alertpattern>selected</#if>>报警出声</option>         
       </select>
       自动重启：
       <select name="startpattern" id="startpattern_${p.id}" style="vertical-align:middle;">
          <option VALUE="0" <#if 0==p.startpattern>selected</#if>>否</option>
          <option VALUE="1" <#if 1==p.startpattern>selected</#if>>是</option>         
       </select>
       <input class="button_g" onclick="changeProcessConfig('${p.id}','${p.processname}');" type="button" value="修改" name="button" style="vertical-align:middle;" />
   </td> 
  </tr>
  </#list>
  </table>
