import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class FilmLocationService {

  public API = '//localhost:8080/locations';

  constructor(private http: HttpClient) { }

  getAll(): Observable<any> {
    return this.http.get(this.API);
  }

  search(searchText: string): Observable<any> {
    return this.http.get(this.API + '/search?location=' + searchText + '&size=1000' + '&page=0');
  }

  get(id: string) {
    return this.http.get(this.API + '/' + id);
  }

  save(location: any): Observable<any> {
    let result: Observable<Object>;
   
      result = this.http.put(this.API + '/' + location.id, location);
   
    return result;
  }
}
