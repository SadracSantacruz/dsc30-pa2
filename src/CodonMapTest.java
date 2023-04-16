import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

class CodonMapTest {

    static CodonMap testCodon;
    @BeforeEach
    void setUp(){
        testCodon = new CodonMap();
    }


    @Test
    void transcribeDNATest() {
        CharQueue transcribed = testCodon.transcribeDNA("ABC");
        assertEquals('A', transcribed.dequeue());

        transcribed = testCodon.transcribeDNA("CAT");
        assertEquals('C', transcribed.dequeue());
        assertEquals('A',transcribed.dequeue());
        assertEquals('U',transcribed.dequeue());

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            CharQueue possibleError = testCodon.transcribeDNA("ERROR");
        });
    }
    @Test
    void translateRNATest() {
        CharQueue rna = testCodon.transcribeDNA("AUCAUGCGUUAGACC");
        CharQueue protein = testCodon.translateRNA(rna);
        assertEquals('M', protein.dequeue());
        assertEquals('R',protein.dequeue());
        assertEquals('*',protein.dequeue());

        rna = testCodon.transcribeDNA("AUG");
        protein = testCodon.translateRNA(rna);
        assertEquals('M', protein.dequeue());
        assertTrue(protein.isEmpty());

        rna = testCodon.transcribeDNA("CAUCAU");
        protein = testCodon.translateRNA(rna);
        assertTrue(protein.isEmpty());
    }
}