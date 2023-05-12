
package passagemaerea;

public class PrevisaoPreco {
    //Guarda e altera as infomações que o usuário digitar.
    String AeroportoOrigem, AeroportoDestino, previcao;
    float Preco;

    public String getAeroportoOrigem() {
        return AeroportoOrigem;
    }

    public void setAeroportoOrigem(String AeroportoOrigem) {
        this.AeroportoOrigem = AeroportoOrigem;
    }

    public String getAeroportoDestino() {
        return AeroportoDestino;
    }

    public void setAeroportoDestino(String AeroportoDestino) {
        this.AeroportoDestino = AeroportoDestino;
    }

    public String getPrevicao() {
        return previcao;
    }

    public void setPrevicao(String previcao) {
        this.previcao = previcao;
    }

    public float getPreco() {
        return Preco;
    }

    public void setPreco(float Preco) {
        this.Preco = Preco;
    }
    public PrevisaoPreco(String AeroportoOrigem, String AeroportoDestino, String previcao, float Preco) {
        this.AeroportoOrigem = AeroportoOrigem;
        this.AeroportoDestino = AeroportoDestino;
        this.previcao = previcao;
        this.Preco = Preco;
    }
    
    
}
