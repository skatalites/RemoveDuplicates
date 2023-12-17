package com.softserve.test.infrastructure;

import com.softserve.test.infrastructure.GetDataFromConsole;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.io.ByteArrayInputStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Slf4j
@ExtendWith(MockitoExtension.class)
class GetDataFromConsoleTest {

    @InjectMocks
    private GetDataFromConsole dataService;


    @Test
    void getInputData() {

        // Given
        var inputData = "AABBCCD112233";
        var mockedInputStream = new ByteArrayInputStream(inputData.getBytes());
        System.setIn(mockedInputStream);

        // When
        var result = dataService.getInputData();

        // Then
        assertEquals(inputData, result.inputData);
        System.setIn(System.in);

    }

}