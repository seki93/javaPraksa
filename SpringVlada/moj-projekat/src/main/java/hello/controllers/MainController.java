package hello.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import hello.entity.Adresa;
import hello.entity.Kompanija;
import hello.repos.AdresaRepository;
import hello.repos.KompanijaRepository;



@Controller
@RequestMapping(path="/maindemo")

public class MainController {
	
	@Autowired
	private AdresaRepository adresaRepository;
    @Autowired
	private KompanijaRepository kompanijaRepository;
	

	
	
	

	
}


