package Modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
/**
 * 
 * @author Alvaro Benitez Carmona
 *
 */
public class Modelo {
	//Dejo estos valores por defecto por si se utiliza el primer constructor por defecto. 
	private String bd = "java";
	private String login = "root";
	private String password = "Alvaro123-456-789";
	private String url = "jdbc:mysql://localhost:3306/" + bd;
	private Connection conn = null;
	private Statement st1=null;
	private boolean piezasCreada=false, proveedoresCreada = false, suministraCreada = false;
	
	
	/**
	 * Constructor por defecto
	 */
	public Modelo() {}
	
	/**
	 * Constructor pasado por parametro
	 * @param bd
	 * @param login
	 * @param password
	 * @param url
	 */
	public Modelo(String bd, String login, String password, String url) {
		this.bd=bd;
		this.login=login;
		this.password=password;
		this.url=url;
	}

	/**
	 * Metodo para iniciar la conexion con las base de datos
	 */
	public String ConnectDB() {
		try {
			String sURL = url;
			conn = DriverManager.getConnection(sURL, login, password);
			if (conn != null) {
				this.st1 = conn.createStatement();
				
	}
	}catch (SQLException ex) {
		System.out.println(ex);
		}
		return "-Abierta base de datos " + url + " - Ok";
	}
	

	/**
	 * Metodo para borrar todas las tablas
	 */
		public String deleteTableAll() {
			try {
			st1.executeUpdate("DROP TABLE IF EXISTS Suministra");
			st1.executeUpdate("DROP TABLE IF EXISTS Piezas");
			st1.executeUpdate("DROP TABLE IF EXISTS Proveedores");
			piezasCreada=false;
			proveedoresCreada=false;
			suministraCreada=false;
			}catch (SQLException ex) {
				System.out.println(ex);
			}
			return "-Borrar todas las tablas - Ok";
		}
		
		/**
		 * Metodo para borrar una tabla pasada por parametro
		 * @param name
		 */
		public String deleteTable(String name) {
			try {
			st1.executeUpdate("DROP TABLE IF EXISTS "+name);
			switch(name) {
			case "Piezas":
				piezasCreada=false;
				break;
			case "Proveedores":
				proveedoresCreada=false;
				break;
			case "Suministra":
				suministraCreada=false;
				break;
			
			
			}
			}catch (SQLException ex) {
				System.out.println(ex);
			}
			return "-Tabla "+name+" borrada - Ok";
		}
		
		/**
		 * Metodo que crea la tabla de piezas
		 */
		public String createTablePiezas() {
			try {
			st1.executeUpdate("create table Piezas(\r\n"
					+ "codigo int auto_increment,\r\n"
					+ "nombre nvarchar(100),\r\n"
					+ "primary key(codigo)\r\n"
					+ ");");
			piezasCreada=true;
			}catch (SQLException ex) {
				System.out.println(ex);
			}
		return "-Tabla Piezas creada - Ok";
		}
		
		/**
		 * Metodo que crea la tabla de proveedores
		 */
		public String createTableProveedores() {
			try {
				st1.executeUpdate("create table Proveedores(\r\n"
						+ "id char(4),\r\n"
						+ "nombre nvarchar(100),\r\n"
						+ "primary key(id)\r\n"
						+ ");");
				proveedoresCreada=true;
			}catch (SQLException ex) {
				System.out.println(ex);
			}
			return "-Tabla Proveedores creada - Ok";
		}
		
		/**
		 * Metodo que crea la tabla de suministra
		 */
		public String createTableSuministra() {
			try {
				st1.executeUpdate("create table Suministra(\r\n"
						+ "codigoPieza int ,\r\n"
						+ "idProveedor char(4) ,\r\n"
						+ "precio int,\r\n"
						+ "primary key(codigoPieza,idProveedor),\r\n"
						+ "foreign key(codigoPieza) references Piezas(codigo) ON UPDATE CASCADE ON DELETE CASCADE,\r\n"
						+ "foreign key(idProveedor) references Proveedores(id) ON UPDATE CASCADE ON DELETE CASCADE\r\n"
						+ ");");
				suministraCreada = true;
			}catch (SQLException ex) {
				System.out.println(ex);
			}
			return "-Tabla Suministra creada - Ok";
		}
		
		
		/**
		 * Metodo que inserta datos en la tabla piezas
		 */
		public String insertTablePiezas() {
			try {
				if(piezasCreada == false) {
					createTablePiezas();
				}
			st1.executeUpdate("insert into Piezas(nombre) values ('Alvaro');");
			st1.executeUpdate("insert into Piezas(nombre) values ('Asmita');");
			st1.executeUpdate("insert into Piezas(nombre) values ('Andrea');");
			st1.executeUpdate("insert into Piezas(nombre) values ('Lucia');");
			st1.executeUpdate("insert into Piezas(nombre) values ('Joan');");
			
			}catch (SQLException ex) {
				System.out.println(ex);
			}
			return "-Datos insertados en tabla Piezas - Ok";
		}
		
