package cic.challenge.com.controller;

import cic.challenge.com.entity.FilmLocation;
import cic.challenge.com.service.FilmLocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class FilmLocationsRestController {

    private FilmLocationService locationService;

    @Autowired
    public FilmLocationsRestController(FilmLocationService locationService){
        this.locationService = locationService;
    }

    @RequestMapping("/locations")
    public Page<FilmLocation> getLocations() {
        return locationService.getAllFilmLocations();
    }

    @RequestMapping(value="/locations/{id}", method = RequestMethod.GET)
    public FilmLocation getLocation(@PathVariable Long id) {

        return locationService.getById(id);
    }

    @RequestMapping("/locationSearch")
    public Page<FilmLocation> getLocations(String location, Pageable pageable) {
        return locationService.getFilmLocationsByLocation(location, pageable);
    }

}
