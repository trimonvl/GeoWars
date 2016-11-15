/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.howest.groep12.geowars.Settings;

import java.io.File;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Jonas Lauwers
 */
public class SoundSettingsTest {
    
    String testdir = "test/test";

    @Test
    public void testSomeMethod() {
        File dir = new File(testdir);
        if(!dir.exists()) {
            dir.mkdir();
            System.out.println("dir created");
        }
        SoundSettings test = SoundSettings.load(testdir);
        System.out.println(test.getMusicOn());
        System.out.println(test.getMusicVolume());
        test.setSfxVolume(80);
    }
    
}
