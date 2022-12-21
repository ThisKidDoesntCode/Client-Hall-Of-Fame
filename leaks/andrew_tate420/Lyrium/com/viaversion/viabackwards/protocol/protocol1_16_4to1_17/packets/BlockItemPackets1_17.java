// 
// Decompiled by Procyon v0.5.36
// 

package com.viaversion.viabackwards.protocol.protocol1_16_4to1_17.packets;

import com.viaversion.viaversion.api.protocol.AbstractProtocol;
import com.viaversion.viabackwards.api.rewriters.MapColorRewriter;
import com.viaversion.viabackwards.protocol.protocol1_16_4to1_17.data.MapColorRewrites;
import com.viaversion.viaversion.libs.opennbt.tag.builtin.CompoundTag;
import com.viaversion.viaversion.libs.opennbt.tag.builtin.NumberTag;
import com.viaversion.viaversion.util.CompactArrayUtil;
import com.viaversion.viaversion.util.MathUtil;
import com.viaversion.viaversion.libs.opennbt.tag.builtin.LongArrayTag;
import com.viaversion.viaversion.libs.opennbt.tag.builtin.Tag;
import com.viaversion.viaversion.api.minecraft.chunks.ChunkSection;
import java.util.Arrays;
import com.viaversion.viaversion.protocols.protocol1_16_2to1_16_1.types.Chunk1_16_2Type;
import com.viaversion.viaversion.protocols.protocol1_17to1_16_4.types.Chunk1_17Type;
import com.viaversion.viaversion.api.minecraft.chunks.Chunk;
import com.viaversion.viaversion.api.minecraft.Position;
import com.viaversion.viaversion.api.minecraft.BlockChangeRecord;
import java.util.Iterator;
import java.util.List;
import java.util.ArrayList;
import com.viaversion.viaversion.api.data.entity.EntityTracker;
import java.util.BitSet;
import com.viaversion.viaversion.protocols.protocol1_16_2to1_16_1.ClientboundPackets1_16_2;
import com.viaversion.viaversion.api.protocol.packet.PacketType;
import com.viaversion.viaversion.protocols.protocol1_17to1_16_4.ServerboundPackets1_17;
import com.viaversion.viabackwards.protocol.protocol1_16_4to1_17.storage.PingRequests;
import com.viaversion.viabackwards.ViaBackwards;
import com.viaversion.viabackwards.protocol.protocol1_16_4to1_17.storage.PlayerLastCursorItem;
import com.viaversion.viaversion.api.protocol.packet.PacketWrapper;
import com.viaversion.viaversion.api.minecraft.item.Item;
import com.viaversion.viaversion.api.protocol.remapper.PacketRemapper;
import com.viaversion.viaversion.api.protocol.packet.ServerboundPacketType;
import com.viaversion.viaversion.protocols.protocol1_16_2to1_16_1.ServerboundPackets1_16_2;
import com.viaversion.viaversion.api.protocol.packet.ClientboundPacketType;
import com.viaversion.viaversion.protocols.protocol1_17to1_16_4.ClientboundPackets1_17;
import com.viaversion.viaversion.protocols.protocol1_16to1_15_2.data.RecipeRewriter1_16;
import com.viaversion.viaversion.api.protocol.Protocol;
import com.viaversion.viaversion.rewriter.BlockRewriter;
import com.viaversion.viaversion.api.type.Type;
import com.viaversion.viabackwards.protocol.protocol1_16_4to1_17.Protocol1_16_4To1_17;
import com.viaversion.viabackwards.api.rewriters.ItemRewriter;

public final class BlockItemPackets1_17 extends ItemRewriter<Protocol1_16_4To1_17>
{
    public BlockItemPackets1_17(final Protocol1_16_4To1_17 protocol) {
        super(protocol);
    }
    
