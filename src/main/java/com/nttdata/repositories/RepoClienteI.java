/**
 * 
 */
package com.nttdata.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Interfaz del repositorio para cliente
 * 
 * @author Jonatan Carrera Viera
 *
 */
@Repository
public interface RepoClienteI extends JpaRepository<Cliente, Long> {

	/**
	 * Método para obtener un cliente por el DNI
	 * 
	 * @param dni
	 * @return List<Cliente>
	 */
	public List<Cliente> findByDni(String dni);
	
	/**
	 * Método para buscar clientes por nombre y apellidos
	 * 
	 * @param nombre
	 * @param primerApellido
	 * @param segundoApellido
	 * @return List<Cliente>
	 */
	public List<Cliente> findByNameAndSurname1AndSurname2(String name, String surname1, String surname2);
}
