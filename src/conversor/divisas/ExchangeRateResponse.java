/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Record.java to edit this template
 */
package conversor.divisas;

/**
 *
 * @author HP
 */
import java.util.Map;
public record ExchangeRateResponse(
    String terms_of_use,
    long time_last_update_unix,
    String time_last_update_utc,
    long time_next_update_unix,
    String time_next_update_utc,
    String base_code,
    Map<String, Double> conversion_rates) {}
