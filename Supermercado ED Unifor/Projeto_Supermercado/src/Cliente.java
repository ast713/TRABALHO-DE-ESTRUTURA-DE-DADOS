public class Cliente {
    private String nome;
    private String cpf;
    private String email;
    private String telefone;
    private boolean receberPromocoes; // Novo campo para armazenar a opção de receber promoções via e-mail

    public Cliente(String nome, String cpf, String email, String telefone, boolean receberPromocoes) {
        this.nome = nome;
        this.cpf = cpf;
        this.email = email;
        this.telefone = telefone;
        this.receberPromocoes = receberPromocoes;
    }

    // Getters e Setters
    public boolean isReceberPromocoes() {
        return receberPromocoes;
    }

    public void setReceberPromocoes(boolean receberPromocoes) {
        this.receberPromocoes = receberPromocoes;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
}
