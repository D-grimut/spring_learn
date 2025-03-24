package ch4_notes.services;

import ch4_notes.model.Comment;
import ch4_notes.proxies.ICommentNotifiProxy;
import ch4_notes.repos.ICommentRepo;

public class CommentService {
    private final ICommentRepo commentRepo;
    private final ICommentNotifiProxy commentNotifProxy;


    public CommentService(ICommentRepo cr, ICommentNotifiProxy cnp){
        this.commentRepo = cr;
        this.commentNotifProxy = cnp;
    }

    public void publishComment(Comment comment){
        this.commentRepo.storeComment(comment);
        this.commentNotifProxy.sendComment(comment);
    }
}
