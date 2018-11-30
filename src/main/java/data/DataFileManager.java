package data;

import config.Config;

import java.io.FileWriter;
import java.io.IOException;

public final class DataFileManager {
    private static final String DATA_FILE_PATH = Config.DATA_PATH + "data.txt";

    synchronized public static void append2DataFile(String content) {
        FileWriter writer = null;
        try {
            writer = new FileWriter(DATA_FILE_PATH, true);
            writer.write(content);
            writer.write('\n');
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            try {
                writer.flush();
                writer.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }
}
