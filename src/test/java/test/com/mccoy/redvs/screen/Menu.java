/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test.com.mccoy.redvs.screen;

import java.awt.List;
import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author rmccoy
 */
public class Menu implements Screen {
private String name;
private String desc;
private ArrayList<Screen> children = new ArrayList<>();

    public Menu(String name, String desc) {
        this.name = name;
        this.desc = desc;
    }

public void addChild(Screen screen) {
    children.add(screen);
}
    
    @Override
    public void paint() {
        System.out.println(String.format("MENU: %s --- %s", name, desc));
        if(children.size() > 0) {
            System.out.println("Children --- ");
            for (Iterator<Screen> iterator = children.iterator(); iterator.hasNext();) {
                Screen next = iterator.next();
                next.paint();
            }
        }
    }
    
}
