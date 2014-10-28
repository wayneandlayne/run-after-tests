package com.wayneandlayne.runaftertests;

import com.intellij.execution.testframework.AbstractTestProxy;
import com.intellij.execution.testframework.TestStatusListener;
import com.intellij.ide.util.PropertiesComponent;
import com.intellij.notification.Notification;
import com.intellij.notification.NotificationType;
import com.intellij.notification.Notifications;

import java.io.IOException;

public class MyTestStatusListener extends TestStatusListener{
    private PropertiesComponent properties;

    public MyTestStatusListener() {
        properties = PropertiesComponent.getInstance();

    }

    private void runCommand(String command) {
        if ("".equals(command)) {
            Notifications.Bus.notify(new Notification("wnl", "Run After Tests", "Would have ran a command, if it were configured.", NotificationType.INFORMATION));
        } else
            Notifications.Bus.notify(new Notification("wnl", "Run After Tests", "Running command: " + command, NotificationType.INFORMATION));
        try {
            Process proc = Runtime.getRuntime().exec(command);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private void runPassCommand() {
        String passCommand = properties.getValue("com.wayneandlayne.runaftertests.passcommand");
        runCommand(passCommand);
    }

    private void runFailCommand() {
        String failCommand = properties.getValue("com.wayneandlayne.runaftertests.failcommand");
        runCommand(failCommand);
    }

    @Override
    public void testSuiteFinished(AbstractTestProxy root) {
        long testsRun = 0;
        long testsSucceeded = 0;

        for (AbstractTestProxy test : root.getAllTests()) {
            if(test.isLeaf()) {
                testsRun++;

                if(test.isPassed()) {
                    testsSucceeded++;
                }
            }
        }

        if (testsRun == testsSucceeded)
        {
            runPassCommand();
        } else
        {
            runFailCommand();
        }
    }
}