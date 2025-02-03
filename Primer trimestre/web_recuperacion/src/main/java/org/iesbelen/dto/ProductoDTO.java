package org.iesbelen.dto;

import org.iesbelen.model.Producto;

public class ProductoDTO extends Producto {

    private String nombreCategoria;

    public ProductoDTO(int idprod, int idcat, String nombre, double precio, int stock, String nombreCategoria) {
        this.setIdProd(idprod);
        this.setIdCat(idcat);
        this.setNombre(nombre);
        this.setPrecio(precio);
        this.setStock(stock);
        this.nombreCategoria = nombreCategoria;
    }

    public ProductoDTO(Producto producto, String nombreCategoria) {
        this.setIdProd(producto.getIdProd());
        this.setIdCat(producto.getIdCat());
        this.setNombre(producto.getNombre());
        this.nombreCategoria = nombreCategoria;
        this.setPrecio(producto.getPrecio());
        this.setStock(producto.getStock());

    }

    public String getNombreCategoria() {
        return nombreCategoria;
    }

    public void setNombreCategoria(String nombreCategoria) {
        this.nombreCategoria = nombreCategoria;
    }
}
