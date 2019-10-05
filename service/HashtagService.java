package com.ambre.wiki.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ambre.wiki.entities.Hashtag;
import com.ambre.wiki.repositories.HashtagRepository;

@Service
public class HashtagService {

	@Autowired
	private HashtagRepository myRepository;
	
	/**
	 * Declares the default constructor
	 */
	public HashtagService() {
		
	}
	
	public Hashtag findHashtagById(Long id) {
		return myRepository.findHashtagById(id);
	}
	
	public Iterable<Hashtag> findAllHashtag() {
		return myRepository.findAllHashtag();
	}

	public Hashtag createHashtag(String title) {
		return myRepository.createHashtag(title);
	}
	
	public Hashtag updateHashtag(Long id, String title) {
		return myRepository.updateHashtag(id, title);
	}
	
	public Boolean deleteHashtag(Long id) {
		return myRepository.deleteHashtag(id);
	}

	public Iterable<Hashtag> findHashtagByTitle(String title) {
		return myRepository.findHashtagByTitle(title);
	}	
	
}
