package br.com.gverga;

import br.com.gverga.dao.ClienteMapDAO;
import br.com.gverga.dao.ClienteSetDAO;
import br.com.gverga.dao.IClienteDAO;
import br.com.gverga.domain.Cliente;

import javax.swing.*;

public class App {

    private static IClienteDAO iClienteDAO;

    public static void main(String[] args) {
        iClienteDAO = new ClienteSetDAO();

        String opcao = JOptionPane.showInputDialog(null,
                "Digite 1 para cadastro, 2 para consultar, 3 para exclusão, 4 para alteração ou 5 para sair",
                "Cadastro", JOptionPane.INFORMATION_MESSAGE);

        while (!isOpcaoValida(opcao)) {
            if("".equals(opcao)) {
                sair();
            }
            opcao = JOptionPane.showInputDialog(null,
                    "Opção invalida digite 1 para cadastro, 2 para consultar, 3 para exclusão, 4 para alteração ou 5 para sair",
                    "Green dinner", JOptionPane.INFORMATION_MESSAGE);
        }

        while (isOpcaoValida(opcao)){

            if (isOpcaoSair(opcao)) {
                sair();
            } else if (isCadastro(opcao)) {
                String dados = JOptionPane.showInputDialog(null,
                        "Digite os dados do cliente separados por virgula, conforme exemplo: Nome, CPF, Telefone, Endereço, Número, Cidade, Estado",
                        "Cadastro", JOptionPane.INFORMATION_MESSAGE);
                cadastrar(dados);
            } else if (isConsultar(opcao)) {
                String dados = JOptionPane.showInputDialog(null,
                        "Digite o CPF: ",
                        "Consultar", JOptionPane.INFORMATION_MESSAGE);
                consultar(dados);
            } else if (isExclusao(opcao)) {
                String dados = JOptionPane.showInputDialog(null,
                        "Digite o CPF do cliente que deseja excluir: ",
                        "Exclusão", JOptionPane.INFORMATION_MESSAGE);
                exclusao(dados);
            } else if (isAlteracao(opcao)) {
                String cpf = JOptionPane.showInputDialog(null,
                        "Digite o cpf do cliente que deseja ser alterado: ",
                        "Alteração", JOptionPane.INFORMATION_MESSAGE);

                Cliente cliente = iClienteDAO.consultar(Long.parseLong(cpf));

                if (cliente != null) {
                    String dados = JOptionPane.showInputDialog(null,
                            "Digite os dados novos do cliente separados por virgula, conforme exemplo: Nome, CPF, Telefone, Endereço, Número, Cidade, Estado: ",
                            "Alteração", JOptionPane.INFORMATION_MESSAGE);
                    alteracao(dados);
                } else {
                    JOptionPane.showMessageDialog(null, "Cliente não existe para alteração!", "Erro", JOptionPane.INFORMATION_MESSAGE);
                }

            }

            opcao = JOptionPane.showInputDialog(null,
                    "Digite 1 para cadastro, 2 para consultar, 3 para exclusão, 4 para alteração ou 5 para sair",
                    "Green dinner", JOptionPane.INFORMATION_MESSAGE);
        }

    }

