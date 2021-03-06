package pl.smpickaxe.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import pl.smpickaxe.ores.Bedrock;
import pl.smpickaxe.ores.CustomDiamond;
import pl.smpickaxe.ores.Meteorite;
import pl.smpickaxe.ores.Platinium;

public class GivePickaxe implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (sender instanceof Player) {
            Player p = (Player) sender;

            if (p.isOp()){
                if(args.length == 0){
                    p.sendMessage("Dopisz materiał");
                    return false;
                }
                else if(args.length == 1){
                    if(args[0].equalsIgnoreCase("meteoryt")){
                        p.getInventory().addItem(Meteorite.createMeteorite());
                        return true;
                    }
                    else if(args[0].equalsIgnoreCase("rubin")){
                        p.getInventory().addItem(CustomDiamond.createCustomDiamond());
                        return true;
                    }
                    else if(args[0].equalsIgnoreCase("platyna")){
                        p.getInventory().addItem(Platinium.createPlatinium());
                        return true;
                    }
                    else if(args[0].equalsIgnoreCase("bedrock")){
                        p.getInventory().addItem(Bedrock.createBedrock());
                        return true;
                    }
                    else{
                        p.sendMessage("Nie ma takiego materiału");
                        return false;
                    }
                }
                else return false;
            }
            else{
                return false;
            }

        }
        else{
            return true;
        }

    }
}
