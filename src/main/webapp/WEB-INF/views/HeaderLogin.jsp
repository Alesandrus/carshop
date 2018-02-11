<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:choose>
    <c:when test="${sessionScope.user eq null}">
        <form name="log" method="post" action=login>
            <table>
                <tr>
                    <td>Логин</td><td><input type="text" name="login"></td>
                </tr>
                <tr>
                    <td>Пароль</td><td><input type="password" name="password"></td>
                </tr>
                <tr>
                    <td colspan="2" align="center"><input type="submit" value="Войти"></td>
                </tr>
            </table>
        </form>
        <p>
            <a href="createcarad">Подать объявление</a> <a href="signup">Зарегистрироваться</a>
        </p>
    </c:when>
    <c:otherwise>
        <p>Здравствуйте, ${sessionScope.user.name}</p>
        <p>
            <a href="createcarad">Подать объявление</a><span style="padding-left:10px;"></span> <a href="account">Личный кабинет</a>
            <jsp:include page="Logout.jsp"/>
        </p>
    </c:otherwise>
</c:choose>