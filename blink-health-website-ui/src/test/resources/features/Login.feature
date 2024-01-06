Feature: Blink Health Login

  Scenario: Blink Health Website Signing In Verification
    Given Blink Health Main Page is open
    When Sign In button is clicked
    Then Verify Blink Health Sign In workflow with the following Credentials
      | email                        | password           | isValidEmail | isValidPassword | isAuthenticatable | description                                       |
      | Invalid Email 1              | Invalid Password 1 | false        | false           | false             | Invalid Email, Invalid Password                   |
      | friendshipistmagic@gmail.com | Invalid Password 2 | true         | false           | false             | Registered Email, Invalid Password                |
      | Invalid Email 2              | tH~7@*+J9YiVrkR    | false        | true            | false             | Invalid Email, Valid Password                     |
      | aleksei.pokolev@mail.ru      | tH~7@*+J9YiVrkR    | true         | true            | false             | Non-registered, but valid Email, Valid Password   |
      | aleksei.pokolev@mail.ru      | Invalid Password 3 | true         | true            | false             | Non-registered, but valid Email, Invalid Password |
      | [blank]                      | [blank]            | false        | false           | false             | Blank Email, Blank Password                       |
      | friendshipistmagic@gmail.com | [blank]            | true         | false           | false             | Registered Email, Blank Password                  |
      | [blank]                      | tH~7@*+J9YiVrkR    | false        | true            | false             | Blank Email, Valid Password                       |
      | friendshipistmagic@gmail.com | tH~7@*+J9YiVrkR    | true         | true            | true              | Valid Credentials                                 |

  Scenario: Blink Health Website Signing Up Verification
    Given Blink Health Main Page is open
    When Sign In button is clicked
    And Create Account button is clicked
    Then Verify Blink Health Sign Up workflow with the following Credentials
      | email                        | password         | isValidEmail | isValidPassword | description                                     |
      | Invalid Email                | any password     | false        | false           | Invalid Email, Invalid Password                 |
      | friendshipistmagic@gmail.com | Invalid Password | true         | false           | Registered Email, Invalid Password              |
      | aleksei.pokolev@mail.ru      | tH~7@*+J9YiVrkR  | false        | true            | Non-registered, but valid Email, Valid Password |
      | friendshipistmagic@gmail.com | tH~7@*+J9YiVrkR  | true         | true            | Valid Credentials                               |