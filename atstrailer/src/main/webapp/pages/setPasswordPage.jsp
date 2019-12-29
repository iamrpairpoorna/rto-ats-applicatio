
<html>
<head>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/jquery-validate/1.19.0/jquery.validate.min.js"></script>
<script>
$(document).ready(function(){
    $("#confirmPassword").keyup(function(){
         if ($("#userPassword").val() != $("#confirmPassword").val()) {
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

body {width =100%;height =800px;background =#fff;
	align-content: center;
}

font-family


:

 

Arial
,
Helvetica
,
sans-serif


;
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
			<form action="setNewPassword">
				<table class="logTable" align="center" border="2">
					<tr>
						<td colspan="2" align="center">Enter New Password</td>
					</tr>
					<tr>
						<td>User Name</td>
						<td><Label>${userName}</Label></td>
					</tr>
					<tr>
						<td>New Password:</td>
						<td><input type="password" name="userPassword"id="userPassword" required/></td>
					</tr>
					<tr>
						<td>Confirm Password:</td>
						<td><input type="password" name="confirmPassword"  id="confirmPassword"required /></td>
					</tr>
					
					<td colspan=2 align="center"><input type="submit"
						value="Update Password" /></td>
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
