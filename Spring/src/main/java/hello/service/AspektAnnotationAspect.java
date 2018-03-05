package hello.service;

import java.text.SimpleDateFormat;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import hello.model.Aspekt;
import hello.repository.AspektRepository;

@Aspect
@Component
public class AspektAnnotationAspect {

	@Autowired
	AspektRepository aspektRepository;

	@Before("@annotation(mojaAnotacija)")
	public void mojaAnotacija(JoinPoint joinPoint){
		Aspekt a =  new Aspekt();
		
		SimpleDateFormat formater = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss.SSS");
		String trenutnoVreme = formater.format(System.currentTimeMillis());
		a.setId(3);
		a.setName("Worker Metoda Anotacija Test 2");
		a.setBegin(trenutnoVreme);
		a.setEnd(trenutnoVreme);
		aspektRepository.save(a);
		System.out.println("Vreme pocetka metode je logovano!");
	}
	
	
}
