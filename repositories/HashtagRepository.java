package com.ambre.wiki.repositories;

import com.ambre.wiki.entities.Category;
import com.ambre.wiki.entities.Comment;
import com.ambre.wiki.entities.Hashtag;
import com.ambre.wiki.entities.Wiki;

import java.util.List;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;


@Repository
@Transactional
public class HashtagRepository extends BaseRepository {

	public HashtagRepository() {
		
	}
	
    public Hashtag findHashtagById(Long id) {
    	return (Hashtag)em.find(Hashtag.class, id);
    }

    public Iterable<Hashtag> findAllHashtag() {
		StringBuilder from = new StringBuilder();
		TypedQuery<Hashtag> lQuery = em.createQuery(from.append("from ").append(Hashtag.class.getName()).toString(), Hashtag.class);
		return (Iterable<Hashtag>) lQuery.getResultList();
    }
    
    @SuppressWarnings("unchecked")
	public Iterable<Hashtag> findHashtagByTitle(String title) { 
        String pattern = title; 
        Query q = em.createQuery("SELECT h FROM " + Hashtag.class.getName() + " h "
                + " WHERE h.title LIKE :pattern ").setParameter("pattern", pattern);
        return (Iterable<Hashtag>) q.getResultList();
    }    
    
    public Hashtag persistHashtag(Hashtag myEntity) {
    	if (myEntity!=null) {
    		em.persist(myEntity);
    		em.flush();
    		return myEntity;
		} 
    	return null;
    }

    public Hashtag createHashtag(String title) {
    	Hashtag myEntity = new Hashtag(); 
    	myEntity.setTitle(title);
		return this.persistHashtag(myEntity);
    }

    public Hashtag updateHashtag(Long id, String title) {
    	if ((title!=null) && (id!=null)) {
            Hashtag myEntity = this.findHashtagById(id);
            if (myEntity!=null) {
        		List<Hashtag> myList = (List<Hashtag>) this.findHashtagByTitle(title);
        		if (myList!=null) {
    				if (myList.size()==0) {
    					myEntity.setTitle(title);
    					return this.persistHashtag(myEntity);
    				}
    			}
			}
		}
    	return null;
    }

    /**
     * Delete a hashtag by id
     * Force deletion.
     * @param id
     * @return
     */
    public Boolean deleteHashtag(Long id) {
        Hashtag myEntity = this.findHashtagById(id);
        if (myEntity!=null) {
        	em.remove(myEntity); 
        	return true;
        }
		return false;
    }
    
    /**
     * Check if Hashtag is bound to Comment.
     * Delete if not.
     * @param id
     * @param deleteIfNotBound
     * @return
     */
    public Boolean deleteHashtag(Long id, boolean deleteIfNotBound) {
    	if (deleteIfNotBound) {
            Hashtag myEntity = this.findHashtagById(id);
            if (myEntity!=null) {
            	if (myEntity.getCommentHashtag().size()==0) {
                	em.remove(myEntity);
                	return true;
				}
            	return false;
            }
		} else {
			return this.deleteHashtag(id);
		}
    	return null;
    }
    
       
    /**
     * Add 
     * @param myHashTag
     * @param myComment
     * @return
     */
	public Hashtag addHashtagToComment(Hashtag myHashTag, Comment myComment) {
		if ((myHashTag!=null) && (myComment!=null)) {
			myComment.getHashtags().add(myHashTag);
			myHashTag.getCommentHashtag().add(myComment);
			return this.persistHashtag(myHashTag);
		}
		return null;
	}
    
    public boolean removeHashtagFromComment(Hashtag myHashTag, Comment myComment) {
        boolean removed = false;
               
        if ((myHashTag!=null) && (myComment!=null)) { 
           //Category myCat = em.find(Category.class, Long.valueOf(categoryId));
           myComment.getHashtags().remove(myHashTag);
           em.persist(myComment);
           em.remove(myHashTag);
           removed = true;
       }
        
       return removed;
   }	
	
    
}
