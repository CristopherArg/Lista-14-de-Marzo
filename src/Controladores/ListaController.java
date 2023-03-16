/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controladores;

import Modelos.Clientes;
import Modelos.ListaModel;
import Vistas.frmListas;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Queue;

/**
 *
 * @author CRIS
 */
public class ListaController implements ActionListener{
    frmListas VstaLista;
    ListaModel ModeloLista;

    public ListaController(frmListas VstaLista, ListaModel ModeloLista) {
        this.VstaLista = VstaLista;
        this.ModeloLista = ModeloLista;
        
        //PONER A LA ESCUCHA LOS BOTONES 
        this.VstaLista.btnAtenderCliente.addActionListener(this);
        this.VstaLista.btnAtenderTodos.addActionListener(this);
        this.VstaLista.btnIngresarCliente.addActionListener(this);
        
        //LEVANTAR LA VISTA LISTA
        this.VstaLista.setLocationRelativeTo(null);
        this.VstaLista.setVisible(true);
        
    }
    
  
    @Override
    public void actionPerformed(ActionEvent e){
        if(e.getSource()==this.VstaLista.btnIngresarCliente){
            this.ModeloLista.EncolarCliente(this.VstaLista.txtApellidos.getText(), 
                    this.VstaLista.txtNombre.getText());
            
            //TRAE LA LISTA CLIENTES DESDE EL MODELO
            Queue <Clientes> listaLocal = this.ModeloLista.ListarClientes();
            
            //RECORRE LA LISTA Y ASIGNA EL TEXT AREA 
            String Cadena = "";
            for(Clientes MiListaClientes: listaLocal){
                Cadena = Cadena + MiListaClientes.getApellidos()+" "+MiListaClientes.getNombre()+"\n";
                this.VstaLista.txtListaClientes.setText(Cadena);
            }
            
            
            
            
           
        }
        
    }
}
