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

    public Page<FilmLocation> getAllFilmLocations(){
        Pageable pageable = new PageRequest(0, 1000);

        return filmLocationRepository.findAll(pageable);
    }

    public Page<FilmLocation> getFilmLocationsByLocation(String location, Pageable pageable){

        String upperCaseLocation = '*' + location.toUpperCase() + '*';

        return filmLocationRepository.findByLocation(location, pageable);
    }

    public FilmLocation getById(Long id) {
        return filmLocationRepository.findById(id).get();
    }
}
