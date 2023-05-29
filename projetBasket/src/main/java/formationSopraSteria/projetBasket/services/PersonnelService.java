package formationSopraSteria.projetBasket.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import formationSopraSteria.projetBasket.entities.Personnel;
import formationSopraSteria.projetBasket.exceptions.PersonnelException;
import formationSopraSteria.projetBasket.repositories.PersonnelRepository;

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
	
	public Personnel update(Personnel Personnel) {
		Personnel personnelEnBase = getById(Personnel.getId());
		checkPersonnel(Personnel);
		personnelEnBase.setId(Personnel.getId());
		personnelEnBase.setNom(Personnel.getNom());
		personnelEnBase.setPrenom(Personnel.getPrenom());
		personnelEnBase.setEquipe(Personnel.getEquipe());
		personnelEnBase.setRole_personnel(Personnel.getRole_personnel());
		personnelEnBase.setSalaire(Personnel.getSalaire());
		return personnelRepo.save(personnelEnBase);
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
            throw new IllegalArgumentException("Personnel non trouvÃ© avec l'ID : " + personnelId);
        }
    }
	
	
	
	
	
	
//	private Personnel getById(Long id) {
//		checkId(id);
//		return personnelRepo.findById(id).orElseThrow(() -> {
//			return new PersonnelException("id inconnu");
//		});
//	}
	public Personnel getById(Long id) {
	    checkId(id);
	    return personnelRepo.findById(id)
	            .orElseThrow(() -> new PersonnelException("id inconnu"));
	}
	public List<Personnel> findBySalaire(double salaire) {
	    return personnelRepo.findBySalaire(salaire);
	}
	
	public List<Personnel> getAll() {
		return personnelRepo.findAll();
	}

	
//	public void delete(Personnel Personnel) {
//		delete(Personnel.getId());
//	}

	public void delete(Long id) {
		Personnel Personnel = getById(id);
		personnelRepo.delete(Personnel);

	}
	
	public List<Personnel> getByNom(String nom) {
		return personnelRepo.findByNomContaining(nom);
	}
}