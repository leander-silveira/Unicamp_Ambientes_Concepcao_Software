package mongoProject;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.result.DeleteResult;
import com.mongodb.client.result.UpdateResult;

public class MongoDBConnection {

    private static final String CONNECTION_STRING = "mongodb://localhost:27017"; // URL de conexão do MongoDB
    private static final String DATABASE_NAME = "test"; // Substitua pelo nome do seu banco de dados
    
    
    private MongoClient mongoClient;
    private MongoDatabase database;

    // Método para conectar ao MongoDB
    public void conectar() {
        try {
            mongoClient = MongoClients.create(CONNECTION_STRING);
            database = mongoClient.getDatabase(DATABASE_NAME);
            System.out.println("Conectado ao banco de dados " + DATABASE_NAME);
        } catch (Exception e) {
            System.err.println("Erro ao conectar ao MongoDB: " + e.getMessage());
            e.printStackTrace();
        }
    }
    
    
    // Método para listar
    public void listar() {
        if (database == null) {
            System.err.println("Banco de dados não está conectado. Conecte-se primeiro.");
            return;
        }
        try {
    		MongoCollection<org.bson.Document> colection = database.getCollection("produtos");
    		
    		System.out.println("Imprimindo Produtos");
    		Iterable<org.bson.Document> produtos = colection.find();    		
    		
    		for (org.bson.Document produto : produtos){
    			String id = produto.getString("id");
    			String nome = ((org.bson.Document) produto).getString("nome");
    			String descricao = produto.getString("descricao");
    			String valor = produto.getString("valor");
    			String estado = produto.getString("estado");
    			System.out.println(id + " -- " + nome + " -- " + descricao + " -- " + valor + " - - " + estado);
    		}
    	} catch (Exception e) {
            System.err.println("Erro ao listar coleções: " + e.getMessage());
            e.printStackTrace();
        }
    }
        
	// Método para inserir
    public void inserir(String id, String nome, String descricao, String valor, String estado) {
    	if (database == null) {
    		System.err.println("Banco de dados não está conectado. Conecte-se primeiro.");
    		return;
	    }	
    	try {
    		MongoCollection<org.bson.Document> colection = database.getCollection("produtos");
	      	
	  		org.bson.Document novoProduto = new org.bson.Document("id", id)
	  				   .append("nome", nome)
	                   .append("descricao", descricao)
	                   .append("valor", valor)
	                   .append("estado", estado);
	  	     colection  .insertOne(novoProduto);
	  	     System.out.println("Novo produto inserido com sucesso!");
	      	
	    } catch (Exception e) {
	          System.err.println("Erro ao listar coleções: " + e.getMessage());
	          e.printStackTrace();
	    }
	}
	  
	  
	  // Método para modificar
    public void modificar(String id, String valor) {
    	if (database == null) {
    		System.err.println("Banco de dados não está conectado. Conecte-se primeiro.");
    		return;
	    }
    	try {
    		MongoCollection<org.bson.Document> collection = database.getCollection("produtos");
    		
    		// Cria um documento com os campos atualizados
    		org.bson.Document atualizacoes = new org.bson.Document()
    				.append("id", id)
    				.append("valor", valor);

	        // Define o filtro
    		org.bson.Document filtro = new org.bson.Document("id", id);

    		// Define a atualização que será aplicada
    		org.bson.Document atualizacao = new org.bson.Document("$set", atualizacoes);

    		// Executa a atualização do documento
    		UpdateResult resultado = collection.updateOne(filtro, atualizacao);

    		if (resultado.getMatchedCount() > 0) {
    			System.out.println("Produto modificado com sucesso!");
	        } else {
	        	System.err.println("Nenhum produto encontrado com o ID especificado.");
	        }

    	} catch (Exception e) {
    		System.err.println("Erro ao modificar o produto: " + e.getMessage());
    		e.printStackTrace();
	    }
    }
	  
	// Método para apagar um produto
    public void apagar(String id) {
    	if (database == null) {
    		System.err.println("Banco de dados não está conectado. Conecte-se primeiro.");
    		return;
	    }
    	try {
    		MongoCollection<org.bson.Document> collection = database.getCollection("produtos");	
    		
    		// Define o filtro para encontrar o produto pelo ID
    		org.bson.Document filtro = new org.bson.Document("id", id);

    		// Executa a exclusão do documento
    		DeleteResult resultado = collection.deleteOne(filtro);

    		if (resultado.getDeletedCount() > 0) {
    			System.out.println("Produto apagado com sucesso!");
	        } else {
	        	System.err.println("Nenhum produto encontrado com o ID especificado.");
	        }
    	} catch (Exception e) {
    		System.err.println("Erro ao apagar o produto: " + e.getMessage());
    		e.printStackTrace();
    	}
    }

    //Fechar conexão
    public void fecharConexao() {
    	if(mongoClient != null) {
    		mongoClient.close();
    		System.out.println("Conexão com o MongoDB fechada.");
    	}
    }
	  
    
}
