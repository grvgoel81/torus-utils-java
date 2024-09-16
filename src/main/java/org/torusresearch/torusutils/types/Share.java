package org.torusresearch.torusutils.types;

import org.jetbrains.annotations.NotNull;
import org.torusresearch.torusutils.TorusUtils;
import org.torusresearch.torusutils.helpers.TorusUtilError;

import java.math.BigInteger;

public class Share {
    private final BigInteger share;
    private final BigInteger shareIndex;

    @SuppressWarnings("unused")
    public Share(@NotNull String shareIndex, @NotNull String share) throws Exception {
        try {
            this.shareIndex = new BigInteger(shareIndex, 16);
        } catch (NumberFormatException e) {
            throw new TorusUtilError("Invalid input", TorusUtils.getClientId());
        }

        try {
            this.share = new BigInteger(share, 16);
        } catch (NumberFormatException e) {
            throw new TorusUtilError("Invalid input", TorusUtils.getClientId());
        }
    }

    public Share(@NotNull BigInteger shareIndex, @NotNull BigInteger share) {
        this.shareIndex = shareIndex;
        this.share = share;
    }

    public BigInteger getShare() {
        return share;
    }

    public BigInteger getShareIndex() {
        return shareIndex;
    }

    // toString method for debugging purposes
    @Override
    public String toString() {
        return "Share{" +
                "share=" + share.toString(16) +
                ", shareIndex=" + shareIndex.toString(16) +
                '}';
    }
}
