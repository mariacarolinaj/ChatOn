package Model;

/**
 * @author maria
 */
public class Sala {

    private int idSala;
    private String senha;
   

    public Sala() {

    }

    public Sala(int idSala, String senha) {
        this.idSala = idSala;
        this.senha = senha;
    }

    public int getIdSala() {
        return idSala;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public void setIdSala(int idSala) {
        this.idSala = idSala;
    }

}
