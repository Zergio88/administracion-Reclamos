package daos;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.classic.Session;

import entities.DuenioEntity;
import entities.EdificioEntity;
import entities.PersonaEntity;
import entities.ReclamoEntity;
import exceptions.PersonaException;
import exceptions.ReclamoException;
import hibernate.HibernateUtil;
import modelo.Persona;
import modelo.Reclamo;

public class ReclamoDAO {
	
	private static ReclamoDAO instancia;
	
	private ReclamoDAO() {}
	
	public static ReclamoDAO getInstancia() {
		if(instancia == null)
			instancia = new ReclamoDAO();
		return instancia;
	}
	
	public void GrabarReclamo(Reclamo reclamo) {
		
		ReclamoEntity rec = toEntity(reclamo);
		
		int resultado = -1; // lo seteo en -1
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session s = sf.getCurrentSession();
		s.beginTransaction();
		s.save(rec); // La session obtiene el id del objeto que se creo y lo guardda
		reclamo.setId(rec.getId());
		s.getTransaction().commit();
	} 
	
	public Reclamo getReclamo(int id_reclamo) throws ReclamoException {
		Reclamo resultado;
		
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session s = sf.getCurrentSession();
		s.beginTransaction();
		
		ReclamoEntity reclamo = (ReclamoEntity) s.createQuery("from ReclamoEntity re where re.idReclamo = ?").setInteger(0, id_reclamo).uniqueResult();
		s.getTransaction().commit();
		if(reclamo != null) {
			resultado = ReclamoDAO.getInstancia().toNegocio(reclamo);
			
			return resultado;
		}
		else {
			throw new ReclamoException("No se pudo recuperar reclamo");
		}
	}

	
	public List<Reclamo> getReclamos() {
		List<Reclamo> resultado = new ArrayList<Reclamo>();
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session s = sf.getCurrentSession();
		s.beginTransaction();
		List<ReclamoEntity> reclamos = s.createQuery("from ReclamoEntity").list();
		for(ReclamoEntity e: reclamos)
			resultado.add(toNegocio(e));
		s.getTransaction().commit();
		
		return resultado;
	}
	/* ver si no me conviene tener este metodo privado*/
	/*public Reclamo findByID(int id) throws ReclamoException {
		Reclamo resultado = null;
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session s = sf.getCurrentSession();
		s.beginTransaction();
		ReclamoEntity reclamo = (ReclamoEntity) s.createQuery("from ReclamoEntity r where r.id = ?").setInteger(0, id).uniqueResult();
		s.getTransaction().commit();
		if(reclamo != null) {
			resultado = toNegocio(reclamo);
			return resultado;
		}
		else
			throw new ReclamoException("No existe reclamo con el id: " + id);
			
	}*/
	
	Reclamo toNegocio(ReclamoEntity p) {
		Reclamo reclamo = null;
		if(p!=null) {
			reclamo = new Reclamo(p.getId(),p.getDocumento(),p.getCodigo(),p.getUbicacion(),p.getDescripcion(),p.getIdentificador());
		}
		return reclamo;
	}
	
	ReclamoEntity toEntity(Reclamo r) {
		return new ReclamoEntity(r.getId_reclamo(),r.getDocumento(),r.getCodigo(),r.getUbicacion(),r.getDescripcion(),r.getIdentificador());
	}

}
