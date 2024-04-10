import { Component, OnInit } from '@angular/core';
import { ApiServiceService } from '../api-service.service';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';

@Component({
  selector: 'app-country',
  standalone: true,
  imports: [
    CommonModule,
    FormsModule,
    HttpClientModule
  ],
  templateUrl: './country.component.html',
  styleUrl: './country.component.css',
  providers: [ApiServiceService]
})
export class CountryComponent implements OnInit {

  camposDoForm: any[] = [];
  dados: any = {};

  constructor(private apiService: ApiServiceService) { }

  ngOnInit(): void {
    this.apiService.getFirstRecord().subscribe(
      campos => {
        this.camposDoForm = campos;
      },
      error => {
        console.error('Erro ao obter os campos do formulário:', error);
      }
    )
  }

}
