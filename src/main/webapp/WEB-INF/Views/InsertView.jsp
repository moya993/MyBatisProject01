<%@ page import="Pack.Insert"%> 
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>InsertView</title>
</head>
<body>
  	<%
		// request 파라메타는 값을 받을수있지만 성립이 안된다
		String name = (String)request.getAttribute("name");
		int age = (int)request.getAttribute("age");
		int r = (int)request.getAttribute("r");
		
		if (r == 1){
			System.out.println("등록완료했습니다.");
			%>
			<h1>등록완료했습니다.</h1>
			<%
			
		}else{
			System.out.println("등록실패했습니다.");
		}
	%>
	
</body>
</html>