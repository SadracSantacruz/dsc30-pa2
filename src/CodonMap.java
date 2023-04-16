

import java.util.HashMap;
class CodonMap{
    public static Character getAminoAcid(String codon) {
    HashMap<String, Character> codonTable = new HashMap<>();
    codonTable.put("UUU", 'F');
    codonTable.put("UUC", 'F');
    codonTable.put("UUA", 'L');
    codonTable.put("UUG", 'L');
    codonTable.put("UCU", 'S');
    codonTable.put("UCC", 'S');
    codonTable.put("UCA", 'S');
    codonTable.put("UCG", 'S');
    codonTable.put("UAU", 'Y');
    codonTable.put("UAC", 'Y');
    codonTable.put("UAA", '*');
    codonTable.put("UAG", '*');
    codonTable.put("UGU", 'C');
    codonTable.put("UGC", 'C');
    codonTable.put("UGA", '*');
    codonTable.put("UGG", 'W');
    codonTable.put("CUU", 'L');
    codonTable.put("CUC", 'L');
    codonTable.put("CUA", 'L');
    codonTable.put("CUG", 'L');
    codonTable.put("CCU", 'P');
    codonTable.put("CCC", 'P');
    codonTable.put("CCA", 'P');
    codonTable.put("CCG", 'P');
    codonTable.put("CAU", 'H');
    codonTable.put("CAC", 'H');
    codonTable.put("CAA", 'Q');
    codonTable.put("CAG", 'Q');
    codonTable.put("CGU", 'R');
    codonTable.put("CGC", 'R');
    codonTable.put("CGA", 'R');
    codonTable.put("CGG", 'R');
    codonTable.put("AUU", 'I');
    codonTable.put("AUC", 'I');
    codonTable.put("AUA", 'I');
    codonTable.put("AUG", 'M');
    codonTable.put("ACU", 'T');
    codonTable.put("ACC", 'T');
    codonTable.put("ACA", 'T');
    codonTable.put("ACG", 'T');
    codonTable.put("AAU", 'N');
    codonTable.put("AAC", 'N');
    codonTable.put("AAA", 'K');
    codonTable.put("AAG", 'K');
    codonTable.put("AGU", 'S');
    codonTable.put("AGC", 'S');
    codonTable.put("AGA", 'R');
    codonTable.put("AGG", 'R');
    codonTable.put("GUU", 'V');
    codonTable.put("GUC", 'V');
    codonTable.put("GUA", 'V');
    codonTable.put("GUG", 'V');
    codonTable.put("GCU", 'A');
    codonTable.put("GCC", 'A');
    codonTable.put("GCA", 'A');
    codonTable.put("GCG", 'A');
    codonTable.put("GAU", 'D');
    codonTable.put("GAC", 'D');
    codonTable.put("GAA", 'E');
    codonTable.put("GAG", 'E');
    codonTable.put("GGU", 'G');
    codonTable.put("GGC", 'G');
    codonTable.put("GGA", 'G');
    codonTable.put("GGG", 'G');
    return codonTable.get(codon);
}
    public CharQueue transcribeDNA(String dna){
        int length = dna.length();
        if (length % 3 != 0) throw new IllegalArgumentException();
        CharQueue dnaQue = new CharQueue(length);
        while (dna.length() != 0){
//            System.out.println("firstchar: "+ dna.charAt(0));
            if (dna.charAt(0) == 'T') dnaQue.enqueue('U');
            else dnaQue.enqueue(dna.charAt(0));
            dna = dna.substring(1);
//            System.out.println("dna: "+dna);
//            System.out.println(dnaQue.peek());
        }
        return dnaQue;
    }

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
            char acid = getAminoAcid(codon.toString());
            protein.enqueue(acid);
            if (acid == '*') break;
        }
        return protein;
    }
}