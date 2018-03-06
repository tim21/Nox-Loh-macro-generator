package lohgen.gen;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.logging.Level;
import java.util.logging.Logger;
import lohgen.Consts;
import lohgen.Main;

public class Generator {

    private ClickList list;

    public Generator(int delay) {
        list = new ClickList(delay);
    }

    public void generateList() {
        list.add(Consts.LIST_START[0]);
        list.delay(500);
        list.add(Consts.LIST_START[1]);
        generateHeroClicks();
        list.add(Consts.END_POINT);
    }

    public void printList() {
        list.print();
    }

    public void generateFile(String name) {
        try {
            Files.write(Paths.get(name), list, Charset.forName("UTF-8"));
        } catch (IOException ex) {
            Logger.getLogger(Generator.class.getName()).log(Level.SEVERE, "file error", ex);
        }
    }

    public void generateText() {
        generateFile(Consts.TEXT_FILE_NAME);
    }

    public void install() {
    }

    public void generateImport() {
//        String json = null;
//        try {
//            //File tmp_folder = new File(Consts.TMP_FOLDER_NAME);
//            //tmp_folder.mkdir();
//            json = new String(Files.readAllBytes(Paths.get("records")));
//        } catch (IOException ex) {
//            Logger.getLogger(Generator.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        Gson gson = new Gson();
//        HashMap records = gson.fromJson(json, HashMap.class);
//        Set keys = records.keySet();
//        for (Object key : keys.toArray()) {
//            System.out.println(key + " : " + records.get((String) key));
//        }
    }

    private void generateHeroClicks() {
        for (int cl = 0; cl < Consts.HERO_NAMES.length; cl++) {

            if (heroesSelectedInClass(cl)) {
                clickClass(cl);
                for (int h = 0; h < Consts.HERO_NAMES[cl].length; h++) {
                    if (heroSelected(cl, h)) {
                        clickHero(h);
                        clickSelect();
                    }
                }
            }
        }
    }

    private boolean heroesSelectedInClass(int cl) {
        for (int h = 0; h < Main.selected[cl].length; h++) {
            if (Main.selected[cl][h] == true) {
                return true;
            }
        }
        return false;
    }

    private void clickClass(int cl) {
        list.add(Consts.CLASS_CLICKPOINT[cl]);
    }

    private boolean heroSelected(int cl, int h) {
        return Main.selected[cl][h];
    }

    private void clickHero(int h) {
        list.add(Consts.HERO_CLICKPOINT[h]);
    }

    private void clickSelect() {
        list.add(Consts.SELECT_POINT);
    }
}
