package trilhaJava.ativ3JDBC.dao;

import trilhaJava.ativ3JDBC.bean.Veiculo;
import trilhaJava.ativ3JDBC.connection.ConnectionFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class VeiculoDAO {

    public void create(Veiculo veiculo){

        try (Connection con = ConnectionFactory.getConnection()){
            String sql = "INSERT INTO veiculo(modelo, placa) VALUES(?, ?)";

            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, veiculo.getModelo());
            stmt.setString(2, veiculo.getPlaca());

            int rowsAffected = stmt.executeUpdate();

            System.out.printf("Veículo inserido com sucesso! ( %d linha(s) inserida(s) )%n", rowsAffected);

        }catch (SQLException e){
            System.out.println("Falha ao inserir veiculo!");
            e.printStackTrace();
        }
    }

    public List<Veiculo> listar(){

        List<Veiculo> veiculos = new ArrayList<>();

        try (Connection con = ConnectionFactory.getConnection()){

            String sql = "SELECT * FROM veiculo";
            PreparedStatement stmt = con.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()){
                int id = rs.getInt("id");
                String modelo = rs.getString("modelo");
                String placa = rs.getString("placa");

                veiculos.add(new Veiculo(
                        id,
                        modelo,
                        placa
                ));
            }


        }catch (SQLException e){
            System.out.println("Falha ao listar veículos!");
            e.printStackTrace();
        }
        return veiculos;
    }

    public Veiculo buscaPorId(int id){

        Veiculo veiculo = new Veiculo();

        try (Connection con = ConnectionFactory.getConnection()){
            String sql = "SELECT * FROM veiculo WHERE id = ?";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()){
                veiculo.setId(rs.getInt("id"));
                veiculo.setModelo(rs.getString("modelo"));
                veiculo.setPlaca(rs.getString("placa"));
            }

        }
        catch (SQLException e){
            System.out.println("Falha na busca por ID!");
            e.printStackTrace();
        }
        return veiculo;
    }

    public void update(Veiculo veiculo){
        try(Connection con = ConnectionFactory.getConnection()){
            String sql = "UPDATE veiculo SET modelo = ?, placa = ? WHERE id = ?";

            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, veiculo.getModelo());
            stmt.setString(2, veiculo.getPlaca());
            stmt.setInt(3, veiculo.getId());

            int rowsAffected = stmt.executeUpdate();

            System.out.printf("Veículo atualizado com sucesso! ( %d linha(s) atualizada(s) )%n", rowsAffected);

        }
        catch (SQLException e){
            System.out.println("Falha ao atualizar veiculo!");
            e.printStackTrace();
        }
    }

    public void delete(int id){
        try (Connection con = ConnectionFactory.getConnection()){
            String sql = "DELETE FROM veiculo WHERE id = ?";

            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, id);

            int rowAffected = stmt.executeUpdate();

            System.out.printf("Veículo removido com sucesso! ( %d linha(s) afetada(s) )%n", rowAffected);
        }
        catch (SQLException e){
            System.out.println("Falha ao remover veículo!");
            e.printStackTrace();
        }


    }






}
