package br.com.quatroquatros.gestaoDeResiduos.steps;

import br.com.quatroquatros.gestaoDeResiduos.dto.auth.LoginDto;
import br.com.quatroquatros.gestaoDeResiduos.dto.usuario.UsuarioCadastroDto;
import br.com.quatroquatros.gestaoDeResiduos.model.UsuarioRole;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.*;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

public class UserAuthSteps {

    @Autowired
    private TestRestTemplate restTemplate;

    private ResponseEntity<String> response;
    private UsuarioCadastroDto usuarioCadastroDto;
    private LoginDto loginDto;
    private String token;
    private String userEmail;

    @Given("a new user info")
    public void a_new_user_info() {
        userEmail = "user_" + UUID.randomUUID().toString() + "@teste.com";
        usuarioCadastroDto = new UsuarioCadastroDto(
                "Novo Usuário",
                userEmail,
                "senha123",
                UsuarioRole.USER
        );
    }

    @Given("the user is already registered")
    public void the_user_is_already_registered() {
        HttpEntity<UsuarioCadastroDto> entity = new HttpEntity<>(usuarioCadastroDto);
        restTemplate.exchange("/api/auth/register", HttpMethod.POST, entity, String.class);
    }

    @Given("the user info with an invalid email {string}")
    public void the_user_info_with_an_invalid_email(String email) {
        usuarioCadastroDto = new UsuarioCadastroDto(
                "Usuário Inválido",
                email,
                "senha123",
                UsuarioRole.USER
        );
    }

    @Given("a registered user with email {string} and password {string}")
    public void a_registered_user_with_email_and_password(String email, String password) {
        usuarioCadastroDto = new UsuarioCadastroDto(
                "Usuário Registrado",
                email,
                password,
                UsuarioRole.USER
        );
        HttpEntity<UsuarioCadastroDto> entity = new HttpEntity<>(usuarioCadastroDto);
        restTemplate.exchange("/api/auth/register", HttpMethod.POST, entity, String.class);

        loginDto = new LoginDto(email, password);
    }

    @Given("an unregistered user with email {string} and password {string}")
    public void an_unregistered_user_with_email_and_password(String email, String password) {
        loginDto = new LoginDto(email, password);
    }

    @Given("a registered user with email {string} and an empty password")
    public void a_registered_user_with_email_and_an_empty_password(String email) {
        usuarioCadastroDto = new UsuarioCadastroDto(
                "Usuário Registrado",
                email,
                "senha123",
                UsuarioRole.USER
        );
        HttpEntity<UsuarioCadastroDto> entity = new HttpEntity<>(usuarioCadastroDto);
        restTemplate.exchange("/api/auth/register", HttpMethod.POST, entity, String.class);

        loginDto = new LoginDto(email, "");
    }

    @When("I send a Post request to \\/api\\/auth\\/register")
    public void i_send_a_post_request_to_api_auth_register() {
        HttpEntity<UsuarioCadastroDto> entity = new HttpEntity<>(usuarioCadastroDto);
        response = restTemplate.exchange("/api/auth/register", HttpMethod.POST, entity, String.class);
    }

    @When("I send a Post request to \\/api\\/auth\\/login")
    public void i_send_a_post_request_to_api_auth_login() {
        HttpEntity<LoginDto> entity = new HttpEntity<>(loginDto);
        response = restTemplate.exchange("/api/auth/login", HttpMethod.POST, entity, String.class);

        if (response.getStatusCode() == HttpStatus.OK) {
            try {
                ObjectMapper mapper = new ObjectMapper();
                JsonNode root = mapper.readTree(response.getBody());
                this.token = root.path("data").path("token").asText();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Then("I should receive a {int} response code")
    public void i_should_receive_a_response_code(Integer statusCode) {
        assertEquals(statusCode.intValue(), response.getStatusCodeValue());
    }

    @Then("the response should contain the user information")
    public void the_response_should_contain_the_user_information() {
        assertTrue(response.getBody().contains("Novo Usuário"));
        assertTrue(response.getBody().contains(userEmail));
    }

    @Then("the response should contain {string}")
    public void the_response_should_contain(String message) {
        assertTrue(response.getBody().contains(message));
    }

    @Then("the response should contain a valid token")
    public void the_response_should_contain_a_valid_token() {
        assertTrue(response.getBody().contains("token"));
    }
}