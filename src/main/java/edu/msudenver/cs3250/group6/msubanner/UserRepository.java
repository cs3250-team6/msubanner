package edu.msudenver.cs3250.group6.msubanner;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/**
 * Data repository interface for User class
 * Using Repository pattern over DAO pattern due to
 *   available documentation.
 * @author Group 6
 */
@RepositoryRestResource
public interface UserRepository extends CrudRepository<User, Long>{

}
