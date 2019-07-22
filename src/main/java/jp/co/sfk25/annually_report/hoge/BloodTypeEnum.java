package jp.co.sfk25.annually_report.hoge;

import java.util.Arrays;

public enum BloodTypeEnum {
    A_TYPE(0, "A"),
    B_TYPE(1, "B"),
    O_TYPE(2, "O"),
    AB_TYPE(3, "AB"),
    UNDEFINED(null, "未入力");

    private Integer code;
    private String value;


    BloodTypeEnum(final Integer code, final String value) {
        this.code = code;
        this.value = value;
    }

    public Integer getCode() {
        return this.code;
    }

    public String getValue() {
        return this.value;
    }

    public static BloodTypeEnum getValueByCode(Integer code) {
        return Arrays.stream(BloodTypeEnum.values())
                .filter(bloodTypeEnum -> bloodTypeEnum.getCode() == code)
                .findFirst().orElse(UNDEFINED);
    }

    public static BloodTypeEnum getCodeByValue(String value) {
        return Arrays.stream(BloodTypeEnum.values())
                .filter(bloodTypeEnum -> bloodTypeEnum.getValue() == value)
                .findFirst().orElse(UNDEFINED);
    }
}
