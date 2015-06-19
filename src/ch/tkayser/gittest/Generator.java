package ch.tkayser.gittest;

import java.io.File;
import java.io.FileWriter;
import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.StringTokenizer;

/**
 * Created by Tom on 19.06.2015.
 */
public class Generator {

    public static void main(String[] args) throws Exception {
        if (args.length != 3) {
            System.out.println("Generator  <outputDir> <package>  <nrOfFeatures>");
            System.exit(1);
        }

        String outputDir = args[0];
        String pkgName = args[1];
        Integer features = Integer.parseInt(args[2]);

        createOutputDir(outputDir, pkgName);

        URI filePath = Generator.class.getClassLoader().getResource("pattern.txt").toURI();
        for (int i = 0; i < features; i++) {
            String featureNr = String.valueOf(i+1);
            String text = new String(Files.readAllBytes(Paths.get(filePath)));
            text = text.replace("<<PACKAGE>>", pkgName);
            text = text.replace("<<FEATURE>>", featureNr);

            File packageDir = new File(outputDir+"/"+pkgName.replaceAll("\\.","/")+"/Feature"+featureNr+".java");
            FileWriter writer = new FileWriter(packageDir);
            writer.write(text);
            writer.close();
        }



    }

    private static void createOutputDir(String outputDir, String packageName) {
        File root = new File(outputDir);
        root.mkdir();
        StringTokenizer tokens = new StringTokenizer(packageName, ".");

        File currentDir = root;
        while (tokens.hasMoreElements()) {
            String folder = tokens.nextToken();
            File packageDir = new File(currentDir, folder);
            packageDir.mkdir();
            currentDir = packageDir;
        }



    }
}
