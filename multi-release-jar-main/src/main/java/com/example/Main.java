/*
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for license information.
 */

package com.example;

import com.azure.core.implementation.ReflectionUtilsApi;

public class Main {
    public static void main(String[] args) {
        final String javaVersion = System.getProperty("java.version");
        final String defaultVersion = new DefaultVersion().version();
        final String reflectionUtilsApi = getReflectionUtilsApi();
        final String reflectionUtilsFor9 = getReflectionUtilsFor9();
        final String reflectionUtilsFor8 = getReflectionUtilsFor8();
        System.out.println(
            "javaVersion: " + javaVersion + "\n" +
                "DefaultVersion: " + defaultVersion + "\n" +
                "ReflectionUtilsApi: " + reflectionUtilsApi + "\n" +
                "ReflectionUtilsFor9: " + reflectionUtilsFor9 + "\n" +
                "ReflectionUtilsFor8: " + reflectionUtilsFor8
        );

        // DefaultVersion: Multi-Release
        // ReflectionUtilsApi: Multi-Release

        // Java 8/DefaultVersion: 8 (OK)
        // Java 8/ReflectionUtilsApi: 8 (OK)
        // Java 8/ReflectionUtilsFor9: (COMPILATION ERROR)
        // Java 8/ReflectionUtilsFor8: 8 (OK)

        // Java 11/DefaultVersion: 11 (OK)
        // Java 11/ReflectionUtilsApi: 9 (OK)
        // Java 11/ReflectionUtilsFor9: 9 (OK)
        // Java 11/ReflectionUtilsFor8: 8 (WARNING)

        // Java 17/DefaultVersion: 17 (OK)
        // Java 17/ReflectionUtilsApi: 9 (OK)
        // Java 17/ReflectionUtilsFor9: 9 (OK)
        // Java 17/ReflectionUtilsFor8: (ERROR)
    }

    private static String getReflectionUtilsFor9() {
        try {
            return String.valueOf(new ReflectionUtilsFor9().getJavaImplementationMajorVersion());
        } catch (Throwable t) {
            t.printStackTrace();
            return "ERROR:" + t.getCause().getMessage();
        }
    }

    private static String getReflectionUtilsApi() {
        try {
            return String.valueOf(ReflectionUtilsApi.INSTANCE.getJavaImplementationMajorVersion());
        } catch (Throwable t) {
            t.printStackTrace();
            return "ERROR:" + t.getCause().getMessage();
        }
    }

    private static String getReflectionUtilsFor8() {
        try {
            return String.valueOf(new ReflectionUtilsFor8().getJavaImplementationMajorVersion());
        } catch (Throwable t) {
            t.printStackTrace();
            return "ERROR:" + t.getCause().getMessage();
        }
    }
}
