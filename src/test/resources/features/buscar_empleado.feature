Feature: consumo de api
  Como usuario consumidor de mi api
  Quiero poder crear, consultar, eliminar and actualizar usuarios en mi api
  Para tener un excelente servicio a los clientes

  Scenario Outline: Busqueda exitosa de empleado
    Given Que el usuario desea probar su api
    When El usuario busca el empleados con <idEmpleado> en su api
    Then El usuario verifica la busqueda del empleado <idEmpleado> en la bd

    Examples:
      |idEmpleado    |
      |12258         |