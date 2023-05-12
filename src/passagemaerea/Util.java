package passagemaerea;

import java.util.Scanner;

public class Util {
    //Passa como parâmetro a mensagem que será informada ao usuário
    //E o retorno dela será armazenado em uma variável do tipo String
    static String pedeString(String mensagem) {
        Scanner leia = new Scanner(System.in);
        String str;
        do {
            System.out.println(mensagem);
            str = leia.nextLine().trim();
        } while (str.length() == 0);
        return str;
    }
    //Passa como parâmetro a mensagem que será informada ao usuário
    //E o retorno dela será armazenado em uma variável do tipo Int
    static int pedeInteiro(String mensagem) {
        Scanner leia = new Scanner(System.in);
        int num;
        try {
            System.out.println(mensagem);
            num = leia.nextInt();
        } catch (java.util.InputMismatchException e) {
            System.out.println("Valor informado inválido, informe apenas números.");
            num = pedeInteiro(mensagem);
        }
        return num;
    }
}
