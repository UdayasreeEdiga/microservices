package com.cts.adb.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cts.adb.entity.GroupEntity;

@Repository
public interface GroupRepository extends JpaRepository<GroupEntity, String> {

}
