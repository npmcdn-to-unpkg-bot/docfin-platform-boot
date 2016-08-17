package com.docfin.platform.repository;

import com.docfin.platform.model.Address;
import com.docfin.platform.model.State;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by amit on 8/16/16.
 */
@Repository
public interface StateRepository extends PagingAndSortingRepository<State, Long>{
}
