package com.hospitalmenegment1.service;

import com.hospitalmenegment1.dao.DoctorDao;
import com.hospitalmenegment1.dao.PersonDao;
import com.hospitalmenegment1.model.Doctor;
import com.hospitalmenegment1.model.Person;

import java.util.List;

public class DoctorService {
    private DoctorDao doctorDao;
    public  DoctorService(DoctorDao doctorDao){
        this.doctorDao=doctorDao;
    }

    public List<Doctor> getallDoctor(){
        return  doctorDao.getAllDoctor();
    }

    public void addDoctor(Doctor doctor){
        doctorDao.addDoctor(doctor);
    }

    public void updateDoctor(int D_id, Doctor doctor){
        doctorDao.updateperson(D_id,doctor);
    }

    public  void deleteDoctor(int D_id){
        doctorDao.deleteDoctor(D_id);
    }
}
