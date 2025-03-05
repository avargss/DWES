package org.iesbelen.videoclub.repository;

import org.iesbelen.videoclub.domain.Actor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ActorRepository extends JpaRepository<Actor, Long> {


}
