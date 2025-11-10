package tests;

import org.junit.jupiter.api.Test;
import pages.TestBoxPage;

import static com.codeborne.selenide.Selenide.open;

class TextBoxPageObjectsTests extends TestBase {
    TestBoxPage testBoxPage = new TestBoxPage();

    @Test
    void fillFormTest() {
        open("/text-box");
        testBoxPage.openTestBoxPage()
                   .setUserName("Alex")
                   .setUserEmail("alex@egorov.com")
                   .setCurrentAddress("Street Main")
                   .setPermanentAddress("Double Street Main")
                   .clickButtonSubmit()
                           .checkResult("Name:", "Alex")
                           .checkResult("Email:", "alex@egorov.com")
                           .checkResult("Current Address :", "Street Main")
                           .checkResult("Permananet Address :", "Double Street Main");
    }
}
