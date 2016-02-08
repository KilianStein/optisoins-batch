package ki.optisoins.utils;

import ki.optisoins.OptiSoinsConfiguration;
import ki.optisoins.log.OptiSoinsLogger;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

public class FileUtils {

  public static String deleteDir(String dir) throws IOException {
    Path path = Paths.get(dir);
    if (Files.isReadable(path) && Files.isDirectory(path)) {
      OptiSoinsLogger.printTrace("Suppression du dossier '" + dir + "'");
      removeRecursive(path);
    }
    return dir;
  }

  public static void removeRecursive(Path path) throws IOException {
    Files.walkFileTree(path, new SimpleFileVisitor<Path>() {
      @Override
      public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        Files.delete(file);
        return FileVisitResult.CONTINUE;
      }

      @Override
      public FileVisitResult visitFileFailed(Path file, IOException exc) throws IOException {
        Files.delete(file);
        return FileVisitResult.CONTINUE;
      }

      @Override
      public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {
        if (exc == null) {
          Files.delete(dir);
          return FileVisitResult.CONTINUE;
        } else {
          throw exc;
        }
      }
    });
  }

  public static Path createDirIfNotExist(String dir) {
    Path path = Paths.get(dir);
    if (!Files.isReadable(path) || !Files.isDirectory(path)) {
      OptiSoinsLogger.printTrace("Création du dossier '" + dir + "'");
      try {
        Files.createDirectory(path);
      } catch (IOException e) {
        OptiSoinsLogger.printError("Erreur lors de la création du dossier '" + dir + "'");
        throw new RuntimeException(e);
      }
    }
    return path;
  }

  public static boolean isDirEmpty(Path directory) throws IOException {
    try (DirectoryStream<Path> dirStream = Files.newDirectoryStream(directory)) {
      return !dirStream.iterator().hasNext();
    }
  }

  public static void copyRessourceIfNotExist(String fichier, String target) throws IOException {
    if (!Files.exists(Paths.get(target))) {
      OptiSoinsLogger.printTrace("Copie de la ressource " + fichier);
      Files.copy(Thread.currentThread().getContextClassLoader().getResourceAsStream(fichier), Paths.get(target));
    }
  }
}