
<html>
<head>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/jquery-validate/1.19.0/jquery.validate.min.js"></script>
<script>
	$(document).ready(function() {
		$("#loginForm").validate();
	});
</script>
<script>

</script>
</head>
<style>
* {
	box-sizing: border-box;
	margin=0;
	padding=0;
}

.errorMsg{
font-weight: 300;
font-size: 20px;
	color: red;
}

input.error, textarea.error {
	border: 1px solid red;
	font-weight: 300;
	color: red;
	}
.error{
text-align: center;
	font-size: 15px;
	color: red;
}

body {
	width=100%;
	height=800px;
	background=#fff;
	align-content: center;
}
	font-family: Arial, Helvetica, sans-serif;
}

/* Style the header */
.header {
	width = 100%;
	height = 30px; 
	background-color: #666;
	padding: 30px;
	text-align: center;
	font-size: 25px;
	color: white;
}

/* Create two columns/boxes that floats next to each other */
.slides {
	float: left;
	width: 60%;
	height: 300px; /* only for demonstration, should be removed */
	background: #ccc;
	padding: 20px;
}

/* Style the list inside the menu */
.loginside {
	float:left;
	width: 40%;
	height:300px;
	background: #ccc;
	list-style-type: none;
	padding: 20px;
	text-align: center;
	border: 1px solid white;
}

.logTable{
margin-top:50px;
}

.href-tag{
margin-top: 70px;
}

.ff{

text-align: left;
}

.su{
text-align: right;
}


.footer {
	margin-top: 3px;
	width=100%;
	height=20px;
	background-color: #666;
	padding: 10px;
	text-align: center;
	color: white;
}
}
</style>
</head>
<body>
	<div>
		<div class="header">
			<h2 align="center">Automatic Toll Collection System</h2>
		</div>

		<div class="slides">
				<img src="Etoll-logo-Sanral.jpg">
		</div>

		<div class="loginside">
				<form action="checkDetails" id="loginForm">
					<table  class="logTable" align="center">
						<tr>
							<td colspan="2" align="center" >Login Here</td>
						</tr>
						<tr>
							<td>User Name</td>
							<td><input type="text" name="userName" id="user_name" required /></td>
						</tr>
						<tr>
							<td>Password</td>
							<td><input type="password" name="password" id="user_name" required /></td>
						</tr>
						<tr ><td colspan="2" align="center"><input type="submit" value="SignIn"/></td></tr>
					</table>
				</form>
				<p class="errorMsg">${errorMsg}</p>
				<div class="href-tag">
					<p class="ff"><a href="forgotForm">Forgot Password</a></p>
					<p class="su"><a href="registerPerson">SignUp Now??</a></p>
				</div>
			</div>
		
		<div class="footer">
			<p>Web Site is designed by R.Paripoorna Chander & Company</p>	
		</div>
	</div>
</body>
</html>
