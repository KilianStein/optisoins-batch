package ki.optisoins.utils;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileUtils {


    public static String createDirIfNotExist(String dir) throws IOException {
        Path path = Paths.get(dir);
        if (!Files.isReadable(path) || !Files.isDirectory(path)) {
            Files.createDirectory(path);
        }
        return dir;
    }

}
