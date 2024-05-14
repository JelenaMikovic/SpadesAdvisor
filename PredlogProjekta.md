<i>SV42/2020 Danilo Babić, SV61/2020 Jelena Miković</i>
<h1>Restaurant Reccomendation</h1>
<h2>Motivacija</h2>
Ovaj projekay proističe iz potrebe da se olakša proces odabira restorana korisnicima, pružajući im personalizovane preporuke koje će poboljšati njihovo iskustvo i zadovoljstvo. Ovaj projekat se zasniva na ideji da nasa aplikacija može efikasno pomoći korisnicima da pronađu restorane koji odgovaraju njihovim željama i očekivanjima, čime se stvara pozitivno iskustvo i podstiče lojalnost korisnika.
<h2>Pregled problema</h2>
Naš projekat za preporuku restorana fokusira se na pružanje preporuka restorana koje su prilagođene individualnim željama korisnika. Za razliku od drugih sistema, mi ćemo uzeti u obzir različite faktore poput ocena korisnika, lokacije, vrste hrane i cene kako bismo generisali preporuke. Ono što nas izdvaja je mogućnost korisnicima da sami prilagode preporuke prema svojim preferencijama i da nam daju povratne informacije, što će doprineti tome da dobiju baš ono što žele. Na taj način, želimo da stvorimo iskustvo koje će korisnicima olakšati pronalaženje savršenog mesta za obrok.
<h2>Metodologija rada</h2>
<h4>Ulazi u sistem (inputs): </h4> 

  - Preferencije korisnika: vrsta restorana, odredjena ocena, lokacija, cena
    
  - Istorija posecenih restorana: informacije o restoranu, ocena koju je korisnik dao
    
  - Najpopularniji restorani: uzece se u obzir trenutno najpopularniji restorani na lokaciji korsinkia

<h4>Izlazi iz sistema (outputs): </h4>

  - Restorani: preporuceni restorani na osnovu istorije i pretrage

<h4>Popunjavanje baze:</h4>

  - Korisnički unos: Korisnici će moći da unesu ili ažuriraju svoje preferencije direktno u sistem, uključujući vrstu restorana, ocene, lokaciju i cenu.

  - Prikupljanje podataka: Podaci o istoriji posećenih restorana će se automatski prikupljati na osnovu aktivnosti korisnika, uključujući informacije o restoranima koje su posetili i ocene koje su dali.

  - Integracija sa drugim izvorima: Podaci o restoranima, uključujući ocene korisnika i druge informacije, mogu se prikupiti iz različitih javno dostupnih izvora, kao što su veb sajtovi za ocenjivanje restorana ili API-ji restorana.

<h4>Baza:</h4>

  - Korisnici: ime, prezime, telefon, email, sifra, omiljeni restorani
    
  - Restorani: vrsta hrane, lokacija, cena, radno vreme
    
  - Ocene: ocene korisnika odredjenog restorana

<h2>Primer rezonovanja</h2>

  1. Prikupljanje informacija o korisniku:

  - Korisnik ulazi u sistem i unosi svoje preferencije, kao što su željena vrsta restorana (italijanski, azijski, vegetarijanski), minimalna ocena restorana, lokacija i budžet za obrok.

  2. Analiza istorije posećenih restorana:

  - Sistem pregledava istoriju posećenih restorana korisnika i analizira informacije o vrsti restorana koje je korisnik prethodno posećivao, kao i ocene koje je davao tim restoranima. Na primer, ako korisnik često posećuje azijske restorane i obično daje visoke ocene japanskim restoranima, sistem će uzeti to u obzir prilikom preporuke.

  3. Uzimanje u obzir trenutno popularnih restorana:

  - Sistem istražuje trenutno popularne restorane na lokaciji korisnika i analizira koje vrste restorana su trenutno najtraženije. Ova informacija može biti korisna za dodavanje dodatnog konteksta u preporuke.

  4. Rezonovanje na osnovu podataka:

  - Na osnovu prikupljenih informacija o korisniku, istoriji posećenih restorana i trenutno popularnih restorana, sistem primenjuje različite algoritme ili pravila za generisanje personalizovanih preporuka. Na primer, sistem može koristiti hibridni model koji kombinuje filtriranje na osnovu sadržaja (content-based filtering) sa kolaborativnim filtriranjem (collaborative filtering) kako bi generisao preporuke koje su relevantne i personalizovane za korisnika.

  5. Generisanje preporuka:

  - Sistem generiše listu preporučenih restorana na osnovu rezonovanja iz prethodnih koraka. Ove preporuke se prikazuju korisniku u obliku liste sa detaljima o restoranima, uključujući ime, ocenu korisnika, lokaciju i vrstu hrane.


