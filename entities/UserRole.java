
package com.ambre.wiki.entities;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


@Entity
@Table (name="user_role")
@SequenceGenerator(name="user_role_sequence_id", initialValue = 1, sequenceName = "role_sequence", allocationSize = 1)
public class UserRole implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_role_sequence_id")
    private Long id;
    
    
    
    @Column (name = "role", nullable = false)
	private String role;
    
    @ElementCollection
    private Set<String> urls;

    public Set<String> getUrls() {
        return urls;
    }

    public void setUrls(Set<String> urls) {
        this.urls = urls;
    }
    
    

    
    public UserRole() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

	public void setRole(String role) {
        this.role = role;
    }

    public String getRole() {
        return role;
    }

	/**
	 * Get the serial version UID
	 * Generated by Eclipse (Getters and Setters)  
	 * @return
	 */
    public static long getSerialversionuid() {
		return serialVersionUID;
	}
    
}
