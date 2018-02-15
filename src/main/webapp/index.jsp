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
            <form name="getfromfilter" id="formx" action="javascript:void(null);" onsubmit="call()">
                Марка<select name="brand" id="brand">
                    <option selected value="0"> -- select -- </option>
                </select>
                </a><span style="padding-left:10px;"></span>Модель<select name="model" id="model">
                    <option selected value="0"> -- select -- </option>
                </select>
                </a><span style="padding-left:10px;"></span>Только с фото<input type="checkbox" name="foto" id="foto">
                </a><span style="padding-left:10px;"></span>За сегодня<input type="checkbox" name="today" id="today">
                </a><span style="padding-left:10px;"></span><input type="submit" value="фильтровать">
            </form>
            <br>
            <table id="ads">
            </table>
        </div>
    <script type="text/javascript" src="scripts/getallads.js"></script>
    </body>
</html>