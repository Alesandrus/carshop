<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>SignUp</title>
    </head>
    <body>
        <div align="center">
            <form method="post" action=signup>
                <table>
                    <tr>
                        <td>Логин</td>
                        <td><input type="text" name="login" required></td>
                    </tr>
                    <tr>
                        <td>Пароль</td>
                        <td><input type="password" name="password" required></td>
                    </tr>
                    <tr>
                        <td>Имя</td>
                        <td><input type="text" name="name" required></td>
                    </tr>
                    <tr>
                        <td>Фамилия</td>
                        <td><input type="text" name="surname" required></td>
                    </tr>
                    <tr>
                        <td>Email</td>
                        <td><input type="email" name="email" required></td>
                    </tr>
                    <tr>
                        <td colspan="2" align="center"><input type="submit" value="Зарегистрироваться"></td>
                    </tr>
                </table>
            </form>
        </div>
    </body>
</html>
