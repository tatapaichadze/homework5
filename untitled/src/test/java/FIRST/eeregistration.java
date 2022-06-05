package FIRST;
import com.codeborne.selenide.*;

import com.codeborne.selenide.Selenide;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import org.junit.Test;

public class eeregistration {
    @Test
    public void dv(){

       // გახსენით ee.ge - ს ლინკი .
        // ტესტ მეთოდი 1 - დადებითი მნიშვნელობები



        //გადადით რეგისტრაციის გვერდზე
        Selenide.open("https://ee.ge/registration");
        Configuration.browserSize="1920x1088";
        //შეამოწმეთ რომ ნამდვილად რეგისტრაციის გვერდზე ხართ
        $(byText("რეგისტრაცია")).click();
        $(byText("დახურვა")).click();
        $(byText("სწრაფი რეგისტრაცი")).shouldBe(Condition.visible);
        //შეავსეთ სახელის ველი, დარწმუნდით რომ მონაცემი ჩაიწერა ანუ ველი არ არის ცარიელი

        $("#firstName").setValue("ტატა");
        $("#firstName").shouldBe(Condition.empty);

         //შეავსეთ გვარის ველი, დარწმუნდით რომ მონაცემი ჩაიწერა ანუ ველი არ არის ცარიელი
        $("#lastname").click();
        $("#lastname").setValue("პაიჭაძე");
        $(byText("გვარი სავალდებულოა")).shouldBe(Condition.visible);
         //შეავსეთ გვარის ველი, დარწმუნდით რომ მონაცემი ჩაიწერა ანუ ველი არ არის ცარიელი
        $("#email").click();
        $("#email").setValue("tatiana.paichadze.1@iliauni.edu.ge");
        $("#email").shouldBe(Condition.empty);

        $("#password").click();
        //შეავსეთ პაროლის ველი
        $("#password").setValue("Tata1234567890.");
        //	შეავსეთ გაიმეორეთ პაროლის ველი
        $("#confir#Password").setValue("Tata1234567890.");
        //	შეამოწმეთ რომ რეგისტრაციის ველი არის Enabled
        $("#singup").shouldBe(Condition.enabled);

    }
    @Test
    public void dv3(){
        Selenide.open("https://ee.ge/registration");
        Configuration.browserSize="1920x1088";
        //გადადით კალათაში და დარწმუნდით რომ ცარიელია
        $(".btn-cart").click();
        $(byText("კალათა ცარიელია")).shouldBe(Condition.visible);

     //დასერჩეთ ნებისმიერი რაღაც რასაც შედეგი ექნება, მაგალითად კომპიუტერი, პირეველივე შედეგი დაამატეთ კალათაში
        $("#search_list").click();
        $("#search_list").setValue("მაცივარი").pressEnter();
        $(".add_to_cart",0).click();

     //გადადით კალათაში ნახეთ რომ კალათა აღარაა ცარიელი
        $(".btn-cart").click();
        $(byText("კალათა ცარიელია")).shouldBe(Condition.disabled);
       
     // წაშალეთ კალათიდან პროდუქტი
        $(byText("წაშლა")).click();

     //დარწმუნდით რომ კალათა კვლავ ცარიელია
        $(byText("კალათა ცარიელია")).shouldBe(Condition.visible);


    }



}
