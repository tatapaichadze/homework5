package FIRST;
import com.codeborne.selenide.*;
import org.junit.Assert;
import org.junit.Test;

import java.time.Duration;

import static com.codeborne.selenide.Selectors.byTagName;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static org.hamcrest.core.Is.is;

public class nextlllllll {
    @Test
    public void ee() {


        // იქსპექტი და ეშუალი უნდა შედარდეს
        Assert.assertEquals("teqsti", "ttt", "ttttt");


        String sstr = "tata";
        $("#asd").setValue("sstr");
        Assert.assertEquals("massage", sstr, $("#asd").getText());


        Assert.assertTrue($(byText("registration")).is(Condition.visible));
        Assert.assertFalse($(byText("registration")).is(Condition.visible));


        // String b;
        //Assert.assertNotEquals(sstr, $(b).getText());

        if ($("#asd").is(Condition.empty)) {

            $("#asd").setValue("tata");
        }
    }

       public void  testcod(){
           Selenide.open("https://ee.ge/registration");
           int cardNumber=$$("add_to_cart").size();
           for(int i=0; i<cardNumber;i++){

               String code= $(".sm-center", i).$(byTagName("P"),1).getText();

               $(".add_to_cart",i).click();

               $(".react-toast-notifications__toast__content").shouldBe(Condition.visible, Duration.ofMillis((1000)));
               Assert.assertEquals(code+ "დამატებულია კალათაში",$(".react-toast-notifications__toast__content").getText());

           }


        }



}
