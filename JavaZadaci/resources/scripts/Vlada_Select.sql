select * from sportista;

select * from adresa;

select * from adresa where grad='Beograd';

select naziv from kompanija inner join adresa on kompanija.adresa_id=adresa.adresa_id where grad='Beograd';

select ime, prezime from radnik inner join adresa on radnik.adresa_id=adresa.adresa_id where grad='Beograd';

select ime, prezime from ((radnik join kompanija on radnik.adresa_id=kompanija.adresa_id) join adresa on radnik.adresa_id=adresa.adresa_id) where grad='Beograd';