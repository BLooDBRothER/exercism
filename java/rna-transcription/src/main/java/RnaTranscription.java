import java.util.HashMap;
import java.util.Map;

class RnaTranscription {
    Map<Character, Character> dnaRnaMap = new HashMap<>();

    public RnaTranscription() {
        dnaRnaMap.put('G', 'C');
        dnaRnaMap.put('C', 'G');
        dnaRnaMap.put('T', 'A');
        dnaRnaMap.put('A', 'U');
    }

    String transcribe(String dnaStrand) {
        StringBuilder rnaStrand = new StringBuilder();
        for(int idx=0; idx<dnaStrand.length(); idx++){
            rnaStrand.append(dnaRnaMap.get(dnaStrand.charAt(idx)));
        }

        return rnaStrand.toString();
    }

}
