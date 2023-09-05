/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DTO.funcionarioDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Aluno
 */
public class FuncionarioDAO {
    Connection conn;
    PreparedStatement pstm;
    
    public void cadastrarFuncionario(funcionarioDTO objfuncionariodto){
        String sql = "insert into tabela (nome, cidade) values(?, ?)";
        
        conn = new ConexaoDAO().conectaBd();
        
        try {
            
            pstm = conn.prepareStatement(sql);
            pstm.setString(1, objfuncionariodto.getNome_funcionario());
            pstm.setString(2, objfuncionariodto.getCidade_funcionario());
            
            pstm.execute();
            pstm.close();
            
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Classe FuncionarioDAO"+ erro);
        }
        
    }
    
}
