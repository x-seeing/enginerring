package com.see.misc.common.utils

import org.apache.commons.codec.binary.Hex

/**
 * Created by suyaqiang (sueeing@126.com) on 2019/1/20.
 */
class HexUtil {

    static byte[] hexString2Bytes(String hex) {
        Hex.decodeHex(hex)
    }

}
