/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import DAO.UsuariosDAO;

/**
 *
 * @author Artur
 */
public class ControllerUsuarios {

    private final UsuariosDAO usuarioDAO = new UsuariosDAO();

    public boolean autenticar(String login, char[] senha)
            throws Exception {

        return usuarioDAO.autenticar(login, senha);
    }
}
