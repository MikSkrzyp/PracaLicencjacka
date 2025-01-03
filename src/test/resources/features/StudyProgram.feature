# language: pl
Funkcja: Program Studiów

    @chrome
    Scenariusz:[PS-001] Tekst STUDIA I STOPNIA
      Zakładając, że jestem na stronie z Programem Studiów I stopnia
      Wtedy powinienem zobaczyć tekst "STUDIA I STOPNIA"

    @chrome
    Scenariusz:[PS-002] Odpowiednia liczba kierunków studiów
      Zakładając, że jestem na stronie z Programem Studiów I stopnia
      Wtedy ukaże mi się 17 kierunków studiów

    @chrome
    Scenariusz:[PS-003] Wybranie Kierunku
      Zakładając, że jestem na stronie z Programem Studiów I stopnia
      Kiedy wybiorę kierunek Analityka Gospodarcza
      Wtedy ukaże mi się strona z programem studiów kierunku Analityki Gospodarczej

    @firefox
    Scenariusz:[PS-004] Ustawienia Dostępności
      Zakładając, że jestem na stronie z Programem Studiów I stopnia
      Kiedy kliknę przycisk "Dostępność"
      Wtedy wyskoczy pop-up z ustawieniami dostępności

    @chrome
    Scenariusz:[PS-005] Ścieżka strony
      Zakładając, że jestem na stronie z Programem Studiów I stopnia
      Wtedy powinienem zostać poinformowany o poprzednich koniecznych aby dojsc do aktualnej strony

    @chrome
    Scenariusz:[PS-006] Przejście na stronę ze studiami II stopnia
      Zakładając, że jestem na stronie z Programem Studiów I stopnia
      Kiedy wybiorę studia II stopnia w zakładce z poziomami studiów
      Wtedy zostanę przeniesiony na odpowiednią stronę z kierunkami studiów II stopnia

    @firefox
    Scenariusz:[PS-007] Domyślny nagłówek i stopka
      Zakładając, że jestem na stronie z Programem Studiów I stopnia
      Wtedy na stronie obecny jest domyślny nagłówek i stopka