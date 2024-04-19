import { ApplicationConfig } from '@angular/core';
import { provideRouter } from '@angular/router';

import { routes } from './app.routes';
import { provideStore } from '@ngrx/store';
import { contadorReducer } from './store/contador.reducer';
import { provideEffects } from '@ngrx/effects';
import { ContadorEffects } from './store/contador.effects';

export const appConfig: ApplicationConfig = {
  providers: [
    provideRouter(routes),
    provideStore({ contador: contadorReducer }),
    provideEffects([ContadorEffects])
  ]
};
