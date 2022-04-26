package teksystems.porter.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class InventoryJoin implements Serializable {

    public String name;
    public Integer weight;
    public Double value;
    public Integer quantity;
    public Boolean worn;

}
