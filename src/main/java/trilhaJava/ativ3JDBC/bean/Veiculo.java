package trilhaJava.ativ3JDBC.bean;

public class Veiculo {

    private Integer id;
    private String modelo;
    private String placa;

    public Veiculo() {
    }

    public Veiculo(String modelo, String placa){
        this.modelo = modelo;
        this.placa = placa;
    }

    public Veiculo(Integer id, String modelo, String placa) {
        this.id = id;
        this.modelo = modelo;
        this.placa = placa;
    }

    public Integer getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    @Override
    public String toString() {
        return "Veiculo {" +
                "id: " + id +
                ", modelo: '" + modelo + '\'' +
                ", placa: '" + placa + '\'' +
                '}'
                ;
    }
}
