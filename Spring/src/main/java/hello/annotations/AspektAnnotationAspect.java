package hello.annotations;

import java.text.SimpleDateFormat;

import javax.servlet.http.HttpServletRequest;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import hello.model.Aspekt;
import hello.model.Service;
import hello.repository.AspektRepository;
import hello.repository.ServiceRepository;

@Aspect
@Component
public class AspektAnnotationAspect {

	@Autowired
	AspektRepository aspektRepository;
	
	@Autowired
	ServiceRepository serviceRepository;
	
	@Before("@annotation(mojaAnotacija)")
	public void mojaAnotacijaBefore(JoinPoint joinPoint){
		Aspekt a =  new Aspekt();
		SimpleDateFormat formater = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss.SSS");
		String trenutnoVreme = formater.format(System.currentTimeMillis());
		a.setId(3);
		a.setName("Worker Metoda Izvrsena");
		a.setBegin(trenutnoVreme);
		a.setEnd(trenutnoVreme);
		aspektRepository.save(a);
		System.out.println("Vreme pocetka metode je logovano!");
	}
	
	@Around("execution(* hello.controllers.WorkerController.getAllWorker(..)) && args(request)")
	public Object serviceService(ProceedingJoinPoint joinPoint, HttpServletRequest request) throws Throwable {

		Long pocetnoVreme = System.currentTimeMillis();

		Object proceed = joinPoint.proceed();
		
		
		Long izvrsnoVreme = System.currentTimeMillis() - pocetnoVreme;

		String serv = request.getRequestURI().toString();
		String url = request.getRequestURL().toString();
		

		Service s = new Service();
		s.setName(serv);
		s.setTime(izvrsnoVreme);
		s.setUrl(url);

		serviceRepository.save(s);
		
		System.out.println(" Vreme izvrsenja servisa : " + izvrsnoVreme + "ms.");
		return proceed;
		
	}
}
