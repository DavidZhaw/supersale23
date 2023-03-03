package ch.zhaw.supersale.model;

import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class CustomerCreateDTO {
    private String email;
    private String name;
}
