package com.zkb.framework.web.domain.server;


import com.zkb.common.utils.Arith;

/**
 * 內存相关信息
 *
 * @author KingPrimes
 */
public class Mem {
    /**
     * 内存总量
     */
    private double total;

    /**
     * 已用内存
     */
    private double used;

    /**
     * 剩余内存
     */
    private double free;

    /**
     * 内存总量
     */
    public double getTotal() {
        return Arith.div(total, (1024 * 1024 * 1024), 2);
    }

    public void setTotal(long total) {
        this.total = total;
    }

    /**
     * 已用内存
     */
    public double getUsed() {
        return Arith.div(used, (1024 * 1024 * 1024), 2);
    }

    public void setUsed(long used) {
        this.used = used;
    }

    /**
     * 剩余内存
     */
    public double getFree() {
        return Arith.div(free, (1024 * 1024 * 1024), 2);
    }

    public void setFree(long free) {
        this.free = free;
    }

    public double getUsage() {
        return Arith.mul(Arith.div(used, total, 4), 100);
    }
}
