package com.nttdata;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.nttdata.repositories.Cliente;
import com.nttdata.services.ServicioGestionClientesI;
import com.nttdata.utilities.Utilidades;

@SpringBootApplication
public class Main implements CommandLineRunner {

	/** Servicio de gestión de clientes */
	@Autowired
	private ServicioGestionClientesI servicioCliente;

	/**
	 * Método main
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		SpringApplication.run(Main.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		/** Creación de clientes */
		Cliente cliente1 = new Cliente();
		cliente1.setName("Jonatan");
		cliente1.setSurname1("Carrera");
		cliente1.setSurname2("Viera");
		cliente1.setDni("28929933G");
		LocalDate ld1 = LocalDate.of(1986, 11, 26);
		Date date1 = Date.valueOf(ld1);
		cliente1.setFechaNacimiento(date1);

		Cliente cliente2 = new Cliente();;
		cliente2.setName("Fernando");
		cliente2.setSurname1("Perez");
		cliente2.setSurname2("Nieto");
		cliente2.setDni("11111111A");
		LocalDate ld2 = LocalDate.of(1991, 12, 10);
		Date date2 = Date.valueOf(ld2);
		cliente2.setFechaNacimiento(date2);

		Cliente cliente3 = new Cliente();;
		cliente3.setName("Pablo");
		cliente3.setSurname1("Dominguez");
		cliente3.setSurname2("Romero");
		cliente3.setDni("22222222B");
		LocalDate ld3 = LocalDate.of(1989, 01, 01);
		Date date3 = Date.valueOf(ld3);
		cliente3.setFechaNacimiento(date3);

		Cliente cliente4 = new Cliente();;
		cliente4.setName("Eva");
		cliente4.setSurname1("Cardenas");
		cliente4.setSurname2("Bermudez");
		cliente4.setDni("33333333C");
		LocalDate ld4 = LocalDate.of(2003, 02, 02);
		Date date4 = Date.valueOf(ld4);
		cliente4.setFechaNacimiento(date4);

		Cliente cliente5 = new Cliente();;
		cliente5.setName("Rafael");
		cliente5.setSurname1("Herrera");
		cliente5.setSurname2("Chavez");
		cliente5.setDni("44444444D");
		LocalDate ld5 = LocalDate.of(2015, 03, 03);
		Date date5 = Date.valueOf(ld5);
		cliente5.setFechaNacimiento(date5);

		/** Insertado de clientes */
		servicioCliente.insertarNuevoCliente(cliente1);
		servicioCliente.insertarNuevoCliente(cliente2);
		servicioCliente.insertarNuevoCliente(cliente3);
		servicioCliente.insertarNuevoCliente(cliente4);
		servicioCliente.insertarNuevoCliente(cliente5);

		/** Comprobación de datos */
		Utilidades.mostrarClientesEnDBActuales(servicioCliente.obtenerTodos());

		/** Actualizar un cliente */
		cliente5.setDni("55555555E");
		servicioCliente.actualizarCliente(cliente5);

		/** Comprobación de datos */
		Utilidades.mostrarClientesEnDBActuales(servicioCliente.obtenerTodos());

		/** Borrar un cliente */
		servicioCliente.borrarCliente(cliente4);

		/** Comprobación de datos */
		Utilidades.mostrarClientesEnDBActuales(servicioCliente.obtenerTodos());

		/** Buscar un cliente por ID */
		Cliente clientePorID = servicioCliente.buscarPorId(2L);
		System.out.println("El cliente con el ID 2 es:\n" + clientePorID.toString() + "\n");

		/** Buscar un cliente por DNI */
		List<Cliente> clientesPorDNI = servicioCliente.buscarPorDNI("28929933G");
		
		System.out.println("La búsqueda del cliente por DNI ha devuelto lo siguiente:");
		
		for (final Cliente clienteProvisional : clientesPorDNI) {
			System.out.println(clienteProvisional.toString() + "\n");
		}

		/** Buscar un cliente por nombre y apellidos */
		List<Cliente> clientes = servicioCliente.buscarPorNombrePrimerApellidoYSegundoApellido("Jonatan", "Carrera",
				"Viera");

		for (final Cliente clienteProvisional : clientes) {
			System.out.println("La búsqueda ha arrojado al cliente:\n" + clienteProvisional.toString() + "\n");
		}

	}
}
