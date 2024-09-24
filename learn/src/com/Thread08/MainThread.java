package com.Thread08;

public class MainThread {
    public static void main(String[] args) {
        BaoZi baoZi = new BaoZi();
        BaoZiPu baoZiPu = new BaoZiPu(baoZi);
        ChiHuo chiHuo = new ChiHuo(baoZi);
        baoZiPu.start();
        chiHuo.start();
    }
}
