package fworks.algorithms.searching.search.bruteforce;

import fworks.algorithms.searching.search.AlgorithmSearchService;

/**
 * Brute Force Service.
 * 
 * @author flaviolcastro
 *
 */
public interface BruteForceSearchService extends AlgorithmSearchService {

  public static final String BRUTE_FORCE = "BruteForce";

  @Override
  default String getAlgorithmName() {
    return BRUTE_FORCE;
  }
}
