package modelo.dao;

import java.util.ArrayList;

import modelo.javabeans.Empleado;

public interface EmpresaDao {

	// creamos todos los metodos abstractos que nos piden en la interface de la clase empleado//
	
		boolean alta(Empleado empleado);
		boolean eliminarUno(Empleado empleado);
		boolean modificarUno(Empleado empleado);
		Empleado buscarUno(int idEmpleado);
		double masaSalarial();
		
		
		ArrayList<Empleado> buscarPorSexo(char sexo);
		ArrayList<Empleado> buscarTodos();
		ArrayList<Empleado> buscarPorDepartamento(int idDepar);
		ArrayList<Empleado> buscarPorTrabajo (String idTrabajo);
		ArrayList<Empleado> buscarPorPais (String pais);
	
		
		
		
			
}
