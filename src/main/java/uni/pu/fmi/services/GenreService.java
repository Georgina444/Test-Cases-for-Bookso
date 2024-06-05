package uni.pu.fmi.services;

import uni.pu.fmi.db.MainRepo;
import uni.pu.fmi.models.Genre;

import java.util.List;

public class GenreService {

    public List<Genre> load(){return MainRepo.getGenres();
    }
}
