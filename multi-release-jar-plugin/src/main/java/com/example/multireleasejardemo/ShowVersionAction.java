/*
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for license information.
 */

package com.example.multireleasejardemo;

import com.example.DefaultVersion;
import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.application.ApplicationManager;
import com.intellij.openapi.diagnostic.Logger;
import com.intellij.openapi.ui.MessageDialogBuilder;
import org.jetbrains.annotations.NotNull;

public class ShowVersionAction extends AnAction {

    public static final @NotNull Logger LOGGER = Logger.getInstance(ShowVersionAction.class);

    @Override
    public void actionPerformed(@NotNull AnActionEvent e) {
        LOGGER.info("======================================");
        final String javaVersion = System.getProperty("java.version");
        LOGGER.info("javaVersion: " + javaVersion);
        final String defaultVersion = new DefaultVersion().version();
        LOGGER.info("DefaultVersion: " + defaultVersion);
        LOGGER.info("======================================");
        ApplicationManager.getApplication().invokeLater(() -> {
            MessageDialogBuilder.okCancel("Versions",
                "javaVersion: " + javaVersion + "\n" +
                    "DefaultVersion: " + defaultVersion
            ).ask(e.getProject());
        });
    }
}