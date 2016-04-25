package projekatBeans;

import java.util.List;

import managers.JPAUtil;
import managers.KartaManager;
import model.Karta;

public class CenaKarteBean {

		private List<Karta> cenaKarte;
		
		public List<Karta> getCenaKarte() {
			return cenaKarte;
		}
		
		public void setCenaKarte(List<Karta> cenaKarte) {
			this.cenaKarte=cenaKarte;
		}
		
		public CenaKarteBean() {
			cenaKarte=new KartaManager().getCenaKarte(JPAUtil.getEntityManager());
		}
	}
