package pages;

//aca heredo las variables y metodos public de BasePage;
//con el super() hago llamada al constructor padre;

public class PaginaPrincipal extends BasePage {
   // '%s' significa que le vamos a estar pasando un String
  // private String searchButton = " //*[@id=\"page_section_63758442\"]/div/section/div[3]/section/div[2]/div/div[2]/form/div/button";
   private String sectionLink ="//a [normalize-space()='%s' and @href]";
   private String elegirUnPlanButton ="//a[normalize-space()='Elegir Plan' and @href]";


    public PaginaPrincipal() {
        super(driver);
    }

    //Metodo para navegar a www.freerangetesters.com
    public void navigateToFreeRangeTesters() {
        navigateTo("https://www.freerangetesters.com");
  //      clickElement(searchButton);
    }

    public void clickOnSectionNavigationBar(String section ){
        //reemplazar el marcador de posicion en seccionLink con el nombre
        String xpathSection = String.format(sectionLink, section);
        clickElement(xpathSection);

    }
    public void clickOnElegirPlanButton() {
        clickElement(elegirUnPlanButton);
    }



}
