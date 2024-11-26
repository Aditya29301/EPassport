package com.example.service;

import java.util.List;

import com.example.model.Appointment;

public interface AppointmentService {
	public Appointment saveAppointment(Appointment appointment);
	public List<Appointment> getAllAppointments();
	public Appointment getAppointmentById(int id);
	public void deleteAppointmentById(int id);
	public void updateAppointment(Appointment appointment);
	public Appointment findAppointmentById(int loginid);
	

}
