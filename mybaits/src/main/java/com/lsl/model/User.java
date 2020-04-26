package com.lsl.model;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

/**
 * @author shiliang.li
 * @version 1.0.0
 * @Title: lsl_study
 * @Package com.lsl.model
 * @Description: :
 * @time 2020/3/6 16:15
 */
@Data
@ToString
public class User implements Serializable {

    private static final long serialVersionUID = -3586955177048538974L;

    private Integer id;
    private String name;
    private String age;
}
