package com.project.blog.repository;

import com.project.blog.model.Board;
import com.project.blog.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

//DAO
//자동으로 Bean으로 등록
@Repository //생략가능
public interface BoardRepository extends JpaRepository<Board, Integer> {

}