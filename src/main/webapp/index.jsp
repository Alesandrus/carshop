<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
        <script type='text/javascript' src='scripts/jquery-3.2.1.min.js'></script>
        <title>Car shop</title>
        <style type="text/css">
            .bottomborder {
                border-bottom: 1px solid lightskyblue;
                padding-top: 2px;
                padding-bottom: 2px;
            }
        </style>
    </head>
    <body>
        <div class="container-fluid">
            <jsp:include page="WEB-INF/views/HeaderLogin.jsp"/>
            <br>
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
                <div class="row">
                    <div class="col-md-2">
                    </div>
                    <div class="col-md-8">
                        <div class="container" id="ads">
                        </div>
                    </div>
                    <div class="col-md-2"></div>
                </div>
            </div>

            <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
            <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
            <script type="text/javascript" src="scripts/getallads.js"></script>
        </div>
    </body>
</html>