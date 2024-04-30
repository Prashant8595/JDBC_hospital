package com.hospitalmenegment1.Main;

import com.hospitalmenegment1.dao.DoctorDao;
import com.hospitalmenegment1.dao.PersonDao;
import com.hospitalmenegment1.model.Doctor;
import com.hospitalmenegment1.model.Person;
import com.hospitalmenegment1.service.DoctorService;
import com.hospitalmenegment1.service.PersonService;

import java.util.List;
import java.util.Scanner;

public class MainClass {
    public  static  Scanner sc=new Scanner(System.in);
    public  static PersonService personService;
    public  static DoctorService doctorService;

    public static void main(String[] args) {
        PersonDao personDao=new PersonDao();
        DoctorDao doctorDao=new DoctorDao();
        personService=new PersonService(personDao);
        doctorService=new DoctorService(doctorDao);
        while (true){
            System.out.println("1 , view all person");
            System.out.println("2 , view all Doctor");
            System.out.println("3 , add new person");
            System.out.println("4 , add new Doctor");
            System.out.println("5 , update person");
            System.out.println("6 , update Doctor");
            System.out.println("7 , delete person");
            System.out.println("8 , delete Doctor");
            System.out.println("9 , exit");
          //  System.out.println("6, create a new table");
            int choice= sc.nextInt();
            sc.nextLine();
            switch (choice){
                case 1:
                    viewAllPerson();
                    break;
                case 2:
                    viewAllDoctor();
                    break;
                case 3:
                    addPerson();
                    break;
                case 4:
                    addDoctor();
                    break;
                case 5:
                    updatePerson();
                    break;
                case 6:
                    updateDoctor();
                    break;
                case 7:
                    deletePerson();
                    break;
                case 8:
                    deleteDoctor();
                    break;
                case 9:
                    System.out.println("Exiting the program");
                    System.exit(4);
//                case 6:
//                    crateTable();
                default:
                    System.out.println("Plese enter valid number");


            }
        }

    }
    public static void viewAllPerson(){
        List<Person> p=personService.getallPerson();
        System.out.println("Person List");
        for (Person pp: p){
            System.out.println(pp);
        }

    }public static void viewAllDoctor(){
        List<Doctor> p=doctorService.getallDoctor();
        System.out.println("Doctor List");
        for (Doctor pp: p){
            System.out.println(pp);
        }

    }
//    public static void crateTable(){
//        System.out.println("Enter table name");
//        String name=sc.nextLine();
//        personService.crataetable(name);
//    }
    private  static void addPerson(){
        System.out.println("Enter id");
        int id= sc.nextInt();
        sc.nextLine();
        System.out.println("Enter name");
        String name=sc.nextLine();
        System.out.println("Enter email");
        String email=sc.nextLine();
        System.out.println("Enter Designation");
        String designation=sc.nextLine();
        System.out.println("Enter Address");
        String address=sc.nextLine();
        System.out.println("Enter illness name if exist else type N");
        String  illness=sc.nextLine();
        System.out.println("Enter total bill if exist");
        int bill=sc.nextInt();
//        System.out.println("Enter salary");
//        int salary=sc.nextInt();
        Person pp=new Person(id,name,email,designation,address,illness, bill);
        personService.addPerson(pp);
    } private  static void addDoctor(){
        System.out.println("Enter id");
        int D_id= sc.nextInt();
        sc.nextLine();
        System.out.println("Enter name");
        String name=sc.nextLine();
        System.out.println("Enter email");
        String email=sc.nextLine();
        System.out.println("Enter Designation");
        String designation=sc.nextLine();

        System.out.println("Enter patient Id(pid)");
        int pid=sc.nextInt();
//        System.out.println("Enter salary");
//        int salary=sc.nextInt();
        Doctor pp=new Doctor(D_id,name,email,designation,pid);
        doctorService.addDoctor(pp);
    }
    private static void updatePerson(){
        System.out.println("Enter id");
        int id= sc.nextInt();
        sc.nextLine();
        System.out.println("Enter name");
        String name=sc.nextLine();
        System.out.println("Enter email");
        String email=sc.nextLine();
        System.out.println("Enter Designation");
        String designation=sc.nextLine();
        System.out.println("Enter Address");
        String address=sc.nextLine();
        System.out.println("Enter illness name if exist else type N");
        String  illness=sc.nextLine();
        System.out.println("Enter total bill if exist");
        int bill=sc.nextInt();
        System.out.println("Enter salary");

        Person pp=new Person(id,name,email,designation,address,illness, bill);
        personService.updatePerson(id,pp);

    }private static void updateDoctor(){
        System.out.println("Enter D_id");
        int D_id= sc.nextInt();
        sc.nextLine();
        System.out.println("Enter name");
        String name=sc.nextLine();
        System.out.println("Enter email");
        String email=sc.nextLine();
        System.out.println("Enter Designation");
        String designation=sc.nextLine();

        System.out.println("Enter patient id(pid)");
        int pid=sc.nextInt();

        Doctor pp=new Doctor(D_id,name,email,designation,pid);
        doctorService.updateDoctor(D_id,pp);

    }
    private static  void deletePerson(){
        System.out.println("Enter id of the person to delete");
        int id=sc.nextInt();
        personService.deletePerson(id);
        System.out.println("Person is deleted successfully");
    }private static  void deleteDoctor(){
        System.out.println("Enter D_id of the doctor to delete");
        int D_id=sc.nextInt();
        personService.deletePerson(D_id);
        System.out.println("Doctor is deleted successfully");
    }
}
