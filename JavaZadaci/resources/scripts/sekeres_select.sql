#Selektuj sve adrese iz baze
SELECT * FROM osoba.adresa;

#Selektuj sve adrese iz beograda
SELECT * FROM osoba.adresa
WHERE Grad ='Beograd';

#Selektuj sve kompanije iz beograda
SELECT naziv FROM kompanija
  JOIN adresa ON kompanija.adresa_id = adresa.adresa_id
 where Grad ='Beograd';

#Selektuj sve adrese koje imaju vise od jedne kompanije
SELECT *
FROM adresa
	JOIN kompanija ON adresa.adresa_id = kompanija.adresa_id
GROUP BY adresa.adresa_id
HAVING COUNT(adresa.adresa_id) > 1;



#Selektuj sve radnike koji zive u beogradu
SELECT adresa.adresa_id, radnik.jmbg
FROM adresa
RIGHT JOIN radnik ON adresa.adresa_id = radnik.adresa_id
WHERE Grad = 'Beograd';

#Selektuj sve radnike koji rade u beogradu
SELECT ime, prezime
FROM radnik
	JOIN kompanija 
		ON radnik.kompanija_id= kompanija.kompanija_id
	JOIN adresa
		on adresa.adresa_id = radnik.adresa_id
WHERE grad = 'Beograd';


