# language: pl
Funkcja: Program Studiów Analityka Gospodarcza



  @chrome
  Scenariusz:[AG-001] Pobranie pliku PDF niedozwolone
    Zakładając, że jestem na stronie kieurnku Analityka Gospodarcza
    Kiedy zaznaczę przycisk studia stacjonarne
    Wtedy nie powinienen się ukazac przycisk z ikonką pdf


  @chrome
  Scenariusz:[AG-002] Alert o braku programu studiów
    Zakładając, że jestem na stronie kieurnku Analityka Gospodarcza
    Kiedy zaznaczę przycisk studia stacjonarne
    Wtedy powinna się ukazać wiadomosc: Program studiów dla specjalności Analityka gospodarcza na rok akademicki 2024-2025 nie został opublikowany.


  @firefox
  Scenariusz:[AG-003] Zmiana Roku akadmickiego na 2016-2017
    Zakładając, że jestem na stronie kieurnku Analityka Gospodarcza
    Kiedy wybiorę rok "2016-2017" przy przycisku "Rok akademicki"
    Wtedy wartość sie zmieni na "2016-2017"


