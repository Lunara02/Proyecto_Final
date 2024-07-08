package proyecto;
/**
 * La enumeración Ingredientes representa los ingredientes disponibles en el juego, con su tipo y nombre.
 */
public enum Ingredientes {
    MASA("pizza", "masa"),

    PEPERONI("pizza", "peperonni"),
    ACEITUNAS("pizza", "aceitunas"),
    CHAMPIÑONES("pizza", "champiñones"),
    PIMIENTOS("pizza", "pimientos"),
    ALBAHACA("pizza", "albahaca"),
    SALSA("pizza", "salsatomate"),
    BLANCA("pizza", "salsablanca"),

    PAN_ARRIBA("hamburguesa", "panArr"),
    PAN_ABAJO("hamburguesa", "panAbj"),
    TOMATE("hamburguesa", "tom"),
    LECHUGA("hamburguesa", "lech"),
    HAMBURGUESA("hamburguesa", "borga"),
    PALTA("hamburguesa", "palto"),
    MAYO("hamburguesa", "mayo"),
    KETCHUP("hamburguesa", "kechu");

    private String tipo;
    private String nombre;
    /**
     * Constructor para un ingrediente específico.
     *
     * @param tipo   El tipo de comida al que pertenece el ingrediente (e.g., "pizza", "hamburguesa").
     * @param nombre El nombre del ingrediente.
     */
    Ingredientes(String tipo, String nombre) {
        this.tipo = tipo;
        this.nombre = nombre;
    }
    /**
     * Obtiene el nombre del ingrediente.
     *
     * @return El nombre del ingrediente.
     */
    public String getNombre() {
        return this.nombre;
    }

    /**
     * Devuelve una representación en cadena del ingrediente, combinando su tipo y su nombre.
     *
     * @return Una cadena representando el tipo y nombre del ingrediente.
     */
    public String toString() {
        return this.tipo + " " + this.nombre;
    }
}
