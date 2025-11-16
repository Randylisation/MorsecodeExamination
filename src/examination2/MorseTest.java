package examination2;


import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class MorseTest {


    @Test
    public void singleLetterFromMorseToEnglish() {

        //ARRANGE
        MorseLogic logic = new MorseLogic();
        String morseInput = ".-";
        String expected = "A";


        //ACT
        String actual = logic.morseCharToEnglish(morseInput);


        //ASSERT
        assertEquals(expected, actual);

    }


    @Test

    public void singleWordFromMorseToEnglish() {

        //ARRANGE
        MorseLogic logic = new MorseLogic();
        String morseInput = "-- .- .-.. .-";
        String expected = "MALA";

        //ACT
        String actual = logic.morseWordToEnglish(morseInput);


        //ASSERT
        assertEquals(expected, actual);

    }



    @Test

    public void sentenceFromMorseToEnglish() {

        //ARRANGE
        MorseLogic logic = new MorseLogic();
        String morseInput = ".. .- -- -- .- .-.. .-";
        String expected = "IAMMALA";


        //ACT
        String actual = logic.morseSentenceToEnglish(morseInput);


        //ASSERT
        assertEquals(expected, actual);

    }

    @Test

    public void singleLetterFromEnglishToMorse() {

        //ARRANGE
        MorseLogic logic = new MorseLogic();
        String englishInput = "W";
        String expected = ".--";


        //ACT
        String actual = logic.englishCharToMorse(englishInput);


        //ASSERT
        assertEquals(expected, actual);

    }


    @Test

    public void singleWordFromEnglishToMorse() {
        //ARRANGE
        MorseLogic logic = new MorseLogic();
        String englishInput = "TOMAS";
        String expected = "- --- -- .- ...";

        //ACT
        String actual = logic.englishWordToMorse(englishInput);



        //ASSERT
        assertEquals(expected, actual);

    }

    @Test

    public void sentenceFromEnglishToMorse() {

        //ARRANGE
        MorseLogic logic = new MorseLogic();
        String englishInput = "HE IS TOMAS";
        String expected = ".... . / .. ... / - --- -- .- ...";


        //ACT
        String actual = logic.englishSentenceToMorse(englishInput);


        //ASSERT
        assertEquals(expected, actual);

    }

    @Test

    public void sentenceFromEnglishToMorseIgnoreDifferentCases() {

        //ARRANGE
        MorseLogic logic = new MorseLogic();
        String englishInput = "JavA Is fUn";
        String expected = ".--- .- ...- .- / .. ... / ..-. ..- -.";

        //ACT
        String actual = logic.englishSentenceToMorse(englishInput);

        //ASSERT
        assertEquals(expected, actual);

    }






    }

