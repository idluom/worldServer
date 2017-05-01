package Beans;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import Entity.Comment;
import Service.CommentEJB;

@ManagedBean
@RequestScoped
public class FeedbackBean implements Serializable{

	private static final long serialVersionUID = 1L;

	@EJB
	private CommentEJB cmntEJB = new CommentEJB();
	
	private Comment comment = new Comment();
	private boolean formDisplayed = false;
	private String alias;
	private String text;
	
	public Comment getComment() {
		return comment;
	}
	
	public void setComment(Comment comment) {
		this.comment = comment;
	}
	
	public boolean isFormDisplayed() {
		return formDisplayed;
	}
	
	public void setFormDisplayed(boolean formDisplayed) {
		this.formDisplayed = formDisplayed;
	}
	
	public List<Comment> getAllComments() {
		return cmntEJB.findAllComments();
	}

	public String getAlias() {
		return alias;
	}

	public void setAlias(String alias) {
		this.alias = alias;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}
	
	public String postComment() {
		
		comment.setDateComment(new Date());
		cmntEJB.addComment(comment);
		return "FeedBack";
	}
	
	public String showCommentArea() {
		setFormDisplayed(true);
		return "";
	}
}
