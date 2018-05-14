/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui.components;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Component;
import java.awt.Font;
import java.util.UUID;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * @author hezj
 */
public interface ParentUI {
    JPanel getContainerJPanel();

    default boolean isTop(Component component) {
        JPanel containerJPanel = getContainerJPanel();
        if (containerJPanel.getComponentCount() <= 0) {
            return false;
        }

        int componentCount = containerJPanel.getComponentCount();
        Component topComponent = containerJPanel.getComponent(componentCount - 1);  // get the last Component

        for (Component c : ((JPanel) topComponent).getComponents()) {
            if (c.equals(component)) {
                return true;
            }
        }

        return false;
    }

    default void popComponent() {
        BiubiuBrowser.getInstance().browser.loadURL("about:blank");

        JPanel containerJPanel = getContainerJPanel();
        if (containerJPanel.getComponentCount() <= 0) {
            return;
        }

        containerJPanel.remove(containerJPanel.getComponentCount() - 1);
        ((CardLayout) containerJPanel.getLayout()).previous(containerJPanel);

        if (containerJPanel.getComponentCount() > 0) {
            int componentCount = containerJPanel.getComponentCount();
            Component component = containerJPanel.getComponent(componentCount - 1);  // get the last Component

            for (Component c : ((JPanel) component).getComponents()) {
                if (c instanceof ChildComponent) {
                    ((ChildComponent) c).exposed();
                }
            }

        }
        componentPoped();
    }

    default void componentPoped() {
    }

    default void pushComponent(Component component) {
        JPanel containerJPanel = getContainerJPanel();
        JPanel wrapper = new JPanel(new BorderLayout());

        wrapper.add(component, BorderLayout.CENTER);
        if (component instanceof HasTitle) {
            String title = ((HasTitle) component).getTitle();
            JLabel lblHeader = new JLabel(title, JLabel.CENTER);
            Font f = lblHeader.getFont();
            lblHeader.setFont(new Font(f.getName(), Font.BOLD, 30));

            wrapper.add(lblHeader, BorderLayout.PAGE_START);
        }

        containerJPanel.add(UUID.randomUUID().toString(), wrapper);
        ((CardLayout) containerJPanel.getLayout()).next(containerJPanel);

        componentPushed(wrapper);
    }

    default void componentPushed(Component component) {
    }

    default void popAllComponents() {
        JPanel containerJPanel = getContainerJPanel();
        containerJPanel.removeAll();
        ((CardLayout) containerJPanel.getLayout()).first(containerJPanel);

        allComponentsPoped();
    }

    default void allComponentsPoped() {
    }
}
