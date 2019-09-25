package com.gmail.nossr50.config.hocon.hardcore;

import com.gmail.nossr50.datatypes.skills.PrimarySkillType;
import ninja.leaping.configurate.objectmapping.Setting;
import ninja.leaping.configurate.objectmapping.serialize.ConfigSerializable;

import java.util.HashMap;

@ConfigSerializable
public class ConfigVampirism {
    private static final double PENALTY_PERCENTAGE_DEFAULT = 5.0D;
    private static final int LEVEL_THRESHOLD_DEFAULT = 0;
    private static final HashMap<PrimarySkillType, Boolean> HARDCORE_SKILL_TOGGLE_MAP_DEFAULT;

    static {
        HARDCORE_SKILL_TOGGLE_MAP_DEFAULT = new HashMap<>();

        for(PrimarySkillType primarySkillType : PrimarySkillType.values()) {
            //TODO: Hacky fix to avoid the main class reference
            if(primarySkillType == PrimarySkillType.SALVAGE || primarySkillType == PrimarySkillType.SMELTING)
                continue;

            HARDCORE_SKILL_TOGGLE_MAP_DEFAULT.put(primarySkillType, false);
        }

    }

    @Setting(value = "Vampirism-Level-Theft-Percentage", comment = "The amount of levels a player will steal from another player when they die with hardcore mode enabled." +
            "\nDefault value: "+PENALTY_PERCENTAGE_DEFAULT)
    private double penaltyPercentage = PENALTY_PERCENTAGE_DEFAULT;

    @Setting(value = "Safe-Level-Threshold", comment = "Players will not be subject to vampirism penalties for skills below this level." +
            "\nDefault value: "+LEVEL_THRESHOLD_DEFAULT)
    private int levelThreshold = LEVEL_THRESHOLD_DEFAULT;

    @Setting(value = "Skills-Using-Vampirism-Mode", comment = "Vampirism mode is enabled on a per skill basis" +
            "\nYou can choose which skills participate in this list." +
            "\nOnly skills that are also enabled in hardcore mode will work, so make sure to turn hardcore mode on for said skills as well.")
    private HashMap<PrimarySkillType, Boolean> skillToggleMap = HARDCORE_SKILL_TOGGLE_MAP_DEFAULT;

    public double getPenaltyPercentage() {
        return penaltyPercentage;
    }

    public int getLevelThreshold() {
        return levelThreshold;
    }

    public HashMap<PrimarySkillType, Boolean> getSkillToggleMap() {
        return skillToggleMap;
    }
}
