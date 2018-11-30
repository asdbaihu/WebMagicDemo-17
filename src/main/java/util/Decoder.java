package util;

public final class Decoder {
    public static String convert(String asciicode) {
        String[] asciis = asciicode.split ("\\\\u");
        StringBuilder nativeValue = new StringBuilder(asciis[0]);
        try {
            for ( int i = 1; i < asciis.length; i++ ) {
                String code = asciis[i];
                nativeValue.append((char) Integer.parseInt(code.substring(0, 4), 16));
                if (code.length () > 4) {
                    nativeValue.append(code.substring(4));
                }
            }
        } catch (NumberFormatException e) {
            return asciicode;
        }
        return nativeValue.toString();
    }
}
