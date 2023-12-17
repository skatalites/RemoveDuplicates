package com.softserve.test.mock;

import com.softserve.test.domain.DataTransfer;

public class DataTransferMother {

    public static DataTransfer getInitialData() {
        return DataTransfer.builder().inputData("AABBCCD112233").build();
    }

    public static DataTransfer getSameData() {
        return DataTransfer.builder().inputData("ABCD123").build();
    }


    public static DataTransfer getInputDataWithSpecialCharacters() {
        return DataTransfer.builder().inputData("@@¡¡££¢¢∞∞§§§¶ºª•¶§¶¶•¶§∞§∞¢∞£¢∞“«~^`´").build();
    }

    public static DataTransfer getInputDataWithAPalindromicPhrase() {
        return DataTransfer.builder()
                .inputData("Was it a car or a cat I saw")
                .build();
    }

    public static DataTransfer getEmptyInputData() {
        return DataTransfer.builder().inputData("").build();
    }

    public static DataTransfer getNullInputData() {
        return DataTransfer.builder().inputData(null).build();
    }

    public static DataTransfer getFinalData() {
        return DataTransfer.builder().inputData("AABBCCD112233").outputData("ABCD123").build();
    }

    public static DataTransfer getFinalDataWithSpecialCharacters() {
        return DataTransfer.builder()
                .inputData("@@¡¡££¢¢∞∞§§§¶ºª•¶§¶¶•¶§∞§∞¢∞£¢∞“«~^`´")
                .outputData("@¡£¢∞§¶ºª•“«~^`´").build();
    }

    public static DataTransfer getFinalDataWithAPalindromicPhrase() {
        return DataTransfer.builder()
                .inputData("Was it a car or a cat I saw")
                .outputData("Was itcroIw")
                .build();
    }

}
