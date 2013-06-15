<!DOCTYPE html>
<html lang="en">
<head>
	<title>GroovyFans - <g:layoutTitle/></title>
	<g:javascript library="jquery" plugin="jquery"/>
	<r:require modules="groovyfans"/>
	<r:layoutResources/>
</head>
<body>
<div id="page" class="container">
<header>
  <div class="navbar navbar-fixed-top">
    <div class="navbar-inner">
      <div class="container">
		<a class="btn btn-navbar" data-toggle="collapse" data-target=".nav-collapse">
          <span class="icon-bar"></span>
          <span class="icon-bar"></span>
          <span class="icon-bar"></span>
      	</a>
        <a class="brand" href="${resource(dir:'/')}">GroovyFans</a>
        <div class="nav-collapse collapse">
          <ul class="nav nav-pills">
            <li class=""><a href="${resource(dir:'/')}">Home</a></li>
            <li><a href="#">Articles</a></li>
            <li><a href="${createLink(controller:'project',action:'index')}">Projects</a></li>
			<li class="dropdown">
	          <a href="#" class="dropdown-toggle" data-toggle="dropdown">Plugins <b class="caret"></b></a>
	          <ul class="dropdown-menu">
	            <li><a href="${createLink(controller:'plugin',action:'list')}">All</a></li>
	            <li><a href="${createLink(controller:'plugin',action:'recent')}">Recent</a></li>
	            <li><a href="${createLink(controller:'plugin',action:'top',params:[max:30])}">Top 30</a></li>
	          </ul>
	        </li>
            <li><a href="#">Forum</a></li>
          </ul>
          <ul class="nav nav-pills pull-right">
            <li><a href="#"></a></li>
            <li class="divider-vertical"></li>
            <li class="dropdown">
            <a href="#" class="dropdown-toggle" data-toggle="dropdown">User <b class="caret"></b></a>
              <ul class="dropdown-menu">
                <li><a href="#">Profile</a></li>
                <li><a href="#">Signin</a></li>
                <li><a href="#">Signoff</a></li>
                <li class="divider"></li>
                <li><a href="about">About GF</a></li>
              </ul>
            </li>
          </ul>
        </div>
      </div>
    </div>
  </div>
</header>
<section id="main">
	<g:layoutBody/>
</section>
<footer>
<p>&copy 2013 groovyfans.org</p>
</footer>
</div>
<r:layoutResources/>
</body>
</html>
