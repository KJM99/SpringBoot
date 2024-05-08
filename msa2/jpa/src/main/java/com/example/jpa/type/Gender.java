package com.example.jpa.type;

public enum  Gender {
    MALE(new int[]{1, 3}), FEMALE(new int[]{2, 4});

    final int[] code;
    Gender(int[] code) {
        this.code = code;
    }
}
