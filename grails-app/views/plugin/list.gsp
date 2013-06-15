<!DOCTYPE html>
<html>
<head>
	<meta name="layout" content="main"/>
	<title>Grails Plugins | All</title>
</head>
<body>
<h1>Grails Plugins</h1>
<p>Totals: ${pluginsTotal}</p>
<table class="table table-striped">
	<thead>
	<tr>
	  <th>Name</th>
	  <th>Version</th>
	  <th>Title</th>
	  <th>Votes</th>
	</tr>
	</thead>
	<tbody>
<g:each in="${plugins}">
	<tr>
	  <td><a href="http://grails.org/plugins/${it.name}" target="_blank">${it.name}</a></td>
	  <td>${it.latestVersion}</td>
	  <td>${it.title}</td>
	  <td><g:remoteLink action="vote" id="${it.id}" onSuccess="voteup(${it.id}, data)"
    on404=""><i class="icon-thumbs-up"></i></g:remoteLink> (<span id="votes-${it.id}">${it.votes}</span>)</td>
	</tr>
</g:each>
	</tbody>
</table>
<div class="pagination">
	<g:paginate total="${pluginsTotal}" />
</div>
 <g:javascript>
    function voteup(id, data) {
		$("#votes-" + id).html(data.votes);
    }
</g:javascript>
</body>
</html>
