import { Component, OnInit } from '@angular/core';
import { FilmLocationService } from '../service/filmLocation/film-location.service';

@Component({
  selector: 'app-location-list',
  templateUrl: './location-list.component.html',
  styleUrls: ['./location-list.component.css']
})
export class LocationListComponent implements OnInit {

  locations: Array<any>;

  constructor(private filmLocationService: FilmLocationService) { }

  ngOnInit() {
    this.filmLocationService.getAll().subscribe(data => {
      this.locations = data.content;
    });
  }
}
