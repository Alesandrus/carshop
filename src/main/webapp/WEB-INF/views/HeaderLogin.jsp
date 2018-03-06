<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="row align-items-center">
    <div class="col-md-2 align-self-start" align="center">
        <jsp:include page="Logo.jsp"/>
    </div>
    <div class="col-md-2"></div>
    <div class="col-md-3 text-primary text-center">
        <h1>My Car Shop</h1>
    </div>
    <c:choose>
        <c:when test="${sessionScope.user eq null}">
                <div class="col-md-5 text-md-right text-sm-center text-center">
                    <form name="log" method="post" action=login>
                        <div class="container">
                            <div class="row">
                                <div class="col-12 col-sm text-sm-right text-center">
                                    <label for="log">Логин</label>
                                </div>
                                <div class="col-12 col-sm text-sm-left text-center">
                                    <input type="text" name="login" id="log">
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-12 col-sm text-sm-right text-center">
                                    <label for="pas">Пароль</label>
                                </div>
                                <div class="col-12 col-sm text-sm-left text-center">
                                    <input type="password" name="password" id="pas">
                                </div>
                            </div>
                            <div class="row">
                                <div class="col text-center">
                                    <input type="submit" class="btn btn-primary btn-sm" value="Войти">
                                </div>
                            </div>
                        </div>
                    </form>
                    <a href="createcarad">Подать объявление</a><span style="padding-left:10px;"></span> <a href="signup">Зарегистрироваться</a>
                </div>
        </c:when>
        <c:otherwise>
                <div class="col-md text-md-right text-sm-center text-center">
                    Здравствуйте, ${sessionScope.user.name}<jsp:include page="Logout.jsp"/>
                    <a href="createcarad">Подать объявление</a><span style="padding-left:10px;"></span> <a href="account">Личный кабинет</a>
                </div>
        </c:otherwise>
    </c:choose>
</div>