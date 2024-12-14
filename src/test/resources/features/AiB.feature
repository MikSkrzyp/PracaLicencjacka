# language: pl
Funkcja: Program Studiów AiB

@firefox
Scenariusz: AiB1
  Zakładając, że jestem na stronie kierunku AiB
  Kiedy zaznacze przycisk studia stacjonarne kierunku AiB
  Wtedy Pojawi się tabela
  I ma 57 rzędów


  @chrome
  Scenariusz: AiB2
    Zakładając, że jestem na stronie kierunku AiB
    Kiedy zaznacze przycisk studia stacjonarne kierunku AiB
    Wtedy Pojawi się tabela
    I ma okreslone nazwy kolumn

  @chrome
  Scenariusz: AiB3
    Zakładając, że jestem na stronie kierunku AiB
    Kiedy zaznacze przycisk studia stacjonarne kierunku AiB
    I klikne przycisk z plikiem PDF
    Wtedy otworzy się strona z PDF