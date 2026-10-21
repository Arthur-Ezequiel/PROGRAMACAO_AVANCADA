/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package DAO;

import Model.ModelCliente;
import java.util.List;

/**
 *
 * @author Artur
 */
public interface ClienteDAOInterdace {

    boolean inserir(ModelCliente cliente);

    ModelCliente buscarPorId(int codCliente);

    List<ModelCliente> listarTodos();

    boolean alterar(ModelCliente cliente);

    boolean excluir(int codCliente);
}
