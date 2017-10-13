package Model;

import java.sql.Date;

/**
 *
 * @author maria
 */
public class Mensagem {

    private String txtMsg;
    private User usuario;
    private Sala sala;
    private int codMensagem;
    private Date data;

    public Mensagem() {

    }

    public Mensagem(String txtMsg, User usuario, Sala sala, int codMensagem, Date data) {
        this.txtMsg = txtMsg;
        this.usuario = usuario;
        this.sala = sala;
        this.codMensagem = codMensagem;
        this.data = data;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public String getTxtMsg() {
        return txtMsg;
    }

    public void setTxtMsg(String txtMsg) {
        this.txtMsg = txtMsg;
    }

    public User getUsuario() {
        return usuario;
    }

    public void setUsuario(User usuario) {
        this.usuario = usuario;
    }

    public Sala getSala() {
        return sala;
    }

    public void setSala(Sala sala) {
        this.sala = sala;
    }

    public int getCodMensagem() {
        return codMensagem;
    }

    public void setCodMensagem(int codMensagem) {
        this.codMensagem = codMensagem;
    }

}
