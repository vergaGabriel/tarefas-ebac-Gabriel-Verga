public class PessoaJuridica extends Pessoa{
    private Long cnpj;

    private String servicoPrestado;

    public String getServicoPrestado() {
        return servicoPrestado;
    }

    public void setServicoPrestado(String servicoPrestado) {
        this.servicoPrestado = servicoPrestado;
    }

    public Long getCnpj() {
        return cnpj;
    }

    public void setCnpj(Long cnpj) {
        this.cnpj = cnpj;
    }

    @Override
    public String toString() {
        return "Nome = " + this.getNome() + "\n" +
                "Serviço Prestado = " + this.servicoPrestado + "\n" +
                "CNPJ = " + this.cnpj;
    }
}
