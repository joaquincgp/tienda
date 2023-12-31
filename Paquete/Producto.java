package Paquete;

/**
 * Paquete.Producto de la tienda.
 */
public class Producto
{
    // -----------------------------------------------------------------
    // Enumeraciones
    // -----------------------------------------------------------------

    /**
     * Enumeradores para los tipos de producto.
     */
    public enum Tipo
    {
        /**
         * Representa el tipo papeler�a.
         */
        PAPELERIA,

        /**
         * Representa el tipo supermercado.
         */
        SUPERMERCADO,

        /**
         * Representa el tipo droguer�a.
         */
        DROGUERIA,

        /**
         * Representa el tipo textil
         */
        TEXTIL
    }

    // -----------------------------------------------------------------
    // Constantes
    // -----------------------------------------------------------------


    /**
     * Representa el impuesto asociado al tipo PAPELERIA.
     */
    private final static double IVA_PAPELERIA = 0.16;

    /**
     * Representa el impuesto asociado al tipo SUPERMERCADO.
     */
    private final static double IVA_SUPERMERCADO = 0.04;

    /**
     * Representa el impuesto asociado al tipo DROGUERIA.
     */
    private final static double IVA_DROGUERIA = 0.12;

    /**
     * Representa el impuesto asociado al tipo TEXTIL
     */
    private final static double IVA_TEXTIL = 0.1;
    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * Nombre del producto.
     */
    private String nombre;

    /**
     * Tipo del producto.
     */
    private Tipo tipo;

    /**
     * Valor unitario del producto.
     */
    private double valorUnitario;

    /**
     * Cantidad de unidades en la bodega del producto.
     */
    private int cantidadBodega;

    /**
     * Cantidad de unidades m�nima que debe haber en bodega para poder hacer un pedido.
     */
    private int cantidadMinima;

    /**
     * Cantidad de unidades vendidas del producto.
     */
    private int cantidadUnidadesVendidas;

    

    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------

    /**
     * Crea un producto con los valores dados por par�metro. <br>
     * <b> post: </b> El tipo, nombre, valor unitario, cantidad en bodega, cantidad m�nima y ruta imagen fueron inicializados con los valores dado por par�metro.
     * @param pTipo Tipo del producto. pTipo != null.
     * @param pNombre Nombre del producto. pNombre != null && pNombre != "".
     * @param pValorUnitario Valor unitario del producto. pValorUnitario >= 0.
     * @param pCantidadBodega Cantidad inicial en la bodega. pCantidadBodega >= 0.
     * @param pCantidadMinima Cantidad m�nima que debe haber en bodega. pCantidadMinima >= 0.
     */
    public Producto( Tipo pTipo, String pNombre, double pValorUnitario, int pCantidadBodega, int pCantidadMinima)
    {
        tipo = pTipo;
        nombre = pNombre;
        valorUnitario = pValorUnitario;
        cantidadBodega = pCantidadBodega;
        cantidadMinima = pCantidadMinima;
        cantidadUnidadesVendidas = 0;
    }

    // -----------------------------------------------------------------
    // M�todos
    // -----------------------------------------------------------------

    /**
     * Retorna el nombre del producto.
     * @return Nombre del producto.
     */
    public String darNombre( )
    {
        return nombre;
    }

    /**
     * Retorna el tipo del producto.
     * @return Tipo de producto.
     */
    public Tipo darTipo( )
    {
        return tipo;
    }

    /**
     * Retorna el valor unitario del producto.
     * @return Valor unitario del producto.
     */
    public double darValorUnitario( )
    {
        return valorUnitario;
    }

    /**
     * Retorna la cantidad en bodega del producto.
     * @return Cantidad en bodega del producto.
     */
    public int darCantidadBodega( )
    {
        return cantidadBodega;
    }

    /**
     * Retorna la cantidad m�nima del producto.
     * @return Cantidad m�nima del producto.
     */
    public int darCantidadMinima( )
    {
        return cantidadMinima;
    }

    /**
     * Retorna la cantidad total de unidades vendidas.
     * @return Cantidad de unidades vendidas.
     */
    public int darCantidadUnidadesVendidas( )
    {
        return cantidadUnidadesVendidas;
    }

  

    /**
     * Calcula el valor final del producto, incluyendo los impuestos.
     * @return Precio de venta de una unidad incluyendo el IVA.
     */
    public double calcularPrecioFinal( )
    {

        return valorUnitario + valorUnitario * darIVA( );
    }

    /**
     * Retorna el IVA correspondiente al producto.
     * @return IVA.
     */
    public double darIVA( )
    {
        double iva = 0;
        switch( tipo )
        {
            case PAPELERIA:
            {
                iva = IVA_PAPELERIA;
                break;
            }
            case SUPERMERCADO:
            {
                iva = IVA_SUPERMERCADO;
                break;
            }
            case DROGUERIA:
            {
                iva = IVA_DROGUERIA;
                break;
            }
            case TEXTIL:
            {
                iva = IVA_TEXTIL;
                break;
            }
        }

        return iva;
    }

    /**
     * Vende la cantidad de unidades dada por par�metro. <br>
     * <b>post: </b> Disminuye la cantidad de unidades en bodega del producto.
     * @param pCantidad Cantidad de unidades a vender. pCantidad > 0.
     * @return Cantidad que realmente fue vendida, seg�n la disponibilidad en la bodega.
     */
    public int vender( int pCantidad )
    {
        int cantidadVendida = 0;

        if( pCantidad > cantidadBodega )
        {
            cantidadVendida = cantidadBodega;
            cantidadBodega = 0;
        }
        else
        {
            cantidadBodega -= pCantidad;
            cantidadVendida = pCantidad;
        }

        cantidadUnidadesVendidas += cantidadVendida;

        return cantidadVendida;
    }

    /**
     * Abastece la cantidad de unidades dada por par�metro. <br>
     * <b>post: </b> Aumenta la cantidad de unidades en bodega del producto.
     * @param pCantidad Cantidad de unidades para abastecer. pCantidad >= 0.
     */
    public void abastecer( int pCantidad )
    {
        cantidadBodega += pCantidad;
    }

    /**
     * Indica si se puede abastecer las unidades del producto.
     * @return True si la cantidad en la bodega es menor que la m�nima, false en caso contrario.
     */
    public boolean puedeAbastecer( )
    {
        boolean respuesta = false;
        if( cantidadBodega < cantidadMinima )
        {
            respuesta = true;
        }
        return respuesta;
    }
}