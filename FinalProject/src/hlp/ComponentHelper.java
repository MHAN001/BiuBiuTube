package hlp;

import java.awt.*;

public class ComponentHelper {

    public static void setComponentSize(Component c, int width, int height) {
        setComponentSize(c, new Dimension(width, height));
    }

    public static void setComponentSize(Component c, Dimension d) {
        c.setPreferredSize(d);
        c.setMaximumSize(d);
        c.setMinimumSize(d);
    }
}
