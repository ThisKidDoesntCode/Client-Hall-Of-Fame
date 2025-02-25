/*
 * Decompiled with CFR 0.152.
 */
package net.optifine.entity.model;

import java.util.ArrayList;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.optifine.entity.model.IEntityRenderer;

public abstract class ModelAdapter {
    private Class entityClass;
    private String name;
    private float shadowSize;
    private String[] aliases;

    public ModelAdapter(Class entityClass, String name, float shadowSize) {
        this.entityClass = entityClass;
        this.name = name;
        this.shadowSize = shadowSize;
    }

    public ModelAdapter(Class entityClass, String name, float shadowSize, String[] aliases) {
        this.entityClass = entityClass;
        this.name = name;
        this.shadowSize = shadowSize;
        this.aliases = aliases;
    }

    public Class getEntityClass() {
        return this.entityClass;
    }

    public String getName() {
        return this.name;
    }

    public String[] getAliases() {
        return this.aliases;
    }

    public float getShadowSize() {
        return this.shadowSize;
    }

    public abstract ModelBase makeModel();

    public abstract ModelRenderer getModelRenderer(ModelBase var1, String var2);

    public abstract String[] getModelRendererNames();

    public abstract IEntityRenderer makeEntityRender(ModelBase var1, float var2);

    public ModelRenderer[] getModelRenderers(ModelBase model) {
        String[] astring = this.getModelRendererNames();
        ArrayList<ModelRenderer> list = new ArrayList<ModelRenderer>();
        for (int i = 0; i < astring.length; ++i) {
            String s = astring[i];
            ModelRenderer modelrenderer = this.getModelRenderer(model, s);
            if (modelrenderer == null) continue;
            list.add(modelrenderer);
        }
        ModelRenderer[] amodelrenderer = list.toArray(new ModelRenderer[list.size()]);
        return amodelrenderer;
    }
}

