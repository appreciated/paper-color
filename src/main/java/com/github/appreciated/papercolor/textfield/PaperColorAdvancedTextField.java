package com.github.appreciated.papercolor.textfield;


import com.github.appreciated.papercolor.PaperColorPickerAdvanced;
import com.vaadin.flow.component.HasValueAndElement;
import com.vaadin.flow.component.textfield.TextField;

public class PaperColorAdvancedTextField extends AbstractPaperColorTextField {
    public PaperColorAdvancedTextField() {
    }

    public PaperColorAdvancedTextField(String label) {
        super(label);
    }

    public PaperColorAdvancedTextField(String label, String placeholder) {
        super(label, placeholder);
    }

    public PaperColorAdvancedTextField(String label, String initialValue, String placeholder) {
        super(label, initialValue, placeholder);
    }

    public PaperColorAdvancedTextField(ValueChangeListener<? super ComponentValueChangeEvent<TextField, String>> listener) {
        super(listener);
    }

    public PaperColorAdvancedTextField(String label, ValueChangeListener<? super ComponentValueChangeEvent<TextField, String>> listener) {
        super(label, listener);
    }

    public PaperColorAdvancedTextField(String label, String initialValue, ValueChangeListener<? super ComponentValueChangeEvent<TextField, String>> listener) {
        super(label, initialValue, listener);
    }

    @Override
    HasValueAndElement<ValueChangeEvent<String>, String> getColorPickerInstance() {
        return new PaperColorPickerAdvanced();
    }

    @Override
    boolean hasSaveButton() {
        return true;
    }
}
