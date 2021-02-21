Feature: consumo de api
  Como usuario consumidor de mi api
  Quiero poder crear, consultar, eliminar and actualizar usuarios en mi api
  Para tener un excelente servicio a los cleintes

  Scenario Outline: Cconsulta exitosa de empleados con salarios mayores a 5000000 y menor meses 6
    Given Que el usuario desea probar su api
    When El usuario consulta los empleados con salario mayor a <Salario> y menor tiempo <Meses> en su api
    Then El usuario verifica la cantidad de empleados con esa condiciones de <Salario> y <Meses> en la bd

    Examples:
         |Salario    |Meses |
         |5000000    |6     |




