/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui.components;

import com.teamdev.jxbrowser.chromium.Browser;
import com.teamdev.jxbrowser.chromium.swing.BrowserView;

/**
 *
 * @author hezj
 */
public class BiubiuBrowser {
    private static BiubiuBrowser biubiuBrowser = new BiubiuBrowser();
    public Browser browser;
    public BrowserView view;

    private BiubiuBrowser() {
        browser = new Browser();
        browser.loadURL("about:blank");
        view = new BrowserView(browser);
        browser.setPopupHandler(e -> null);
    }

    public static BiubiuBrowser getInstance() {
        return biubiuBrowser;
    }
}
