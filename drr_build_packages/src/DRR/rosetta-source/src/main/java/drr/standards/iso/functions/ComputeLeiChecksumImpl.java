package drr.standards.iso.functions;

public class ComputeLeiChecksumImpl extends ComputeLeiChecksum {

    @Override
    protected String doEvaluate(String lei18) {
        if (lei18 == null) {
            return null;
        }
        // Convert each character to its numeric representation.
        // The result is built as a string of decimal digits.
        StringBuilder numeric = new StringBuilder(36); // each letter becomes two digits
        for (char c : lei18.toCharArray()) {
            if (c >= '0' && c <= '9') {
                numeric.append(c);
            } else {
                numeric.append(Character.getNumericValue(c));
            }
        }
        // Append the two zeros required by the algorithm.
        numeric.append("00");
        // Compute (numericString mod 97) using a streaming remainder
        // to avoid overflow of the intermediate value.
        int remainder = 0;
        for (int i = 0; i < numeric.length(); i++) {
            char digitChar = numeric.charAt(i);
            int digit = digitChar - '0';
            remainder = (remainder * 10 + digit) % 97;
        }
        int check = 98 - remainder;
        return (check < 10 ? "0" : "") + check;
    }
}
