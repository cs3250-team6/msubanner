package edu.msudenver.cs3250.group6.msubanner;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface SectionRepository extends CrudRepository<Section, Long> {
}
