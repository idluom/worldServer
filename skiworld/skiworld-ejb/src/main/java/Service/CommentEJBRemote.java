package Service;

import java.util.List;

import javax.ejb.Remote;

import Entity.Comment;

@Remote
public interface CommentEJBRemote {
	public void deleteComment(Comment comment);
	public Comment findCommentById(Long id);
	public void addComment(Comment comment);
	public List<Comment> findAllComments();
}
