package com.usbDemo;

public class Main {
    public static void main(String[] args) {
        Computer computer = new Computer();

        KeyBoard keyBoard = new KeyBoard();
        Mouse mouse = new Mouse();

        computer.useDevice(keyBoard);

    }
}
