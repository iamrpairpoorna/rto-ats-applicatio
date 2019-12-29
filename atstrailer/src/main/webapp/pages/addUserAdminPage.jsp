
<html>
<head>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script>
	$(document).ready(function() {
		
		$("#displayUser").hide();
		$("#userAdd").hide();
		$("#home").click(function() {
			callHomeFunction();

		});
	});

	function callHomeFuntion() {
		$("#displayUser").show();
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

body {width =100%;height =800px;background =#fff;
	align-content: center;
}

/* Style the header */
.header {width = 100%;height = 20px;
	background-color: #666;
	padding: 5px;
	text-align: center;
	font-size: 10px;
	color: white;
}

.menu {width = 100%;height = 5px;
	background-color: white;
	padding: 0px;
	color: white;
}

.adminText {
	text-align: right;
	font-size: 15px;
	color: red;
}

ul {
	
}

ul li {
	display: inline-block; font-size =15px;
	padding-right: 30px;
}

ul li a {
	
}
/* Create two columns/boxes that floats next to each other */

/* Style the list inside the menu */
.content {
	float: left;
	width: 100%;
	height: 350px;
	background: #ccc;
	list-style-type: none;
	padding: 20px;
	text-align: center;
	border: 1px solid white;
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
	<div class="header">
		<h2 align="center">Automatic Toll Collection System</h2>
		<p class="adminText">Admin</p>
	</div>

	<div class="menu">
		<nav>
			<ul>
				<li id="home"><a href="">Home</a></li>
				<li id="addUser"><a href="addUser">Add User</a></li>
				<li id="showUser"><a href="">Show Users</a></li>
				<li id="showAgents"><a href="">Show Agents</a></li>
				<li id="showAdmins"><a href="">Show Admins</a></li>
				<li id="help"><a href="">Help</a></li>
			</ul>
		</nav>
	</div>
	<div class="content">
		<form action="saveUserByAdmin" id="register_form">
			<table class="logTable" align="center" border="2">
				<tr>
					<td colspan="2" align="center">Add User</td>
				</tr>
				<tr>
					<td>First Name:</td>
					<td><input type="text" name="firstName" id="firstName"
						required /> <span class=".errorData" id="fname_span">${error_fname}</span></td>

				</tr>
				<tr>
					<td>Last Name:</td>
					<td><input type="text" name="lastName" id="lastName" required />
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
					<td><input type="date" name="userDob" placeholder="dd/mm/yyyy"
						id="userDob" required /> <span class=".errorData" id="dob_span">${error_dob}</span></td>

				</tr>
				<tr>
					<td>Gender</td>
					<td><input type="radio" name="userGender" value="male"
						required id="userGender required">Male <input type="radio"
						name="userGender" value="female" id="userGender" required>Female <input
						type="radio" name="userGender" value="other" id="userGender"
						required>Others <span class=".errorData" id="gender_span">${error_gender}</span></td>

				</tr>
				<tr>
						<td>Role</td>
						<td><select name="userRole" required>
								<option value="user">User</option>
								<option value="agent">Agent</option>
								<option value="admin">Admin</option>
						</select></td>
					</tr>
				<tr>
					<td colspan="2" align="center"><input type="submit"
						value="Add User" /></td>
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
