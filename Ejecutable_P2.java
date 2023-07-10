package PRACTICA_02;

import java.util.Scanner;

import LIBRERIA_P.Generica_P;

public class Ejecutable_P2 {

	public static void main(String[] args) {

		int opc = 0, id =0, total =0;
		double precio = 0.0;
		String nombre;
		
		Almacen alm = new Almacen(0,"===");
		Generica_P <Juguete, String>dmenu = new Generica_P <Juguete, String>();
		
		@SuppressWarnings("resource")
		Scanner in = new Scanner(System.in); 
		
		System.out.println(alm.rSocial + "\n" + alm.slogan);
		do {		
			System.out.print("\n- MENU PRINCIPAL -" +
							   "\n1. Ingresar Nueva Adquisicion" +
							   "\n2. Listar Juguetes de Inventario" + 
							   "\n3. Vender Juguetes" + 
							   "\n4. Stock de Productos" + 
							   "\n0. Salir" + 
							   "\nIngrese su opcion: ");
			opc = in.nextInt();
			
			switch (opc) {
				case 1:
					System.out.println("\n- IGREASAR NUEVA ADQUISICION -");
					System.out.print("\nIdentificador: ");
					id = in.nextInt();
									
					System.out.print("Fabricante: ");
					dmenu.setAtributoS1(in.next());
					
					System.out.print("Nombre del Juguete: ");
					nombre = in.next();
					dmenu.setAtributoS2(nombre);
										
					System.out.print("Precio: ");
					precio = in.nextDouble();
					
					System.out.print("Total de prodcutos Comprados: ");
					total = in.nextInt();
					
					dmenu.addElemento(new Juguete(id, dmenu.getAtributoS1(), dmenu.getAtributoS2(), ((precio*0.12)+precio), total));
					System.out.println();
					break;
					
				case 2:
					System.out.println("\n- INVENTARIO -\n");
					for(Juguete j1: dmenu.getAlmacen()) {
						System.out.println(j1.toString());
					}					
					break;
					
				case 3:
					System.out.println("\n- VENDER JUGUETES -");
					System.out.print("\nIngrese el nombre del juguete: ");
					dmenu.setAtributoS2(in.next());
					System.out.print("Cantidad a comprar: ");
					total = in.nextInt();
					
					for(Juguete p1: dmenu.getAlmacen()) {
						if(p1.getJuguete().equalsIgnoreCase(dmenu.getAtributoS2())) {
							if(!p1.restock()) {
								if(p1.getStock()>=total) {
									p1.setStock(p1.getStock()-total);
									System.out.println("Produtos comprados Total: $" + (((precio*0.12)+precio)*total));
								}else {
									System.out.println("La cantidad insuficente a lo solicitado [" + p1.getStock() + "]");
								}
							}else {
								System.out.println("Productos existente en bodega #" + p1.getStock() + " productos");
							}
						}
					}
					System.out.println();
					break;
					
				case 4:
					System.out.println("\n- ACTUALIZAR STOCK DE PRODUCTOS -");
					System.out.print("\nID del producto: ");
					id = in.nextInt();
					
					System.out.print("Ingrese el nombre del juguete: ");
					dmenu.setAtributoS2(in.next());
					
					System.out.print("Ingrese el nuevo stock: ");
					total = in.nextInt();
										
					for(Juguete p1: dmenu.getAlmacen()) {
						if(p1.getJuguete().equals(dmenu.getAtributoS2())) {
							if(!p1.restock2()) {
								if(p1.getStock()==0) {
									p1.setStock(p1.getStock() + total);
									System.out.println("Pedido procesado, Entregados y listos para la venta [" + p1.getStock() + "]");
								}else {
									System.out.println("Aun existen unidades [" + p1.getStock() + "]");
								}
							}else {
								System.out.println("Productos existente en bodega #" + p1.getStock());
							}
						}
					}
					System.out.println();
					break;
					
				case 0:
					System.out.print("\nDesea salir [s/n]:");
					if(in.next().toLowerCase().equals("s")) {
						System.out.println("\nSaliendo....");
						break;
					}				
	
				default:
					System.out.println("\nERROR OPCION INCORRECTA....");
					System.out.println();
					break;
			}
		}while(opc!=0);
	}
}
