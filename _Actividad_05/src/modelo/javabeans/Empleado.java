package modelo.javabeans;

import java.util.Objects;

public class Empleado {
	
	
	// creamos la clase empleado y en ella tienen que haber los atributos trabajo y departamento para que
	//queden referenciadas las clases pertinentes
	private int idEmpleado;
	private String nombre, apellidos, email;
	private char genero;
	private double salario, comision;
	private Trabajo trabajo;
	private Departamento departamento;
	
	
	public Empleado() {
		super();
	}
	
	
	public Empleado(int idEmpleado, String nombre, String apellidos, String email,
			char genero, double salario, double comision, Trabajo trabajo, 
			Departamento departamento) {
		super();
		this.idEmpleado = idEmpleado;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.email = email;
		this.genero = genero;
		this.salario = salario;
		this.comision = comision;
		this.trabajo = trabajo;
		this.departamento = departamento;
	}
	
	
	
	public int getIdEmpleado() {
		return idEmpleado;
	}
	
	public void setIdEmpleado(int idEmpleado) {
		this.idEmpleado = idEmpleado;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public String getApellidos() {
		return apellidos;
	}
	
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public char getGenero() {
		return genero;
	}
	
	public void setGenero(char genero) {
		this.genero = genero;
	}
	
	public double getSalario() {
		return salario;
	}
	
	public void setSalario(double salario) {
		this.salario = salario;
	}
	
	public double getComision() {
		return comision;
	}
	
	public void setComision(double comision) {
		this.comision = comision;
	}
	
	public Trabajo getTrabajo() {
		return trabajo;
	}
	
	public void setTrabajo(Trabajo trabajo) {
		this.trabajo = trabajo;
	}
	
	public Departamento getDepartamento() {
		return departamento;
	}
	
	public void setDepartamento(Departamento departamento) {
		this.departamento = departamento;
	}
	
	
	@Override
	public String toString() {
		return "Empleado [idEmpleado= " + idEmpleado + "nombre= " + nombre + 
				"apellidos= " + apellidos + "email= " + email + "genero= " + 
				genero + "salario= " + salario + "comision= " + comision + "trabajo= " + 
				trabajo + "departamento= " + departamento + "]";
	}
	
	
	@Override
	public int hashCode() {
		return Objects.hash(idEmpleado);
	}
	
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
		return false;
		Empleado other = (Empleado) obj;
		return idEmpleado == other.idEmpleado;
		
	}
	
	
	
	//cramos los diferentes metodos//
	
	
	public double salarioBruto() {
		return (salario + comision);
	}
	
	public double salarioMensual(int meses) {
		return (salario / meses);
	}
	
	
	public String literalSexo(char sexo) {
		switch (sexo){
			case 'h', 'H':
				System.out.println("Hombre");
			break;
			case 'm', 'M':
				System.out.println("Mujer");
		}
		return String.valueOf(sexo);
		
	}
	
	public String obtenerEmail() {
		String letraNombre = " ", letraApellido = " ";
		
		letraNombre = String.valueOf(nombre.toLowerCase().charAt(0));
		
		for (int i = 0; apellidos.charAt(i) != ' '; i++) {
			letraApellido += apellidos.toLowerCase().charAt(i);
		}
		
		return letraNombre + letraApellido + "@edix.com";
	}
	
	
	
	public String nombreCompleto() {
		return nombre +  apellidos;
	}
}

