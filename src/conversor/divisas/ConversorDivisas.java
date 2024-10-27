/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package conversor.divisas;

/**
 *
 * @author HP
 */
import java.util.InputMismatchException;
import java.util.Scanner;
public class ConversorDivisas {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ExchangesRateAPIClient client = new ExchangesRateAPIClient();

        
        int opcion;
        System.out.println();
        System.out.println(" \nBienvenido/a al conversor de monedas ");
        System.out.println(" Contamos con soporte de convercion a mas 161 monedas mundiales.");
        System.out.println("------------------------------------------------------");
        
       do {
            System.out.println("\n\t\tMenu de opciones:");
            System.out.println("1. Lista de codigos y paises adminitidos");
            System.out.println("2. Conversor Monedas");
            System.out.println("3. Salir\n");
            System.out.print("Ingrese una opcion: ");
            opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar el buffer para evitar problemas al leer cadenas
            

            switch (opcion) {
                case 1:
                    muestraPaises();
                    break;
                case 2:
                    System.out.println("\nConversor de monedas.. ");
                    try {
                        System.out.print("Ingrese la moneda base (por ejemplo, EUR): ");
                        String baseCode = scanner.nextLine().toUpperCase();

                        System.out.print("Ingrese la moneda a la que quiere convertir (por ejemplo, USD): ");
                        String targetCode = scanner.nextLine().toUpperCase();

                        System.out.print("Ingrese el monto a convertir: ");
                        double amount = scanner.nextDouble();

                        ExchangeRateResponse response = client.getExchangeRates(baseCode);

                        if (response.conversion_rates().containsKey(targetCode)) {
                            double conversionRate = response.conversion_rates().get(targetCode);
                            double convertedAmount = amount * conversionRate;

                            System.out.printf("%.2f %s equivale a %.2f %s segun la tasa actual.%n",
                                amount, baseCode, convertedAmount, targetCode);
                        } else {
                            System.out.println("La moneda objetivo no esta disponible en los datos de la API.");
                        }
                    } catch (Exception e) {
                        System.out.println("Error al obtener los datos de la API: " + e.getMessage());
                    }
                    break;
                case 3:
                    System.out.println(" Gracias por usar nuestro servicio");
                    break;
                default:
                    System.out.println(" La opcion ingresada es incorrecta");
            }
         
        } while (opcion != 3);
    }// fin del main 
    
    
    
    
    //---------------------------------------------------- metodo statico que muestra la lista de paises disponibles para hacer la convercion 
    public static void muestraPaises() {

            System.out.println("---------------------------------------------------------------------------");
            System.out.println("DEA Emiratos arabes Unidos\t| AFN Afganistan");
            System.out.println("TODO Albania\t| AMD Armenia");
            System.out.println("ANG Antillas Holandesas\t| AOA Angola");
            System.out.println("ARS Argentina\t| AUD Australia");
            System.out.println("AWG Aruba\t| AZN Azerbaiyan");
            System.out.println("bam Bosnia y Herzegovina\t| BBD Barbados");
            System.out.println("BDT Bangladesh\t| BGN Bulgaria");
            System.out.println("BHD Bahréin\t| BIF Burundi");
            System.out.println("DMO islas Bermudas\t| BND Brunei");
            System.out.println("BETO bolivia\t| reales Brasil");
            System.out.println("BSD bahamas\t| BTN Butan");
            System.out.println("BWP Botsuana\t| BYN Bielorrusia");
            System.out.println("BZD Belice\t| CANALLA Canada");
            System.out.println("CDF Republica Democratica del Congo\t| CHF Suiza");
            System.out.println("CLP Chile\t| CNY Porcelana");
            System.out.println("POLICÍA Colombia\t| CDN Costa Rica");
            System.out.println("TAZA Cuba\t| CVE Cabo Verde");
            System.out.println("coronas checas Republica Checa\t| DJF Yibuti");
            System.out.println("coronas danesas Dinamarca\t| DOP Republica Dominicana");
            System.out.println("DZD Argelia\t| EGP Egipto");
            System.out.println("ERN Eritrea\t| ETB Etiopia");
            System.out.println("EUR union Europea\t| FJD Fiyi");
            System.out.println("FKP Islas Malvinas\t| FOK Islas Faroe");
            System.out.println("GBP Reino Unido\t| GEL Georgia");
            System.out.println("GGP Guernesey\t| GHS Ghana");
            System.out.println("PIB Gibraltar\t| GMD Gambia");
            System.out.println("GNF Guinea\t| GTQ Guatemala");
            System.out.println("GYD Guayana\t| dolares de Hong Kong Hong Kong");
            System.out.println("HNL Honduras\t| HRK Croacia");
            System.out.println("HTG Haití\t| HUF Hungria");
            System.out.println("IDR Indonesia\t| ILS Israel");
            System.out.println("DIABLILLO Isla del hombre\t| INR India");
            System.out.println("IQD Irak\t| TIR Iran");
            System.out.println("corona islandesa Islandia\t| JEP Jersey");
            System.out.println("JMD Jamaica\t| JOD Jordan");
            System.out.println("Guay Japon\t| KES Kenia");
            System.out.println("kgs Kirguistán\t| KHR Camboya");
            System.out.println("NIÑO Kiribati\t| KMF Comoras");
            System.out.println("KRW Corea del Sur\t| kwd Kuwait");
            System.out.println("KYD Islas Caiman\t| KZT Kazajstan");
            System.out.println("LAK Laos\t| dolar lumbar Libano");
            System.out.println("LKR Sri Lanka\t| LRD Liberia");
            System.out.println("LSL Lesoto\t| LYD Libia");
            System.out.println("ENOJADO Marruecos\t| MDL Moldavia");
            System.out.println("mga Madagascar\t| MKD Macedonia del Norte");
            System.out.println("MMK Birmania\t| TMN Mongolia");
            System.out.println("FREGAR Macao\t| MRU Mauritania");
            System.out.println("MURO Mauricio\t| MVR Maldivas");
            System.out.println("MWK Malaui\t| MXN Mexico");
            System.out.println("MYR Malasia\t| MZN Mozambique");
            System.out.println("NAD Namibia\t| NGN Nigeria");
            System.out.println("NÍO Nicaragua\t| NO OK Noruega");
            System.out.println("NPR Nepal\t| moneda neozelandesa Nueva Zelanda");
            System.out.println("OMR Omán\t| PAB Panama");
            System.out.println("BOLÍGRAFO Perú\t| PGK Papua Nueva Guinea");
            System.out.println("PHP Filipinas\t| PKR Pakistan");
            System.out.println("PLN Polonia\t| PYG Paraguay");
            System.out.println("QAR Katar\t| RON Rumania");
            System.out.println("RSD Serbia\t| FROTAR Rusia");
            System.out.println("RWF Ruanda\t| RAE Arabia Saudita");
            System.out.println("SBD Islas Salomon\t| RCS Seychelles");
            System.out.println("ODS Sudán\t| coronas suecas Suecia");
            System.out.println("SGD Singapur\t| SHP santa elena");
            System.out.println("LES Sierra Leona\t| LLAMADA DE SOCORRO Somalia");
            System.out.println("SDR Surinam\t| SSP Sudan del Sur");
            System.out.println("ESTN Santo Tome y Principe\t| SYP Siria");
            System.out.println("SZL Suazilandia\t| THB Tailandia");
            System.out.println("TJS Tayikistan\t| TMT Turkmenistan");
            System.out.println("TND Tunez\t| TOP Tonga");
            System.out.println("TRY Turquia\t| TTD Trinidad y Tobago");
            System.out.println("TWD Taiwan\t| TZS Tanzania");
            System.out.println("UAH Ucrania\t| UGX Uganda");
            System.out.println("USD Estados Unidos\t| UYU Uruguay");
            System.out.println("UZS Uzbekistan\t| VES Venezuela");
            System.out.println("VND Vietnam\t| VUV Vanuatu");
            System.out.println("WST Samoa\t| XAF CFA Franc BEAC");
            System.out.println("XAG Plata (onza troy)\t| XAU Oro (onza troy)");
            System.out.println("XCD Dólar del Caribe Oriental\t| XDR Derechos Especiales de Giro");
            System.out.println("XOF CFA Franc BCEAO\t| XPD Paladio (onza troy)");
            System.out.println("XPF Franco CFP\t| XPT Platino (onza troy)");
            System.out.println("YER Yemen\t| ZAR Sudafrica");
            System.out.println("ZMW Zambia\t| ZWL Zimbabue");
            System.out.println("-------------------------------------------------------------------------------------------");
    }    
} // fin de la clase main
