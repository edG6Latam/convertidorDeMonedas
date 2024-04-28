package service;

import com.google.gson.annotations.SerializedName;

public record RecordMoneda(String result, String base_code, String target_code, double conversion_rate, double conversion_result  ) {
}
