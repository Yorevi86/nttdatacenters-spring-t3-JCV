/**
 * 
 */
package com.nttdata.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.nttdata.repositories.Cliente;
import com.nttdata.repositories.RepoClienteI;

/**
 * Implementación del servicio de gestión de clientes
 * 
 * @author Jonatan Carrera Viera
 *
 */
@Service
public class ServicioGestionClientesImpl implements ServicioGestionClientesI {

	/** Servicio: gestión de clientes */
	@Autowired
	private RepoClienteI repoCliente;

	@Override
	public void insertarNuevoCliente(final Cliente cliente) {

		// Verificación de nulidad e inexistencia.
		if (cliente != null && cliente.getClienteId() == null) {

			// Inserción del nuevo cliente.
			repoCliente.save(cliente);
		}

	}

	@Override
	public void actualizarCliente(final Cliente cliente) {

		// Verificación de nulidad y existencia.
		if (cliente != null && cliente.getClienteId() != null) {

			// Actualización del cliente.
			repoCliente.save(cliente);
		}

	}

	@Override
	public void borrarCliente(final Cliente cliente) {

		// Verificación de nulidad y existencia.
		if (cliente != null && cliente.getClienteId() != null) {

			// Eliminación del cliente.
			repoCliente.delete(cliente);
		}

	}

	@Override
	public Cliente buscarPorId(final Long id) {

		// Resultado.
		Cliente cliente = null;

		// Verificación de nulidad.
		if (id != null) {

			// Obtención del cliente por ID.
			cliente = repoCliente.findById(id).orElse(null);
		}

		return cliente;
	}

	@Override
	public List<Cliente> obtenerTodos() {

		// Obtención del listado completo de clientes.
		return repoCliente.findAll();
	}

	@Override
	public List<Cliente> buscarPorDNI(final String dni) {

		// Listado clientes resultantes.
		List<Cliente> listaClientes = new ArrayList<>();

		// Verificación de nulidad.
		if (StringUtils.hasText(dni)) {

			// Obtención del cliente por el DNI.
			listaClientes = repoCliente.findByDni(dni);
		}

		return listaClientes;
	}

	@Override
	public List<Cliente> buscarPorNombrePrimerApellidoYSegundoApellido(final String nombre, final String primerApellido,
			final String segundoApellido) {

		// Listado clientes resultantes.
		List<Cliente> listaClientes;

		// Obtención de jugadores.
		listaClientes = repoCliente.findByNameAndSurname1AndSurname2(nombre, primerApellido, segundoApellido);

		return listaClientes;
	}

}
