/**
 * 
 */
package com.nttdata.utilities;

import java.util.List;

import com.nttdata.repositories.Cliente;

/**
 * Clase de utilidades auxiliar para gestión de datos del proyecto
 * 
 * @author Jonatan Carrera Viera
 *
 */
public class Utilidades {

	public static void mostrarClientesEnDBActuales(List<Cliente> listadoClientes) {

		System.out.println("Los clientes actuales son:\n");

		for (final Cliente clienteProvisional : listadoClientes) {
			System.out.println(clienteProvisional.toString());
			System.out.println("\n");
		}
	}
}
