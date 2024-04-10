import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable, map } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ApiServiceService {

  constructor(private http: HttpClient) { }

  getFirstRecord(): Observable<any> {
    return this.http.get<any>('https://restcountries.com/v3.1/all').pipe(
      map(resposta => {
        const primeiroPais = resposta[0];
        const camposDoForm = Object.keys(primeiroPais).map(key => ({
          tipo: 'text',
          nome: key,
          rotulo: key
        }));
        return camposDoForm
      })
    )
  }
}
