<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>Insert title here</title>
  <style >
        div.register{
          background-color: grey;
          color:white;
          height: 300px;
	      width: 300px;
	      border: 2px solid rgb(37, 39, 41);
	      margin-top: 10px;
	      padding:10px  
        }
        
  </style>
</head>
<body>
    <div class="register">
       <h2>Registration Page</h2>
    <form action="regForm" method="post">
    Id : <input type="text" name="id" palceholder="Enter ID"/><br /><br />
    Name : <input type="text" name="name" palceholder="Enter Name"/><br /><br />
    Email : <input type="email" name="email" palceholder="Enter Email"/><br /><br />
    Password : <input type="password" name="pass" palceholder="Enter Password"/><br /><br />
    city : <select name="city">
           <option>Select city</option>
           <option>Delhi</option>
           <option>Bhopal</option>
           <option>Indore</option>
           <option>Bangalore</option>
    
           </select><br /><br />
    <input type="submit" value="register"/>
    
    </form>
    </div>

</body>
</html>