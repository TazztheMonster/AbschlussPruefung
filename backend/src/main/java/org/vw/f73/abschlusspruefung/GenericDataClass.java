package org.vw.f73.abschlusspruefung;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.data.annotation.Id;

@Data
@EqualsAndHashCode
public class GenericDataClass {

    @Id
    private String data1;
    private String data2;
    private int data3;

    public GenericDataClass (String data1, String data2, int data3) {
        this.data1 = data1;
        this.data2 = data2;
        this.data3 = data3;
    }

    public String toString() {
        return data1 + ", " + data2 + ", " + data3;
    }

}
