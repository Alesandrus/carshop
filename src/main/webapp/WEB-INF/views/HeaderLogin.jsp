<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:choose>
    <c:when test="${sessionScope.user eq null}">
        <div class="row">
            <div class="col-md" align="right">
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
                <a href="createcarad">Подать объявление</a><span style="padding-left:10px;"></span> <a href="signup">Зарегистрироваться</a>
            </div>
        </div>
    </c:when>
    <c:otherwise>
        <div class="row">
            <div class="col-md" align="right">
                Здравствуйте, ${sessionScope.user.name}<jsp:include page="Logout.jsp"/>
                <a href="createcarad">Подать объявление</a><span style="padding-left:10px;"></span> <a href="account">Личный кабинет</a>
            </div>
        </div>
    </c:otherwise>
</c:choose>