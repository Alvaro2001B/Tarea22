package Vista;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;
/**
 * 
 * @author Alvaro Benitez Carmona
 *
 */

public class Vista {

	Scanner teclado = new Scanner(System.in);
	
	public Vista() {
		
	}
	
	/**
	 * Metodo que muestra el menu
	 * @return Retorna un String con el menu
	 */
	public String menu() {
		/*System.out.println("Menu:");
		System.out.println("	1.Inicialización DB.");
		System.out.println("	2.Insertar paquete de datos.");
		System.out.println("	3.Borrar tabla.");
		System.out.println("	4.CRUD");
		System.out.println("	5.Salir");*/
		return "Menu:\n\t\t1.Inicialización DB.\n\t\t2.Insertar paquete de datos.\n\t\t3.Borrar tabla.\n\t\t4.CRUD\n\t\t5.Salir";
	}
	
	/**
	 * Metodo que muestra el menu de borrar
	 * @return Retorna un String con el menu de borrar
	 */
	public String submenuBorrar() {
		/*System.out.println("\n\nBorrar tabla:");
		System.out.println("		1.Piezas.");
		System.out.println("		2.Proveedores.");
		System.out.println("		3.Suministra.");
		System.out.println("		4.Borrar todo.");
		System.out.println("		5.Salir");*/
		return  "Borrar tabla:\n\t\t1.Piezas DB.\n\t\t2.Proveedores.\n\t\t3.Suministra.\n\t\t4.Borrar todo.\n\t\t5.Salir";
	}
	
	/**
	 * Metodo que muestra el menu del CRUD
	 * @return  Retorna un String con el menu del CRUD
	 */
	public String submenuCRUD() {
		/*System.out.println("\n\nCRUD:");
		System.out.println("		1.Añadir registro.");
		System.out.println("		2.Consultar un registro.");
		System.out.println("		3.Listar registros.");
		System.out.println("		4.Modificar registro");
		System.out.println("		5.Borrar registro");
		System.out.println("		6.Salir");*/
		return "CRUD:\n\t\t1.Añadir registro DB.\n\t\t2.Consultar un registro.\n\t\t3.listar registros.\n\t\t4.Modificar registro\n\t\t5.Borrar registro\n\t\t6.Salir";
	}
	
	/**
	 * Metodo para indicar la tabla a elegir
	 * @return Retorna un String con el texto
	 */
	public String addRegister() {
		/*System.out.println("En que tabla quieres añadir informacion:");
		System.out.println("		1.Piezas.");
		System.out.println("		2.Proveedores.");
		System.out.println("		3.Suministra.");*/
		return "En que tabla quieres añadir informacion:\n\t\t1.Piezas.\n\t\t2.Proveedores.\n\t\t3.Suministra.";
	}
	
	/**
	 * Metodo para indicar la tabla donde quieres buscar
	 * @return Retorna un String con el texto
	 */
	public String searchRegistertoString() {
		/*System.out.println("En que tabla quieres buscar informacion:");
		System.out.println("		1.Piezas.");
		System.out.println("		2.Proveedores.");
		System.out.println("		3.Suministra.");*/
		return "En que tabla quieres buscar informacion:\n\t\t1.Piezas.\n\t\t2.Proveedores.\n\t\t3.Suministra.";
	}
	
	/**
	 * Metodo para indicar que tabla quieres mostrar
	 * @return Retorna un String con el texto
	 */
	public String showTable() {
		/*System.out.println("Que tabla quieres ver:");
		System.out.println("		1.Piezas.");
		System.out.println("		2.Proveedores.");
		System.out.println("		3.Suministra.");*/
		return "Que tabla quieres ver:\n\t\t1.Piezas.\n\t\t2.Proveedores.\n\t\t3.Suministra.";
	}
	
	/**
	 * Metodo para indicar la tabla donde quieres modificar un resgistro
	 * @return Retorna un String con el texto
	 */
	public String modifyRegister() {
		/*System.out.println("Que tabla quieres modificar:");
		System.out.println("		1.Piezas.");
		System.out.println("		2.Proveedores.");
		System.out.println("		3.Suministra.");*/
		return "Que tabla quieres modificar:\n\t\t1.Piezas.\n\t\t2.Proveedores.\n\t\t3.Suministra.";
	}
	
	/**
	 * Metodo para indicar la tabla donde quieres elim inar un registro
	 * @return
	 */
	public String deleteRegister() {
		/*System.out.println("Que tabla quieres modificar:");
		System.out.println("		1.Piezas.");
		System.out.println("		2.Proveedores.");
		System.out.println("		3.Suministra.");*/
		return "En que tabla quieres borrar un registro:\n\t\t1.Piezas.\n\t\t2.Proveedores.\n\t\t3.Suministra.";
	}
	
