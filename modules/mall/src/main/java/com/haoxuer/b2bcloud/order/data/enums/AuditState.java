package com.haoxuer.b2bcloud.order.data.enums;

public enum AuditState {

    init, success, fail;

    public String toString() {
        if (this.name().equals("init")) {
            return "审核中";
        } else if (this.name().equals("success")) {
            return "审核成功";
        } else if (this.name().equals("fail")) {
            return "审核失败";
        } else {
            return this.name();
        }
    }
}
