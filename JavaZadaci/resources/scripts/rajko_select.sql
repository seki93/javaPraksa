#Selektuj sve adrese iz baze
#select *
#from adresa;

#Selektuj sve adrese iz beograda
#select *
#from adresa
#where grad='Beograd';

#Selektuj sve kompanije iz beograda
#select *
#from kompanija k join adresa a on k.adresa_id = a.adresa_id
#where a.grad = 'Beograd';

#Selektuj sve adrese koje imaju vise od jedne kompanije
#select adresa.adresa_id
#from  kompanija, adresa
#where kompanija.adresa_id=adresa.adresa_id
#group by adresa.adresa_id
#having count(adresa.adresa_id)>1


#Selektuj sve radnike koji zive u beogradu
#select *
#from radnik r left join adresa a on r.adresa_id = a.adresa_id
#where a.grad = 'Beograd';

#Selektuj sve radnike koji rade u beogradu
#select *
#from radnik r join kompanija k on r.kompanija_id = k.kompanija_id
#			   join adresa a on k.adresa_id=a.adresa_id
#where a.grad = 'Beograd';
#