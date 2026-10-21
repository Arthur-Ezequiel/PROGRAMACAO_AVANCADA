/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package DAO;

import Model.ModelProduto;
import java.util.List;

/**
 *
 * @author Artur
 */
public interface ProdutoDAOInterface {

    boolean inserir(ModelProduto produto);

    ModelProduto buscarPorId(int codProduto);

    List<ModelProduto> listarTodos();

    boolean alterar(ModelProduto produto);

    boolean excluir(int codProduto);
}
