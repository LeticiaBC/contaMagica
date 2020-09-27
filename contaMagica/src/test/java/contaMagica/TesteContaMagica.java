package contaMagica;

//import org.junit.Test;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

public class TesteContaMagica {
    public static final int SILVER = 0;

    @Test
    public void verificaCategoriaSilver() {
        ContaMagica contamagica = new ContaMagica();
        Assertions.assertTrue((contamagica.getSaldo() < 50000) && (contamagica.getStatus() == SILVER));
    }

}
