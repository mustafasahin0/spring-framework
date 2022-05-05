package com.cydeo.repository;

import com.cydeo.model.Comment;

public interface CommentRepository {
    void storeComment(Comment comment);
}
