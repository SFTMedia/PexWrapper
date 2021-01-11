package com.blalp.pexwrapper;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class TestPexWrapper {
        @Test
        public void userAdd() {
                assertEquals("luckperms user blalp permission set bukkit.fly",
                                PexWrapper.translateCommand("user blalp add bukkit.fly".split(" ")));
                assertEquals("luckperms user blalp permission set bukkit.fly false",
                                PexWrapper.translateCommand("user blalp add -bukkit.fly".split(" ")));
                assertEquals("luckperms user __trick1111 permission set bukkit.fly false",
                                PexWrapper.translateCommand("user __trick1111 add -bukkit.fly".split(" ")));
        }

        @Test
        public void userRemove() {
                assertEquals("luckperms user blalp permission unset bukkit.fly",
                                PexWrapper.translateCommand("user blalp remove bukkit.fly".split(" ")));
                assertEquals("luckperms user blalp permission unset bukkit.fly false",
                                PexWrapper.translateCommand("user blalp remove -bukkit.fly".split(" ")));
        }

        @Test
        public void userPrefix() {
                assertEquals("luckperms user blalp meta setprefix 999999 &0[&7ImaBlalp&0]&7",
                                PexWrapper.translateCommand("user blalp prefix &0[&7ImaBlalp&0]&7".split(" ")));
                assertEquals("luckperms user blalp meta setprefix 999999 \"Test Test \"",
                                PexWrapper.translateCommand("user blalp prefix \"Test Test \"".split(" ")));
        }

        @Test
        public void userClearPrefix() {
                assertEquals("luckperms user blalp meta setprefix 999999 \"\"\nluckperms user blalp meta removeprefix 999999 \"\"",
                                PexWrapper.translateCommand("user blalp prefix \"\"".split(" ")));
        }

        @Test
        public void userSuffix() {
                assertEquals("luckperms user blalp meta setsuffix 999999 >>&7",
                                PexWrapper.translateCommand("user blalp suffix >>&7".split(" ")));
                assertEquals("luckperms user blalp meta setsuffix 999999 \">>&7 test test Test\"",
                                PexWrapper.translateCommand("user blalp suffix \">>&7 test test Test\"".split(" ")));
        }

        @Test
        public void userClearSuffix() {
                assertEquals("luckperms user blalp meta setsuffix 999999 \"\"\nluckperms user blalp meta removesuffix 999999 \"\"",
                                PexWrapper.translateCommand("user blalp suffix \"\"".split(" ")));
        }

        @Test
        public void userGroup() {
                assertEquals("luckperms user blalp parent add sheep",
                                PexWrapper.translateCommand("user blalp group add sheep".split(" ")));
                assertEquals("luckperms user blalp parent set owner",
                                PexWrapper.translateCommand("user blalp group set owner".split(" ")));
                assertEquals("luckperms user blalp parent remove catapult",
                                PexWrapper.translateCommand("user blalp group remove catapult".split(" ")));
        }

        @Test
        public void groupAdd() {
                assertEquals("luckperms group manager permission set bukkit.fly",
                                PexWrapper.translateCommand("group manager add bukkit.fly".split(" ")));
        }

        @Test
        public void groupRemove() {
                assertEquals("luckperms group manager permission unset bukkit.fly",
                                PexWrapper.translateCommand("group manager remove bukkit.fly".split(" ")));
                assertEquals("luckperms group manager permission unset bukkit.fly false",
                                PexWrapper.translateCommand("group manager remove -bukkit.fly".split(" ")));
                assertEquals("luckperms group admin permission unset bukkit.fly false",
                                PexWrapper.translateCommand("group admin remove -bukkit.fly".split(" ")));
        }

        @Test
        public void groupPrefix() {
                assertEquals("luckperms group manager meta setprefix 999999 &0[&7ImaBlalp&0]&7",
                                PexWrapper.translateCommand("group manager prefix &0[&7ImaBlalp&0]&7".split(" ")));
                assertEquals("luckperms group manager meta setprefix 999999 \"Test test test test test Test \"",
                                PexWrapper.translateCommand(
                                                "group manager prefix \"Test test test test test Test \"".split(" ")));
        }

        @Test
        public void groupSuffix() {
                assertEquals("luckperms group manager meta setsuffix 999999 >>&7",
                                PexWrapper.translateCommand("group manager suffix >>&7".split(" ")));
                assertEquals("luckperms group manager meta setsuffix 999999 \">>&7 test test test test Test\"",
                                PexWrapper.translateCommand(
                                                "group manager suffix \">>&7 test test test test Test\"".split(" ")));
        }

        // Start https://luckperms.net/wiki/GM-&-PEX-Command-Equivalents

        @Test
        public void wikiGeneral() {
                assertEquals("lp", PexWrapper.translateCommand("pex".split(" ")));
                assertEquals("lp sync", PexWrapper.translateCommand("reload".split(" ")));
                assertEquals("lp verbose on", PexWrapper.translateCommand("pex toggle debug".split(" ")));
                assertEquals("lp verbose off", PexWrapper.translateCommand("pex toggle debug".split(" ")));
        }
        @Test
        public void wikiUser() {
                assertEquals("lp user blalp haspermission minecraft.commands.give",
                                PexWrapper.translateCommand("pex user blalp check minecraft.commands.give".split(" ")));
                assertEquals("lp user blalp haspermission minecraft.commands.give", PexWrapper
                                .translateCommand("pex user blalp check -minecraft.commands.give".split(" ")));
                assertEquals("lp info", PexWrapper.translateCommand("pex backend".split(" ")));
                assertEquals("lp user blalp permission info",
                                PexWrapper.translateCommand("pex user blalp list".split(" ")));
                assertEquals("lp user blalp meta info",
                                PexWrapper.translateCommand("pex user blalp prefix".split(" ")));
                assertEquals("lp user blalp meta addprefix 999999 &0r&fa&1d&7p&6r&5e&8f&ci&ax&b", PexWrapper
                                .translateCommand("pex user blalp prefix &0r&fa&1d&7p&6r&5e&8f&ci&ax&b".split(" ")));
                assertEquals("lp user blalp meta addprefix 999999 \"Multi Word\"",
                                PexWrapper.translateCommand("pex user blalp prefix \"Multi Word\"".split(" ")));
                assertEquals("unknown", PexWrapper.translateCommand("pex user blalp prefix \"\"".split(" ")));
                assertEquals("lp user blalp meta info",
                                PexWrapper.translateCommand("pex user blalp suffix".split(" ")));
                assertEquals("lp user blalp meta addsuffix 999999 &0s&fu&0f&0f&0f&ff&0i&fx&0", PexWrapper
                                .translateCommand("pex user blalp suffix &0s&fu&0f&0f&0f&ff&0i&fx&0".split(" ")));
                assertEquals("unknown", PexWrapper.translateCommand("pex user blalp suffix \"\"".split(" ")));
                assertEquals("lp user blalp meta addsuffix 999999 \"Multi Word\"",
                                PexWrapper.translateCommand("pex user blalp suffix \"Multi Word\"".split(" ")));
                assertEquals("lp user blalp clear", PexWrapper.translateCommand("pex user blalp delete".split(" ")));
                assertEquals("lp user blalp permission set minecraft.commands.give true world=MyWorld", PexWrapper
                                .translateCommand("pex user blalp add minecraft.commands.give MyWorld".split(" ")));
                assertEquals("lp user blalp permission set minecraft.commands.give true world=world", PexWrapper
                                .translateCommand("pex user blalp add minecraft.commands.give world".split(" ")));
                assertEquals("lp user blalp permission set minecraft.commands.give false world=MyWorld", PexWrapper
                                .translateCommand("pex user blalp add -minecraft.commands.give MyWorld".split(" ")));
                assertEquals("lp user blalp permission unset minecraft.commands.give world=MyWorld", PexWrapper
                                .translateCommand("pex user blalp remove minecraft.commands.give MyWorld".split(" ")));
                assertEquals("lp user blalp permission unset minecraft.commands.give world=MyWorld", PexWrapper
                                .translateCommand("pex user blalp remove -minecraft.commands.give MyWorld".split(" ")));
                assertEquals("lp user blalp permission settemp minecraft.commands.give true 1mo3d13h45m world=MyWorld",
                                PexWrapper.translateCommand(
                                                "pex user blalp timed add minecraft.commands.give 1mo3d13h45m MyWorld"
                                                                .split(" ")));
                assertEquals("lp user blalp permission settemp minecraft.commands.give true 1482694200 world=MyWorld",
                                PexWrapper.translateCommand(
                                                "pex user blalp timed add minecraft.commands.give 1482694200 MyWorld"
                                                                .split(" ")));
                assertEquals("lp user blalp permission settemp minecraft.commands.give false 1mo3d13h45m world=MyWorld",
                                PexWrapper.translateCommand(
                                                "pex user blalp timed add -minecraft.commands.give 1mo3d13h45m MyWorld"
                                                                .split(" ")));
                assertEquals("lp user blalp permission unsettemp minecraft.commands.give world=MyWorld",
                                PexWrapper.translateCommand(
                                                "pex user blalp timed remove -minecraft.commands.give 1mo3d13h45m MyWorld"
                                                                .split(" ")));
                assertEquals("lp user blalp permission unsettemp minecraft.commands.give world=MyWorld",
                                PexWrapper.translateCommand(
                                                "pex user blalp timed remove minecraft.commands.give 1mo3d13h45m MyWorld"
                                                                .split(" ")));
                assertEquals("lp user blalp meta set option value world=MyWorld",
                                PexWrapper.translateCommand("pex user blalp set option value MyWorld".split(" ")));
                assertEquals("lp user blalp meta set option2 value2 world=MyWorld",
                                PexWrapper.translateCommand("pex user blalp set option2 value2 MyWorld".split(" ")));
                assertEquals("lp user blalp parent info",
                                PexWrapper.translateCommand("pex user blalp group list".split(" ")));
                assertEquals("lp user blalp parent add admin world=MyWorld",
                                PexWrapper.translateCommand("pex user blalp group add admin MyWorld".split(" ")));
                assertEquals("lp user blalp parent addtemp admin 1mo3d13h45m world=MyWorld", PexWrapper
                                .translateCommand("pex user blalp group add admin MyWorld 1mo3d13h45m".split(" ")));
                assertEquals("lp user blalp parent set admin",
                                PexWrapper.translateCommand("pex user blalp group set admin".split(" ")));
                assertEquals("lp user blalp parent remove admin world=MyWorld",
                                PexWrapper.translateCommand("pex user blalp group remove admin MyWorld".split(" ")));
        }
        @Test
        public void wikiGroup() {
                assertEquals("lp listgroups", PexWrapper.translateCommand("pex groups list".split(" ")));
                assertEquals("lp group admin permission info",
                                PexWrapper.translateCommand("pex group admin list".split(" ")));
                assertEquals("lp group admin meta info",
                                PexWrapper.translateCommand("pex group admin prefix".split(" ")));
                assertEquals("lp group admin meta addprefix 999999 &0r&fa&1d&7p&6r&5e&8f&ci&ax&b", PexWrapper
                                .translateCommand("pex group admin prefix &0r&fa&1d&7p&6r&5e&8f&ci&ax&b".split(" ")));
                assertEquals("lp group admin meta addprefix 999999 \"Multi Word\"",
                                PexWrapper.translateCommand("pex group admin prefix \"Multi Word\"".split(" ")));
                assertEquals("Unknown", PexWrapper.translateCommand("pex group admin prefix \"\"".split(" ")));
                assertEquals("lp group admin meta info",
                                PexWrapper.translateCommand("pex group admin suffix".split(" ")));
                assertEquals("lp group admin meta addsuffix 999999 &0s&fu&0f&0f&0f&ff&0i&fx&0", PexWrapper
                                .translateCommand("pex group admin suffix &0s&fu&0f&0f&0f&ff&0i&fx&0".split(" ")));
                assertEquals("unknown", PexWrapper.translateCommand("pex group admin suffix \"\"".split(" ")));
                assertEquals("lp group admin meta addsuffix 999999 \"Multi Word\"",
                                PexWrapper.translateCommand("pex group admin suffix \"Multi Word\"".split(" ")));
                assertEquals("lp creategroup admin", PexWrapper.translateCommand("pex group admin create".split(" ")));
                assertEquals("lp deletegroup admin", PexWrapper.translateCommand("pex group admin delete".split(" ")));
                assertEquals("lp group admin parent info",
                                PexWrapper.translateCommand("pex group admin parents list".split(" ")));
                assertEquals("lp group admin listmembers",
                                PexWrapper.translateCommand("pex group admin users".split(" ")));
                assertEquals("lp group admin parent add admin",
                                PexWrapper.translateCommand("pex group admin parents set admin".split(" ")));
                assertEquals("unknown", PexWrapper
                                .translateCommand("pex group admin parents set JMod,Mod,Manager,Admin>".split(" ")));
                assertEquals("lp group admin permission set minecraft.commands.give true world=MyWorld", PexWrapper
                                .translateCommand("pex group admin add minecraft.commands.give MyWorld".split(" ")));
                assertEquals("lp group admin permission set minecraft.commands.give false world=MyWorld", PexWrapper
                                .translateCommand("pex group admin add -minecraft.commands.give MyWorld".split(" ")));
                assertEquals("lp group admin permission unset minecraft.commands.give world=MyWorld", PexWrapper
                                .translateCommand("pex group admin remove minecraft.commands.give MyWorld".split(" ")));
                assertEquals("lp group admin permission unset minecraft.commands.give world=MyWorld",
                                PexWrapper.translateCommand(
                                                "pex group admin remove -minecraft.commands.give MyWorld".split(" ")));
                assertEquals("lp group admin permission settemp minecraft.commands.give true 1mo3d13h45m world=MyWorld",
                                PexWrapper.translateCommand(
                                                "pex group admin timed add minecraft.commands.give 1mo3d13h45m MyWorld"
                                                                .split(" ")));
                assertEquals("lp group admin permission settemp minecraft.commands.give false 1mo3d13h45m world=MyWorld",
                                PexWrapper.translateCommand(
                                                "pex group admin timed add -minecraft.commands.give 1mo3d13h45m MyWorld"
                                                                .split(" ")));
                assertEquals("lp group admin permission unsettemp minecraft.commands.give world=MyWorld",
                                PexWrapper.translateCommand(
                                                "pex group admin timed remove minecraft.commands.give 1mo3d13h45m MyWorld"
                                                                .split(" ")));
                assertEquals("lp group admin permission unsettemp minecraft.commands.give world=MyWorld",
                                PexWrapper.translateCommand(
                                                "pex group admin timed remove -minecraft.commands.give 1mo3d13h45m MyWorld"
                                                                .split(" ")));
                assertEquals("lp group admin meta set option value world=MyWorld",
                                PexWrapper.translateCommand("pex group admin set option value MyWorld".split(" ")));
                assertEquals("lp group admin meta set option2 value3 world=MyWorld",
                                PexWrapper.translateCommand("pex group admin set option2 value3 MyWorld".split(" ")));
        }
        @Test
        public void wikiParent() {
                assertEquals("lp user blalp parent add admin",
                                PexWrapper.translateCommand("pex group admin user add blalp".split(" ")));
                assertEquals("lp user blalp parent remove admin",
                                PexWrapper.translateCommand("pex group admin user remove blalp".split(" ")));
        }
        @Test
        public void wikiLadder() {
                assertEquals("lp user blalp promote ladder",
                                PexWrapper.translateCommand("pex promote blalp ladder".split(" ")));
                assertEquals("lp user blalp promote secondladder>",
                                PexWrapper.translateCommand("pex promote blalp secondladder".split(" ")));
                assertEquals("lp user blalp demote ladder",
                                PexWrapper.translateCommand("pex demote blalp ladder".split(" ")));
        }
}
