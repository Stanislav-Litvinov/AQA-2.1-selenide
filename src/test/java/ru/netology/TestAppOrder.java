package ru.netology;

import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class TestAppOrder {

    @Test
    void shouldSubmitRequest() {
        open("http://localhost:9999");
        SelenideElement form = $("#root");
        form.$("[data-test-id=name] input").setValue("Коржов Василий");
        form.$("[data-test-id=phone] input.input__control").setValue("+79633414412");
        form.$("[data-test-id=agreement]").click();
        form.$("[type=\"button\"]").click();
        $(".Success_successBlock__2L3Cw").shouldHave(exactText("  Ваша заявка успешно отправлена!" +
                " Наш менеджер свяжется с вами в ближайшее время."));
    }
}