		/**
		 * Metodo que inserta datos en la tabla proveedores
		 */
		public String insertTableProveedores() {
			try {
				if(proveedoresCreada == false) {
					createTableProveedores();
				}
				st1.executeUpdate("insert into Proveedores(id,nombre) values(5362,\"Alvaro\");");
				st1.executeUpdate("insert into Proveedores(id,nombre) values(9562,\"Asmita\");");
				st1.executeUpdate("insert into Proveedores(id,nombre) values(6231,\"Andrea\");");
				st1.executeUpdate("insert into Proveedores(id,nombre) values(7458,\"Lucia\");");
				st1.executeUpdate("insert into Proveedores(id,nombre) values(4136,\"Joan\");");
			}catch (SQLException ex) {
				System.out.println(ex);
			}
			return "-Datos insertados en tabla Proveedores - Ok";
		}
		
		/**
		 * Metodo que inserta datos en la tabla suministra
		 */
		public String insertTableSuministra() {
			try {
				if(suministraCreada == false) {
					createTableSuministra();
				}
				st1.executeUpdate("insert into Suministra(codigoPieza,idProveedor,precio) values(1,5362,550);");
				st1.executeUpdate("insert into Suministra(codigoPieza,idProveedor,precio) values(2,9562,550);");
				st1.executeUpdate("insert into Suministra(codigoPieza,idProveedor,precio) values(3,6231,550);");
				st1.executeUpdate("insert into Suministra(codigoPieza,idProveedor,precio) values(4,7458,550);");
				st1.executeUpdate("insert into Suministra(codigoPieza,idProveedor,precio) values(5,4136,550);");
			}catch (SQLException ex) {
				System.out.println(ex);
			}
			return "-Datos insertados en tabla Suministra - Ok";
		}
		
		/**
		 * Metodo para insertar un resgistro en la tabla piezas
		 * @param name
		 */
		public String insertPiezas(String name) {
			try {
			st1.executeUpdate("insert into Piezas(nombre) values ('"+name+"');");
			}catch (SQLException ex) {
				System.out.println(ex);
			}
			return "-Resgistro insertado en tabla Piezas - Ok"; 
		}
		
		/**
		 *  Metodo para insertar un resgistro en la tabla proveedores
		 * @param id
		 * @param name
		 */
		public String insertProveedores(String id, String name) {
			try {
				st1.executeUpdate("insert into Proveedores(id,nombre) values('"+id+"','"+name+"');");
			}catch (SQLException ex) {
				System.out.println(ex);
			}
			return "-Resgistro insertado en tabla Proveedores - Ok";
		}
		
