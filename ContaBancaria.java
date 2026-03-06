public class ContaBancaria{
    private int numero;
    private int agencia;
    private double saldo;
    private String cliente;

    // construtor
    public ContaBancaria(int agencia, int numero, String cliente, double saldo){
        this.numero = numero;
        this.agencia = agencia;
        this.cliente = cliente;
        this.saldo = saldo;
    }

    public ContaBancaria(int agencia, int numero){
        this.agencia = agencia;
        this.numero = numero;
        this.saldo = 0;
        this.cliente = "Não informado";
    }
    public double version(){
        return saldo;
    }

    public void sacar(double valor){
        saldo = saldo - valor;
    }

    public void sacar(){
        saldo = saldo - 100.0;
    }

    public void depositar(double valor){
        saldo = saldo + valor;
    }

    // get e set
    public String getCliente(){
        return cliente;
    }

    public void setCliente(String cliente){
        this.cliente = cliente;
    }

    public double getSaldo(){
        return saldo;
    }

    public void setSaldo(double saldo){
        this.saldo = saldo;
    }

    public int getNumero(){
        return numero;
    }

    public void setNumero(int numero){
        this.numero = numero;
    }

    public int getAgencia(){
        return agencia;
    }

    public void setAgencia(int agencia)
    {
        this.agencia = agencia;
    }
    //metodos gerais

    // toString



    public String toString(){
        return "\nAgência: "+ agencia +
        "\nNúmero: " + numero +
        "\nCliente: " + cliente +
        "\nSaldo: R$" + saldo;
        }
}