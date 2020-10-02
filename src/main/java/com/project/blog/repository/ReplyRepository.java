package com.project.blog.repository;

import com.project.blog.model.Reply;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface ReplyRepository extends JpaRepository<Reply, Integer> {
    @Modifying
    @Query(value = "INSERT INTO reply(userId, boardId, content, createDate) VALUE(?1,?2,?3,now())", nativeQuery = true)
    int customSave(int userId, int boardId, String content);
}
