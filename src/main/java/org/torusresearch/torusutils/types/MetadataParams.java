package org.torusresearch.torusutils.types;

public class MetadataParams extends MetadataPubKey {
    private final MetadataSetData set_data;
    private final String signature;

    //private final KeyType key_type;

    public MetadataParams(String pub_key_X, String pub_key_Y, MetadataSetData set_data, String signature) {
        super(pub_key_X, pub_key_Y);
        this.set_data = set_data;
        this.signature = signature;
        //this.key_type = key_type;
    }

    public MetadataSetData getSet_data() {
        return set_data;
    }

    public String getSignature() {
        return signature;
    }

    //public KeyType getKey_type() { return key_type; }

    public static class MetadataSetData {
        private final String data;
        // timestamp in hex
        private final String timestamp;

        public MetadataSetData(String data, String timestamp) {
            this.data = data;
            this.timestamp = timestamp;
        }

        public String getData() {
            return data;
        }

        public String getTimestamp() {
            return timestamp;
        }
    }
}
