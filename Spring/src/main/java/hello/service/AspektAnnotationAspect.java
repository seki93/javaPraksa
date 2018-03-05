package hello.service;

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
		Long s = System.currentTimeMillis();
		a.setId(1);
		a.setName("Worker Metoda sa anotacijom");
		a.setBegin(s);
		a.setEnd(s);
		aspektRepository.save(a);
		System.out.println("Vreme pocetka metode je logovano!");
	}
}
