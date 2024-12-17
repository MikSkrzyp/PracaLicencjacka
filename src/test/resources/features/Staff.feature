# language: pl
Funkcja: Strona z pracownikami uczelni


@chrome
  Scenariusz: S1
    Zakładając, że jestem na stronie z pracownikami UG
    Wtedy pierwszy pracownik którego zobaczę to dr Alicja Antonowicz

  @chrome
  Scenariusz: S2
    Zakładając, że jestem na stronie z pracownikami UG
    Kiedy klikne Dydaktycy
    Wtedy liczba pracowników na stronie powinna być równa 4
