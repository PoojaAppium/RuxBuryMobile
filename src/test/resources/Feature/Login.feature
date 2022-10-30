Feature: Login Feature

  @RLTC_1
  Scenario Outline: Login using valid credentials
    Given Application Launch
    When Application Open
    Then Validate SplashScreen Logo
    When Click on SignIN button
    Then Validate SignIN page Title <Sign in to Ruxbury>
    When Fill Email ID "<EmailID>"
    And Fill password "<Password>"
    And Click on submit
    Then Validate Home Page UI
    And Quite Application

    Examples: 
      | EmailID                    |  | Password |
      | pooja.dwivedi@codinova.com |  |    12345 |

  @RLTC_2
  Scenario Outline: Login Using Invalid Password
    Given Application Launch
    When Application Open
    Then Validate SplashScreen Logo
    When Click on SignIN button
    Then Validate SignIN page Title <Sign in to Ruxbury>
    When Fill Email ID "<EmailID>"
    And Fill password "<Password>"
    And Click on submit
    Then Validate Error <Invalid credentials>
    And Quite Application

    Examples: 
      | EmailID                    |  | Password |
      | pooja.dwivedi@codinova.com |  |      145 |

  @RLTC_3
  Scenario Outline: Login Using Invalid Email ID
    Given Application Launch
    When Application Open
    Then Validate SplashScreen Logo
    When Click on SignIN button
    Then Validate SignIN page Title <Sign in to Ruxbury>
    When Fill Email ID "<EmailID>"
    And Fill password "<Password>"
    And Click on submit
    Then Validate Error <Invalid credentials>
    And Quite Application

    Examples: 
      | EmailID         |  | Password |
      | pooja@gmail.com |  |    12345 |

  @RLTC_4
  Scenario Outline: Login Using Invalid Email Format
    Given Application Launch
    When Application Open
    Then Validate SplashScreen Logo
    When Click on SignIN button
    Then Validate SignIN page Title <Sign in to Ruxbury>
    When Fill Email ID "<EmailID>"
    And Fill password "<Password>"
    And Click on submit
    Then Validate Error <Enter valid email id>
    And Quite Application

    Examples: 
      | EmailID       |  | Password |
      | pooja.dwivedi |  |    12345 |

  @RLTC_5
  Scenario Outline: Login using empty password
    Given Application Launch
    When Application Open
    Then Validate SplashScreen Logo
    When Click on SignIN button
    Then Validate SignIN page Title <Sign in to Ruxbury>
    When Fill Email ID "<EmailID>"
    And Fill password "<Password>"
    And Click on submit
    Then Validate Error <Enter valid password>
    And Quite Application

    Examples: 
      | EmailID                    |  | Password |
      | pooja.dwivedi@codinova.com |  |          |
