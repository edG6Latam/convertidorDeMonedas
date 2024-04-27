import com.google.gson.Gson;
import service.RecordMoneda;
import service.Moneda;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {

        String key="99d8bdb1c2dd1adb66b66f87";
//        String pais="HNL";
//        String convertir="USD";
//        double cantidad=500;
        Scanner scan= new Scanner(System.in);


        int contador =0;
        while (contador!=5){
            System.out.println("""
                ********************************
                Bienvenido a conversor de monedas OnLine
                ********************************
                Indicanos tus siglas de pais de origen o el pais de 
                la moneda que deseas cambiar
                **
                ARS  para Argentina
                COP	para Colombia
                ARS	para Argentina
                BOB	para Bolivia
                BRL	para Brazil
                CLP	para Chile
                CNY	para China
                COP	para Colombia
                CRC	para Costa Rica
                CUP	para Cuba
                EUR	para European Union
                GTQ	para Guatemala
                HKD	para Hong Kong
                HNL	para Honduras
                HTG	para Haiti
                ILS	para Israel
                INR	para India
                IQD	para Iraq
                JMD	para Jamaica
                JPY	para Japan
                KRW	para Korea
                MXN	para Nicaragua
                PAB	paraPanama
                PEN para Peru
                TRY	para Turkey
                USD	para United States
                UYU	para Uruguay
                VES	para Venezuela
                """);
            try {
            String paisOrigen=scan.next().substring(0,3).trim();

            System.out.println("""
                ********************************
                Pais a convertir Moneda
                ********************************
                ingresa las siglas de el pais al que deseas convertir tu monedad
                **
                ARS  para Argentina
                COP	para Colombia
                ARS	para Argentina
                BOB	para Bolivia
                BRL	para Brazil
                CLP	para Chile
                CNY	para China
                COP	para Colombia
                CRC	para Costa Rica
                CUP	para Cuba
                EUR	para European Union
                GTQ	para Guatemala
                HKD	para Hong Kong
                HNL	para Honduras
                HTG	para Haiti
                ILS	para Israel
                INR	para India
                IQD	para Iraq
                JMD	para Jamaica
                JPY	para Japan
                KRW	para Korea
                MXN	para Nicaragua
                PAB	paraPanama
                PEN para Peru
                TRY	para Turkey
                USD	para United States
                UYU	para Uruguay
                VES	para Venezuela
                """);

                String paisAConvertir= scan.next().substring(0,3).trim();
                System.out.println("ingres la cantidad que desea convertir: ");
                double cantidad=scan.nextDouble();
                if(paisOrigen!=null || paisAConvertir!= null || paisOrigen.length()>=4 || paisAConvertir.length()>=4){
                    URI uri = URI.create("https://v6.exchangerate-api.com/v6/"+key+"/pair/"+paisOrigen+"/"+paisAConvertir+"/"+cantidad);

            HttpClient client=HttpClient.newHttpClient();
            HttpRequest request= HttpRequest.newBuilder()
                    .uri(uri)
                    .build();

            HttpResponse<String> response=client
                    .send(request,HttpResponse.BodyHandlers.ofString());


            String json= response.body();

            Gson gson= new Gson();
            RecordMoneda recordMoneda = gson.fromJson(json, RecordMoneda.class);

            Moneda miMoneda= new Moneda(recordMoneda,cantidad);


            System.out.println(miMoneda);
                    System.out.println("""
                    *********************
                    1 si desea seguir con la aplicacion
                    5 si desea salir de la aplicacion
                    """);
                    int opcion= scan.nextInt();
                    if(opcion==5){
                        contador=5;
                        System.out.println("*********** saliste del programa *************");
                    }

                }

            }catch (StringIndexOutOfBoundsException e){
                System.out.println("error de escritura solo siglas dichas y en mayusculas");
            }

        }


    }
}