		/**
		 *  Metodo para insertar un resgistro en la tabla suministra
		 * @param codigoPiezas
		 * @param idProveedor
		 * @param precio
		 */
		public String insertSuministra(String  codigoPiezas, String idProveedor, String precio) {
			try {
				st1.executeUpdate("insert into Suministra(codigoPieza,idProveedor,precio) values('"+codigoPiezas+"','"+idProveedor+"','"+precio+"');");
			
			}catch (SQLException ex) {
				System.out.println(ex);
			}
			return "-Resgistro insertado en tabla Suministra - Ok"; 
		}
		
		
		/**
		 * 	Metodo que modifica registros de las tablas.
		 * @param nameDB
		 * @param id
		 * @param name
		 * @param codigoPiezas
		 * @param idProveedor
		 * @param precio
		 * @param id_mod
		 * @param name_mod
		 * @param codigoPiezas_mod
		 * @param idProveedor_mod
		 * @param precio_mod
		 */
		public void update(String nameDB,String id, String name, String codigoPiezas, String idProveedor , String precio,String id_mod, String name_mod, String codigoPiezas_mod, String idProveedor_mod , String precio_mod) {
			try {
				if(nameDB.equalsIgnoreCase("Proveedores") || nameDB.equalsIgnoreCase("Piezas")) {
			
				if(id == null && name != null) {
					if(nameDB.equalsIgnoreCase("Piezas")){
						st1.executeUpdate("update "+nameDB+" set nombre='"+name_mod+"'  where nombre= "+ "'"+name+"'");
					}
					if(id_mod==null && name_mod!=null && nameDB.equalsIgnoreCase("Proveedores")) {
						st1.executeUpdate("update "+nameDB+" set nombre='"+name_mod+"'  where nombre= "+ "'"+name+"'");
					}else {
						st1.executeUpdate("update "+nameDB+" set id='"+id_mod+"'  where nombre= "+ "'"+name+"'");
					}
				}else if(name == null && id != null){
					if(id_mod!=null && name_mod==null) {
						st1.executeUpdate("update "+nameDB+" set id='"+id_mod+"'  where id= "+ "'"+id+"'");
					}else {
						st1.executeUpdate("update "+nameDB+" set nombre='"+name_mod+"'  where id= "+ "'"+id+"'");
					}
				} else {
				if(name_mod!=null && id_mod==null) {
					st1.executeUpdate("update "+nameDB+" set nombre='"+name_mod+"' where id ="+"'"+id+"'"+" AND upper(nombre) = "+ "'"+name.toUpperCase()+"'");
				}else if(name_mod==null && id_mod!=null) {
					st1.executeUpdate("update "+nameDB+" set id='"+id_mod+"' where id ="+"'"+id+"'"+" AND upper(nombre) = "+ "'"+name.toUpperCase()+"'");
				}else {
					st1.executeUpdate("update "+nameDB+" set nombre='"+name_mod+"', id = "+"'"+id_mod+"' where id ="+"'"+id+"'"+" AND upper(nombre) = "+ "'"+name.toUpperCase()+"'");
				}
					
				}
				}else {
					if(idProveedor != null && codigoPiezas==null && precio == null ) {
							st1.executeUpdate("update "+nameDB+" set precio='"+precio_mod+"' where idProveedor ="+"'"+idProveedor+"'");
					}else if(idProveedor == null && codigoPiezas!=null && precio == null ) {
							st1.executeUpdate("update "+nameDB+" set precio='"+precio_mod+"' where codigoPieza ="+"'"+codigoPiezas+"'");
					}else if(idProveedor == null && codigoPiezas==null && precio != null){
							st1.executeUpdate("update "+nameDB+" set precio='"+precio_mod+"' where precio ="+"'"+precio+"'");	
					}else if(idProveedor != null && codigoPiezas==null && precio != null) {	
							st1.executeUpdate("update "+nameDB+" set precio='"+precio_mod+"'  where idProveedor ="+"'"+idProveedor+"'"+" AND precio = "+ "'"+precio+"'");
					}else if(idProveedor != null && codigoPiezas!=null && precio == null) {		
								st1.executeUpdate("update "+nameDB+" set precio='"+precio_mod+"' where idProveedor ="+"'"+idProveedor+"'"+" AND codigoPieza = "+ "'"+codigoPiezas+"'");					
					}else if(idProveedor == null && codigoPiezas!=null && precio != null) {
							st1.executeUpdate("update "+nameDB+" set precio='"+precio_mod+"'  where codigoPieza ="+"'"+codigoPiezas+"'"+" AND precio = "+ "'"+precio+"'");
					}else {
							st1.executeUpdate("update "+nameDB+" set precio='"+precio_mod+ "' where idProveedor ="+"'"+idProveedor+"'"+" AND precio = "+ "'"+precio+"'"+" AND codigoPieza = "+ "'"+codigoPiezas+"'");						
					}
				}
			}
			
			catch (SQLException e) {
				System.out.println(e);
			} }
		
