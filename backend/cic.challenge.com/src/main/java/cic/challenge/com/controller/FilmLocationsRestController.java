package cic.challenge.com.controller;

import cic.challenge.com.entity.FilmLocation;
import cic.challenge.com.service.FilmLocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FilmLocationsRestController {

    private FilmLocationService locationService;

    @Autowired
    public FilmLocationsRestController(FilmLocationService locationService){
        this.locationService = locationService;
    }

    @RequestMapping("/locations")
    public Page<FilmLocation> getLocations(Pageable pageable) {
        return locationService.getAllLocations();
    }

}
