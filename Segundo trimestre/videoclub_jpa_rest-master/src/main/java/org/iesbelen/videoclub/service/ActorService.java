package org.iesbelen.videoclub.service;

import org.iesbelen.videoclub.domain.Actor;
import org.iesbelen.videoclub.exception.AutorNotFoundException;
import org.iesbelen.videoclub.repository.ActorRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ActorService {
    private final ActorRepository actorRepository;

    ActorService(ActorRepository actorRepository) {
        this.actorRepository = actorRepository;
    }

    public List<Actor> all() {
        return this.actorRepository.findAll();
    }

    public Actor save(Actor actor) {
        return this.actorRepository.save(actor);
    }

    public Actor one(Long id) {
        return this.actorRepository.findById(id)
                .orElseThrow(() -> new AutorNotFoundException(id));
    }

    public Actor replace(Long id, Actor actor) {
        return this.actorRepository.findById(id).map(a -> (id.equals(actor.getIdActor()) ?
                        this.actorRepository.save(actor) : null))
                .orElseThrow(() -> new AutorNotFoundException(id));
    }

    public void delete(Long id) {
        this.actorRepository.findById(id).map(a -> {
                    this.actorRepository.delete(a);
                    return a;
                })
                .orElseThrow(() -> new AutorNotFoundException(id));
    }
}
