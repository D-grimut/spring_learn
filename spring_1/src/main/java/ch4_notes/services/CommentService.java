package ch4_notes.services;

import org.springframework.stereotype.Service;

import ch4_notes.model.Comment;
import ch4_notes.proxies.ICommentNotifiProxy;
import ch4_notes.repos.ICommentRepo;

// @Service and @Component effectively do the same thing - and have very subtle differences under the hood
// (from what I gather, @Service may be scanned and caught by some other Spring depnednencies)
// In a general sense tho, they do the same thing and create Beans!
@Service
public class CommentService {
    private final ICommentRepo commentRepo;
    private final ICommentNotifiProxy commentNotifProxy;

    // no need for @Autowired since we only have one Constructor so Spring knows where to inject stuff - epic!
    // more than one constructor tho (including the empty constructor) - @Autowired is required.
    // Also, note how cool Spring is here - it's so smart it goes and CHECKS for Beans that implement (parent type) is the interface!
    public CommentService(ICommentRepo cr, ICommentNotifiProxy cnp){
        this.commentRepo = cr;
        this.commentNotifProxy = cnp;
    }

    public void publishComment(Comment comment){
        this.commentRepo.storeComment(comment);
        this.commentNotifProxy.sendComment(comment);
    }
}