		/**
		 * Metodo para buscar un regsitro en concreto
		 * @param nameDB
		 * @param id
		 * @param name
		 * @param codigoPiezas
		 * @param idProveedor
		 * @param precio
		 * @return Retorna un resulset para luego poder mostrarlo con las vista
		 */
		public ResultSet search(String nameDB, String id, String name,String codigoPiezas, String idProveedor , String precio) {
			try {
				if(nameDB.equalsIgnoreCase("Proveedores") || nameDB.equalsIgnoreCase("Piezas")) {
				
				if(id == null && name != null) {
						ResultSet rs1 = st1.executeQuery("select * from "+nameDB+" where upper(nombre)= "+ "'"+name.toUpperCase()+"'");
						return rs1;
				}else if(name == null && id != null){
					ResultSet rs1 = st1.executeQuery("select * from "+nameDB+" where id ="+"'"+id+"'");
					return rs1;
				} else {
					ResultSet rs1 = st1.executeQuery("select * from "+nameDB+" where id ="+"'"+id+"'"+" AND upper(nombre) = "+ "'"+name.toUpperCase()+"'");
					return rs1;
				}
				}else {
					if(idProveedor != null && codigoPiezas==null && precio == null ) {
						ResultSet rs1 = st1.executeQuery("select * from "+nameDB+" where idProveedor = "+ "'"+idProveedor+"'");
						return rs1;
					}else if(idProveedor == null && codigoPiezas!=null && precio == null ) {
						ResultSet rs1 = st1.executeQuery("select * from "+nameDB+" where codigoPieza = "+ "'"+codigoPiezas+"'");
						return rs1;
					}else if(idProveedor == null && codigoPiezas==null && precio != null){
						ResultSet rs1 = st1.executeQuery("select * from "+nameDB+" where precio = "+ "'"+precio+"'");
						return rs1;
					}else if(idProveedor != null && codigoPiezas==null && precio != null) {
						ResultSet rs1 = st1.executeQuery("select * from "+nameDB+" where precio ="+"'"+precio+"'"+" AND idProveedor = "+ "'"+idProveedor+"'");
						return rs1;
					}else if(idProveedor != null && codigoPiezas!=null && precio == null) {
						ResultSet rs1 = st1.executeQuery("select * from "+nameDB+" where codigoPieza ="+"'"+codigoPiezas+"'"+" AND idProveedor= "+ "'"+idProveedor+"'");
						return rs1;
					}else if(idProveedor == null && codigoPiezas!=null && precio != null) {
						ResultSet rs1 = st1.executeQuery("select * from "+nameDB+" where precio ="+"'"+precio+"'"+" AND codigoPieza= "+ "'"+codigoPiezas+"'");
						return rs1;
					}else {
						 ResultSet rs1 = st1.executeQuery("select * from "+nameDB+" where codigoPieza ="+"'"+codigoPiezas+"'"+" AND idProveedor= "+ "'"+idProveedor+"'"+ " AND precio= "+ "'"+precio+"'");
							return rs1;
					}
					
					
				}
			
			}
			
			catch (SQLException e) {
				System.out.println(e);
			}
			return null; }
		
		
		/**
		 * Metodo para borrar un registro en concreto
		 * @param nameDB
		 * @param id
		 * @param name
		 * @param codigoPiezas
		 * @param idProveedor
		 * @param precio
		 */
		public void delete(String nameDB, String id, String name,String codigoPiezas, String idProveedor , String precio) {
			try {
				if(nameDB.equalsIgnoreCase("Proveedores") || nameDB.equalsIgnoreCase("Piezas")) {
				
				if(id == null && name != null) {
					st1.executeUpdate("delete from "+nameDB+" where upper(nombre)= "+ "'"+name.toUpperCase()+"'");
				}else if(name == null && id != null){
					st1.executeUpdate("delete from "+nameDB+" where id ="+"'"+id+"'");
				} else {
					st1.executeUpdate("delete from "+nameDB+" where id ="+"'"+id+"'"+" AND upper(nombre) = "+ "'"+name.toUpperCase()+"'");
				}
				}else {
					if(idProveedor != null && codigoPiezas==null && precio == null ) {
						st1.executeUpdate("delete from "+nameDB+" where idProveedor = "+ "'"+idProveedor+"'");
					}else if(idProveedor == null && codigoPiezas!=null && precio == null ) {
						st1.executeUpdate("delete from "+nameDB+" where codigoPieza = "+ "'"+codigoPiezas+"'");
					}else if(idProveedor == null && codigoPiezas==null && precio != null){
						st1.executeUpdate("delete from "+nameDB+" where precio = "+ "'"+precio+"'");
					}else if(idProveedor != null && codigoPiezas==null && precio != null) {
						st1.executeUpdate("delete from "+nameDB+" where precio ="+"'"+precio+"'"+" AND idProveedor = "+ "'"+idProveedor+"'");
					}else if(idProveedor != null && codigoPiezas!=null && precio == null) {
						st1.executeUpdate("delete from "+nameDB+" where codigoPieza ="+"'"+codigoPiezas+"'"+" AND idProveedor= "+ "'"+idProveedor+"'");
					}else if(idProveedor == null && codigoPiezas!=null && precio != null) {
						st1.executeUpdate("delete from "+nameDB+" where precio ="+"'"+precio+"'"+" AND codigoPieza= "+ "'"+codigoPiezas+"'");
					}else {
						st1.executeUpdate("delete from "+nameDB+" where codigoPieza ="+"'"+codigoPiezas+"'"+" AND idProveedor= "+ "'"+idProveedor+"'"+ " AND precio= "+ "'"+precio+"'");
					}
				}
			}
			catch (SQLException e) {
				System.out.println(e);
			}
		 }
		
		
		
		/**
		 * Metodo que cierra la conexion
		 */
		public String closeDB() {
			try {
				conn.close(); 
			}catch (SQLException ex) {
				System.out.println(ex);
			}
			return "-Cerrar base de datos " + url + " - Ok";
		}
		/**
		 * Metodo getST 
		 * @return Devuleve un el statement st1
		 */
		public Statement getSt() {
			return st1;
		}
		
		/**
		 * Metoddo getUrl
		 * @return Devuelve el valor de url
		 */
		public String getUrl() {
			return url;
		}
}

