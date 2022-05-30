package FIRST;

import com.codeborne.selenide.*;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.Assert;
import org.junit.Test;

import java.time.Duration;

import static com.codeborne.selenide.Selectors.byTagName;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class homework5 {
    @Test
    public void work1() {

        // გახსენით ee.ge - ს ლინკი .
        // ტესტ მეთოდი 1 - დადებითი მნიშვნელობები


        //გადადით რეგისტრაციის გვერდზე
        Selenide.open("https://ee.ge/registration");
        Configuration.browserSize = "1920x1088";
        //შეამოწმეთ რომ ნამდვილად რეგისტრაციის გვერდზე ხართ
        $(byText("რეგისტრაცია")).click();
        $(byText("დახურვა")).click();
        $(byText("სწრაფი რეგისტრაცი")).shouldBe(Condition.visible);
        Assert.assertTrue($(byText("სწრაფი რეგისტრაცი")).is(Condition.visible));
        //შეავსეთ სახელის ველი, დარწმუნდით რომ მონაცემი ჩაიწერა ანუ ველი არ არის ცარიელი

        $("#firstName").setValue("ტატა");
        $("#firstName").shouldBe(Condition.empty);

        //შეავსეთ გვარის ველი, დარწმუნდით რომ მონაცემი ჩაიწერა ანუ ველი არ არის ცარიელი
        $("#lastname").click();
        $("#lastname").setValue("პაიჭაძე");
        $(byText("გვარი სავალდებულოა")).shouldBe(Condition.visible);
        Assert.assertTrue($(byText("გვარი სავალდებულოა")).is(Condition.visible));

        String sstr = "პაიჭაძე";
        $("#lastname").setValue("sstr");
        Assert.assertEquals("გვარი სავალდებულოა", sstr, $("#lastname").getText());

        //შეავსეთ გვარის ველი, დარწმუნდით რომ მონაცემი ჩაიწერა ანუ ველი არ არის ცარიელი
        $("#email").click();
        $("#email").setValue("tatiana.paichadze.1@iliauni.edu.ge");
        $("#email").shouldBe(Condition.empty);

        $("#password").click();
        //შეავსეთ პაროლის ველი
        $("#password").setValue("Tata1234567890.");
        //	შეავსეთ გაიმეორეთ პაროლის ველი
        $("#confir#Password").setValue("Tata1234567890.");
        Assert.assertEquals( "#password", "#confir#Password");

        //	შეამოწმეთ რომ რეგისტრაციის ველი არის Enabled
        $("#singup").shouldBe(Condition.enabled);

    }

    @Test
    public void work3() {
        Selenide.open("https://ee.ge/registration");
        Configuration.browserSize = "1920x1088";
        //გადადით კალათაში და დარწმუნდით რომ ცარიელია
        $(".btn-cart").click();
        $(byText("კალათა ცარიელია")).shouldBe(Condition.visible);

        //დასერჩეთ ნებისმიერი რაღაც რასაც შედეგი ექნება, მაგალითად კომპიუტერი, პირეველივე შედეგი დაამატეთ კალათაში
        $("#search_list").click();
        $("#search_list").setValue("მაცივარი").pressEnter();
        $(".add_to_cart", 0).click();

        //გადადით კალათაში ნახეთ რომ კალათა აღარაა ცარიელი
        $(".btn-cart").click();
        $(byText("კალათა ცარიელია")).shouldBe(Condition.disabled);

        // წაშალეთ კალათიდან პროდუქტი
        $(byText("წაშლა")).click();

        //დარწმუნდით რომ კალათა კვლავ ცარიელია
        $(byText("კალათა ცარიელია")).shouldBe(Condition.visible);


        int cardNumber = $$("add_to_cart").size();
        for (int i = 0; i < cardNumber; i++) {

            String code = $(".sm-center", i).$(byTagName("P"), 1).getText();

            $(".add_to_cart", i).click();

            $(".react-toast-notifications__toast__content").shouldBe(Condition.visible, Duration.ofMillis((1000)));
            Assert.assertEquals(code + "დამატებულია კალათაში", $(".react-toast-notifications__toast__content").getText());


        }

    }
}
