package ch.zhaw.supersale.model;

import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class CustomerSetStateDTO {
    private String email;
    private CustomerState state;
}
