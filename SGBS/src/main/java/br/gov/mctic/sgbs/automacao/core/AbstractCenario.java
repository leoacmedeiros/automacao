package br.gov.mctic.sgbs.automacao.core;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public abstract class AbstractCenario {

    protected <T> T Em(Class<T> classe) {
        return PageFactory.initElements(WDS.get(), classe);
    }

    protected void acessarMenu(String... menus) {
        WDS.get().get(PropriedadeUtils.get("pagina_inicial"));
        if (menus.length == 1 && "Home".equals(menus[0])) {
            WDS.get().findElement(By.xpath("//span[text()='Home']")).click();
        } else {
            WebElement menu = WDS.get().findElement(By.xpath("//button/div/span[text()='" + menus[0] + "']"));
            String nameMenu = menu.findElement(By.xpath("../..")).getAttribute("name");
            menu.click();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (menus.length > 1) {
                WebElement subMenu = WDS.get().findElement(By.xpath("//ul[@id='docs-menu-" + nameMenu + "']/li/div/div/a/span[text()='" + menus[1] + "']"));
                subMenu.click();
            }
        }
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        aguardarCarregamento();
    }

    protected void aguardarCarregamento() {
        WDS.delay(500);
        WDS.getWait().until(ExpectedConditions.invisibilityOf(WDS.get().findElement(By.cssSelector(".block-ui-container"))));
        WDS.delay(500);
    }
}
