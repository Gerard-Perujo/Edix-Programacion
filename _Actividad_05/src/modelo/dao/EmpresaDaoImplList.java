package modelo.dao;

import java.util.ArrayList;

import modelo.javabeans.Departamento;
import modelo.javabeans.Empleado;
import modelo.javabeans.Localidad;
import modelo.javabeans.Trabajo;

//Aqui implementamos los metodos de la interface Empresa//


public class EmpresaDaoImplList implements EmpresaDao{
	
	private String nombre;
	private ArrayList<Empleado> plantilla;
	
	
	// creamos un constructor con el nombre y creamos el array list plantilla y
	// un metodo cargar datos ya que no tenemos base de datos//
	
	public EmpresaDaoImplList(String nombre) {
		this.nombre = nombre;
		
		plantilla = new ArrayList<>();
		
		cargarDatos();
	}
	
	
	// hacemos el getter solo del nombre//
	
	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	
	// Aqui escribimos el metodo cargar datos donde pondremos los datos de todos los empleados de la empresa
	
	public void cargarDatos() {
		plantilla.add(new Empleado(41698752, "Gerard", "Perujo_Buxeda", "ger@edix.com", 'H', 1300, 200,
					new Trabajo("1002", "Carpintero", 1020, 1600), new Departamento(800, "Mobiliario", 
					new Localidad (17520, "calle Cerda 1", "puigcerda","Paris"))));
		
		plantilla.add(new Empleado(41698725, "Pepe", "Castro_Ruiz", "pepe@edix.com", 'H', 900, 200,
				new Trabajo("1005", "Electricista", 1200, 1600), new Departamento(805, "Nomotica", 
				new Localidad (17526, "calle Puigcerda 20", "Llivia","España"))));
		
		plantilla.add(new Empleado(30698752, "Mireia", "Ruiz_Perez", "Mire@edix.com", 'M', 1400, 300,
				new Trabajo("1020", "Administrativa", 1200, 1700), new Departamento(900, "Cuentas", 
				new Localidad (17500, "calle Palamos", "palafrugell","España"))));
		
		plantilla.add(new Empleado(4168552, "Lurdes", "Candela_Rodriguez", "lur@edix.com", 'M', 1200, 500,
				new Trabajo("1030", "Conductora", 1100, 1700), new Departamento(030, "Autobuses", 
				new Localidad (17500, "calle Tramuntana", "palafrugell","Inglaterra"))));
		
		plantilla.add(new Empleado(20698752, "Gonzalo", "Matamoros_Roldan", "gon@edix.com", 'H', 1200, 100,
				new Trabajo("1050", "Construccion", 900, 1300), new Departamento(900, "Monobra", 
				new Localidad (17520, "calle belloch", "puigcerda","España"))));
	}

	
	// aqui tenemos todos los metodos del interface e implementamos contenido en cada unos de ellos //
	

	
	// aqui agregamos un nuevo empleado en el caso de que el empleado agregado ya exista nos devuelve false refiriendose 
	//a que el empleado ya existe por lo tanto no se ha agregado
	// y sino esta lo agreamos con el add del arraylist
	@Override
	public boolean alta(Empleado empleado) {
		if (plantilla.contains(empleado))
		return false;
		else
			return plantilla.add(empleado);
		
	}
	
	
	
	//eliminamos un empleado con el remove del arraylist
	@Override
	public boolean eliminarUno(Empleado empleado) {
		
		return plantilla.remove(empleado);
		
	}
	
	
	@Override
	public boolean modificarUno(Empleado empleado) {
		
		if (plantilla.contains(empleado))
			return false;
			else
				return true;
			
	}

	// Este metodo creamos un empleado virutal donde le pasamos la idEmpleado que estamos buscando en el caso de que no coicida
	// index nos devuelve -1 por lo tanto sera nulo y si concide sacaremos el empleado de la plantilla 
	// 
	@Override
	public Empleado buscarUno(int idEmpleado) {
		
		Empleado em = new Empleado();
		em.setIdEmpleado(idEmpleado);
		int posicion = plantilla.indexOf(em);
		if (posicion == -1)
			return null;
		else
			return plantilla.get(posicion);
	}

	// vamos a decir cuanto suman todos los salarios y comisiones de todos los empleados para ello utilizamos el for
	//para ir pasando por todos los empleado y sumamos el salario y la comision utilizando el metodo salarioBruto() que tenemos
	//creado dentro de la clase empleado
	
	@Override
	public double masaSalarial() {
		double total = 0;
		for (Empleado empleado: plantilla) {
			 total += empleado.salarioBruto();
			
		}
		return total;
	}

	// creamos una arraylist auxiliar donde vamos aderir el empleado cuando lo encontremos y con un for vamos a ir buscando por todos
	//los empleados hasta que encuentre el sexo que le hemos indicado y nos saque todos aquellos empleados que tengan ese
	//mismo sexo
	@Override
	public ArrayList<Empleado> buscarPorSexo(char sexo) {
		
		ArrayList<Empleado> aux = new ArrayList<>();
		
		for (Empleado empleado: plantilla)
			if(empleado.getGenero()== sexo)
				aux.add(empleado);
		return aux;
	}

	
	//aqui solo hace falta devolver la plantilla entera con todos los empleados
	@Override
	public ArrayList<Empleado> buscarTodos() {
		
		return plantilla;
	}

	
	// creamos una arraylist auxiliar donde vamos adderir el empleado cuando lo encontremos y con un for vamos a ir buscando por todos
		//los empleados hasta que encuentre el idDepartamento que le hemos indicado y nos saque todos aquellos empleados que tengan ese
		//mismo idDepartamento
	
	@Override
	public ArrayList<Empleado> buscarPorDepartamento(int idDepar) {
		
		ArrayList<Empleado> aux = new ArrayList<>();
		
		for (Empleado empleado: plantilla) {
			if(empleado.getDepartamento().getIdDepar() == idDepar)
				aux.add(empleado);
		}
		return aux;
	}

	

	// creamos una arraylist auxiliar donde vamos adderir el empleado cuando lo encontremos y con un for vamos a ir buscando por todos
		//los empleados hasta que encuentre el idTrabajo que le hemos indicado y nos saque todos aquellos empleados que tengan ese
		//mismo idtrabajo
	@Override
	public ArrayList<Empleado> buscarPorTrabajo(String idTrabajo) {
		
		ArrayList<Empleado> aux = new ArrayList<>();
		
		for (Empleado empleado: plantilla) {
			if (empleado.getTrabajo().getIdTrabajo().equalsIgnoreCase(idTrabajo))
			aux.add(empleado);
		}
		return aux;
	}

	
	// creamos una arraylist auxiliar donde vamos adderir el empleado cuando lo encontremos y con un for vamos a ir buscando por todos
		//los empleados hasta que encuentre el pais que le hemos indicado y nos saque todos aquellos empleados que tengan ese
		//mismo pais
	@Override
	public ArrayList<Empleado> buscarPorPais(String pais) {
		
		ArrayList<Empleado> aux = new ArrayList<>();
		
		for (Empleado empleado: plantilla) {
			if(empleado.getDepartamento().getLocalidad().getPais().equalsIgnoreCase(pais))
				aux.add(empleado);
		}
		return aux;
	}
	
	
	
}
