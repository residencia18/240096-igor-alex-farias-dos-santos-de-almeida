import { Routes } from '@angular/router';
import { MenuComponent } from './menu/menu.component';
import { Componente1Component } from './menu/componente-1/componente-1.component';

export const routes: Routes = [
    {
        path: 'menu-componente',
        component: MenuComponent
    },
    {
        path: 'componente-1',
        component: Componente1Component
    },
    {
        path: 'componente-2',
        loadComponent: () => import('./menu/componente-2/componente-2.component').then(comp => comp.Componente2Component)
    },
    {
        path: 'componente-3',
        loadComponent: () => import('./menu/componente-3/componente-3.component').then(comp => comp.Componente3Component)
    },
];
