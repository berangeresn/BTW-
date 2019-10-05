
package com.ambre.wiki.entities;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table (name="wiki_status")
@SequenceGenerator(name="wiki_status_sequence_id", initialValue = 1, sequenceName = "wikistatus_sequence", allocationSize = 1)
public class WikiStatus implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "wiki_status_sequence_id")
    private Long id;
    
    @Column (name = "status", nullable = false)
    private String status;

    /**
     * Define the default constructor 
     * (needed to declare an entity bean)
     */
    public WikiStatus() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
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
