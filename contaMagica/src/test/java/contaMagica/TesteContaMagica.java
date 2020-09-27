package contaMagica;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

public class TesteContaMagica {
    public static final int SILVER = 0;
    public static final int GOLD = 1;

    @Test
    public void verificaCategoriaSilver() {
        final ContaMagica contamagica = new ContaMagica();
        Assertions.assertTrue((contamagica.getSaldo() < 50000) && (contamagica.getStatus() == SILVER));
    }

    @Test
    public void verificaSaldoNegativo() throws INVALID_OPER_EXCEPTION {
        final ContaMagica contaMagica = new ContaMagica();
        contaMagica.deposito(10000);
        Assertions.assertThrows(INVALID_OPER_EXCEPTION.class, () -> {
            contaMagica.retirada(20000);
        });
    }

    @Test
    public void verificaOperacaoDepositoNegativa() {
        final ContaMagica contaMagica = new ContaMagica();
        Assertions.assertThrows(INVALID_OPER_EXCEPTION.class, () -> {
            contaMagica.deposito(-1);
        });
    }

    @Test
    public void verificaOperacaoRetiradaNegativa() {
        final ContaMagica contaMagica = new ContaMagica();
        Assertions.assertThrows(INVALID_OPER_EXCEPTION.class, () -> {
            contaMagica.retirada(-10000);
        });
    }

    @Test
    public void verificaRetiradaDowngradeGoldSilver() throws INVALID_OPER_EXCEPTION {
        final ContaMagica contaMagica = new ContaMagica();
        contaMagica.deposito(75000);
        contaMagica.retirada(50001);
        System.out.println(contaMagica.getSaldo());
        Assertions.assertTrue((contaMagica.getStatus() == SILVER) && (contaMagica.getSaldo() == 24999));
    }

    @Test
    public void verificaRetiradaDowngradePlatinumGold() throws INVALID_OPER_EXCEPTION {
        final ContaMagica contaMagica = new ContaMagica();
        contaMagica.deposito(150000);
        contaMagica.deposito(50000);
        contaMagica.retirada((100001 + 500));
        System.out.println(contaMagica.getSaldo());
        Assertions.assertTrue((contaMagica.getStatus() == GOLD) && (contaMagica.getSaldo() == 99999));
    }

    @Test
    public void verificaRetiradaDowngradePlatinumSilver() throws INVALID_OPER_EXCEPTION {
        final ContaMagica contaMagica = new ContaMagica();
        contaMagica.deposito(150000);
        contaMagica.deposito(50000);
        contaMagica.retirada((175001+500));
        System.out.println(contaMagica.getSaldo());
        Assertions.assertFalse(contaMagica.getStatus() == SILVER); 
    } 

}
