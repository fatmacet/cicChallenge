package cic.challenge.com.service;

import cic.challenge.com.entity.FilmLocation;
import cic.challenge.com.repository.FilmLocationRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class FilmLocationService {

    private FilmLocationRepository filmLocationRepository;

    public FilmLocationService(FilmLocationRepository filmLocationRepository){
        this.filmLocationRepository = filmLocationRepository;
    }

    public Page<FilmLocation> getAllLocations(){
        Pageable pageable = new PageRequest(0, 1000);

        return filmLocationRepository.findAll(pageable);
    }

}
