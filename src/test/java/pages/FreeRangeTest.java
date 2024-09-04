/////package pages;
////DEPENDENCIAS Y OBJETOS DE DEPENDENCIAS
//
////import io.github.bonigarcia.wdm.WebDriverManager;
////import org.junit.Test;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.testng.annotations.AfterMethod;
//import org.testng.annotations.BeforeMethod;
//
////LA CLASE SIEMPRE TIENE EL MISMO NOMBRE DEL ARCHIVO, EN ESTE CASO FreeRangeTest
////En esta clase vamos a inicializar el chromedriver(setup), crear la instancia del chrome driver
////despues vamos a tener un test que va estar navegando en HTTP...
////y despues va haber un cierre
//
//public class FreeRangeTest {
//
//    private WebDriver driver; //Estamos seteando(SET) la variable/objeto "Driver" del tipo "WebDriver"
//    //EMPEZAMOS A USAR ANOTACIONES DE "testNG" COMO EL SETUP (BEFOREMETHOD) TEARDOWN (AFTERMETHOD) CLEAN;
//
//    @BeforeMethod
//    //el BeforeMethod ejecuta el codigo dentro de este bloque al principio de las pruebas
//    //al principio de este metodo en este caso
//    public void setUp() {
//        //inicializa el WebDriver para Chrome
//        WebDriverManager.chromedriver().setup();
//        driver = new ChromeDriver(); //Aca estamos instanciando el chromdriver
//    }
//
//    @Test
//    //Navega a la pagina web
//    public void navegamosAFreeRangeTesters() {
//        driver.get("https://www.freerangetesters.com"); //Aca usamos este metodo get
//    }
//
//    @AfterMethod
//    //Cierra el navegador despues de la prueba
//    public void tearDown(){
//        if (driver != null){ //si la instancia del web driver nombre "Driver" no es null
//            driver.quit(); //si la hay, hay quit
//        }
//    }
//}
