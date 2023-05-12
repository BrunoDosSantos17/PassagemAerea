package passagemaerea;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Linha {

    static Scanner leia = new Scanner(System.in);
    float preco;
    
    public String pedeOrigemDestino(String msg) {
        Aeroporto verific = new Aeroporto();
        String Aeroporto;
        
        do {
            Aeroporto = Util.pedeString(msg);
            verific.VerificaAeroporto(Aeroporto);
        } while (verific.verdadeiro || Aeroporto == "");

        return Aeroporto;
    }
    //Pede e valida a data informada
    public String pedeData() {
        String data = null;
        boolean verific = false;
        //método para chamar a data atual
        DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        Date date = new Date();
        String dateAtual = formatter.format(date);
        Date dataInformada = null;

        do {
            try {
                System.out.println("Informe a data de embarque (dd/mm/aaaa, até 2030)");
                data = leia.nextLine();
                verific = VerificaData(data, dateAtual);
                if (!verific) {
                    try {
                        dataInformada = (Date) formatter.parse(data);
                        verific = false;
                    } catch (ParseException ex) {
                        System.out.println("Data inválida, digite novamente.");
                        verific = true;
                    }

                }
            } catch (java.lang.NumberFormatException e) {
                System.out.println("Data inválida, digite novamente.");
                verific = true;
            }

        } while (verific);
        return data;
    }
    
    public boolean VerificaData(String data, String dataAtual) {
        try {
        int[] diasNoMes = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        //separação da data atual em mês e ano
        int mesAtual = Integer.valueOf(dataAtual.substring(3, 5));
        int anoAtual = Integer.valueOf(dataAtual.substring(6));
        int dia = Integer.valueOf(data.substring(0, 2));

       
            int mes = Integer.valueOf(data.substring(3, 5));
            int maiorDia = diasNoMes[mes - 1];
            int ano = Integer.valueOf(data.substring(6));
            if (mes < mesAtual) {
                if (ano <= anoAtual) {
                    if (dia > 1 || dia < maiorDia) {
                        System.out.println("Data inválida");
                        return true;
                    } else {
                        return false;
                    }
                }

            }
            if (ano < anoAtual || ano > 2030) {
                System.out.println("Data inválida");
                return true;
            }
            if (dia < 0 || dia > maiorDia) {
                System.out.println("Data inválida");
                return true;
            }

        } catch (Exception e) {
            System.out.println("Data inválida");
            return true;
        }
        return false;
    }
    
    public float CalculaPrevisão(String AeroportoOrigem, String AeroportoDestino) {
        String previsao = BuscaPrevisao(AeroportoOrigem, AeroportoDestino);
        System.out.println("O tempo aproximado de voo será de:  " + previsao);
        return preco;

    }
    //Pega previsão e armazena
    private String BuscaPrevisao(String AO, String AD) {
        Aeroporto lista = new Aeroporto();
        lista.carregaArrayList();
        String horario = null;
        for (PrevisaoPreco object : lista.chega) {
            if (object.getAeroportoOrigem().equals(AO) && object.getAeroportoDestino().equals(AD)) {
                horario = object.getPrevicao();
                preco = object.getPreco();
                return horario;
            }
        }
        return horario;
    }
}
