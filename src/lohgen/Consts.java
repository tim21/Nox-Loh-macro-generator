package lohgen;

import java.awt.Color;
import java.nio.file.Path;
import java.nio.file.Paths;
import javax.swing.BorderFactory;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;
import lohgen.gen.ClickPoint;

public class Consts {

    public static final String NAME = "Nox LoH macro generator";
    public static final String VERSION = "0.3.0";

    public static final int RES_X = 1280;
    public static final int RES_Y = 720;
    public static final int INIT_DELAY = 500;

    public static final Path FILENAME = Paths.get("generated macro.txt");

    public static final Border BORDER_BLACKLINE1 = BorderFactory.createLineBorder(Color.black);
    public static final Border BORDER_BLACKLINE2 = BorderFactory.createLineBorder(Color.black, 2);
    public static final Border BORDER_ETCHEDLINE = BorderFactory.createEtchedBorder(EtchedBorder.LOWERED);

    public static final String[] CLASSES = {"Knight", "Warrior", "Assasin", "Archer", "Mechanic", "Wizard", "Priest"};

    public static final String[][] HERO_NAMES = {
        {"Phillop", "Clause", "Demia", "Morrah", "Jane", "Ricardo", "Sonia"},
        {"Kasel", "Gau", "Naila", "Theo", "Viska", "Priscilla", "Scarlet"},
        {"Roi", "Epis", "Reina", "Fluss", "Tanya", "Ezekiel", "Mirianne", "Gladi"},
        {"Selene", "Dimael", "Luna", "Arch", "Yanne", "Requina"},
        {"Lakrak", "Miruru", "Rodina", "Annette", "Mitra", "Oddy"},
        {"Cleo", "Maria", "Lorraine", "Pavel", "Aisha", "Lewisia", "Nyx", "Ophelia", "Artemia"},
        {"Frey", "Kaulah", "Rephy", "Baudouin", "Leo", "Laias", "Cassandra", "Mediana", "May"}
    };

    public final static ClickPoint SELECT_POINT = new ClickPoint(878, 717);
    private final static ClickPoint FIRST_CLASS_POINT = new ClickPoint(500, 150);
    private final static ClickPoint FIRST_HERO_POINT = new ClickPoint(349, 204);

    private final static int CLASS_NEXT_X = 73;
    private final static int HERO_NEXT_X = 105;
    private final static int HERO_NEXT_Y = 105;

    public final static ClickPoint[] LIST_START = new ClickPoint[2];

    static {
        LIST_START[0] = new ClickPoint(1138, 660);
        LIST_START[1] = new ClickPoint(934, 511);
    }

    public final static ClickPoint END_POINT = new ClickPoint(1240, 615);

    public final static ClickPoint[] CLASS_CLICKPOINT = new ClickPoint[CLASSES.length];

    static {
        for (int cl = 0; cl < CLASSES.length; cl++) {
            CLASS_CLICKPOINT[cl] = new ClickPoint(FIRST_CLASS_POINT.getX() + cl * CLASS_NEXT_X, FIRST_CLASS_POINT.getY());
        }
    }

    private final static int MAX_HEROES;

    static {
        int max = 0;
        for (int cl = 0; cl < CLASSES.length; cl++) {
            if (HERO_NAMES[cl].length > max) {
                max = HERO_NAMES[cl].length;
            }
        }
        MAX_HEROES = max;
    }

    public final static ClickPoint[] HERO_CLICKPOINT = new ClickPoint[MAX_HEROES];

    static {
        for (int h = 0; h < MAX_HEROES; h++) {
            HERO_CLICKPOINT[h] = new ClickPoint(FIRST_HERO_POINT.getX() + (h % 6) * HERO_NEXT_X, FIRST_HERO_POINT.getY() + (h / 6) * HERO_NEXT_Y);
        }
    }
}
