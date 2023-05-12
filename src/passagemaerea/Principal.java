package passagemaerea;

import java.util.ArrayList;

public class Principal {

    public String AeroportoOrigem;
    public String AeroportoDestino;
    public String dataSaida;
    float prec;
    final private ArrayList<Cliente> listaClientes = new ArrayList();
    public ArrayList<Passageiro> Passageiros = new ArrayList();
    
    public static void main(String[] args) {
        System.out.println("***************************************** BEM VINDO AO SISTEMA DE VENDA DE PASSAGENS **************************************");
        System.out.println("********************************************************* AEREAS **********************************************************");
        Principal programa = new Principal();
        programa.iniciaPrograma();
    }
    /*
    Informa os Aeroportos disponíves
    Pede e valida quais os aeroportos de embarque e desembarque 
    */
    private void cuidaLinha() {
        Aeroporto mostra = new Aeroporto();
        Linha linha = new Linha();
        Aeroporto a = new Aeroporto();
        System.out.println("**************************************************************************************************************");
        for (String b : mostra.aeroportos) {
            System.out.println(b + "\n");
        }
        AeroportoOrigem = linha.pedeOrigemDestino("Escolha um aeroporto acima como o de embarque (informe apenas a IATA):").toUpperCase().trim();
        a.VerificaAeroporto(AeroportoOrigem);
        do {
            System.out.println("**************************************************************************************************************");
            for (String b : mostra.aeroportos) {
                int falso = b.indexOf("(");
                String b1 = b.substring(falso + 1, falso + 4);
                if (!AeroportoOrigem.equalsIgnoreCase(b1)) {
                    System.out.println(b + "\n");
                }
            }
            AeroportoDestino = linha.pedeOrigemDestino("Escolha um aeroporto acima como o de desembarque (informe apenas a IATA)").toUpperCase().trim();
            a.VerificaAeroporto(AeroportoDestino);
        } while (AeroportoOrigem.equals(AeroportoDestino));
        dataSaida = linha.pedeData();
        prec = linha.CalculaPrevisão(AeroportoOrigem, AeroportoDestino);

    }
    //Verifica se o passageiro ja foi cadastrado 
    private Passageiro buscaPassageiro(String CpfPassageiro, String Nome) {
        for (Passageiro ob : Passageiros) {
            if (ob.getCpfPassageiro().equals(CpfPassageiro)) {
                if (ob.getNome().equals(Nome)) {
                    return null;
                } else {
                    return ob;
                }
            }
        }
        return null;
    }
    
    public Cliente buscaCliente(String cpf) {
        for (Cliente objeto : listaClientes) {
            if (objeto.getCpf().equals(cpf)) {
                return objeto;
            }
        }
        return null;
    }
    //valida o formato em que o CPF do cliente deve ser informado
    public String verificaCpf(String mensagem) {
        String CpfVerificado;
        String mask = "[0-9]{3}?\\.[0-9]{3}?\\.[0-9]{3}?\\-[0-9]{2}";
        do {
            CpfVerificado = Util.pedeString(mensagem + " (formato: xxx.xxx.xxx-xx, não podendo conter letras):").trim();
        } while (!CpfVerificado.matches(mask));
        return CpfVerificado;
    }

    private void cadastroDaVenda(int quantidadePassagem, String CpfCliente, float pre) {
        String nome;
        String IDs;
        int lugar;
        int idadePassageiro;
        String Telefone;
        String CpfPassageiro;
        String tipoPassagem;
        float precoPS;
        float precoFinal = 0;
        Passageiro p;
        Cliente a;
        Passagem IdPassagem = new Passagem();
        Linha preco = new Linha();
        Aviao ids = new Aviao();
        Venda psVendidas = new Venda();

        for (int i = 0; i < quantidadePassagem; i++) {
            nome = psVendidas.Nome();
            idadePassageiro = psVendidas.Idade();
            do {
                do {
                    CpfPassageiro = verificaCpf("Digite o CPF do Passageiro:").trim();
                    p = buscaPassageiro(CpfPassageiro, nome);
                } while (!(p == null));
                a = buscaCliente(CpfPassageiro);
            } while (a == null);

            Telefone = psVendidas.Telefone();
            IDs = IdPassagem.IDsPassagem();
            lugar = ids.InformaLugar();

            if (idadePassageiro < 13) {
                tipoPassagem = "Passagem meia";
                precoPS = (float) (prec * 0.75);
            } else {
                tipoPassagem = "Passagem Inteira";
                precoPS = prec;
            }
            precoFinal = precoFinal + precoPS;
            Passageiros.add(new Passageiro(nome, CpfCliente, CpfPassageiro, Telefone, tipoPassagem, IDs, AeroportoOrigem, AeroportoDestino, dataSaida, idadePassageiro, (lugar + 1), precoPS));

            System.out.println("******************************** PASSAGEM CADASTRADA COM SUCESSO ****************************************.");
        }
        System.out.println("Preço total: R$" + (precoFinal + pre));

    }
    //Pede e valida as informações do cliente
    private void verificacaoCliente(boolean passa, String cpf) {
        String cpfCliente = cpf;
        int IdadeCliente;
        String nomeCliente;
        String telefoneCliente;
        String endereco;

        String maskTelefone = "\\([0-9]{2}?\\)[0-9]{4}?\\-[0-9]{4}";

        if (passa) {
            cpfCliente = verificaCpf("Informe o CPF do cliente:");
        }

        Cliente cliente = buscaCliente(cpfCliente);
        // verifica se o cliente está ou não cadastrado.
        if (cliente == null) {
            // como o cliente não está cadastrado, cria um objeto da classe Cliente e pede os demais dados para fazer o cadastro dele.
            do {
                nomeCliente = Util.pedeString("Informe o nome do cliente(diferente de vazio):");
            } while ("".equals(nomeCliente));

            do {
                IdadeCliente = Util.pedeInteiro("Informe a idade do cliente(de 18 à 100)");
            } while (IdadeCliente < 18 || IdadeCliente > 100);

            if (IdadeCliente > 17) {
                do {
                    telefoneCliente = Util.pedeString("Informe o telefone do cliente(formato: (xx)xxxx-xxxx, não podendo conter letras):");
                } while (!telefoneCliente.matches(maskTelefone));

                endereco = Util.pedeString("Informe o endereço (diferente de vazio):");

                cliente = new Cliente(nomeCliente, cpfCliente, endereco, telefoneCliente, IdadeCliente);

                // adiciona o objeto criado para manter o cliente cadastrado na memória do programa.
                listaClientes.add(cliente);
                System.out.println("Cliente cadastrado com sucesso!");
            }

        } else {
            System.out.println("Cliente já cadastrado no sistema.");
            System.out.println("Nome: " + cliente.getNome());
            System.out.println("Telefone: " + cliente.getTelefone());
            System.out.println("Idade: " + cliente.getIdade());
        }
    }

