/**
 * 
 */
package com.nttdata.repositories;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Entidad para Cliente
 * 
 * @author Jonatan Carrera Viera
 *
 */
@Entity
@Table(name = "T_CLIENTE")
public class Cliente implements Serializable {

	/** Serial Version */
	private static final long serialVersionUID = 1L;

	/** Id (PK) */
	private Long clienteId;

	/** Nombre del cliente */
	private String name;

	/** Primer apellido del cliente */
	private String surname1;
	
	/** Segundo apellido del cliente */
	private String surname2;

	/** Fecha nacimiento del cliente */
	private Date fechaNacimiento;

	/** DNI del cliente */
	private String dni;

	/**
	 * @return the clienteId
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "C_PK_CLIENTE_ID", nullable = false)
	public Long getClienteId() {
		return clienteId;
	}

	/**
	 * @param clienteId the clienteId to set
	 */
	public void setClienteId(Long clienteId) {
		this.clienteId = clienteId;
	}

	/**
	 * @return the name
	 */
	@Column(name = "C_NOMBRE", nullable = false)
	public String getName() {
		return name;
	}

	/**
	 * @param nombre the nombre to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the primerApellido
	 */
	@Column(name = "C_PRIMER_APELLIDO", nullable = false)
	public String getSurname1() {
		return surname1;
	}

	/**
	 * @param primerApellido the primerApellido to set
	 */
	public void setSurname1(String surname1) {
		this.surname1 = surname1;
	}
	
	/**
	 * @return the segundoApellido
	 */
	@Column(name = "C_SEGUNDO_APELLIDO", nullable = false)
	public String getSurname2() {
		return surname2;
	}

	/**
	 * @param segundoApellido the segundoApellido to set
	 */
	public void setSurname2(String surname2) {
		this.surname2 = surname2;
	}

	/**
	 * @return the fechaNacimiento
	 */
	@Column(name = "C_FECHA_NACIMIENTO", nullable = false)
	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}

	/**
	 * @param fechaNacimiento the fechaNacimiento to set
	 */
	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	/**
	 * @return the dni
	 */
	@Column(name = "C_DNI", nullable = false)
	public String getDni() {
		return dni;
	}

	/**
	 * @param dni the dni to set
	 */
	public void setDni(String dni) {
		this.dni = dni;
	}

	@Override
	public String toString() {
		return "Cliente [Id de cliente=" + clienteId + "; Nombre=" + name + "; Primer apellido=" + surname1
				+ "; Segundo Apellido=" + surname2 + "; Fecha de nacimiento=" + fechaNacimiento + "; DNI=" + dni
				+ "]";
	}

}
