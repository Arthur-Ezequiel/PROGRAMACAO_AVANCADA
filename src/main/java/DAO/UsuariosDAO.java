/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Connection.Conexao;
import Model.ModelUsuarios;
import util.SegurancaSenha;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Artur
 */
public class UsuariosDAO {

    public ModelUsuarios buscarPorLogin(String login) throws SQLException {

        String sql = "SELECT id, nome, login, senha_hash FROM usuarios WHERE login = ?";

        try (Connection conexao = Conexao.conectar(); PreparedStatement comando = conexao.prepareStatement(sql)) {

            comando.setString(1, login);

            try (ResultSet resultado = comando.executeQuery()) {

                if (resultado.next()) {

                    ModelUsuarios usuario = new ModelUsuarios();

                    usuario.setId(resultado.getInt("id"));
                    usuario.setNome(resultado.getString("nome"));
                    usuario.setLogin(resultado.getString("login"));
                    usuario.setSenhaHash(resultado.getString("senha_hash"));

                    return usuario;
                }
            }
        }

        return null;
    }

    public boolean autenticar(String login, char[] senha)
            throws Exception {

        try {
            ModelUsuarios usuario = buscarPorLogin(login);

            if (usuario == null) {
                return false;
            }

            return SegurancaSenha.verificar(
                    senha,
                    usuario.getSenhaHash()
            );

        } finally {
            java.util.Arrays.fill(senha, '\0');
        }
    }
}
