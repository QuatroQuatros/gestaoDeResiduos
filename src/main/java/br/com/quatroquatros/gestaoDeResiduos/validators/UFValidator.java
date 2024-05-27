package br.com.quatroquatros.gestaoDeResiduos.validators;

import java.util.Arrays;
import java.util.List;

public class UFValidator {

    private static final List<String> UFS_VALIDAS = Arrays.asList(
            "AC", "AL", "AP", "AM", "BA", "CE", "DF", "ES", "GO", "MA", "MT", "MS",
            "MG", "PA", "PB", "PR", "PE", "PI", "RJ", "RN", "RS", "RO", "RR", "SC",
            "SP", "SE", "TO"
    );
    public static boolean validarUF(String uf) {
        return UFS_VALIDAS.contains(uf.toUpperCase());
    }
}