    private void vendaPassagem() {
        int escolha;
        String CpfVenda;
        Aviao IDs = new Aviao();

        CpfVenda = verificaCpf("Iniciaremos a venda de passagens aereas, por favor Informe \n"
                + "seu CPF para continuarmos: ");

        Cliente cliente = buscaCliente(CpfVenda);
        if (cliente == null) {
            do {
                escolha = Util.pedeInteiro("Cliente ainda não cadastrado, gostaria de cadastrar?\n"
                        + "1 - sim\n"
                        + "2 - não");
            } while (escolha < 1 || escolha > 2);

            if (escolha == 1) {
                verificacaoCliente(false, CpfVenda);
            }
        } else {
            cuidaLinha();
            int qtdPassagem = Util.pedeInteiro("Quantas passagens o(a) senhor(a) gostaria?");
            int pss = Util.pedeInteiro("O(a) senhor(a) será um passageiro?\n"
                    + "1 - sim\n"
                    + "2 - não");
            float preco;
            if (pss == 1) {

                Passagem idPss = new Passagem();
                String nome = cliente.getNome();
                String telefone = cliente.getTelefone();
                int idade = cliente.getIdade();
                String numeroVoo = idPss.IDsPassagem();
                int lugar = IDs.lugar;
                preco = prec;

                Passageiros.add(new Passageiro(nome, CpfVenda, CpfVenda, telefone, "Inteira", numeroVoo, AeroportoOrigem, AeroportoDestino, dataSaida, idade, (lugar + 1), preco));
                System.out.println("******************************** PASSAGEM CADASTRADA COM SUCESSO ****************************************.");
                qtdPassagem = qtdPassagem - 1;
            } else {
                preco = 0;
            }
            cadastroDaVenda(qtdPassagem, CpfVenda, preco);
        }
    }

    private void iniciaPrograma() {
        int opcao;
        try {
            do {
                System.out.println("**************************************************************************************************************");
                opcao = Util.pedeInteiro("Selecione a opção desejada:"
                        + " \n 1 - Cadastrar cliente"
                        + " \n 2 - Vender Passagem"
                        + " \n 3 - Mostrar Passagem"
                        + " \n 4 - Sair");

                switch (opcao) {
                    case 1:
                        verificacaoCliente(true, "0");
                        break;
                    case 2:
                        vendaPassagem();
                        break;
                    case 3:
                        mostrarPassagem();
                        break;
                }
            } while (opcao != 4);
        } catch (java.util.InputMismatchException e) {
            System.out.println("Valor informado inválido, informe apenas números.");
            iniciaPrograma();
        }
    }
    
    /*
    Pede o CPF do cliente que efetuou a compra da(s) passagem(ns) para consultar os dados sobre a compra;
    Se o CPF foi cadastrado na compra de uma passagem, informa a(s) passagem(ns) comprada(s) e os dados do passageiro que a possui ;
    Se não, informa que não foi encontrado nenhum dado.
    */
    public void mostrarPassagem() { 
        String CpfCliente = verificaCpf("Informe o CPF do cliente para consultar os dados:");
        Cliente cliente = buscaCliente(CpfCliente);
        System.out.println("Passagens compradas:");
        if (cliente == null) {
            System.out.println("Nenhum dado encontrado.");
        } else {
            for (Passageiro object : Passageiros) {
                if (object.getCpfCliente().equals(CpfCliente)) {
                    System.out.println("*********************************************** Passagem *******************************************************");
                    System.out.println("* Nome do passageiro: " + object.getNome());
                    System.out.println("* Idade do passageiro: " + object.getIdade());
                    System.out.println("* Aeroporto de embarque: " + object.getAeroportoO());
                    System.out.println("* Aeroporto de desembarque: " + object.getAeroportoD());
                    System.out.println("* Número da poltrona: " + object.getNumeroDaPoltrona());
                    System.out.println("* Tipo da passagem: Passagem " + object.getTipodaPassagem());
                    System.out.println("* Preço da passagem: R$" + object.getPreco());
                    System.out.println("**************************************************************************************************************");
                }
            }
        }
    }
}
