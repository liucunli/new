package com.news.dao;

import com.news.model.Admin;
import com.news.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.io.Serializable;

public interface AdminMapper extends JpaRepository<User, Integer>, JpaSpecificationExecutor<User>, Serializable {

}
