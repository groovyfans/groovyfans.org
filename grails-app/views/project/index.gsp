<!DOCTYPE html>
<html>
<head>
	<meta name="layout" content="main"/>
	<title>Projects</title>
</head>
<body>
	<div class="projects">
		<div data-repo="groovyfans/groovyfans.org" class="github-box-wrap"></div>
		<div data-repo="groovyfans/grails-plugins-manual" class="github-box-wrap"></div>
		<div data-repo="groovyfans/kello" class="github-box-wrap"></div>
		<div data-repo="groovyfans/groller" class="github-box-wrap"></div>
		<div data-repo="groovyfans/grails-propertyset" class="github-box-wrap"></div>
		<div data-repo="groovyfans/grails-i18n" class="github-box-wrap"></div>
	</div>	

	<script src="${resource(dir:'/js',file:'jquery.github.min.js')}"></script>
	<script>
		$("[data-repo]").github();
	</script>
</body>
</html>
