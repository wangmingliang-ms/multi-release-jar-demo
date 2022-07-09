/*
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for license information.
 */

package com.example;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.reflect.Constructor;
/**
 * copied from
 * <a href="https://github.com/Azure/azure-sdk-for-java/blob/azure-core_1.30.0/sdk/core/azure-core/src/main/java/com/azure/core/implementation/ReflectionUtils.java">
 * java8/ReflectionUtils.java
 * </a>
 */
public final class ReflectionUtilsFor8 {
    private static final MethodHandle PRIVATE_LOOKUP_IN;

    public MethodHandles.Lookup getLookupToUse(Class<?> targetClass) throws Exception {
        try {
            return (MethodHandles.Lookup) PRIVATE_LOOKUP_IN.invoke(targetClass);
        } catch (Throwable var3) {
            if (var3 instanceof Error) {
                throw (Error) var3;
            } else {
                throw (Exception) var3;
            }
        }
    }

    public int getJavaImplementationMajorVersion() {
        return 8;
    }

    public ReflectionUtilsFor8() {
    }

    static {
        try {
            Constructor<MethodHandles.Lookup> privateLookupInConstructor = MethodHandles.Lookup.class.getDeclaredConstructor(Class.class);
            if (!privateLookupInConstructor.isAccessible()) {
                privateLookupInConstructor.setAccessible(true);
            }

            PRIVATE_LOOKUP_IN = MethodHandles.lookup().unreflectConstructor(privateLookupInConstructor);
        } catch (ReflectiveOperationException var1) {
            throw new RuntimeException("Unable to use private lookup in constructor.", var1);
        }
    }
}