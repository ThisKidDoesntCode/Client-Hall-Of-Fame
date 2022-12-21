// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.network.play.client;

import net.minecraft.network.INetHandler;
import java.io.IOException;
import net.minecraft.network.PacketBuffer;
import net.minecraft.network.play.INetHandlerPlayServer;
import net.minecraft.network.Packet;

public class C03PacketPlayer implements Packet<INetHandlerPlayServer>
{
    public double x;
    public double y;
    public double z;
    public float yaw;
    public float pitch;
    public boolean onGround;
    public boolean moving;
    public boolean rotating;
    
    public C03PacketPlayer() {
    }
    
    public C03PacketPlayer(final boolean isOnGround) {
        this.onGround = isOnGround;
    }
    
    @Override
    public void processPacket(final INetHandlerPlayServer handler) {
        handler.processPlayer(this);
    }
    
    @Override
    public void readPacketData(final PacketBuffer buf) throws IOException {
        this.onGround = (buf.readUnsignedByte() != 0);
    }
    
    @Override
    public void writePacketData(final PacketBuffer buf) throws IOException {
        buf.writeByte(this.onGround ? 1 : 0);
    }
    
    public void setX(final double x) {
        this.x = x;
    }
    
    public void setY(final double y) {
        this.y = y;
    }
    
    public void setZ(final double z) {
        this.z = z;
    }
    
    public double getX() {
        return this.x;
    }
    
    public double getY() {
        return this.y;
    }
    
    public double getZ() {
        return this.z;
    }
    
    public float getYaw() {
        return this.yaw;
    }
    
    public void setYaw(final float yaw) {
        this.yaw = yaw;
    }
    
    public float getPitch() {
        return this.pitch;
    }
    
    public void setPitch(final float pitch) {
        this.pitch = pitch;
    }
    
    public boolean isOnGround() {
        return this.onGround;
    }
    
    public void setOnGround(final boolean onGround) {
        this.onGround = onGround;
    }
    
    public boolean isMoving() {
        return this.moving;
    }
    
    public void setMoving(final boolean isMoving) {
        this.moving = isMoving;
    }
    
    public boolean getRotating() {
        return this.rotating;
    }
    
    public void setRotating(final boolean rotating) {
        this.rotating = rotating;
    }
    
    public static class C04PacketPlayerPosition extends C03PacketPlayer
    {
        public C04PacketPlayerPosition() {
            this.moving = true;
        }
        
        public C04PacketPlayerPosition(final double posX, final double posY, final double posZ, final boolean isOnGround) {
            this.x = posX;
            this.y = posY;
            this.z = posZ;
            this.onGround = isOnGround;
            this.moving = true;
        }
        
        @Override
        public void readPacketData(final PacketBuffer buf) throws IOException {
            this.x = buf.readDouble();
            this.y = buf.readDouble();
            this.z = buf.readDouble();
            super.readPacketData(buf);
        }
        
        @Override
        public void writePacketData(final PacketBuffer buf) throws IOException {
            buf.writeDouble(this.x);
            buf.writeDouble(this.y);
            buf.writeDouble(this.z);
            super.writePacketData(buf);
        }
    }
    
    public static class C05PacketPlayerLook extends C03PacketPlayer
    {
        public C05PacketPlayerLook() {
            this.rotating = true;
        }
        
        public C05PacketPlayerLook(final float playerYaw, final float playerPitch, final boolean isOnGround) {
            this.yaw = playerYaw;
            this.pitch = playerPitch;
            this.onGround = isOnGround;
            this.rotating = true;
        }
        
        @Override
        public void readPacketData(final PacketBuffer buf) throws IOException {
            this.yaw = buf.readFloat();
            this.pitch = buf.readFloat();
            super.readPacketData(buf);
        }
        
        @Override
        public void writePacketData(final PacketBuffer buf) throws IOException {
            buf.writeFloat(this.yaw);
            buf.writeFloat(this.pitch);
            super.writePacketData(buf);
        }
    }
    
    public static class C06PacketPlayerPosLook extends C03PacketPlayer
    {
        public C06PacketPlayerPosLook() {
            this.moving = true;
            this.rotating = true;
        }
        
        public C06PacketPlayerPosLook(final double playerX, final double playerY, final double playerZ, final float playerYaw, final float playerPitch, final boolean playerIsOnGround) {
            this.x = playerX;
            this.y = playerY;
            this.z = playerZ;
            this.yaw = playerYaw;
            this.pitch = playerPitch;
            this.onGround = playerIsOnGround;
            this.rotating = true;
            this.moving = true;
        }
        
        public C06PacketPlayerPosLook(final double playerX, final double playerY, final double playerZ, final float playerYaw, final float playerPitch, final boolean playerIsOnGround, final boolean moving) {
            this.x = playerX;
            this.y = playerY;
            this.z = playerZ;
            this.yaw = playerYaw;
            this.pitch = playerPitch;
            this.onGround = playerIsOnGround;
            this.rotating = true;
            this.moving = moving;
        }
        
        @Override
        public void readPacketData(final PacketBuffer buf) throws IOException {
            this.x = buf.readDouble();
            this.y = buf.readDouble();
            this.z = buf.readDouble();
            this.yaw = buf.readFloat();
            this.pitch = buf.readFloat();
            super.readPacketData(buf);
        }
        
        @Override
        public void writePacketData(final PacketBuffer buf) throws IOException {
            buf.writeDouble(this.x);
            buf.writeDouble(this.y);
            buf.writeDouble(this.z);
            buf.writeFloat(this.yaw);
            buf.writeFloat(this.pitch);
            super.writePacketData(buf);
        }
    }
}
