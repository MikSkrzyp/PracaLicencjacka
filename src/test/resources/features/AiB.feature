# language: pl
Funkcja: Program Studiów AiB

@chrome
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

    @firefox
    Scenariusz: AiB4
      Zakładając, że jestem na stronie kierunku AiB
      Wtedy powinno się pojawić zdjęcię kierunku AiB

    Scenariusz: AiB5
      Zakładając, że jestem na stronie kierunku AiB
      Kiedy kliknę przycisk wróć
      Wtedy powinienem zostać przerzucony na poprzednią stronę

      @firefox
    Scenariusz: AiB6
      Zakładając, że jestem na stronie kierunku AiB
      Kiedy zaznacze przycisk studia stacjonarne kierunku AiB
      Wtedy Pojawi się tabela SEMESTR I
      I jest wypełniona odpowiednimi danymi

    Scenariusz: AiB7
      Zakładając, że jestem na stronie kierunku AiB
      Wtedy nie powinienem dostać alertu że program studiów na kierunku AiB nie został opublikowany

    Scenariusz: AiB8
      Zakładając, że jestem na stronie kierunku AiB
      Kiedy zaznacze przycisk studia stacjonarne kierunku AiB
      Wtedy Pojawi się tabela SEMESTR II
      I liczba ECTS'ów każdego przedmiotu się odpowiednio sumuje
#
  Scenariusz: AiB9
    Zakładając, że jestem na stronie kierunku AiB
    Kiedy zaznacze przycisk studia stacjonarne kierunku AiB
    Wtedy Pojawi się tabela SEMESTR II
    I kolumna Roz. ma wartosci zgodne z legenda (E lub Z)

    @firefox
  Scenariusz: AiB10
    Zakładając, że jestem na stronie kierunku AiB
    Kiedy zaznacze przycisk studia stacjonarne kierunku AiB
    Wtedy powinny się ukazać zsumowany wartosci dla wszystkich semestrow


