package com.craftworks.pearclient.event.impl;

import com.craftworks.pearclient.event.Event;

import net.minecraft.entity.Entity;

public class EventAttackEntity extends Event {
	
private Entity entity;
	
	public EventAttackEntity(Entity entity) {
		this.entity = entity;
	}

	public Entity getEntity() {
		return entity;
	}

}
