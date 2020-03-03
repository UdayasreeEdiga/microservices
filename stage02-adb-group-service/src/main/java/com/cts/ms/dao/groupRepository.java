package com.cts.ms.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cts.ms.entity.GroupEntity;

public interface groupRepository  extends JpaRepository<GroupEntity,String> {

}
