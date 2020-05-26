package com.immersivetools.core;

import com.immersivetools.list.ItemList;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;

public class ITItemGroup extends ItemGroup
{

    public ITItemGroup()
    {
        super("immersivetools");
    }

    @Override
    public ItemStack createIcon()
    {
        return new ItemStack(ItemList.testExcavator);
    }

}
