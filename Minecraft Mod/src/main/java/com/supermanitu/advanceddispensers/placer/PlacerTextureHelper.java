package com.supermanitu.advanceddispensers.placer;

import com.supermanitu.advanceddispensers.main.AdvancedDispensersMod;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.init.Blocks;
import net.minecraft.util.IIcon;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class PlacerTextureHelper 
{
	@SideOnly(Side.CLIENT)
	private IIcon textureTop;
	@SideOnly(Side.CLIENT)
	private IIcon textureFront;
	@SideOnly(Side.CLIENT)
	private IIcon textureSide;
	@SideOnly(Side.CLIENT)
	private IIcon textureBottom;
	@SideOnly(Side.CLIENT)
	private IIcon textureTopVertical;
	@SideOnly(Side.CLIENT)
	private IIcon textureBottomVertical;
	
	public void registerBlockIcons(IIconRegister register)
	{
		textureBottom = Blocks.dispenser.getIcon(0, 1);
		textureSide = register.registerIcon(AdvancedDispensersMod.MODID+":"+"Placer_side");
		textureTop = register.registerIcon(AdvancedDispensersMod.MODID+":"+"Placer_top");
		textureFront = register.registerIcon(AdvancedDispensersMod.MODID+":"+"Placer_front");
		textureTopVertical = register.registerIcon(AdvancedDispensersMod.MODID+":"+"Placer_top_vertical");
		textureBottomVertical = register.registerIcon(AdvancedDispensersMod.MODID+":"+"Placer_bottom_vertical");
	}
	
	public IIcon getIcon(int side, int metadata)
	{
		switch(metadata)
		{
		case 0: return getDown(side);
		case 1: return getUp(side);
		
		default: return getSide(side, metadata);
		}
	}

	private IIcon getSide(int side, int metadata) 
	{
		IIcon ret = textureSide;
		
		switch(side)
		{
		case 0: return textureBottom;
		case 1: return textureTop;
		}
		
		if(side == metadata)
		{
			ret = textureFront;
		}
		
		return ret;
	}

	private IIcon getUp(int side) 
	{
		switch(side)
		{
		case 0: return textureBottom;
		case 1: return textureTopVertical;
		
		default: return textureSide;
		}
	}

	private IIcon getDown(int side)
	{
		switch(side)
		{
		case 0: return textureBottomVertical;
		case 1: return textureTop;
		
		default: return textureSide;
		}
	}
}
