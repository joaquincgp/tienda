package Paquete;

import Paquete.Producto;

/**
 * Paquete.Tienda que maneja 4 productos.
 */
public class Tienda
{
    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * Paquete.Producto 1 de la tienda.
     */
    private Producto producto1;

    /**
     * Paquete.Producto 2 de la tienda.
     */
    private Producto producto2;

    /**
     * Paquete.Producto 3 de la tienda.
     */
    private Producto producto3;

    /**
     * Paquete.Producto 4 de la tienda.
     */
    private Producto producto4;

    /**
     * Dinero total recibido por las ventas.
     */
    private double dineroEnCaja;

    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------

    /**
     * Crea la tienda con sus 4 productos. <br>
     * <b> post: </b> El dinero en caja fue inicializado en 0.<br>
     * Los 4 productos fueron inicializados con los siguientes valores: <br>
     * Paquete.Producto 1 - Tipo: PAPELERIA, Nombre: L�piz, Valor unitario: 550.0, Cantidad en bodega: 18, Cantidad m�nima: 5 <br>
     * Paquete.Producto 2 - Tipo: DROGUERIA, Nombre: Aspirina, Valor unitario: 109.5, Cantidad en bodega: 25, Cantidad m�nima: 8 <br>
     * Paquete.Producto 3 - Tipo: PAPELERIA, Nombre: Borrador, Valor unitario: 207.3, Cantidad en bodega: 30, Cantidad m�nima: 10 <br>
     * Paquete.Producto 4 - Tipo: SUPERMERCADO, Nombre: Pan, Valor unitario: 150.0, Cantidad en bodega: 15, Cantidad m�nima: 20 <br>
     * 
     */
    public Tienda( )
    {
        producto1 = new Producto( Producto.Tipo.PAPELERIA, "Lapiz", 1.55, 18, 5);
        producto2 = new Producto( Producto.Tipo.DROGUERIA, "Aspirina", 2.5, 25, 8);
        producto3 = new Producto( Producto.Tipo.PAPELERIA, "Borrador", 1.3, 30, 10);
        producto4 = new Producto( Producto.Tipo.SUPERMERCADO, "Pan", 1.5, 15, 20);
        dineroEnCaja = 0;
    }

    // -----------------------------------------------------------------
    // M�todos
    // -----------------------------------------------------------------

    /**
     * Retorna el producto 1.
     * @return Paquete.Producto 1 de la tienda.
     */
    public Producto darProducto1( )
    {
        return producto1;
    }

    /**
     * Retorna el producto 2.
     * @return Paquete.Producto 2 de la tienda.
     */
    public Producto darProducto2( )
    {
        return producto2;
    }

    /**
     * Retorna el producto 3.
     * @return Paquete.Producto 3 de la tienda.
     */
    public Producto darProducto3( )
    {
        return producto3;
    }

    /**
     * Retorna el producto 4.
     * @return Paquete.Producto 4 de la tienda.
     */
    public Producto darProducto4( )
    {
        return producto4;
    }

    /**
     * Retorna el dinero en caja.
     * @return Dinero en caja.
     */
    public double darDineroEnCaja( )
    {
        return dineroEnCaja;
    }

    /**
     * Retorna el producto con el nombre dado por par�metro.
     * @param pNombre Nombre del producto buscado. pNombre != null && pNombre != "".
     * @return Paquete.Producto con el nombre dado por par�metro, null si no lo encuentra.
     */
    public Producto darProducto( String pNombre )
    {
        Producto buscado = null;

        if( producto1.darNombre( ).equals( pNombre ) )
        {
            buscado = producto1;
        }
        else if( producto2.darNombre( ).equals( pNombre ) )
        {
            buscado = producto2;
        }
        else if( producto3.darNombre( ).equals( pNombre ) )
        {
            buscado = producto3;
        }
        else if( producto4.darNombre( ).equals( pNombre ) )
        {
            buscado = producto4;
        }

        return buscado;

    }

    /**
     * Retorna el promedio de las ventas.
     * @return Dinero promedio obtenido por unidad de producto vendida.
     */
    public double darPromedioVentas( )
    {
        double respuesta = 0.0;
        double totalUnidadesVendidas = producto1.darCantidadUnidadesVendidas( ) + producto2.darCantidadUnidadesVendidas( ) + producto3.darCantidadUnidadesVendidas( ) + producto4.darCantidadUnidadesVendidas( );
        if( totalUnidadesVendidas > 0 )
        {
            respuesta = dineroEnCaja / totalUnidadesVendidas;
        }
        return respuesta;
    }

    /**
     * Retorna el producto con m�s unidades vendidas.
     * @return Paquete.Producto con m�s unidades vendidas. Null si ning�n producto tiene unidades vendidas.
     */
    public Producto darProductoMasVendido( )
    {
        int venta1 = producto1.darCantidadUnidadesVendidas( );
        int venta2 = producto2.darCantidadUnidadesVendidas( );
        int venta3 = producto3.darCantidadUnidadesVendidas( );
        int venta4 = producto4.darCantidadUnidadesVendidas( );

        Producto masVendido = null;
        int mayorCantidad = 0;

        if( venta1 > mayorCantidad )
        {
            masVendido = producto1;
            mayorCantidad = venta1;
        }
        if( venta2 > mayorCantidad )
        {
            masVendido = producto2;
            mayorCantidad = venta2;
        }
        if( venta3 > mayorCantidad )
        {
            masVendido = producto3;
            mayorCantidad = venta3;
        }
        if( venta4 > mayorCantidad )
        {
            masVendido = producto4;
        }

        return masVendido;
    }

