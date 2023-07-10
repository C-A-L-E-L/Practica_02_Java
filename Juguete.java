package PRACTICA_02;

import LIBRERIA_P.Generica_P;

public class Juguete extends Almacen{

	private Generica_P <?, Integer> dJuguete;
	
	public Juguete(int idFabricante, String nombreFabricante, String nombreJuguete, double precio, int stock) {
		super(idFabricante, nombreFabricante);
		dt_almacen.setAtributoS2(nombreJuguete);
		//dJuguete = new Generica_P <Double, Integer>(precio, stock);
		dJuguete = new Generica_P <Double, Integer>(precio, stock);
	}
	
	public int getStock() { // umboxing
		return  dJuguete.getAtributoS1();
	}
	
	public void setStock(int newStock) { // umboxing
		 dJuguete.setAtributoS1(Integer.valueOf(newStock));
	}
		
	// Fabricante <- Almacen
	
	public void setJuguete(String newJuguete) {
		dt_almacen.setAtributoS2(newJuguete);
	}
	
	public String getJuguete() {
		return dt_almacen.getAtributoS2();
	}
	
	public boolean restock() {
		if(getStock()>0) {
			return false; // no puedo midificar
		}
		return true; // se puede mofidicar
	}
	
	public boolean restock2() {
		if(getStock()==0) {
			return false; // no puedo midificar
		}
		return true; // se puede mofidicar
	}
		
	public String toString() {
		return 	getIdFabricante() + ".- " + getFabricante()  + ": " + getJuguete() + " $" +
				dJuguete.getAtributoT1() + " [Includo IVA] " + dJuguete.getAtributoS1() + " Uni ";
	}
}
