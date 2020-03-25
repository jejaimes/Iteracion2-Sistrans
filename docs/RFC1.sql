SELECT PROVEEDOR_TIPO_DOC,PROVEEDOR_NUM_DOC, SUM(RESERVA.PRECIO)
FROM RESERVA
INNER JOIN ALOJAMIENTO
ON RESERVA.ALOJAMIENTO = ALOJAMIENTO.ID
WHERE FECHA <= sysdate AND FECHA >  TRUNC(sysdate,'yyyy')
GROUP BY PROVEEDOR_TIPO_DOC,PROVEEDOR_NUM_DOC
;
