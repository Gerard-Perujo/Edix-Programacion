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

	
	// Aqui escribimos el metodo cargar datos donde pondremos los datos de la empresa
	
	public void cargarDatos() {
		plantilla.add(new Empleado(41698752, "Gerard", "Perujo_Buxeda", "ger@edix.com", 'H', 1300, 200,
					new Trabajo("1002", "Carpintero", 1020, 1600), new Departamento(800, "Mobiliario", 
					new Localidad (17520, "calle Cerda 1", "puigcerda","España"))));
		
		plantilla.add(new Empleado(41698725, "Pepe", "Castro_Ruiz", "pepe@edix.com", 'H', 900, 200,
				new Trabajo("1005", "Electricista", 1200, 1600), new Departamento(805, "Nomotica", 
				new Localidad (17526, "calle Puigcerda 20", "Llivia","España"))));
		
		plantilla.add(new Empleado(30698752, "Mireia", "Ruiz_Perez", "Mire@edix.com", 'M', 1400, 300,
				new Trabajo("1020", "Administrativa", 1200, 1700), new Departamento(900, "Cuentas", 
				new Localidad (17500, "calle Palamos", "palafrugell","España"))));
		
		plantilla.add(new Empleado(4168552, "Lurdes", "Candela_Rodriguez", "lur@edix.com", 'M', 1200, 500,
				new Trabajo("1030", "Conductora", 1100, 1700), new Departamento(030, "Autobuses", 
				new Localidad (17500, "calle Tramuntana", "palafrugell","España"))));
		
		plantilla.add(new Empleado(20698752, "Gonzalo", "Matamoros_Roldan", "gon@edix.com", 'H', 1200, 100,
				new Trabajo("1050", "Construccion", 900, 1300), new Departamento(900, "Monobra", 
				new Localidad (17520, "calle belloch", "puigcerda","España"))));
	}

	
	// aqui tenemos todos los metodos del interface e implementamos contenido en cada unos de ellos //
	

	@Override
	public boolean alta(Empleado empleado) {
		if (plantilla.contains(empleado))
		return false;
		else
			return plantilla.add(empleado);
		
	}

	@Override
	public boolean eliminarUno(Empleado empleado) {
		// TODO Auto-generated method stub
		return plantilla.remove(empleado);
	}

	@Override
	public Empleado modificarUno(Empleado empleado) {
		
		int posicion = plantilla.indexOf(empleado);
		if (posicion == -1)
			return null;
			return plantilla.set(posicion, empleado);
	}

	@Override
	public Empleado buscarUno(int empleado) {
		
		Empleado em = new Empleado();
		em.setIdEmpleado(empleado);
		int posicion = plantilla.indexOf(em);
		if (posicion == -1)
			return null;
		else
			return plantilla.get(posicion);
	}

	@Override
	public double masaSalarial() {
		
		Empleado em = new Empleado();
		double total = em.getSalario() + em.getComision();
		return total;
		
		
		
	}

	@Override
	public ArrayList<Empleado> buscarPorSexo(char sexo) {
		
		ArrayList<Empleado> aux = new ArrayList<>();
		
		for (Empleado empleado: plantilla)
			if(empleado.getGenero()== sexo)
				aux.add(empleado);
		return aux;
	}

	@Override
	public ArrayList<Empleado> buscarTodos() {
		// TODO Auto-generated method stub
		return plantilla;
	}

	@Override
	public ArrayList<Empleado> buscarPorDepartamento(int idDepar) {
		
		ArrayList<Empleado> aux = new ArrayList<>();
		
		for (Empleado empleado: plantilla) {
			if(empleado.getDepartamento().getIdDepar() == idDepar)
				aux.add(empleado);
		}
		return aux;
	}

	@Override
	public ArrayList<Empleado> buscarPorTrabajo(String idTrabajo) {
		
		ArrayList<Empleado> aux = new ArrayList<>();
		
		for (Empleado empleado: plantilla) {
			if (empleado.getTrabajo().getIdTrabajo().equalsIgnoreCase(idTrabajo));
			aux.add(empleado);
		}
		return aux;
	}

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
