package examination2;

import java.util.Scanner;

public class MorseMain {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        MorseLogic logic = new MorseLogic();

        System.out.println("Välj vad du vill översätta från nedan");
        System.out.println("Val 1 = från ENGELSKA till MORSE");
        System.out.println("Val 2 = från MORSE till ENGELSKA");

        int choiceOfTranslation = scanner.nextInt();
        scanner.nextLine(); // Rensar Scanner

        // Kolla direkt om valet är fel
        if (choiceOfTranslation != 1 && choiceOfTranslation != 2) {
            System.out.println("Fel val! Programmet avslutas. Välj 1 eller 2 nästa gång.");
            scanner.close();
            return; // stoppar main
        }

        while (true) { // Kör tills break
            System.out.println("Toppen! Skriv in din engelska text eller morsekod");
            String input = scanner.nextLine();

            try {
                if (choiceOfTranslation == 1) {
                    String morseTranslated = logic.englishSentenceToMorse(input);
                    System.out.println(input + " blir: " + morseTranslated);
                } else if (choiceOfTranslation == 2) {
                    String englishTranslated = logic.morseSentenceToEnglish(input);
                    System.out.println(input + " blir: " + englishTranslated);
                }

                // Bryter loopen eftersom inmatningen blev korrekt
                break;

            } catch (NullPointerException e) {
                if (choiceOfTranslation == 1) {
                    System.out.println("Det ser ut som att du missat att mata in text. Testa igen!");
                } else {
                    System.out.println("Det blev lite fel. Försök igen och tänk på att skriva morsekod med morsekodens tecken");
                }
            } catch (Exception e) {
                if (choiceOfTranslation == 1) {
                    System.out.println("Någonting blev fel! Försök igen och säkra att du använder bokstäver mellan A-Z");
                } else {
                    System.out.println("Ojdå! Kontrollera att du bara använder morsekodens tecken");
                }
            }
        }

        scanner.close();
    }
}