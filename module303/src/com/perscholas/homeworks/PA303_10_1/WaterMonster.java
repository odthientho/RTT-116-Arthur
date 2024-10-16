package com.perscholas.homeworks.PA303_10_1;

public class WaterMonster extends Monster {
    public WaterMonster() {
        super.monsterName = "";
    };

    public WaterMonster(String name) {
        super.monsterName = name;
    }

    @Override
    public String attack() {
       return "Attack With Water";
    }
}
