package fworks.algorithms.searching;

import javax.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SearchRequest {

  /**
   * Key to be found.
   */
  @NotNull
  private long key;
  
  /**
   * Array to be searched.
   */
  @NotNull
  private long[] array;

}
