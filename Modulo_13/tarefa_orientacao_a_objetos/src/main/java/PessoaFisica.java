public class PessoaFisica extends Pessoa{
    private Long cpf;

    private String sobrenome;

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public Long getCpf() {
        return cpf;
    }

    public void setCpf(Long cpf) {
        this.cpf = cpf;
    }

    @Override
    public String toString() {
        return "Nome = " + this.getNome() + "\n" +
                "Sobrenome = " + this.sobrenome + "\n" +
                "CPF = " + this.cpf;
    }
}
