import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ControlesContadorComponent } from './controles-contador.component';

describe('ControlesContadorComponent', () => {
  let component: ControlesContadorComponent;
  let fixture: ComponentFixture<ControlesContadorComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      imports: [ControlesContadorComponent]
    });
    fixture = TestBed.createComponent(ControlesContadorComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
