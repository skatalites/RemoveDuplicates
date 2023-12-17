package com.softserve.test.application;

import com.softserve.test.mock.DataTransferMother;
import com.softserve.test.service.DuplicateRemoverUsingLambdas;
import com.softserve.test.infrastructure.GetDataFromConsole;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.BDDMockito.*;

@ExtendWith(MockitoExtension.class)
class HandlerTest {

    @InjectMocks
    private Handler handler;

    @Mock
    private GetDataFromConsole dataService;

    @Mock
    private DuplicateRemoverUsingLambdas removalService;

    private String inputData;
    private String outputData;

    @BeforeEach
    void setUp() {
        inputData = "AABBCCD112233";
        outputData = "ABCD123";
    }

    @Test
    void shouldHandleRemoveDuplicateValues() {

        // Given
        var initialData = DataTransferMother.getInitialData();
        var finalData = DataTransferMother.getFinalData();

        given(dataService.getInputData()).willReturn(initialData);
        given(removalService.removeDuplicateValues(initialData)).willReturn(finalData);

        // When
        handler.handle();

        // Then
        assertEquals(inputData, initialData.inputData);
        assertEquals(outputData, finalData.outputData);

        verify(dataService, times(1)).getInputData();
        verify(removalService, times(1)).removeDuplicateValues(any());
    }

    @Test
    void shouldHandleSameValue() {

        // Given
        var initialData = DataTransferMother.getSameData();
        var finalData = DataTransferMother.getFinalData();

        given(dataService.getInputData()).willReturn(initialData);
        given(removalService.removeDuplicateValues(initialData)).willReturn(finalData);

        // When
        handler.handle();

        // Then
        assertEquals("ABCD123", initialData.inputData);
        assertEquals(outputData, finalData.outputData);

        verify(dataService, times(1)).getInputData();
        verify(removalService, times(1)).removeDuplicateValues(any());
    }

    @Test
    void shouldHandleAPalindromicPhrase() {

        // Given
        var initialData = DataTransferMother.getInputDataWithAPalindromicPhrase();
        var finalData = DataTransferMother.getFinalDataWithAPalindromicPhrase();

        given(dataService.getInputData()).willReturn(initialData);
        given(removalService.removeDuplicateValues(initialData)).willReturn(finalData);

        // When
        handler.handle();

        // Then
        assertEquals("Was it a car or a cat I saw", initialData.inputData);
        assertEquals("Was itcroIw", finalData.outputData);

        verify(dataService, times(1)).getInputData();
        verify(removalService, times(1)).removeDuplicateValues(any());
    }

    @Test
    void shouldHandleRemovingDuplicateValuesWithSpecialCharacters() {

        // Given
        var initialData = DataTransferMother.getInputDataWithSpecialCharacters();
        var finalData = DataTransferMother.getFinalDataWithSpecialCharacters();

        given(dataService.getInputData()).willReturn(initialData);
        given(removalService.removeDuplicateValues(initialData)).willReturn(finalData);

        // When
        handler.handle();

        // Then
        assertEquals("@@¡¡££¢¢∞∞§§§¶ºª•¶§¶¶•¶§∞§∞¢∞£¢∞“«~^`´", initialData.inputData);
        assertEquals("@¡£¢∞§¶ºª•“«~^`´", finalData.outputData);

        verify(dataService, times(1)).getInputData();
        verify(removalService, times(1)).removeDuplicateValues(any());
    }

    @Test
    void shouldIgnoreEmptyValue() {

        // Given
        var initialData = DataTransferMother.getEmptyInputData();

        given(dataService.getInputData()).willReturn(initialData);

        // When
        handler.handle();

        // Then
        assertEquals("", initialData.inputData);

        verify(dataService, times(1)).getInputData();
        then(removalService).shouldHaveNoInteractions();
    }

    @Test
    void shouldIgnoreNullValue() {

        // Given
        var initialData = DataTransferMother.getNullInputData();

        given(dataService.getInputData()).willReturn(initialData);

        // When
        handler.handle();

        // Then
        assertNull(initialData.inputData);

        verify(dataService, times(1)).getInputData();
        then(removalService).shouldHaveNoInteractions();
    }

}