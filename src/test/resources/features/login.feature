Feature: Login

  Background:
    Given el usuario está en la página de login

  Scenario: Login exitoso
    When ingresa usuario y contraseña válidos
    Then puede ver la pagina principal de productoss

  Scenario: Login fallido
    When ingresa usuario válido y contraseña incorrecta
    Then se muestra un mensaje de error de credenciales inválidas

  Scenario: Validación campos obligatorios
    When el usuario intenta iniciar sesión sin credenciales
    Then se muestra un mensaje de error de credenciales requeridas