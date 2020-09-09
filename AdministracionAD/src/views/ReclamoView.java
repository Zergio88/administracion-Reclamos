package views;

import java.io.Serializable;

public class ReclamoView implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int id_reclamo;
	private String documento;
	private int codigo;
	private String ubicacion;
	private String descripcion;
	private int identificador;
	
	public ReclamoView(int id_reclamo, String documento, int codigo, String ubicacion, String descripcion, int identificador) {
		this.id_reclamo = id_reclamo;
		this.documento = documento;
		this.codigo = codigo;
		this.ubicacion = ubicacion;
		this.descripcion = descripcion;
		this.identificador = identificador;
	}
	
	public ReclamoView() {}

	public int getId_reclamo() {
		return id_reclamo;
	}

	public void setId_reclamo(int id_reclamo) {
		this.id_reclamo = id_reclamo;
	}

	public String getDocumento() {
		return documento;
	}

	public void setDocumento(String documento) {
		this.documento = documento;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getUbicacion() {
		return ubicacion;
	}

	public void setUbicacion(String ubicacion) {
		this.ubicacion = ubicacion;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public int getIdentificador() {
		return identificador;
	}

	public void setIdentificador(int identificador) {
		this.identificador = identificador;
	}

	@Override
	public String toString() {
		return id_reclamo + " " + documento + " " + codigo + " " + ubicacion + " " + descripcion + " " + identificador;
	}
	
}
