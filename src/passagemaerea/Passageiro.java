package passagemaerea;

public class Passageiro {
 //Guarda e altera as infomações que o usuário digitar.
    private String nome, cpfCliente, cpfPassageiro, telefone, tipodaPassagem, idPassagem, AeroportoO, AeroportoD, data;

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getAeroportoO() {
        return AeroportoO;
    }

    public void setAeroportoO(String AeroportoO) {
        this.AeroportoO = AeroportoO;
    }

    public String getAeroportoD() {
        return AeroportoD;
    }

    public void setAeroportoD(String AeroportoD) {
        this.AeroportoD = AeroportoD;
    }
    private int idade, numeroDaPoltrona;
    private float preco;

    public Passageiro(String nome, String cpfCliente, String cpfPassageiro, String telefone, String tipodaPassagem, String idPassagem, String AeroportoO, String AeroportoD,String data, int idade, int numeroDaPoltrona, float preco) {
        this.nome = nome;
        this.cpfCliente = cpfCliente;
        this.cpfPassageiro = cpfPassageiro;
        this.telefone = telefone;
        this.tipodaPassagem = tipodaPassagem;
        this.idPassagem = idPassagem;
        this.AeroportoO = AeroportoO;
        this.AeroportoD = AeroportoD;
        this.idade = idade;
        this.numeroDaPoltrona = numeroDaPoltrona;
        this.preco = preco;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpfCliente() {
        return cpfCliente;
    }

    public void setCpfCliente(String cpfCliente) {
        this.cpfCliente = cpfCliente;
    }

    public String getCpfPassageiro() {
        return cpfPassageiro;
    }

    public void setCpfPassageiro(String cpfPassageiro) {
        this.cpfPassageiro = cpfPassageiro;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getTipodaPassagem() {
        return tipodaPassagem;
    }

    public void setTipodaPassagem(String tipodaPassagem) {
        this.tipodaPassagem = tipodaPassagem;
    }

    public String getIdPassagem() { 
        return idPassagem;
    }

    public void setIdPassagem(String idPassagem) {
        this.idPassagem = idPassagem;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public int getNumeroDaPoltrona() {
        return numeroDaPoltrona;
    }

    public void setNumeroDaPoltrona(int numeroDaPoltrona) {
        this.numeroDaPoltrona = numeroDaPoltrona;
    }

    public float getPreco() {
        return preco;
    }

    public void setPreco(float preco) {
        this.preco = preco;
    }

}
