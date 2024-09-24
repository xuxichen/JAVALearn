package com.usbDemo;

public class Computer {
    public void powerOn() {
        System.out.println("笔记本电脑关机");
    }

    public void powerOff() {
        System.out.println("笔记本电脑关机");
    }

    public void useDevice(USB usb) {
        usb.open();
        if (usb instanceof KeyBoard) {
            ((KeyBoard) usb).input();
        }
        if (usb instanceof Mouse) {
            ((Mouse) usb).click();
        }
    }

    public void shotDownDevice(USB usb){
        usb.close();

    }
}
