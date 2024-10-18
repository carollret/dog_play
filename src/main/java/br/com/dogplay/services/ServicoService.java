package br.com.dogplay.services;

import br.com.dogplay.Repository.ServiceRepository;
import br.com.dogplay.models.Servico;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ServicoService {

    private final ServiceRepository servicosRepository;

    public ServicoService(ServiceRepository servicosRepository) {
        this.servicosRepository = servicosRepository;
    }

    public Servico save(Servico servico){
        return servicosRepository.save(servico);
    }

    public Servico findById(UUID id) {
        return servicosRepository.findById(id).orElse(null);
    }

    public void delete(UUID Id) {
        servicosRepository.deleteById(Id);
    }

    public List<Servico> findAll() {
        return servicosRepository.findAll();
    }

    public Servico update(Servico servico, UUID Id) {
        var aux = findById(Id);
        if (aux != null) {
            if (servico.getId() != null) {
                aux.setId(servico.getId());
            }
            if (servico.getPrestador() != null) {
                aux.setPrestador(servico.getPrestador());
            }
            return servicosRepository.save((aux));
        }
        return null;
    }


}