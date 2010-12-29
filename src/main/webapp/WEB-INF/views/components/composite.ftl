<#import "/components/form.ftl" as f>

<#macro input name label value="" error="" >
<p>
	<@f.label name label />
	<@f.input name value />
	<span style="color: red">${error}</span>
</p>
</#macro>