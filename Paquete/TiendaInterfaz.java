package Paquete;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TiendaInterfaz extends JFrame{
    Tienda tienda2 = new Tienda();
    private JPanel ventana;
    private JButton verProductos;
    private JLabel opcion1;
    private JLabel opcion2;
    private JLabel opcion3;
    private JLabel opcion4;
    private JLabel opcion5;
    private JButton venderProducto;
    private JButton abastecer;
    private JButton cambiarProducto;
    private JButton calcularVentas;
    private JTextArea outputArea;
    private JButton borrarButton;


    /*//
    Constructor de la interfaz para definir parametros
     */
    public TiendaInterfaz(){
        setContentPane(ventana);
        verProductos.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                outputArea.setText("---- Producto 1 ----\n" + "Nombre: " + tienda2.darProducto1().darNombre() + "\n" +
                        "Tipo: " + tienda2.darProducto1().darTipo() + "\n" +
                        "Valor unitario: " + tienda2.darProducto1().darValorUnitario() + "\n" +
                        "Cantidad: " + tienda2.darProducto1().darCantidadBodega() + "\n" +
                        "Cantidad mínima: " + tienda2.darProducto1().darCantidadMinima() + "\n" +
                        "Unidades vendidas: " + tienda2.darProducto1().darCantidadUnidadesVendidas() + "\n\n" +
                        "---- Producto 2 ----\n" +
                        "Nombre: " + tienda2.darProducto2().darNombre() + "\n" +
                        "Tipo: " + tienda2.darProducto2().darTipo() + "\n" +
                        "Valor unitario: " + tienda2.darProducto2().darValorUnitario() + "\n" +
                        "Cantidad: " + tienda2.darProducto2().darCantidadBodega() + "\n" +
                        "Cantidad mínima: " + tienda2.darProducto2().darCantidadMinima() + "\n" +
                        "Unidades vendidas: " + tienda2.darProducto2().darCantidadUnidadesVendidas() + "\n\n" +
                        "---- Producto 3 ----\n"+  "Nombre: " + tienda2.darProducto3().darNombre() + "\n" +
                        "Tipo: " + tienda2.darProducto3().darTipo() + "\n" +
                        "Valor unitario: " + tienda2.darProducto3().darValorUnitario() + "\n" +
                        "Cantidad: " + tienda2.darProducto3().darCantidadBodega() + "\n" +
                        "Cantidad mínima: " + tienda2.darProducto3().darCantidadMinima() + "\n" +
                        "Unidades vendidas: " + tienda2.darProducto3().darCantidadUnidadesVendidas() + "\n\n" +
                        "---- Producto 4 ----\n" +
                        "Nombre: " + tienda2.darProducto4().darNombre() + "\n" +
                        "Tipo: " + tienda2.darProducto4().darTipo() + "\n" +
                        "Valor unitario: " + tienda2.darProducto4().darValorUnitario() + "\n" +
                        "Cantidad: " + tienda2.darProducto4().darCantidadBodega() + "\n" +
                        "Cantidad mínima: " + tienda2.darProducto4().darCantidadMinima() + "\n" +
                        "Unidades vendidas: " + tienda2.darProducto4().darCantidadUnidadesVendidas());
            }

        });

        venderProducto.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                    String producto = JOptionPane.showInputDialog("Ingrese el nombre del producto a vender:");
                    int cantidad = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la cantidad a vender:"));
                    tienda2.venderProducto(producto, cantidad);
                    JOptionPane.showMessageDialog(null, "Producto vendido exitosamente.");
                }

        });


        abastecer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                    String producto = JOptionPane.showInputDialog("Ingrese el nombre del producto a abastecer:");
                    int cantidad = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la cantidad a abastecer:"));
                    boolean abastecido = tienda2.abastecerProducto(producto, cantidad);
                    if (abastecido) {
                        JOptionPane.showMessageDialog(null, "Producto abastecido exitosamente.");
                    } else {
                        JOptionPane.showMessageDialog(null, "No se pudo abastecer el producto. Verifique los datos.");
                    }
                }

        });
    }

}
