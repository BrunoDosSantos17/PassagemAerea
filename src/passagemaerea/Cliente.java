package passagemaerea;

public class Cliente {

    private String nome, cpf, endereco, telefone;
    private int idade;
    //Guarda e altera as infomações que o usuário digitar.
    public Cliente(String nome, String cpf, String endereco, String telefone, int idade) {
        this.nome = nome;
        this.cpf = cpf;
        this.endereco = endereco;
        this.telefone = telefone;
        this.idade = idade;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
    public int getIdade(){
        return idade;
    }
    public void setIdade(int idade){
        this.idade = idade;
    }
}
