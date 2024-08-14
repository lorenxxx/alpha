package com.clawchat.alpha.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Range;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class CreateDemoDTO {

    @Schema(title = "名字", example = "Loren", minLength = 1, maxLength = 10)
    @NotBlank(message = "名字不能为空")
    private String name;

    @Schema(title = "年龄", example = "18", minimum = "0", maximum = "150")
    @NotNull(message = "年龄不能为空")
    @Range(min = 0, max = 150, message = "年龄在0~150之间")
    private Integer age;

    @Schema(title = "电话（可选）")
    private String phone;

}
