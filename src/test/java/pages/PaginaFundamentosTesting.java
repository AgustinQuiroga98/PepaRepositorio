package pages;

public class PaginaFundamentosTesting extends BasePage {

    private String fundamentosTestingLink = "//a[normalize-space()='Introducción al testing de software' and @href]";

    public PaginaFundamentosTesting(){
        super(driver);
    }

    public void clickFundamentosTestingLink (){
        clickElement(fundamentosTestingLink);
    }
}
