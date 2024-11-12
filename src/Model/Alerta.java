package Model;

public class Alerta {
    private Boolean tipoAlerta; // emergencia ou anormalidade (true e false)
    private String mensagem;
    private Paciente paciente;
    private Medico medico;
    private String data;

    public Boolean getTipoAlerta() {
        return tipoAlerta;
    }

    public void setTipoAlerta(Boolean tipoAlerta) {
        this.tipoAlerta = tipoAlerta;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public Medico getMedico() {
        return medico;
    }

    public void setMedico(Medico medico) {
        this.medico = medico;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}
