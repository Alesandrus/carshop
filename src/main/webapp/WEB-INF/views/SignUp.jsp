﻿<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="st" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
        <link rel="icon" href="images/logo/logo.png" type="image/png">
        <title>Регистрация</title>
        <style type="text/css">
            .error{
                color: red;
            }
        </style>
    </head>
    <body>
        <div class="container-fluid">
            <div class="row">
                <div class="col-md-2" align="center">
                    <jsp:include page="Logo.jsp"/>
                </div>
                <div class="col-md-8 align-self-center">
                    <div class="container-fluid text-center">
                        <sf:form method="post" action="signup" modelAttribute="user">
                            <div class="form-row justify-content-center">
                                <div class="form-group col-sm-auto">
                                    <label for="login">Логин</label>
                                    <sf:input path="login" class="form-control" id="login" type="text" name="login"/>
                                    <sf:errors path="login" cssClass="error" class="error"/>
                                </div>
                                <div class="form-group col-sm-auto">
                                    <label for="password">Пароль</label>
                                    <sf:input path="password" class="form-control" id="password" type="password" name="password"/>
                                    <sf:errors path="password" cssClass="error" class="error"/>
                                </div>
                            </div>
                            <div class="form-row justify-content-center">
                                <div class="form-group col-sm-auto">
                                    <label for="name">Имя</label>
                                    <sf:input path="name" class="form-control" id="name" type="text" name="name" />
                                    <sf:errors path="name" cssClass="error" class="error"/>
                                </div>
                                <div class="form-group col-sm-auto">
                                    <label for="surname">Фамилия</label>
                                    <sf:input path="surname" class="form-control" id="surname" type="text" name="surname" />
                                    <sf:errors path="surname" cssClass="error" class="error"/>
                                </div>
                            </div>
                            <div class="form-row justify-content-center">
                                <div class="form-group col-sm-auto">
                                    <label for="email">Email</label>
                                    <sf:input path="email" class="form-control" id="email" type="email" name="email" />
                                    <sf:errors path="email" cssClass="error" class="error"/>
                                </div>
                            </div>
                            <div class="form-row">
                                <div class="form-group col-12 align-self-center">
                                    <input class="btn btn-primary" type="submit" value="Зарегистрироваться">
                                </div>
                            </div>
                        </sf:form>
                    </div>
                </div>
                <div class="col-md-2"></div>
            </div>
        </div>
        <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
    </body>
</html>