    private static void alteracao(String dados) {
        String[] dadosSeparados = dados.split(",");
        if (dadosSeparados.length < 7) {

            String[] dadosSeparadosNulo = new String[7];
            System.arraycopy(dadosSeparados, 0, dadosSeparadosNulo, 0, dadosSeparados.length);

            for(int i = dadosSeparados.length; i < 7; i++) {
                if (i == 1 || i == 2 || i == 4) {
                    dadosSeparadosNulo[i] = "0";
                    continue;
                }
                dadosSeparadosNulo[i] = "null";
            }

            Cliente cliente = new Cliente(dadosSeparadosNulo[0],dadosSeparadosNulo[1],dadosSeparadosNulo[2],dadosSeparadosNulo[3],dadosSeparadosNulo[4],dadosSeparadosNulo[5],dadosSeparadosNulo[6]);
            Boolean isCadastrado = iClienteDAO.cadastrar(cliente);

            iClienteDAO.alterar(cliente);

            JOptionPane.showMessageDialog(null, "Cliente alterado com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);

        } else {
            Cliente cliente = new Cliente(dadosSeparados[0],dadosSeparados[1],dadosSeparados[2],dadosSeparados[3],dadosSeparados[4],dadosSeparados[5],dadosSeparados[6]);
            Boolean isCadastrado = iClienteDAO.cadastrar(cliente);

            iClienteDAO.alterar(cliente);

            JOptionPane.showMessageDialog(null, "Cliente alterado com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);

        }

    }

    private static boolean isAlteracao(String opcao) {
        if ("4".equals(opcao)) {
            return true;
        }
        return false;
    }

    private static void exclusao(String dados) {
        Cliente cliente = iClienteDAO.consultar(Long.parseLong(dados));

        if (cliente != null) {
            iClienteDAO.excluir(Long.parseLong(dados));
            JOptionPane.showMessageDialog(null, "Cliente excluido: " + cliente.toString(), "Sucesso", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "Cliente não existe ou ja foi excluido!", "Erro", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    private static boolean isExclusao(String opcao) {
        if ("3".equals(opcao)) {
            return true;
        }
        return false;
    }

    private static void consultar(String dados) {
        if (dados.matches("[0-9]+")) {
            Cliente cliente = iClienteDAO.consultar(Long.parseLong(dados));

            if (cliente != null) {
                JOptionPane.showMessageDialog(null, "Cliente encontrado: " + cliente.toString(), "Sucesso", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "Cliente nao encontrado!", "Erro", JOptionPane.INFORMATION_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(null, "CPF invalido para buscar!", "Erro", JOptionPane.INFORMATION_MESSAGE);

        }
    }

    private static boolean isConsultar(String opcao) {
        if ("2".equals(opcao)) {
            return true;
        }
        return false;
    }

    private static void cadastrar(String dados) {
        String[] dadosSeparados = dados.split(",");
        if (dadosSeparados.length < 7) {

            String[] dadosSeparadosNulo = new String[7];
            System.arraycopy(dadosSeparados, 0, dadosSeparadosNulo, 0, dadosSeparados.length);

            for(int i = dadosSeparados.length; i < 7; i++) {
                if (i == 1 || i == 2 || i == 4) {
                    dadosSeparadosNulo[i] = "0";
                    continue;
                }
                dadosSeparadosNulo[i] = "null";
            }

            Cliente cliente = new Cliente(dadosSeparadosNulo[0],dadosSeparadosNulo[1],dadosSeparadosNulo[2],dadosSeparadosNulo[3],dadosSeparadosNulo[4],dadosSeparadosNulo[5],dadosSeparadosNulo[6]);
            Boolean isCadastrado = iClienteDAO.cadastrar(cliente);

            if (isCadastrado) {
                JOptionPane.showMessageDialog(null, "Cliente cadastrado com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "Cliente já se encontra cadastrado!", "Erro", JOptionPane.INFORMATION_MESSAGE);
            }
        } else {
            Cliente cliente = new Cliente(dadosSeparados[0],dadosSeparados[1],dadosSeparados[2],dadosSeparados[3],dadosSeparados[4],dadosSeparados[5],dadosSeparados[6]);
            Boolean isCadastrado = iClienteDAO.cadastrar(cliente);

            if (isCadastrado) {
                JOptionPane.showMessageDialog(null, "Cliente cadastrado com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "Cliente já se encontra cadastrado!", "Erro", JOptionPane.INFORMATION_MESSAGE);
            }
        }
    }

    private static boolean isCadastro(String opcao) {
        if ("1".equals(opcao)) {
            return true;
        }

        return false;
    }

    private static boolean isOpcaoSair(String opcao) {
        if ("5".equals(opcao)) {
            return true;
        }

        return false;
    }

    private static void sair() {
        JOptionPane.showMessageDialog(null, "Até logo!", "Sair", JOptionPane.INFORMATION_MESSAGE);
        System.exit(0);
    }

    private static boolean isOpcaoValida(String opcao) {
        if ("1".equals(opcao) || "2".equals(opcao)
            || "3".equals(opcao) || "4".equals(opcao) || "5".equals(opcao)) {
            return true;
        }
        return false;
    }
    
    private static boolean isOpcaoCadastro(String opcao) {
        if ("1".equals(opcao)) {
            return true;
        }
        
        return false;
    }
}
