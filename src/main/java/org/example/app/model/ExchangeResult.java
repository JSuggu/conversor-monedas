package org.example.app.model;

import com.google.gson.annotations.SerializedName;

public class ExchangeResult {
    @SerializedName("result")
    private String result;
    @SerializedName("documentation")
    private String documentation;
    @SerializedName("terms_of_use")
    private String termOfUse;
    @SerializedName("time_last_update_unix")
    private Integer timeLastUpdateUnix;
    @SerializedName("time_last_update_utc")
    private String timeLastUpdateUtc;
    @SerializedName("time_next_update_unix")
    private Integer timeNextUpdateUnix;
    @SerializedName("time_next_update_utc")
    private String timeNextUpdateUtc;
    @SerializedName("base_code")
    private String baseCode;
    @SerializedName("target_code")
    private String targetCode;
    @SerializedName("conversion_rate")
    private Double conversionRate;

    public ExchangeResult(String result, String documentation, String termOfUse, Integer timeLastUpdateUnix, String timeLastUpdateUtc, Integer timeNextUpdateUnix, String timeNextUpdateUtc, String baseCode, String targetCode, Double conversionRate) {
        this.result = result;
        this.documentation = documentation;
        this.termOfUse = termOfUse;
        this.timeLastUpdateUnix = timeLastUpdateUnix;
        this.timeLastUpdateUtc = timeLastUpdateUtc;
        this.timeNextUpdateUnix = timeNextUpdateUnix;
        this.timeNextUpdateUtc = timeNextUpdateUtc;
        this.baseCode = baseCode;
        this.targetCode = targetCode;
        this.conversionRate = conversionRate;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getDocumentation() {
        return documentation;
    }

    public void setDocumentation(String documentation) {
        this.documentation = documentation;
    }

    public String getTermOfUse() {
        return termOfUse;
    }

    public void setTermOfUse(String termOfUse) {
        this.termOfUse = termOfUse;
    }

    public Integer getTimeLastUpdateUnix() {
        return timeLastUpdateUnix;
    }

    public void setTimeLastUpdateUnix(Integer timeLastUpdateUnix) {
        this.timeLastUpdateUnix = timeLastUpdateUnix;
    }

    public String getTimeLastUpdateUtc() {
        return timeLastUpdateUtc;
    }

    public void setTimeLastUpdateUtc(String timeLastUpdateUtc) {
        this.timeLastUpdateUtc = timeLastUpdateUtc;
    }

    public Integer getTimeNextUpdateUnix() {
        return timeNextUpdateUnix;
    }

    public void setTimeNextUpdateUnix(Integer timeNextUpdateUnix) {
        this.timeNextUpdateUnix = timeNextUpdateUnix;
    }

    public String getTimeNextUpdateUtc() {
        return timeNextUpdateUtc;
    }

    public void setTimeNextUpdateUtc(String timeNextUpdateUtc) {
        this.timeNextUpdateUtc = timeNextUpdateUtc;
    }

    public String getBaseCode() {
        return baseCode;
    }

    public void setBaseCode(String baseCode) {
        this.baseCode = baseCode;
    }

    public String getTargetCode() {
        return targetCode;
    }

    public void setTargetCode(String targetCode) {
        this.targetCode = targetCode;
    }

    public Double getConversionRate() {
        return conversionRate;
    }

    public void setConversionRate(Double conversionRate) {
        this.conversionRate = conversionRate;
    }
}
