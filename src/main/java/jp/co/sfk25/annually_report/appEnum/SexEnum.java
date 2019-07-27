package jp.co.sfk25.annually_report.appEnum;

import java.util.Arrays;

public enum SexEnum {
    WOMAN(0, "女性"),
    MAN(1, "男性"),
    UNDEFINED(null, "未入力");

    private Integer code;
    private String value;


    SexEnum(final Integer code, final String value) {
        this.code = code;
        this.value = value;
    }

    public Integer getCode() {
        return this.code;
    }

    public String getValue() {
        return this.value;
    }

    public static SexEnum getValueByCode(Integer code) {
        return Arrays.stream(SexEnum.values())
                .filter(bloodTypeEnum -> bloodTypeEnum.getCode() == code)
                .findFirst().orElse(UNDEFINED);
    }

    public static SexEnum getCodeByValue(String value) {
        return Arrays.stream(SexEnum.values())
                .filter(bloodTypeEnum -> bloodTypeEnum.getValue() == value)
                .findFirst().orElse(UNDEFINED);
    }
}
