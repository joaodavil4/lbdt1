import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class Pecas {
	private String codigo;
	private String descricao;
	private Connection conexao;
	
	public Pecas(String codigo, String descricao) {
		this.codigo = codigo;
		this.descricao = descricao;
		conexaoBD();
	}
	
	public Pecas() {
		conexaoBD();
	}
	
	public void insertInto() {
        String sql ="INSERT INTO pecas (codigo_peca, descricao)"+
        "VALUES (?,?)";
        try{
            PreparedStatement stmt = conexao.prepareStatement(sql);

            stmt.setString(1, this.codigo);  //varchar
            stmt.setString(2, this.descricao);  //varchar

            stmt.execute();
            conexao.close();
        }catch(Exception e){
            System.out.println("Erro: " + e);
        }

    }
	
    public void conexaoBD(){
        try {
            conexao = DriverManager.getConnection("jdbc:oracle:thin:@//camburi.pucrs.br:1521/facin11g", "bh111057", "BH111057");
        }catch(Exception e){
            System.out.println("Erro: " + e);
        }
    }
}

