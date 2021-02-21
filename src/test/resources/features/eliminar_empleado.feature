Feature: consumo de api
  Como usuario consumidor de mi api
  Quiero poder crear, consultar, eliminar and actualizar usuarios en mi api
  Para tener un excelente servicio a los cleintes

  Scenario Outline: Eliminar exitosamente un empleados de la bd
    Given Que el usuario desea probar su api
    When El usuario elimina el empleado <IdEmpleado> en su api
    Then El usuario verifica la eliminacion del empleado <IdEmpleado>

    Examples:
      |IdEmpleado |
      |12258      |