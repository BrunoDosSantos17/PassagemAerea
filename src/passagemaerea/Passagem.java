package passagemaerea;

public class Passagem {

    String Ids = IDsPassagem();
    //Identifica a passagem para referencia-la ao passageiro certo.
    public String IDsPassagem() {
        Principal mostraP = new Principal();
        int idPassagem = 0;
        String PassagemIDs;
        for (Passageiro object : mostraP.Passageiros) {
            if (idPassagem == 200){
                idPassagem = 0;
            }else{
                idPassagem = idPassagem + 1;
            }
                
        }
        PassagemIDs = Integer.toString(idPassagem);
        return PassagemIDs;
    }

}