<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	function delCustomer(id) {
		location.href = "${pageContext.request.contextPath }/customer/delCustomer?delCustomerId="+id;
	}

</script>

</head>
<body>
		<table border="1px" align="center">
			<tr colspan="4" align="center">
				<a href="${pageContext.request.contextPath }/jsp/addCustomer.jsp">add Customer</a>
			</tr>
			<tr align="center">
				<td>序号</td>
				<td>客户</td>
				<td>客户名称</td>
				<td>联系电话</td>		
				<td>操作</td>
			</tr>
		<s:iterator value="cs" var="c" status="vs">
			<tr align="center">
				<td> <s:property value="#vs.index+1"/> </td>
				<td> <img src='<s:property value='#c.cusImgsrc'/>'> </td>
				<td> <s:property value="#c.cusName"/> </td>
				<td> <s:property value="#c.cusPhone"/> </td>		
				<td>
					<a href="javascript:void(0)" onclick="delCustomer(<s:property value='#c.id'/>);">删除客户</a>
					<a href="javascript:void(0)" onclick="findOrders(<s:property value='#c.id'/>);">查询订单</a>
				</td>
			</tr>
		
			<table>
				<tr>
					<td> </td>
				</tr>
			
			</table>
		</s:iterator>
		
		</table>
</body>
</html>