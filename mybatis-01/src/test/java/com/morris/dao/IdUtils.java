package com.morris.dao;

import org.junit.Test;

import java.util.UUID;

public class IdUtils {

    public static String getId() {
        return UUID.randomUUID().toString().replaceAll("-", "");
    }

    @Test
    public void test() {
        System.out.println(IdUtils.getId());
    }
}
