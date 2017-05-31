<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="${pageContext.request.contextPath }/customer/addCutomer" method="post" enctype="multipart/form-data">
		name:<input type="text" name="cusName"><br/>
		phone:<input type="text" name="cusPhone"><br/>
		<input type="file" name="cusImg"><br/>
		<input type="submit" value="添加">
	</form>
</body>
</html>