package com.perscholas.homeworks.PA303_10_1;

import java.sql.SQLOutput;

public class FireMonster extends Monster {
    public FireMonster() {};

    public FireMonster(String name) {
        super.monsterName = name;
    }

    @Override
    public String attack() {
        return "Attack with fire";
    }
}
