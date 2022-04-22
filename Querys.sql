CREATE VIEW     detalleProductos                  AS

    SELECT      C.id,
                C.sabor,
                F.form                              AS form,
                F.formato                           AS formato,
                F.venta                             AS venta,
                F.compra                            AS compra,
                C.cantidad                          as stock,
                C.imagen                            AS imagen

    FROM        catalogo                            AS C
                INNER JOIN  
                formatos                            AS F

    ON          C.formato       = F.idFormato;



CREATE VIEW     detalleMovimientos                  AS

    SELECT      M.idMovimiento,
                C.sabor,
                F.form                              AS formato,
                D.depto                             AS departamento,
                DATE_FORMAT(M.fecha,"%Y-%m-%d")     AS fecha,
                TIME_FORMAT(M.fecha,"%H:%i:%s")     AS hora,
                M.pVenta                            AS venta,
                M.pCompra                           AS compra,
                M.cantidad                          AS cantidad

    FROM        movimientos                         AS M
                INNER JOIN 
                catalogo                            AS C

    ON          M.idPaleta      = C.id
                INNER JOIN  
                formatos                            AS F

    ON          C.formato       = F.idFormato
                INNER JOIN
                dptos                               AS D

    ON          M.idDepto       = D.idDepto;


DELIMITER //
CREATE PROCEDURE    insertaMovimiento(varFecha varchar(10), varHora varchar(8), varSabor varchar(20), varFormato varchar(2), varVenta decimal(5,2), varCompra decimal(5,2),varDepto varchar(8), varCantidad int) 
BEGIN

    INSERT INTO     MOVIMIENTOS(idPaleta,idDepto,fecha,pVenta,pCompra,cantidad)

        SELECT      C.id                                AS idPaleta,
                    D.idDepto                           AS idDepto,
                    CONCAT(varFecha," ",varHora)        AS fecha,
                    varVenta                            AS venta,
                    varCompra                           AS compra,
                    varCantidad                         AS cantidad

        FROM        detalleProductos                    AS C
                    INNER JOIN
                    dptos                               AS D

        ON          C.sabor             = varSabor
        AND         C.form              = varFormato
        AND         D.depto             = varDepto;

END //
DELIMITER ;



--recibe como parametros dos fechas en formato AAAA-MM-DD HH-mm-ss
DELIMITER //
CREATE PROCEDURE getMovimientosIntervalo(fechaIni varchar(19), fechaFin varchar(19)) 
BEGIN
    SELECT          *
    FROM            detalleMovimientos
    WHERE           concat(fecha," ",hora) BETWEEN fechaIni AND fechaFin;
END//

DELIMITER ;


DELIMITER //
CREATE PROCEDURE setImgUrl() 
BEGIN

    UPDATE          catalogo                    AS C 
                    INNER JOIN  
                    formatos                    AS F 
    
    ON              C.formato   = F.idFormato 
    SET             C.imagen    = concat("/img/catalogo/",sabor,f.form,".jpg");

END //
DELIMITER ;
