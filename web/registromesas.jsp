<%-- 
    Document   : registro
    Created on : 03-oct-2019, 1:17:18
    Author     : irving
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <title>Registro</title>
  <!-- Tell the browser to be responsive to screen width -->
  <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
  <!-- Bootstrap 3.3.6 -->
  <link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">
  <!-- Font Awesome -->
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.5.0/css/font-awesome.min.css">
  <!-- Ionicons -->
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/ionicons/2.0.1/css/ionicons.min.css">
  <!-- Theme style -->
  <link rel="stylesheet" href="dist/css/AdminLTE.min.css">
  <!-- iCheck -->
  <link rel="stylesheet" href="plugins/iCheck/square/blue.css">

  <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
  <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
  <!--[if lt IE 9]>
  <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
  <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
  <![endif]-->
</head>
<body class="hold-transition register-page">
<div class="register-box">
  <div class="register-logo">
    <a href="../../index.html"><b>Administracion</b></a>
  </div>

  <div class="register-box-body">
    <p class="login-box-msg">Registrar Mesas</p>

    <form>
      <div class="form-group has-feedback">
        <input type="number" class="form-control" placeholder="Numero Local" id="local">

      </div>
      <div class="form-group has-feedback">
        <input type="text" class="form-control" placeholder="Descripcion" id="descripcion">

      </div>
      
      <div class="row">
        <div class="col-xs-8">
<!--          <div class="checkbox icheck">
            <label>
              <input type="checkbox"> Estoy de acuerdo con los <a href="#">terminos</a>
            </label>
          </div>-->
        </div>
        <!-- /.col -->
        <div class="col-xs-4">
          <button type="button" id="registrar" class="btn btn-primary btn-block btn-flat">Registrar</button>
        </div>
        <!-- /.col -->
      </div>
    </form>
  </div>
  <!-- /.form-box -->
</div>
<!-- /.register-box -->

<!-- jQuery 2.2.3 -->
<script src="plugins/jQuery/jquery-2.2.3.min.js"></script>
<!-- Bootstrap 3.3.6 -->
<script src="bootstrap/js/bootstrap.min.js"></script>
<!-- iCheck -->
<script src="plugins/iCheck/icheck.min.js"></script>
<script>
  $(function () {
    $('input').iCheck({
      checkboxClass: 'icheckbox_square-blue',
      radioClass: 'iradio_square-blue',
      increaseArea: '20%' // optional
    });
  });
</script>
<script src="jquery-3.4.1.min.js"></script>    
        <script>             
            //AJAX con JSON
            $("#registrar").click(function() {
                var user = new Object();
                user.local = $('#local').val();
                user.descripcion = $('#descripcion').val();
                console.log(user);
                $.ajax({
                        url: "MesaRegister",
                        type: 'POST',
                        dataType: 'json',
                        data: {
                            text_json: JSON.stringify(user)
                        },
                        //contentType: 'application/json',
                        //mimeType: 'application/json',   
                        success : function(response) {
                                //$('#ajaxUserServletResponse').text(responseText);
                                console.log(response);
                                alert("Se registro correctamente")
                        },
                        error:function(data,status,er) {
                            alert("error: "+data+" status: "+status+" er:"+er);
                        }
                });
            });
        </script>
</body>
</html>

