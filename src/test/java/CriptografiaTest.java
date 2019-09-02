import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.params.provider.Arguments.arguments;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class CriptografiaTest {
    private final Criptografia criptografia = new Criptografia();

    @DisplayName("Validar a criptografia")
    @ParameterizedTest
    @MethodSource("testesCriptografia")
    public void testarCriptografia(String texto, int qtdCasas, String esperado, String sha1Esperado){
        ResultadoDescriptografia resultado = criptografia.Descriptografar(texto, qtdCasas);
        assertEquals(esperado, resultado.texto);
        assertEquals(sha1Esperado, resultado.sha1());
    }

    static Stream<Arguments> testesCriptografia() {
        return Stream.of(
                arguments("d oljhlud udsrvd pduurp vdowrx vreuh r fdfkruur fdqvdgr",
                        3, "a ligeira raposa marrom saltou sobre o cachorro cansado", "b5395144deedf4a152cf3180b7deaa5ba0d468bd"),
                arguments("1.ejgwf.uwjyf.j.gwfshf", 5, "1.zebra.preta.e.branca", "a4bd199d86ee6fb8c36af9411216f01c6684a20a"),
                arguments("hizipstiv: er svkermwq xlex xyvrw gsjjii mrxs gshi. yrorsar",
                        4, "developer: an organism that turns coffee into code. unknown", "9c7354ba4d33fcaa91c1050f15214497dca9cb56")
        );
    }
}
