<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
    <head>
        <title>Create Car Ad</title>
    </head>
    <body>
    <div align="center">
        <form enctype="multipart/form-data" method="post" action=createcarad>
            <table>
                <tr>
                    <td colspan="2" align="center">Местоположение</td>
                </tr>
                <tr>
                    <td>Страна</td>
                    <td>
                        <select name="countries" id="country" required>
                            <option disabled selected value> -- select -- </option>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td>Город</td>
                    <td>
                        <select name="cities" id="city" required>
                            <option disabled selected value> -- select -- </option>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td colspan="2" align="center">Параметры</td>
                </tr>
                <tr>
                    <td>Марка</td>
                    <td>
                        <select name="brands" id="brand" required>
                            <option disabled selected value> -- select -- </option>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td>Модель</td>
                    <td>
                        <select name="models" id="model" required>
                            <option disabled selected value> -- select -- </option>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td>Год выпуска</td>
                    <td><input type="text" name="year" required></td>
                </tr>
                <tr>
                    <td>Пробег</td>
                    <td><input type="text" name="kilo" required></td>
                </tr>
                <tr>
                    <td>Кузов</td>
                    <td>
                        <select name="bodies" required>
                            <option disabled selected value> -- select -- </option>
                            <c:forEach var="body" items="${sessionScope.bodies}">
                                <option value="${body}">${body}</option>
                            </c:forEach>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td>Тип двигателя</td>
                    <td>
                        <select name="motors" required>
                            <option disabled selected value> -- select -- </option>
                            <c:forEach var="motor" items="${sessionScope.motors}">
                                <option value="${motor}">${motor}</option>
                            </c:forEach>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td>Мощность двигателя (л.с.)</td>
                    <td><input type="text" name="power" required></td>
                </tr>
                <tr>
                    <td>Коробка передач</td>
                    <td>
                        <select name="transmissions" required>
                            <option disabled selected value> -- select -- </option>
                            <c:forEach var="transmission" items="${sessionScope.transmissions}">
                                <option value="${transmission}">${transmission}</option>
                            </c:forEach>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td>Привод</td>
                    <td>
                        <select name="drives" required>
                            <option disabled selected value> -- select -- </option>
                            <c:forEach var="drive" items="${sessionScope.drives}">
                                <option value="${drive}">${drive}</option>
                            </c:forEach>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td>Описание объявления</td>
                    <td><textarea name="description" rows="10" cols="48"></textarea></td>
                </tr>
                <tr>
                    <td>Цена (руб)</td>
                    <td><input type="number" name="price" required></td>
                </tr>
                <tr>
                    <td>Загрузить фотографию (jpeg)</td>
                    <td id="files"><input type="file" name="photo" multiple accept="image/jpeg"></td>
                </tr>
                <tr>
                    <td colspan="2" align="center"><input type="submit" value="Подать объявление"></td>
                </tr>
            </table>
        </form>
    </div>
    </body>
</html>
