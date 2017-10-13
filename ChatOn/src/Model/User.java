package Model;

/**
 * @author maria
 */
public class User {

    private String username;
    private int codUsuario;

    public User() {

    }

    public User(String username) {
        this.username = username;
    }
    
    public int getCodUsuario() {
        return codUsuario;
    }

    public void setCodUsuario(int codUsuario) {
        this.codUsuario = codUsuario;
    } 

    public String getUserName() {
        return username;
    }

    public void setUserName(String username) {
        this.username = username;
    }

}
