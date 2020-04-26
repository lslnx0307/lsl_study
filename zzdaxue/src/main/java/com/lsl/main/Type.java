package com.lsl.main;

/**
 * @author shiliang.li
 * @date 2020/4/10
 */
public enum Type {

    SHOE("shoe", "鞋子"),
    APPAREL("apparel", "服饰"),
    EQUIPMENT("equipment", "装备");

    private String type;

    private String typeName;

    public String getType() {
        return type;
    }

    public String getTypeName() {
        return typeName;
    }


    Type(String type, String typeName) {
        this.type = type;
        this.typeName = typeName;
    }
}
