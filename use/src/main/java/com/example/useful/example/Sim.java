package src.main.java.com.example.useful.example;

import lombok.*;

import org.springframework.data.annotation.Id;

import java.io.Serializable;

import javax.persistence.*;

@Entity
@Table(name = "phoneModel")
@Setter
@Getter
@ToString
@NoArgsConstructor
public class Sim implements Serializable {
    private static final long serialVersionUID = 2L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "model_gen")
    @SequenceGenerator(name = "model_gen", sequenceName = "phoneModel_seq", allocationSize = 1)
    private Long id;

    @NonNull private String modelColour;
    @NonNull private String modelNo;
    @NonNull private String modelPrice;

    public Sim(String modelNo, String modelPrice, String modelColour) {

        this.modelNo = modelNo;
        this.modelPrice = modelPrice;
        this.modelColour = modelColour;
    }
}
