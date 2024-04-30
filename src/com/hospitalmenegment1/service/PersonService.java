package com.hospitalmenegment1.service;

import com.hospitalmenegment1.dao.PersonDao;
import com.hospitalmenegment1.model.Person;

import java.util.List;

public class PersonService {
    private PersonDao personDao;
    public  PersonService(PersonDao personDao){
        this.personDao=personDao;
    }

    public List<Person> getallPerson(){
        return  personDao.getAllPerson();
    }

    public void addPerson(Person person){
        personDao.addperson(person);
    }

    public void updatePerson(int id, Person person){
        personDao.updateperson(id,person);
    }

    public  void deletePerson(int id){
        personDao.deletePerson(id);
    }
//    public  void crataetable(String name){personDao.createtable(name);}

}
