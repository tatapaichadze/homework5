package FIRST;

import com.codeborne.selenide.*;

import org.junit.Assert;
import org.junit.Test;

import static com.codeborne.selenide.Selectors.byName;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static java.lang.Thread.sleep;

public class lesson {
    @Test

    public void test() throws InterruptedException {
        Selenide.open("https://www.google.ge/");
        Configuration.browserSize="1920x1088";
      //  SelenideElement selector=$(".gLFYf");
        SelenideElement selector1=$(byText("ავტორიზაცია"));

        //ეს ელემნტი ჩანს თუ არა ამოწმებს
        $("#telllogin").shouldBe(Condition.visible);


        SelenideElement selector=$(".gLFYf");
       $ ("#telllogin").shouldHave(Condition.text("შესვლა"));


        System.out.println(selector);

        //რამდენი ცალი არსებობს შევამოწმებთ
        ElementsCollection col=$$(byName("q")).shouldHave(CollectionCondition.size(12));

       //sleep(1000);
       //Duration.ofMillis(5000) იპოვოს 5000 წამის განმავლობაში
        $(".gLFYf").click();
        $("ავტორიზაცია").click();
       // $("ავტორიზაცია").sendKeys(Keys.END);
        $("ავტორიზაცია").setValue("tata");

        //შემიძლია ჩავწერო კლასი/ და ასარჩევი რაც იქნება ( მაგ: მამრობი ან მდედრობითი )
        $("ავტორიზაცია").selectRadio("ყავა");



    }
     @Test
    public void login() throws InterruptedException {
        Selenide. open("https://redmed.ge/ka");
         Configuration.browserSize = "1920x1080";
         //დაკლიკება ავტოიზაციაზე
         $(byText("ავტორიზაცია")).click();
         sleep(1000);
         //დავაკლიკოთ პაციენტს
         $(byText("პაციენტი")).click();
         //შესვლა რომ ჩანს ვამოწმებთ
         $(byText("შესვლა")).shouldBe(Condition.visible);

         //ვამოწმებთ ღილაკი "შემდეგი " რომ არის დისეიბლ( აიდი ავიღეთ საიდიტიდან)
         $("#login-button").shouldBe(Condition.disabled);
         // ჩავწერთ რაიმე ტექსტს და შევამოწმებთ რომ ინეიბლ გახდება( ჩასაწერს ვუპოვით უნიკალურს მაგ : აიდი)
         $("#tellogin").setValue("555555");
         $("#login-button").shouldBe(Condition.enabled);



         String sstr="tata";
         $("#asd").setValue("tata");
         Assert.assertEquals("tata","tata",$("#asd").getText());

     }


}