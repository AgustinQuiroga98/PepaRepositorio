package pages;
// Importaciones necesarias
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BasePage {
    /*
     * Declaración de una variable estática 'driver' de tipo WebDriver
     * Esta variable va a ser compartida por todas las instancias de BasePage y sus subclases
     */
    protected static WebDriver driver;
    /*
     * Declaración de una variable de instancia 'wait' de tipo WebDriverWait.
     * Se inicializa inmediatamente con una instancia dew WebDriverWait utilizando el 'driver' estático
     * WebDriverWait se usa para poner esperas explícitas en los elementos web
     */
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    /*
     * Configura el WebDriver para Chrome usando WebDriverManager.
     * WebDriverManager va a estar descargando y configurando automáticamente el driver del navegador
     */

    static {
        WebDriverManager.chromedriver().setup();

        //Inicializa la variable estática 'driver' con una instancia de ChromeDriver

        driver = new ChromeDriver();
    }
    /*
     * Este es el constructor de BasePage que acepta un objeto WebDriver como argumento.
     */

    public BasePage(WebDriver driver) {
        BasePage.driver = driver;
    }

   /* ///Método estático para navegar a una URL.*/

    public static void navigateTo(String url) {
        driver.get(url);
    }
    //Metodo para cerrar el browser

    public static void closeBrowser(){
        driver.quit();
    }

    // Encuentra y devuelve un WebElement en la página utilizando un locator XPath, esperando a que esté presentente en el DOM

    private WebElement Find (String locator) {
        return wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(locator)));
    }

    public void clickElement (String locator){
        Find(locator).click();
    }

    //funcion para escribir texto en campo de texto, y clear para que quede limpio cuando ya haya completado con texto

    public void write (String locator,String keysToSend){
        Find(locator).clear();
        Find(locator).sendKeys( keysToSend);
    }

    //funciones para usar dropdown.
    //Seleccionar un dropDown por su valor.

    public void selectFromDropDownByValue(String locator,String value){
       Select dropdown = new Select(Find(locator));//vamos a definir su comportamiento
         dropdown.selectByValue(value);  //con la instancia dropdown me va permitir el llamado a funciones que me permite el select
    }

    //Seleccionar dropDown por su indice.

    public void selectFromDropDownByIndex(String locator, Integer index){
        Select dropdown = new Select(Find(locator));
        dropdown.selectByIndex(index);
    }

    //Esta funcion nos va estar devolviendo un numero de cantidad de opciones que tenemos en el dropDown

    public int dropDownSize(String locator){
        Select dropdown = new Select(Find(locator)); //creamos la instancia dropdown con objeto select
        List<WebElement>dropdownOptions = dropdown.getOptions();//este select nos permite agarrar todas las opciones de esa lista
        return dropdownOptions.size(); //el size es el numero de opciones

    }

    //Creamos un nuevo metodo para que nos devuelva todos los valores del dropdown

    public List<String> getDropdownValues(String locator){
        Select dropdown = new Select(Find(locator));

        List<WebElement> dropdownOptions = dropdown.getOptions();
        List<String> values = new ArrayList<>();
        for ( WebElement option : dropdownOptions){
            values.add(option.getText());
        }
        return values;



    }


}




/*package pages;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.time.Duration;

public class BasePage {
    protected static WebDriver driver;
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

//ACA TENEMOS EL BLOQUE ESTATICO QUE VA LEVANTAR UN ChromeDriver

    static {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

///CREAMOS CONSTRUCTOR
//(WebDriver driver) es un argumento creado recientemente;
//Este constructor nos va permitir que cuando heredemos esta clase;

    public BasePage(WebDriver driver) {
        BasePage.driver = driver;
    }
//CREAMOS FUNCION
// El argumento aca es una url

    public static void navigateTo(String url){
        driver.get(url);
    }


}*/