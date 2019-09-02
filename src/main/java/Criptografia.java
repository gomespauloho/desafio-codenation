public class Criptografia {
    private final int valorA = 97;
    private final int valorZ = 122;
    public ResultadoDescriptografia Descriptografar(String texto, int qtdeCasas){
        String criptografado = texto.toLowerCase();

        ResultadoDescriptografia resultado = new ResultadoDescriptografia();

        for(int i = 0; i < criptografado.length(); i++){
            int ascii = criptografado.charAt(i);

            // valores fora de a-z são desconsiderados
            if (ascii < valorA || ascii > valorZ){
                resultado.texto += criptografado.charAt(i);
                continue;
            }
            int novo = ascii - qtdeCasas;
            // substituição simples
            if (novo >= valorA){
                resultado.texto += Character.toString((char) novo);
                continue;
            }
            // trata posições que ultrapassam os limites
            int dif = valorA - novo;
            novo = (valorZ + 1) - dif;

            resultado.texto += Character.toString((char) novo);
        }

        return resultado;
    }
}
