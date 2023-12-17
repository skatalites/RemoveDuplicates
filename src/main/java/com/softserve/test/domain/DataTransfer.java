package com.softserve.test.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;

@Builder
@AllArgsConstructor
public class DataTransfer {

    public String inputData;
    public String outputData;

}
