package FIRST;

import org.junit.Test;
import com.codeborne.selenide.*;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class homework4 {

    @Test


    public void redmed(){

        Selenide.open("https://redmed.ge/ka/user/register");
        Configuration.browserSize="1920x1088";
        $(byText("რეგისტრაცია")).click();
        $("#firstName").setValue("ტატა");
        $("#firstName").shouldBe(Condition.empty);
        $("#lastname").click();
        $("#lastname").setValue("პაიჭაძე");
        $(byText("გვარი სავალდებულოა")).shouldBe(Condition.visible);
        $("#phone").click();
        $("phone").setValue("565650908");
        $("#email").click();
        $("#email").setValue("tatiana.paichadze.1@iliauni.edu.ge");
        $("#email").shouldBe(Condition.empty);

        $("terms").shouldBe(Condition.checked);
        $("#singup").shouldBe(Condition.enabled);



    }

}
