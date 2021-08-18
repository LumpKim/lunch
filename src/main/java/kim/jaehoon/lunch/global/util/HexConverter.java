package kim.jaehoon.lunch.global.util;

public class HexConverter {

    private static byte decodeHexChar(char var0) {
        int var2;
        if (var0 >= '0' && var0 <= '9') {
            var2 = var0 - 48;
        } else {
            byte var1 = 97;
            if (var0 < 'a' || var0 > 'f') {
                var1 = 65;
                if (var0 < 'A' || var0 > 'F') {
                    return 0;
                }
            }
            var2 = var0 - var1 + 10;
        }
        return (byte) var2;
    }

    public static byte[] decodeHexString(String var0) {
        if (var0 == null) {
            return null;
        } else {
            byte[] var3 = new byte[var0.length() / 2];
            for (int var1 = 0; var1 < var3.length; ++var1) {
                int var2 = var1 * 2;
                var3[var1] = (byte) (decodeHexChar(var0.charAt(var2)) * 16);
                var3[var1] += decodeHexChar(var0.charAt(var2 + 1));
            }
            return var3;
        }
    }

    public static String toBitString(byte var0) {
        StringBuilder var2 = new StringBuilder();
        for (int var1 = 7; var1 >= 0; --var1) {
            var2.append(var0 >>> var1 & 1);
        }
        return var2.toString();
    }

    public static String toBitString(int var0) {
        StringBuilder var2 = new StringBuilder();
        for (int var1 = 31; var1 >= 0; --var1) {
            var2.append(var0 >>> var1 & 1);
        }
        return var2.toString();
    }

    public static void toBytes(long var0, byte[] var2, int var3, int var4) {
        if (var4 <= 0) {
            throw new IllegalArgumentException("len should be positive integer");
        } else {
            int var5 = var4 + var3 - 1;
            for (var4 = 0; var5 >= var3; var4 += 8) {
                var2[var5] = (byte) ((int) (var0 >>> var4 & 255L));
                --var5;
            }
        }
    }

    public static String toHexString(byte[] var0) {
        return var0 == null ? null : toHexString(var0, 0, var0.length, 0);
    }

    public static String toHexString(byte[] var0, int var1, int var2, int var3) {
        if (var0 == null) {
            return null;
        } else {
            int var4 = var0.length;
            int var5 = var1 + var2;
            if (var4 >= var5) {
                StringBuilder var6 = new StringBuilder();
                for (var4 = 0; var1 < var5; ++var1) {
                    var6.append(String.format("%02x", var0[var1]));
                    ++var4;
                    if (var4 != var2 && var3 != 0 && var4 % var3 == 0) {
                        var6.append(" ");
                    }
                }
                return var6.toString();
            } else {
                throw new IllegalArgumentException("buffer length is not enough");
            }
        }
    }

    public static String toHexString(int[] var0) {
        if (var0 == null) {
            return null;
        } else {
            StringBuilder var3 = new StringBuilder();
            int var2 = var0.length;
            for (int i : var0) {
                var3.append(String.format("%08x", i));
                var3.append("  ");
            }
            return var3.toString();
        }
    }

}
