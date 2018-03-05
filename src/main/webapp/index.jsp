<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
          integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <script type='text/javascript' src='scripts/jquery-3.2.1.min.js'></script>
    <title>Car Shop</title>
    <link rel="icon" href="images/logo/logo.png" type="image/png">
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
    <div>
        <div class="container-fluid text-sm-center">
            <form name="getfromfilter" id="formx" action="javascript:void(null);" onsubmit="call()" role="form">
                <div class="form-row justify-content-center">
                    <div class="form-group col-sm-auto">
                        <label for="brand">Марка</label>
                        <select name="brand" id="brand" class="form-control">
                            <option selected value="0"> -- select --</option>
                        </select>
                    </div>
                    <div class="form-group col-sm-auto">
                        <label for="model">Модель</label>
                        <select name="model" id="model" class="form-control">
                            <option selected value="0"> -- select --</option>
                        </select>
                    </div>
                    <div class="form-group col-sm-auto align-self-center">
                        <div class="custom-control custom-checkbox my-1 mr-sm-2">
                            <input type="checkbox" class="custom-control-input" id="foto" name="foto">
                            <label class="custom-control-label" for="foto">Только с фото</label>
                        </div>
                    </div>
                    <div class="form-group col-sm-auto align-self-center">
                        <div class="custom-control custom-checkbox my-1 mr-sm-2">
                            <input type="checkbox" class="custom-control-input" id="today" name="today">
                            <label class="custom-control-label" for="today">За сегодня</label>
                        </div>
                    </div>
                </div>
                <div class="form-row justify-content-center">
                    <div class="form-group col-sm-1 col-12 align-self-center">
                        <input class="btn btn-primary" type="submit" value="фильтровать">
                    </div>
                </div>
            </form>
        </div>
        <br>
        <div class="row justify-content-center">
            <div class="col-md-8">
                <div class="container" id="ads">
                </div>
            </div>
        </div>
    </div>
</div>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"
        integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
        crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"
        integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
        crossorigin="anonymous"></script>
<script type="text/javascript" src="scripts/getallads.js"></script>
</body>
</html>