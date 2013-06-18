<!DOCTYPE html>
<head>
  <meta name="layout" content="main" />
  <title>Login</title>
</head>
<body>
<g:if test="${flash.message}">
  <div class="message">${flash.message}</div>
</g:if>
<g:form action="signIn" class="form-horizontal">
  <input type="hidden" name="targetUri" value="${targetUri}" />
  <div class="control-group">
    <label class="control-label" for="username">Username</label>
    <div class="controls">
      <input type="text" name="username" value="${username}" id="username" placeholder="Username">
    </div>
  </div>
  <div class="control-group">
    <label class="control-label" for="password">Password</label>
    <div class="controls">
      <input type="password" name="password" value="" id="password" placeholder="Password">
    </div>
  </div>
  <div class="control-group">
    <div class="controls">
      <label class="checkbox">
        <input type="checkbox"> Remember me
      </label>
      <button type="submit" class="btn">Sign in</button>
    </div>
  </div>
</g:form>

</body>
</html>
