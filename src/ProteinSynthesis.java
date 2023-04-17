/*
    Name: Tianqi Zhang, Sadrac Santacruz Ibarra
    PID:  A17284671, A17420185
 */

/**
 * The ProteinSynthesis class has functionality to transcribe a string of DNA
 * into RNA and then translate RNA stored in a CharQueue into a protein.
 *
 * @author Tianqi Zhang, Sadrac Santacruz
 * @since 4/15/2023
 */
class ProteinSynthesis {
    /**
     * Transcribes a string of DNA stored in a String into RNA stored in a CharQueue.
     * @param dna the dna to transcribe
     * @return a CharQueue containing the corresponding RNA string
     */
    public CharQueue transcribeDNA(String dna){
        int length = dna.length();
        if (length % 3 != 0) throw new IllegalArgumentException();
        CharQueue dnaQue = new CharQueue(length);
        while (dna.length() != 0){
            if (dna.charAt(0) == 'T') dnaQue.enqueue('U');
            else dnaQue.enqueue(dna.charAt(0));
            dna = dna.substring(1);
        }
        return dnaQue;
    }

    /**
     * Translates the RNA into a protein stored in a CharQueue
     * @param rna The RNA to synthesize the protein with
     * @return the synthesized protein sequence
     */
    public CharQueue translateRNA(CharQueue rna){
        CharQueue protein = new CharQueue();
        StringBuilder codon = new StringBuilder();
        String startCodon = "AUG";
        while (rna.size() >= 3 & !codon.toString().equalsIgnoreCase(startCodon))
        {
            codon = new StringBuilder();
            for (int i = 0; i < 3; i++) {
                codon.append(rna.dequeue());
            }
        }
        if (codon.toString().equalsIgnoreCase(startCodon)) protein.enqueue('M');
        while(rna.size() >= 3){

            codon = new StringBuilder();
            for(int i = 0; i < 3; i++){
                codon.append(rna.dequeue());
            }
            char acid = CodonMap.getAminoAcid(codon.toString());
            protein.enqueue(acid);
            if (acid == '*') break;
        }
        return protein;
    }

}