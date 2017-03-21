<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>


<html>
<head>
<script type="text/javascript">
function validateLogin() {

  var userName = document.getElementById("txtUserName");
  var password = document.getElementById("txtPassword");
  var loginErrorMessage = "UserName/Password is wrong or not provide.";
  var valid = true;
  if ( (userName.value.trim().length <= 0 || password.value.trim().length <= 0) ) {
    valid = false;
    document.getElementById('lblErrorMessage').innerHTML = loginErrorMessage;

  } else {
    document.getElementById('lblErrorMessage').innerHTML = "";
  }
  return valid;
}
;
</script>
</head>
<body>

    
	

</body>
</html>


