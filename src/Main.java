import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.hibernate.HibernateUtil;
import com.models.Etudiant;
import com.models.Filiere;

public class Main {

	public static void main(String[] args) {
		Session s = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction t = s.beginTransaction();
		
		//List<Filiere> fls = s.createQuery("from Filiere").list();
		//List<Etudiant> etds = s.createQuery("from Etudiant").list();
		/*for(Etudiant f : etds) {
			System.out.println(f);
		}*/
		
		Etudiant e = new Etudiant();
		e.setNom("zayd");
		e.setPrenom("elimrani");
		
		Filiere f = new Filiere();
		f.setIdFiliere(1);
		
		e.setFiliere(f);
		s.save(e);
		
		
		t.commit();
		s.close();

	}

}
