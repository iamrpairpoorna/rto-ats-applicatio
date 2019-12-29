
<html>
<head>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/jquery-validate/1.19.0/jquery.validate.min.js"></script>
<script>
	$(function() {
		$("#userLock").hide();
		$("#fname_span").hide();
		$("#lname_span").hide();
		$("#email_span").hide();
		$("#phone_span").hide();
		$("#dob_span").hide();
		$("#gender_span").hide();

		var error_fname = false;
		var error_lname = false;
		var error_email = false;
		var error_phone = false;
		var error_dob = false;
		var error_gender = false;

		$("#firstName").focusout(function(){
			check_firstName();
		});	
		$("#lastName").focusout(function(){
			check_lastName();
		});	
		$("#userEmail").focusout(function(){
			check_userEmail();
		});	
		$("#userPhone).focusout(function(){
			check_userPhone();
		});	
		$("#userDob").focusout(function(){
			check_userDob();
		});	
		$("#userGender").focusout(function(){
			check_userGender();
		});	
		
		function check_firstName(){
			val len =$("firstName").val().length;
			if(len<5||len>20){
				${"fname_span"}.html("First Name must be above 5 character");
				$("#fname_span").show();
				error_fname=true;
			}
			else
				$("#fname_span").hide();
		  }
		
		function check_lastName(){
			val len =$("lastName").val().length;
			if(len==0){
				${"lname_span"}.html("Last Name is required");
				$("#lname_span").show();
				error_lname=true;
			}
			else
				$("#lname_span").hide();
		  }
		function check_userEmail(){
			val len =$("userEmail").val().length;
			if(len==0){
				${"email_span"}.html("Last Name is required");
				$("#email_span").show();
				error_email=true;
			}
			else
				$("#email_span").hide();
		  }
		
		function check_userPhone(){
			val len =$("userPhone").val().length;
			if(len<10){
				${"phone_span"}.html("Phone no. must be min 10 long");
				$("#phone_span").show();
				error_phone=true;
			}
			else
				$("#phone_span").hide();
		  }

		function check_userBob(){
			val len =$("userDob").val().length;
			if(len<10){
				${"dob_span"}.html("Phone no. must be min 10 long");
				$("#dob_span").show();
				error_dob=true;
			}
			else
				$("#dob_span").hide();
		  }
		
	});function check_userGender(){
		val len =$("userGender").val().length;
		if(len==0){
			${"gender_span"}.html("Phone no. must be min 10 long");
			$("#gender_span").show();
			error_gender=true;
		}
		else
			$("#gender_span").hide();
	  }

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

input.error, textarea.error {
	border: 1px solid red;
	font-weight: 300;
	color: red;
}

.errorData {
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
						<td><input type="text" name="firstName" id="firstName" required
							 /> <span class=".errorData" id="fname_span">${error_fname}</span></td>

					</tr>
					<tr>
						<td>Last Name:</td>
						<td><input type="text" name="lastName" id="lastName" required/>
							<span class=".errorData" id="lname_span">${error_lname}</span></td>

					</tr>
					<tr>
						<td>Email:</td>
						<td><input type="email" name="userEmail" id="userEmail"
							required /> <span class=".errorData" id="email_span">${error_email}</span></td>

					</tr>
					<tr>
						<td>Phone Number:</td>
						<td><input type="text" name="userPhone" id="userPhone"
							required /> <span class=".errorData" id="phone_span">${error_phone}</span></td>

					</tr>
					<tr>
						<td>DOB:</td>
						<td><input type="date" name="userDob"
							placeholder="dd/mm/yyyy" id="userDob"  required/> <span
							class=".errorData" id="dob_span">${error_dob}</span></td>

					</tr>
					<tr>
						<td>Gender</td>
						<td><input type="radio" name="userGender" value="male"
							required id="userGender required">Male <input type="radio"
							name="userGender" value="female" id="userGender" >Female
							<input type="radio" name="userGender" value="other"
							id="userGender" required>Others <span class=".errorData"
							id="gender_span">${error_gender}</span></td>

					</tr>
					<tr hidden="true">
						<td>User Role:</td>
						<td><input type="text" name="userRole" id="userRole" value="user"
							required /> <span class=".errorData" id="phone_span">${error_phone}</span></td>

					</tr>
					<tr hidden="true">
						<td>User Lock:</td>
						<td><input type="text" name="userlock" id="userLock" value="lock"
							required /> <span class=".errorData" id="phone_span">${error_phone}</span></td>

					</tr>
					<tr>
						<td colspan="2" align="center"><input type="submit"
							value="Sign Up" /></td>
					</tr>
				</table>
			</form>

		</div>

		<div class="footer">
			<p>Web Site is designed by R.Paripoorna Chander & Company</p>
		</div>
	</div>
</body>
</html>
