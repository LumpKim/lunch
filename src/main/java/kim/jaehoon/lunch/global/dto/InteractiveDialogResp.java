package kim.jaehoon.lunch.global.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.List;

@Data
@SuperBuilder
@NoArgsConstructor
public class InteractiveDialogResp {

    private String triggerId;
    private String url;
    private Dialog dialog;

    @Getter
    @SuperBuilder
    @NoArgsConstructor
    public static class Dialog {
        private String callbackId;
        private String title;
        private String iconUrl;
        private List<Element> elements;
        private String submitLabel;
        private boolean notifyOnCancel;
        private String state;
    }

    @Getter
    @SuperBuilder
    @NoArgsConstructor
    public static class Element {
        private String displayName;
        private String name;
        private String type;
        private String subType;
        @JsonProperty("default")
        private String defaultText;
        private String placeholder;
        private String helpText;
        private Boolean optional;
        private int minLength;
        private int maxLength;
        private String dataSource;
        private List<Option> options;
    }

    @Data
    @SuperBuilder
    @NoArgsConstructor
    public static class Option {
        private String text;
        private String value;
    }
}