	/**
	 * Metodo para coger los datos para añadir un registro
	 * @param option
	 * @return Retorna un arrayList con los datos
	 */
	public ArrayList<String> collectDataAdd(int option) {
		ArrayList<String> data_list=new ArrayList<String>();
		String data=null;
		switch(option) {
		case 1:
			System.out.println("Para añadir datos en la tabla \"Piezas\" necesitamos: name");
			System.out.println("Indica el \"name\"");
			data = teclado.nextLine();
			data_list.add(data);
			break;
		case 2:
			System.out.println("Para añadir datos en la tabla \"Proveedor\" necesitamos: id/name");
			System.out.println("Indica el \"id\"");
			data = teclado.nextLine();
			data_list.add(data);
			System.out.println("Indica el \"name\"");
			data = teclado.nextLine();
			data_list.add(data);
			break;
		case 3:
			System.out.println("Para añadir datos en la tabla \"Suministra\" necesitamos: codigoPieza/idProveedor/precio");
			System.out.println("Indica el \"codigoPieza\"");
			data = teclado.nextLine();
			data_list.add(data);
			System.out.println("Indica el \"idProveedor\"");
			data = teclado.nextLine();
			data_list.add(data);
			System.out.println("Indica el \"precio\"");
			data = teclado.nextLine();
			data_list.add(data);
			break;
		}
		return data_list;
	}
	
	/**
	 * Metodo para coger los datos para modificar un registro 
	 * @param option
	 * @return Retorna un arrayList con los datos
	 */
	public ArrayList<String> collectDataModifyMod (int option) {
		ArrayList<String> data_list=new ArrayList<String>();
		String data=null;
		switch(option) {
		case 1:
			System.out.println("Para modificar datos en la tabla \"Piezas\" necesitamos: name");
			System.out.println("Indica el \"name\"");
			data = teclado.nextLine();
			if(data.equalsIgnoreCase("null")) {
				data_list.add(null);
			} else {
				data_list.add(data);
			}
			break;
		case 2:
			System.out.println("Para modificar datos en la tabla \"Proveedor\" necesitamos: id/name");
			System.out.println("Indica el \"id\"");
			data = teclado.nextLine();
			if(data.equalsIgnoreCase("null")) {
				data_list.add(null);
			} else {
				data_list.add(data);
			}
			System.out.println("Indica el \"name\"");
			data = teclado.nextLine();
			if(data.equalsIgnoreCase("null")) {
				data_list.add(null);
			} else {
				data_list.add(data);
			}
			break;
		case 3:
			System.out.println("Indica los datos que quieres modificar en la tabla \"Suministra\" (en este caso solo se podra modificar precio): codigoPieza/idProveedor/precio");
			data_list.add(null);
			data_list.add(null);
			System.out.println("Indica el \"precio\"");
			data = teclado.nextLine();
			if(data.equalsIgnoreCase("null")) {
				data_list.add(null);
			} else {
				data_list.add(data);
			}
			break;
		}
		return data_list;
	}
	/**
	 * Metodo para coger los datos donde quieres modificar un registro
	 * @param option
	 * @return Retorna un arrayList con los datos
	 */
	public ArrayList<String> collectDataModify (int option) {
		ArrayList<String> data_list=new ArrayList<String>();
		String data=null;
		switch(option) {
		case 1:
			System.out.println("Indica los datos que quieres modificar en la tabla \"Piezas\": name");
			System.out.println("Indica el \"name\"");
			data = teclado.nextLine();
			if(data.equalsIgnoreCase("null")) {
				data_list.add(null);
			} else {
				data_list.add(data);
			}
			break;
		case 2:
			System.out.println("Indica los datos que quieres modificar en la tabla \"Proveedor\": id/name");
			System.out.println("Indica el \"id\"");
			data = teclado.nextLine();
			if(data.equalsIgnoreCase("null")) {
				data_list.add(null);
			} else {
				data_list.add(data);
			}
			System.out.println("Indica el \"name\"");
			data = teclado.nextLine();
			if(data.equalsIgnoreCase("null")) {
				data_list.add(null);
			} else {
				data_list.add(data);
			}
			break;
		case 3:
			System.out.println("Indica los datos que quieres modificar en la tabla \"Suministra\": codigoPieza/idProveedor/precio");
			System.out.println("Indica el \"codigoPieza\"");
			data = teclado.nextLine();
			if(data.equalsIgnoreCase("null")) {
				data_list.add(null);
			} else {
				data_list.add(data);
			}
			System.out.println("Indica el \"idProveedor\"");
			data = teclado.nextLine();
			if(data.equalsIgnoreCase("null")) {
				data_list.add(null);
			} else {
				data_list.add(data);
			}
			System.out.println("Indica el \"precio\"");
			data = teclado.nextLine();
			if(data.equalsIgnoreCase("null")) {
				data_list.add(null);
			} else {
				data_list.add(data);
			}
			break;
		}
		return data_list;
	}
	
