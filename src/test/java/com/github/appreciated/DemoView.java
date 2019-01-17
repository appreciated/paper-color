package com.github.appreciated;

import com.github.appreciated.papercolor.textfield.PaperColorAdvancedTextField;
import com.github.appreciated.papercolor.PaperColorPicker;
import com.github.appreciated.papercolor.PaperColorPickerAdvanced;
import com.github.appreciated.papercolor.textfield.PaperColorTextField;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

@Route("")
public class DemoView extends VerticalLayout {

    public DemoView() {
        add(new PaperColorTextField(),
                new PaperColorAdvancedTextField(),
                new PaperColorPicker(),
                new PaperColorPicker("#03a9f4"),
                new PaperColorPickerAdvanced(),
                new PaperColorPickerAdvanced("#03a9f4")
        );
    }
}
