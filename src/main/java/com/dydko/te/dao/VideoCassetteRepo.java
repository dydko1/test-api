package com.dydko.te.dao;

import com.dydko.te.entity.VideoCassette;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VideoCassetteRepo  extends CrudRepository<VideoCassette, Long> {
}
