import { Component, OnDestroy, OnInit } from '@angular/core';
import { Subscription } from 'rxjs';
import { ActivatedRoute, Router } from '@angular/router';
import { FilmLocationService } from '../service/filmLocation/film-location.service';
import { NgForm } from '@angular/forms';

@Component({
  selector: 'app-location-edit',
  templateUrl: './location-edit.component.html',
  styleUrls: ['./location-edit.component.css']
})
export class LocationEditComponent implements OnInit, OnDestroy {
  location: any = {};

  sub: Subscription;

  constructor(private route: ActivatedRoute,
              private router: Router,
              private locationService: FilmLocationService) {
  }

  ngOnInit() {
    this.sub = this.route.params.subscribe(params => {
      const id = params['id'];
      if (id) {
        this.locationService.get(id).subscribe((location: any) => {
          if (location) {
            this.location = location;
          } else {
            this.gotoList();
          }
        });
      }
    });
  }

  ngOnDestroy() {
    this.sub.unsubscribe();
  }

  gotoList() {
    this.router.navigate(['/locations-list']);
  }

  save() {
    this.locationService.save(this.location).subscribe(result => {
      this.gotoList();
    }, error => console.error(error));
  }

}