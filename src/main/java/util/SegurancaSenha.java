/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package util;

import java.security.SecureRandom;
import java.security.spec.KeySpec;
import java.util.Base64;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;

/**
 *
 * @author Artur
 */
public class SegurancaSenha {

    private static final int ITERACOES = 120000;
    private static final int TAMANHO_HASH = 256;

    public static String gerarHash(char[] senha) throws Exception {

        byte[] salt = new byte[16];
        new SecureRandom().nextBytes(salt);

        PBEKeySpec spec = new PBEKeySpec(
                senha, salt, ITERACOES, TAMANHO_HASH
        );

        try {
            byte[] hash = SecretKeyFactory
                    .getInstance("PBKDF2WithHmacSHA256")
                    .generateSecret(spec)
                    .getEncoded();

            return "pbkdf2$" + ITERACOES + "$"
                    + Base64.getEncoder().encodeToString(salt) + "$"
                    + Base64.getEncoder().encodeToString(hash);

        } finally {
            spec.clearPassword();
        }
    }

    public static boolean verificar(
            char[] senha, String hashArmazenado) throws Exception {

        String[] partes = hashArmazenado.split("\\$");

        if (partes.length != 4 || !partes[0].equals("pbkdf2")) {
            return false;
        }

        int iteracoes = Integer.parseInt(partes[1]);

        if (iteracoes < 10000 || iteracoes > 1000000) {
            return false;
        }

        byte[] salt = Base64.getDecoder().decode(partes[2]);
        byte[] hashOriginal = Base64.getDecoder().decode(partes[3]);

        PBEKeySpec spec = new PBEKeySpec(
                senha, salt, iteracoes, hashOriginal.length * 8
        );

        try {
            byte[] hashCalculado = SecretKeyFactory
                    .getInstance("PBKDF2WithHmacSHA256")
                    .generateSecret(spec)
                    .getEncoded();

            return java.security.MessageDigest.isEqual(
                    hashOriginal, hashCalculado
            );

        } finally {
            spec.clearPassword();
        }
    }
}
