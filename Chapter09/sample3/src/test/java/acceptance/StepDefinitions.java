package acceptance;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.springframework.web.client.RestTemplate;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


/** Steps definitions for calculator.feature */
public class StepDefinitions {
    private String server = System.getProperty("calculator.url");

    private RestTemplate restTemplate = new RestTemplate();

    private String a;
    private String b;
    private String result;

    @Given("^I have two numbers: (.*) and (.*)$")
    public void i_have_two_numbers(String a, String b) throws Throwable {
        this.a = a;
        this.b = b;
    }

    @When("^the calculator sums them$")
    public void the_calculator_sums_them() throws Throwable {
        String url = String.format("%s/sum?a=%s&b=%s", server, a, b);
        result = restTemplate.getForObject(url, String.class);
    }

    @Then("^I receive (.*) as a result$")
    public void i_receive_as_a_result(String expectedResult) throws Throwable {
        assertEquals(expectedResult, result);
    }

    @Given("^I have two numbers: (.*) and (.*)$")
    public void i_have_two_numbers_div(String a, String b) throws Throwable {
        this.a = a;
        this.b = b;
    }
    
    @When("^the calculator divides them$")
    public void the_calculator_divides_them() throws Throwable {
        String url = String.format("%s/divide?a=%s&b=%s", server, a, b);
        result = restTemplate.getForObject(url, String.class);
    }

    @Then("^I receive (.*) as a result$")
    public void i_receive_as_a_div_result(String expectedResult) throws Throwable {
        assertEquals(expectedResult, result);
    }

    @Given("^I have two numbers: (.*) and (.*)$")
    public void i_have_two_numbers_div_fail(String a, String b) throws Throwable {
        this.a = a;
        this.b = b;
    }

    @When("^the calculator attempts to divide them$")
    public void the_calculator_attempts_to_divide_them() throws Throwable {
        String url = String.format("%s/divide?a=%s&b=%s", server, a, b);
        try {
            result = restTemplate.getForObject(url, String.class);
        } catch (Exception e) {
            result = "error";
        }
    }

    @Then("^I should see an error message$")
    public void i_should_see_an_error_message() throws Throwable {
        assertTrue("Expected an error message", result.equals("error"));
    }
}
