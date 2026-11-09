/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package util;

/**
 *
 * @author Artur
 */
public class CriarAdmin {

    public static void main(String[] args) throws Exception {

        String senha = "admin123";

        String hash = SegurancaSenha.gerarHash(senha.toCharArray());

        System.out.println(hash);
    }
}
