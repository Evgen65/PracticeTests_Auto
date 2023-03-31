package models;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Builder
public class Pets {
    String type;
    String sex;
    String breed;
    String color;
    String height;
    String distinctiveFeatures;
    String description;
    String location;


}
