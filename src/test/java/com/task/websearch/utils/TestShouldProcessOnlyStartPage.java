package com.task.websearch.utils;

import com.task.websearch.dto.InitialDataModel;

public class TestShouldProcessOnlyStartPage {

    public static InitialDataModel getTestInitialModelForOneLinkProcess() {
        return new InitialDataModel("https://ua.woodoos.com/woodoos-ua/ukrazom/", 2, "fgdfgdg", 1);
    }

    public static String getFirstMessage() {
        return "{\"id\":1,\"url\":\"https://ua.woodoos.com/woodoos-ua/ukrazom/\",\"status\":\"Upload\",\"processed\":false}";
    }

    public static String getSecondMessage() {
        return "{\"id\":1,\"url\":\"https://ua.woodoos.com/woodoos-ua/ukrazom/\",\"status\":\"Search started\",\"processed\":false}";
    }

    public static String getThirdMessage() {
        return "{\"id\":1,\"url\":\"https://ua.woodoos.com/woodoos-ua/ukrazom/\",\"status\":\"Not found\",\"processed\":true}";
    }

    public static String getStartPageBody() {
        return "<!doctype html>\n" +
                "<html lang=\"en\"> \n" +
                " <head> \n" +
                "  <meta charset=\"UTF-8\"> \n" +
                "  <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\"> \n" +
                "  <meta http-equiv=\"X-UA-Compatible\" content=\"ie=edge\"> \n" +
                "  <title>Woodoos</title> \n" +
                "  <link rel=\"stylesheet\" href=\"../css/libs.min.css\"> \n" +
                "  <link rel=\"stylesheet\" href=\"../css/style_ukrazom.min.css\"> \n" +
                "  <link href=\"https://fonts.googleapis.com/css2?family=Open+Sans:wght@400;700&amp;display=swap\" rel=\"stylesheet\"> \n" +
                " </head> \n" +
                " <body> \n" +
                "  <header class=\"header\"> \n" +
                "   <div class=\"container\"> \n" +
                "    <div class=\"header__inner\"> <a href=\"#main\"> \n" +
                "      <div class=\"arrow-down\"> \n" +
                "       <img src=\"../images/icons/arrow-down.png\" alt=\"\"> \n" +
                "      </div> </a> \n" +
                "     <div style=\"font-size: 34px; line-height: 0.3; color: white; text-align: center; position: relative; top: 40%;\n" +
                "                       \">\n" +
                "      <div class=\"rich-text\"></div>\n" +
                "     </div> \n" +
                "    </div> \n" +
                "   </div> \n" +
                "  </header> \n" +
                "  <section class=\"main\" id=\"main\"> \n" +
                "   <div class=\"container\"> \n" +
                "    <div class=\"main-text\"> \n" +
                "     <div class=\"rich-text\">\n" +
                "      <p>Шановний учасник єдиної в Україні програми соціально-правового захисту учасників бойових дій \"Соціальна картка учасника АТО \"Українці-Разом!\", Вас запрошено до користування додатком пільг і привілеїв Woodoos, що надане Вам всеукраїнською організацією \"Українці-Разом!\".</p>\n" +
                "     </div> <a class=\"btn\" href=\"\" style=\"pointer-events: none\">БУДЬТЕ НА ЗВ’ЯЗКУ І ОТРИМУЙТЕ ПЕРЕВАГИ</a> \n" +
                "     <div class=\"rich-text\">\n" +
                "      <p>Додаток надає Вам можливість бути на постійному зв'язку з \"Українці-Разом!\", отримувати їхні повідомлення. А ще цей Додаток зробить Ваші щоденні покупки більш вигідними, Ви отримаєте більше. Передплачуйте Ваші покупки у торгових мережах – наших партнерах прямо у Додатку і отримуйте при цьому миттєву ВИГОДУ.</p>\n" +
                "     </div> <a class=\"btn\" href=\"\" style=\"pointer-events: none\">КУПУЙТЕ ВИГІДНО КОЖНОГО РАЗУ</a> \n" +
                "     <div class=\"rich-text\">\n" +
                "      <p>Почнемо? Треба скачати Додаток Woodoos на AppStore або Play Market і зареєструватись в ньому із тим номером мобільного, на який Ви отримали від нас запрошення. З цього моменту Ви – повноправний учасник програми, можете додавати Вашу платіжну картку і постійно отримувати ВИГОДУ, купуючи потрібні Вам товари. Ваші платіжні дані дбайливо і безпечно оброблюються обслуговуючим банком – ПАТ «Альфа-Банк Україна» за найвищими стандартами фінансової безпеки, за їх збереження можна не хвилюватись. Доступу до них немає ані у нас, ані навіть у \"Українці-Разом!\"<b>.<br></b></p>\n" +
                "      <p></p>\n" +
                "      <p><b><br></b></p>\n" +
                "      <p>Додаткова інформація на сайті об'єднання \"Українці-Разом!\" <a href=\"https://www.ukrazom.org/\">ukrazom.org</a> &nbsp; Для отримання картки потрібно зареєструватися на сайті <a href=\"https://kartka.ukrazom.org/\">kartka.ukrazom.org</a></p>\n" +
                "      <p>Зразок картки учасника об'єднання \"Українці-Разом!\"<br><br></p>\n" +
                "      <p></p>\n" +
                "      <img alt=\"mobile_file_2020-07-24_12-59-58.jpg\" class=\"richtext-image\" height=\"352\" src=\"https://begemot-app.s3.amazonaws.com/images/mobile_file_2020-07-24_12-59-58.width-800.jpg\" style=\"width:90%;object-fit: contain;\">\n" +
                "      <p></p>\n" +
                "      <p></p>\n" +
                "      <p></p>\n" +
                "      <p></p>\n" +
                "     </div> <!--\n" +
                "             <p>Шановний учасник програми підтримки співробітників  <a href=\"#\">НАЗВА КОМПАНІЇ АБО ПРОГРАМИ</a> , Вас запрошено до користування додатком пільг і привілеїв Woodoos, що надано Вам  <a href=\"#\">НАЗВА КОМПАНІЇ АБО ПРОГРАМИ!</a> </p>\n" +
                "             <a class=\"btn\" href=\"#\">БУДЬТЕ НА ЗВ’ЯЗКУ\n" +
                "                І ОТРИМУЙТЕ ПЕРЕВАГИ</a>\n" +
                "                <p>Додаток надає Вам можливість бути на постійному зв'язку з  <a href=\"#\">НАЗВА КОМПАНІЇ АБО ПРОГРАМИ</a> , отримувати їхні повідомлення. А ще цей Додаток зробить Ваші щоденні покупки більш вигідними, Ви отримаєте більше. Передплачуйте Ваші покупки у торгових мережах – наших партнерах прямо у Додатку і отримуйте при цьому миттєву ВИГОДУ. </p>\n" +
                "                <a class=\"btn\" href=\"#\">КУПУЙТЕ ВИГІДНО\n" +
                "                    КОЖНОГО РАЗУ</a>\n" +
                "                <p>Почнемо? Треба скачати Додаток Woodoos на AppStore або Play Market і зареєструватись в ньому із тим номером мобільного, на який Ви отримали від нас запрошення. З цього моменту Ви – повноправний учасник програми, можете додавати Вашу платіжну картку і постійно отримувати ВИГОДУ, купуючи потрібні Вам товари. Ваші платіжні дані дбайливо і безпечно оброблюються обслуговуючим банком – ПАТ «Альфа-Банк Україна» за найвищими стандартами фінансової безпеки, за їх збереження можна не хвилюватись. Доступу до них немає ані у нас, ані навіть у <a href=\"#\">НАЗВА КОМПАНІЇ АБО ПРОГРАМИ.</a> </p>\n" +
                "              --> \n" +
                "    </div> \n" +
                "   </div> \n" +
                "  </section> \n" +
                "  <section class=\"link\"> \n" +
                "   <div class=\"container\"> \n" +
                "    <div class=\"link__inner\"> <a target=\"_blank\" href=\"https://apps.apple.com/ua/app/woodoos-ukraine/id1436127682?l=ru\"> <img src=\"../images/link/app-spore.jpg\" alt=\"\"> </a> <a target=\"_blank\" href=\"https://play.google.com/store/apps/details?id=com.ogloba.gc.affinity.mgc.android.ua\"> <img src=\"../images/link/google.jpg\" alt=\"\"> </a> <a target=\"_blank\" href=\"https://ua.woodoos.com/woodoos-ua/ukrazom/1_Public_offer_Woodoos_published_updated_280220.html\"> <img src=\"../images/link/Offerta.jpg\" alt=\"\"> </a> \n" +
                "    </div> \n" +
                "   </div> \n" +
                "  </section> \n" +
                "  <footer class=\"footer\"> \n" +
                "   <div class=\"container\"> \n" +
                "    <div class=\"footer__inner\"> \n" +
                "    </div> \n" +
                "   </div> \n" +
                "  </footer> \n" +
                "  <script src=\"https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js\"></script> \n" +
                "  <script src=\"../js/libs.min.js\"></script> \n" +
                "  <script src=\"../js/main.js\"></script>  \n" +
                " </body>\n" +
                "</html>";
    }
}
