package fr.k0bus.creativemanager.utils;

import fr.k0bus.creativemanager.CreativeManager;
import fr.k0bus.k0buscore.utils.StringUtils;
import org.bukkit.command.CommandSender;

import java.util.HashMap;
import java.util.Map;

public class CMUtils {
    public static void sendMessage(CommandSender messageTo, String text)
    {
        if(!CreativeManager.getLang().getString(text).isEmpty())
            messageTo.sendMessage(parse(StringUtils.parse(CreativeManager.getLang().getString(text))));
    }
    public static void sendMessage(CommandSender messageTo, String text, HashMap<String, String> replaceMap)
    {
        for(Map.Entry<String, String> entry: replaceMap.entrySet())
        {
            text = text.replace(entry.getKey(), entry.getValue());
        }
        if(!CreativeManager.getLang().getString(text).isEmpty())
            messageTo.sendMessage(parse(StringUtils.parse(CreativeManager.getLang().getString(text))));
    }
    public static void sendRawMessage(CommandSender messageTo, String text)
    {
        if(!text.isEmpty())
            messageTo.sendMessage(parse(StringUtils.parse(text)));
    }

    public static String parse(String string)
    {
        return string.replace("{TAG}", CreativeManager.TAG);
    }
}
