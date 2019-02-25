import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class FilmLocationService {

  public API = '//localhost:8080';
  public LOCATION_API = this.API + '/locations';

  constructor(private http: HttpClient) { }

  getAll(): Observable<any> {
    return this.http.get('//localhost:8080/locations');
  }

  get(id: string) {
    return this.http.get(this.LOCATION_API + '/' + id);
  }

  save(location: any): Observable<any> {
    let result: Observable<Object>;
    if (location['href']) {
      result = this.http.put(location.href, location);
    } else {
      result = this.http.post(this.LOCATION_API, location);
    }
    return result;
  }
}
