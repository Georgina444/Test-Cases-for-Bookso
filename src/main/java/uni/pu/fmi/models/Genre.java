package uni.pu.fmi.models;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class Genre {

    private long genreId;
    private String genreTitle;
    private String genreDescription;


}
