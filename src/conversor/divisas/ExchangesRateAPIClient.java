/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package conversor.divisas;

/**
 *
 * @author HP
 */

import java.net.URL;
import java.net.HttpURLConnection;
import java.io.InputStreamReader;
import java.util.Map;
import com.google.gson.Gson;

public class ExchangesRateAPIClient {
    private static final String key= "ce85c9f275e397cecb927f75";
    private static final String API_URL = "https://v6.exchangerate-api.com/v6/"+key+"/latest/";
    
    // metodo que resive el codigo de moneda 
    public ExchangeRateResponse getExchangeRates(String baseCode) throws Exception {
        URL url = new URL(API_URL + baseCode);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");

        try (InputStreamReader reader = new InputStreamReader(connection.getInputStream())) {
            Gson gson = new Gson();
            return gson.fromJson(reader, ExchangeRateResponse.class);
        }
    }
    
}
