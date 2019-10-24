<%-- 
    Document   : login
    Created on : 02-oct-2019, 22:21:35
    Author     : irving
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <title>Log in</title>
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

  <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
  <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
  <!--[if lt IE 9]>
  <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
  <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
  <![endif]-->
</head>
<body class="hold-transition login-page">
<div class="login-box">
  <div class="login-logo">
    <a href="../../index2.html"><b>Administracion</b></a>
  </div>
  <!-- /.login-logo -->
  <div class="login-box-body">
    <p class="login-box-msg">Ingrese</p>

    <form>
      <div class="form-group has-feedback">
        <input type="text" class="form-control" placeholder="Usuario" name="un" id="un">
        <span class="glyphicon glyphicon-envelope form-control-feedback"></span>
      </div>
      <div class="form-group has-feedback">
        <input type="password" class="form-control" placeholder="Constraseña" name="pw" id="pw">
        <span class="glyphicon glyphicon-lock form-control-feedback"></span>
      </div>
      <div class="row">
        <div class="col-xs-8">
<!--          <div class="checkbox icheck">
            <label>
              <input type="checkbox"> Recuerdame
            </label>
          </div>-->
        </div>
        <!-- /.col -->
        <div class="col-xs-4">
          <button type="button" id="logeo" class="btn btn-primary btn-block btn-flat">Ingresar</button>
        </div>
        <!-- /.col -->
      </div>
    </form>
<!--    <a href="register.html" class="text-center">Registrar</a>-->

  </div>
  <!-- /.login-box-body -->
</div>
<!-- /.login-box -->

<!-- jQuery 2.2.3 -->
<script src="https://code.jquery.com/jquery-2.2.3.min.js"></script>
<!-- Bootstrap 3.3.6 -->
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
<!-- iCheck -->
<script src="https://cdnjs.cloudflare.com/ajax/libs/iCheck/1.0.2/icheck.min.js"></script>
<!--<script>
  $(function () {
    $('input').iCheck({
      checkboxClass: 'icheckbox_square-blue',
      radioClass: 'iradio_square-blue',
      increaseArea: '20%' // optional
    });
  });
</script>-->

        <script src="jquery-3.4.1.min.js"></script>    
        <script>   
            
            $("#logeo" ).click(function() {
                var user = new Object();
                user.un = $('#un').val();
                user.pw = $('#pw').val();
                console.log(user);
                $.ajax({
                        url: "UserController",
                        type: 'POST',
                        dataType: 'json',
                        data: {
                            text_json: JSON.stringify(user)
                        },
                        //contentType: 'application/json',
                        //mimeType: 'application/json',   
                        success : function(response) {
                                //$('#ajaxUserServletResponse').text(responseText);
                                var name = response.firstName;
                                //response.sendRedirect("administracion.jsp")
                                alert("Bienvenido "+name)
                                location.href ="administracion.jsp";
//                                console.log(response);                               
//                                $('#UserController').html("Bienvenido "+name + "<br>");
                        },
                        error:function(data,status,er) {
//                                console.log(response);
//                                var name = response.firstName;
                                alert("No registrado")
//                                $('#UserController').html("No registrado " + "<br>");
                        }
                });
            });

        </script>

</body>
</html>
