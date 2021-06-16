package kim.jaehoon.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;

import javax.inject.Singleton;
import java.util.Map;

@Singleton
@RequiredArgsConstructor
public class Encryptor {

    private final ObjectMapper objectMapper;

    public String encrypt(Object obj) {
        try {
            Map<String, Object> var1 = objectMapper.convertValue(obj, Map.class);
            if (var1 != null) {
                byte[] var2 = HexUtil.decodeHexString("8b3ce010a5728b3c19d76d0f529afb00");
                byte[] var3 = HexUtil.decodeHexString("6c4d6dc56ade4f24dcc36f7315d515c8");
                byte[] var4 = objectMapper.writeValueAsBytes(var1);
                var2 = KISA_SEED_CBC.SEED_CBC_Encrypt(var2, var3, var4, 0, var4.length);
                if (isCracked(HexUtil.toHexString(var2))) {
                    return var1.toString();
                } else {
                    return HexUtil.toHexString(var2);
                }
            } else {
                return "";
            }
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return "";
        }
    }

    public boolean isCracked(String var1) {
        byte[] var3 = HexUtil.decodeHexString("8b3ce010a5728b3c19d76d0f529afb00");
        byte[] var2 = HexUtil.decodeHexString("6c4d6dc56ade4f24dcc36f7315d515c8");
        byte[] var4 = HexUtil.decodeHexString(var1);
        return !(new String(KISA_SEED_CBC.SEED_CBC_Decrypt(var3, var2, var4, 0, var4.length))).startsWith("{");
    }

}
