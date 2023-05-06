package org.techtalk.debu.spring.jpa.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.techtalk.debu.spring.jpa.entity.Tutorial;
import org.techtalk.debu.spring.jpa.repository.TutorialRepository;

@Service
public class TutorialServiceImpl implements TutorialService {

	@Autowired
	private TutorialRepository tutorialRepository;
	
	
	
	@Transactional
	public List<Tutorial> findByTitleAndSort(String title) {
		return tutorialRepository.findByTitleAndSort(title,Sort.by("title").descending());
	}
	
	@Transactional
	public List<Tutorial> findAllSort() {
		
		Sort sort = new Sort(Sort.Direction.ASC, "title");
		return tutorialRepository.findAllSort(sort);
	}
	
	@Transactional
	public Page<Tutorial> findAllWithPagination(int page,int size) {
		Pageable pageable = PageRequest.of(page, size);

		return tutorialRepository.findAllWithPagination(pageable);
	}
	
	
	@Transactional
	public List<Tutorial> findAll() {
		return tutorialRepository.findAll();
	}
	
	@Transactional
	public Tutorial save(Tutorial tutorialObj) {
		return tutorialRepository.save(tutorialObj);
	}
	
	
	
	@Transactional
	public Optional<Tutorial> findByTitle(String title) {
		return tutorialRepository.findByTitle(title);
	}
	
	/*@Transactional
	public List<Tutorial> findByPublished(String isPublished) {
		boolean status = false;
		if(isPublished.equalsIgnoreCase("true"))
			status = true;
		return tutorialRepository.findByPublished(status);
	}
	
	
	@Transactional
	public List<Tutorial> findByTitleLike(String title) {
		return tutorialRepository.findByTitleLike(title);
	}*/
	
}
