package com.perscholas.homeworks.PA303_10_1;

public class StoneMonster extends Monster {
    public StoneMonster() {
        super.monsterName = "";
    };

    public StoneMonster(String name) {
        super.monsterName = name;
    }

    @Override
    public String attack() {
        return "Attack With Stone";
    }
}
