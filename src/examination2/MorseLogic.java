package examination2;

import java.util.HashMap;

public class MorseLogic {

    //ATTRIBUT
    private HashMap<String, String> morseTranslatedToEnglish;
    private HashMap<String, String> englishTranslatedToMorse;



    //KONSTRUKTOR
    public MorseLogic() {
        //MORSE --> ENG
        morseTranslatedToEnglish = new HashMap<>();

        //Lägger in key i morse och value på engelska genom .put
        morseTranslatedToEnglish.put(".-", "A");
        morseTranslatedToEnglish.put("-...", "B");
        morseTranslatedToEnglish.put("-.-.", "C");
        morseTranslatedToEnglish.put("-..", "D");
        morseTranslatedToEnglish.put(".", "E");
        morseTranslatedToEnglish.put("..-.", "F");
        morseTranslatedToEnglish.put("--.", "G");
        morseTranslatedToEnglish.put("....", "H");
        morseTranslatedToEnglish.put("..", "I");
        morseTranslatedToEnglish.put(".---", "J");
        morseTranslatedToEnglish.put("-.-", "K");
        morseTranslatedToEnglish.put(".-..", "L");
        morseTranslatedToEnglish.put("--", "M");
        morseTranslatedToEnglish.put("-.", "N");
        morseTranslatedToEnglish.put("---", "O");
        morseTranslatedToEnglish.put(".--.", "P");
        morseTranslatedToEnglish.put("--.-", "Q");
        morseTranslatedToEnglish.put(".-.", "R");
        morseTranslatedToEnglish.put("...", "S");
        morseTranslatedToEnglish.put("-", "T");
        morseTranslatedToEnglish.put("..-", "U");
        morseTranslatedToEnglish.put("...-", "V");
        morseTranslatedToEnglish.put(".--", "W");
        morseTranslatedToEnglish.put("-..-", "X");
        morseTranslatedToEnglish.put("-.--", "Y");
        morseTranslatedToEnglish.put("--..", "Z");


        //ENG --> MORSE
        englishTranslatedToMorse = new HashMap<>();

        englishTranslatedToMorse.put("A", ".-");
        englishTranslatedToMorse.put("B", "-...");
        englishTranslatedToMorse.put("C", "-.-.");
        englishTranslatedToMorse.put("D", "-..");
        englishTranslatedToMorse.put("E", ".");
        englishTranslatedToMorse.put("F", "..-.");
        englishTranslatedToMorse.put("G", "--.");
        englishTranslatedToMorse.put("H", "....");
        englishTranslatedToMorse.put("I", "..");
        englishTranslatedToMorse.put("J", ".---");
        englishTranslatedToMorse.put("K", "-.-");
        englishTranslatedToMorse.put("L", ".-..");
        englishTranslatedToMorse.put("M", "--");
        englishTranslatedToMorse.put("N", "-.");
        englishTranslatedToMorse.put("O", "---");
        englishTranslatedToMorse.put("P", ".--.");
        englishTranslatedToMorse.put("Q", "--.-");
        englishTranslatedToMorse.put("R", ".-.");
        englishTranslatedToMorse.put("S", "...");
        englishTranslatedToMorse.put("T", "-");
        englishTranslatedToMorse.put("U", "..-");
        englishTranslatedToMorse.put("V", "...-");
        englishTranslatedToMorse.put("W", ".--");
        englishTranslatedToMorse.put("X", "-..-");
        englishTranslatedToMorse.put("Y", "-.--");
        englishTranslatedToMorse.put("Z", "--..");

    }








    //METODER

    public String morseCharToEnglish(String morseInput) {
        // Hämtar engelska bokstaven i HashMap:en
        String englishChar = morseTranslatedToEnglish.get(morseInput);

        // Kollar om tecknet finns, annars returnerar tomt
        if (englishChar != null) {
            return englishChar;
        } else {
            return ""; // Ignorerar null
        }
    }





    public String morseWordToEnglish(String morseWord) {
        //Bryter ner morseordet till separata morse-tecken
        String[] morseChars = morseWord.trim().split(" ");

        //Holder där chars kommer att matas in för att bilda ordet på engelska
        String englishWord = "";

        //Loop som går igenom och adderar alla morseChars och gör om till engelska
        for (int i = 0; i < morseChars.length; i++) {
            String morseChar = morseChars[i];

            //Hämtar engelska bokstaven i HashMap:en
            String englishChar = morseTranslatedToEnglish.get(morseChar);

            //Kollar om tecknet finns, annars sätter "?" (för ogiltiga tecken)
            if (englishChar != null) {
                englishWord += englishChar;
            } else {
                englishWord += ""; //Ignorerar null
            }
        }

        return englishWord;
    }


    public String morseSentenceToEnglish(String morseInput) {
        String[] morseChars = morseInput.trim().split(" ");
        String englishSentence = "";
        for (int i = 0; i < morseChars.length; i++) {
            String englishChar = morseTranslatedToEnglish.get(morseChars[i]);
            if (englishChar == null) {
                throw new IllegalArgumentException("Ogiltig morsekod: " + morseChars[i]);
            }
            englishSentence += englishChar;
        }
        return englishSentence;
    }



    public String englishCharToMorse(String englishInput) {
        englishInput = englishInput.toUpperCase();
        return englishTranslatedToMorse.get(englishInput);
    }


    public String englishWordToMorse(String englishInput) {

        //Gör alla bokstäver stora
        englishInput = englishInput.toUpperCase();

        //Delar upp det engelska ordet i bokstäver
        String[] englishCharsAdded = englishInput.trim().split("");

        //Gör en tom holder där chars kommer att matas in för att bilda morseordet
        String morseWord = "";

        //Loop som går igenom och adderar alla eng chars och gör om till morse
        for (int i = 0; i < englishCharsAdded.length; i++) {
            String englishChars = englishCharsAdded[i];
            String morseChar = englishTranslatedToMorse.get(englishChars);
            morseWord += morseChar;

            //Lägger till mellanslag mellan morse så länge som det inte är sista
            if (i < englishCharsAdded.length - 1) {
                morseWord += " ";
            }

        }

        return morseWord;

    }


    public String englishSentenceToMorse(String englishInput) {
        //Gör att all input blir stora bokstäver. Spelar ingen roll om små eller stora
        englishInput = englishInput.toUpperCase();

        String[] englishWords = englishInput.trim().split(" ");
        String morseSentence = "";

        for (int i = 0; i < englishWords.length; i++) {
            String[] englishChars = englishWords[i].split("");
            for (int j = 0; j < englishChars.length; j++) {
                String morseChar = englishTranslatedToMorse.get(englishChars[j]);
                if (morseChar == null) {
                    throw new IllegalArgumentException("Ogiltigt tecken: " + englishChars[j]);
                }
                morseSentence += morseChar;
                if (j < englishChars.length - 1) {
                    morseSentence += " ";
                }
            }
            if (i < englishWords.length - 1) {
                morseSentence += " / ";
            }
        }

        return morseSentence;
    }




}
