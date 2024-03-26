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

    @When("^the calculator attempts to divide them$")
    public void the_calculator_divs_them() throws Throwable {
        String url = String.format("%s/div?a=%s&b=%s", server, a, b);
        try {
            result = restTemplate.getForObject(url, String.class);
        } catch (Exception e) {
            result = "error";
        }
    }

    @Then("^I should see an error message$")
    public void i_should_see_an_error_message() throws Throwable {
        System.out.println("Actual result: " + result); // Add this line
        assertEquals("Division by 0", result);
    }

}
