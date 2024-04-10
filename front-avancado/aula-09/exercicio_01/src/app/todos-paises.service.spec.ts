import { TestBed } from '@angular/core/testing';

import { TodosPaisesService } from './todos-paises.service';

describe('TodosPaisesService', () => {
  let service: TodosPaisesService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(TodosPaisesService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
