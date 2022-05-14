package com.jmu.XPathDemo.service;

import com.jmu.XPathDemo.domain.ResultNodeList;

public interface MyService {

    ResultNodeList xPathTest(String xpathStr) throws Exception;

}
