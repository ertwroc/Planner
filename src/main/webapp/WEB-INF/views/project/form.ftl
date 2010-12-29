<#import "/template/template.ftl" as t>
<#import "/components/composite.ftl" as c>
<@t.template>
<div class="grid_4">
	<div class="box">
		<h2>${msg.getMessage('project.new')}</h2>
		<div class="block">
			<form method="post">
				<fieldset>
					<legend>${msg.getMessage('project.new')}</legend>
					<@c.input "name" msg.getMessage('project.name') name error['name'] />
					<@c.input "desc" msg.getMessage('project.description') desc error['desc']/>
					<@c.input "owner" msg.getMessage('project.owner') owner error['owner']/>
					<@c.input "start_date" msg.getMessage('project.startdate') start_date error['start_date'] />
					<@c.input "end_date" msg.getMessage('project.enddate') end_date error['end_date'] />
				</fieldset>
				<p>
					<input type="submit" value="${msg.getMessage('project.create')}" /> 
				</p>
			</form>
		</div>
	</div>
</div>
</@t.template>