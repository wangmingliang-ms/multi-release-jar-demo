/*
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for license information.
 */

package com.example.multireleasejardemo;

import com.azure.core.implementation.ReflectionUtilsApi;
import com.example.DefaultVersion;
import com.example.ReflectionUtilsFor8;
import com.example.ReflectionUtilsFor9;
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
        final String reflectionUtilsApi = getReflectionUtilsApi();
        LOGGER.info("ReflectionUtilsApi: " + reflectionUtilsApi);
        final String reflectionUtilsFor9 = getReflectionUtilsFor9();
        LOGGER.info("ReflectionUtilsFor9: " + reflectionUtilsFor9);
        final String reflectionUtilsFor8 = getReflectionUtilsFor8();
        LOGGER.info("ReflectionUtilsFor8: " + reflectionUtilsFor8);
        LOGGER.info("======================================");
        ApplicationManager.getApplication().invokeLater(() -> {
            MessageDialogBuilder.okCancel("Versions",
                "javaVersion: " + javaVersion + "\n" +
                    "DefaultVersion: " + defaultVersion + "\n" +
                    "ReflectionUtilsApi: " + reflectionUtilsApi + "\n" +
                    "ReflectionUtilsFor9: " + reflectionUtilsFor9 + "\n" +
                    "ReflectionUtilsFor8: " + reflectionUtilsFor8
            ).ask(e.getProject());
        });
    }

    @NotNull
    private String getReflectionUtilsFor9() {
        try {
            return String.valueOf(new ReflectionUtilsFor9().getJavaImplementationMajorVersion());
        } catch (Throwable t) {
            t.printStackTrace();
            return "ERROR:" + t.getCause().getMessage();
        }
    }

    @NotNull
    private String getReflectionUtilsApi() {
        try {
            return String.valueOf(ReflectionUtilsApi.INSTANCE.getJavaImplementationMajorVersion());
        } catch (Throwable t) {
            t.printStackTrace();
            return "ERROR:" + t.getCause().getMessage();
        }
    }

    @NotNull
    private String getReflectionUtilsFor8() {
        try {
            return String.valueOf(new ReflectionUtilsFor8().getJavaImplementationMajorVersion());
        } catch (Throwable t) {
            t.printStackTrace();
            return "ERROR:" + t.getCause().getMessage();
        }
    }
}