<h2>Pravila</h2>
<h4>Osnovna pravila: </h4>

  - Ako korisnik je na odredjenoj lokaciji, preporuke na osnovu te lokacije.
  - Ako je korisnik pusac, preporuke restorana koji dozvoljavaju pusenje.
  - Ako je korisnik vegitarijanac, preporuke restorana koji imaju vegatarijanska jela.

<h4>Filter: </h4>
  - Ako korisnik zeli odredjenu vrstu hrane, preporuke te vrste hrane.
  - Ako korisnik zeli do odredjene cene, preporuke restorana te cene.
  - Ako korisnik zeli od odredjene srednje ocene, preporuke restorana minimum te ocene.
  - Ako korisnik zeli odredjenu lokaciju, preporuke na osnovu te lokacije.
  - Ako korisnik zeli mesto za pusace, preporuke restorana koji dozvoljavaju pusenje.
  - Ako korisnik zeli mesto za vegetarijance, preporuke restorana koji imaju vegatarijanska jela.

<h4>Forward chaining: </h4>

  - Preporuka na osnovu vrste restorana
    1. Korisnik je ocenio restoran sa visokom ocenom, restoran ide na listu pozitivno ocenjenih restorana
    2. Vrsta tog restorana se stavlja u listu vrsta restorana koje preferira korisnik
    3. Na osnovu vrste se preporucuje restoran
  
  - Preporuka na osnovu cene
    1. Korisnik preferira restorane u određenom cenovnom rangu, restoran se dodaje u listu restorana u tom cenovnom rangu
    2. Cena tog restorana se stavlja u listu cenovnih raspona koje korisnik preferira
    3. Na osnovu cene se preporučuje restoran
  
  - Preporuka na osnovu lokacije
    1. Korisnik je dao pozitivnu ocenu restoranu na odredjenoj lokaciji, restoran ide na listu restorana na toj lokaciji
    2. Lokacija tog restorana se stavlja u listu lokacija koje korisnik preferira
    3. Na osnovu lokacije se preporucuje restoran
   
  - Preporuka na osnovu radnog vremena
    1. Korisnik preferira restorane koji su otvoreni kasno, restoran se dodaje na listu restorana koji rade do kasno.
    2. Radno vreme tog restorana se stavlja na listu radnih vremena koje korisnik preferira.
    3. Na osnovu radnog vremena se preporučuje restoran.

<h4>Backward chaining: </h4>

  - Pretraga kuvara i restorana na osnovu Michelin zvezda koje je restoran dobio.
    
![bkwd1 drawio](https://github.com/JelenaMikovic/RestaurantReccomendation/assets/24361522/8926f90b-494d-4148-b2da-291489ab5ddc)

<h4>Query: </h4>

  - Izvestaj prikazuje koje vrste hrane korisnik najcesce posecuje.
  - Izvestaj prikazuje korisnikove omiljene restorane.
  - Izvestaj prikazuje koji cenovni rang korisnik najcesce bira.
  - Izvestaj prikazuje koje radno vreme korisnik najcesce bira.

<h4>Template: </h4>

  - Admin podesava uslove za trending restorane te nedelje:
      - Podesava se uslov za broj ostavljenih recenzija (npr. makar 10 ocena u prethodnih mesec dana)
      - Podesava se uslov za minimalnu ocenu restorana (npr. minimum ocena 4.5)
      - Podesava se uslov za vrstu restorana (npr. nedelja azijske hrane)

<h4>CEP: </h4>

  - Preporuka restorana na osnovu nedavnih poseta korisnika i preferirane vrste hrane
    1. Korisnik je u poslednjih 7 dana posetio 2 ili više restorana
    2. Analizira se vrsta hrane koju je korisnik konzumirao tokom poseta restoranima.
    3. Generiše se preporuka za restorane koji nude istu ili sličnu vrstu hrane kao što je konzumirana tokom nedavnih poseta korisnika.

  - Preporuka restorana na osnovu nedavnih ocena korisnika i preferirane cene
    1. Korisnik je u poslednjih 48 sati dao 1 ili više pozitivnih ocena restoranima.
    2. Analizira se preferirana cena korisnika za obrok.
    3. Generiše se preporuka za najbolje ocenjene restorane koji odgovaraju preferiranoj ceni korisnika.
  
