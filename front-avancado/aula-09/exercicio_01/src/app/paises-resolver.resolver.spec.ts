import { TestBed } from '@angular/core/testing';
import { ResolveFn } from '@angular/router';

import { paisesResolverResolver } from './paises-resolver.resolver';

describe('paisesResolverResolver', () => {
  const executeResolver: ResolveFn<boolean> = (...resolverParameters) => 
      TestBed.runInInjectionContext(() => paisesResolverResolver(...resolverParameters));

  beforeEach(() => {
    TestBed.configureTestingModule({});
  });

  it('should be created', () => {
    expect(executeResolver).toBeTruthy();
  });
});
