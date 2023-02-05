package modelo.Testing;

import modelo.dao.EmpresaDaoImplList;
import modelo.javabeans.Departamento;
import modelo.javabeans.Empleado;
import modelo.javabeans.Localidad;
import modelo.javabeans.Trabajo;

public class Empresa{
	

	public static void main(String[] args) {
		
		
		
		// vamaos a utilizar todos los metodos creados en el EmpresaDaoImplList//
		//por ello creamos un objeto nuevo que el que vamos utilizar
		
		
		EmpresaDaoImplList Empresa = new EmpresaDaoImplList("Industria S.L");
		
		
		
		//empezamos a escribir los metodos para sacar todas las busquedas//
		
		
		System.out.println("-------------------------");
		System.out.println("Alta Empleado" );
		
		Empleado emp1 = new Empleado(3000, "Pablo", "Ruiz Ruiz", "rui@edix.com", 'H', 1300, 200, new Trabajo("1002", "Carpintero", 1020, 1600), new Departamento(800, "Mobiliario", 
				new Localidad (17520, "calle Cerda 1", "puigcerda","Paris")));
		
		System.out.println(Empresa.alta(emp1));
		for (Empleado ele: Empresa.buscarTodos())
			System.out.println(ele);
				
	
		
		

		System.out.println("-------------------------");
		Empleado emp2 = new Empleado(8000, "Pablo80", "Contreras Ruiz", "Con@edix.com", 'H', 1300, 200, new Trabajo("1002", "Constructor", 1020, 1600), new Departamento(800, "Mobiliario", 
				new Localidad (17500, "calle Cerda 1", "Girona","españa")));
		emp1=emp2;
		System.out.println("modificamos emp1 : ");
		System.out.println(Empresa.modificarUno(emp1));
		for (Empleado ele: Empresa.buscarTodos())
			System.out.println(ele);
		
		
		
		
		
		
		System.out.println("-------------------------");
		System.out.println("Eliminamos emp1:  " + Empresa.eliminarUno(emp1) );
		for (Empleado ele: Empresa.buscarTodos())
			System.out.println(ele);
		
			
				
		
		
		
		
		System.out.println("-------------------------");
		System.out.println("Buscar un empleado con id 41698752" );
		System.out.println(Empresa.buscarUno(41698752));
		
		
		
		
		System.out.println("-------------------------");
		System.out.println("buscar por sexo" );
		for (Empleado ele: Empresa.buscarPorSexo('M')) {
			System.out.println(ele);
		}
		
		
		System.out.println("-------------------------");
		System.out.println("ArrayList buscar todos");
		for (Empleado ele: Empresa.buscarTodos()){
			System.out.println(ele);
		}
		
		
		System.out.println("-------------------------");
		System.out.println("buscar empleado del departamento 800" );
		for (Empleado ele: Empresa.buscarPorDepartamento(800)) {
			System.out.println(ele);
		}
		
		
		
		
		System.out.println("-------------------------");
		System.out.println("buscar empleado con id de trabajo 1002" );
		for (Empleado ele: Empresa.buscarPorTrabajo("1002")) {
			System.out.println(ele);
		}
		
		
		
		System.out.println("-------------------------");
		System.out.println("Buscar los empleados de España");
		for (Empleado ele: Empresa.buscarPorPais("España")) {
			System.out.println(ele);
		}
		
		
		
		
		
		
		System.out.println("-------------------------");
		System.out.println("masa salarial" );
		System.out.println(Empresa.masaSalarial());
		
		

		
		

	}

}
