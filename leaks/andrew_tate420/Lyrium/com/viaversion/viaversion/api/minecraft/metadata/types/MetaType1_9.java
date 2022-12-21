// 
// Decompiled by Procyon v0.5.36
// 

package com.viaversion.viaversion.api.minecraft.metadata.types;

import com.viaversion.viaversion.api.type.Type;
import com.viaversion.viaversion.api.minecraft.metadata.MetaType;

public enum MetaType1_9 implements MetaType
{
    Byte(0, (Type)Type.BYTE), 
    VarInt(1, (Type)Type.VAR_INT), 
    Float(2, (Type)Type.FLOAT), 
    String(3, (Type)Type.STRING), 
    Chat(4, (Type)Type.COMPONENT), 
    Slot(5, (Type)Type.ITEM), 
    Boolean(6, (Type)Type.BOOLEAN), 
    Vector3F(7, (Type)Type.ROTATION), 
    Position(8, (Type)Type.POSITION), 
    OptPosition(9, (Type)Type.OPTIONAL_POSITION), 
    Direction(10, (Type)Type.VAR_INT), 
    OptUUID(11, (Type)Type.OPTIONAL_UUID), 
    BlockID(12, (Type)Type.VAR_INT);
    
    private final int typeID;
    private final Type type;
    
    private MetaType1_9(final int typeID, final Type type) {
        this.typeID = typeID;
        this.type = type;
    }
    
    public static MetaType1_9 byId(final int id) {
        return values()[id];
    }
    
    @Override
    public int typeId() {
        return this.typeID;
    }
    
    @Override
    public Type type() {
        return this.type;
    }
}
