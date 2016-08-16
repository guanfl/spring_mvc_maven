 <#import "/spring.ftl" as spring />
 <#import "/templates/mod.ftl" as w/>
 <#assign context=rc.getContextPath()/>
 
 <#if pages??> 
 <table cellspacing="0" cellpadding="0">
  <tr>
  	<th>系统名</th>
  	<th>级别</th>
  	<th>日志时间</th>
  	<th>内容</th>
  	<th>是否处理</th>
  </tr>
  <#list pages.list as log>
  <tr id="${log.logid}">
   <td>${log.system} </td>
   <td>${log.logLevel}</td>
   <td><#if log.logTime??>${log.logTime?string("yyyy-MM-dd HH:mm:ss")}</#if></td>
   <td>${log.logContent}</td>
   <td>${log.handle}</td>
  </tr>
  </#list>
  <table>
  <tr>
   <td align="center" valign="middle">
     <@w.ajaxPageBar listPage=pages pageMethod="mini.search.list" params="{beginDate:'${beginDate}',endDate:'${endDate}',system:'${system}',logLevel:'${logLevel}'}"/>
   </td>
  </tr>
  </table> 
 </#if> 
