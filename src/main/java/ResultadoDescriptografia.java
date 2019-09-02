import org.apache.commons.codec.digest.DigestUtils;

public class ResultadoDescriptografia {
    public String texto = "";
    public String sha1() {
        return DigestUtils.sha1Hex(texto);
    };
}
