# language: pl
Funkcja: Program Studiów Analityka Gospodarcza


  @firefox
  Scenariusz: test10
    Zakładając, że jestem na stronie kieurnku Analityka Gospodarcza
    Kiedy zaznacze przycisk studia stacjonarne
    Wtedy Nie powinien sie ukazac przycisk z ikono pdf

  @chrome
  Scenariusz: test11
    Zakładając, że jestem na stronie kieurnku Analityka Gospodarcza
    Kiedy zaznacze przycisk studia stacjonarne
    Wtedy powinna się ukazać wiadomosc: Program studiów dla specjalności Analityka gospodarcza na rok akademicki 2024-2025 nie został opublikowany.

