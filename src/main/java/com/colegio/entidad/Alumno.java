package com.colegio.entidad;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

//@Entity le esta dciendo que alumno tiene su clase en la bd
//@Table nombre de la tabla en la bd
//@Id PK
//@Column columna de la bd que este caso coinciden pero cuando coinciden no es necesario ponerlo
@Entity
@Table(name ="Alumno")
public class Alumno {

	@Id
	@Column(name = "idAlumno")
	private Long idAlumno;
	
	@Column(name = "nombre")
	private String nombre;
	
	@Column(name = "dni")
	private String dni;
	
	@Column(name = "correo")
	private String correo;

	public Long getIdAlumno() {
		return idAlumno;
	}

	public void setIdAlumno(Long idAlumno) {
		this.idAlumno = idAlumno;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}
	
	
	
}
