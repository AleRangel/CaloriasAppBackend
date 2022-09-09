package scraper;

import java.util.ArrayList;

import org.jsoup.*;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Scraper {

    public static Document getHTML(String url) {
        Document html = null;
        try {
            html = Jsoup.connect(url).userAgent("Mozilla/5.0").timeout(1000000).get();
        } catch (Exception err) {
            System.out.println("Error al obtene el codigo HTML");
        }
        return html;
    }

    public ArrayList<String> scrapingHtml(String alimento) {
        ArrayList<String> filtro1 = new ArrayList<String>();
        ArrayList<String> filtro2 = new ArrayList<String>();

        ArrayList<String> datosNutricionalesBruto = new ArrayList<String>();

        Document datos = Scraper.getHTML("https://www.google.com.mx/search?q="+alimento+"+calories");

        Elements datosTabla2 = datos.select("td");

        for (Element datoTabla : datosTabla2) {

            String[] datoTablaDoc = datoTabla.text().split("%");

            for (var each : datoTablaDoc) {
                datosNutricionalesBruto.add(each.toString());

            }

        }

        for (int i = 0; i < datosNutricionalesBruto.size(); i++) {

            if (datosNutricionalesBruto.get(i).length() < 10 || datosNutricionalesBruto.get(i).contains("*") == true) {
                continue;
            } else {

                filtro1.add(datosNutricionalesBruto.get(i));
            }

        }
        for (int i = 0; i < filtro1.size(); i++) {

            String elementos = filtro1.get(i);
            String[] x = elementos.split(" ");
            for (String elemento : x) {
                filtro2.add(elemento.toString());
            }

        }
        return filtro2;
    }
}
