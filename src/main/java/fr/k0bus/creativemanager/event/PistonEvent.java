package fr.k0bus.creativemanager.event;

import fr.k0bus.creativemanager.CreativeManager;
import fr.k0bus.creativemanager.log.BlockLog;
import fr.k0bus.creativemanager.settings.Protections;
import org.bukkit.Location;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPistonExtendEvent;
import org.bukkit.event.block.BlockPistonRetractEvent;

public class PistonEvent implements Listener{
	CreativeManager plugin;

	public PistonEvent(CreativeManager instance)
	{
		plugin = instance;
	}

	@EventHandler(ignoreCancelled = true)
    public void onExtend(BlockPistonExtendEvent e)
    {
		if(plugin.getSettings().getProtection(Protections.LOOT))
		{
			BlockFace pistonDirection = e.getDirection();
			for (Block toMoveBlock:e.getBlocks()) {
				BlockLog blockLog = plugin.getDataManager().getBlockFrom(toMoveBlock.getLocation());
				if(blockLog != null)
				{
					if(blockLog.isCreative())
					{
						Location movedBlock = toMoveBlock.getLocation().add(pistonDirection.getModX(),
								pistonDirection.getModY(),
								pistonDirection.getModZ());
						plugin.getDataManager().moveBlock(toMoveBlock.getLocation(), movedBlock);
					}
				}
			}
		}
    }
	@EventHandler(ignoreCancelled = true)
	public void onRetract(BlockPistonRetractEvent e)
	{
		if(plugin.getSettings().getProtection(Protections.LOOT))
		{
			BlockFace pistonDirection = e.getDirection();
			for (Block toMoveBlock:e.getBlocks()) {
				BlockLog blockLog = plugin.getDataManager().getBlockFrom(toMoveBlock.getLocation());
				if(blockLog != null)
				{
					if(blockLog.isCreative())
					{
						Location movedBlock = toMoveBlock.getLocation().add(pistonDirection.getModX(),
								pistonDirection.getModY(),
								pistonDirection.getModZ());
						plugin.getDataManager().moveBlock(toMoveBlock.getLocation(), movedBlock);
					}
				}
			}
		}
	}
}