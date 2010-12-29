<#macro foo>
Hello foo and bar!<br/>
</#macro>

<#macro template>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" >
	<head>
		<meta http-equiv="content-type" content="text/html; charset=utf-8" />
		<title>Project planner2</title>
		<link rel="stylesheet" type="text/css" href="${request.contextPath}/resources/css/reset.css" />
		<link rel="stylesheet" type="text/css" href="${request.contextPath}/resources/css/text.css" />
		<link rel="stylesheet" type="text/css" href="${request.contextPath}/resources/css/grid.css" />
		<link rel="stylesheet" type="text/css" href="${request.contextPath}/resources/css/layout.css" />
		<link rel="stylesheet" type="text/css" href="${request.contextPath}/resources/css/nav.css" />
		
		<!--[if IE 6]><link rel="stylesheet" type="text/css" href="${request.contextPath}/resources/css/ie6.css" /><![endif]-->
		<!--[if IE 7]><link rel="stylesheet" type="text/css" href="${request.contextPath}/resources/css/ie.css" /><![endif]-->
		
	</head>
	<body>
		<div class="container_16">
			<div class="grid_16"><h1 id="branding"><a>Project planner</a></h1></div>
			<div class="grid_16">
				<@menu />
			</div>
			<div class="grid_16">
					<div style="margin-bottom: 1em;" />
			</div>
			<div id="site_info" class="grid_16">
				<div class="box">
					<p>
						<div style="background-color: pink;"><#nested></div>
					</p>
				</div>
			</div>
		</div>
	</body>
</html>
</#macro>

<#macro menu>
<ul class="nav main">
	<li>
		<a>Users</a>
		<ul>
			<li><a href="${request.contextPath}/user/new">New</a></li>
			<li><a>List</a></li>
		</ul>
	</li>
	<li>
		<a>Projects</a>
		<ul>
			<li><a href="${request.contextPath}/project/new" >New</a></li>
			<li><a>List</a></li>
		</ul>
	</li>
</ul>
</#macro>
