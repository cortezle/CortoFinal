/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import Modelo.Producto;
import Products.Products;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.JLabel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author LN710Q
 */
public class Graph extends JFrame {
    public JLabel lblId , lblNombre , lblCantidad , lblExistencia, lblprecio,lbltipo;
    public JTextField codigo,precio,cantidad, nombre,disponibilidad;
    public JComboBox tipo;
    ButtonGroup existencia = new ButtonGroup();
    public JRadioButton no,si;
    public JTable resultados;
    public JPanel table;
    public JButton buscar, eliminar, insertar,limpiar,actualizar;
    private static final int ANCHOC = 130, ALTOC = 30;
        
    DefaultTableModel tm;

        public Graph(){
        super ("CortoDePoo");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        agregarLabels();
        formulario();
        llenarTabla();
        Container container = getContentPane();
        container.add(lblId);
        container.add(lblNombre);
        container.add(lblCantidad);
        container.add(lblExistencia);
        container.add(codigo);
        container.add(nombre);
        container.add(precio);
        container.add(cantidad);
        container.add(nombre);
        container.add(disponibilidad);
        container.add(si);
        container.add(no);
        container.add(buscar);
        container.add(insertar);
        container.add(actualizar);
        container.add(eliminar);
        container.add(limpiar);
        container.add(table);
        setSize(600,600);
        eventos();

    }
            public final void agregarLabels(){
        lblId = new JLabel("Id");
        lblNombre = new JLabel("Nombre");
        lblCantidad = new JLabel("Cantidad");
        lblExistencia = new JLabel("Existencia");
        lblprecio = new JLabel("Precio");
        lbltipo = new JLabel("Tipo");
        lblId.setBounds(10,10,ANCHOC,ALTOC);
        lblNombre.setBounds(10,60,ANCHOC,ALTOC);
        lblCantidad.setBounds(10,100,ANCHOC,ALTOC);
        lblExistencia.setBounds(10,140,ANCHOC,ALTOC);
        lblprecio.setBounds(10,180,ANCHOC,ALTOC);
        lbltipo.setBounds(10,220,ANCHOC,ALTOC);
    }
    public final void formulario(){
        codigo= new JTextField();
        tipo= new JComboBox();
        disponibilidad = new JTextField();
        si = new JRadioButton ("si",true);
        no = new JRadioButton ("no");
        resultados = new JTable();
        buscar = new JButton("Buscar");
        insertar = new JButton ("Insertar");
        eliminar = new JButton ("Eliminar");
        actualizar = new JButton ("Actualizar");
        limpiar = new JButton ("Limpiar");
        table =new JPanel();
        tipo.addItem("Fruta");
        tipo.addItem("Bebida");
        tipo.addItem("Dulce ");
        tipo.addItem("Verdura");
        existencia= new ButtonGroup();
        existencia.add(si);
        existencia.add(no);
        codigo.setBounds(140, 10, ANCHOC,ALTOC);
        nombre.setBounds(140,60, ANCHOC,ALTOC);
        disponibilidad.setBounds(140,100, ANCHOC,ALTOC);
        si.setBounds(140,140,50,ALTOC);
        no.setBounds(210,140,50,ALTOC);
        buscar.setBounds(300,10,ANCHOC,ALTOC);
        insertar.setBounds(10,210,ANCHOC,ALTOC);
        actualizar.setBounds(150,210,ANCHOC,ALTOC);
        eliminar.setBounds(300,210,ANCHOC,ALTOC);
        limpiar.setBounds(450,210,ANCHOC,ALTOC);
        resultados = new JTable();
        table.setBounds(10,250,500,200);
        table.add(new JScrollPane (resultados));

    }
            public void llenarTabla(){
        tm = new DefaultTableModel(){
            public Class<?> getColumnClass (int column){
                switch(column){
                    case 0:
                        return String.class;
                    case 2:
                        return String.class;
                    case 3:
                        return String.class;
                    default:
                        return Boolean.class;
                }
            }
        };
        tm.addColumn("Codigo");
        tm.addColumn("Nomre");
        tm.addColumn("Tipo");
        tm.addColumn("Disponibilidad");
        tm.addColumn("Precio");
        tm.addColumn("Cantidad");
        
        Products fd = new Products();
        ArrayList<Producto> filtros = fd.readAll();
        
        for (Producto fi: filtros){
            tm.addRow(new Object[]{fi.getId(),fi.getNombre(),fi.getPrecio(),fi.getTipo(),fi.getDisponibilidad(),fi.getCantidad()});
        }
        resultados.setModel(tm);
    }
    
    public void eventos(){
        
        
        
        insertar.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                Products fd = new Products();
                Producto f = new Producto(Integer.parseInt(codigo.getText()),nombre.getText(),tipo.getSelectedItem().toString(),Float.parseFloat(precio.getText()),Integer.parseInt(cantidad.getText()),true);
                if(no.isSelected()){
                    f.setDisponibilidad(false);
                }
                if(fd.create(f)){
                    JOptionPane.showMessageDialog(null, "Producto registrado con exito");
                    limpiarCampos();
                    llenarTabla();
                    
                }else{
                    JOptionPane.showMessageDialog(null, "ocurrio un problema al momento de crear el Producto ");
                }
            }


        });
        
                actualizar.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                Products fd = new Products();
                Producto f = new Producto(Integer.parseInt(codigo.getText()),nombre.getText(),tipo.getSelectedItem().toString(),Float.parseFloat(precio.getText()),Integer.parseInt(cantidad.getText()),true);
                if(no.isSelected()){
                    f.setDisponibilidad(false);
                }
                if(fd.create(f)){
                    JOptionPane.showMessageDialog(null, "Producto modificado con exito");
                    limpiarCampos();
                    llenarTabla();
                    
                }else{
                    JOptionPane.showMessageDialog(null, "ocurrio un problema al momento de modificar el Producto ");
                }
            }


        });
                
                eliminar.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                Products fd = new Products();
                if(fd.delete(codigo.getText())){
                    JOptionPane.showMessageDialog(null, "Producto registrado con exito");
                    limpiarCampos();
                    llenarTabla();
                }else{
                    JOptionPane.showMessageDialog(null,"ocurrio un problema la momento de eliminar el Producto ");
                }
                

    }});
                
            buscar.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                Products fd = new Products();
                Producto f = new Producto();
                if(f==null){
                    JOptionPane.showMessageDialog(null, "Producto buscado no se encuentra");
                } else{
                    codigo.setText(Integer.toString(f.getId()));
                    tipo.setSelectedItem(f.getNombre());
                    cantidad.setText(Integer.toString(f.getCantidad()));
                    if(f.getDisponibilidad()){
                        si.setSelected(true);
                    } else {
                        no.setSelected(true);
                    }
                }
   
            }});
                            
            limpiar.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                limpiarCampos();
            }
            });
    }
    public void limpiarCampos(){
        codigo.setText("");
        tipo.setSelectedItem("FRAM");
        disponibilidad.setText("");
    }
    
    public static void main(String[] args){
    java.awt.EventQueue.invokeLater(new Runnable(){
    @Override
    public void run(){
    new Graph().setVisible(true);
    }
    
    });
    }

}
