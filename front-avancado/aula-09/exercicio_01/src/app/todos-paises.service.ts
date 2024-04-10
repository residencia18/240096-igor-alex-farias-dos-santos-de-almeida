import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class TodosPaisesService {

  private apiUrl = 'https://restcountries.com/v3.1/all';

  constructor(private http: HttpClient) { }

  getCountries():Promise<todosPaises[]> {
    return new Promise((resolve,reject)) => {
      resolve(this.http.get<any[]>(this.apiUrl))
    }
    
  }
}
