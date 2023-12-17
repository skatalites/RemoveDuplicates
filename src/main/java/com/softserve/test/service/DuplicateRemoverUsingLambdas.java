package com.softserve.test.service;

import com.softserve.test.domain.DataTransfer;
import com.softserve.test.domain.DuplicateRemovalService;

import java.util.stream.Collectors;

public class DuplicateRemoverUsingLambdas implements DuplicateRemovalService {

    @Override
    public DataTransfer removeDuplicateValues(DataTransfer dataTransfer) {

        return DataTransfer.builder().outputData(
                        dataTransfer.inputData.chars()
                                .mapToObj(character -> (char) character)
                                .distinct()
                                .map(Object::toString)
                                .collect(Collectors.joining("")))
                .build();
    }

}
