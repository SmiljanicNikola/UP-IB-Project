-Sto se backend-a tice, pristupamo eclipsu i pokrecemo program UP-IBProjekat, konkretno UpIbProjekatApplication.java fajl.


-Svi potrebni podaci i modeli nalaze nam se u MySQL Workbench-u za koji su sve potrebne informacije ostavljene u okviru fajla data.sql
unutar samog projekta.


-Frontend je radjen sa react-om i pristupamo tako sto ulazimo u Visual Studio Code, pullujemo samu aplikaciju i pomocu cd komande dolazimo
do fajla koji se zove react-upibprojekat. React se pokrece sa komandom npm start i unutar konzole ce se ispisivati svi potrebni eksterni moduli
koji su neophodni za pokretanje same aplikacije.


-Nakon par minuta pristupice se samom browseru gde ce putanja za sam home page aplikacije vec biti uneta(http://localhost:3000). Neautentifikovanom
korisniku bice omoguceno da pristupa samo stranicama za login i registraciju. Nakon logovanja u zavisnosti od role korisnika, svakom od njih ce biti
omogucene funkcionalnosti koje smo implementirali i bice prikazane vecinom u okviru headera i dublje.

ADMINISTRATOR KLINIKE: USERNAME:adminklinike|PASSWORD:123


LEKAR: USERNAME:ivan@gmail.com|PASSWORD:ivan123


PACIJENT: USERNAME:milena@gmail.com|PASSWORD:milena


MEDICINSKA SESTRA: USERNAME:dragana@gmail.com|PASSWORD:dragana


KLINICKI CENTAR ADMINISTRATOR: USERNAME:centaradmin|PASSWORD:12345
