package com.github.appreciated.papercolor.textfield;


import com.github.appreciated.papercolor.PaperColorPicker;
import com.vaadin.flow.component.HasValueAndElement;
import com.vaadin.flow.component.textfield.TextField;

public class PaperColorTextField extends AbstractPaperColorTextField {
    public PaperColorTextField() {
    }

    public PaperColorTextField(String label) {
        super(label);
    }

    public PaperColorTextField(String label, String placeholder) {
        super(label, placeholder);
    }

    public PaperColorTextField(String label, String initialValue, String placeholder) {
        super(label, initialValue, placeholder);
    }

    public PaperColorTextField(ValueChangeListener<? super ComponentValueChangeEvent<TextField, String>> listener) {
        super(listener);
    }

    public PaperColorTextField(String label, ValueChangeListener<? super ComponentValueChangeEvent<TextField, String>> listener) {
        super(label, listener);
    }

    public PaperColorTextField(String label, String initialValue, ValueChangeListener<? super ComponentValueChangeEvent<TextField, String>> listener) {
        super(label, initialValue, listener);
    }

    @Override
    HasValueAndElement<ValueChangeEvent<String>, String> getColorPickerInstance() {
        PaperColorPicker picker = new PaperColorPicker();
        picker.addClickListener(paperColorPickerClickEvent -> {
            setValue(picker.getValue());
            getDialog().close();
        });
        return picker;
    }

    @Override
    boolean hasSaveButton() {
        return false;
    }
}

