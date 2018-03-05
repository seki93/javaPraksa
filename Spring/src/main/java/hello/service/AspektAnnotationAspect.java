package hello.service;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import hello.model.Aspekt;

@Aspect
@Component
public class AspektAnnotationAspect {

	@Before("@annotation(mojaAnotacija)")
	public void mojaAnotacija(){
		Aspekt a =  new Aspekt();
		Long s = System.currentTimeMillis();
		a.setBegin(s);
		System.out.println("Vreme pocetka metode je logovano!");
	}
}
