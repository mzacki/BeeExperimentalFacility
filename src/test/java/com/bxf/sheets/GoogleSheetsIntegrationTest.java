package com.bxf.sheets;

import com.google.api.services.sheets.v4.Sheets;
import com.google.api.services.sheets.v4.model.BatchGetValuesResponse;
import com.google.api.services.sheets.v4.model.ValueRange;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by Matt on 05.06.2019 at 18:30.
 */

public class GoogleSheetsIntegrationTest {

    private static Sheets sheetsService;
    private static final String SPREADSHEET_ID = "";

    @BeforeClass
    public static void setup() throws GeneralSecurityException, IOException {
        sheetsService = SheetsServiceUtil.getSheetsService();
    }

    @Test
    public void whenWriteSheet_thenReadSheetOk() throws IOException {

        List<String> ranges = Arrays.asList("E1","E4");
        BatchGetValuesResponse readResult = sheetsService.spreadsheets().values()
                .batchGet(SPREADSHEET_ID)
                .setRanges(ranges)
                .execute();

        ValueRange januaryTotal = readResult.getValueRanges().get(0);
        assertThat(januaryTotal.getValues().get(0).get(0))
                .isEqualTo("40");

        ValueRange febTotal = readResult.getValueRanges().get(1);
        assertThat(febTotal.getValues().get(0).get(0))
                .isEqualTo("25");
    }

}
