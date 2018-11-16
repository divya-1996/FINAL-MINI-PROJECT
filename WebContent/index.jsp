<%@ page errorPage = "error.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="bootstrap.min.css"/>
<style type="text/css">
.inputform{float:left;
width:400px;border:5px solid black;border-radius:10px;padding:10px;
}
.inputform table tr td input,textarea,select{width:200px;}
#gender1,#gender2{width:10px;}
#submit{margin-left:100px;width:100px;}
#reset{width:100px;}
.design{background-color:red;color:white;padding-left:100px;}
</style>
</head>
<body>

<!-- header -->
<h2>COMPANY MAIL SYSTEM</h2>
<h3 style="background-color:red;color:red;">c</h3>
<!-- body -->

<div class="inputform">
<h2 class="design">Registration Form</h2>
<form action="RegistrationServlet" method="post">
<table>
<tr><td>Name:</td><td><input type="text" name="usrname" placeholder="name" required></td></tr>
<tr><td>Email:</td><td><input type="text" name="email" placeholder="email" required/></td></tr>
<tr><td>Password:</td><td><input type="password" id="password" name="password" placeholder="password" pattern="(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{8,}" title="my format" onkeyup= "check()" required/></td></tr>
<tr><td id="message"></td> </tr>
<tr><td> confirm-Password:</td><td><input type="password" id=" confirm-password"  name="confirm-password" onkeyup= "check()" required/></td></tr>
<tr><td>Gender:</td><td><input id="gender1" type="radio" name="gender" value="male"/>Male 
<input type="radio" id="gender2" name="gender" value="female"/>Female
</td></tr>
<tr><td>AddressLine:</td><td><textarea name="addressLine" rows="5" cols="15" required></textarea></td></tr>
<tr><td>city:</td><td><select name="city">
<option>Select-city:</option>
<option>Mumbai</option>
<option>baghdad</option>
<option>banagalore</option>
<option>Other</option>
</select></td></tr>
<tr><td>State:</td><td><select name="state">
<option>Select-State:</option>
<option>Maharashtra</option>
<option>Gujarat</option>
<option>Madhyapradesh</option>
<option>Kashmir</option>
<option>Chennai</option>
<option>Hyderabad</option>
<option>Other</option>
</select></td></tr>
<tr><td>Country:</td><td><select name="country">
<option>Select-Country:</option>
<option>India</option>
<option>Pakistan</option>
<option>China</option>
<option>Bhutan</option>
<option>USA</option>
<option>France</option>
<option>Other</option>
</select></td></tr>
<tr><td>Contact:</td><td><input type="text" name="contact" pattern="()7|8|9)\d{9}" title="phone no should start with 6 or 7 or 9" required/></td></tr>
<tr><td colspan="2"> <button type="submit" class="btn btn-primary">Register</button>
</td></tr>
</table>
</form>
</div>

<div class="inputform" style="float:right;">
<h2 class="design">Login Form</h2>
<form action="LoginServlet" method="post">
<table>
<tr><td>Email:</td><td><input type="email" name="email" required/></td></tr>
<tr><td>Password:</td><td><input type="password" name="password" required/></td></tr>
<tr><td colspan="2">  <button type="submit" class="btn btn-primary">Login</button>
</td></tr>
</table>
</form>
</div>

<script>
function check(){
if(document.getElementById('password').value == 
document.getElementById('confirm-password').value){
document.getElementById('message').style.color = 'green';
document.getElementById('message').innerHTML = 'matching';
} 
else{
document.getElementById('message').style.color = 'red';
document.getElementById('message').innerHTML = ' not matching';
}
}
</script>

</body>
</html>