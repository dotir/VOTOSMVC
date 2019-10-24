<%-- 
    Document   : index
    Created on : 02-oct-2019, 21:48:30
    Author     : irving
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Votaciones</title>
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <!-- Tell the browser to be responsive to screen width -->
        <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
        <!-- Bootstrap 3.3.6 -->
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
        <!-- Font Awesome -->
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.5.0/css/font-awesome.min.css">
        <!-- Ionicons -->
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/ionicons/2.0.1/css/ionicons.min.css">
        <!-- Theme style -->
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/admin-lte/2.4.18/css/AdminLTE.min.css">
        <!-- iCheck -->
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/iCheck/1.0.2/skins/flat/blue.css">
        <style>
        html {
            height:100%;
            width:100%;
        }
        body{
            background:#8ba987 url('http://cd00.epimg.net/cincodias/imagenes/2015/12/14/lifestyle/1450083573_743332_1450084825_noticia_normal.jpg') no-repeat center center;
            background-size:100% 100%;
        }
        #navegador ul{
        list-style-type: none;
        text-align: right;
        }
        #navegador li{
           display: inline;
           text-align: center;
           margin: 0 10px 0 0;
        }
        #navegador li a {
           padding: 2px 7px 2px 7px;
           color: #666;
           background-color: #eeeeee;
           border: 1px solid #ccc;
           text-decoration: none;
        }
        #navegador li a:hover{
           background-color: #333333;
           color: #ffffff;
        }

        </style>
    </head>
    <body>
        <div id="navegador">
        <ul>
        <li><a href="login.jsp">Administracion</a></li>
        </ul>
        </div>
        <h1>Votaciones</h1>
        
        <div  class="form-group login-box">
             <div class="input-group">
<!--                <span class="input-group-addon">DNI</span>-->
                <input type="text" class="form-control" placeholder="Ingrese su DNI">
                <button class="btn btn-primary btn-sm">
                <i class="fa fa-check"</i>
            </button>
                
             </div>
            
        </div>
<!--        <div class="input-group input-group-sm">
                <span class="input-group-addon">DNI</span>
                <input type="number" class="form-control" placeholder="Ingrese su DNI" name="dni"  alt="Ingrese">
                
        </div>
            <button class="btn btn-primary btn-sm" type="submit"><i class="fa fa-check"</i></button>-->
        <!--</div>-->
        
        
    </body>
</html>
