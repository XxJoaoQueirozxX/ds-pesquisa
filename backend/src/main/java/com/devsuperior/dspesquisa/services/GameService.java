package com.devsuperior.dspesquisa.services;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devsuperior.dspesquisa.DTO.GameDTO;
import com.devsuperior.dspesquisa.entities.Game;
import com.devsuperior.dspesquisa.repositories.GameRepository;

@Service
public class GameService {

	
	@Autowired
	private GameRepository repository;
	
	@Transactional(readOnly=true)
	public List<GameDTO> findAll(){
		List<Game> games = repository.findAll();
		return games.stream().map(x -> new GameDTO(x)).collect(Collectors.toList());
	}
}
