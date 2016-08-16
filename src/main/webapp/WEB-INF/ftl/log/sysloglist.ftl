 <#import "/spring.ftl" as spring />
 <#import "/templates/mod.ftl" as w/>
 <#assign context=rc.getContextPath()/>
 
 <#if pages??> 
 <table cellspacing="0" cellpadding="0">
  <tr>
  	<th>操作人</th>
  	<th>级别</th>
  	<th>操作时间</th>
  	<th>内容</th>
  	<th>是否成功</th>
  </tr>
  <#list pages.list as log>
  <tr id="${log.logid}">
   <td>${log.username} </td>
   <td>${log.loglevel}</td>
   <td><#if log.logtime??>${log.logtime?string("yyyy-MM-dd HH:mm:ss")}</#if></td>
   <td>${log.logcontent}</td>
   <td>${log.success}</td>
  </tr>
  </#list>
  <table>
  <tr>
   <td align="center" valign="middle">
     <@w.ajaxPageBar listPage=pages pageMethod="mini.search.list" params="{beginDate:'${beginDate}',endDate:'${endDate}'}"/>
   </td>
  </tr>
  </table> 
 </#if> 
