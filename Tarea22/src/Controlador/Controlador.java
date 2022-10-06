package Controlador;

import java.io.IOException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
import Exception.ExcepcionIncorrecta;
import Modelo.Modelo;
import Vista.Vista;
/**
 * 
 * @author Alvaro Benitez Carmona
 *
 */
public class Controlador {
	private Vista vista;
	private Modelo modelo;
	private Boolean exit;
	Scanner teclado = new Scanner(System.in);
	/**
	 * Constructor de Controlador
	 */
	public Controlador() {
		this.vista=new Vista();
		this.modelo=new Modelo();
		this.exit=true;
		
	}
	/**
	 * Metodo que muestra que enlaza todo vista y modelo
	 */
	public void showMenu() {
		try {
			vista.helloMessage();
		} catch (IOException | InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		while (exit) {
			 int option=repeatOption(teclado,1,5,vista.menu());	
			switch(option) {
			case 1:
				vista.showConsole(modelo.ConnectDB());
				vista.showConsole(modelo.deleteTableAll());
				vista.showConsole(modelo.createTablePiezas());
				vista.showConsole(modelo.createTableProveedores());
				vista.showConsole(modelo.createTableSuministra());
				break;
			case 2:
				vista.showConsole(modelo.insertTablePiezas());
				vista.showConsole(modelo.insertTableProveedores());
				vista.showConsole(modelo.insertTableSuministra());
				break;
			case 3:
				int option1=repeatOption(teclado,1,5,vista.submenuBorrar());
				switch(option1) {
				case 1:
					vista.showConsole(modelo.deleteTable("Piezas"));
					break;
				case 2:
					vista.showConsole(modelo.deleteTable("Proveedores"));
					break;
				case 3:
					vista.showConsole(modelo.deleteTable("Suministra"));
					break;
				case 4:
					vista.showConsole(modelo.deleteTableAll());
					break;
				case 5:
					break;
				}
				break;
			case 4:
				int option2=repeatOption(teclado,1,6,vista.submenuCRUD());
				switch(option2) {
				case 1:
					int option3=repeatOption(teclado,1,3,vista.addRegister());
					ArrayList<String> dataList=	vista.collectDataAdd(option3);
					switch(option3){
					case 1:
						vista.showConsole(modelo.insertPiezas(dataList.get(0)));
						break;
					case 2:
						vista.showConsole(modelo.insertProveedores(dataList.get(0), dataList.get(1)));
						break;
					case 3:
						vista.showConsole(modelo.insertSuministra(dataList.get(0), dataList.get(1), dataList.get(2)));
						break;
					}
					break;
				case 2:
					int option4=repeatOption(teclado,1,3,vista.searchRegistertoString());
					ArrayList<String> dataList1=vista.searchRegister(option4);
					switch(option4){
					case 1:
						vista.showPiezas(modelo.search("Piezas", null, dataList1.get(0), null, null, null));
						break;
					case 2:
						vista.showProveedores(modelo.search("Proveedores", dataList1.get(0), dataList1.get(1), null, null, null));
						break;
					case 3:
					 	vista.showSuministra(modelo.search("Suministra", null, null, dataList1.get(0), dataList1.get(1), dataList1.get(2)));
						break;
					}
					break;
				case 3:
					int option5=repeatOption(teclado,1,3,vista.showTable());
					switch(option5){
					case 1:
						vista.showTable("Piezas", modelo.getSt());
						break;
					case 2:
						vista.showTable("Proveedores", modelo.getSt());
						break;
					case 3:
						vista.showTable("Suministra", modelo.getSt());
						break;
					}
					break;
				case 4:
					int option6=repeatOption(teclado,1,3,vista.modifyRegister());
					ArrayList<String> dataList2=vista.collectDataModify(option6);
					ArrayList<String> dataList3=vista.collectDataModifyMod(option6);
					switch(option6){
					case 1:
						modelo.update("Piezas", null, dataList2.get(0), null, null, null, null, dataList3.get(0), null, null, null);
						break;
					case 2:
						modelo.update("Proveedores", dataList2.get(0), dataList2.get(1), null, null, null, dataList3.get(0), dataList3.get(1), null, null, null);
						break;
					case 3:
						modelo.update("Suministra", null, null, dataList2.get(0), dataList2.get(1), dataList2.get(2),null, null, dataList3.get(0), dataList3.get(1), dataList3.get(2));
						break;
					}
					break;
				case 5:
					int option7=repeatOption(teclado,1,3,vista.deleteRegister());
					ArrayList<String> dataList4=vista.deleteRegister(option7);
					switch(option7){
					case 1:
						modelo.delete("Piezas", null, dataList4.get(0), null, null, null);
						break;
					case 2:
						modelo.delete("Proveedores", dataList4.get(0), dataList4.get(1), null, null, null);
						break;
					case 3:
					 	modelo.delete("Suministra", null, null, dataList4.get(0), dataList4.get(1), dataList4.get(2));
						break;
					}
					break;
				case 6:
					break;
				}
				break;
			case 5:
				exit=false;
				vista.showConsole(modelo.closeDB());
				System.out.println("-Aplicación cerrada. Hasta pronto!!!! :D");
				break;
			
			}	
		}
		
	}
	/**
	 * Metodo para indicar la opcion que quieres
	 * @param teclado
	 * @param min 
	 * @param max
	 * @param vista
	 * @return retorn la opcion elegida 
	 */
	private static int repeatOption(Scanner teclado, int min, int max, String vista) {
		Boolean repeat;
		int option=0;
		do {
			repeat = false;
			try {
				System.out.println(vista);
				option = teclado.nextInt();
				if (option < min || option > max) {
					throw new ExcepcionIncorrecta();
				}
			} catch (ExcepcionIncorrecta ex) {
				System.out.println(ex.getMessage());
				teclado.nextLine();
				repeat = true;
			} catch (NumberFormatException ex) {
				System.out.println(ex.getMessage());
				teclado.nextLine();
				repeat = true;
			} catch (InputMismatchException ex) {
				System.out.println("No puedes introducir un caracter");
				teclado.nextLine();
				repeat = true;
			}

		} while (repeat);
		return option;
	}
	
}
