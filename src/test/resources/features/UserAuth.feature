Feature: User Authentication behavior

  Scenario: Register a new user successfully
    Given a new user info
    When I send a Post request to /api/auth/register
    Then I should receive a 201 response code
    And the response should contain the user information

  Scenario: Attempt to register an existing user
    Given a new user info
    And the user is already registered
    When I send a Post request to /api/auth/register
    Then I should receive a 409 response code
    And the response should contain "usuário já cadastrado"

  Scenario: Register a user with invalid data
    Given the user info with an invalid email "invalid-email"
    When I send a Post request to /api/auth/register
    Then I should receive a 400 response code
    And the response should contain "O email fornecido não é válido!"

  Scenario: Login with valid credentials
    Given a registered user with email "novoemail@teste.com" and password "senha123"
    When I send a Post request to /api/auth/login
    Then I should receive a 200 response code
    And the response should contain a valid token

  Scenario: Login with invalid credentials
    Given an unregistered user with email "invalid@teste.com" and password "senha123"
    When I send a Post request to /api/auth/login
    Then I should receive a 403 response code
    And the response should contain "usuário não cadastrado ou credenciais inválidas"

  Scenario: Login with empty password
    Given a registered user with email "novoemail@teste.com" and an empty password
    When I send a Post request to /api/auth/login
    Then I should receive a 400 response code
    And the response should contain "A senha do usuário é obrigatória!"



