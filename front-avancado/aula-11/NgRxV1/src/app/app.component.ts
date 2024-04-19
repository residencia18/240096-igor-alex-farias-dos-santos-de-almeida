import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterOutlet } from '@angular/router';
import { SaidaContadorComponent } from './saida-contador/saida-contador.component';
import { ControlesContadorComponent } from './controles-contador/controles-contador.component';

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [CommonModule, RouterOutlet, SaidaContadorComponent, ControlesContadorComponent],
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'NgRxV1';
}
