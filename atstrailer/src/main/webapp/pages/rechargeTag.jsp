<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script>
	$(document).ready(function() {
		
		
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
	padding-left: 30px;
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

/* .home{
padding-left:50px;
}
 */
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

	</div>

	<div class="menu">
		<nav>
			<ul>
				<li id="home"><a href="tagAccountSummary">Tag Account
						Summary</a></li>
				<li id="addUser"><a href="purchaseTag">Purchase Tag</a></li>
				<li id="help"><a href="">Contact Us</a></li>
			</ul>
		</nav>
	</div>
	<div class="content">
	<form action="rechargeTagId">
		<h3 align="left">Welcome Mr/Mrs.${name}</h3>
		<br>
		<table border="2" width="70%" cellpadding="2" class="viewTable">
			<tr>
				<th>Tag Id</th>
				<td>${tagId}</td>	
			</tr>
			<tr>
				<th>Current Balance</th>
				<td>${tagBalance}</td>
			</tr>
			<tr>
				<th>Amount</th>
				<td><input type="text" value="0" name="amount"/></td>
			</tr>
			<tr ><td colspan=2><input type="submit" value="Recharge"/></td>
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
