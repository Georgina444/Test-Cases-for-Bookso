# Описва фунционалноста(feature), която ще бъде тестватна


Feature: Визуализиране на налични книги

  Background: отваряне на приложението
    Given отваряне на приложението

  Scenario: Отваряне на начален екран с налични книги
    Then Визуализира се списък с жанрове
    And Визуализира списък с наличните 6 книги

  Scenario: Отваряне на начален екран с книги с избор на жанър
    When потребителя избере категория: "Комедия"
    Then Визуализира списък с наличните 5 книги

  Scenario: Отваряне на начален екран с книги с търсене по име на книга
    When потребителя въвежда име на книга "The Monk who sold his Ferrari" в полето за търсене
    And натиска бутона за търсене
    Then Визуализира списък с наличните 1 книга

  Scenario Outline: Отваряне на начален екран с книги с търсене по заглавие на книга
    When потребителя въвежда заглавие на книгата <име> в полето за търсене
    And натиска бутона за търсене
    Then Визуализира списък с наличните <брои> книги
    Examples:
      | име                               | брои |
      | "The Monk who sold his Ferrari"   | 1    |
      | ""                                | 6    |
      | "         "                       | 6    |
      | "$#%$&^^(*&&*()*)(*)(<><df;;;;'>" | 0    |