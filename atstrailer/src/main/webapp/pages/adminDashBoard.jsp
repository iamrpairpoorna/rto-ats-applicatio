
<html>
<head>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script>
	$(document).ready(function() {
		 $("#displayUser").hide();
		$("#userAdd").hide();
		$("#home").click(function(){
			  callHomeFunction();
		
		});
	});
	
	function callHomeFuntion(){
		$("#displayUser").show();
	} 
</script>
</head>
<style>
* {
	box-sizing: border-box;
	margin=0;
	padding=0;
}

body {width =100%;height =800px;background =#fff;
	align-content: center;
}

/* Style the header */
.header {width = 100%;height = 20px;
	background-color: #666;
	padding: 5px;
	text-align: center;
	font-size: 20px;
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
				<li id="home"><a href="adminDashBoard">Home</a></li>
				<li id="addUser"><a href="addUser">Add User</a></li>
				<li id="showUser"><a href="showUsers">Show Users</a></li>
				<li id="showAgents"><a href="">Show Agents</a></li>
				<li id="showAdmins"><a href="">Show Admins</a></li>
				<li id="help"><a href="">Help</a></li>
			</ul>
		</nav>
	</div>
	<div class="content">
	
	</div>
	<div class="footer">
		<p>Web Site is designed by R.Paripoorna Chander & Company</p>
	</div>
	</div>
</body>
</html>
