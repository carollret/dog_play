package br.com.dogplay.services;

import br.com.dogplay.Repository.TutorRepository;
import br.com.dogplay.models.Tutor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TutorService {

    private TutorRepository TutorRepository;

    public TutorService(TutorRepository repositoryTutor) {
        this.TutorRepository = repositoryTutor;
    }

    public Tutor save(Tutor tutor){
        return TutorRepository.save(tutor);
    }

    public Tutor findById (Long id) {
        var aux = TutorRepository.findById(id);
        Tutor tutor = null;
        if (aux.isPresent()){
            tutor = aux.get();
        }
        return tutor;
    }
    public void delete(Long id) {
        TutorRepository.deleteById(id);
    }
    public Tutor update(Tutor tutor, Long id) {
        var aux = findById(id);
        if (tutor.getId() != null) {
            aux.setId(tutor.getId());
        }
        if (tutor.getNome() != null){
            aux.setNome(tutor.getNome());

        }
        return TutorRepository.save(aux);

    }
    public List<Tutor> findAll() {
        return TutorRepository.findAll();
    }


}