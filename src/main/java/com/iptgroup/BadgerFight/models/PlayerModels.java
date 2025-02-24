package com.iptgroup.BadgerFight.models;

public class PlayerModels {
    private String name;
    private int attackPower;

    public PlayerModels(String name, int attackPower) {
        this.name = name;
        this.attackPower = attackPower;
    }

    public String getName() { return name; }
    public int getAttackPower() { return attackPower; }
}
