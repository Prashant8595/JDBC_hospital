package com.hospitalmenegment1.dao;

import com.hospitalmenegment1.connection.connectionProvider;
import com.hospitalmenegment1.model.Doctor;
import com.hospitalmenegment1.model.Person;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class DoctorDao {
    private Connection connection;
    public DoctorDao() {
        try {
            connection= connectionProvider.getConnection();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public void addDoctor(Doctor doctor){
        try {
            String query="INSERT INTO doctor(D_id, name, email, designation, pid ) VALUES (?, ?, ?, ?, ?)";
            try(PreparedStatement psmt=connection.prepareStatement(query)){
                psmt.setInt(1,doctor.getD_id());
                psmt.setString(2,doctor.getName());
                psmt.setString(3,doctor.getEmail());
                psmt.setString(4,doctor.getDesignation());
                psmt.setInt(5,doctor.getPid());

                psmt.executeUpdate();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }


    public void updateperson(int D_id ,Doctor doctor){
        try {
            String query="UPDATE person SET name=?,email=?, designation=?, pid=? WHERE D_id=?";
            try(PreparedStatement psmt=connection.prepareStatement(query)) {

                psmt.setString(1, doctor.getName());
                psmt.setString(2, doctor.getEmail());
                psmt.setString(3, doctor.getDesignation());
                psmt.setInt(4, doctor.getPid());

                psmt.setInt(5, D_id);
                psmt.executeUpdate();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public List<Doctor> getAllDoctor(){
        List<Doctor> doctors=new ArrayList<>();
        try {
            String query="SELECT * FROM doctor";
            try(PreparedStatement stm= connection.prepareStatement(query)){
                ResultSet rs=stm.executeQuery();
                while (rs.next()){
                    Doctor doctor=new Doctor(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getInt(5));
                    doctors.add(doctor);
                }
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return doctors;
    }

    public void deleteDoctor(int D_id){
        try {
            String query="DELETE FROM doctor WHERE D_id=?";
            try(PreparedStatement ps= connection.prepareStatement(query)){
                ps.setInt(1,D_id);
                ps.executeUpdate();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