	/**
	 * Metodo para coger los datos del registro a buscar
	 * @param option
	 * @return Retorna un arrayList con los datos
	 */
	public ArrayList<String> searchRegister(int option) {
		ArrayList<String> data_list=new ArrayList<String>();
		String data=null;
		System.out.println("Acontinuacion indica los datos a buscar (en caso de no querer poner uno escribir null)");
		switch(option) {
		case 1:
			System.out.println("Indica los siguientes datos para buscar en la tabla \"Piezas\": ");
			System.out.println("Indica el \"name\"");
			data = teclado.nextLine();
			if(data.equalsIgnoreCase("null")) {
				data_list.add(null);
			} else {
				data_list.add(data);
			}
			break;
		case 2:
			System.out.println("Indica los siguientes datos para buscar en la tabla \"Proveedores\": ");
			System.out.println("Indica el \"id\"");
			data = teclado.nextLine();
			if(data.equalsIgnoreCase("null")) {
				data_list.add(null);
			} else {
				data_list.add(data);
			}
			System.out.println("Indica el \"name\"");
			data = teclado.nextLine();
			if(data.equalsIgnoreCase("null")) {
				data_list.add(null);
			} else {
				data_list.add(data);
			}
			break;
		case 3:
			System.out.println("Indica los siguientes datos para buscar en la tabla \"Suministra\": ");
			System.out.println("Indica el \"codigoPieza\"");
			data = teclado.nextLine();
			if(data.equalsIgnoreCase("null")) {
				data_list.add(null);
			} else {
				data_list.add(data);
			}
			System.out.println("Indica el \"idProveedor\"");
			data = teclado.nextLine();
			if(data.equalsIgnoreCase("null")) {
				data_list.add(null);
			} else {
				data_list.add(data);
			}
			System.out.println("Indica el \"precio\"");
			data = teclado.nextLine();
			if(data.equalsIgnoreCase("null")) {
				data_list.add(null);
			} else {
				data_list.add(data);
			}
			break;
		}
		return data_list;
	}
	
	/**
	 * Metodo para coger los datos del registro a eliminar.
	 * @param option
	 * @return Retorna un arrayList con los datos
	 */
	public ArrayList<String> deleteRegister(int option) {
		ArrayList<String> data_list=new ArrayList<String>();
		String data=null;
		System.out.println("Acontinuacion indica los datos de los registros que quieres borrar (en caso de no querer poner uno escribir null)");
		switch(option) {
		case 1:
			System.out.println("Indica los siguientes datos para eliminar en la tabla \"Piezas\": ");
			System.out.println("Indica el \"name\"");
			data = teclado.nextLine();
			if(data.equalsIgnoreCase("null")) {
				data_list.add(null);
			} else {
				data_list.add(data);
			}
			break;
		case 2:
			System.out.println("Indica los siguientes datos para eliminar en la tabla \"Proveedores\": ");
			System.out.println("Indica el \"id\"");
			data = teclado.nextLine();
			if(data.equalsIgnoreCase("null")) {
				data_list.add(null);
			} else {
				data_list.add(data);
			}
			System.out.println("Indica el \"name\"");
			data = teclado.nextLine();
			if(data.equalsIgnoreCase("null")) {
				data_list.add(null);
			} else {
				data_list.add(data);
			}
			break;
		case 3:
			System.out.println("Indica los siguientes datos para eliminar en la tabla \"Suministra\": ");
			System.out.println("Indica el \"codigoPieza\"");
			data = teclado.nextLine();
			if(data.equalsIgnoreCase("null")) {
				data_list.add(null);
			} else {
				data_list.add(data);
			}
			System.out.println("Indica el \"idProveedor\"");
			data = teclado.nextLine();
			if(data.equalsIgnoreCase("null")) {
				data_list.add(null);
			} else {
				data_list.add(data);
			}
			System.out.println("Indica el \"precio\"");
			data = teclado.nextLine();
			if(data.equalsIgnoreCase("null")) {
				data_list.add(null);
			} else {
				data_list.add(data);
			}
			break;
		}
		return data_list;
	}
	
