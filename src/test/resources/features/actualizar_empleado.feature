Feature: consumo de api
  Como usuario consumidor de mi api
  Quiero poder crear, consultar, eliminar and actualizar usuarios en mi api
  Para tener un excelente servicio a los cleintes

  Scenario Outline: actualizacion exitosa de empleados
    Given Que el usuario desea probar su api
    When El usuario desea actualizar el empleado <idEmpleado> en su api
      |<Nombre>|<Meses>|<Salario>|
    Then El usuario verifica la actualizacion del empleado en la bd
      |<idEmpleado>|<Nombre>|<Meses>|<Salario>|
    Examples:
      |idEmpleado |Nombre|Meses|Salario |
      |12258      |Pepe  |1    |20000000|