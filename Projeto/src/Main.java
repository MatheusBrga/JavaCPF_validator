public class Main {
    public static void main(String[] args) {
        // Entrada do CPF
        String cpfInput = "727.400.590-19"; // Exemplo de um "CPF" para mostrar o funcionamento do código

        // Remove os pontos e o hífen, e extrai os 9 primeiros dígitos
        String baseDigits = cpfInput.replace(".", "").replace("-", "").substring(0, 9);
        int weight = 10; // Peso regressivo começa em 10
        int firstSum = 0;

        // Calcula a soma ponderada para o primeiro dígito verificador
        for (int i = 0; i < baseDigits.length(); i++) {
            char currentDigit = baseDigits.charAt(i); // Obtém o dígito atual
            int numericValue = currentDigit - '0'; // Converte o caractere em número inteiro
            int product = numericValue * weight; // Multiplica o número pelo peso regressivo
            firstSum += product; // Adiciona o produto à soma total
            weight--; // Diminui o peso regressivo
        }

        // Calcula o primeiro dígito verificador
        int firstVerifier = (firstSum * 10) % 11;
        if (firstVerifier > 9) {
            firstVerifier = 0; // Ajusta o dígito para 0 se for maior que 9
        }

        // Combina os 9 dígitos base com o primeiro dígito verificador
        String baseWithFirstVerifier = baseDigits + firstVerifier;
        weight = 11; // Peso regressivo começa em 11 para o segundo dígito
        int secondSum = 0;

        // Calcula a soma ponderada para o segundo dígito verificador
        for (int i = 0; i < baseWithFirstVerifier.length(); i++) {
            char currentDigit = baseWithFirstVerifier.charAt(i); // Obtém o dígito atual
            int numericValue = currentDigit - '0'; // Converte o caractere em número inteiro
            int product = numericValue * weight; // Multiplica o número pelo peso regressivo
            secondSum += product; // Adiciona o produto à soma total
            weight--; // Diminui o peso regressivo
        }

        // Calcula o segundo dígito verificador
        int secondVerifier = (secondSum * 10) % 11;
        if (secondVerifier > 9) {
            secondVerifier = 0; // Ajusta o dígito para 0 se for maior que 9
        }

        // Exibe os resultados
        System.out.println("Processo de Validação do CPF:");
        System.out.println("-----------------------------");
        System.out.println("CPF Original: " + cpfInput);
        System.out.println("Primeiro Dígito Verificador: " + firstVerifier);
        System.out.println("Segundo Dígito Verificador: " + secondVerifier);
        System.out.println("CPF Completo: " + baseWithFirstVerifier + secondVerifier);
    }
}
