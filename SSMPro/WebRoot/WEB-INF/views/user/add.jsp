<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
<link href="<c:url value="/css/main.css" />" type="text/css" rel="stylesheet" />
<script language="javascript" type="text/javascript" 
    src="<c:url value="/my97/WdatePicker.js" />"></script>
<title>新增用户</title>
</head>
<body>
    <div class="main">
        <h2 class="title"><span>新增用户</span></h2>
        <form:form action="addSave" method="post" modelAttribute="user">
        <fieldset>
            <legend>用户</legend>
            <table cellpadding="5" cellspacing="8"> 
                <tr>
                    <td><label for="user_name">姓名：</label></td>
                    <td><form:input path="user_name" size="40"/></td>
                    <td><form:errors path="user_name" cssClass="error"></form:errors></td>
                </tr>
                <tr>
                    <td><label for="user_sex">性别：</label></td>
                    <td>
                        <form:select path="user_sex" style="width:100%">
                             <form:option value="">--请选择--</form:option>
                             <form:options items="${sexList}"  itemLabel="codedesc" itemValue="code"/>
                        </form:select>
                    </td>
                    <td><form:errors path="user_sex" cssClass="error"></form:errors></td>
                </tr>
                <tr>
                    <td><label for="user_birthday">出生日期：</label></td>
                    <td><form:input path="user_birthday" size="40" class="Wdate" onClick="WdatePicker()"/></td>
                    <td><form:errors path="user_birthday" cssClass="error"></form:errors></td>
                </tr>
                <tr>
                    <td><label for="user_email">邮箱：</label></td>
                    <td><form:input path="user_email" size="40"/></td>
                    <td><form:errors path="user_email" cssClass="error"></form:errors></td>
                </tr>
                <tr>
                    <td><label for="user_edu">学历：</label></td>
                    <td>
                         <form:select path="user_edu" style="width:100%">
                             <form:option value="">--请选择--</form:option>
                             <form:options items="${eduList}"  itemLabel="codedesc" itemValue="code"/>
                        </form:select>
                    </td>
                    <td><form:errors path="user_edu" cssClass="error"></form:errors></td>
                </tr>
                <tr>
                    <td><label for="user_telephone">联系方式：</label></td>
                    <td><form:input path="user_telephone" size="40"/></td>
                    <td><form:errors path="user_telephone" cssClass="error"></form:errors></td>
                </tr>
                <tr>
                    <td><label for="user_address">家庭住址：</label></td>
                    <td><form:input path="user_address" size="40"/></td>
                    <td><form:errors path="user_address" cssClass="error"></form:errors></td>
                </tr>
            </table>
            <p>
              <input type="submit" value="保存" class="btn out">
            </p>
        </fieldset>
        <!--<form:errors path="*"></form:errors> -->
        </form:form>
        <p style="color: red">${message}</p>
        <p>
            <a href="<c:url value="/user/list" />"  class="abtn out">返回列表</a>
        </p>
    </div>
</body>
</html>