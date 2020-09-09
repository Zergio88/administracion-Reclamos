package modelo;

import java.io.Serializable;

import daos.ReclamoDAO;
import views.ReclamoView;

public class Reclamo implements Serializable {

	private int id_reclamo;
	private String documento;
	private int codigo;
	private String ubicacion;
	private String descripcion;
	private int identificador;
	
	
	public Reclamo(int id_reclamo, String documento, int codigo, String ubicacion, String descripcion, int identificador) {
		this.id_reclamo = id_reclamo;
		this.documento = documento;
		this.codigo = codigo;
		this.ubicacion = ubicacion;
		this.descripcion = descripcion;
		this.identificador = identificador;		
	}
	
	public void GrabarReclamo() {
		ReclamoDAO.getInstancia().GrabarReclamo(this);  
		
	}
	
	public ReclamoView toView() {
		return new ReclamoView(id_reclamo, documento, codigo, ubicacion, descripcion, identificador);
	}

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

	public void setId(Integer id) {
		// TODO Auto-generated method stub
		this.id_reclamo = id;
	}
	
}
