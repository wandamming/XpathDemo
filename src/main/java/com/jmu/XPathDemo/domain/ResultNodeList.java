package com.jmu.XPathDemo.domain;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;
@Data
public class ResultNodeList {

    private List<String> name = new ArrayList<>();

    private List<String> content = new ArrayList<>();

    private int num;
}
