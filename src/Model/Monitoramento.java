package Model;

public class Monitoramento {
    private Paciente paciente;
    private Dispositivos dispositivos;
    private String Dadosmonitoramento;
    private int idMonitoramento;
    private Medico medico;

    public Medico getMedico() {
        return medico;
    }

    public void setMedico(Medico medico) {
        this.medico = medico;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public Dispositivos getDispositivos() {
        return dispositivos;
    }

    public void setDispositivos(Dispositivos dispositivos) {
        this.dispositivos = dispositivos;
    }

    public String getDadosmonitoramento() {
        return Dadosmonitoramento;
    }

    public void setDadosmonitoramento(String dadosmonitoramento) {
        Dadosmonitoramento = dadosmonitoramento;
    }

    public int getIdMonitoramento() {
        return idMonitoramento;
    }

    public void setIdMonitoramento(int idMonitoramento) {
        this.idMonitoramento = idMonitoramento;
    }
}
