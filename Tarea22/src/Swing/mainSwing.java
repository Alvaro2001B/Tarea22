package Swing;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import Modelo.Modelo;
import Vista.Vista;

public class mainSwing extends JFrame{
	private JFrame frame;
	private JButton button1, button2, button3, button4, button5, button6, button7, button8, button9, button10, button11, button12, button13, button14, button15, button16;
	private JLabel text1, text2, text3, text4,text5;
	private JTextArea log1;
	private JTextField field1, field2, field3;
	private JComboBox selec_tabla;
	private JPanel menu, log, insertData, menu_n,menu_c, menu_s, right, left, window,vacio, menu1,insertData_s, insertData_n, insertData_c, data1, data2, data3, data4, data5, data6, data4_1, data5_1, data6_1;
	private Modelo modelo=new Modelo();
	private Vista vista=new Vista();
	private static boolean crudAdd , crudRequest, crudShow, crudModify, crudDelete;
	private String option;

	public mainSwing() {
	super("TAREA_22_SWING");	
	this.setLocation(490, 150);
	this.setSize(750, 600);
	this.setLayout(new FlowLayout(0, 70, 0));
	
	//Inicializar variables
	crudAdd = false;
	crudRequest = false;
	crudShow = false;
	crudModify = false;
	crudDelete = false;
	option = null;
	String[] tablas = { "Piezas", "Proveedores", "Suministra"};
	selec_tabla = new JComboBox(tablas);
	frame = new JFrame();
	button1 = new JButton("Inicar DB");
	button2 = new JButton("Inicializar datos");
	button3 = new JButton("Borrar datos");
	button4 = new JButton("CRUD");
	button5 = new JButton("Salir");
	button6 = new JButton("Aplicar");
	button7 = new JButton("Piezas");
	button8 = new JButton("Proveedores");
	button9 = new JButton("Suministra");
	button10 = new JButton("Borrar todo");
	button11 = new JButton("Volver");
	button12 = new JButton("Añadir");
	button13 = new JButton("Consultar");
	button14 = new JButton("Listar");
	button15 = new JButton("Modifcar");
	button16 = new JButton("Borrar");
	text1 = new JLabel("MENU:");
	text2 = new JLabel("Selecciona una tabla: ");
	text3 = new JLabel("Indica el nombre:");
	text4 = new JLabel("Indica el id:");
	text5 = new JLabel("Indica el precio:");
	log1 = new JTextArea();
	field1 = new JTextField(10);
	field2 = new JTextField(10);
	field3 = new JTextField(10);
	menu = new JPanel();
	menu_n = new JPanel();
	menu_c = new JPanel();
	menu_s = new JPanel();
	log = new JPanel();
	insertData = new JPanel();
	insertData_n = new JPanel();
	insertData_c = new JPanel();
	insertData_s = new JPanel();
	left = new JPanel();
	right = new JPanel();
	window = new JPanel();
	vacio = new JPanel();
	menu1=new JPanel();
	data1 = new JPanel();
	data2 = new JPanel();
	data3 = new JPanel();
	log1.setPreferredSize(new Dimension(350, 475));
	right.setBorder(new EmptyBorder(25, 50, 60, 0));
	
	
	//Listeners
	selec_tabla.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			switch(selec_tabla.getSelectedItem().toString()) {
			case "Piezas":
				insertData_c.setVisible(false);
				data1.removeAll();
				data2.removeAll();
				data3.removeAll();
				if(crudModify == true) {
					text3.setText("Indica el nombre/nombre_Mod");
				}else {
					text3.setText("Indica el nombre:");
				}
				data1.add(text3);
				data1.add(field1);
				insertData_c.add(data1, BorderLayout.NORTH);
				insertData_c.add(data2, BorderLayout.CENTER);
				insertData_c.add(data3, BorderLayout.SOUTH);
				insertData_c.setVisible(true);
				break;
			case "Proveedores":
				insertData_c.setVisible(false);
				data1.removeAll();
				data2.removeAll();
				data3.removeAll();
				if(crudModify == true) {
					text3.setText("Indica el nombre/nombre_Mod");
					text4.setText("Indica el id/id_Mod");
				}else {
					text3.setText("Indica el nombre:");
					text4.setText("indica el id:");
				}
				
				data1.add(text3);
				data1.add(field1);
				data2.add(text4);
				data2.add(field2);
				insertData_c.add(data1, BorderLayout.NORTH);
				insertData_c.add(data2, BorderLayout.CENTER);
				insertData_c.add(data3, BorderLayout.SOUTH);
				insertData_c.setVisible(true);
				break;
			case "Suministra":
				insertData_c.setVisible(false);
				data1.removeAll();
				data2.removeAll();
				data3.removeAll();
				if(crudModify == true) {
					text3.setText("Indica el codigoPiezas");
					text4.setText("Indica el idProveedor");
					text5.setText("Indica el precio/precio_mod");
				}else {
					text3.setText("Indica el codigoPieza:");
					text4.setText("indica el idProveedor:");
					text5.setText("Indica el precio:");
				}
				data1.add(text3);
				data1.add(field1);
				data2.add(text4);
				data2.add(field2);
				data3.add(text5);
				data3.add(field3);
				insertData_c.add(data1, BorderLayout.NORTH);
				insertData_c.add(data2, BorderLayout.CENTER);
				insertData_c.add(data3, BorderLayout.SOUTH);
				insertData_c.setVisible(true);
				break;
			}
		}
	});
	
	
	
	button1.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			log1.setText(log1.getText()+"\n"+modelo.ConnectDB()+"\n"+modelo.deleteTableAll()+"\n"+modelo.createTablePiezas()+"\n"+modelo.createTableProveedores()+"\n"+modelo.createTableSuministra());
		}
	});
	
	button2.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			log1.setText(log1.getText()+"\n"+modelo.insertTablePiezas()+"\n"+modelo.insertTableProveedores()+"\n"+modelo.insertTableSuministra());
		}
	});
	
	
	button3.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			menu.setVisible(false);
			menu_s.removeAll();
			menu_n.removeAll();
			menu_c.removeAll();
			text1.setText("MENU BORRAR:");
			menu_n.add(button7);
			menu_n.add(button8);
			menu_c.add(button9);
			menu_c.add(button10);
			menu_s.add(button11);		
			menu.setVisible(true);
		}
	});
	
	button4.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			menu.setVisible(false);
			menu_s.removeAll();
			menu_n.removeAll();
			menu_c.removeAll();
			text1.setText("MENU CRUD:");
			menu_n.add(button12);
			menu_n.add(button13);
			menu_c.add(button14);
			menu_c.add(button15);
			menu_s.add(button16);
			menu_s.add(button11);		
			menu.setVisible(true);
		}
	});
	
	button5.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			setVisible(false);
		}
	});
	
	button6.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			switch(option) {
			case "ADD":
				if(crudAdd == true) {
					switch(selec_tabla.getSelectedItem().toString()) {
					case "Piezas":
						modelo.insertPiezas(field1.getText());
						break;
					case "Proveedores":
						modelo.insertProveedores(field2.getText() ,field1.getText());
						break;
					case "Suministra":
						modelo.insertSuministra(field1.getText(), field2.getText(), field3.getText());
						break;
					}
					log1.setText(log1.getText()+ "\n-Registro añadido correctamente:"+vista.showTable(selec_tabla.getSelectedItem().toString(), modelo.getSt()));
				}
				break;
			case "REQ":
				if(crudRequest == true) {
					String data1, data2, data3;
					switch(selec_tabla.getSelectedItem().toString()) {
					case "Piezas":
						if(field1.getText().equalsIgnoreCase("")) {
							data1 = null;
						} else {
							data1 = field1.getText();
						}
						log1.setText(log1.getText()+ "\n-Registro encontrado:"+vista.showPiezas(modelo.search("Piezas", null,data1, null, null, null)));			
						break;
					case "Proveedores":
						if(field1.getText().equalsIgnoreCase("")) {
							data1 = null;
						} else {
							data1 = field1.getText();
						}
						if(field2.getText().equalsIgnoreCase("")) {
							data2 = null;
						} else {
							data2 = field2.getText();
						}
						//System.out.println(field2.getText()+"-"+field1.getText()+"/"+data1+data2);
						log1.setText(log1.getText()+ "\n-Registro encontrado:"+vista.showProveedores(modelo.search("Proveedores", data2, data1, null, null, null)));			
						break;
					case "Suministra":
						if(field1.getText().equalsIgnoreCase("")) {
							data1 = null;
						} else {
							data1 = field1.getText();
						}
						if(field2.getText().equalsIgnoreCase("")) {
							data2 = null;
						} else {
							data2 = field2.getText();
						}
						if(field3.getText().equalsIgnoreCase("")) {
							data3 = null;
						} else {
							data3 = field3.getText();
						}
						log1.setText(log1.getText()+ "\n-Registro encontrado:"+vista.showSuministra(modelo.search("Suministra", null, null, data1, data2, data3)));			
						break;
					}			
					}
				break;
			case "SHOW":
				if(crudShow == true) {
					switch(selec_tabla.getSelectedItem().toString()) {
					case "Piezas":
						log1.setText(log1.getText()+ "\n-Lista Piezas:"+vista.showTable(selec_tabla.getSelectedItem().toString(), modelo.getSt()));			
						break;
					case "Proveedores":
						log1.setText(log1.getText()+ "\n-Lista Proveedores:"+vista.showTable(selec_tabla.getSelectedItem().toString(), modelo.getSt()));			
						break;
					case "Suministra":
						log1.setText(log1.getText()+ "\n-Lista Suministra:"+vista.showTable(selec_tabla.getSelectedItem().toString(), modelo.getSt()));			
						break;
					}		
					}
				break;
			case "MOD":
				if(crudModify == true) {
					String data1 = null, data2 = null, data3 = null, dataMod1 = null, dataMod2 = null, dataMod3 = null;
					Boolean vacio1 = false, vacio2 = false;
					switch(selec_tabla.getSelectedItem().toString()) {
					case "Piezas":
						String[] dataListP=field1.getText().split("/");
						if(dataListP[0].equalsIgnoreCase("")) {
							data1 = null;
						} else {
							data1 = dataListP[0];
						}
						if(dataListP[1].equalsIgnoreCase("")) {
							dataMod1 = null;
						} else {
							dataMod1 = dataListP[1];
						}
						modelo.update("Piezas", null,data1, null, null, null,null,dataMod1,null,null,null);
						log1.setText(log1.getText()+ "\n-Registro modificado:"+vista.showTable("Piezas", modelo.getSt()));			
						break;
					case "Proveedores":
						if(!field1.getText().equalsIgnoreCase("")) {
							String[] dataListPR1=field1.getText().split("/");
							if(dataListPR1[0].equalsIgnoreCase("")) {
								data1 = null;
							} else {
								data1 = dataListPR1[0];
							}
							if(dataListPR1[1].equalsIgnoreCase("")) {
								dataMod1 = null;
							} else {
								dataMod1 = dataListPR1[1];
							}
						}
						if(!field2.getText().equalsIgnoreCase("")) {
							String[] dataListPR2=field2.getText().split("/");
							if(dataListPR2[0].equalsIgnoreCase("")) {
								data2 = null;
							} else {
								data2 = dataListPR2[0];
							}
							if(dataListPR2[1].equalsIgnoreCase("")) {
								dataMod2 = null;
							} else {
								dataMod2 = dataListPR2[1];
							}
						}	
						modelo.update("Proveedores", data2,data1, null , null, null,dataMod2,dataMod1,null,null,null);
						log1.setText(log1.getText()+ "\n-Registro modificado:"+vista.showTable("Proveedores", modelo.getSt()));
						break;
					case "Suministra":
						String[] dataListS3=field3.getText().split("/");
						if(field1.getText().equalsIgnoreCase("")) {
							data1 = null;
						} else {
							data1 = field1.getText();
						}
						if(field2.getText().equalsIgnoreCase("")) {
							data2 = null;
						} else {
							data2 = field2.getText();
						}
						if(dataListS3[0].equalsIgnoreCase("")) {
							data3 = null;
						} else {
							data3 = dataListS3[0];
						}
						if(dataListS3[1].equalsIgnoreCase("")) {
							dataMod3 = null;
						} else {
							dataMod3 = dataListS3[1];
						}
						modelo.update("Suministra", null, null, data1, data2, data3,null, null, null, null,dataMod3);
						log1.setText(log1.getText()+ "\n-Registro modificado:"+vista.showTable("Suministra", modelo.getSt()));					
						break;
					}			
					}
				break;
			case "DEL":
				String data1, data2, data3;
				if(crudDelete == true) {
					switch(selec_tabla.getSelectedItem().toString()) {
					case "Piezas":
						if(field1.getText().equalsIgnoreCase("")) {
							data1 = null;
						} else {
							data1 = field1.getText();
						}
						modelo.delete("Piezas", null,data1, null, null, null);
						log1.setText(log1.getText()+ "\n-Registro eliminado:"+vista.showTable("Piezas", modelo.getSt()));			
						break;
					case "Proveedores":
						if(field1.getText().equalsIgnoreCase("")) {
							data1 = null;
						} else {
							data1 = field1.getText();
						}
						if(field2.getText().equalsIgnoreCase("")) {
							data2 = null;
						} else {
							data2 = field2.getText();
						}
						modelo.delete("Proveedores", data2,data1, null, null, null);
						log1.setText(log1.getText()+ "\n-Registro eliminado:"+vista.showTable("Proveedores", modelo.getSt()));
						break;
					case "Suministra":
						if(field1.getText().equalsIgnoreCase("")) {
							data1 = null;
						} else {
							data1 = field1.getText();
						}
						if(field2.getText().equalsIgnoreCase("")) {
							data2 = null;
						} else {
							data2 = field2.getText();
						}
						if(field3.getText().equalsIgnoreCase("")) {
							data3 = null;
						} else {
							data3 = field3.getText();
						}
						modelo.delete("Suministra", null, null, data1, data2, data3);
						log1.setText(log1.getText()+ "\n-Registro eliminado:"+vista.showTable("Suministra", modelo.getSt()));
						break;
					}			
					}
				break;
			}
		}
	});
	
	button7.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			log1.setText(log1.getText()+"\n"+modelo.deleteTable("Piezas"));
		}
	});
	button8.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			log1.setText(log1.getText()+"\n"+modelo.deleteTable("Proveedores"));
		}
	});
	button9.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			log1.setText(log1.getText()+"\n"+modelo.deleteTable("Suministra"));
		}
	});
	button10.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			log1.setText(log1.getText()+"\n"+modelo.deleteTableAll());
		}
	});
	button11.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			menu.setVisible(false);
			menu_s.removeAll();
			menu_n.removeAll();
			menu_c.removeAll();
			text1.setText("MENU:");
			menu_n.add(button1);
			menu_n.add(button2);
			menu_c.add(button3);
			menu_c.add(button4);
			menu_s.add(button5);
			resetBool();
			menu.setVisible(true);
		}
	});

	button12.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			resetBool();
			crudAdd = true;
			option = "ADD";
			insertData.updateUI();
			log1.setText("-Has escogido la opcion: Añadir un registro");
		}
	});
	
	button13.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			resetBool();
			crudRequest = true;
			option = "REQ";
			log1.setText("-Has escogido la opcion: Consultar un registro");
		}
	});
	
	button14.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			resetBool();
			crudShow = true;
			option = "SHOW";
			log1.setText("-Has escogido la opcion: Lista una tabla");
		}
	});
	
	button15.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			resetBool();
			crudModify = true;
			option = "MOD";
			log1.setText("-Has escogido la opcion: Modificar un registro");
		}
	});
	
	button16.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			resetBool();
			crudDelete = true;
			option = "DEL";
			log1.setText("-Has escogido la opcion: Borrar un registro");
		}
	});
	
	
	menu.setLayout(new BorderLayout());
	menu_s.setLayout(new FlowLayout());
	menu_c.setLayout(new FlowLayout());
	menu_n.setLayout(new FlowLayout());
	menu1.setLayout(new FlowLayout());
	log.setLayout(new FlowLayout());
	insertData.setLayout(new BorderLayout());
	insertData_n.setLayout(new FlowLayout());
	insertData_c.setLayout(new BorderLayout());
	left.setLayout(new BorderLayout());
	right.setLayout(new BorderLayout());
	window.setLayout(new FlowLayout());
	data1.setLayout(new FlowLayout());
	data2.setLayout(new FlowLayout());
	data3.setLayout(new FlowLayout());
	menu_n.add(button1);
	menu_n.add(button2);
	menu_c.add(button3);
	menu_c.add(button4);
	menu_s.add(button5);
	menu1.add(vacio);
	menu1.add(text1);
	menu1.add(vacio);
	menu.add(menu_n, BorderLayout.NORTH);
	menu.add(menu_c, BorderLayout.CENTER);
	menu.add(menu_s, BorderLayout.SOUTH);
	
	insertData_n.add(text2);
	insertData_n.add(selec_tabla);
	insertData_n.add(vacio);
	
	data1.add(text3);
	data1.add(field1);
	
	
	insertData_c.add(data1, BorderLayout.NORTH);
	insertData_c.add(data2, BorderLayout.CENTER);
	insertData_c.add(data3, BorderLayout.SOUTH);
	insertData_s.add(button6);
	insertData.add(insertData_n, BorderLayout.NORTH);
	insertData.add(insertData_c, BorderLayout.CENTER);
	insertData.add(insertData_s, BorderLayout.SOUTH);
	
	
	left.add(menu1, BorderLayout.NORTH);
	left.add(menu, BorderLayout.CENTER);
	left.add(insertData, BorderLayout.SOUTH);
	right.add(vacio,BorderLayout.NORTH);
	right.add(log1,BorderLayout.CENTER);
	right.add(vacio,BorderLayout.SOUTH);
	window.add(left);
	window.add(right);
	
	
	
	this.add(window);
	
	// Ponemos la vista en true y declaramos la ultima opcion
	this.setDefaultCloseOperation(HIDE_ON_CLOSE);
	this.setVisible(true);
	}
	
	private static void resetBool() {
		crudAdd = false;
		crudRequest = false;
		crudShow = false;
		crudModify = false;
		crudDelete = false;
	}
	
	
	public static void main(String[] args) {
		new mainSwing();

	}
	
	
}
