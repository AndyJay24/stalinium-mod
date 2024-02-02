package io.github.andyjay24.stalinium_mod;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.Items;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import org.quiltmc.loader.api.ModContainer;
import org.quiltmc.qsl.base.api.entrypoint.ModInitializer;
import org.quiltmc.qsl.block.extensions.api.QuiltBlockSettings;
import org.quiltmc.qsl.item.setting.api.QuiltItemSettings;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class StaliniumMod implements ModInitializer {
	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod name as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.
	public static final Logger LOGGER = LoggerFactory.getLogger("Example Mod");
	public static final Block STALINIUM_BLOCK = new Block(QuiltBlockSettings.create());
	public static final Item STALINIUM_SHEET = new Item(new QuiltItemSettings());
	public static final Item PROCESSED_IRON_INGOT = new Item(new QuiltItemSettings());

	@Override
	public void onInitialize(ModContainer mod)
	{
		LOGGER.info("Booted Stalinium Mod Successfully.");

		//Stalinium Sheet Stuff
		//Registering the item
		Registry.register(Registries.ITEM, new Identifier(mod.metadata().id(), "stalinium_sheet"), STALINIUM_SHEET);
		//Adding the stalinium sheet to the materials tab
		ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(entries -> {
			entries.addAfter(Items.NETHERITE_INGOT, STALINIUM_SHEET);
		});

		//Processed Iron Ingot Stuff
		//Registering the item
		Registry.register(Registries.ITEM, new Identifier(mod.metadata().id(), "processed_iron_ingot"), PROCESSED_IRON_INGOT);
		//Adding ingot to materials group
		ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(entries -> {
			entries.addAfter(Items.IRON_INGOT, PROCESSED_IRON_INGOT);
		});

		//Stalinium Block Stuff
		//Registering the block into the block registry
		Registry.register(Registries.BLOCK, new Identifier(mod.metadata().id(), "stalinium_block"), STALINIUM_BLOCK);
		//Registering the block as an item
		Registry.register(Registries.ITEM, new Identifier(mod.metadata().id(), "stalinium_block"), new BlockItem(STALINIUM_BLOCK, new QuiltItemSettings()));
		//Adding the block item to the building blocks group
		ItemGroupEvents.modifyEntriesEvent(ItemGroups.BUILDING_BLOCKS).register(entries -> {
			entries.addAfter(Items.NETHERITE_BLOCK, STALINIUM_BLOCK.asItem());
		});


	}
}
