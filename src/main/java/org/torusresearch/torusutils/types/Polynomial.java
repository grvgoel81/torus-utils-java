package org.torusresearch.torusutils.types;

import static org.torusresearch.torusutils.helpers.KeyUtils.getOrderOfCurve;

import java.math.BigInteger;
import java.util.HashMap;

public class Polynomial {
    private BigInteger[] polynomial;

    public Polynomial(BigInteger[] polynomial) {
        this.polynomial = polynomial;
    }

    public int getThreshold() {
        return polynomial.length;
    }

    /*public BigInteger polyEval(BigInteger x) {
        BigInteger tmpX = x;
        BigInteger xi = new BigInteger(tmpX.toByteArray());
        BigInteger sum = BigInteger.ZERO.add(polynomial[0]);
        for (int i = 1; i < polynomial.length; i++) {
            BigInteger tmp = xi.multiply(polynomial[i]);
            sum = sum.add(tmp);
            sum = sum.mod(secp256k1N);
            xi = xi.multiply(new BigInteger(tmpX.toByteArray()));
            xi = xi.mod(secp256k1N);
        }
        return sum;
    }*/

    public BigInteger polyEval(BigInteger x) {
        BigInteger tmpX = x;
        BigInteger xi = new BigInteger(tmpX.toString());
        BigInteger sum = BigInteger.ZERO;
        BigInteger orderOfCurve = getOrderOfCurve();

        sum = sum.add(polynomial[0]);
        for (int i = 1; i < polynomial.length; i++) {
            BigInteger tmp = xi.multiply(polynomial[i]);
            sum = sum.add(tmp).mod(orderOfCurve);
            xi = xi.multiply(tmpX).mod(orderOfCurve);
        }

        return sum;
    }

    public HashMap<String, Share> generateShares(BigInteger[] shareIndexes) { // TODO: Check these indexes are correct, i.e ordering starts at 0, not 1
        HashMap<String, Share> shares = new HashMap<>();

        for (BigInteger shareIndex : shareIndexes) {
            String hexString = String.format("%064x", shareIndex);
            shares.put(hexString, new Share(shareIndex, polyEval(shareIndex)));
        }

        return shares;
    }
}

