package com.persona.persona.modelo;

import com.persona.persona.utils.MySQLConection;
//BRAYAN REYNOSO MACEDO
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DaoPersona {
    Connection conn;
    PreparedStatement pstm;
    CallableStatement cstm;
    ResultSet rs;

    MySQLConection mySQLConection = new MySQLConection();
    BeanPersona beanPersona = new BeanPersona();

    public List<BeanPersona> listarPersona() throws SQLException {

        List<BeanPersona> personas = new ArrayList<BeanPersona>();
        String sql = "SELECT * FROM personas";
        conn = mySQLConection.getConnection();
        Statement statement = conn.createStatement();
        ResultSet resulSet = statement.executeQuery(sql);

        while (resulSet.next()) {
            long id = resulSet.getLong("id");
            String name = resulSet.getString("name");
            String surname = resulSet.getString("surname");
            String curp = resulSet.getString("curp");
            String birthday = resulSet.getString("birthaday");
            BeanPersona persona = new BeanPersona(id, name, surname, curp, birthday);
            personas.add(persona);
        }
        closeConnections();
        return personas;
    }
    public List<BeanPersona> findAll(){
        List<BeanPersona> personas = new ArrayList<>();
        BeanPersona persona = null;

        try {
            conn = new MySQLConection().getConnection();
            String query = "SELECT * FROM personas;";
            pstm = conn.prepareStatement(query);
            rs = pstm.executeQuery();
            while (rs.next()){
                persona = new BeanPersona();
                persona.setId(rs.getLong("id"));
                persona.setName(rs.getString("name"));
                persona.setSurname(rs.getString("surname"));
                persona.setCurp(rs.getString("curp"));
                persona.setBirthday(rs.getString("birthaday"));
                personas.add(persona);
            }
        } catch (SQLException e) {
            Logger.getLogger(DaoPersona.class.getName())
                    .log(Level.SEVERE, "Error de findAll", e);
        }finally{
            closeConnections();
        }
        return personas;
    }
    public void closeConnections(){
        try {
            if (conn != null){
                conn.close();
            }
            if (pstm != null){
                pstm.close();
            }if (cstm != null){
                cstm.close();
            }
            if (rs != null){
                rs.close();
            }

        }catch (SQLException e){

        }
    }

    public BeanPersona findOne(Long id){
        try{
            conn = new MySQLConection().getConnection();
            String query = "SELECT * FROM personas WHERE id = ?";
            pstm =conn.prepareStatement(query);
            rs = pstm.executeQuery();
            if(rs.next()){
                BeanPersona persona = new BeanPersona();
                persona.setId(rs.getLong("id"));
                persona.setName(rs.getString("name"));
                persona.setSurname(rs.getString("surname"));
                persona.setCurp(rs.getString("curp"));
                persona.setBirthday(rs.getString("birthaday"));
            }
        }catch (SQLException e){
            Logger.getLogger(DaoPersona.class.getName())
                    .log(Level.SEVERE, "Error findOne", e);
        }finally {

        }
        return null;
    }

    public boolean save(BeanPersona persona){
        try {
            conn = new MySQLConection().getConnection();
            String query = "INSERT INTO personas" + "(name, surname, curp, birthaday )"
                    + "VALUES (?,?,?,?)";
            pstm = conn.prepareStatement(query);
            pstm.setString(1,persona.getName());
            pstm.setString(2,persona.getSurname());
            pstm.setString(3,persona.getCurp());
            pstm.setString(4,persona.getBirthday());
            return pstm.executeUpdate() ==1;
        }catch (SQLException e){
            Logger.getLogger(DaoPersona.class.getName())
                    .log(Level.SEVERE, "Error al guardar el registro", e);
            return false;
        }finally {
            closeConnections();
        }
    }
    public boolean update(BeanPersona persona) {
        try {
            conn = new MySQLConection().getConnection();
            String query = "UPDATE personas SET name = ?, surname = ?, curp = ?, birthaday = ? WHERE id = ?";
            pstm = conn.prepareStatement(query);
            pstm.setString(1, persona.getName());
            pstm.setString(2,persona.getSurname());
            pstm.setString(3,persona.getCurp());
            pstm.setString(4,persona.getBirthday());
            pstm.setLong(5,persona.getId());
            return pstm.executeUpdate() == 1;
        } catch (SQLException e) {
            Logger.getLogger(DaoPersona.class.getName())
                    .log(Level.SEVERE, "Error update", e);
            return false;
        } finally {
            closeConnections();
        }
    }

    public boolean delete(Long id) {
        try {
            conn = new MySQLConection().getConnection();
            String query = "DELETE FROM personas WHERE id = ?";
            pstm = conn.prepareStatement(query);
            pstm.setLong(1, id);
            return pstm.executeUpdate() == 1;
        } catch (SQLException e) {
            Logger.getLogger(DaoPersona.class.getName())
                    .log(Level.SEVERE, "Error delete method");
            return false;
        } finally {
            closeConnections();
        }
    }
}
