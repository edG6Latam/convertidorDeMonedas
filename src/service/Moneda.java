package service;

public class Moneda {

    private String moneda;
    private String convertirA;
    private double taza_conversion;
    private double resultado;
    private double cantidad;
    private String error;

    public Moneda(RecordMoneda recordMoneda,double cantidad) {
        this.moneda= recordMoneda.base_code();
        this.convertirA= recordMoneda.target_code();
        this.taza_conversion= recordMoneda.conversion_rate();
        this.resultado= recordMoneda.conversion_result();
        this.cantidad=cantidad;
        this.error= recordMoneda.result();
    }

    public String getError() {
        return error;
    }

    public String getMoneda() {
        return moneda;
    }

    public String getConvertirA() {
        return convertirA;
    }

    public double getTaza_conversion() {
        return taza_conversion;
    }

    public Double getResultado() {
        return resultado;
    }

    @Override
    public String toString() {
        return
                "\n***********************\n"+
                "cantidad a convertir= " + cantidad +","+moneda+'\n'+
                "moneda= " + moneda + '\n' +
                "convertir a moneda= " + convertirA + '\n' +
                "tasa de conversion= " + taza_conversion +'\n'+
                "resultado= " + resultado+'\n'+
                "***********************\n"
                ;
    }
}
