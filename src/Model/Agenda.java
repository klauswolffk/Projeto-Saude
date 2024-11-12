package Model;

public class Agenda {
    private String data;
    private String hora;
    private Medico medico;
    private Paciente paciente;
    private String diagnostico;
    private String prescricaoMedicamento;

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

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

    public String getDiagnostico() {
        return diagnostico;
    }

    public void setDiagnostico(String diagnostico) {
        this.diagnostico = diagnostico;
    }

    public String getPrescricaoMedicamento() {
        return prescricaoMedicamento;
    }

    public void setPrescricaoMedicamento(String prescricaoMedicamento) {
        this.prescricaoMedicamento = prescricaoMedicamento;
    }
}
