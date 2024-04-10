import { Component } from '@angular/core';
import { Componente1Component } from './componente-1/componente-1.component'
import { Componente2Component } from './componente-2/componente-2.component'
import { Componente3Component } from './componente-3/componente-3.component'
import { RouterOutlet, RouterLink, RouterLinkActive } from '@angular/router'

@Component({
  selector: 'app-menu',
  standalone: true,
  imports: [
    Componente1Component,
    Componente2Component,
    Componente3Component,
    RouterOutlet, 
    RouterLink, 
    RouterLinkActive
  ],
  templateUrl: './menu.component.html',
  styleUrl: './menu.component.css'
})
export class MenuComponent {

}
