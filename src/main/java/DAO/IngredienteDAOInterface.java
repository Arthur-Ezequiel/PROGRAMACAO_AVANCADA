/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package DAO;

import Model.ModelIngrediente;
import java.util.List;

/**
 *
 * @author Artur
 */
public interface IngredienteDAOInterface {

    boolean inserir(ModelIngrediente ingrediente);

    ModelIngrediente buscarPorId(int codIngrediente);

    List<ModelIngrediente> listarTodos();

    boolean alterar(ModelIngrediente ingrediente);

    boolean excluir(int codIngrediente);
}
