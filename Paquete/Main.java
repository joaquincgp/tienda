package Paquete;

import javax.swing.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                TiendaInterfaz tiendaInterfaz = new TiendaInterfaz();
                tiendaInterfaz.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                tiendaInterfaz.setSize(300, 300);
                tiendaInterfaz.setVisible(true);
            }
        });
        Scanner sc = new Scanner(System.in);
        Tienda tienda = new Tienda();
        int opcion;
        do {
            System.out.println("1. Visualizar la informacion de los productos");
            System.out.println("2. Vender un producto");
            System.out.println("3. Abastecer la tienda con un producto");
            System.out.println("4. Cambiar un producto");
            System.out.println("5. Calcular estadisticas de ventas");
            System.out.println("Ingresa una opcion");
            opcion = sc.nextInt();
            switch (opcion){
                case 1:
                    System.out.println("---- Paquete.Producto 1 ---- "+"\n Nombre: "+tienda.darProducto1().darNombre()+"\n Tipo: "+tienda.darProducto1().darTipo()+"\n Valor unitario : "+tienda.darProducto1().darValorUnitario()+"\n Cantidad: "+tienda.darProducto1().darCantidadBodega()+ "\n Cantidad minima: "+tienda.darProducto1().darCantidadMinima()+"\n Unidades vendidas: "+tienda.darProducto1().darCantidadUnidadesVendidas());
                    System.out.println("---- Paquete.Producto 2 ---- "+"\n Nombre: "+tienda.darProducto2().darNombre()+"\n Tipo: "+tienda.darProducto2().darTipo()+"\n Valor unitario : "+tienda.darProducto2().darValorUnitario()+"\n Cantidad: "+tienda.darProducto2().darCantidadBodega()+ "\n Cantidad minima: "+tienda.darProducto2().darCantidadMinima()+"\n Unidades vendidas: "+tienda.darProducto2().darCantidadUnidadesVendidas());
                    System.out.println("---- Paquete.Producto 3 ---- "+"\n Nombre: "+tienda.darProducto3().darNombre()+"\n Tipo: "+tienda.darProducto3().darTipo()+"\n Valor unitario : "+tienda.darProducto3().darValorUnitario()+"\n Cantidad: "+tienda.darProducto3().darCantidadBodega()+ "\n Cantidad minima: "+tienda.darProducto3().darCantidadMinima()+"\n Unidades vendidas: "+tienda.darProducto3().darCantidadUnidadesVendidas());
                    System.out.println("---- Paquete.Producto 4 ---- "+"\n Nombre: "+tienda.darProducto4().darNombre()+"\n Tipo: "+tienda.darProducto4().darTipo()+"\n Valor unitario : "+tienda.darProducto4().darValorUnitario()+"\n Cantidad: "+tienda.darProducto4().darCantidadBodega()+ "\n Cantidad minima: "+tienda.darProducto4().darCantidadMinima()+"\n Unidades vendidas: "+tienda.darProducto4().darCantidadUnidadesVendidas());
                    break;
                case 2:
                    System.out.println("Que producto deseas vender?: ");
                    String pProducto = sc.next();
                    System.out.println("Que cantidad deseas vender?: ");
                    int pCantidad = sc.nextInt();
                    tienda.venderProducto(pProducto,pCantidad);
                    break;
                case 3:
                    System.out.println("Que producto desea abastecer?: ");
                    String pProducto2 = sc.next();
                    System.out.println("Cantidad a abastecer: ");
                    int pCantidad2 = sc.nextInt();
                    System.out.println("Se abastecio: "+tienda.abastecerProducto(pProducto2, pCantidad2));
                    break;
                case 4:
                    System.out.println("Que producto desea cambiar?: ");
                    String pProductoCambio = sc.next();
                    System.out.println("Con que producto desea cambiar: ");
                    String pProductoNuevo = sc.next();
                    System.out.println("De que tipo es el producto: ");
                    String pTipo = sc.next();
                    System.out.println("Ingrese el nuevo valor unitario: ");
                    int pValor = sc.nextInt();
                    System.out.println("Cantidad que desea ingresar: ");
                    int pCantidad3 = sc.nextInt();
                    System.out.println("Cantidad minima: ");
                    int pCantidadMinima = sc.nextInt();
                    System.out.println("Se cambio el producto: "+tienda.cambiarProducto(pProductoCambio, pProductoNuevo, Producto.Tipo.valueOf(pTipo),pValor,pCantidad3, pCantidadMinima));
                    break;
                case 5:
                    System.out.println("--- ESTADISTICAS ---");
                    System.out.println("1) El producto mas vendido.\n" +
                            "2)El producto menos vendido.\n" +
                            "3)La cantidad total de dinero obtenido por las ventas de la tienda.\n" +
                            "4)La cantidad de dinero promedio obtenido por unidad de producto vendida\n");
                    System.out.println("Ingrese una opcion: ");
                    int opcion5 = sc.nextInt();
                    switch (opcion5){
                        case 1:
                            System.out.println("El producto mas vendido es: "+tienda.darProductoMasVendido().darNombre());
                            break;
                        case 2:
                            System.out.println("El producto menos vendido es: "+tienda.darProductoMenosVendido());
                            break;
                        case 3:
                            System.out.println("Cantidad total de ventas: "+tienda.darDineroEnCaja());
                            break;
                        case 4:
                            System.out.println("Dinero promedio obtenido por unidad: "+tienda.darPromedioVentas());
                    }
            }

        } while (opcion != 6);
    }
}
