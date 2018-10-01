import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.Random;

public class GenFolder {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        System.out.print("The folder and file will be created now. Press Enter to continue.");
        scn.nextLine();
        createFolder();
        System.out.println("Folder and file has been created. Press Enter to exit");
        scn.nextLine();

    }

    private static void createFolder(){
        String nameDir = createName();
        System.out.println("Name folder: "+ nameDir);
        //String path = "../../../";
        File dir = new File(nameDir);
        if (!dir.exists()) {
            try {
                boolean flag = dir.mkdir();
                if (flag)
                    System.out.println("Folder has been created");
            }
            catch (Exception ex) {
                System.out.println(ex.getMessage());
            }
            createTxt(nameDir);
        }
        else
            createFolder();
    }

    private static String createName() {
        Random gen = new Random();
        final String symbolsUP = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        final String symbolsLOW = symbolsUP.toLowerCase();
        final String digits = "1234567890";
        final String symbols = symbolsLOW + symbolsUP + digits;
        final int lenSymbs = symbols.length();
        int lengthName = gen.nextInt(10) + 10;
        String name= "";
        for (int i = 0; i < lengthName; i ++) {
            name += symbols.charAt(gen.nextInt(lenSymbs));
        }
        return name;
    }

    private static void createTxt(String nameDir) {
        String path = "./"+nameDir;
        String nameTxt = "toIgnore.txt";
        System.out.println("Name file: "+ nameTxt);
        File txt = new File(path, nameTxt);
        try {
            boolean flag = txt.createNewFile();
            if (flag)
                System.out.println("File has been created");
        }
        catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
}

