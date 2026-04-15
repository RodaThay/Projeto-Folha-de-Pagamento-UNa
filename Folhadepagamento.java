
import java.util.ArrayList;
import java.util.Scanner;

public class Folhadepagamento {

    public static void main(String[] args) {
        // Entrada de dados padrão via teclado
        Scanner scanner = new Scanner(System.in); // scanner para receber informações do usuário

        final double salariobase = 2000.00; // salário base para o cálculo do salário final
        ArrayList<String> Nome = new ArrayList<>(); // lista para armazenar os nomes dos funcionários cadastrados
        ArrayList<String> matricula = new ArrayList<>(); // lista para armazenar as matrículas/CPFs dos funcionários
        ArrayList<Double> salarioFinal = new ArrayList<>(); // lista para armazenar o salário final de cada funcionário

        // Variável de controle do menu
        int opcao = -1;
        while (opcao != 0) { // enquanto a opção for diferente de 0, o sistema continua rodando.
            System.out.println("=======MENU======="); // cabeçalho do menu
            System.out.println("1 - Cadastrar Funcionario"); // opção de cadastro
            System.out.println("2 - Listar Funcionarios"); // opção de listagem
            System.out.println("3 - Gerar Folha de Pagamento"); // opção de geração da folha
            System.out.println("0 - Sair"); // opção de saída
            System.out.println("==================");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt(); // captura a opção selecionada pelo usuário

            switch (opcao) {
                case 1:
                    // Chama o método de cadastro
                    cadastrarFuncionarios(Nome, matricula, salarioFinal, salariobase, scanner);
                    break;
                case 2:
                    // Chama o método de listagem simples (sem salários)
                    listarFuncionarios(Nome, matricula, scanner);
                    break;
                case 3:
                    // Chama o método da folha de pagamento (com os cálculos e bônus)
                    gerarFolhaPagamento(Nome, matricula, salarioFinal, salariobase, scanner);
                    break;
                case 0:
                    System.out.println("Saindo do sistema... Até logo!"); // mensagem de encerramento
                    break;
                default:
                    System.out.println("Opção inválida! Tente novamente."); // trata opção inválida
                    break;
            }
        }

    }

    public static void cadastrarFuncionarios(ArrayList<String> nomes, ArrayList<String> matriculas, ArrayList<Double> salarioFinal, double salarioBase, Scanner scanner) {
        // Tela de cadastro de funcionário
        System.out.println("======= CADASTRO DE FUNCIONARIO =======");
        System.out.println("Digite o nome do funcionario: ");
        String nome = scanner.next(); // ler o nome do funcionario.

        System.out.println("Digite a matricula do funcionario ou CPF: ");
        String cadastro = scanner.next(); // ler a matricula do funcionario.
        boolean jaExiste = false; // para verificar se a matrícula já existe
        int i = 0;
        while (i < matriculas.size()) {
            if (matriculas.get(i).equals(cadastro)) {
                jaExiste = true;
                break;
            }
            i++;
        }
        if (jaExiste) {
            System.out.println("Matrícula já cadastrada! Tente novamente.");// mensagem de erro para matrícula duplicada
            System.out.println("Pressione ENTER para voltar ao menu");
            scanner.nextLine();
            scanner.nextLine();
            return;

        }

        // menu de escolha de cargo
        System.out.println("1 - Funcionario Padrao");
        System.out.println("2 - Funcionario Comissionado");
        System.out.println("3 - Funcionario de producao");
        System.out.print("Escolha o cargo do funcionario: ");
        int cargo = scanner.nextInt();

        // calcula o salário final de acordo com o cargo e valores informados
        double resultado = calcularSalarioFinal(cargo, salarioBase, scanner);

        // armazena os dados na respectiva lista
        nomes.add(nome);
        matriculas.add(cadastro);
        salarioFinal.add(resultado);

        System.out.println("Funcionário cadastrado com sucesso!");
        System.out.println("Pressione ENTER para voltar ao menu");
        scanner.nextLine();
        scanner.nextLine();
    }

    public static double calcularSalarioFinal(int cargo, double salariobase, Scanner scanner) {
        // Método para calcular o salário dos funcionários conforme o cargo
        double resultado = salariobase; // salário inicial = base

        if (cargo == 1) { // funcionário padrão: salário base
            resultado = salariobase;

        } else if (cargo == 2) { // funcionário comissionado: base + 10% sobre vendas
            System.out.println("Digite o valor das vendas do funcionario: ");
            double vendas = scanner.nextDouble(); // ler o valor das vendas do funcionário
            resultado = salariobase + (vendas * 0.10); // calculo da comissão

        } else if (cargo == 3) { // funcionário de produção: base + R$16 por item produzido
            System.out.println("Digite a quantidade de producao do funcionario: ");
            int producao = scanner.nextInt(); // ler a produção do funcionário
            resultado = salariobase + (producao * 16); // calculo do adicional por produção

        } else {
            // cargo inválido não altera o salário base, apenas informa o erro
            System.out.println("Cargo invalido!");
            System.out.println("Pressione enter para voltar ao menu");
            scanner.nextLine();
            scanner.nextLine();
        }
        return resultado; // retorna o salário final calculado
    }

    public static void listarFuncionarios(ArrayList<String> nomes, ArrayList<String> matriculas, Scanner scanner) {
        // Verifica se há algum funcionário cadastrado antes de exibir
        if (nomes.isEmpty()) {
            System.out.println("Nenhum funcionario cadastrado.");
            return;
        }

        System.out.println("\n--- LISTA DE FUNCIONÁRIOS ---"); // cabeçalho da listagem
        for (int i = 0; i < nomes.size(); i++) {
            // imprime nome e matrícula de cada funcionário
            System.out.println("Nome: " + nomes.get(i) + " | Matrícula: " + matriculas.get(i));
        }
        System.out.println("-----------------------------");
        System.out.println("Pressione ENTER para voltar ao menu");
        scanner.nextLine();
        scanner.nextLine();
    }

    public static void gerarFolhaPagamento(ArrayList<String> nomes, ArrayList<String> matriculas, ArrayList<Double> salarioFinal, double salariobase, Scanner scanner) {
        // Gera a folha de pagamento para todos funcionários cadastrados
        if (nomes.isEmpty()) {
            System.out.println("Nenhum funcionário encontrado");
            return;
        }

        double totalDaEmpresa = 0; // acumula o custo total da folha

        for (int i = 0; i < nomes.size(); i++) {
            double totalReceber = salarioFinal.get(i); // salário calculado do funcionário
            double bonus = totalReceber - salariobase; // bônus é o valor acima do salário base
            totalDaEmpresa += totalReceber; // adiciona no total geral

            System.out.println("------------------------------------------");
            System.out.println("NOME: " + nomes.get(i));
            System.out.println("MATRÍCULA: " + matriculas.get(i));
            System.out.println("Salário Base: R$ " + salariobase);
            System.out.println("Adicionais/Bônus: R$ " + String.format("%.2f", bonus));
            System.out.println("TOTAL A RECEBER: R$ " + totalReceber);
        }

        // Exibição do total da folha de pagamento para a empresa
        System.out.println("------------------------------------------");
        System.out.println("TOTAL GERAL DA FOLHA: R$ " + totalDaEmpresa);
        System.out.println("------------------------------------------\n");
        System.out.println("Pressione ENTER para voltar ao menu");
        scanner.nextLine();
        scanner.nextLine();
    }
}
