select * from adresa;

select * from adresa where grad='Beograd';

select naziv from kompanija inner join adresa on kompanija.adresa_id=adresa.adresa_id where grad='Beograd'; 

select ime,prezime from radnik inner join adresa on radnik.adresa_id=adresa.adresa_id where grad='Beograd';

select ime,prezime from radnik inner join kompanija on radnik.kompanija_id=kompanija.kompanija_id inner join adresa on adresa.adresa_id = radnik.adresa_id where grad='Beograd';