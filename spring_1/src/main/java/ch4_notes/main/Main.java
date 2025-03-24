package ch4_notes.main;

import ch4_notes.model.Comment;
import ch4_notes.proxies.EmailCommentNotifProxy;
import ch4_notes.repos.DBCommentRepo;
import ch4_notes.services.CommentService;

/* 
General Notes:
In Spring, especialy spring boot, code usualy follows a MVC structure, where we have Services, repos, proxies and models.
Proxies = Anything that communicates and establishes communication with the outside world (ex: email notification)
model = digital representation of some entity we want to mode (ex: a comment)
repos = anything that connects and interacts with a DB - i.e. Data Access Objects (DAO)
service = objects that implmenet the buisnes logic/use-cases of our app
*/ 
public class Main {
    public static void main(String[] args) {
        DBCommentRepo db = new DBCommentRepo();
        EmailCommentNotifProxy emailProxy = new EmailCommentNotifProxy();
        Comment c = new Comment("Daniel", "Daniel is 1 step closer to being a 10x dev");
        CommentService cs = new CommentService(db, emailProxy);
        cs.publishComment(c);
    }
}
