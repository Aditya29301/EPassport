package com.example.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.exception.UserNotFoundException;
import com.example.model.Appointment;
import com.example.repository.AppointmentRepository;

@Service
public class AppointmentServiceImpl implements AppointmentService{
	
	@Autowired
	AppointmentRepository repo;
	
	@Override
	public Appointment saveAppointment (Appointment appointment) {
		return repo.save(appointment);
		
	}
     
	@Override
	public List<Appointment> getAllAppointments(){
		return repo.findAll();
	}
		
	@Override
	public Appointment getAppointmentById(int id) {
		Optional <Appointment> opt=repo.findById(id);
		if(opt.isPresent()) {
			return opt.get();
		}else {
			throw new UserNotFoundException("Invoice with Id:"+id+"Not Found");
		}
	}
	
	@Override
	public void deleteAppointmentById(int id) {
		repo.delete(getAppointmentById(id));
	}
	
	@Override
	public void updateAppointment(Appointment appointment) {
		repo.save(appointment);
	
	}

	@Override
	public Appointment findAppointmentById(int loginid) {
		return repo.findById(loginid).get();
	}
}
