package proyecto;

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
    Ingredientes(String tipo, String nombre) {
        this.tipo = tipo;
        this.nombre = nombre;
    }

    public String getNombre() {
        return this.nombre;
    }

    public String toString() {
        return this.tipo + " " + this.nombre;
    }
}
