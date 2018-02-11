<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <title>Car shop</title>
        <script type='text/javascript' src='scripts/jquery-3.2.1.min.js'></script>
    </head>
    <body>
        <div align="right">
            <jsp:include page="WEB-INF/views/HeaderLogin.jsp"/>
        </div>
        <div align="center">
            <table id="ads">
            </table>
        </div>
    <script type="text/javascript" src="scripts/getallads.js"></script>
    </body>
</html>