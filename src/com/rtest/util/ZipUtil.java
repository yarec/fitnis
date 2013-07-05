package com.rtest.util;


import com.gargoylesoftware.htmlunit.UnexpectedPage;

import java.io.*;
import java.util.Enumeration;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

public class ZipUtil {
        public static void writeToFile(InputStream is, File file) {
        try {
            DataOutputStream out = new DataOutputStream(new BufferedOutputStream(new FileOutputStream(file)));
            int c;
            while ((c = is.read()) != -1) {
                out.writeByte(c);
            }
            is.close();
            out.close();
        }
        catch (IOException e) {
            System.err.println("Error Writing/Reading Streams.");
        }
    }

    InputStream String2InputStream(String str) {
        ByteArrayInputStream stream = new ByteArrayInputStream(str.getBytes());
        return stream;
    }

    static String inputStream2String(InputStream is) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(is));
        StringBuffer buffer = new StringBuffer();
        String line = "";
        while ((line = in.readLine()) != null) {
            buffer.append(line);
        }
        return buffer.toString();
    }

    public synchronized static String unzipStream(UnexpectedPage unExpectedPage) {
        String ret_text = "";
        try {
            String tmpzip = "tmp.zip";
            writeToFile(unExpectedPage.getInputStream(), new File(tmpzip));

            ZipFile zipFile = new ZipFile(new File(tmpzip));
            Enumeration emu = zipFile.entries();
            while (emu.hasMoreElements()) {
                ZipEntry entry = (ZipEntry) emu.nextElement();
                ret_text = inputStream2String(zipFile.getInputStream(entry));
            }
            new File(tmpzip).deleteOnExit();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return ret_text;
    }
}
