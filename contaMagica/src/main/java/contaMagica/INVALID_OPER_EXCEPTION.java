package contaMagica;

public class INVALID_OPER_EXCEPTION extends Exception{

    private static final long serialVersionUID = 1L;
    private int valor;

    public INVALID_OPER_EXCEPTION(int valor){
        super();
        this.valor = valor;
    }
}
