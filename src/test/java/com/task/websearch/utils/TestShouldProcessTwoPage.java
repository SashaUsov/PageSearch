package com.task.websearch.utils;

import com.task.websearch.dto.InitialDataModel;

public class TestShouldProcessTwoPage {

    public static InitialDataModel getTestInitialModelForTwoLinkProcess() {
        return new InitialDataModel("https://ua.woodoos.com/woodoos-ua/ukrazom/", 2, "Українці", 2);
    }

    public static String getFirstMessage() {
        return "{\"id\":1,\"url\":\"https://ua.woodoos.com/woodoos-ua/ukrazom/\",\"status\":\"Upload\",\"processed\":false}";
    }

    public static String getSecondMessage() {
        return "{\"id\":1,\"url\":\"https://ua.woodoos.com/woodoos-ua/ukrazom/\",\"status\":\"Search started\",\"processed\":false}";
    }

    public static String getThirdMessage() {
        return "{\"id\":1,\"url\":\"https://ua.woodoos.com/woodoos-ua/ukrazom/\",\"status\":\"Found\",\"processed\":true}";
    }

    public static String getFourthMessage() {
        return "{\"id\":2,\"url\":\"https://www.ukrazom.org/\",\"status\":\"Upload\",\"processed\":false}";
    }

    public static String getFifthMessage() {
        return "{\"id\":2,\"url\":\"https://www.ukrazom.org/\",\"status\":\"Search started\",\"processed\":false}";
    }

    public static String getSixthMessage() {
        return "{\"id\":2,\"url\":\"https://www.ukrazom.org/\",\"status\":\"Found\",\"processed\":true}";
    }

