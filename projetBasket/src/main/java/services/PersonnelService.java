package services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import entities.Joueur;
import entities.Personnel;
import exceptions.PersonnelException;
import repositories.PersonnelRepository;

@Service
public class PersonnelService {
	
	@Autowired
	private PersonnelRepository personnelRepo;
	
	private void checkPersonnel(Personnel personnel) {
		if (personnel == null) {
			throw new PersonnelException("personnel null");
		}
		if (personnel.getNom() == null || personnel.getNom().isEmpty()) {
			throw new PersonnelException("nom obligatoire");
		}
	}
	private void checkId(Long id) {
		if (id == null) {
			throw new PersonnelException("id null");
		}
	}
	
	public Personnel create(Personnel personnel) {
		checkPersonnel(personnel);
		return personnelRepo.save(personnel);
	}
	
	/*
	 * public Personnel updateSalaire(Personnel personnel) { Personnel
	 * personnelEnBase = getById(personnel.getId());
	 * personnelEnBase.setSalaire(personnel.getSalaire()); return
	 * personnelRepo.save(personnelEnBase); }
	 */
	
	public Personnel modifierSalairePersonnel(Long personnelId, int nouveauSalaire) {
        Optional<Personnel> personnelOptional = personnelRepo.findById(personnelId);

        if (personnelOptional.isPresent()) {
            Personnel personnel = personnelOptional.get();
            personnel.setSalaire(nouveauSalaire);
            return personnelRepo.save(personnel);
        } else {
            throw new IllegalArgumentException("Personnel non trouvé avec l'ID : " + personnelId);
        }
    }
	
	
	
	
	
	
//	private Personnel getById(Long id) {
//		checkId(id);
//		return personnelRepo.findById(id).orElseThrow(() -> {
//			return new PersonnelException("id inconnu");
//		});
//	}
	private Personnel getById(Long id) {
	    checkId(id);
	    return personnelRepo.findById(id)
	            .orElseThrow(() -> new PersonnelException("id inconnu"));
	}
	public List<Personnel> findBySalaire(double salaire) {
	    return personnelRepo.findBySalaire(salaire);
	}
}

	