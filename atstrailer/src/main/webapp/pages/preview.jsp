
<html>
<head>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/jquery-validate/1.19.0/jquery.validate.min.js"></script>
<script>
	$(document).ready(function() {
		$("#userForm").validate();
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
	height: auto;
	background: #ccc;
	list-style-type: none;
	padding: 20px;
	text-align: left;
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


		<div class="userForm" id="userForm">
			<form action="saveVehicleDetails">
				<h3 align="center">Check the details</h3>
				<br>
				<h3>Owner Details</h3>
				<br> <label>First Name:</label><label>${o.getOwner_fname()}</label><br>
				<label>Last Name:</label><label>${o.getOwner_lname()}</label><br>
				<label>Gender:</label><label>${o.getOwner_gender()}</label><br>
				<label>DOB:</label><label>${o.getOwner_dob()}</label><br> <label>Email:</label><label>${o.getOwner_email()}</label><br>
				<label>Phone Number:</label><label>${o.getOwner_phno()}</label><br>
				<label>SSN:</label><label>${o.getOwner_ssn()}</label><br>
				<br>
				<h3>Owner Address</h3>
				<br> <label>House No:</label><label>${od.getOwner_hno()}</label><br>
				<label>Street No:</label><label>${od.getOwner_streetNo()}</label><br>
				<label>City:</label><label>${od.getOwner_city()}</label><br> <label>State:</label><label>${od.getOwner_state()}</label><br>
				<label>Zip Code:</label><label>${od.getOwner_zip()}</label><br>
				<br>
				<h3>Vehicle Details</h3>
				<br> <label>Vehicle Type:</label><label>${vd.getVehicle_type()}</label><br>
				<label>Vehicle Company:</label><label>${vd.getVehicle_company()}</label><br>
				<label>Year of Purchase:</label><label>${vd.getVehicle_year() }</label><br>
				<br>
				<br> <input type="submit" value="Previous" name=Previous_v" />
				<input type="submit" value="Proceed" name="storeVehicleDeails" />
			</form>

		</div>

		<div class="footer">
			<p>Web Site is designed by R.Paripoorna Chander & Company</p>
		</div>
	</div>
</body>
</html>
