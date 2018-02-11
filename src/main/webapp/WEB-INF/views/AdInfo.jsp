<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Ad Info</title>
    <style>
        #price {
            font-size: 130%;
        }

        #about {
            font-size: 120%;
            font-weight: bold;
        }
    </style>
</head>
<body>
<div align="center">
    <table>
        <tr>
            <td><span id="about">${ad.model.brand.name} ${ad.model.name} ${ad.yearOfManufacture}</span></td>
            <td id="price">
                <c:choose>
                    <c:when test="${ad.status}">
                        Продано
                    </c:when>
                    <c:otherwise>
                        Цена: ${ad.price} руб.
                    </c:otherwise>
                </c:choose>
            </td>
        </tr>
        <tr>
            <td>Размещено ${created}</td>
            <td></td>
        </tr>
        <tr>
            <td>
                <c:choose>
                    <c:when test="${ad.images[0] eq null}">
                        <img src="images/nofoto.jpg">
                    </c:when>
                    <c:otherwise>
                        <img src="images/${ad.images[0]}">
                    </c:otherwise>
                </c:choose>
            </td>
            <td align="right">
                Контактная информация<br>
                ${ad.creator.name}<br>
                ${ad.creator.email}<br><br>
                Место осмотра<br>
                ${ad.city.country.name}, ${ad.city.name}
            </td>
        </tr>
        <tr>
            <td>
                <table width="800">
                    <tr>
                        <td valign="top">
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
                        </td>
                        <td valign="top">
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
                        </td>
                    </tr>
                    <tr>
                        <td colspan="2">
                            ${ad.description}
                        </td>
                    </tr>
                </table>
            </td>
            <td></td>
        </tr>
    </table>
</div>
</body>
</html>
