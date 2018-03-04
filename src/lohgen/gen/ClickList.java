package lohgen.gen;

import java.util.ArrayList;
import lohgen.Consts;

class ClickList extends ArrayList<String> {

    private int delay;
    private int time;

    public ClickList(int delay) {
        super();
        this.delay = delay;
        this.time = delay;
    }

    public void add(ClickPoint click) {
        String sep = "ScRiPtSePaRaToR";
        String start = "0" + sep + Consts.RES_X + "|" + Consts.RES_Y + "|";
        String com1 = "MULTI:1:0:" + click.getX() + ":" + click.getY() + sep + time;
        String com2 = "MULTI:0:1" + sep + (time + delay / 2);
        String com3 = "MSBRL:-1507396:-1730873" + sep + (time + delay / 2);
        String line1 = start + com1;
        String line2 = start + com2;
        String line3 = start + com3;
        add(line1);
        add(line2);
        add(line3);
        delay(delay);
    }

    public void add(ClickPoint[] pointList) {
        for (ClickPoint point : pointList) {
            add(point);
        }
    }

    public void print() {
        this.forEach((line) -> {
            System.out.println(line);
        });
    }

    public void delay(int t) {
        time += t;
    }
}
