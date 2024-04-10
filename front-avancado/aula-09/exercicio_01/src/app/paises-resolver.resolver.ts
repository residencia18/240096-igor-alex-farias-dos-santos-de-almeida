import { ResolveFn } from '@angular/router';
import { inject } from '@angular/core';
import { TodosPaisesService } from './todos-paises.service'

export const paisesResolverResolver: ResolveFn<todosPaises[]> = (route, state) => {

  let todosPaisesService = inject(TodosPaisesService);

  return todosPaisesService.getCountries();
};
