package PRACTICA_02;

import LIBRERIA_P.Generica_P;

public class Almacen {
		
	protected Generica_P <?,String> dt_almacen;
	
	public final String rSocial = "+ + JUGUETERIA NACIONAL + +", 
						slogan = "!! Los Mejores Jueguetes !!";
	
	public Almacen(int idFabricante, String nombreFabricante) {
		dt_almacen = new Generica_P <Integer, String> (idFabricante, nombreFabricante);
	}
	
	public int getIdFabricante() {
		return Integer.valueOf(dt_almacen.getAtributoT1().toString());
	}
	
	public String getFabricante() {
		return dt_almacen.getAtributoS1().toString();
	}
	
	public void setFabricante(String newFabricante) {
		dt_almacen.setAtributoS1(newFabricante);
	}
}
