public class ContaBancaria{
    private int numero;
    private int agencia;
    private double saldo;
    private String cliente;
   
    public ContaBancaria(int agencia, int numero, String cliente, double saldo){
        this.agencia = agencia;
        this.numero = numero;
        this.cliente = cliente;
        this.saldo = saldo;
    }
   
    public void setCliente(String cliente){
        this.cliente = cliente;
    }

    public void setSaldo(double saldo){
        this.saldo = saldo;
    }

    public void setNumero(int numero){
        this.numero = numero;
    }

    public void setAgencia(int NovaAgencia)
    {
        this.agencia = NovaAgencia;
    }
    public double getSaldo()
    {
        return saldo;
    }    // toString
   
    public void depositar(double valor) {
        saldo = saldo + valor;
    }
   
    public void depositar(double valor, double taxa) {
        saldo = saldo + valor - taxa;
    }

    public void saque(double saque)
    {
        saldo = saldo - saque;
    }
    public void saque(double saque, int antecipacao)
    {
        saldo = saldo - (saque + (saque + antecipacao * 0.10));
    }



    public String toString(){
        return "\n - Agência: "+ agencia +
        "\n - Número: " + numero +
        "\n - Cliente: " + cliente +
        "\n - Saldo: R$" + saldo;
        }
}