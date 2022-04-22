<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es" ng-app="PaletasApp">
    <head>
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta charset="UTF-8">
        <link rel="stylesheet" type="text/css" href="css/bootstrap/bootstrap.css">
        <link rel="stylesheet" type="text/css" href="css/index/index.css">

        <link rel="preconnect" href="https://fonts.googleapis.com">
        <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
        <link href="https://fonts.googleapis.com/css2?family=Montserrat&display=swap" rel="stylesheet">

        <script type="text/javascript" src="js/index.js"></script>
        <script type="text/javascript" src="js/jquery-3.6.0.js"></script>
        <script type="text/javascript" src="js/angular.js"></script>
        <script type="text/javascript" src="js/app.js"></script>

    </head>
    <body onload="onloadBody()" ng-controller="controlador">
        <header>
            
        </header>
        <div id="cover">    
            <div class="fullContent">
                <h1>
                    Las Paletas chidas
                </h1>

                <div id="botones" class="container" >
                    <div class="row justify-content-center">

                        <div class="col col-md-3 col-12">
                            <p>Realizar pedido</p>
                        </div>

                        <div class="col col-md-3 col-12">
                            <p>Catalogo</p>
                        </div>


                        <div class="col col-md-3 col-12">
                            <p>Promociones</p>
                        </div>

                    </div>
                    
                </div>
            </div>
        </div>

        <div class="fullContent" id="catalogo">

            <h1>
               Nuestros productos 
            </h1>

            <div class="container catalogo" >
                <div class="row justify-content-around">

                    <div class="col col-lg-3 col-md-4 col-6">
                        <img src="img/catalogo/LimonMD.jpg">
                        <div class="prodData">
                            <h2>Limon</h2>
                            <p>Mediana (100gr)</p>
                            <p class="precio">$20 MXN</p>
                        </div>
                    </div>

                    <div class="col col-lg-3 col-md-4 col-6">
                        <img src="img/catalogo/GrosellaMD.png">
                        <div class="prodData">
                            <h2>Grosella</h2>
                            <p>Mediana (100gr)</p>
                            <p class="precio">$20.00 MXN</p>
                        </div>
                            
                    </div>


                    <div class="col col-lg-3 col-md-4 col-6">
                        <img src="img/catalogo/TamarindoMD.png">
                        <div class="prodData">
                            <h2>Tamarindo</h2>
                            <p>Mediana (100gr)</p>
                            <p class="precio">$20.00 MXN</p>
                        </div>
                        
                    </div>

                    <div class="col col-lg-3 col-md-4 col-6">
                        <img src="img/catalogo/PinaMD.png">
                        <div class="prodData">
                            <h2>Piña</h2>
                            <p>Mediana (100gr)</p>
                            <p class="precio">$20.00 MXN</p>
                        </div>
                        
                    </div>

                    

        </div>

        <div class="fullContent" id="catalogo2">

            <h1>
               Nuestros productos 
            </h1>

            <div class="container catalogo" >
                <div class="row justify-content-around">
                    <div ng-repeat="producto in catalogo" class="col col-lg-3 col-md-4 col-6">
                        <img src="img/catalogo/PinaMD.png">
                        <div class="prodData">
                            <h2>{{producto.sabor}}</h2>
                            <p>{{producto.formato}} (100gr)</p>
                            <p class="precio">{{ "$" + producto.venta}} MXN</p>
                        </div>
                        
                    </div>
                </div>
                
            </div>

    </body>
</html>
