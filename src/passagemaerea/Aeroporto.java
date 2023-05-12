package passagemaerea;

import java.util.ArrayList;

public class Aeroporto {

    String iata;
    boolean verdadeiro = true;
    String[] aeroportos = {"John F. Kennedy (JFK) - Queens, NY, EUA", "Antônio Carlos Jobim (GIG) -  Ilha do Governador, RJ, Brasil", "Hercílio Luz (FLN) - Florianópolis, SC, Brasil"};
    String[] iatas = {"JFK", "GIG", "FLN"};
    ArrayList<PrevisaoPreco> chega = new ArrayList();

    public void carregaArrayList() {
        chega.add(new PrevisaoPreco("JFK", "GIG", "10h 09min", 3097.00f));
        chega.add(new PrevisaoPreco("JFK", "FLN", "10h 22min", 3244.00f));
        chega.add(new PrevisaoPreco("GIG", "JFK", "10h 09min", 3097.00f));
        chega.add(new PrevisaoPreco("FLN", "JFK", "10h 22min", 3244.00f));
        chega.add(new PrevisaoPreco("GIG", "FLN", "1h 33min", 166.00f));
        chega.add(new PrevisaoPreco("FLN", "GIG", "1h 33min", 166.00f));
    }
    //Verifica se o aeroporto informado existe na lista disponibilizada.
    public void VerificaAeroporto(String aeroporto) {

        aeroporto = aeroporto.toUpperCase().trim();
        for (String b : iatas) {
            if (aeroporto.equals(b)) {
                verdadeiro = false;
            }
        }
    }

}
