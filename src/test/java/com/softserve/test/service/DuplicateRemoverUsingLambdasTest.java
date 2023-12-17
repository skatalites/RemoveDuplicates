package com.softserve.test.service;

import com.softserve.test.mock.DataTransferMother;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doThrow;

@ExtendWith(MockitoExtension.class)
class DuplicateRemoverUsingLambdasTest {

    @InjectMocks
    private DuplicateRemoverUsingLambdas duplicateRemoverUsingLambdas;

    @Test
    void removeDuplicateValues() {

        // Given
        var initialData = DataTransferMother.getInitialData();

        // When
        var result = duplicateRemoverUsingLambdas.removeDuplicateValues(initialData);

        // Then
        assertEquals("ABCD123", result.outputData);
    }

    @Test
    void testRemoveDuplicateValuesWithEmptyInput() {

        // Given
        var initialData = DataTransferMother.getEmptyInputData();

        // When
        var result = duplicateRemoverUsingLambdas.removeDuplicateValues(initialData);

        // Then
        assertEquals("", result.outputData);
    }

}