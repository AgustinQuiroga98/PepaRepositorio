package steps;
//Aca no necesitamos heredar nada
//eso se hace en la page object class y en base page

import java.util.List;

import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import java.util.Arrays;
import io.cucumber.java.en.* ; // el " .* " abarca todos los tipos (Given,When;There,etc)
import pages.PaginaPrincipal;
import pages.PaginaCursos;
import pages.PaginaFundamentosTesting;
import pages.PaginaRegistro;

public class FreeRangeSteps {

    SoftAssert soft = new SoftAssert();

    PaginaPrincipal landingPage = new PaginaPrincipal();
    PaginaCursos cursosPage = new PaginaCursos();
    PaginaFundamentosTesting fundamentosPage = new PaginaFundamentosTesting();
    PaginaRegistro registro = new PaginaRegistro();



    @Given("I navigate to www.freerangetesters.com")

/*
    Aca nececitamos acceder a
    Metodo para navegar a www.freerangetesters.com
    public void navigateToFreeRangeTesters(){
        navigateTo("https://www.freerangetesters.com");
    }
    tenemos que llamar a este metodo: navigateTo
    para eso necesitamos una instancia de la clase principal dentro de los steps
    PaginaPrincipal landingPage = new PaginaPrincipal(); por eso agregamos eso arriba.
*/

    public void iNavigateToFRT(){ //este tiene la estructura de un metodo, estamos poniendo un public void, nombre al metodo y parentesis, que si tuviese argumento se lo agregamos ahí;
        landingPage.navigateToFreeRangeTesters();

    }

    @When("I go to {word} using the navigation bar") //ahora entre llaves le vamos a avisar que section va ser cambiado por una palabra
    public void navigationBarUse(String section){ //ahora le avisamos que va estar usando un string que va ser la seccion
        landingPage.clickOnSectionNavigationBar(section); //aca voy a estar usando ese string
    }
    @When("(I|The user|The client) (select|selects) Elegir Plan")
    public void selectElegirPlan() {
        landingPage.clickOnElegirPlanButton();
    }
    @And("(I|The user|The client) (select|selects) Introducción al Testing")
    public void navigateToIntro(){
        cursosPage.clickFundamentosTestingLink();
        fundamentosPage.clickFundamentosTestingLink();

    }
    @Then("(I|The user|The client) can validate the options in the checkout page")
    public void validateCheckoutPlans() {
        List<String> lista = registro.returnPlanDropdownValues();
        List<String> listaEsperada = Arrays.asList("Academia: $16.99 / mes • 13 productos",
                "Academia: $176 / año • 13 productos", "Free: Gratis • 3 productos");

        Assert.assertEquals(listaEsperada, lista); //Aca estamos validando 2 listas
    }

    public void EjemplosAssertions(){
        String palabraEsperada = "pepe";
        String palabraEncontrada= "pepa";

        //Verifica que dos valores no son iguales
        Assert.assertNotEquals(palabraEsperada,palabraEncontrada);

        //verifica que dos valores son iguales.
        Assert.assertEquals(palabraEsperada,palabraEncontrada);

        //Verifica que una condicion sea verdadera
        Assert.assertTrue(palabraEncontrada.contains(palabraEsperada));

        //Verifica que una condicion es falsa
        Assert.assertFalse(palabraEncontrada.contains(palabraEsperada));

        //soft Assertions: No detienen la ejecución al fallar, ideal para verificar muchas cosas pequeñas a la vez.




    }

}
