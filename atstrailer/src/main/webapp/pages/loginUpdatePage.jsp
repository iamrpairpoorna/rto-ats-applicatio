
<html>
<head>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/jquery-validate/1.19.0/jquery.validate.min.js"></script>
<script>
	$(document).ready(function() {
		 $("#confrmPass").keyup(function(){
	         if ($("#newPass").val() != $("#confrmPass").val()) {
	             $("#msg").html("Password do not match").css("color","red");
	         }else{
	             $("#msg").html("Password matched").css("color","green");
	        }
		});
		
	});
</script>
</head>
<style>
* {
	box-sizing: border-box;
	margin
	=0;
	padding
	=0;
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
body {width =100%;height =800px;background =#fff;
	align-content: center;
}


/* Style the header */
.header {width = 100%;height = 30px;
	background-color: #666;
	padding: 30px;
	text-align: center;
	font-size: 25px;
	color: white;
}

/* Create two columns/boxes that floats next to each other */

/* Style the list inside the menu */
.userForm {
	float: left;
	width: 100%;
	height: 400px;
	background: #ccc;
	list-style-type: none;
	padding: 20px;
	text-align: center;
	border: 1px solid white;
}

.logTable {
	margin-top: 50px;
}

.footer {
	margin-top: 3px; width =100%; height =20px;
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


		<div class="userForm">
			<form action="updateLoginDetails" id="resetPassword">
				<table class="logTable" align="center" border="2">
					<tr>
						<td colspan="2" align="center">Update Login Details Form</td>
					</tr>
					<tr>
						<td>User Name:</td>
						<td><input type="email" name="userName" required/>
						</td>
					</tr>
					<tr>
						<td>Temporary Password:</td>
						<td><input type="password" name="tempPass" id="tempPass" required /></td>
					</tr>
					<tr>
						<td>New Password:</td>
						<td><input type="password" name="newPass" id="newPass" required/></td>
					</tr>
						<tr>
						<td>Confirm Password:</td>
						<td><input type="password" name="confirmPass" id="confrmPass" required/></td>
					</tr>
					<tr>
						<td  colspan=2 align="center"><input type="submit"value="Update Password"/></td>
					</tr>
				</table>
			</form>
			<p id="msg"></p>
		</div>

		<div class="footer">
			<p>Web Site is designed by R.Paripoorna Chander & Company</p>
		</div>
	</div>
</body>
</html>
