package com.see.core
/**
 * Created by suyaqiang (sueeing@126.com) on 2019/1/20.
 */
class SpoilsWriter {

    static final String DEFAULT_PATH = '/spoils/'

    static PrintWriter getW(name, file) {
        def path = (DEFAULT_PATH + name + File.separator) as File
        if (!path.exists()) {
            path.mkdirs()
        }
        def f = (path.getAbsolutePath() + File.separator + file) as File
        if (!f.exists()) {
            f.createNewFile()
        }

        new FileWriter(f).newPrintWriter()
    }


}
