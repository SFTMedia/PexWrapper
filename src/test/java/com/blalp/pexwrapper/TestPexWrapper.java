package com.blalp.pexwrapper;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class TestPexWrapper {
    @Test
    public void userAdd() {
        assertEquals("luckperms user blalp permission set bukkit.fly",
                PexWrapper.translateCommand("pex user blalp add bukkit.fly".split(" ")));
        assertEquals("luckperms user blalp permission set bukkit.fly false",
                PexWrapper.translateCommand("pex user blalp add -bukkit.fly".split(" ")));
        assertEquals("luckperms user __trick1111 permission set bukkit.fly false",
                PexWrapper.translateCommand("pex user __trick1111 add -bukkit.fly".split(" ")));
    }

    @Test
    public void userRemove() {
        assertEquals("luckperms user blalp permission unset bukkit.fly",
                PexWrapper.translateCommand("pex user blalp remove bukkit.fly".split(" ")));
        assertEquals("luckperms user blalp permission unset bukkit.fly false",
                PexWrapper.translateCommand("pex user blalp remove -bukkit.fly".split(" ")));
    }

    @Test
    public void userPrefix() {
        assertEquals("luckperms user blalp meta setprefix &0[&7ImaBlalp&0]&7",
                PexWrapper.translateCommand("pex user blalp prefix &0[&7ImaBlalp&0]&7".split(" ")));
        assertEquals("luckperms user blalp meta setprefix \"Test Test \"",
                PexWrapper.translateCommand("pex user blalp prefix \"Test Test \"".split(" ")));
    }

    @Test
    public void userSuffix() {
        assertEquals("luckperms user blalp meta setsuffix >>&7",
                PexWrapper.translateCommand("pex user blalp suffix >>&7".split(" ")));
        assertEquals("luckperms user blalp meta setsuffix \">>&7 test test Test\"",
                PexWrapper.translateCommand("pex user blalp suffix \">>&7 test test Test\"".split(" ")));
    }

    @Test
    public void userGroup() {
        assertEquals("luckperms user blalp parent add sheep",
                PexWrapper.translateCommand("pex user blalp group add sheep".split(" ")));
        assertEquals("luckperms user blalp parent set owner",
                PexWrapper.translateCommand("pex user blalp group set owner".split(" ")));
        assertEquals("luckperms user blalp parent remove catapult",
                PexWrapper.translateCommand("pex user blalp group remove catapult".split(" ")));
    }

    @Test
    public void groupAdd() {
        assertEquals("luckperms group manager permission set bukkit.fly",
                PexWrapper.translateCommand("pex group manager add bukkit.fly".split(" ")));
    }

    @Test
    public void groupRemove() {
        assertEquals("luckperms group manager permission unset bukkit.fly",
                PexWrapper.translateCommand("pex group manager remove bukkit.fly".split(" ")));
        assertEquals("luckperms group manager permission unset bukkit.fly false",
                PexWrapper.translateCommand("pex group manager remove -bukkit.fly".split(" ")));
        assertEquals("luckperms group admin permission unset bukkit.fly false",
                PexWrapper.translateCommand("pex group admin remove -bukkit.fly".split(" ")));
    }

    @Test
    public void groupPrefix() {
        assertEquals("luckperms group manager meta setprefix &0[&7ImaBlalp&0]&7",
                PexWrapper.translateCommand("pex group manager prefix &0[&7ImaBlalp&0]&7".split(" ")));
        assertEquals("luckperms group manager meta setprefix \"Test test test test test Test \"",
                PexWrapper.translateCommand("pex group manager prefix \"Test test test test test Test \"".split(" ")));
    }

    @Test
    public void groupSuffix() {
        assertEquals("luckperms group manager meta setsuffix >>&7",
                PexWrapper.translateCommand("pex group manager suffix >>&7".split(" ")));
        assertEquals("luckperms group manager meta setsuffix \">>&7 test test test test Test\"",
                PexWrapper.translateCommand("pex group manager suffix \">>&7 test test test test Test\"".split(" ")));

    }
}
