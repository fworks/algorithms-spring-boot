package fworks.algorithms.api.model;

import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Repository for SortingRequest.
 * 
 * @author flaviolcastro
 *
 */
interface SortingRequestRepository extends MongoRepository<SortingRequest, String> {
}
