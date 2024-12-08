# language: pl
Funkcja: Program Studiów

@firefox
  Scenariusz: test1
    Zakładając, że Jestem na stronie z Programem Studiów
    Wtedy Powinienem zobaczyć tekst "STUDIA I STOPNIA"

@chrome
  Scenariusz: test2
    Zakładając, że Jestem na stronie z Programem Studiów
    Kiedy Wybiorę kierunek Analityka Gospodarcza
    Wtedy Powinienem zostać przeniesiony na stronę Analityki Gospodarczej
    I Zobaczyć komunikat: Program studiów dla specjalności Analityka gospodarcza na rok akademicki 2024-2025 nie został opublikowany.

  @chrome
  Scenariusz: test3
    Zakładając, że Jestem na stronie z Programem Studiów
    Kiedy Wybiorę kierunek Analityka Gospodarcza
    I Zaznaczę opcję Studia Stacjonarne
    Wtedy Nie powinien się pojawić przycisk z ikonką PDF

    @chrome
    Scenariusz: test4
      Zakładając, że Jestem na stronie z Programem Studiów
      Kiedy Wybiorę kierunek AiB
      I Zaznaczę opcję Studia Stacjonarne na stronie AiB
      Wtedy Powinienem zobaczyć tablicę z przedmiotami kierunku AiB

      @chrome
      Scenariusz: test5
        Zakładając, że Jestem na stronie z Programem Studiów AiB
        Kiedy Wybiorę rok 2016-2017
        Wtedy zmieni się data
#        I Przedmioty na tablicy się zmienią