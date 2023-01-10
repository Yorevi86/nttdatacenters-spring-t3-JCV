/**
 * 
 */
package com.nttdata.services;

import java.util.List;

import com.nttdata.repositories.Cliente;

/**
 * Interfaz para el servicio de gestión de clientes
 * 
 * @author Jonatan Carrera Viera
 *
 */
public interface ServicioGestionClientesI {

	/**
	 * Método para insertar un nuevo cliente
	 * 
	 * @param cliente
	 */
	public void insertarNuevoCliente(Cliente cliente);

	/**
	 * Método para actualizar datos de un cliente existente
	 * 
	 * @param cliente
	 */
	public void actualizarCliente(Cliente cliente);

	/**
	 * Método para borrar un cliente
	 * 
	 * @param cliente
	 */
	public void borrarCliente(Cliente cliente);

	/**
	 * Método para buscar un cliente por su Id
	 * 
	 * @param id
	 * @return
	 */
	public Cliente buscarPorId(Long id);

	/**
	 * Método para obtener todos los clientes
	 * 
	 * @return List<Cliente>
	 */
	public List<Cliente> obtenerTodos();

	/**
	 * Método para buscar un cliente por DNI
	 * 
	 * @param dni
	 * @return List<Cliente>
	 */
	public List<Cliente> buscarPorDNI(String dni);

	/**
	 * Método para buscar un cliente por nombre, primer apellido y segundo apellido
	 * 
	 * @param nombre
	 * @param primerApellido
	 * @param segundoApellido
	 * @return List<Cliente>
	 */
	public List<Cliente> buscarPorNombrePrimerApellidoYSegundoApellido(String nombre, String primerApellido,
			String segundoApellido);

}