    @Override
    protected void registerPackets() {
        final BlockRewriter blockRewriter = new BlockRewriter(this.protocol, Type.POSITION1_14);
        new RecipeRewriter1_16(this.protocol).registerDefaultHandler(ClientboundPackets1_17.DECLARE_RECIPES);
        this.registerSetCooldown(ClientboundPackets1_17.COOLDOWN);
        this.registerWindowItems(ClientboundPackets1_17.WINDOW_ITEMS, Type.FLAT_VAR_INT_ITEM_ARRAY);
        this.registerEntityEquipmentArray(ClientboundPackets1_17.ENTITY_EQUIPMENT, Type.FLAT_VAR_INT_ITEM);
        this.registerTradeList(ClientboundPackets1_17.TRADE_LIST, Type.FLAT_VAR_INT_ITEM);
        this.registerAdvancements(ClientboundPackets1_17.ADVANCEMENTS, Type.FLAT_VAR_INT_ITEM);
        blockRewriter.registerAcknowledgePlayerDigging(ClientboundPackets1_17.ACKNOWLEDGE_PLAYER_DIGGING);
        blockRewriter.registerBlockAction(ClientboundPackets1_17.BLOCK_ACTION);
        blockRewriter.registerEffect(ClientboundPackets1_17.EFFECT, 1010, 2001);
        this.registerCreativeInvAction(ServerboundPackets1_16_2.CREATIVE_INVENTORY_ACTION, Type.FLAT_VAR_INT_ITEM);
        ((AbstractProtocol<C1, C2, S1, ServerboundPackets1_16_2>)this.protocol).registerServerbound(ServerboundPackets1_16_2.EDIT_BOOK, new PacketRemapper() {
            @Override
            public void registerMap() {
                this.handler(wrapper -> BlockItemPackets1_17.this.handleItemToServer(wrapper.passthrough(Type.FLAT_VAR_INT_ITEM)));
            }
        });
        ((AbstractProtocol<C1, C2, S1, ServerboundPackets1_16_2>)this.protocol).registerServerbound(ServerboundPackets1_16_2.CLICK_WINDOW, new PacketRemapper() {
            @Override
            public void registerMap() {
                this.map(Type.UNSIGNED_BYTE);
                final short slot;
                final byte button;
                final int mode;
                final Item clicked;
                final PlayerLastCursorItem state;
                final Item carried;
                this.handler(wrapper -> {
                    slot = wrapper.passthrough((Type<Short>)Type.SHORT);
                    button = wrapper.passthrough((Type<Byte>)Type.BYTE);
                    wrapper.read((Type<Object>)Type.SHORT);
                    mode = wrapper.passthrough((Type<Integer>)Type.VAR_INT);
                    clicked = BlockItemPackets1_17.this.handleItemToServer(wrapper.read(Type.FLAT_VAR_INT_ITEM));
                    wrapper.write(Type.VAR_INT, 0);
                    state = wrapper.user().get(PlayerLastCursorItem.class);
                    Label_0220_1: {
                        if (mode == 0 && button == 0 && clicked != null) {
                            state.setLastCursorItem(clicked);
                        }
                        else if (mode == 0 && button == 1 && clicked != null) {
                            if (state.isSet()) {
                                state.setLastCursorItem(clicked);
                            }
                            else {
                                state.setLastCursorItem(clicked, (clicked.amount() + 1) / 2);
                            }
                        }
                        else {
                            if (mode == 5 && slot == -999) {
                                if (button != 0) {
                                    if (button == 4) {
                                        break Label_0220_1;
                                    }
                                }
                                else {
                                    break Label_0220_1;
                                }
                            }
                            state.setLastCursorItem(null);
                        }
                    }
                    carried = state.getLastCursorItem();
                    if (carried == null) {
                        wrapper.write(Type.FLAT_VAR_INT_ITEM, clicked);
                    }
                    else {
                        wrapper.write(Type.FLAT_VAR_INT_ITEM, carried);
                    }
                });
            }
        });
        ((AbstractProtocol<ClientboundPackets1_17, C2, S1, S2>)this.protocol).registerClientbound(ClientboundPackets1_17.SET_SLOT, new PacketRemapper() {
            @Override
            public void registerMap() {
                final short windowId;
                final short slot;
                final Item carried;
                this.handler(wrapper -> {
                    windowId = wrapper.passthrough((Type<Short>)Type.UNSIGNED_BYTE);
                    slot = wrapper.passthrough((Type<Short>)Type.SHORT);
                    carried = wrapper.read(Type.FLAT_VAR_INT_ITEM);
                    if (carried != null && windowId == -1 && slot == -1) {
                        wrapper.user().get(PlayerLastCursorItem.class).setLastCursorItem(carried);
                    }
                    wrapper.write(Type.FLAT_VAR_INT_ITEM, BlockItemPackets1_17.this.handleItemToClient(carried));
                });
            }
        });
        ((Protocol<C1, C2, ServerboundPackets1_17, ServerboundPackets1_16_2>)this.protocol).registerServerbound(ServerboundPackets1_16_2.WINDOW_CONFIRMATION, null, new PacketRemapper() {
            @Override
            public void registerMap() {
                short inventoryId;
                short confirmationId;
                boolean accepted;
                PacketWrapper pongPacket;
                this.handler(wrapper -> {
                    wrapper.cancel();
                    if (!(!ViaBackwards.getConfig().handlePingsAsInvAcknowledgements())) {
                        inventoryId = wrapper.read((Type<Short>)Type.UNSIGNED_BYTE);
                        confirmationId = wrapper.read((Type<Short>)Type.SHORT);
                        accepted = wrapper.read((Type<Boolean>)Type.BOOLEAN);
                        if (inventoryId == 0 && accepted && wrapper.user().get(PingRequests.class).removeId(confirmationId)) {
                            pongPacket = wrapper.create(ServerboundPackets1_17.PONG);
                            pongPacket.write(Type.INT, (int)confirmationId);
                            pongPacket.sendToServer(Protocol1_16_4To1_17.class);
                        }
                    }
                });
            }
        });
        ((AbstractProtocol<ClientboundPackets1_17, C2, S1, S2>)this.protocol).registerClientbound(ClientboundPackets1_17.SPAWN_PARTICLE, new PacketRemapper() {
            @Override
            public void registerMap() {
                this.map(Type.INT);
                this.map(Type.BOOLEAN);
                this.map(Type.DOUBLE);
                this.map(Type.DOUBLE);
                this.map(Type.DOUBLE);
                this.map(Type.FLOAT);
                this.map(Type.FLOAT);
                this.map(Type.FLOAT);
                this.map(Type.FLOAT);
                this.map(Type.INT);
                final int id;
                this.handler(wrapper -> {
                    id = wrapper.get((Type<Integer>)Type.INT, 0);
                    if (id == 16) {
                        wrapper.passthrough((Type<Object>)Type.FLOAT);
                        wrapper.passthrough((Type<Object>)Type.FLOAT);
                        wrapper.passthrough((Type<Object>)Type.FLOAT);
                        wrapper.passthrough((Type<Object>)Type.FLOAT);
                        wrapper.read((Type<Object>)Type.FLOAT);
                        wrapper.read((Type<Object>)Type.FLOAT);
                        wrapper.read((Type<Object>)Type.FLOAT);
                    }
                    else if (id == 37) {
                        wrapper.set(Type.INT, 0, -1);
                        wrapper.cancel();
                    }
                    return;
                });
                this.handler(BlockItemPackets1_17.this.getSpawnParticleHandler(Type.FLAT_VAR_INT_ITEM));
            }
        });
        ((Protocol1_16_4To1_17)this.protocol).mergePacket(ClientboundPackets1_17.WORLD_BORDER_SIZE, ClientboundPackets1_16_2.WORLD_BORDER, 0);
        ((Protocol1_16_4To1_17)this.protocol).mergePacket(ClientboundPackets1_17.WORLD_BORDER_LERP_SIZE, ClientboundPackets1_16_2.WORLD_BORDER, 1);
        ((Protocol1_16_4To1_17)this.protocol).mergePacket(ClientboundPackets1_17.WORLD_BORDER_CENTER, ClientboundPackets1_16_2.WORLD_BORDER, 2);
        ((Protocol1_16_4To1_17)this.protocol).mergePacket(ClientboundPackets1_17.WORLD_BORDER_INIT, ClientboundPackets1_16_2.WORLD_BORDER, 3);
        ((Protocol1_16_4To1_17)this.protocol).mergePacket(ClientboundPackets1_17.WORLD_BORDER_WARNING_DELAY, ClientboundPackets1_16_2.WORLD_BORDER, 4);
        ((Protocol1_16_4To1_17)this.protocol).mergePacket(ClientboundPackets1_17.WORLD_BORDER_WARNING_DISTANCE, ClientboundPackets1_16_2.WORLD_BORDER, 5);
        ((AbstractProtocol<ClientboundPackets1_17, C2, S1, S2>)this.protocol).registerClientbound(ClientboundPackets1_17.UPDATE_LIGHT, new PacketRemapper() {
            @Override
            public void registerMap() {
                this.map(Type.VAR_INT);
                this.map(Type.VAR_INT);
                this.map(Type.BOOLEAN);
                final EntityTracker tracker;
                final int startFromSection;
                final long[] skyLightMask;
                final long[] blockLightMask;
                final int cutSkyLightMask;
                final int cutBlockLightMask;
                final long[] emptySkyLightMask;
                final long[] emptyBlockLightMask;
                this.handler(wrapper -> {
                    tracker = wrapper.user().getEntityTracker(Protocol1_16_4To1_17.class);
                    startFromSection = Math.max(0, -(tracker.currentMinY() >> 4));
                    skyLightMask = wrapper.read(Type.LONG_ARRAY_PRIMITIVE);
                    blockLightMask = wrapper.read(Type.LONG_ARRAY_PRIMITIVE);
                    cutSkyLightMask = BlockItemPackets1_17.this.cutLightMask(skyLightMask, startFromSection);
                    cutBlockLightMask = BlockItemPackets1_17.this.cutLightMask(blockLightMask, startFromSection);
                    wrapper.write(Type.VAR_INT, cutSkyLightMask);
                    wrapper.write(Type.VAR_INT, cutBlockLightMask);
                    emptySkyLightMask = wrapper.read(Type.LONG_ARRAY_PRIMITIVE);
                    emptyBlockLightMask = wrapper.read(Type.LONG_ARRAY_PRIMITIVE);
                    wrapper.write(Type.VAR_INT, BlockItemPackets1_17.this.cutLightMask(emptySkyLightMask, startFromSection));
                    wrapper.write(Type.VAR_INT, BlockItemPackets1_17.this.cutLightMask(emptyBlockLightMask, startFromSection));
                    this.writeLightArrays(wrapper, BitSet.valueOf(skyLightMask), cutSkyLightMask, startFromSection, tracker.currentWorldSectionHeight());
                    this.writeLightArrays(wrapper, BitSet.valueOf(blockLightMask), cutBlockLightMask, startFromSection, tracker.currentWorldSectionHeight());
                });
            }
            
            private void writeLightArrays(final PacketWrapper wrapper, final BitSet bitMask, final int cutBitMask, final int startFromSection, final int sectionHeight) throws Exception {
                wrapper.read((Type<Object>)Type.VAR_INT);
                final List<byte[]> light = new ArrayList<byte[]>();
                for (int i = 0; i < startFromSection; ++i) {
                    if (bitMask.get(i)) {
                        wrapper.read(Type.BYTE_ARRAY_PRIMITIVE);
                    }
                }
                for (int i = 0; i < 18; ++i) {
                    if (this.isSet(cutBitMask, i)) {
                        light.add(wrapper.read(Type.BYTE_ARRAY_PRIMITIVE));
                    }
                }
                for (int i = startFromSection + 18; i < sectionHeight + 2; ++i) {
                    if (bitMask.get(i)) {
                        wrapper.read(Type.BYTE_ARRAY_PRIMITIVE);
                    }
                }
                for (final byte[] bytes : light) {
                    wrapper.write(Type.BYTE_ARRAY_PRIMITIVE, bytes);
                }
            }
            
            private boolean isSet(final int mask, final int i) {
                return (mask & 1 << i) != 0x0;
            }
        });
        ((AbstractProtocol<ClientboundPackets1_17, C2, S1, S2>)this.protocol).registerClientbound(ClientboundPackets1_17.MULTI_BLOCK_CHANGE, new PacketRemapper() {
            @Override
            public void registerMap() {
                this.map(Type.LONG);
                this.map(Type.BOOLEAN);
                final long chunkPos;
                final int chunkY;
                BlockChangeRecord[] array;
                BlockChangeRecord[] records;
                int length;
                int i = 0;
                BlockChangeRecord record;
                this.handler(wrapper -> {
                    chunkPos = wrapper.get((Type<Long>)Type.LONG, 0);
                    chunkY = (int)(chunkPos << 44 >> 44);
                    if (chunkY < 0 || chunkY > 15) {
                        wrapper.cancel();
                    }
                    else {
                        records = (array = wrapper.passthrough(Type.VAR_LONG_BLOCK_CHANGE_RECORD_ARRAY));
                        for (length = array.length; i < length; ++i) {
                            record = array[i];
                            record.setBlockId(((Protocol1_16_4To1_17)BlockItemPackets1_17.this.protocol).getMappingData().getNewBlockStateId(record.getBlockId()));
                        }
                    }
                });
            }
        });
        ((AbstractProtocol<ClientboundPackets1_17, C2, S1, S2>)this.protocol).registerClientbound(ClientboundPackets1_17.BLOCK_CHANGE, new PacketRemapper() {
            @Override
            public void registerMap() {
                this.map(Type.POSITION1_14);
                this.map(Type.VAR_INT);
                final int y;
                this.handler(wrapper -> {
                    y = wrapper.get(Type.POSITION1_14, 0).getY();
                    if (y < 0 || y > 255) {
                        wrapper.cancel();
                    }
                    else {
                        wrapper.set(Type.VAR_INT, 0, ((Protocol1_16_4To1_17)BlockItemPackets1_17.this.protocol).getMappingData().getNewBlockStateId(wrapper.get((Type<Integer>)Type.VAR_INT, 0)));
                    }
                });
            }
        });
        ((AbstractProtocol<ClientboundPackets1_17, C2, S1, S2>)this.protocol).registerClientbound(ClientboundPackets1_17.CHUNK_DATA, new PacketRemapper() {
            @Override
            public void registerMap() {
                final EntityTracker tracker;
                final int currentWorldSectionHeight;
                final Chunk chunk;
                final int startFromSection;
                final ChunkSection[] sections;
                final CompoundTag heightMaps;
                final Iterator<Tag> iterator;
                Tag heightMapTag;
                LongArrayTag heightMap;
                int[] heightMapData;
                int bitsPerEntry;
                int j;
                ChunkSection section;
                int k;
                int old;
                final NumberTag tag;
                this.handler(wrapper -> {
                    tracker = wrapper.user().getEntityTracker(Protocol1_16_4To1_17.class);
                    currentWorldSectionHeight = tracker.currentWorldSectionHeight();
                    chunk = wrapper.read((Type<Chunk>)new Chunk1_17Type(currentWorldSectionHeight));
                    wrapper.write(new Chunk1_16_2Type(), chunk);
                    startFromSection = Math.max(0, -(tracker.currentMinY() >> 4));
                    chunk.setBiomeData(Arrays.copyOfRange(chunk.getBiomeData(), startFromSection * 64, startFromSection * 64 + 1024));
                    chunk.setBitmask(BlockItemPackets1_17.this.cutMask(chunk.getChunkMask(), startFromSection, false));
                    chunk.setChunkMask(null);
                    sections = Arrays.copyOfRange(chunk.getSections(), startFromSection, startFromSection + 16);
                    chunk.setSections(sections);
                    heightMaps = chunk.getHeightMap();
                    heightMaps.values().iterator();
                    while (iterator.hasNext()) {
                        heightMapTag = iterator.next();
                        heightMap = (LongArrayTag)heightMapTag;
                        heightMapData = new int[256];
                        bitsPerEntry = MathUtil.ceilLog2((currentWorldSectionHeight << 4) + 1);
                        CompactArrayUtil.iterateCompactArrayWithPadding(bitsPerEntry, heightMapData.length, heightMap.getValue(), (i, v) -> heightMapData[i] = MathUtil.clamp(v + tracker.currentMinY(), 0, 255));
                        heightMap.setValue(CompactArrayUtil.createCompactArrayWithPadding(9, heightMapData.length, i -> heightMapData[i]));
                    }
                    for (j = 0; j < 16; ++j) {
                        section = sections[j];
                        if (section != null) {
                            for (k = 0; k < section.getPaletteSize(); ++k) {
                                old = section.getPaletteEntry(k);
                                section.setPaletteEntry(k, ((Protocol1_16_4To1_17)BlockItemPackets1_17.this.protocol).getMappingData().getNewBlockStateId(old));
                            }
                        }
                    }
                    chunk.getBlockEntities().removeIf(compound -> {
                        tag = (NumberTag)compound.get("y");
                        return tag != null && (tag.asInt() < 0 || tag.asInt() > 255);
                    });
                });
            }
        });
        ((AbstractProtocol<ClientboundPackets1_17, C2, S1, S2>)this.protocol).registerClientbound(ClientboundPackets1_17.BLOCK_ENTITY_DATA, new PacketRemapper() {
            @Override
            public void registerMap() {
                final int y;
                this.handler(wrapper -> {
                    y = wrapper.passthrough(Type.POSITION1_14).getY();
                    if (y < 0 || y > 255) {
                        wrapper.cancel();
                    }
                });
            }
        });
        ((AbstractProtocol<ClientboundPackets1_17, C2, S1, S2>)this.protocol).registerClientbound(ClientboundPackets1_17.BLOCK_BREAK_ANIMATION, new PacketRemapper() {
            @Override
            public void registerMap() {
                this.map(Type.VAR_INT);
                final int y;
                this.handler(wrapper -> {
                    y = wrapper.passthrough(Type.POSITION1_14).getY();
                    if (y < 0 || y > 255) {
                        wrapper.cancel();
                    }
                });
            }
        });
        ((AbstractProtocol<ClientboundPackets1_17, C2, S1, S2>)this.protocol).registerClientbound(ClientboundPackets1_17.MAP_DATA, new PacketRemapper() {
            @Override
            public void registerMap() {
                this.map(Type.VAR_INT);
                this.map(Type.BYTE);
                this.handler(wrapper -> wrapper.write(Type.BOOLEAN, true));
                this.map(Type.BOOLEAN);
                final boolean hasMarkers;
                this.handler(wrapper -> {
                    hasMarkers = wrapper.read((Type<Boolean>)Type.BOOLEAN);
                    if (!hasMarkers) {
                        wrapper.write(Type.VAR_INT, 0);
                    }
                    else {
                        MapColorRewriter.getRewriteHandler(MapColorRewrites::getMappedColor).handle(wrapper);
                    }
                });
            }
        });
    }
    
    private int cutLightMask(final long[] mask, final int startFromSection) {
        if (mask.length == 0) {
            return 0;
        }
        return this.cutMask(BitSet.valueOf(mask), startFromSection, true);
    }
    
    private int cutMask(final BitSet mask, final int startFromSection, final boolean lightMask) {
        int cutMask = 0;
        for (int to = startFromSection + (lightMask ? 18 : 16), i = startFromSection, j = 0; i < to; ++i, ++j) {
            if (mask.get(i)) {
                cutMask |= 1 << j;
            }
        }
        return cutMask;
    }
}
