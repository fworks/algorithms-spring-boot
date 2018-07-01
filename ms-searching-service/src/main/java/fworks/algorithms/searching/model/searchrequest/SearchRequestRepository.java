package fworks.algorithms.searching.model.searchrequest;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Repository for SearchRequest.
 * 
 * @author flaviolcastro
 *
 */
interface SearchRequestRepository extends JpaRepository<SearchRequest, String> {
}
