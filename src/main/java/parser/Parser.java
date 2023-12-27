package parser;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;


public class Parser {
    public static void sentReq(String body) throws IOException {
        URL url = new URL("http://localhost:8080/base/add");

        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("POST");
        connection.setDoOutput(true);
        connection.setRequestProperty("Accept-Charset", "UTF-8");
        connection.setRequestProperty("Content-Type", "application/json;charset=" + "UTF-8");
        OutputStreamWriter writer = new OutputStreamWriter(connection.getOutputStream());
        writer.write(body);
        writer.flush();

        BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        String line;
        StringBuilder response = new StringBuilder();
        while ((line = reader.readLine()) != null) {
            response.append(line);
        }
        reader.close();
    }
    public static void main(String[] args) {
        ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
        Runnable task = new Runnable() {
            @Override
            public void run() {
                try {
                    Date currentDate = new Date();
                    SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
                    String date = formatter.format(currentDate);

                    //ГЛОБУС МОЛОКО
                    Elements[] elems = new Elements[3];
                    for (int i = 1; i < 10; i++) {
                        //страница
                        String page = "https://www.globus.ru/catalog/molochnye-produkty-syr-yaytsa/moloko-i-molochnye-produkty/moloko/" + "?page=" + i;
                        Document document = Jsoup.parse(new URL(page).openStream(), "UTF-8", page);
                        //цена
                        elems[0] = document.getElementsByClass("pim-list__item-price-actual-main");
                        //название
                        elems[1] = document.getElementsByClass("pim-list__item-title js-crop-text");

                        for (int k = 0; k < (elems[1].size() - 1); k++) {
                            //PrintStream out = new PrintStream(System.out, true, "UTF-8");
                            //out.println(elems[1].get(k).text());
                            if (elems[1].get(k).text().equals("Молоко ультрапастеризованное Parmalat 3,5%, 1 л")) {
                                try {
                                    String body = "{\"price\": " + Integer.parseInt(elems[0].get(k).text()) + ", \"time\": \"" + date + "\", \"product\":{\"id\": 3}, \"shop\": {\"id\": 12}}";
                                    sentReq(body);
                                } catch (Exception e) {
                                    e.printStackTrace();
                                }
                                break;
                            }
                            if (elems[1].get(k).text().equals("Молоко цельное Эконива 3,3-6%, 1 л")) {
                                try {
                                    String body = "{\"price\": " + Integer.parseInt(elems[0].get(k).text()) + ", \"time\": \"" + date + "\", \"product\":{\"id\": 4}, \"shop\": {\"id\": 12}}";
                                    sentReq(body);
                                } catch (Exception e) {
                                    e.printStackTrace();
                                }
                                break;
                            }
                            if (elems[1].get(k).text().equals("Молоко пастеризованное Углече Поле органическое 3,2%, 1 л")) {
                                try {
                                    String body = "{\"price\": " + Integer.parseInt(elems[0].get(k).text()) + ", \"time\": \"" + date + "\", \"product\":{\"id\": 7}, \"shop\": {\"id\": 12}}";
                                    sentReq(body);
                                } catch (Exception e) {
                                    e.printStackTrace();
                                }
                                break;
                            }
                        }
                    }
                    //Глобус МЯСО
                    Elements[] elems_chiken = new Elements[3];
                    for (int i = 1; i < 2; i++) {
                        //страница
                        String page2 = "https://www.globus.ru/catalog/myaso-ptitsa-kolbasy/ptitsa/kuritsa/" + "?page=" + i;
                        Document document2 = Jsoup.parse(new URL(page2).openStream(), "UTF-8", page2);
                        //цена
                        elems_chiken[0] = document2.getElementsByClass("pim-list__item-price-actual-main");
                        //название
                        elems_chiken[1] = document2.getElementsByClass("pim-list__item-title js-crop-text");

                        for (int k2 = 0; k2 < (elems_chiken[1].size() - 1); k2++) {
                            //PrintStream out = new PrintStream(System.out, true, "UTF-8");
                            //out.println(elems[1].get(k).text());
                            if (elems_chiken[1].get(k2).text().equals("Тушка цыплёнка-бройлера охлаждённая Верхневолжская птицефабрика, 1 кг")) {
                                try {
                                    String body = "{\"price\": " + Integer.parseInt(elems[0].get(k2).text()) + ", \"time\": \"" + date + "\", \"product\":{\"id\": 1}, \"shop\": {\"id\": 12}}";
                                    sentReq(body);
                                } catch (Exception e) {
                                    e.printStackTrace();
                                }
                                break;
                            }


                        }
                    }


                    //ПЕРЕКРЕСТОК
                        //страница
                        String page = "https://www.perekrestok.ru/cat/c/243/hleb";
                        Document document = Jsoup.parse(new URL(page).openStream(), "UTF-8", page);
                        //цена
                        elems[0] = document.getElementsByClass("price-new");
                        //название
                        elems[1] = document.getElementsByClass("product-card__title");

                        for (int k = 0; k < (elems[1].size() - 1); k++) {

                            if (elems[1].get(k).text().equals("Хлеб Экохлеб Богатырский цельнозерновой, 350г")) {
                                try {
                                    String body = "{\"price\": " + Integer.parseInt(elems[0].get(k).text().split(",")[0]) + ", \"time\": \"" + date + "\", \"product\":{\"id\": 10}, \"shop\": {\"id\": 13}}";
                                    sentReq(body);
                                } catch (Exception e) {
                                    e.printStackTrace();
                                }

                            }
                            if (elems[1].get(k).text().equals("Хлеб Коломенское Даниловский зерновой, 300г")) {
                                try {
                                    String body = "{\"price\": " + Integer.parseInt(elems[0].get(k).text().split(",")[0]) + ", \"time\": \"" + date + "\", \"product\":{\"id\": 9}, \"shop\": {\"id\": 13}}";
                                    sentReq(body);
                                } catch (Exception e) {
                                    e.printStackTrace();
                                }

                            }
                            if (elems[1].get(k).text().equals("Хлеб Дарницкий, 700г")) {
                                try {
                                    String body = "{\"price\": " + Integer.parseInt(elems[0].get(k).text().split(",")[0]) + ", \"time\": \"" + date + "\", \"product\":{\"id\": 8}, \"shop\": {\"id\": 13}}";
                                    sentReq(body);
                                } catch (Exception e) {
                                    e.printStackTrace();
                                }

                            }
                        }
                    //ВКУСВИЛЛ


                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        };
        scheduler.scheduleAtFixedRate(task, 0, 1, TimeUnit.MINUTES);
    }

}
