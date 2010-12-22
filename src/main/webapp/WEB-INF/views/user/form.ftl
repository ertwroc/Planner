<#import "/template/template.ftl" as t>
<#import "/components/composite.ftl" as c>
<@t.template>
<div class="grid_4">
	<div class="box">
		<h2>Formularz</h2>
		<div class="block">
			<form method="post">
				<fieldset>
					<legend>Dane logowania</legend>
					<@c.input "login" msg.getMessage('user.login') "" />
					<@c.input "password" msg.getMessage('user.password') "" />
					<@c.input "retypepassword" msg.getMessage('user.retype') "" />
					<@c.input "email" msg.getMessage('user.email') "" />
				</fieldset>
				<fieldset>
					<legend>Dane osobowe</legend>
					<@c.input "firstName" msg.getMessage('user.firstname') "" />
					<@c.input "lastName" msg.getMessage('user.lastname') "" />
				</fieldset>
				<p>
					<input type="submit" value="${msg.getMessage('user.create')}" /> 
				</p>
			</form>
		</div>
	</div>
</div>
</@t.template>
