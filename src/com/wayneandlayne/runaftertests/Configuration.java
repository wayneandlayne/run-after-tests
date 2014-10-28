package com.wayneandlayne.runaftertests;


import com.intellij.ide.ui.LafManager;
import com.intellij.ide.ui.UISettings;
import com.intellij.ide.util.PropertiesComponent;
import com.intellij.notification.Notification;
import com.intellij.notification.NotificationType;
import com.intellij.notification.Notifications;
import com.intellij.openapi.options.Configurable;

import javax.swing.*;


public class Configuration implements Configurable {
    private JComponent myComponent;
    private JPanel myPanel;
    private JTextField passTextField;
    private JTextField failTextField;

    public String getDisplayName() {
        return "Run After Tests";
    }

    public boolean isModified() {
        return true;
    }

    public JComponent createComponent() {
        myComponent = (JComponent) myPanel;
        return myComponent;
    }

    public void apply() {
        //Notifications.Bus.notify(new Notification("wnl", "Run After Tests", "Applying!", NotificationType.INFORMATION));

        PropertiesComponent properties = PropertiesComponent.getInstance();
        String passCommand = passTextField.getText();
        String failCommand = failTextField.getText();
        properties.setValue("com.wayneandlayne.runaftertests.passcommand", passCommand);
        properties.setValue("com.wayneandlayne.runaftertests.failcommand", failCommand);
    }

    public void disposeUIResources() {
        myComponent = null;
    }

    public String getHelpTopic() {
        return "";
    }

    public void reset() {
        PropertiesComponent properties = PropertiesComponent.getInstance();
        properties.setValue("com.wayneandlayne.runaftertests.passcommand", "");
        properties.setValue("com.wayneandlayne.runaftertests.failcommand", "");
        passTextField.setText("");
        failTextField.setText("");
    }
}
