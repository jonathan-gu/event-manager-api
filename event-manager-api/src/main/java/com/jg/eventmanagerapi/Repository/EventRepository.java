package com.jg.eventmanagerapi.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jg.eventmanagerapi.Entity.Event;

@Repository
public interface EventRepository extends JpaRepository<Event, Integer> {
	List<Event> findByStartDateTimeGreaterThan(LocalDateTime date);
	
	Optional<Event> findById(Integer id);
	
	void deleteById(Integer id);
}
