<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
        <title>Создать объявление</title>
        <link rel="icon" href="images/logo/logo.png" type="image/png">
    </head>
    <body>
        <div class="container-fluid">
            <div class="row align-items-center">
                <div class="col-sm-2" align="center">
                    <jsp:include page="Logo.jsp"/>
                </div>
                <div class="col-sm-8 text-center text-primary">
                    <h1>
                        Создание объявления
                    </h1>
                </div>
                <div class="col-sm-2">
                </div>
            </div>
            <div class="row align-items-center justify-content-center">
                <div class="col-10">
                    <div class="contaner-fluid">
                            <form enctype="multipart/form-data" method="post" action=createcarad>
                                <div class="row justify-content-center">
                                    <p class="text-info">
                                        Местоположение
                                    </p>
                                </div>
                                <div class="form-group row justify-content-center">
                                    <label class="col-form-label col-md-3" for="country">Страна</label>
                                    <div class="col-md-3">
                                        <select name="countries" id="country" class="form-control" style="text-align-last: center;" required>
                                            <option disabled selected value> -- select -- </option>
                                        </select>
                                    </div>
                                </div>
                                <div class="form-group row justify-content-center">
                                    <label class="col-form-label col-md-3" for="city">Город</label>
                                    <div class="col-md-3">
                                        <select name="cities" id="city" class="form-control" style="text-align-last: center;" required>
                                            <option disabled selected value> -- select -- </option>
                                        </select>
                                    </div>
                                </div>
                                <div class="row justify-content-center">
                                    <p class="text-info">
                                        Параметры
                                    </p>
                                </div>
                                <div class="form-group row justify-content-center">
                                    <label class="col-form-label col-md-3" for="brand">Марка</label>
                                    <div class="col-md-3">
                                        <select name="brands" id="brand" class="form-control" style="text-align-last: center;" required>
                                            <option disabled selected value> -- select -- </option>
                                        </select>
                                    </div>
                                </div>
                                <div class="form-group row justify-content-center">
                                    <label class="col-form-label col-md-3" for="model">Модель</label>
                                    <div class="col-md-3">
                                        <select name="models" id="model" class="form-control" style="text-align-last: center;" required>
                                            <option disabled selected value> -- select -- </option>
                                        </select>
                                    </div>
                                </div>
                                <div class="form-group row justify-content-center">
                                    <label class="col-md-3 col-form-label" for="year">Год выпуска</label>
                                    <div class="col-md-3">
                                        <input type="number" class="form-control" id="year" name="year" required>
                                    </div>
                                </div>
                                <div class="form-group row justify-content-center">
                                    <label class="col-md-3 col-form-label" for="kilo">Пробег</label>
                                    <div class="col-md-3">
                                        <input type="number" class="form-control" id="kilo" name="kilo" required>
                                    </div>
                                </div>
                                <div class="form-group row justify-content-center">
                                    <label class="col-form-label col-md-3" for="body">Кузов</label>
                                    <div class="col-md-3">
                                        <select name="bodies" id="body" class="form-control" style="text-align-last: center;" required>
                                            <option disabled selected value> -- select -- </option>
                                            <c:forEach var="body" items="${sessionScope.bodies}">
                                                <option value="${body}">${body}</option>
                                            </c:forEach>
                                        </select>
                                    </div>
                                </div>
                                <div class="form-group row justify-content-center">
                                    <label class="col-form-label col-md-3" for="motor">Тип двигателя</label>
                                    <div class="col-md-3">
                                        <select name="motors" id="motor" class="form-control" style="text-align-last: center;" required>
                                            <option disabled selected value> -- select -- </option>
                                            <c:forEach var="motor" items="${sessionScope.motors}">
                                                <option value="${motor}">${motor}</option>
                                            </c:forEach>
                                        </select>
                                    </div>
                                </div>
                                <div class="form-group row justify-content-center">
                                    <label class="col-md-3 col-form-label" for="power">Мощность двигателя (л.с.)</label>
                                    <div class="col-md-3">
                                        <input type="number" class="form-control" id="power" name="power" required>
                                    </div>
                                </div>
                                <div class="form-group row justify-content-center">
                                    <label class="col-form-label col-md-3" for="transmission">Коробка передач</label>
                                    <div class="col-md-3">
                                        <select name="transmissions" id="transmission" class="form-control" style="text-align-last: center;" required>
                                            <option disabled selected value> -- select -- </option>
                                            <c:forEach var="transmission" items="${sessionScope.transmissions}">
                                                <option value="${transmission}">${transmission}</option>
                                            </c:forEach>
                                        </select>
                                    </div>
                                </div>
                                <div class="form-group row justify-content-center">
                                    <label class="col-form-label col-md-3" for="drive">Привод</label>
                                    <div class="col-md-3">
                                        <select name="drives" id="drive" class="form-control" style="text-align-last: center;" required>
                                            <option disabled selected value> -- select -- </option>
                                            <c:forEach var="drive" items="${sessionScope.drives}">
                                                <option value="${drive}">${drive}</option>
                                            </c:forEach>
                                        </select>
                                    </div>
                                </div>
                                <div class="form-group row justify-content-end">
                                    <label class="col-md-3 col-form-label" for="description">Описание объявления</label>
                                    <div class="col-md-6">
                                        <textarea class="form-control" id="description" name="description" rows="10"></textarea>
                                    </div>
                                </div>
                                <div class="form-group row justify-content-center">
                                    <label class="col-md-3 col-form-label" for="price">Цена (руб)</label>
                                    <div class="col-md-3">
                                        <input type="number" class="form-control" id="price" name="price" required>
                                    </div>
                                </div>
                                <div class="form-group row justify-content-center">
                                    <label class="col-md-3 col-form-label" for="photo">Загрузить фотографию (jpeg)</label>
                                    <div class="col-md-4">
                                        <input type="file" class="form-control" id="photo" name="photo" multiple accept="image/jpeg">
                                    </div>
                                </div>
                                <div class="form-row">
                                    <div class="form-group col-12 align-self-center text-center">
                                        <input class="btn btn-primary" type="submit" value="Подать объявление">
                                    </div>
                                </div>
                            </form>
                    </div>
                </div>
            </div>
        </div>
        <script type='text/javascript' src='scripts/getgeobrand.js'></script>
        <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
    </body>
</html>
