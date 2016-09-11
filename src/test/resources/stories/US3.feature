Feature: US3
  In order to check my operations
  As a bank client
  I want to see the history (operation, date, amount, balance) of my operations

  Background:
    Given I have an account with this history
      | Operation  | Date       | Amount     | Balance    |
      | DEPOSIT    | 2016/08/05 | 50.0       | 1050.0     |
      | WITHDRAWAL | 2016/08/21 | 240.0      | 810.0      |
      | DEPOSIT    | 2016/09/11 | 100.0      | 910.0      |
      | WITHDRAWAL | 2016/09/11 | 30.0       | 880.0      |

  Scenario: I want to see the history of my operations
    When I check my account history
    Then My account history looks like
    """
    | Operation  | Date       | Amount     | Balance    |
    | DEPOSIT    | 2016/08/05 | 50.0       | 1050.0     |
    | WITHDRAWAL | 2016/08/21 | 240.0      | 810.0      |
    | DEPOSIT    | 2016/09/11 | 100.0      | 910.0      |
    | WITHDRAWAL | 2016/09/11 | 30.0       | 880.0      |

    """

  Scenario: I want to see the history of my operations after some valid transactions
    Given I make a deposit from 700 the 2016/09/12
    And I make a withdraw from 450 the 2016/09/13
    And I make a deposit from 2000 the 2016/09/14
    And I make a withdraw from 200 the 2016/09/15
    When I check my account history
    Then My account history looks like
    """
    | Operation  | Date       | Amount     | Balance    |
    | DEPOSIT    | 2016/08/05 | 50.0       | 1050.0     |
    | WITHDRAWAL | 2016/08/21 | 240.0      | 810.0      |
    | DEPOSIT    | 2016/09/11 | 100.0      | 910.0      |
    | WITHDRAWAL | 2016/09/11 | 30.0       | 880.0      |
    | DEPOSIT    | 2016/09/12 | 700.0      | 1580.0     |
    | WITHDRAWAL | 2016/09/13 | 450.0      | 1130.0     |
    | DEPOSIT    | 2016/09/14 | 2000.0     | 3130.0     |
    | WITHDRAWAL | 2016/09/15 | 200.0      | 2930.0     |

    """

  Scenario: I want to see the history of my operations after some invalid transactions
    Given I make a deposit from 100 the 2016/09/12
    And I make a withdraw from 7000 the 2016/09/15
    And I make a deposit from 500 the 2016/09/16
    When I check my account history
    Then My account history looks like
    """
    | Operation  | Date       | Amount     | Balance    |
    | DEPOSIT    | 2016/08/05 | 50.0       | 1050.0     |
    | WITHDRAWAL | 2016/08/21 | 240.0      | 810.0      |
    | DEPOSIT    | 2016/09/11 | 100.0      | 910.0      |
    | WITHDRAWAL | 2016/09/11 | 30.0       | 880.0      |
    | DEPOSIT    | 2016/09/12 | 100.0      | 980.0      |
    | DEPOSIT    | 2016/09/16 | 500.0      | 1480.0     |

    """
