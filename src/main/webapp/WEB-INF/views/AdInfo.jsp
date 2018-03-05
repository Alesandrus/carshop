<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <script type='text/javascript' src='scripts/jquery-3.2.1.min.js'></script>
    <title>${ad.model.brand.name} ${ad.model.name}</title>
    <link rel="icon" href="images/logo/logo.png" type="image/png">
</head>
<body>
<div class="container-fluid">
    <div class="row align-items-center">
        <div class="col-sm-2" align="center">
            <jsp:include page="Logo.jsp"/>
        </div>
        <div class="col-sm-8 text-primary text-center">
            <h1>
                ${ad.model.brand.name} ${ad.model.name} ${ad.yearOfManufacture}
            </h1>
        </div>
        <div class="col-sm-2 text-center text-primary">
            <h3>
                <c:choose>
                    <c:when test="${ad.status}">
                        Продано
                    </c:when>
                    <c:otherwise>
                        Цена: ${ad.price}&#160;&#8381;
                    </c:otherwise>
                </c:choose>
            </h3>
        </div>
    </div>
    <div class="row">
        <div class="col-md-9 col-12 text-center">
            <div class="container-fluid">
                <div class="row">
                    <div class="col-12">
                        <c:choose>
                            <c:when test="${ad.images[0] eq null}">
                                <img class="rounded img-fluid" src="images/nofoto.jpg">
                            </c:when>
                            <c:otherwise>
                                <img class="rounded img-fluid" src="images/${ad.images[0]}">
                            </c:otherwise>
                        </c:choose>
                    </div>
                </div>
                <div class="row">
                    <div class="col-sm-6">
                        Марка: ${ad.model.brand.name}<br>
                        Модель: ${ad.model.name}<br>
                        Год выпуска: ${ad.yearOfManufacture}<br>
                        Пробег: ${ad.kilometrage} км<br>
                        Тип кузова: <span id="body">${ad.body}</span>
                        <script>
                            var body = document.getElementById("body")
                            var text = body.innerText.toLowerCase();
                            body.innerHTML = text;
                        </script>
                    </div>
                    <div class="col-sm-6">
                        Коробка передач: <span id="transmission">${ad.transmission}</span><br>
                        <script>
                            var body = document.getElementById("transmission")
                            var text = body.innerText.toLowerCase();
                            body.innerHTML = text;
                        </script>
                        Тип двигателя: <span id="motor">${ad.motor}</span><br>
                        <script>
                            var body = document.getElementById("motor")
                            var text = body.innerText.toLowerCase();
                            body.innerHTML = text;
                        </script>
                        Привод: <span id="drive">${ad.wheelDrive}</span><br>
                        <script>
                            var body = document.getElementById("drive")
                            var text = body.innerText.toLowerCase();
                            body.innerHTML = text;
                        </script>
                        Мощность двигателя: ${ad.power} л.с.
                    </div>
                </div>
                <p>
                    <div class="row text-justify">
                        ${ad.description}
                    </div>
                </p>
            </div>
        </div>
        <div class="col-md-3 col-sm-12">
            <div class="container-fluid">
                <p>
                    <div class="row">
                        <div class="col">Контактная информация:</div>
                    </div>
                    <div class="row">
                        <div class="col">${ad.creator.name}</div>
                    </div>
                    <div class="row">
                        <div class="col">${ad.creator.email}</div>
                    </div>
                </p>
                <p>
                    <div class="row">
                        <div class="col">Место осмотра:</div>
                    </div>
                    <div class="row">
                        <div class="col">${ad.city.country.name}, ${ad.city.name}</div>
                    </div>
                </p>
                <p>
                    <div class="row">
                        <div class="col">Размещено: ${created}</div>
                    </div>
                </p>
            </div>
        </div>
    </div>
</div>
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
</body>
</html>
