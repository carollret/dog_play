package br.com.dogplay.services;

import br.com.dogplay.Repository.PetsRepository;
import br.com.dogplay.models.Pets;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class PetsService {
    @Autowired
    private PetsRepository petsRepository;

    public Pets savePet(Pets pets) {
        return petsRepository.save(pets);
    }

    public List<Pets> getAllPets() {
        return petsRepository.findAll();
    }

    public Optional<Pets> getPetById(Long id) {
        return petsRepository.findById(id);
    }

    public void deletePet(Long id) {
        petsRepository.deleteById(id);
    }

    public Pets update(Pets pets, Long id) {
        var aux = petsRepository.findById(id).get();
        if (aux != null) {
            if (pets.getId() != null) {
                aux.setId(pets.getId());
            }
            if (pets.getId() != null) {
                aux.setId(pets.getId());
            }
            return petsRepository.save((aux));
        }
        return null;
    }
}



