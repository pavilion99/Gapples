package tech.spencercolton.gapples.Commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import tech.spencercolton.gapples.Gapples;

/**
 * @author Spencer Colton
 */
public class ToggleGapplesCmd implements CommandExecutor {

    public boolean onCommand(CommandSender sender, Command cmd, String label, String... args) {
        Gapples.craftingAllowed = !Gapples.craftingAllowed;
        return true;
    }

}
