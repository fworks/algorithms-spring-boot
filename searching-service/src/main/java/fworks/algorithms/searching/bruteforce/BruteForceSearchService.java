package fworks.algorithms.searching.bruteforce;

import fworks.algorithms.searching.SearchService;

/**
 * Brute Force Service.
 * 
 * @author flaviolcastro
 *
 */
public interface BruteForceSearchService extends SearchService {

  public static final String BRUTE_FORCE = "BruteForce";

  @Override
  default String getAlgorithmName() {
    return BRUTE_FORCE;
  }
}
