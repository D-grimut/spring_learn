package ch4_notes.repos;

import ch4_notes.model.Comment;

public interface ICommentRepo {
    void storeComment(Comment comment);
}