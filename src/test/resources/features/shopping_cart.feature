Feature: Agregar productos al carrito

  Background:
    Given el usuario está logueado

  Scenario: Ver varios productos agregados en el carrito
    When el usuario agrega los siguientes productos al carrito
      | add-to-cart-sauce-labs-backpack |
      | add-to-cart-sauce-labs-bike-light |
      | add-to-cart-sauce-labs-bolt-t-shirt |
    And el usuario hace clic en el icono del carrito
    Then puede ver los siguientes productos agregados en el carrito
      | Sauce Labs Backpack |
      | Sauce Labs Bike Light |
      | Sauce Labs Bolt T-Shirt |