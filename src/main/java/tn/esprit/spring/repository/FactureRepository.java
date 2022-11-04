package tn.esprit.spring.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import DTO.Balanceagee;
import DTO.Chiffre_aff;
import DTO.DSO;
import DTO.Evolution_retard;
import DTO.Facture_client;
import DTO.Prevision;
import DTO.Retards;
import DTO.Risque;
import DTO.Statuts;
import tn.esprit.spring.entity.Facture;


@Repository
public interface FactureRepository extends JpaRepository<Facture, Integer>{
	@Query("select f from Facture f where f.idclient=:x")
	public List<Facture> findFactureByClientId(@Param("x")Long code_client);
	@Query(value = "SELECT new DTO.Balanceagee(SUM(CASE WHEN f.retards<0 THEN f.montant_restant ELSE 0 END) , SUM(CASE WHEN f.retards Between 0 AND 30 THEN f.montant_restant ELSE 0 END) , SUM(CASE WHEN f.retards Between 31 AND 60 THEN f.montant_restant ELSE 0 END) ,SUM(CASE WHEN f.retards Between 61 AND 90 THEN f.montant_restant ELSE 0 END) , SUM(CASE WHEN 91<=f.retards THEN f.montant_restant ELSE 0 END)) FROM Facture f")
	public List<Balanceagee> getMontantByRetards();
	@Query(value = "SELECT new DTO.Statuts(COUNT(*)/(Select COUNT(*) from Facture)*100, status) FROM Facture GROUP BY status")
	public List<Statuts> getStatus();
	@Query(value = "SELECT new DTO.Evolution_retard(SUM(montant_restant), SUM(CASE WHEN f.retards Between 0 AND 30 THEN f.montant_restant ELSE 0 END)+SUM(CASE WHEN f.retards Between 31 AND 60 THEN f.montant_restant ELSE 0 END)+SUM(CASE WHEN f.retards Between 61 AND 90 THEN f.montant_restant ELSE 0 END)+SUM(CASE WHEN 91<=f.retards THEN f.montant_restant ELSE 0 END), MONTHNAME(delai_paimentF), (SUM(CASE WHEN f.retards Between 0 AND 30 THEN f.montant_restant ELSE 0 END)+SUM(CASE WHEN f.retards Between 31 AND 60 THEN f.montant_restant ELSE 0 END)+SUM(CASE WHEN f.retards Between 61 AND 90 THEN f.montant_restant ELSE 0 END)+SUM(CASE WHEN 91<=f.retards THEN f.montant_restant ELSE 0 END))/(SUM(montant_restant))*100) FROM Facture f GROUP BY MONTHNAME(delai_paimentF) ORDER BY delai_paimentF")
	public List<Evolution_retard> getEvolution_retard();
	@Query(value = "SELECT new DTO.Facture_client(client.code_client, SUM(montant_restant), SUM(CASE WHEN f.retards Between 0 AND 30 THEN f.montant_restant ELSE 0 END)+SUM(CASE WHEN f.retards Between 31 AND 60 THEN f.montant_restant ELSE 0 END)+SUM(CASE WHEN f.retards Between 61 AND 90 THEN f.montant_restant ELSE 0 END)+SUM(CASE WHEN 91<=f.retards THEN f.montant_restant ELSE 0 END)) FROM Facture f GROUP BY client.code_client")
	public List<Facture_client> getFacture_client();
	@Query(value = "SELECT new DTO.Retards(SUM(CASE WHEN f.retards Between 0 AND 30 THEN f.montant_restant ELSE 0 END)+SUM(CASE WHEN f.retards Between 31 AND 60 THEN f.montant_restant ELSE 0 END)+SUM(CASE WHEN f.retards Between 61 AND 90 THEN f.montant_restant ELSE 0 END)+SUM(CASE WHEN 91<=f.retards THEN f.montant_restant ELSE 0 END)) FROM Facture f")
	public List<Retards> getRetards();
	@Query(value = "SELECT new DTO.Chiffre_aff(SUM(montant_restant)+SUM(montant_initial)) FROM Facture")
	public List<Chiffre_aff> getChiffre_aff();
	@Query(value = "SELECT new DTO.Prevision(SUM(CASE WHEN f.retards<0 THEN f.montant_restant ELSE 0 END), SUM(CASE WHEN f.status='Promesse de règlement' AND f.retards<0 THEN f.montant_restant ELSE 0 END), MONTHNAME(date_echeance)) FROM Facture f GROUP BY MONTHNAME(date_echeance) ORDER BY date_echeance")
	public List<Prevision> getPrevision();
	@Query(value = "SELECT new DTO.DSO(SUM(montant_restant)/(SUM(montant_restant)+SUM(montant_initial))*183, SUM(CASE WHEN f.retards<0 THEN f.montant_restant ELSE 0 END)/(SUM(montant_restant)+SUM(montant_initial))*183, (SUM(montant_restant)/(SUM(montant_restant)+SUM(montant_initial))*183)-(SUM(CASE WHEN f.retards<0 THEN f.montant_restant ELSE 0 END)/(SUM(montant_restant)+SUM(montant_initial))*183), (SUM(CASE WHEN f.retards Between 0 AND 30 THEN f.montant_restant ELSE 0 END)+SUM(CASE WHEN f.retards Between 31 AND 60 THEN f.montant_restant ELSE 0 END)+SUM(CASE WHEN f.retards Between 61 AND 90 THEN f.montant_restant ELSE 0 END)+SUM(CASE WHEN 91<=f.retards THEN f.montant_restant ELSE 0 END))/(SUM(montant_restant))*100, MONTHNAME(delai_paimentF)) FROM Facture f GROUP BY MONTHNAME(delai_paimentF) ORDER BY delai_paimentF")
	public List<DSO> getDSO();
	@Query(value = "SELECT new DTO.Risque(client.code_client, SUM(montant_restant), SUM(montant_restant), SUM(CASE WHEN f.retards Between 0 AND 30 THEN f.montant_restant ELSE 0 END)+SUM(CASE WHEN f.retards Between 31 AND 60 THEN f.montant_restant ELSE 0 END)+SUM(CASE WHEN f.retards Between 61 AND 90 THEN f.montant_restant ELSE 0 END)+SUM(CASE WHEN 91<=f.retards THEN f.montant_restant ELSE 0 END), (SUM(CASE WHEN f.retards Between 0 AND 30 THEN f.montant_restant ELSE 0 END)+SUM(CASE WHEN f.retards Between 31 AND 60 THEN f.montant_restant ELSE 0 END)+SUM(CASE WHEN f.retards Between 61 AND 90 THEN f.montant_restant ELSE 0 END)+SUM(CASE WHEN 91<=f.retards THEN f.montant_restant ELSE 0 END))/(SUM(montant_restant))*100, SUM(garantie_assureur), SUM(autres_garanties), SUM(montant_restant)-SUM(garantie_assureur)-SUM(autres_garanties), (SUM(montant_restant)-SUM(garantie_assureur)-SUM(autres_garanties))/(SUM(montant_restant))*100, SUM(montant_restant)-SUM(garantie_assureur)-SUM(autres_garanties), SUM(limite_credit), SUM(limite_credit)-SUM(montant_restant)) FROM Facture f GROUP BY client.code_client")
	public List<Risque> getRisque();
}
