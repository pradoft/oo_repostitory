import java.util.Scanner;

public class LoginMenu {
    public static void main(String[] args) {
        Scanner Escanear = new Scanner(System.in);
        ContaBancaria login = new ContaBancaria(0, 0, "nenhum no momento", 0);
        System.out.println("====================================");
        System.out.println("         LOGIN DO BANCO       ");
        System.out.println("====================================");
       
        System.out.printf("Digite o numero da sua agencia:");

        login.setAgencia(Escanear.nextInt());
       
        System.out.printf("Digite o seu numero de telefone:");

        login.setNumero(Escanear.nextInt());

        System.out.printf("Digite o seu nome:");

        login.setCliente(Escanear.next());

        System.out.printf("Saldo do Banco:");
        login.setSaldo(Escanear.nextInt());
       
        int opcao = 1, qtddepositos = 0, opcaosaque = 0, antecipacao;
        double verificador;
        while(true)
        {
            System.out.println("\n\nMENU DO BANCO");
            System.out.println("OPÇÕES DISPONIVEIS ABAIXO");
            System.out.println("0 - SAIR");
            System.out.println("1 - DEPOSITAR");
            System.out.println("2 - SAQUE");
            System.out.println("3 - EXIBIR DADOS");
            System.out.printf("Escolha uma opção:");
            opcao = Escanear.nextInt();
            if (opcao == 1)
            {
                System.out.println("\n\nSISTEMA DE DEPÓSITOS");
                System.out.println("ALERTAS: DEPÓSITOS ABAIXO DE 5,00 NÃO SÃO VALIDOS E APÓS 5 DEPÓSITOS HÁ UMA TAXA DE 2,99 SOBRE CADA DEPÓSITO!");
                System.out.println("Saldo Atual R$ " + login.getSaldo());
                System.out.println("Qual valor o senhor(a) deseja depositar?:");
                verificador = Escanear.nextDouble();
                if (verificador < 5.00)
                {
                    System.out.println("ERRO: Digitou um valor abaixo de R$ 5,00");
                }
                else
                {
                    if (qtddepositos < 5)
                    {
                        login.depositar(verificador);
                        System.out.printf("Seu novo saldo: R$ " + login.getSaldo()  + "\n\n");
                        Escanear.nextLine();
                        qtddepositos++;
                    }
                    else
                    {
                        login.depositar(verificador, 2.99);
                        System.out.printf("Seu novo saldo: R$ " + login.getSaldo() + "\n\n");
                        Escanear.nextLine();
                    }
                }
            }
            else if (opcao == 2)
            {
                opcaosaque = 0;
                while(opcaosaque != 1 && opcaosaque != 2)
                {
                    System.out.println("SISTEMA DE SAQUES");
                    System.out.println("1 - SAQUE NORMAL");
                    System.out.println("2 - SAQUE COM ANTECIPAÇÃO \n\n");
                    opcaosaque = Escanear.nextInt();
                    if (opcaosaque == 1)
                    {
                        System.out.println("SAQUE NORMAL");
                        System.out.println("ALERTAS: SE NÃO INFORMAR UM VALOR SERÁ SACADO R$ 49,90 AUTOMATICAMENTE E SAQUES ACIMA DO SEU SALDO ATUAL NÃO SERÃO PERMITIDOS!");
                        System.out.println("Saldo Atual R$ " + login.getSaldo());
                        System.out.println("Qual valor o(a) senhor(a) deseja sacar?:");
                        verificador = Escanear.nextDouble();
                        if (verificador > login.getSaldo())
                        {
                            System.out.println("ERRO: Tentou sacar um valor acima do saldo atual! \n\n");
                        }
                        else if (verificador == 0)
                        {
                            login.saque(49.90);
                            System.out.println("Saldo Novo R$ " + login.getSaldo()  + "\n\n");
                        }
                        else 
                        {
                            login.saque(verificador);
                            System.out.println("Saldo Novo R$ " + login.getSaldo()  + "\n\n");
                        }
                    }
                    else if (opcaosaque == 2)
                    {
                        System.out.println("SAQUE COM ANTECIPAÇÃO");
                        System.out.printf("Qual o valor que o(a) senhor(a) deseja sacar?:");
                        verificador = Escanear.nextDouble();
                        System.out.printf("Quantos dias de antecipação?:");
                        antecipacao = Escanear.nextInt();
                        if (verificador > login.getSaldo())
                        {
                            System.out.println("ERRO: Tentou sacar um valor acima do saldo atual!");
                        }
                        else if (verificador == 0)
                        {
                            login.saque(49.90, antecipacao);
                            System.out.println("Saldo Novo R$ " + login.getSaldo()  + "\n\n");
                        }
                        else 
                        {
                            login.saque(verificador, antecipacao);
                            System.out.println("Saldo Novo R$ " + login.getSaldo()  + "\n\n");
                        }
                    }
                }
            }
            else if (opcao == 3)
            {
                System.out.println("---DADOS DO USÚARIO---");
                System.out.printf(login.toString()  + "\n\n");
            }
            else if (opcao == 0)
            {
                break;
            }
            else 
            {
                System.out.printf("\n\nERRO: Digitou um opção invalida!");
            }
        }
        System.out.println("Até mais!");
        Escanear.close();
        
    }
}