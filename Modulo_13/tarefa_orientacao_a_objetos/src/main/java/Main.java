public class Main {
    public static void main(String[] args){
        PessoaFisica pf = new PessoaFisica();
        pf.setNome("Gabriel");
        pf.setSobrenome("Verga");
        pf.setCpf(2387518L);

        System.out.println("Pessoa Fisica");
        System.out.println(pf+"\n");

        PessoaJuridica pj = new PessoaJuridica();
        pj.setNome("Tech. Comp");
        pj.setServicoPrestado("Botique de Software");
        pj.setCnpj(238752318L);

        System.out.println("Pessoa Juridica");
        System.out.println(pj);
    }
}
