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
                assertEquals("luckperms user blalp permission unset bukkit.fly",
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
                assertEquals("luckperms group manager permission unset bukkit.fly",
                                PexWrapper.translateCommand("group manager remove -bukkit.fly".split(" ")));
                assertEquals("luckperms group admin permission unset bukkit.fly",
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
                assertEquals("luckperms", PexWrapper.translateCommand(new String[] {}));
                assertEquals("luckperms sync", PexWrapper.translateCommand("reload".split(" ")));
                assertEquals("luckperms verbose on", PexWrapper.translateCommand("toggle debug".split(" ")));
                assertEquals("luckperms verbose off", PexWrapper.translateCommand("toggle debug".split(" ")));
        }

        @Test
        public void wikiUserInfo() {
                assertEquals("luckperms user blalp haspermission minecraft.commands.give",
                                PexWrapper.translateCommand("user blalp check minecraft.commands.give".split(" ")));
                assertEquals("luckperms info", PexWrapper.translateCommand("backend".split(" ")));
                assertEquals("luckperms user blalp permission info",
                                PexWrapper.translateCommand("user blalp list".split(" ")));
        }

        @Test
        public void wikiUserPrefix() {
                assertEquals("luckperms user blalp meta info",
                                PexWrapper.translateCommand("user blalp prefix".split(" ")));
                assertEquals("luckperms user blalp meta setprefix 999999 &0r&fa&1d&7p&6r&5e&8f&ci&ax&b", PexWrapper
                                .translateCommand("user blalp prefix &0r&fa&1d&7p&6r&5e&8f&ci&ax&b".split(" ")));
                assertEquals("luckperms user blalp meta setprefix 999999 \"Multi Word\"",
                                PexWrapper.translateCommand("user blalp prefix \"Multi Word\"".split(" ")));
                assertEquals("luckperms user blalp meta setprefix 999999 \"\"\nluckperms user blalp meta removeprefix 999999 \"\"",
                                PexWrapper.translateCommand("user blalp prefix \"\"".split(" ")));
        }

        @Test
        public void wikiUserSuffix() {
                assertEquals("luckperms user blalp meta info",
                                PexWrapper.translateCommand("user blalp suffix".split(" ")));
                assertEquals("luckperms user blalp meta setsuffix 999999 &0s&fu&0f&0f&0f&ff&0i&fx&0",
                                PexWrapper.translateCommand("user blalp suffix &0s&fu&0f&0f&0f&ff&0i&fx&0".split(" ")));
                assertEquals("luckperms user blalp meta setsuffix 999999 \"\"\nluckperms user blalp meta removesuffix 999999 \"\"",
                                PexWrapper.translateCommand("user blalp suffix \"\"".split(" ")));
                assertEquals("luckperms user blalp meta setsuffix 999999 \"Multi Word\"",
                                PexWrapper.translateCommand("user blalp suffix \"Multi Word\"".split(" ")));
        }

        @Test
        public void wikiUserPermissions() {
                assertEquals("luckperms user blalp clear", PexWrapper.translateCommand("user blalp delete".split(" ")));
        }

        @Test
        public void wikiUserPermissionsAdd() {
                assertEquals("luckperms user blalp permission set minecraft.commands.give world=MyWorld", PexWrapper
                                .translateCommand("user blalp add minecraft.commands.give MyWorld".split(" ")));
                assertEquals("luckperms user blalp permission set minecraft.commands.give",
                                PexWrapper.translateCommand("user blalp add minecraft.commands.give".split(" ")));
                assertEquals("luckperms user blalp permission set minecraft.commands.give world=world",
                                PexWrapper.translateCommand("user blalp add minecraft.commands.give world".split(" ")));
                assertEquals("luckperms user blalp permission set minecraft.commands.give false world=MyWorld",
                                PexWrapper.translateCommand(
                                                "user blalp add -minecraft.commands.give MyWorld".split(" ")));
                assertEquals("luckperms user blalp permission set minecraft.commands.give false",
                                PexWrapper.translateCommand("user blalp add -minecraft.commands.give".split(" ")));
        }

        @Test
        public void wikiUserPermissionsRemove() {
                assertEquals("luckperms user blalp permission unset minecraft.commands.give world=MyWorld", PexWrapper
                                .translateCommand("user blalp remove minecraft.commands.give MyWorld".split(" ")));
                assertEquals("luckperms user blalp permission unset minecraft.commands.give",
                                PexWrapper.translateCommand("user blalp remove minecraft.commands.give".split(" ")));
                assertEquals("luckperms user blalp permission unset minecraft.commands.give world=MyWorld", PexWrapper
                                .translateCommand("user blalp remove -minecraft.commands.give MyWorld".split(" ")));
                assertEquals("luckperms user blalp permission unset minecraft.commands.give",
                                PexWrapper.translateCommand("user blalp remove -minecraft.commands.give".split(" ")));
        }

        @Test
        public void wikiUserTimedPermissionsAdd() {
                assertEquals("luckperms user blalp permission settemp minecraft.commands.give 3d13h45m world=MyWorld",
                                PexWrapper.translateCommand(
                                                "user blalp timed add minecraft.commands.give 3d13h45m MyWorld"
                                                                .split(" ")));
                assertEquals("luckperms user blalp permission settemp minecraft.commands.give 3d13h45m", PexWrapper
                                .translateCommand("user blalp timed add minecraft.commands.give 3d13h45m".split(" ")));
                assertEquals("luckperms user blalp permission settemp minecraft.commands.give 10000s world=MyWorld",
                                PexWrapper.translateCommand("user blalp timed add minecraft.commands.give 10000 MyWorld"
                                                .split(" ")));
                assertEquals("luckperms user blalp permission settemp minecraft.commands.give 1000s", PexWrapper
                                .translateCommand("user blalp timed add minecraft.commands.give 1000".split(" ")));
                assertEquals("luckperms user blalp permission settemp minecraft.commands.give false 3d13h45m world=MyWorld",
                                PexWrapper.translateCommand(
                                                "user blalp timed add -minecraft.commands.give 3d13h45m MyWorld"
                                                                .split(" ")));
                assertEquals("luckperms user blalp permission settemp minecraft.commands.give false 3d13h45m",
                                PexWrapper.translateCommand(
                                                "user blalp timed add -minecraft.commands.give 3d13h45m".split(" ")));
        }

        @Test
        public void wikiUserTimedPermissionsRemove() {

                assertEquals("luckperms user blalp permission unsettemp minecraft.commands.give world=MyWorld",
                                PexWrapper.translateCommand(
                                                "user blalp timed remove -minecraft.commands.give 3d13h45m MyWorld"
                                                                .split(" ")));
                assertEquals("luckperms user blalp permission unsettemp minecraft.commands.give",
                                PexWrapper.translateCommand("user blalp timed remove -minecraft.commands.give 3d13h45m"
                                                .split(" ")));
                assertEquals("luckperms user blalp permission unsettemp minecraft.commands.give world=MyWorld",
                                PexWrapper.translateCommand(
                                                "user blalp timed remove minecraft.commands.give 3d13h45m MyWorld"
                                                                .split(" ")));
                assertEquals("luckperms user blalp permission unsettemp minecraft.commands.give",
                                PexWrapper.translateCommand(
                                                "user blalp timed remove minecraft.commands.give 3d13h45m".split(" ")));
        }

        @Test
        public void wikiUserMeta() {
                assertEquals("luckperms user blalp meta set option value world=MyWorld",
                                PexWrapper.translateCommand("user blalp set option value MyWorld".split(" ")));
                assertEquals("luckperms user blalp meta set option value",
                                PexWrapper.translateCommand("user blalp set option value".split(" ")));
                assertEquals("luckperms user blalp meta set option2 value2 world=MyWorld",
                                PexWrapper.translateCommand("user blalp set option2 value2 MyWorld".split(" ")));
                assertEquals("luckperms user blalp meta set option2 value2",
                                PexWrapper.translateCommand("user blalp set option2 value2".split(" ")));
        }

        @Test
        public void wikiUserParent() {
                assertEquals("luckperms user blalp parent info",
                                PexWrapper.translateCommand("user blalp group list".split(" ")));
                assertEquals("luckperms user blalp parent add admin world=MyWorld",
                                PexWrapper.translateCommand("user blalp group add admin MyWorld".split(" ")));
                assertEquals("luckperms user blalp parent add admin",
                                PexWrapper.translateCommand("user blalp group add admin".split(" ")));
                assertEquals("luckperms user blalp parent addtemp admin 3d13h45m world=MyWorld",
                                PexWrapper.translateCommand("user blalp group add admin MyWorld 3d13h45m".split(" ")));
                assertEquals("luckperms user blalp parent addtemp admin 1000s world=MyWorld",
                                PexWrapper.translateCommand("user blalp group add admin MyWorld 1000".split(" ")));
                assertEquals("luckperms user blalp parent set admin",
                                PexWrapper.translateCommand("user blalp group set admin".split(" ")));
                assertEquals("luckperms user blalp parent remove admin world=MyWorld",
                                PexWrapper.translateCommand("user blalp group remove admin MyWorld".split(" ")));
        }

        @Test
        public void wikiGroup() {
                assertEquals("luckperms listgroups", PexWrapper.translateCommand("groups list".split(" ")));
                assertEquals("luckperms group admin permission info",
                                PexWrapper.translateCommand("group admin list".split(" ")));
        }

        @Test
        public void wikiGroupPrefix() {
                assertEquals("luckperms group admin meta info",
                                PexWrapper.translateCommand("group admin prefix".split(" ")));
                assertEquals("luckperms group admin meta setprefix 999999 &0r&fa&1d&7p&6r&5e&8f&ci&ax&b", PexWrapper
                                .translateCommand("group admin prefix &0r&fa&1d&7p&6r&5e&8f&ci&ax&b".split(" ")));
                assertEquals("luckperms group admin meta setprefix 999999 \"Multi Word\"",
                                PexWrapper.translateCommand("group admin prefix \"Multi Word\"".split(" ")));
                assertEquals("luckperms group admin meta setprefix 999999 \"\"\nluckperms group admin meta removeprefix 999999 \"\"",
                                PexWrapper.translateCommand("group admin prefix \"\"".split(" ")));
        }

        @Test
        public void wikiGroupSuffix() {
                assertEquals("luckperms group admin meta info",
                                PexWrapper.translateCommand("group admin suffix".split(" ")));
                assertEquals("luckperms group admin meta setsuffix 999999 &0s&fu&0f&0f&0f&ff&0i&fx&0", PexWrapper
                                .translateCommand("group admin suffix &0s&fu&0f&0f&0f&ff&0i&fx&0".split(" ")));
                assertEquals("luckperms group admin meta setsuffix 999999 \"\"\nluckperms group admin meta removesuffix 999999 \"\"",
                                PexWrapper.translateCommand("group admin suffix \"\"".split(" ")));
                assertEquals("luckperms group admin meta setsuffix 999999 \"Multi Word\"",
                                PexWrapper.translateCommand("group admin suffix \"Multi Word\"".split(" ")));
        }

        @Test
        public void wikiGroupCreation() {
                assertEquals("luckperms creategroup admin",
                                PexWrapper.translateCommand("group admin create".split(" ")));
                assertEquals("luckperms deletegroup admin",
                                PexWrapper.translateCommand("group admin delete".split(" ")));
        }

        @Test
        public void wikiGroupParent() {
                assertEquals("luckperms group admin parent info",
                                PexWrapper.translateCommand("group admin parents list".split(" ")));
                assertEquals("luckperms group admin listmembers",
                                PexWrapper.translateCommand("group admin users".split(" ")));
                assertEquals("luckperms group admin parent add manager",
                                PexWrapper.translateCommand("group admin parents set manager".split(" ")));
                assertEquals("luckperms group admin parent add JMod\nluckperms group admin parent add Mod\nluckperms group admin parent add Manager",
                                PexWrapper.translateCommand("group admin parents set JMod,Mod,Manager".split(" ")));
        }

        @Test
        public void wikiGroupPermissionsAdd() {
                assertEquals("luckperms group admin permission set minecraft.commands.give world=MyWorld", PexWrapper
                                .translateCommand("group admin add minecraft.commands.give MyWorld".split(" ")));
                assertEquals("luckperms group admin permission set minecraft.commands.give false world=MyWorld",
                                PexWrapper.translateCommand(
                                                "group admin add -minecraft.commands.give MyWorld".split(" ")));
        }

        @Test
        public void wikiGroupPermissionsRemove() {
                assertEquals("luckperms group admin permission unset minecraft.commands.give world=MyWorld", PexWrapper
                                .translateCommand("group admin remove minecraft.commands.give MyWorld".split(" ")));
                assertEquals("luckperms group admin permission unset minecraft.commands.give world=MyWorld", PexWrapper
                                .translateCommand("group admin remove -minecraft.commands.give MyWorld".split(" ")));
        }

        @Test
        public void wikiGroupTimedPermissionsAdd() {
                assertEquals("luckperms group admin permission settemp minecraft.commands.give 3d13h45m world=MyWorld",
                                PexWrapper.translateCommand(
                                                "group admin timed add minecraft.commands.give 3d13h45m MyWorld"
                                                                .split(" ")));
                assertEquals("luckperms group admin permission settemp minecraft.commands.give false 3d13h45m world=MyWorld",
                                PexWrapper.translateCommand(
                                                "group admin timed add -minecraft.commands.give 3d13h45m MyWorld"
                                                                .split(" ")));
        }

        @Test
        public void wikiGroupTimedPermissionsRemove() {
                assertEquals("luckperms group admin permission unsettemp minecraft.commands.give world=MyWorld",
                                PexWrapper.translateCommand(
                                                "group admin timed remove minecraft.commands.give 3d13h45m MyWorld"
                                                                .split(" ")));
                assertEquals("luckperms group admin permission unsettemp minecraft.commands.give world=MyWorld",
                                PexWrapper.translateCommand(
                                                "group admin timed remove -minecraft.commands.give 3d13h45m MyWorld"
                                                                .split(" ")));
        }

        @Test
        public void wikiGroupMeta() {
                assertEquals("luckperms group admin meta set option value world=MyWorld",
                                PexWrapper.translateCommand("group admin set option value MyWorld".split(" ")));
                assertEquals("luckperms group admin meta set option2 value3 world=MyWorld",
                                PexWrapper.translateCommand("group admin set option2 value3 MyWorld".split(" ")));
        }

        @Test
        public void wikiParent() {
                assertEquals("luckperms user blalp parent add admin",
                                PexWrapper.translateCommand("group admin user add blalp".split(" ")));
                assertEquals("luckperms user blalp parent remove admin",
                                PexWrapper.translateCommand("group admin user remove blalp".split(" ")));
        }

        @Test
        public void wikiLadder() {
                assertEquals("luckperms user blalp promote ladder",
                                PexWrapper.translateCommand("promote blalp ladder".split(" ")));
                assertEquals("luckperms user blalp promote secondladder",
                                PexWrapper.translateCommand("promote blalp secondladder".split(" ")));
                assertEquals("luckperms user blalp demote ladder",
                                PexWrapper.translateCommand("demote blalp ladder".split(" ")));
        }
}
