var app = angular.module("PaletasApp",[]);

app.controller("controlador",function($scope){

    var paletas = $scope;

    paletas.catalogo = {};

    paletas.getProductos = function(){

        $.ajax({
                    url: "http://192.168.100.54:8080/api/productos", 
                    success: function(result){
              
                            paletas.catalogo = result;
                            alert(paletas.catalogo);
                            $apply();
                    }
                });
    };

    paletas.getProductos();
    

});