    /**
     * Retorna el producto con menos unidades vendidas.
     * @return Paquete.Producto con menos unidades vendidas. Null si ning�n producto tiene unidades vendidas.
     */
    public Producto darProductoMenosVendido( )
    {
        int venta1 = producto1.darCantidadUnidadesVendidas( );
        int venta2 = producto2.darCantidadUnidadesVendidas( );
        int venta3 = producto3.darCantidadUnidadesVendidas( );
        int venta4 = producto4.darCantidadUnidadesVendidas( );

        Producto menosVendido = null;

        if( venta1 > 0 || venta2 > 0 || venta3 > 0 || venta4 > 0 )
        {
            if( venta1 <= venta2 && venta1 <= venta3 && venta1 <= venta4 )
            {
                menosVendido = producto1;
            }
            else if( venta2 <= venta1 && venta2 <= venta3 && venta2 <= venta4 )
            {
                menosVendido = producto2;
            }
            else if( venta3 <= venta2 && venta3 <= venta1 && venta3 <= venta4 )
            {
                menosVendido = producto3;
            }
            else
            {
                menosVendido = producto4;
            }
        }

        return menosVendido;
    }

    /**
     * Vende una cantidad de unidades de producto de la tienda, dado su nombre por par�metro. <br>
     * <b>post: </b> Disminuy� la cantidad de unidades del producto dado y se actualiz� el dinero de la caja.
     * @param pNombreProducto Nombre del producto a vender. npNombreProducto != null && pNombreProducto != "".
     * @param pCantidad Cantidad de unidades del producto a vender. pCantidad > 0.
     * @return Cantidad que fue efectivamente vendida.
     */

    public int venderProducto( String pNombreProducto, int pCantidad )
    {
        int cantidadVendida = 0;
        Producto producto = darProducto( pNombreProducto );
        cantidadVendida = producto.vender( pCantidad );
        dineroEnCaja += cantidadVendida * producto.calcularPrecioFinal( );

        return cantidadVendida;
    }

    /**
     * Abastece un producto dado su nombre, con la cantidad de unidades dadas. <br>
     * <b>post: </b> Aument� la cantidad de unidades en bodega del producto dado.
     * @param pNombreProducto Nombre del producto a abastecer. pNombreProducto != null && pNombreProducto != "".
     * @param pCantidad La cantidad de unidades a abastecer. cantidad >= 0.
     * @return Retorna true si se pudo efectuar el abastecimiento, false en caso contrario.
     */
    public boolean abastecerProducto( String pNombreProducto, int pCantidad )
    {
        boolean abastece = false;
        Producto producto = darProducto( pNombreProducto );

        if( producto.puedeAbastecer( ) )
        {
            producto.abastecer( pCantidad );
            abastece = true;
        }

        return abastece;
    }

    /**
     * Cambia el producto que tiene el nombre actual con los nuevos valores dados por par�metro. <br>
     * <b>post: </b> El nombre, tipo, valor unitario, cantidad en bodega y cantidad m�nima fueron cambiados con los valores dados por par�metro.
     * @param pNombreActual Nombre actual del producto. pNombreActual != null && pNombreActual != "".
     * @param pNombreNuevo Nuevo nombre del producto. pNombreNuevo != null && pNombreNuevo != "".
     * @param pTipo Tipo del producto. pTipo != null.
     * @param pValorUnitario Valor unitario del producto
     * @param pCantidadBodega Cantidad en bodega del producto. pCantidadBodega >= 0.
     * @param pCantidadMinima Cantidad m�nima en bodega para hacer un pedido del producto. pCantidadMinima > 0.
    
     * @return Retorna true si cambi� la informaci�n del producto, false si ya exist�a un producto diferente con el nuevo nombre.
     */
    public boolean cambiarProducto(String pNombreActual, String pNombreNuevo, Producto.Tipo pTipo, double pValorUnitario, int pCantidadBodega, int pCantidadMinima )
    {
        boolean cambio = false;
        if( pNombreActual.equals( pNombreNuevo ) || darProducto( pNombreNuevo ) == null )
        {

            if( producto1.darNombre( ).equals( pNombreActual ) )
            {
                producto1 = new Producto( pTipo, pNombreNuevo, pValorUnitario, pCantidadBodega, pCantidadMinima );
            }
            else if( producto2.darNombre( ).equals( pNombreActual ) )
            {
                producto2 = new Producto( pTipo, pNombreNuevo, pValorUnitario, pCantidadBodega, pCantidadMinima);
            }
            else if( producto3.darNombre( ).equals( pNombreActual ) )
            {
                producto3 = new Producto( pTipo, pNombreNuevo, pValorUnitario, pCantidadBodega, pCantidadMinima );
            }
            else if( producto4.darNombre( ).equals( pNombreActual ) )
            {
                producto4 = new Producto( pTipo, pNombreNuevo, pValorUnitario, pCantidadBodega, pCantidadMinima);
            }
            cambio = true;
        }
        return cambio;
    }

    // -----------------------------------------------------------------
    // Puntos de Extensi�n
    // -----------------------------------------------------------------

    /**
     * M�todo para la extensi�n 1.
     * @return Respuesta 1.
     */
    public String metodo1( )
    {
        return "Respuesta 1";
    }

    /**
     * M�todo para la extensi�n 2.
     * @return Respuesta 2.
     */
    public String metodo2( )
    {
        return "Respuesta 2";
    }
}