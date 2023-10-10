# Knihy - Spring

V tomto projekte na naprogramovaný aplikačný server v jazyku Java s pomocou frameworku Spring.

Aplikačný server umožňuje správu kníh, ich autorov a ich požičiavania (napr. z knižnice).
Webové rozhranie (API), ako aj objekty, ktoré sa používajú na komunikáciu s vonkajším svetom sú definované v špecifikácii API a musi byť použité na komunikáciu cez webové služby.

Špecifikáciu webového rozhrania, ktoré má aplikácia poskytovať nájdete tu: https://app.swaggerhub.com/apis-docs/stuba-fei-uim-oop/OOPZadanie3Knihy/1.0.0-oas3

## Popis systému

Podrobný popis jednotlivých operácii je uvedený v špecifikácii API.

Systém umožňuje pridávanie a odoberanie kníh z knižnice. Dalej umožnuje úpravu existujúcich knih (aj zmenu autora, autor môže byť len jeden), ako aj navýšenie počtu stavu kníh v knižnici.

Systém umožňuje vytváranie a vymazávanie listov s požičanými knihami. Do listov je možné pridávať a odoberať knihy (vždy v jednom liste môže byt len jedna kniha). Systém ďalej umožnuje požičanie ešte nevypožičaných listov, čo inkrementuje počítadlo požičaných kópií v individuálnych knihách. Do už vypožičaných listov kníh nie je možné pridávať ďalšie knihy.

### Ďalšie informácie

V projekte sú dodržané OOP prinpcípy ako napríklad:

* vhodné pomenovanie tried, metód a premenných v jednotnom jazyku (názvy tried s veľkým počiatočným písmenom, názvy metód s malým),
* vhodné použitie modifikátorov prístupu (public, private, poprípade protected) na obmedzenie prístupu k metódam a atribútom,
* využitie dedenia a polymorfizmu,
* použitie výnimiek na ošetrenie nedovoleného správania (nehádzať a nezachytávať všeobecnú triedu Exception),
* hlavná trieda (main) obsahuje len kód potrebný na inicializáciu aplikácie pomocou Spring frameworku,
* v projekte je použitá knižnica lombok a jej anotácie.
