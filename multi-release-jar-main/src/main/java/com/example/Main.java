/*
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for license information.
 */

package com.example;

public class Main {
    public static void main(String[] args) {
        final String javaVersion = System.getProperty("java.version");
        final String defaultVersion = new DefaultVersion().version();
        System.out.println(
            "javaVersion: " + javaVersion + "\n" +
                "DefaultVersion: " + defaultVersion
        );

        // DefaultVersion: Multi-Release
        // Java 8/DefaultVersion: 8 (OK)
        // Java 11/DefaultVersion: 11 (OK)
        // Java 17/DefaultVersion: 17 (OK)
    }
}
