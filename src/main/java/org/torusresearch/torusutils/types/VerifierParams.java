package org.torusresearch.torusutils.types;

import org.jetbrains.annotations.NotNull;

import io.reactivex.annotations.Nullable;

public class VerifierParams {
    public final String verifier_id;
    @Nullable
    public final String extended_verifier_id;
    @Nullable
    public final String[] sub_verifier_ids;
    @Nullable
    public final VerifyParams[] verify_params;

    public VerifierParams(@NotNull String verifierId, @Nullable String extendedVerifierId, @Nullable String[] subVerifierIds, @Nullable VerifyParams[] verifyParams) {
        this.verifier_id = verifierId;
        this.extended_verifier_id = extendedVerifierId;
        this.verify_params = verifyParams;
        this.sub_verifier_ids = subVerifierIds;
    }
}