    public static String getSecondPageBody() {
        return "<!doctype html>\n" +
                "<html lang=\"uk\" prefix=\"og: https://ogp.me/ns#\"> \n" +
                " <head> \n" +
                "  <meta charset=\"UTF-8\"> \n" +
                "  <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge,chrome=1\"> \n" +
                "  <meta name=\"viewport\" content=\"width=device-width, height=device-height, initial-scale=1\"> \n" +
                "  <title>Українці Разом - Всеукраїнське об'єднання учасників АТО</title> \n" +
                "  <link rel=\"icon\" type=\"image/png\" href=\"favicon.png\"> \n" +
                "  <link rel=\"shortcut icon\" type=\"image/x-icon\" href=\"https://www.ukrazom.org/wp-content/themes/ukrazom/favicon.png\"> \n" +
                "  <link rel=\"apple-touch-icon\" sizes=\"152x152\" href=\"https://www.ukrazom.org/wp-content/themes/ukrazom/appleico.png\"> \n" +
                "  <link rel=\"stylesheet\" href=\"https://www.ukrazom.org/wp-content/themes/ukrazom/resources/css/main.css\"> <!-- All in One SEO Pack 3.3.5 від Michael Torbert of Semper Fi Web Design[267,274] --> \n" +
                "  <meta name=\"description\" content=\"Всеукраїнське об'єднання небайдужих українців, яке було створено для допомоги бійцям, що беруть участь у антитерористичній операції на сході України\"> \n" +
                "  <script type=\"application/ld+json\" class=\"aioseop-schema\">{\"@context\":\"https://schema.org\",\"@graph\":[{\"@type\":\"Organization\",\"@id\":\"https://www.ukrazom.org/#organization\",\"url\":\"https://www.ukrazom.org/\",\"name\":\"\\u0423\\u043a\\u0440\\u0430\\u0457\\u043d\\u0446\\u0456 \\u0440\\u0430\\u0437\\u043e\\u043c\",\"sameAs\":[\"https://www.facebook.com/ukrazom.org\",\"https://twitter.com/ukrrazom\",\"https://t.me/ukrazom\"]},{\"@type\":\"WebSite\",\"@id\":\"https://www.ukrazom.org/#website\",\"url\":\"https://www.ukrazom.org/\",\"name\":\"\\u0423\\u043a\\u0440\\u0430\\u0457\\u043d\\u0446\\u0456 \\u0420\\u0430\\u0437\\u043e\\u043c\",\"publisher\":{\"@id\":\"https://www.ukrazom.org/#organization\"}},{\"@type\":\"WebPage\",\"@id\":\"https://www.ukrazom.org/#webpage\",\"url\":\"https://www.ukrazom.org/\",\"inLanguage\":\"uk\",\"name\":\"\\u0413\\u043e\\u043b\\u043e\\u0432\\u043d\\u0430 \\u0441\\u0442\\u043e\\u0440\\u0456\\u043d\\u043a\\u0430\",\"isPartOf\":{\"@id\":\"https://www.ukrazom.org/#website\"},\"image\":{\"@type\":\"ImageObject\",\"@id\":\"https://www.ukrazom.org/#primaryimage\",\"url\":\"https://www.ukrazom.org/wp-content/uploads/2021/01/IMG_7936-scaled-e1610825404827.jpg\",\"width\":2039,\"height\":1401},\"primaryImageOfPage\":{\"@id\":\"https://www.ukrazom.org/#primaryimage\"},\"datePublished\":\"2016-06-08T07:13:11+03:00\",\"dateModified\":\"2021-01-16T19:42:12+02:00\",\"about\":{\"@id\":\"https://www.ukrazom.org/#organization\"},\"description\":\"\\u0412\\u0441\\u0435\\u0443\\u043a\\u0440\\u0430\\u0457\\u043d\\u0441\\u044c\\u043a\\u0435 \\u043e\\u0431\\u2019\\u0454\\u0434\\u043d\\u0430\\u043d\\u043d\\u044f \\u043d\\u0435\\u0431\\u0430\\u0439\\u0434\\u0443\\u0436\\u0438\\u0445 \\u0443\\u043a\\u0440\\u0430\\u0457\\u043d\\u0446\\u0456\\u0432, \\u044f\\u043a\\u0435 \\u0431\\u0443\\u043b\\u043e \\u0441\\u0442\\u0432\\u043e\\u0440\\u0435\\u043d\\u043e \\u0434\\u043b\\u044f \\u0434\\u043e\\u043f\\u043e\\u043c\\u043e\\u0433\\u0438 \\u0431\\u0456\\u0439\\u0446\\u044f\\u043c, \\u0449\\u043e \\u0431\\u0435\\u0440\\u0443\\u0442\\u044c \\u0443\\u0447\\u0430\\u0441\\u0442\\u044c \\u0443 \\u0430\\u043d\\u0442\\u0438\\u0442\\u0435\\u0440\\u043e\\u0440\\u0438\\u0441\\u0442\\u0438\\u0447\\u043d\\u0456\\u0439 \\u043e\\u043f\\u0435\\u0440\\u0430\\u0446\\u0456\\u0457 \\u043d\\u0430 \\u0441\\u0445\\u043e\\u0434\\u0456 \\u0423\\u043a\\u0440\\u0430\\u0457\\u043d\\u0438\"}]}</script> \n" +
                "  <link rel=\"canonical\" href=\"https://www.ukrazom.org/\"> \n" +
                "  <meta property=\"og:type\" content=\"website\"> \n" +
                "  <meta property=\"og:title\" content=\"Українці Разом - Всеукраїнське об'єднання учасників АТО\"> \n" +
                "  <meta property=\"og:description\" content=\"Всеукраїнське об'єднання небайдужих українців, яке було створено для допомоги бійцям, що беруть участь у антитерористичній операції на сході України\"> \n" +
                "  <meta property=\"og:url\" content=\"https://www.ukrazom.org/\"> \n" +
                "  <meta property=\"og:site_name\" content=\"Українці разом\"> \n" +
                "  <meta property=\"og:image\" content=\"https://ukrazom.knopix.net/wp-content/uploads/2016/06/1_ukrayintsi-razom.png\"> \n" +
                "  <meta property=\"og:image:secure_url\" content=\"https://ukrazom.knopix.net/wp-content/uploads/2016/06/1_ukrayintsi-razom.png\"> \n" +
                "  <meta name=\"twitter:card\" content=\"summary\"> \n" +
                "  <meta name=\"twitter:title\" content=\"Українці Разом - Всеукраїнське об'єднання учасників АТО\"> \n" +
                "  <meta name=\"twitter:description\" content=\"Всеукраїнське об'єднання небайдужих українців, яке було створено для допомоги бійцям, що беруть участь у антитерористичній операції на сході України\"> \n" +
                "  <meta name=\"twitter:image\" content=\"https://ukrazom.knopix.net/wp-content/uploads/2016/06/1_ukrayintsi-razom.png\"> <!-- All in One SEO Pack --> \n" +
                "  <link rel=\"dns-prefetch\" href=\"//s.w.org\"> \n" +
                "  <link rel=\"alternate\" type=\"application/rss+xml\" title=\"Українці Разом » Головна сторінка Канал коментарів\" href=\"https://www.ukrazom.org/sample-page/feed\"> \n" +
                "  <script type=\"text/javascript\">\n" +
                "\t\t\twindow._wpemojiSettings = {\"baseUrl\":\"https:\\/\\/s.w.org\\/images\\/core\\/emoji\\/12.0.0-1\\/72x72\\/\",\"ext\":\".png\",\"svgUrl\":\"https:\\/\\/s.w.org\\/images\\/core\\/emoji\\/12.0.0-1\\/svg\\/\",\"svgExt\":\".svg\",\"source\":{\"concatemoji\":\"https:\\/\\/www.ukrazom.org\\/wp-includes\\/js\\/wp-emoji-release.min.js?ver=5.3.6\"}};\n" +
                "\t\t\t!function(e,a,t){var r,n,o,i,p=a.createElement(\"canvas\"),s=p.getContext&&p.getContext(\"2d\");function c(e,t){var a=String.fromCharCode;s.clearRect(0,0,p.width,p.height),s.fillText(a.apply(this,e),0,0);var r=p.toDataURL();return s.clearRect(0,0,p.width,p.height),s.fillText(a.apply(this,t),0,0),r===p.toDataURL()}function l(e){if(!s||!s.fillText)return!1;switch(s.textBaseline=\"top\",s.font=\"600 32px Arial\",e){case\"flag\":return!c([127987,65039,8205,9895,65039],[127987,65039,8203,9895,65039])&&(!c([55356,56826,55356,56819],[55356,56826,8203,55356,56819])&&!c([55356,57332,56128,56423,56128,56418,56128,56421,56128,56430,56128,56423,56128,56447],[55356,57332,8203,56128,56423,8203,56128,56418,8203,56128,56421,8203,56128,56430,8203,56128,56423,8203,56128,56447]));case\"emoji\":return!c([55357,56424,55356,57342,8205,55358,56605,8205,55357,56424,55356,57340],[55357,56424,55356,57342,8203,55358,56605,8203,55357,56424,55356,57340])}return!1}function d(e){var t=a.createElement(\"script\");t.src=e,t.defer=t.type=\"text/javascript\",a.getElementsByTagName(\"head\")[0].appendChild(t)}for(i=Array(\"flag\",\"emoji\"),t.supports={everything:!0,everythingExceptFlag:!0},o=0;o<i.length;o++)t.supports[i[o]]=l(i[o]),t.supports.everything=t.supports.everything&&t.supports[i[o]],\"flag\"!==i[o]&&(t.supports.everythingExceptFlag=t.supports.everythingExceptFlag&&t.supports[i[o]]);t.supports.everythingExceptFlag=t.supports.everythingExceptFlag&&!t.supports.flag,t.DOMReady=!1,t.readyCallback=function(){t.DOMReady=!0},t.supports.everything||(n=function(){t.readyCallback()},a.addEventListener?(a.addEventListener(\"DOMContentLoaded\",n,!1),e.addEventListener(\"load\",n,!1)):(e.attachEvent(\"onload\",n),a.attachEvent(\"onreadystatechange\",function(){\"complete\"===a.readyState&&t.readyCallback()})),(r=t.source||{}).concatemoji?d(r.concatemoji):r.wpemoji&&r.twemoji&&(d(r.twemoji),d(r.wpemoji)))}(window,document,window._wpemojiSettings);\n" +
                "\t\t</script> \n" +
                "  <style type=\"text/css\">\n" +
                "img.wp-smiley,\n" +
                "img.emoji {\n" +
                "\tdisplay: inline !important;\n" +
                "\tborder: none !important;\n" +
                "\tbox-shadow: none !important;\n" +
                "\theight: 1em !important;\n" +
                "\twidth: 1em !important;\n" +
                "\tmargin: 0 .07em !important;\n" +
                "\tvertical-align: -0.1em !important;\n" +
                "\tbackground: none !important;\n" +
                "\tpadding: 0 !important;\n" +
                "}\n" +
                "</style> \n" +
                "  <link rel=\"stylesheet\" id=\"wp-block-library-css\" href=\"https://www.ukrazom.org/wp-includes/css/dist/block-library/style.min.css?ver=5.3.6\" type=\"text/css\" media=\"all\"> \n" +
                "  <link rel=\"stylesheet\" id=\"dashicons-css\" href=\"https://www.ukrazom.org/wp-includes/css/dashicons.min.css?ver=5.3.6\" type=\"text/css\" media=\"all\"> \n" +
                "  <link rel=\"stylesheet\" id=\"post-views-counter-frontend-css\" href=\"https://www.ukrazom.org/wp-content/plugins/post-views-counter/css/frontend.css?ver=1.3.1\" type=\"text/css\" media=\"all\"> \n" +
                "  <link rel=\"stylesheet\" id=\"ssb-front-css-css\" href=\"https://www.ukrazom.org/wp-content/plugins/simple-social-buttons/assets/css/front.css?ver=3.1.1\" type=\"text/css\" media=\"all\"> \n" +
                "  <link rel=\"stylesheet\" id=\"tablepress-default-css\" href=\"https://www.ukrazom.org/wp-content/plugins/tablepress/css/default.min.css?ver=1.10\" type=\"text/css\" media=\"all\"> \n" +
                "  <script type=\"text/javascript\" src=\"https://www.ukrazom.org/wp-includes/js/jquery/jquery.js?ver=1.12.4-wp\"></script> \n" +
                "  <script type=\"text/javascript\" src=\"https://www.ukrazom.org/wp-includes/js/jquery/jquery-migrate.min.js?ver=1.4.1\"></script> \n" +
                "  <script type=\"text/javascript\" src=\"https://www.ukrazom.org/wp-content/plugins/simple-social-buttons/assets/js/front.js?ver=3.1.1\"></script> \n" +
                "  <link rel=\"https://api.w.org/\" href=\"https://www.ukrazom.org/wp-json/\"> \n" +
                "  <link rel=\"EditURI\" type=\"application/rsd+xml\" title=\"RSD\" href=\"https://www.ukrazom.org/xmlrpc.php?rsd\"> \n" +
                "  <link rel=\"wlwmanifest\" type=\"application/wlwmanifest+xml\" href=\"https://www.ukrazom.org/wp-includes/wlwmanifest.xml\"> \n" +
                "  <meta name=\"generator\" content=\"WordPress 5.3.6\"> \n" +
                "  <link rel=\"shortlink\" href=\"https://www.ukrazom.org/\"> \n" +
                "  <link rel=\"alternate\" type=\"application/json+oembed\" href=\"https://www.ukrazom.org/wp-json/oembed/1.0/embed?url=https%3A%2F%2Fwww.ukrazom.org%2F\"> \n" +
                "  <link rel=\"alternate\" type=\"text/xml+oembed\" href=\"https://www.ukrazom.org/wp-json/oembed/1.0/embed?url=https%3A%2F%2Fwww.ukrazom.org%2F&amp;format=xml\"> \n" +
                "  <style media=\"screen\">\n" +
                "\n" +
                "\t\t.simplesocialbuttons.simplesocialbuttons_inline .ssb-fb-like {\n" +
                "\t  margin: ;\n" +
                "\t}\n" +
                "\t\t /*inline margin*/\n" +
                "\t\n" +
                "\t\n" +
                "\t\n" +
                "\t\n" +
                "\t\n" +
                "\t\n" +
                "\t\t\t .simplesocialbuttons.simplesocialbuttons_inline.simplesocial-simple-icons button{\n" +
                "\t\t margin: ;\n" +
                "\t }\n" +
                "\n" +
                "\t\t\t /*margin-digbar*/\n" +
                "\n" +
                "\t\n" +
                "\t\n" +
                "\t\n" +
                "\t\n" +
                "\t\n" +
                "\t\n" +
                "\t\n" +
                "</style> <!-- Open Graph Meta Tags generated by Simple Social Buttons 3.1.1 --> \n" +
                "  <meta property=\"og:title\" content=\"Головна сторінка - Українці Разом\"> \n" +
                "  <meta property=\"og:description\" content=\"СЛАВА УКРАЇНІ!\n" +
                "Шановні побратими, просимо вибачення за тимчасові незручності з видачею соціальних карток учасників АТО.\n" +
                "Звертаємо вашу увагу, що представниками УКРАЇНЦІ-РАЗОМ! є такі самі волонтери та учасники АТО/ООС, як і ви, які допомагають виключно на добровільних засадах. У вільний час від роботи та постійних поїздок в зону ООС, вони ще знаходять сили, щоб допомагати своїм побратимам отримати картки. Дуже велика кількість бажаючих\"> \n" +
                "  <meta property=\"og:url\" content=\"https://www.ukrazom.org/\"> \n" +
                "  <meta property=\"og:site_name\" content=\"Українці Разом\"> \n" +
                "  <meta property=\"og:image\" content=\"https://www.ukrazom.org/wp-content/uploads/2021/01/IMG_7936-scaled-e1610825404827.jpg\"> \n" +
                "  <meta name=\"twitter:card\" content=\"summary_large_image\"> \n" +
                "  <meta name=\"twitter:description\" content=\"СЛАВА УКРАЇНІ!\n" +
                "Шановні побратими, просимо вибачення за тимчасові незручності з видачею соціальних карток учасників АТО.\n" +
                "Звертаємо вашу увагу, що представниками УКРАЇНЦІ-РАЗОМ! є такі самі волонтери та учасники АТО/ООС, як і ви, які допомагають виключно на добровільних засадах. У вільний час від роботи та постійних поїздок в зону ООС, вони ще знаходять сили, щоб допомагати своїм побратимам отримати картки. Дуже велика кількість бажаючих\"> \n" +
                "  <meta name=\"twitter:title\" content=\"Головна сторінка - Українці Разом\"> \n" +
                "  <meta property=\"twitter:image\" content=\"https://www.ukrazom.org/wp-content/uploads/2021/01/IMG_7936-scaled-e1610825404827.jpg\"> \n" +
                "  <link rel=\"icon\" href=\"https://www.ukrazom.org/wp-content/uploads/2016/06/cropped-1_ukrayintsi-razom-400x400.png\" sizes=\"32x32\"> \n" +
                "  <link rel=\"icon\" href=\"https://www.ukrazom.org/wp-content/uploads/2016/06/cropped-1_ukrayintsi-razom-400x400.png\" sizes=\"192x192\"> \n" +
                "  <link rel=\"apple-touch-icon-precomposed\" href=\"https://www.ukrazom.org/wp-content/uploads/2016/06/cropped-1_ukrayintsi-razom-400x400.png\"> \n" +
                "  <meta name=\"msapplication-TileImage\" content=\"https://www.ukrazom.org/wp-content/uploads/2016/06/cropped-1_ukrayintsi-razom-400x400.png\"> \n" +
                " </head> \n" +
                " <body> \n" +
                "  <header> \n" +
                "   <div class=\"main-content\"> \n" +
                "    <div class=\"box p20-0 header-phone-block r\"> <i class=\"l block icon-default ico-phone\"></i> Безкоштовна гаряча лінія \n" +
                "     <br> <a href=\"tel:0800507575\" class=\"no-decor\">0 800 <span class=\"thick-font\">50 7575</span></a> \n" +
                "     <br>\n" +
                "     <br>\n" +
                "     <br> <!--     <a href=\"https://www.ukrazom.org/contacts#address\" class=\"no-decor\">\n" +
                "                    <i class=\"l block icon-default ico-point\"></i>\n" +
                "                    вул. Саксаганського 143-а,<br>\n" +
                "                    м. Київ\n" +
                "\t            </a>  --> \n" +
                "    </div> <a href=\"https://www.ukrazom.org\" class=\"logo block\"></a> \n" +
                "    <div class=\"menu-block-cover\"> \n" +
                "     <nav class=\"menu\"> \n" +
                "      <ul id=\"menu-verhnye-menyu\" class=\"\">\n" +
                "       <li id=\"menu-item-10\" class=\"menu-item menu-item-type-post_type menu-item-object-page menu-item-home current-menu-item page_item page-item-2 current_page_item menu-item-has-children menu-item-10 active \"><a href=\"https://www.ukrazom.org/\" aria-current=\"page\">Головна</a> \n" +
                "        <ul class=\"sub-menu\"> \n" +
                "         <li id=\"menu-item-18\" class=\"menu-item menu-item-type-post_type menu-item-object-page menu-item-18\"><a href=\"https://www.ukrazom.org/about\">Про нас</a></li> \n" +
                "         <li id=\"menu-item-417\" class=\"menu-item menu-item-type-taxonomy menu-item-object-category menu-item-417\"><a href=\"https://www.ukrazom.org/media\">ЗМІ про нас</a></li> \n" +
                "        </ul> </li> \n" +
                "       <li id=\"menu-item-21\" class=\"menu-item menu-item-type-post_type menu-item-object-page menu-item-has-children menu-item-21\"><a href=\"https://www.ukrazom.org/social-card\">Соціальна картка</a> \n" +
                "        <ul class=\"sub-menu\"> \n" +
                "         <li id=\"menu-item-945\" class=\"menu-item menu-item-type-custom menu-item-object-custom menu-item-945\"><a href=\"https://goo.gl/SG8ysH\">Отримати картку</a></li> \n" +
                "         <li id=\"menu-item-2035\" class=\"menu-item menu-item-type-post_type menu-item-object-post menu-item-2035\"><a href=\"https://www.ukrazom.org/news/yak-aktyvuvaty-sotsialnu-kartku-uchasnyka-ato-ukrayintsi-razom\">Як активувати картку</a></li> \n" +
                "         <li id=\"menu-item-1590\" class=\"menu-item menu-item-type-custom menu-item-object-custom menu-item-has-children menu-item-1590\"><a href=\"https://www.ukrazom.org/news/uchasnykam-bojovyh-dij-potribna-dopomoga-kozhnogo-ukrayintsya-2\">Допомога війсковим</a> \n" +
                "          <ul class=\"sub-menu\"> \n" +
                "           <li id=\"menu-item-11\" class=\"menu-item menu-item-type-post_type menu-item-object-page menu-item-11\"><a href=\"https://www.ukrazom.org/military-needs\">Потреби військових</a></li> \n" +
                "           <li id=\"menu-item-182\" class=\"menu-item menu-item-type-taxonomy menu-item-object-category menu-item-182\"><a href=\"https://www.ukrazom.org/statements\">Звіти про допомогу</a></li> \n" +
                "          </ul> </li> \n" +
                "         <li id=\"menu-item-949\" class=\"menu-item menu-item-type-post_type menu-item-object-page menu-item-949\"><a href=\"https://www.ukrazom.org/staty-volonterom\">Стати волонтером</a></li> \n" +
                "         <li id=\"menu-item-1594\" class=\"menu-item menu-item-type-post_type menu-item-object-page menu-item-1594\"><a href=\"https://www.ukrazom.org/dopomoga\">Отримати допомогу</a></li> \n" +
                "        </ul> </li> \n" +
                "       <li id=\"menu-item-1588\" class=\"menu-item menu-item-type-custom menu-item-object-custom menu-item-1588\"><a target=\"_blank\" rel=\"noopener noreferrer\" href=\"https://ukrazom.org/contacts2\">Правова допомога</a></li> \n" +
                "       <li id=\"menu-item-13\" class=\"menu-item menu-item-type-taxonomy menu-item-object-category menu-item-has-children menu-item-13\"><a href=\"https://www.ukrazom.org/news\">Новини</a> \n" +
                "        <ul class=\"sub-menu\"> \n" +
                "         <li id=\"menu-item-2757\" class=\"menu-item menu-item-type-taxonomy menu-item-object-category menu-item-2757\"><a href=\"https://www.ukrazom.org/news/partners\">Партнери</a></li> \n" +
                "         <li id=\"menu-item-2758\" class=\"menu-item menu-item-type-taxonomy menu-item-object-category menu-item-2758\"><a href=\"https://www.ukrazom.org/news/actions\">Акції</a></li> \n" +
                "         <li id=\"menu-item-2777\" class=\"menu-item menu-item-type-post_type menu-item-object-page menu-item-2777\"><a href=\"https://www.ukrazom.org/dusha-ridnoyi-zemli\">Благодійні концерти</a></li> \n" +
                "        </ul> </li> \n" +
                "       <li id=\"menu-item-2516\" class=\"menu-item menu-item-type-post_type menu-item-object-page menu-item-has-children menu-item-2516\"><a href=\"https://www.ukrazom.org/our-partners\">Партнери</a> \n" +
                "        <ul class=\"sub-menu\"> \n" +
                "         <li id=\"menu-item-1990\" class=\"menu-item menu-item-type-custom menu-item-object-custom menu-item-1990\"><a href=\"https://kartka.ukrazom.org/partners\">Наші партнери</a></li> \n" +
                "         <li id=\"menu-item-2779\" class=\"menu-item menu-item-type-custom menu-item-object-custom menu-item-2779\"><a href=\"https://kartka.ukrazom.org/newpartner\">Стати партнером</a></li> \n" +
                "        </ul> </li> \n" +
                "       <li id=\"menu-item-17\" class=\"menu-item menu-item-type-post_type menu-item-object-page menu-item-has-children menu-item-17\"><a href=\"https://www.ukrazom.org/contacts\">Контакти</a> \n" +
                "        <ul class=\"sub-menu\"> \n" +
                "         <li id=\"menu-item-1500\" class=\"menu-item menu-item-type-post_type menu-item-object-page menu-item-1500\"><a href=\"https://www.ukrazom.org/contacts-card\">Координати центрів по видачі соціальних карток</a></li> \n" +
                "         <li id=\"menu-item-1493\" class=\"menu-item menu-item-type-post_type menu-item-object-page menu-item-1493\"><a href=\"https://www.ukrazom.org/contacts2\">Контакти центрів з надання безоплатної вторинної правової допомоги</a></li> \n" +
                "         <li id=\"menu-item-1498\" class=\"menu-item menu-item-type-post_type menu-item-object-page menu-item-1498\"><a href=\"https://www.ukrazom.org/contacts-partners\">Контакти керівників обласних та районних осередків по підключенню партнерів</a></li> \n" +
                "         <li id=\"menu-item-1724\" class=\"menu-item menu-item-type-post_type menu-item-object-page menu-item-1724\"><a href=\"https://www.ukrazom.org/hochu-staty-regionalnym-kerivnykom-ukrayintsi-razom\">Хочу стати регіональним керівником “Українці-Разом”</a></li> \n" +
                "        </ul> </li> \n" +
                "      </ul> \n" +
                "     </nav> \n" +
                "    </div> \n" +
                "    <div class=\"ico-nav pointer abs middle\"> \n" +
                "     <div class=\"ico-line\"></div> \n" +
                "     <div class=\"ico-line\"></div> \n" +
                "     <div class=\"ico-line\"></div> \n" +
                "    </div> \n" +
                "    <div class=\"clear\"></div> \n" +
                "   </div> \n" +
                "  </header> \n" +
                "  <main> \n" +
                "   <section class=\"main-top-block center white-text\" style=\"background-image: url('https://www.ukrazom.org/wp-content/uploads/2021/01/IMG_7936-scaled-e1610825404827.jpg');\"> \n" +
                "    <div class=\"main-top-block-text\"> \n" +
                "     <div class=\"p20-0 m-b30\"> \n" +
                "      <h1 class=\"h1 title-font\">Українці Разом!</h1> \n" +
                "      <h2>Всеукраїнське об'єднання учасників АТО</h2> \n" +
                "     </div> \n" +
                "     <div class=\"main-top-block-text p40-0\"> \n" +
                "      <h2 class=\"title-font m-b10\"><b>Про організацію</b></h2> \n" +
                "      <p class=\"small-content text-left\"> «Українці-Разом!» – Всеукраїнське об’єднання небайдужих українців, яке було створено для допомоги бійцям, що беруть участь у антитерористичній операції на сході України. Основна мета організації – допомогти воїнам на фронті, а також надати соціальний захист учасникам АТО та їх сім’ям.<br> <br> У своїх лавах ми об'єднуємо більше 250 тис. учасників та маємо свої філії в усіх областях України. \"Українці-Разом!\" – це об’єднання однодумців, які прагнуть своїми рішучими діями допомогти іншим та змінити долю України та Українців на краще. </p> <a href=\"https://www.ukrazom.org/staty-volonterom\" class=\"btn inline-block m-t40 m-b30\">Стати волонтером</a> &nbsp; <a href=\"https://kartka.ukrazom.org\" target=\"_blank\" class=\"btn inline-block\">Отримати картку учасника АТО/ООС</a> \n" +
                "      <br> <a href=\"https://www.ukrazom.org/about\" class=\"center white-text\">Дізнатися більше</a> \n" +
                "     </div> \n" +
                "    </div> \n" +
                "   </section> \n" +
                "   <section> \n" +
                "    <div class=\"main-content p40-0\"> \n" +
                "     <h2 class=\"title-font red-text center m-b40\"><b>Останні новини</b></h2> \n" +
                "     <div class=\"main-last-new\"> <a href=\"https://www.ukrazom.org/news/z-novym-rokom-ta-rizdvyanymy-svyatamy-vid-ukrayintsi-razom\" class=\"main-last-new-img block m-b10\" style=\"background-image: url('https://www.ukrazom.org/wp-content/uploads/2019/12/new_year_wp2.jpg');\" title=\"\"></a> <a href=\"https://www.ukrazom.org/news/z-novym-rokom-ta-rizdvyanymy-svyatamy-vid-ukrayintsi-razom\" class=\"invert-link main-last-new-title block cover\"><h3 class=\"title-font\">З Новим Роком та Різдвяними святами від “Українці-Разом!”</h3></a> \n" +
                "      <p class=\"gray-text m-b10\">31.12.2020 | <a href=\"https://www.ukrazom.org/author/ukrazom\" title=\"Записи автора УКРАЇНЦІ РАЗОМ\" rel=\"author\">УКРАЇНЦІ РАЗОМ</a></p> Шановні УКРАЇНЦІ! Дорогі побратими та посестри! Щиро вітаємо всіх вас з новорічними та різдвяними святами! Бажаємо в Новому Році міцного здоров’я, сімейного благополуччя, здійснення мрій, нових досягнень, гарного настрою та ПЕРЕМОГИ на всіх життєвих фронтах! \uD83C\uDF84 В цьому році&nbsp;ваш проект&nbsp;“Українці-Разом!”&nbsp;ріс та розвивався завдяки вашій участі та підтримці. За останній час... \n" +
                "      <br> \n" +
                "      <p><a class=\"red-text\" href=\"https://www.ukrazom.org/news/z-novym-rokom-ta-rizdvyanymy-svyatamy-vid-ukrayintsi-razom\">Читати далі</a></p> \n" +
                "     </div> \n" +
                "     <div class=\"main-last-new\"> <a href=\"https://www.ukrazom.org/news/programa-sotsialna-karta-uchasnykiv-ato-teper-diye-i-v-internet-magazyni-epicentrk-ua\" class=\"main-last-new-img block m-b10\" style=\"background-image: url('https://www.ukrazom.org/wp-content/uploads/2019/12/news12-400x268.jpg');\" title=\"\"></a> <a href=\"https://www.ukrazom.org/news/programa-sotsialna-karta-uchasnykiv-ato-teper-diye-i-v-internet-magazyni-epicentrk-ua\" class=\"invert-link main-last-new-title block cover\"><h3 class=\"title-font\">Програма «Соціальна карта учасників АТО» тепер діє і в інтернет-магазині epicentrk.ua</h3></a> \n" +
                "      <p class=\"gray-text m-b10\">30.12.2020 | <a href=\"https://www.ukrazom.org/author/ukrazom\" title=\"Записи автора УКРАЇНЦІ РАЗОМ\" rel=\"author\">УКРАЇНЦІ РАЗОМ</a></p> Запрошуємо власників соціальних карток учасника АТО до торговельних центрів «Епіцентр» здійснювати покупки необхідних їм товарів та послуг з економією до 7%. Ініціатором соціальної карти є Всеукраїнське об’єднання учасників АТО «Українці – Разом!» . Відтепер власники «Соціальної картки учасника АТО “Українці-Разом”»! мають змогу здійснювати покупки й отримувати економію 7%* на різні... \n" +
                "      <br> \n" +
                "      <p><a class=\"red-text\" href=\"https://www.ukrazom.org/news/programa-sotsialna-karta-uchasnykiv-ato-teper-diye-i-v-internet-magazyni-epicentrk-ua\">Читати далі</a></p> \n" +
                "     </div> \n" +
                "     <div class=\"main-last-new\"> <a href=\"https://www.ukrazom.org/news/majzhe-na-milyard-gryven-dopomogy-otrymaly-zahysnyky-ukrayiny-vid-partneriv-ukrayintsi-razom\" class=\"main-last-new-img block m-b10\" style=\"background-image: url('https://www.ukrazom.org/wp-content/uploads/2020/12/GL_DSC_7182.png');\" title=\"\"></a> <a href=\"https://www.ukrazom.org/news/majzhe-na-milyard-gryven-dopomogy-otrymaly-zahysnyky-ukrayiny-vid-partneriv-ukrayintsi-razom\" class=\"invert-link main-last-new-title block cover\"><h3 class=\"title-font\">Майже на МІЛЬЯРД гривень допомоги отримали Захисники України від партнерів УКРАЇНЦІ РАЗОМ!</h3></a> \n" +
                "      <p class=\"gray-text m-b10\">11.12.2020 | <a href=\"https://www.ukrazom.org/author/ukrazom\" title=\"Записи автора УКРАЇНЦІ РАЗОМ\" rel=\"author\">УКРАЇНЦІ РАЗОМ</a></p> «Українці-Разом!» – Всеукраїнське об’єднання ветеранів російсько-української війни, волонтерів АТО/ООС, представників соціально-відповідального бізнесу, підприємців та небайдужих українців, яке було створено в&nbsp;2014 році з початком російсько-української війни для допомоги бійцям, що беруть участь в антитерористичній операції (операції об’єднаних сил) на сході України та членам їх сімей. Основна мета організації – допомогти воїнам... \n" +
                "      <br> \n" +
                "      <p><a class=\"red-text\" href=\"https://www.ukrazom.org/news/majzhe-na-milyard-gryven-dopomogy-otrymaly-zahysnyky-ukrayiny-vid-partneriv-ukrayintsi-razom\">Читати далі</a></p> \n" +
                "     </div> \n" +
                "     <div class=\"clear center\"> <a class=\"btn inline-block m-t20 w150\" href=\"https://www.ukrazom.org/news\">Всі новини</a> \n" +
                "     </div> \n" +
                "    </div> \n" +
                "   </section> \n" +
                "   <section> \n" +
                "    <div class=\"main-content p40-0 cover\"> \n" +
                "     <h2 class=\"title-font red-text center m-b40\"><b>Соціальна картка</b></h2> \n" +
                "     <div class=\"video-cover\"> <iframe src=\"https://www.youtube.com/embed/C4CB_HOMfOY\" frameborder=\"0\" allowfullscreen></iframe> \n" +
                "     </div> \n" +
                "     <div class=\"video-text\"> \n" +
                "      <p> <b>Видано:&nbsp;<span class=\"red-text\">254889</span></b>&nbsp;карток </p> \n" +
                "      <p> <b>Зареєстровано:&nbsp;<span class=\"red-text\">281336</span></b>&nbsp;учасників </p> \n" +
                "      <p>За ініціативою Всеукраїнського Об’єднання учасників АТО “УКРАЇНЦІ-РАЗОМ!”створено програму “Соціальна картка учасника АТО”, яка дозволяє учасникам бойових дій на сході України та членам їх сімей бути цілодобово захищеними та отримувати необхідну допомогу.<br> На сьогодні це єдина всеукраїнська соціально-правова програма допомоги учасникам бойових дій \"СОЦІАЛЬНА КАРТКА УЧАСНИКА АТО\" за підтримки Державної Служби України у справах ветеранів війни та учасників АТО, Міністерства Оборони України, Національної Гвардії України, Служби Безпеки України, Державної Прикордонної Служби України, соціально відповідального бізнесу. <br> «Соціальна картка учасника АТО \"УКРАЇНЦІ-РАЗОМ!\"» є інструментом, що за допомогою відповідного програмно-технологічного забезпечення дозволяє кожному власнику отримувати певний перелік можливостей.</p> \n" +
                "      <p><a href=\"https://www.ukrazom.org/social-card\" class=\"red-text\">Дізнатися більше</a></p> \n" +
                "     </div> \n" +
                "     <div class=\"center clear\"> <a href=\"http://kartka.ukrazom.org\" target=\"_blank\" class=\"btn inline-block m-t20 m-b20\">Замовити картку</a> <a href=\"http://kartka.ukrazom.org\" target=\"_blank\" class=\"btn inline-block m-t20 m-b20\">Увійти у власний кабінет</a> <!--\t<a href=\"https://kartka.ukrazom.org/?anketa=&profile_status=8\" target=\"_blank\" class=\"btn inline-block\">Стати регіональним представником</a> --> <a href=\"http://kartka.ukrazom.org\" target=\"_blank\" class=\"btn inline-block m-t20 m-b20\">Активувати картку</a> \n" +
                "      <br> <a href=\"https://www.ukrazom.org/partners-join\" class=\"center\">Стати партнером</a> \n" +
                "     </div> \n" +
                "    </div> \n" +
                "   </section> \n" +
                "   <section class=\"bg-light-gray\"> \n" +
                "    <div class=\"main-content p40-0 cover\"> \n" +
                "     <h2 class=\"title-font red-text center m-b40\"><b>Футбольна ліга учасників АТО</b></h2> \n" +
                "     <div> \n" +
                "      <div class=\"football-logo\"> \n" +
                "       <img src=\"https://www.ukrazom.org/wp-content/themes/ukrazom/resources/img/federaciya_football_ATO_small_red.png\"> \n" +
                "      </div> \n" +
                "      <p>Футбольна ліга учасників АТО - це регулярний турнір з футболу, який офіційно входить до складу змагань за підтримки Федерації футболу України та Федерації футболу м.Києва. Організатором турнірів виступає громадське об’єднання учасників АТО «Українці Разом!».</p> \n" +
                "      <p class=\"football-url\"><a href=\"http://football.ukrazom.org\" class=\"red-text\">Сайт ліги учасників АТО</a></p> \n" +
                "     </div> \n" +
                "    </div> \n" +
                "   </section> \n" +
                "   <section class=\"bg-light-gray\"> \n" +
                "    <div class=\"main-content p40-0 cover center\"> \n" +
                "     <p style=\"text-align: center;\"><span style=\"color: #9d0b0e; font-size: 14pt;\"><strong>СЛАВА УКРАЇНІ!</strong></span></p> \n" +
                "     <p style=\"text-align: center;\"><span style=\"color: #9d0b0e; font-size: 14pt;\"><strong>Шановні побратими, просимо вибачення за тимчасові незручності з видачею соціальних карток учасників АТО.</strong></span></p> \n" +
                "     <p style=\"text-align: center;\"><strong>Звертаємо вашу увагу, що представниками УКРАЇНЦІ-РАЗОМ! є такі самі волонтери та учасники АТО/ООС, як і ви, які допомагають виключно на добровільних засадах. У вільний час від роботи та постійних поїздок в зону ООС, вони ще знаходять сили, щоб допомагати своїм побратимам отримати картки. Дуже велика кількість бажаючих отримати адресну пряму допомогу у вигляді соціальних карток призводить до збільшення терміну опрацювання інформації. УВАГА! </strong><strong>У зв”язку з пандемією в країні рекомендуємо уникати зайвих контактів і замовляти доставку своєї картки Новою Поштою за посиланням <a href=\"https://kartka.ukrazom.org/np\">kartka.ukrazom.org/np</a></strong><br><span style=\"font-size: 13pt;\"><strong>Працюємо над поліпшенням та прискоренням роботи. Щиро дякуємо за розуміння.</strong></span></p> \n" +
                "     <p style=\"text-align: center;\">Напишіть ваші питання в <a href=\"https://kartka.ukrazom.org/help\" target=\"_blank\" rel=\"noopener noreferrer\">нашу техпідтримку</a></p> \n" +
                "     <p>&nbsp;</p> \n" +
                "     <p><span style=\"font-size: 14pt;\"><strong>Потребуємо вашої допомоги у підключенні нових партнерів-підприємців (надавати знижки на свої товари та послуги) до нашої програми “Соціальна картка учасника АТО” у ваших населених пунктах!</strong></span></p> \n" +
                "     <p style=\"text-align: left;\">Звертаємося до всіх порядних, небайдужих, політично незаангажованих учасників АТО, членів їх сімей та волонтерів! До нас щодня надходить велика кількість заявок-побажань на розширення послуг програми “Соціальної картки учасника АТО “УКРАЇНЦІ-РАЗОМ!”. Тому потребуємо вашої допомоги у підключенні нових партнерів-підприємців (кожен бажаючий добровільно може долучитися і надавати знижки на свої товари та послуги) у ваших населених пунктах (областях, районах, містах, селах, селищах, смт), щоб наша спільна допомога дійшла кожному учаснику АТО/ООС та його родині. Додаткова інформація за посиланням <a href=\"https://kartka.ukrazom.org/newpartners\">kartka.ukrazom.org/newpartners</a></p> \n" +
                "     <p>&nbsp;</p> \n" +
                "    </div> \n" +
                "   </section> \n" +
                "  </main> \n" +
                "  <footer class=\"bg-dark\"> \n" +
                "   <div class=\"main-content p30-0\"> \n" +
                "    <div class=\"white-text footer-left\">\n" +
                "      © 2014-2020 Всеукраїнське об'єднання учасників АТО \"Українці разом!\". ВОУ АТО \"Українці-Разом!\" дозволяє вiльне використання матерiалiв сайту за наступних умов: збереження логотипу на зображеннях; вiдео має бути в плеєрі YouTube; в тексті - клікабельний прямий URL на сторінку, матеріали якої використані. \n" +
                "    </div> \n" +
                "    <div class=\"white-text center footer-center\">\n" +
                "      Ми в соціальних мережах:&nbsp; <a target=\"_blank\" href=\"https://www.facebook.com/ukrazom.org\" class=\"soc-icon inline-block v-middle rel\"> <i class=\"icon-default abs ico-soc-fb white\"></i> <i class=\"icon-default abs ico-soc-fb red\"></i> </a> <!--  <a target=\"_bank\" href=\"https://plus.google.com/u/0/+%D0%A3%D0%BA%D1%80%D0%B0%D1%97%D0%BD%D1%86%D1%96%D0%A0%D0%B0%D0%B7%D0%BE%D0%BC\" class=\"soc-icon inline-block v-middle rel\">\n" +
                "\t\t\t<img src=\"//ssl.gstatic.com/images/icons/gplus-32.png\" alt=\"Google+\" style=\"border:0;width:22px;height:22px;\"/>\n" +
                "                    <!--i class=\"icon-default abs ico-soc-vk white\"></i>\n" +
                "                    <i class=\"icon-default abs ico-soc-vk red\"></i\n" +
                "                </a> --> <a target=\"_blank\" href=\"https://twitter.com/ukrazom\" class=\"soc-icon inline-block v-middle rel\"> <i class=\"icon-default abs ico-soc-tw white\"></i> <i class=\"icon-default abs ico-soc-tw red\"></i> </a> <a target=\"_blank\" href=\"https://t.me/ukrazom\" class=\"soc-icon inline-block v-middle rel\"> <img src=\"https://ukrazom.org/wp-content/uploads/2019/03/06.png\" alt=\"Telegram\" style=\"border:0;width:22px;height:22px;\"> <!-- <i class=\"icon-default abs ico-soc-tg white\"></i>\n" +
                "                    <i class=\"icon-default abs ico-soc-tg red\"></i> --> </a> \n" +
                "    </div> \n" +
                "    <div class=\"gray-text footer-right\">\n" +
                "      Підтримка сайту <a href=\"http://web1nar.com\" class=\"knopix-logo gray-text\" target=\"_blank\">Вебинар.com</a> \n" +
                "    </div> \n" +
                "   </div> \n" +
                "  </footer> <a class=\"fixed-help-application\" href=\"https://www.ukrazom.org/donate\">Бажаю допомогти організації \"УКРАЇНЦІ-РАЗОМ!\"</a>  \n" +
                "  <div id=\"fb-root\"></div> \n" +
                "  <script>(function(d, s, id) {\n" +
                "\t\t\tvar js, fjs = d.getElementsByTagName(s)[0];\n" +
                "\t\t\tif (d.getElementById(id)) return;\n" +
                "\t\t\tjs = d.createElement(s); js.id = id;\n" +
                "\t\t\tjs.src = 'https://connect.facebook.net/en_US/sdk.js#xfbml=1&version=v2.11&appId=1158761637505872';\n" +
                "\t\t\tfjs.parentNode.insertBefore(js, fjs);\n" +
                "\t\t}(document, 'script', 'facebook-jssdk'));</script> \n" +
                "  <script type=\"text/javascript\" src=\"https://www.ukrazom.org/wp-content/themes/ukrazom/resources/js/common.js\"></script> \n" +
                "  <script type=\"text/javascript\" src=\"https://www.ukrazom.org/wp-includes/js/wp-embed.min.js?ver=5.3.6\"></script> \n" +
                "  <script type=\"text/javascript\">function initTwitCount(d,s,id){var js,fjs=d.getElementsByTagName(s)[0],p=/^http:/.test(d.location)?'http':'https';if(!d.getElementById(id)){js=d.createElement(s);js.id=id;js.src=p+'://static1.twitcount.com/js/twitcount.js';fjs.parentNode.insertBefore(js,fjs)}}\n" +
                "        var ssb_twit_count_init=!1;addEventListener('mouseover',function(event){if(!ssb_twit_count_init){initTwitCount(document,'script','twitcount_plugins')\n" +
                "        ssb_twit_count_init=!0}})</script><!-- Global site tag (gtag.js) - Google Analytics --> \n" +
                "  <script async src=\"https://www.googletagmanager.com/gtag/js?id=UA-38825739-2\"></script> \n" +
                "  <script>\n" +
                "  window.dataLayer = window.dataLayer || [];\n" +
                "  function gtag(){dataLayer.push(arguments);}\n" +
                "  gtag('js', new Date());\n" +
                "\n" +
                "  gtag('config', 'UA-38825739-2');\n" +
                "</script> \n" +
                " </body>\n" +
                "</html>";
    }
}
