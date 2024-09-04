package runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.AfterClass;
import org.junit.runner.RunWith;
import pages.BasePage;

@RunWith(Cucumber.class)
@CucumberOptions(features ="src/test/resources", //Directorios de nuestros archivos .features
        glue="steps",//Paquete donde tenemos nuestras clases definiendo los steps escritos en el feature file //para nuevo ejercicio vamos a dejar solo step antes habia "src/test/java/steps"
        plugin = { "pretty","html:target/cucumber-reports" }, tags = "@Navigation") //si le pongo otro nombre al tags que no existe no va correr nada en terminal con gradle test

public class TestRunner {
    @AfterClass
    public static void  cleanDriver(){
        BasePage.closeBrowser();
    }
}
