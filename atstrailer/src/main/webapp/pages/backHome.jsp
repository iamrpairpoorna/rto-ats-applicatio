
<html>
<head>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/jquery-validate/1.19.0/jquery.validate.min.js"></script>
<script>
$(document)
.ready(
		function() {
		
			$("#register_form")
					.validate(
							{
								rules : {
									firstName : {
										required : true,
										minlength : 5
									},
									lastName : {
										required : true,
									},
									userGender : {
										required : true
									},
									userDob : {
										required : true,
										date : true
									},

									userEmail : {
										required : true,
										email : true
									},
									userPhone : {
										required : true,
										minlength:5
										number : true
									},
									messages : {
										userFName : {
											minlength : "first name should be atleast 3 characters"
										},
										owner_lname : {
											minlenght : "middle name should be atleast 3 characters"
										},
										owner_phno : {
											number : "please enter phone number as a numerical"
										}
									}
								}
							});
		});
</script>
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
font-size: 25px;
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
			<form action="saveUserDetails" id="register_form">
				<table class="logTable" align="center" border="2">
					<tr>
						<td colspan="2" align="center">Create User Form</td>
					</tr>
					<tr>
						<td>First Name:</td>
						<td><input type="text" name="firstName" value="${person.firstName}" required /> </td>

					</tr>
					<tr>
						<td>Last Name:</td>
						<td><input type="text" name="lastName" value="${person.lastName}" required /> </td>

					</tr>
					<tr>
						<td>Email:</td>
						<td><input type="email" name="userEmail" value="" required /> </td>

					</tr>
					<tr>
						<td>Phone Number:</td>
						<td><input type="text" name="userPhone" value="${person.userPhone}" required /></td>

					</tr>
					<tr>
						<td>DOB:</td>
						<td><input type="date" name="userDob"
							placeholder="dd/mm/yyyy" value="{person.userDob}" required /> </td>

					</tr>
					<tr>
						<td>Gender</td>
						<td><input type="radio" name="userGender" value="male"
							required>Male <input type="radio" name="userGender"
							value="female" required>Female <input type="radio"
							name="userGender" value="other" required>Others</td>

					</tr>
					<tr>
						<td colspan="2" align="center"><input type="submit"
							value="Sign Up" /></td>
					</tr>
				</table>
			</form>
			<p class="errorMsg">${errorMsg}</p>

		</div>

		<div class="footer">
			<p>Web Site is designed by R.Paripoorna Chander & Company</p>
		</div>
	</div>
</body>
</html>
