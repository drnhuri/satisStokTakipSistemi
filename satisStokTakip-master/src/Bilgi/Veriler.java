
package Bilgi;

import Bilgi.Doviz;
import java.io.IOException;
import org.jsoup.Jsoup;


/**
 *
 * @author sevinc
 */
public class Veriler {
    Doviz doviz = new Doviz();
    
    public String  veri(){
        try {
            org.jsoup.nodes.Document doc =  Jsoup.connect("https://www.bloomberght.com/doviz/dolar").get();
            String dolar = doc.select("div.piyasaDataValues > span").set(1, doc).text();
           doviz.setDolar(dolar);
        } catch (IOException ex) {
          doviz.setDolar("\n"
                  + "İnternet bağlantısını kontrol ediniz");

        }
        return doviz.getDolar();
    }
    
}
