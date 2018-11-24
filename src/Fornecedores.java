import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Connection;

public class Fornecedores {
	private String codigo;
	private String nome;
	private Date data;
	private Connection conexao;
	

	public Fornecedores(String cod, String nome, Date data) {
		this.codigo = cod;
		this.nome = nome;
		this.data = data;
		conexaoBD();
	}

	public Fornecedores() {
		conexaoBD();
	}
	
	public void insertInto() {
        String sql ="INSERT INTO fornecedores (codigo_fornecedor, nome, data_cadastro)"+
        "VALUES (?,?,?)";
        try{
            PreparedStatement stmt = conexao.prepareStatement(sql);

            stmt.setString(1, this.codigo);  //varchar
            stmt.setString(2, this.nome);  //varchar
            stmt.setDate(3, data); //date 'dd/mm/yy'

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
	

