package cic.challenge.com.controller;

import cic.challenge.com.entity.FilmLocation;
import cic.challenge.com.service.FilmLocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
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

    @RequestMapping("/locations/search")
    public Page<FilmLocation> getLocations(@RequestParam("location") String location, Pageable pageable) {
        return locationService.getFilmLocationsByLocation(location, pageable);
    }

    @PutMapping("/locations/{id}")
    public ResponseEntity<?> saveResource(@RequestBody FilmLocation filmLocation,
                                          @PathVariable("id") String id) {
        locationService.save(filmLocation);
        return ResponseEntity.ok(filmLocation);
    }

}
