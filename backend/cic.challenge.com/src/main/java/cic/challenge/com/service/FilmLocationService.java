package cic.challenge.com.service;

import cic.challenge.com.entity.FilmLocation;
import cic.challenge.com.repository.FilmLocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class FilmLocationService {

    private FilmLocationRepository filmLocationRepository;

    @Autowired
    public FilmLocationService(FilmLocationRepository filmLocationRepository){
        this.filmLocationRepository = filmLocationRepository;
    }

    public Page<FilmLocation> getAllFilmLocations(){
        Pageable pageable = PageRequest.of(0, 1000);

        return filmLocationRepository.findAll(pageable);
    }

    public Page<FilmLocation> getFilmLocationsByLocation(String location, Pageable pageable){

        String upperCaseLocation = '%' + location.toUpperCase() + '%';

        return filmLocationRepository.searchByLocation(upperCaseLocation, pageable);
    }

    public FilmLocation getById(Long id) {
        return filmLocationRepository.findById(id).get();
    }

    public void save(FilmLocation filmLocation) {
        this.filmLocationRepository.save(filmLocation);
    }
}
