package com.company;
import org.apache.commons.io.FilenameUtils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;

public class Main {

    private static BufferedImage resize(BufferedImage img, int x, int y) {
        Image tmp = img.getScaledInstance(x, y, Image.SCALE_SMOOTH);
        BufferedImage resized = new BufferedImage(x, y, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2d = resized.createGraphics();
        g2d.drawImage(tmp, 0, 0, null);
        g2d.dispose();
        return resized;
    }


    public static void main(String[] args) throws IOException {
        System.out.println("Path");
        Scanner sc = new Scanner(System.in);
        String path = sc.nextLine();
        File folder = new File(path);
        File[] filelist = folder.listFiles();
        String[] fls = new String[filelist.length];
        for (int i = 0; i < filelist.length; i++) {
            if (filelist[i].isFile()) {
                fls[i] = filelist[i].getName();
            }
        }
        ArrayList<String> toConvert = new ArrayList<>();
        for (int j = 0; j < fls.length; j++) {
            String rash = FilenameUtils.getExtension(fls[j]);
            if(rash.equals("png")){toConvert.add(fls[j]);}
        }
        String[] convertate = new String[toConvert.size()];
        for (int c = 0; c <convertate.length ; c++) {
            convertate[c] = toConvert.get(c);
        }

            System.out.println("new Width");
            int x = sc.nextInt();
            System.out.println("new Height");
            int y = sc.nextInt();
String izmpath = sc.nextLine();
        for (int v = 0; v <convertate.length ; v++) {
            File input = new File(path+"/"+convertate[v]);
            BufferedImage image = ImageIO.read(input);

            BufferedImage resized = resize(image, x, y);

            File output = new File(izmpath+convertate[v]);
            ImageIO.write(resized, "png", output);
System.out.println("resized:"+convertate[v]);

        }
System.out.println("DONE");

        }
    }


