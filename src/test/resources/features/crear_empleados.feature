
Feature: consumo de api
 Como usuario consumidor de mi api
 Quiero poder crear,consultar,eliminar and actualizar usuarios en mi api
 Para tener un excelente servicio a los cleintes

  Scenario Outline: Creacion de empleados exitoso
    Given Que el usuario desea probar su api
    When El usuario crea el empleado en su api
      | <IdEmpleado>|<Nombre>|<Meses>|<Salario>|
    Then El usuario deberia ver reflejado en la bd el empleado exitosamente
      | <IdEmpleado>|<Nombre>|<Meses>|<Salario>|

    Examples:
      |IdEmpleado |Nombre     |Meses |Salario |
      |12258      |Simon      |3     |6000000 |
      |13545      |Tomas      |5     |5400000 |
      |45687      |Bartolome  |9     |7200000 |
      |21546      |Juan       |24    |4300000 |
      |46875      |Andres     |65    |3500000 |
      |654543     |Pedro      |54    |3800000 |
      |56156      |Santiago   |12    |6600000 |
      |99865      |Felipe     |13    |1800000 |
      |33461      |Mateo      |1     |3514132 |
      |788756     |Judas      |4     |2355000 |




