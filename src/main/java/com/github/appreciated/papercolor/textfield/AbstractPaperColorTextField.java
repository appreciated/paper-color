package com.github.appreciated.papercolor.textfield;

import com.vaadin.flow.component.AbstractField;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.HasValue;
import com.vaadin.flow.component.HasValueAndElement;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;

abstract public class AbstractPaperColorTextField extends TextField {
    private String saveButtonString = "Save";
    private Dialog dialog;

    public AbstractPaperColorTextField() {
        super();
        init();
    }

    public AbstractPaperColorTextField(String label) {
        super(label);
        init();
    }

    public AbstractPaperColorTextField(String label, String placeholder) {
        super(label, placeholder);
        init();
    }

    public AbstractPaperColorTextField(String label, String initialValue, String placeholder) {
        super(label, initialValue, placeholder);
        init();
    }

    public AbstractPaperColorTextField(HasValue.ValueChangeListener<? super AbstractField.ComponentValueChangeEvent<TextField, String>> listener) {
        super(listener);
        init();
    }

    public AbstractPaperColorTextField(String label, HasValue.ValueChangeListener<? super AbstractField.ComponentValueChangeEvent<TextField, String>> listener) {
        super(label, listener);
        init();
    }

    public AbstractPaperColorTextField(String label, String initialValue, HasValue.ValueChangeListener<? super AbstractField.ComponentValueChangeEvent<TextField, String>> listener) {
        super(label, initialValue, listener);
        init();
    }

    protected void init() {
        Button suffixButton = new Button(VaadinIcon.PAINTBRUSH.create());
        suffixButton.getElement().setAttribute("theme", "tertiary");
        suffixButton.addClickListener(event -> {
            VerticalLayout layout = new VerticalLayout();
            layout.setMargin(false);
            layout.setPadding(false);
            dialog = new Dialog(layout);
            HasValueAndElement<HasValue.ValueChangeEvent<String>, String> paperColorPicker = getColorPickerInstance();
            if (getValue() != null) {
                paperColorPicker.setValue(getValue());
            }
            paperColorPicker.addValueChangeListener(stringValueChangeEvent -> {
            });
            HorizontalLayout buttons = new HorizontalLayout(
                    new Button(saveButtonString, buttonClickEvent -> {
                        AbstractPaperColorTextField.this.setValue(paperColorPicker.getValue());
                        dialog.close();
                    })
            );
            buttons.setJustifyContentMode(FlexComponent.JustifyContentMode.END);
            buttons.setWidth("100%");
            layout.add((Component) paperColorPicker);
            if (hasSaveButton()) {
                layout.add(buttons);
            }
            dialog.open();
        });
        setSuffixComponent(suffixButton);
    }

    public Dialog getDialog() {
        return dialog;
    }

    public void setSaveButtonString(String saveButtonString) {
        this.saveButtonString = saveButtonString;
    }

    public String getSaveButtonString() {
        return saveButtonString;
    }

    abstract HasValueAndElement<HasValue.ValueChangeEvent<String>, String> getColorPickerInstance();

    abstract boolean hasSaveButton();
}
