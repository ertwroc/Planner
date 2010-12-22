<#import "/components/form.ftl" as f>

<#macro input name label value="">
<p>
	<@f.label name label />
	<@f.input name value />
</p>
</#macro>