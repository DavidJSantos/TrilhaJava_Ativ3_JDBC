package trilhaJava.ativ3JDBC.application;

import trilhaJava.ativ3JDBC.bean.Veiculo;
import trilhaJava.ativ3JDBC.dao.VeiculoDAO;

import java.util.List;

public class VeiculoTeste {

    public static void main(String[] args) {

        VeiculoDAO veiculoDAO = new VeiculoDAO();

        // Adicionar veiculo
        /*Veiculo novoVeiculo = new Veiculo(
                "GOL", "QQQ1111"
        );
        veiculoDAO.create(novoVeiculo);*/

        // Listar Veiculos
        List<Veiculo> veiculos = veiculoDAO.listar();
        veiculos.stream().forEach(System.out::println);

        // Atualizar veiculo
        /*Veiculo veiculo = veiculoDAO.buscaPorId(4);
        veiculo.setModelo("GOL");
        veiculo.setPlaca("GOL0505");

        veiculoDAO.update(veiculo);

        veiculos = veiculoDAO.listar();
        veiculos.stream().forEach(System.out::println);*/


        // Delete
        veiculoDAO.delete(4);
        veiculos = veiculoDAO.listar();
        veiculos.stream().forEach(System.out::println);

    }

}
