package com.github.appreciated.papercolor;

import com.vaadin.flow.component.*;
import com.vaadin.flow.component.dependency.HtmlImport;
import com.vaadin.flow.shared.Registration;

@Tag("l2t-paper-color-advanced")
@HtmlImport("bower_components/l2t-paper-color/l2t-paper-color-advanced.html")
public class PaperColorPickerAdvanced extends Component implements HasComponents, HasValueAndElement<HasValue.ValueChangeEvent<String>, String> {

    public PaperColorPickerAdvanced() {
        getElement().synchronizeProperty("color", "color-changed");
    }

    public PaperColorPickerAdvanced(String color) {
        this();
        setValue(color);
    }

    @Override
    public void setValue(String color) {
        getElement().setProperty("color", color);
    }

    @Override
    public String getValue() {
        return getElement().getProperty("color");
    }

    @Override
    public Registration addValueChangeListener(ValueChangeListener<? super ValueChangeEvent<String>> valueChangeListener) {
        return getElement().addPropertyChangeListener("color", propertyChangeEvent -> valueChangeListener.valueChanged(new ValueChangeEvent<String>() {
            @Override
            public HasValue<?, String> getHasValue() {
                return PaperColorPickerAdvanced.this;
            }

            @Override
            public boolean isFromClient() {
                return true;
            }

            @Override
            public String getOldValue() {
                return (String) propertyChangeEvent.getOldValue();
            }

            @Override
            public String getValue() {
                return (String) propertyChangeEvent.getValue();
            }
        }));
    }
}
