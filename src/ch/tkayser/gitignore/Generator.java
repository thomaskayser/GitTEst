package ch.tkayser.gitignore;

import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Paths;

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
        String pckgName = args[1];
        Integer features = Integer.parseInt(args[2]);

        URI filePath = Generator.class.getClassLoader().getResource("pattern.txt").toURI();
        for (int i = 0; i < features; i++) {
            String text = new String(Files.readAllBytes(Paths.get(filePath)));
            text = text.replace("<<PACKAGE>>", pckgName);
            text = text.replace("<<FEATURE>>", String.valueOf(i+1));
            System.out.println(text);
        }



    }
}
