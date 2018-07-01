package fworks.algorithms.sorting.model.sortingrequest;

import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Repository for SortingRequest.
 * 
 * @author flaviolcastro
 *
 */
interface SortingRequestRepository extends MongoRepository<SortingRequest, String> {
}
