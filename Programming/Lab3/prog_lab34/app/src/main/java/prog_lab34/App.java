package prog_lab34;

import prog_lab34.parsingconfigfile.FileObjProvider;
import prog_lab34.parsingconfigfile.SimpleObjProvider;
import prog_lab34.interaction.Interaction;

import prog_lab34.argparser.ArgParser;

public class App {


    public static void main(String[] args) {

        try {
            ArgParser parser = new ArgParser(args);
            Interaction interaction;

            if (parser.getArgument("provider") != null && parser.getArgument("provider").equals("simple")
                || parser.getArgument("p") != null && parser.getArgument("p").equals("s")) {

                interaction = new Interaction(new SimpleObjProvider());
                System.out.println(interaction.startInteraction());
            } else {
                interaction = new Interaction(new FileObjProvider());
                if (parser.getArgument("input") != null) {
                    System.out.println(interaction.startInteraction(parser.getArgument("input")));
                } else {
                    System.out.println(interaction.startInteraction(parser.getArgument("i")));
                }
                
            }
        } catch (IllegalArgumentException e) {
            System.err.println(e.getMessage());
        }

    }
}
