package pages.components;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class CalendarComponent {

    SelenideElement dateOfBirthInput = $("#dateOfBirthInput");
    SelenideElement monthInput = $(".react-datepicker__month-select");
    SelenideElement yearInput = $(".react-datepicker__year-select");

    public void setDate (String day, String month, String year) {
        dateOfBirthInput.click();
        monthInput.selectOption(month);
        yearInput.selectOption(year);
        String dayOfDateLocator = String.format(".react-datepicker__day--0%s", day);
        $(dayOfDateLocator).click();
       // $(String.format(".react-datepicker__day--0%s:not(.react-datepicker__day--outside-month)", day)).click();
    }
}
