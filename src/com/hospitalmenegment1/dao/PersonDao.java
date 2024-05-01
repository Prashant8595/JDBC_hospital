package com.hospitalmenegment1.dao;

import com.hospitalmenegment1.connection.connectionProvider;
import com.hospitalmenegment1.model.Person;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class PersonDao {
    private Connection connection;
    public PersonDao() {
        try {
           connection= connectionProvider.getConnection();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
//public void createtable(String name){
//        try {
//            String query="CREATE TABLE +this.name+" +
//                    "(id int, name varchar(100), " +
//                    "email varchar(100), " +
//                    "designation varchar(100), " +
//                    "address varchar(100), bill int)";
//            try(PreparedStatement psmt1=connection.prepareStatement(query)){
//                psmt1.setString(1,name);
//                psmt1.executeUpdate();
//            }
//        }catch (Exception e){
//            e.printStackTrace();
//        }
//}
    public void addperson(Person person){
        try {
            String query="INSERT INTO person(id, name, email, designation, address, illness, bill ) VALUES (?, ?, ?, ?, ?, ?, ?)";
            try(PreparedStatement psmt=connection.prepareStatement(query)){
                psmt.setInt(1,person.getId());
                psmt.setString(2,person.getName());
                psmt.setString(3,person.getEmail());
                psmt.setString(4,person.getDesignation());
                psmt.setString(5,person.getAddress());
                psmt.setString(6,person.getIllness());
                psmt.setInt(7,person.getBill());

                psmt.executeUpdate();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void updateperson(int id ,Person person){
        try {
            String query="UPDATE person SET name=?,email=?, designation=?, address=?, illness=?, bill=? WHERE id=?";
            try(PreparedStatement psmt=connection.prepareStatement(query)) {

                psmt.setString(1, person.getName());
                psmt.setString(2, person.getEmail());
                psmt.setString(3, person.getDesignation());
                psmt.setString(4, person.getAddress());
                psmt.setString(5, person.getIllness());
                psmt.setInt(6, person.getBill());
                psmt.setInt(7, id);
                psmt.executeUpdate();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public List<Person> getAllPerson(){
        List<Person> persons=new ArrayList<>();
        try {
            String query="SELECT * FROM person";
            try(PreparedStatement stm= connection.prepareStatement(query)){
                ResultSet rs=stm.executeQuery();
                while (rs.next()){
                    Person person=new Person(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getInt(7));
                    persons.add(person);
                }
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return persons;
    }
    public void deletePerson(int id){
        try {
            String query="DELETE FROM person WHERE id=?";
            try(PreparedStatement ps= connection.prepareStatement(query)){
                ps.setInt(1,id);
                ps.executeUpdate();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    // public void addMultipalEmployee(){
    //     try {
    //         String query="INSERT INTO employees(id, name, email, designation, address) VALUES (?, ?, ?, ?, ?)";
    //         PreparedStatement statement= connection.prepareStatement(query);
    //         Scanner sc=new Scanner(System.in);
    //         while (true){
    //             System.out.println("Enter id");
    //             int id= sc.nextInt();
    //             sc.nextLine();
    //             System.out.println("Enter name");
    //             String name=sc.nextLine();
    //             System.out.println("Enter email");
    //             String email=sc.nextLine();
    //             System.out.println("Enter Designation");
    //             String designation=sc.nextLine();
    //             System.out.println("Enter Address");
    //             String address=sc.nextLine();
    //             statement.setInt(1,id);
    //             statement.setString(2,name);
    //             statement.setString(3,email);
    //             statement.setString(4,designation);
    //             statement.setString(5,address);
    //             statement.addBatch();
    //             System.out.println("Want to add more employee records y/n");
    //             String ans=sc.nextLine();
    //             if(ans.equals("n")){
    //                 break;
    //             }
    //         }
    //         statement.executeUpdate();
    //     }catch (Exception e){
    //         e.printStackTrace();
    //     }
    // }

    // public void createTable(){
    //     try {
    //         Scanner sc=new Scanner(System.in);
    //         System.out.println("Enter table name");
    //         String name=sc.nextLine();
    //         String query="CREATE TABLE "+name+" (id int, name varchar(100), designation varchar(100), address varchar(100))";
    //         try(PreparedStatement statement=connection.prepareStatement(query)){
    //             statement.execute();
    //         }
    //     }catch (Exception e){
    //         e.printStackTrace();
    //     }
    // }
}
