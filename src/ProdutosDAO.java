/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Adm
 */

// imports que você já tem
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class ProdutosDAO {

    Connection conn;
    PreparedStatement prep;
    ResultSet resultset;

    // MÉTODO PARA CADASTRAR PRODUTO NO BANCO (agora retorna boolean)
    public boolean cadastrarProduto(ProdutosDTO produto) {

        String sql = "INSERT INTO produtos (nome, valor, status) VALUES (?, ?, ?)";

        try {
            // Use aqui sua classe que fornece a conexão. 
            // No seu projeto você comentou conn = new conectaDAO().connectDB();
            // Então eu uso esse mesmo método abaixo:
            conn = new conectaDAO().connectDB();

            prep = conn.prepareStatement(sql);
            prep.setString(1, produto.getNome());
            prep.setInt(2, produto.getValor());
            prep.setString(3, produto.getStatus());

            int linhas = prep.executeUpdate();

            // opcional: fechar recursos (melhor prática)
            try { if (prep != null) prep.close(); } catch (Exception ex) {}
            try { if (conn != null) conn.close(); } catch (Exception ex) {}

            return linhas > 0;

        } catch (SQLException e) {
            // mostra mensagem e retorna false em caso de erro
            JOptionPane.showMessageDialog(null, "Erro ao cadastrar produto: " + e.getMessage());
            e.printStackTrace();
            return false;
        }
    }

    // ... resto da classe (listarProdutos etc.)

    ArrayList<ProdutosDTO> listarProdutos() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}


