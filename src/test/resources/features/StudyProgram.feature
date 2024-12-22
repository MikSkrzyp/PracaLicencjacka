# language: pl
Funkcja: Program Studiów

@chrome
  Scenariusz: SP1
    Zakładając, że jestem na stronie z Programem Studiów 1 stopnia
    Wtedy Powinienem zobaczyć tekst "STUDIA I STOPNIA"

   @chrome
    Scenariusz: SP2
      Zakładając, że jestem na stronie z Programem Studiów 1 stopnia
      Wtedy ukażę mi się 17 kierunków


  @chrome
  Scenariusz: SP3
    Zakładając, że jestem na stronie z Programem Studiów 1 stopnia
    Kiedy klikne Analityka Gospodarcza
    Wtedy ukaze mi sie strona z programem studiow Analityki Gospodarczej

    @firefox
    Scenariusz: SP4
      Zakładając, że jestem na stronie z Programem Studiów 1 stopnia
      Kiedy kline przycisk "Dostępnosc"
      Wtedy ukaża mi się ustawienia dostępnosci

      Scenariusz: SP5
        Zakładając, że jestem na stronie z Programem Studiów 1 stopnia
        Wtedy powinienem zostać poinformowany o poprzednich przejsciach aby dojsc do aktualnej strony

        Scenariusz: SP6
          Zakładając, że jestem na stronie z Programem Studiów 1 stopnia
          Kiedy wybiorę studia II stopnia w zakladce z poziomami studiów
          Wtedy zostanę przeniesiony na odpowiednią stronę
