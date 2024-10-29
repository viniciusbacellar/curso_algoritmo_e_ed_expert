package org.example.models;

public class DateInfo {

    private Integer dia;
    private Integer mes;
    private Integer ano;

    public DateInfo(String dia, String mes, String ano) {
        this.dia = Integer.valueOf(dia);
        this.mes = Integer.valueOf(mes);
        this.ano = Integer.valueOf(ano);
    }


    @Override
    public String toString() {
        return "dia: " + dia +
                ", mes: " + mes +
                ", ano: " + ano;
    }
}
