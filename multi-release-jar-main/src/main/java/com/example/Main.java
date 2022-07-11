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

        // > Task :Main.main()
        // javaVersion: 1.8.0_292
        // DefaultVersion: 8

        // > Task :Main.main()
        // javaVersion: 11.0.11
        // DefaultVersion: 11

        // > Task :Main.main()
        // javaVersion: 17
        // DefaultVersion: 17
    }
}
