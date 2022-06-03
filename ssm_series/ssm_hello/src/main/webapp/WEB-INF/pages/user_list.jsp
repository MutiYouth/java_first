<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8"%>
<html>
<head>
    <title>SSM框架整合测试</title>
</head>
<body>
${userList.size()} <br/>
${userList[1].username} <br/>
----------------------------- <br/>


<table width="50%" border="0" cellspacing="0">
    <thead>
    <tr>
        <th>行号</th>
        <th>UID</th>
        <th>User Name</th>
    </tr>
    </thead>

    <tbody>
    <c:forEach var="user_one" items="${userList}" varStatus="status">
        <tr>
            <td width="10%">${status.count}</td>
            <td width="20%">${user_one.uid }</td>
            <td width="20%">${user_one.username }</td>
            <td width="30%">
                <!-- 减少 -->
                <input type="button" value='-' style="width:20px" onclick="changeAge1('${user_one.uid-1}','${user_one.uid}')">

                <!-- 商品数量显示 -->
                <input name="text" type="text" value="${user_one.uid}" style="width:40px;text-align:center"/>

                <!-- 增加商品数量 -->
                <input type="button" value='+' style="width:20px" onclick="changeAge2('${user_one.uid+1}','${user_one.uid}')">
            </td>
            <td width="20%">
                <!-- 删除商品 -->
                <a href="${pageContext.request.contextPath}/del_user?id=${user_one.uid}"
                   style="color:#FF0000; font-weight:bold" onclick="javascript:return userDel()">X</a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>

<c:set value="${userList.size()}" var="total count"/>

</body>
</html>