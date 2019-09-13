package fr.arthurbambou.randomlyaddinganything.config;

import fr.arthurbambou.randomlyaddinganything.RandomlyAddingAnything;
import fr.arthurbambou.randomlyaddinganything.api.namegeneration.LangEnum;
import me.sargunvohra.mcmods.autoconfig1.ConfigData;

@me.sargunvohra.mcmods.autoconfig1.annotation.Config(name = RandomlyAddingAnything.MOD_ID)
public class Config implements ConfigData {

    public int materialNumber = 1000;
    public boolean debug = true;
    public boolean regen = false;
    public LangEnum namingLanguage = LangEnum.en;

}
