package teste2;
import java.util.ArrayList;
import java.util.List;

public class Paciente {
    private String nome;
    private String cpf;
    private String telefone;
    private String data;
    private boolean jaFoiPaciente;
    private boolean consultaRealizada;
    private String observacoes;
    private boolean observacoesEditavel;
    private boolean botaoFinalizar;

    public Paciente(String nome, String cpf, String telefone, String data, boolean jaFoiPaciente) {
        this.nome = nome;
        this.cpf = cpf;
        this.telefone = telefone;
        this.data = data;
        this.jaFoiPaciente = jaFoiPaciente;
        this.consultaRealizada = false;
        this.observacoes = "";
        this.observacoesEditavel = true;
        this.botaoFinalizar = true;
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

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public boolean isJaFoiPaciente() {
        return jaFoiPaciente;
    }

    public void setJaFoiPaciente(boolean jaFoiPaciente) {
        this.jaFoiPaciente = jaFoiPaciente;
    }

    public boolean isConsultaRealizada() {
        return consultaRealizada;
    }

    public void setConsultaRealizada(boolean consultaRealizada) {
        this.consultaRealizada = consultaRealizada;
    }

    public String getObservacoes() {
        return observacoes;
    }

    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }
    
    public boolean isObservacoesEditavel() {
        return observacoesEditavel;
    }

    public void setObservacoesEditavel(boolean observacoesEditavel) {
        this.observacoesEditavel = observacoesEditavel;
    }
    
    public boolean isBotaoFinalizar() {
        return botaoFinalizar;
    }

    public void setBotaoFinalizar(boolean botaoFinalizar) {
        this.botaoFinalizar = botaoFinalizar;
    }
}