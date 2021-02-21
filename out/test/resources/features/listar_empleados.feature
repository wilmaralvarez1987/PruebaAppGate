Feature: consumo de api
  Como usuario consumidor de mi api
  Quiero poder crear, consultar, eliminar and actualizar usuarios en mi api
  Para tener un excelente servicio a los cleintes

  Scenario: Consulta exitosa de todos los empleados
    Given Que el usuario desea probar su api
    When El usuario consulta todos los empleados en su api
    Then El usuario verifica la cantidad de empleados en total en la bd

