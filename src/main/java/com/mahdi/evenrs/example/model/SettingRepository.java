package com.mahdi.evenrs.example.model;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SettingRepository extends CrudRepository<Setting, Long> {
}
