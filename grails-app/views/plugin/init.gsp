<!DOCTYPE html>
<html>
<head>
	<meta name="layout" content="main"/>
	<title>Welcome to Grails</title>
</head>
<body>
<table class="table table-striped">
	<thead>
	<tr>
	  <th>Name</th>
	  <th>Version</th>
	  <th>Title</th>
	</tr>
	</thead>
	<tbody>
<g:each in="${plugins}">
	<tr>
	  <td>${it.name}</td>
	  <td>${it.latestVersion}</td>
	  <td>${it.title}</td>
	</tr>
</g:each>
	</tbody>
</table>
</body>
</html>