	/**
	 * Metodo que muestra las piezas
	 * @param rs
	 */
	public String showPiezas(ResultSet rs) {
		String str="\n";
		try {
			while (rs.next()) {
				str=str+rs.getString(1) + " " + rs.getString(2)+"\n";
					  System.out.println( rs.getString(1) + " " + rs.getString(2) + " "/* +
					  rs1.getString(3) + " " + rs1.getString(4)+" "+ rs1.getString(5)*/); 
					 }
			
		}catch (SQLException ex) {
			System.out.println(ex);
		}
		return str;
	}
	
	/**
	 * Metodo que muestra los proveedores
	 * @param rs
	 */
	public String showProveedores(ResultSet rs) {
		String str="\n";
		try {
			
			while (rs.next()) {
				str=str+rs.getString(1) + " " + rs.getString(2)+"\n";
					  System.out.println( rs.getString(1) + " " + rs.getString(2) + " " 
					 /* rs2.getString(3) + " " + rs2.getString(4)+" " +rs1.getString(5)*/); 
					 }
		}catch (SQLException ex) {
			System.out.println(ex);
		}
		return str;
	}
	
	/**
	 * Metodo que muestra suministra
	 * @param rs
	 * @return 
	 */
	public String showSuministra(ResultSet rs) {
		String str="\n";
		try {
			while (rs.next()) {
				str=str+rs.getString(1) + " " + rs.getString(2)+" "+rs.getString(3)+"\n";
					  System.out.println( rs.getString(1) + " " + rs.getString(2) + " " +
					  rs.getString(3) /*+ " " + rs3.getString(4)+ " "+ rs1.getString(5)*/); 
					 }
			
		}catch (SQLException ex) {
			System.out.println(ex);
		}
		return str;
	}

	/**
	 * Metodo que muestra una tabla 
	 * @param nameDB
	 * @param st1
	 */
	public String showTable(String nameDB, Statement st1) {
		String str="\n";
		try {
			ResultSet rs = st1.executeQuery("select * from "+nameDB);
			if(nameDB.equalsIgnoreCase("Piezas") || nameDB.equalsIgnoreCase("Proveedores")) {
				while (rs.next()) {
					str=str+rs.getString(1) + " " + rs.getString(2)+"\n";
					  System.out.println( rs.getString(1) + " " + rs.getString(2)/* + " " +
					  rs1.getString(3) + " " + rs3.getString(4)+ " "+ rs1.getString(5)*/); 
					 }
			}else {
				while (rs.next()) {
					str=str+rs.getString(1) + " " + rs.getString(2) + " " +
							  rs.getString(3)+"\n";
					  System.out.println( rs.getString(1) + " " + rs.getString(2) + " " +
					  rs.getString(3) /*+ " " + rs3.getString(4)+ " "+ rs1.getString(5)*/); 
					 }
			}
		}catch (SQLException ex) {
			System.out.println(ex);
		}
		return str;
	}

	/**
	 * Mensaje de bienvenida
	 * @throws IOException
	 * @throws InterruptedException
	 */
	public void helloMessage() throws IOException, InterruptedException {
		System.out.println("Bienvenido al ejercicio 22.");
		System.out.println("Iniciando aplicacion");
		for (int i = 0; i <= 200; i = i + 20) {
		    progressPercentage(i, 200);
		    try {
		        Thread.sleep(250);
		    } catch (Exception e) {
		    }
		System.out.println();    
		}
	}
	
	public void showConsole(String text) {
		System.out.println(text);
	}
	
	/**
	 * Metodo de la barra de carga
	 * @param remain
	 * @param total
	 */
	public static void progressPercentage(int remain, int total) {
	    if (remain > total) {
	        throw new IllegalArgumentException();
	    }
	    int maxBareSize = 10; // 10unit for 100%
	    int remainProcent = ((100 * remain) / total) / maxBareSize;
	    char defaultChar = '-';
	    String icon = "*";
	    String bare = new String(new char[maxBareSize]).replace('\0', defaultChar) + "]";
	    StringBuilder bareDone = new StringBuilder();
	    bareDone.append("[");
	    for (int i = 0; i < remainProcent; i++) {
	        bareDone.append(icon);
	    }
	    String bareRemain = bare.substring(remainProcent, bare.length());
	    System.out.print("\r" + bareDone + bareRemain + " " + remainProcent * 10 + "%");
	    if (remain == total) {
	        System.out.print("\n");
	    }
	}
	
	
}
