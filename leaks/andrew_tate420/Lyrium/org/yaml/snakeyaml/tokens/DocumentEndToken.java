// 
// Decompiled by Procyon v0.5.36
// 

package org.yaml.snakeyaml.tokens;

import org.yaml.snakeyaml.error.Mark;

public final class DocumentEndToken extends Token
{
    public DocumentEndToken(final Mark startMark, final Mark endMark) {
        super(startMark, endMark);
    }
    
    @Override
    public ID getTokenId() {
        return ID.DocumentEnd;
    }
}
