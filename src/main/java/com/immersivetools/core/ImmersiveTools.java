package com.immersivetools.core;

import com.immersivetools.list.ItemList;
import com.immersivetools.tool.ItemExcavator;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.*;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.obj.MaterialLibrary;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


@Mod("immersivetools")
public class ImmersiveTools
{
    public static ImmersiveTools instance;
    public static final String modid = "immersivetools";
    public static final Logger logger = LogManager.getLogger(modid);
    public static final ItemGroup immersive_tools = new ITItemGroup();

    public ImmersiveTools()
    {
        instance = this;
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::clientRegistries);
        MinecraftForge.EVENT_BUS.register(this);
      //  ModLoadingContext.get().registerConfig(ModConfig.Type.SERVER, ConfigManager.sConfig);
      //  ConfigManager.loadConfig(ConfigManager.sConfig);
    }

    private void setup(final FMLCommonSetupEvent event)
    {

    }

    private void clientRegistries(final FMLClientSetupEvent event)
    {
    }

    @Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
    public static class RegistryEvents {

        @SubscribeEvent
        public static void regBlocks(final RegistryEvent.Register<Block> event) {
            event.getRegistry().registerAll();
        }

        @SubscribeEvent
        public static void regItems(final RegistryEvent.Register<Item> event) {
            event.getRegistry().registerAll(
                    ItemList.testExcavator = new ItemExcavator(ItemTier.IRON,1,1,new Item.Properties().group(immersive_tools)).setRegistryName("iron_excavator")

            );


        }

        private static ResourceLocation getResourceLocation(String name) {
            return new ResourceLocation(modid, name);
        }

    }
}
