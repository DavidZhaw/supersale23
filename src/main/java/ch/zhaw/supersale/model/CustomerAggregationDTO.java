package ch.zhaw.supersale.model;

import java.util.List;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class CustomerAggregationDTO {
    private String id;
    private List<String> customer;
}
