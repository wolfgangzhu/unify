/*
 * Zenlayer.com Inc.
 * Copyright (c) 2014-2019 All Rights Reserved.
 */
package com.wolfgangzhu.unify.trace.utils;

import java.util.Random;

/**
 * @author leon
 * @version $Id: RandomStringUtils.java, v 0.1 2018-01-17 10:54:37 leon Exp $
 */
public class RandomStringUtils {

    private static final char[] alphanumericSubset = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
    private static final char[] alphabeticSubset   = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();

    private static final Random r = new Random();

    public static String randomAlphanumericString(final int count) {
        return randomString(alphanumericSubset, count);
    }

    public static String randomAlphabeticString(final int count) {
        return randomString(alphabeticSubset, count);
    }

    public static String randomString(final char[] subset, final int count) {
        char[] chars = new char[count];
        for (int i = 0; i < count; i++) {
            chars[i] = subset[r.nextInt(subset.length)];
        }
        return new String(chars);
    }

}
