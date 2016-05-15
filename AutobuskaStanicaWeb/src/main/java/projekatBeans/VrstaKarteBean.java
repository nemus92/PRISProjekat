package projekatBeans;

import java.util.List;

import managers.JPAUtil;
import managers.KartaManager;
import model.Karta;

public class VrstaKarteBean {

private List<Karta> slobodneKarte;
	
	public List<Karta> getSlobodneKarte() {
		return slobodneKarte;
	}
	
	public void setSlobodneKarte(List<Karta> slobodneKarte) {
		this.slobodneKarte=slobodneKarte;
	}
	
//	public SlobodneKarteBean() {
//		slobodneKarte=new KartaManager().getSveSlobodneKarte(JPAUtil.getEntityManager());
//	}
}
