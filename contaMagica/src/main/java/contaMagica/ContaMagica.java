package contaMagica;

public class ContaMagica {
  public static final int SILVER = 0;

  private double saldo;
  private int status;

  public ContaMagica() {
    this.saldo = 0;
    this.status = SILVER;
  }

  public double getSaldo(){
    return this.saldo;
  }
  public void setSaldo(double valor){
    this.saldo += valor;
  }

  public int getStatus(){
    return this.status;
  }

}
