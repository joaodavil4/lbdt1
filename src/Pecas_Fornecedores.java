import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Connection;

public class Pecas_Fornecedores {

	private String codigo_peca;
	private String codigo_fornecedor;
	private double preco;
	private Connection conexao;
	
	public Pecas_Fornecedores(String codpeca, String codfornecedor, double preco) {
		this.codigo_peca = codpeca;
		this.codigo_fornecedor = codfornecedor;
		this.preco = preco;
		conexaoBD();
	}
	
	public Pecas_Fornecedores() {
		conexaoBD();
	}
	
	public void insertInto() {
        String sql ="INSERT INTO pecas (codigo_peca, codigo_fornecedor, preco_peca)"+
        "VALUES (?,?)";
        try{
            PreparedStatement stmt = conexao.prepareStatement(sql);

            stmt.setString(1, this.codigo_peca);  //varchar
            stmt.setString(2, this.codigo_fornecedor);  //varchar
            stmt.setDouble(3, this.preco); //double 3,00

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
