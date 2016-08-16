
<#macro page title="">
 <#include "/templates/header.ftl" />
   <#nested>
 <#include "/templates/footer.ftl" />
</#macro>

<#macro loginpage title="">
 <#include "/templates/loginheader.ftl" />
   <#nested>
</#macro>



<#macro layer title=""  width=500 height=400>
 <div id="w" class="easyui-window" closed="true" title="${title}" iconCls="icon-save" style="width:${width}px;height:${height}px;padding:5px;background: #fafafa;">
  <div class="easyui-layout" fit="true">
    <div id="data" region="center" border="false">

    </div>
  </div>
  </div>
</#macro>


<#macro process title="">
  <#if title=='master'>
    <h3>
		<span><a class="current">主机系统</a></span>
    	<span><a href="javascript:goto('admin')">后台系统</a></span>
    	<span><a href="javascript:goto('lb')">lb系统</a></span>
	</h3>
  </#if>
  <#if title=='admin'>
    <h3>
		<span><a href="javascript:goto('master')">主机系统</a></span>
    	<span><a class="current">后台系统</a></span>
    	<span><a href="javascript:goto('lb')">lb系统</a></span>
	</h3>
  </#if>
  <#if title=='lb'>
    <h3>
		<span><a href="javascript:goto('master')">主机系统</a></span>
    	<span><a href="javascript:goto('admin')">后台系统</a></span>
    	<span><a class="current">lb系统</a></span>
	</h3>
  </#if>
</#macro>



<#macro ajaxPageBar listPage pageMethod maxPages=10 params="{}">
  <#if listPage.pages gt 1>
      <#if (listPage.currPage>1)>
        <a href="#" onclick="efn.util.ajaxPage(${params}, ${listPage.currPage-1}, ${pageMethod}); return false;">上一页</a>
      <#else>
        上一页
      </#if>
      <#if (listPage.currPage > maxPages/2)>
        <#local start=(listPage.currPage-maxPages/2)/>
      <#else>
        <#local start=1/>
      </#if>
      <#local end=(start+maxPages-1)/>
      <#if (end > listPage.pages)>
        <#local end=listPage.pages/>
      </#if>
      <#if (start < listPage.currPage)>
        <#list start..(listPage.currPage-1) as i>
          [<a href="#" onclick="efn.util.ajaxPage(${params}, ${i}, ${pageMethod}); return false;">${i}</a>]
        </#list>
      </#if>
      [${listPage.currPage}]
      <#if (end > listPage.currPage)>
        <#list (listPage.currPage+1)..end as i>
          [<a href="#" onclick="efn.util.ajaxPage(${params}, ${i}, ${pageMethod}); return false;">${i}</a>]
        </#list>
      </#if>
    <#if (listPage.currPage < listPage.pages)>
      <a href="#" onclick="efn.util.ajaxPage(${params}, ${listPage.currPage+1}, ${pageMethod}); return false;">下一页</a>
    <#else>
       下一页
    </#if>
  </#if>
</#macro>
