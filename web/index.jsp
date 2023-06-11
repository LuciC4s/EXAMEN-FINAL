<%-- Document : index Created on : 10/06/2023, 05:15:05 PM Author : Usuario --%>

    <%@page contentType="text/html" pageEncoding="UTF-8" %>
        <!DOCTYPE html>
        <html lang="en">

        <head>

            <meta charset="utf-8">
            <meta http-equiv="X-UA-Compatible" content="IE=edge">
            <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
            <meta name="description" content="">
            <meta name="author" content="">

            <title>Dashboard</title>

            <!-- Custom fonts for this template-->
            <link href="resources/vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
            <link
                href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i"
                rel="stylesheet">

            <!-- Custom styles for this template-->
            <link href="resources/css/sb-admin-2.min.css" rel="stylesheet">
            <link href="resources/vendor/datatables/dataTables.bootstrap4.min.css" rel="stylesheet">

            <link rel="stylesheet" type="text/css" href="https://cdn.jsdelivr.net/npm/toastify-js/src/toastify.min.css">
            <script type="text/javascript" src="https://cdn.jsdelivr.net/npm/toastify-js"></script>

        </head>

        <body id="page-top">
            <!-- Page Wrapper -->
            <div id="wrapper">

                <!-- Sidebar -->
                <ul class="navbar-nav bg-gradient-primary sidebar sidebar-dark accordion" id="accordionSidebar">

                    <!-- Sidebar - Brand -->
                    <a class="sidebar-brand d-flex align-items-center justify-content-center" href="#">
                        <div class="sidebar-brand-text mx-3">Dashboard</div>
                    </a>

                    <!-- Divider -->
                    <hr class="sidebar-divider my-0">

                    <!-- Nav Item - Dashboard -->
                    <li class="nav-item active">
                        <a class="nav-link" href="index.html">
                            <i class="fas fa-fw fa-tachometer-alt"></i>
                            <span>Dashboard</span></a>
                    </li>

                    <!-- Divider -->
                    <hr class="sidebar-divider">

                    <!-- Heading -->
                    <div class="sidebar-heading">
                        Interface
                    </div>

                    <!-- Nav Item - Pages Collapse Menu -->
                    <li class="nav-item">
                        <a class="nav-link collapsed" href="#" data-toggle="collapse" data-target="#collapseTwo"
                            aria-expanded="true" aria-controls="collapseTwo">
                            <i class="fas fa-fw fa-cog"></i>
                            <span>Administracion usuarios</span>
                        </a>
                        <div id="collapseTwo" class="collapse" aria-labelledby="headingTwo"
                            data-parent="#accordionSidebar">
                            <div class="bg-white py-2 collapse-inner rounded">
                                <h6 class="collapse-header">Administracion usuarios:</h6>
                                <a class="collapse-item" href="#" data-toggle="modal" data-target="#addUserModal">Añadir
                                    colaborador</a>
                            </div>
                        </div>
                    </li>

                </ul>
                <!-- End of Sidebar -->

                <!-- Content Wrapper -->
                <div id="content-wrapper" class="d-flex flex-column">

                    <!-- Main Content -->
                    <div id="content">

                        <!-- Begin Page Content -->
                        <div class="container-fluid">
                            <h1 class="h3 mt-3 text-gray-800">Listado kardex</h1>
                            <div class="mt-5">
                                <div class="modal-body">
                                    <form action="${pageContext.request.contextPath}/actions?act=insertUser"
                                        method='post'>
                                        <div class="form-row">
                                            <div class="form-group col-md-6">
                                                <label for="product">Producto</label>
                                                <select name="product" class="form-control">
                                                    <option selected value='A'>algo</option>
                                                    <option value='S'>mas</option>
                                                </select>
                                            </div>
                                            <div class="form-group col-md-6">
                                                <label for="moveType">Tipo de movimiento</label>
                                                <select name="movetype" class="form-control">
                                                    <option selected value='A'>Entrada de inventario</option>
                                                    <option value='S'>Salida de inventario</option>
                                                </select>
                                            </div>
                                        </div>
                                        <div class="form-row">
                                            <div class="form-group col-md-6">
                                                <label for="quantity">Cantidad</label>
                                                <input type="number" class="form-control" name="quantity"
                                                    placeholder="1">
                                            </div>
                                            <div class="form-group col-md-6">
                                                <label for="user">Usuario</label>
                                                <select name="user" class="form-control">
                                                    <option selected value='A'>lrperezc</option>
                                                    <option value='S'>mas</option>
                                                </select>
                                            </div>
                                        </div>
                                        <div class="form-row">
                                            <div class="form-group col-md-6">
                                                <label for="comments">Comentarios</label>
                                                <input type="text" class="form-control" name="cpmments"
                                                    placeholder="Comentarios (descripcion)">
                                            </div>
                                        </div>
                                        <div class="form-row d-flex justify-content-end">
                                            <button class="btn btn-primary mr-3">Nuevo</button>
                                            <button type="submit" class="btn btn-success">Ingresar</button>
                                        </div>

                                    </form>
                                </div>
                            </div>

                            <!-- Begin Page Content -->
                            <div>

                                <!-- DataTales Example -->
                                <div class="card shadow mb-4">
                                    <div class="card-body">
                                        <div class="table-responsive">
                                            <table class="table table-bordered" id="dataTable" width="100%"
                                                cellspacing="0">
                                                <thead>
                                                    <tr>
                                                        <th>No.</th>
                                                        <th>Usuario</th>
                                                        <th>Producto</th>
                                                        <th>Tipo de movimiento</th>
                                                        <th>Cantidad</th>
                                                        <th>Existencia</th>
                                                        <th>Saldo</th>
                                                        <th>Fecha</th>
                                                    </tr>
                                                </thead>
                                                <tbody>

                                                    <tr>
                                                        <th></th>
                                                        <th></th>
                                                        <th></th>
                                                        <th></th>
                                                        <th></th>
                                                        <th></th>
                                                        <th></th>
                                                        <th></th>
                                                    </tr>


                                                </tbody>
                                            </table>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <!-- /.container-fluid -->


                        </div>
                        <!-- /.container-fluid -->

                    </div>
                    <!-- End of Main Content -->

                </div>
                <!-- End of Content Wrapper -->

            </div>
            <!-- End of Page Wrapper -->



            <!-- add user Modal-->
            <div class="modal fade" id="addUserModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel"
                aria-hidden="true">
                <div class="modal-dialog modal-dialog-centered" role="document">
                    <div class="modal-content">
                        <div class="modal-header">
                            <h5 class="modal-title" id="exampleModalLabel">Ingresa los datos del colaborador</h5>
                            <button class="close" type="button" data-dismiss="modal" aria-label="Close">
                                <span aria-hidden="true">×</span>
                            </button>
                        </div>
                        <div class="modal-body">
                            <form action="${pageContext.request.contextPath}/actions?act=insertUser" method='post'>
                                <div class="form-row">
                                    <div class="form-group col-md-6">
                                        <label for="idUsr">Id de usuario</label>
                                        <input type="number" class="form-control" name="idUsr" placeholder="1">
                                    </div>
                                    <div class="form-group col-md-6">
                                        <label for="usrFullName">Nombre de usuario</label>
                                        <input type="text" class="form-control" name="usrFullName"
                                            placeholder="Lucia Del Rosario Perez Castillo">
                                    </div>
                                </div>
                                <div class="form-row">
                                    <div class="form-group col-md-6">
                                        <label for="usrName">Nombre de usuario</label>
                                        <input type="text" class="form-control" name="usrName" placeholder="Lrperezc">
                                    </div>
                                    <div class="form-group col-md-6">
                                        <label for="pwdUsr">CLave de usuario</label>
                                        <input type="password" class="form-control" name="pwdUsr"
                                            placeholder="A very Secure password">
                                    </div>
                                </div>
                                <button type="submit" class="btn btn-primary">Aceptar</button>
                            </form>
                        </div>
                    </div>
                </div>
            </div>



            <!-- Bootstrap core JavaScript-->
            <script src="resources/vendor/jquery/jquery.min.js"></script>
            <script src="resources/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

            <!-- Core plugin JavaScript-->
            <script src="resources/vendor/jquery-easing/jquery.easing.min.js"></script>

            <!-- Custom scripts for all pages-->
            <script src="resources/js/sb-admin-2.min.js"></script>

        </body>

        </html>