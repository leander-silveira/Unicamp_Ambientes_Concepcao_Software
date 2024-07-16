package mongoProject;

public class MongoAppMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        MongoDBConnection dbConnection = new MongoDBConnection();

        // Conectar ao MongoDB
        dbConnection.conectar();

        //Listar
        dbConnection.listar();
        
        //inserir
        dbConnection.inserir("100", "NovoProduto", "Descrição do Novo Produto", "100.00", "Disponível");

        // Listar
        dbConnection.listar();       
      
        //Modificar valor
        dbConnection.modificar("100", "1200");
        
        //Listar
        dbConnection.listar();
       
        //Apagar
        dbConnection.apagar("100");
        
        // Listar
        dbConnection.listar();
        
        //Fechar conexão
        dbConnection.fecharConexao();

	}

}
