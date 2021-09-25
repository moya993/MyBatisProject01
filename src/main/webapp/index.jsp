<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.*, java.text.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<head>
<title>Index</title>
</head>
<body>
	<!-- Insert.java의 @RequestMa\pping("i1"); 실행 -->
    <form action="i1" method="post" >
      <input type="text" name="name" value="test"><br>
      <input type="text" name="age" value="1234"><br>
      <input type="submit" value="전송"><br>
   </form>
</body>