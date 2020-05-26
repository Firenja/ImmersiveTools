package com.immersivetools.toolfunction;

import com.immersivetools.core.ImmersiveTools;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;

import java.util.Set;

public class ExcavatorFunction
{
    public static void checkBreakBlocks(World world, BlockPos pos, PlayerEntity player,Set<Block> values)
    {
        Direction face = player.getHorizontalFacing();
        for (int i = -1; i < 2; i++)
        {
            for (int j = -1; j < 2; j++)
            {
                if (face == Direction.NORTH || face == Direction.SOUTH)
                {
                    breakBlock(world, pos.add(i, j, 0), player,values);
                }
                else
                {
                    breakBlock(world, pos.add(0, i, j), player,values);
                }
            }
        }
    }


    private static void breakBlock(World world, BlockPos pos, PlayerEntity player,Set<Block> values)
    {
        if(values.contains(world.getBlockState(pos).getBlock()))
        {
            BlockState state = world.getBlockState(pos);
            world.destroyBlock(pos, false);
            Block.spawnDrops(state, world, pos, null, player, player.getHeldItemMainhand());
        }
    }
}
