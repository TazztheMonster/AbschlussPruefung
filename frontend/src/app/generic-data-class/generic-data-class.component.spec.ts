import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { GenericDataClassComponent } from './generic-data-class.component';

describe('GenericDataClassComponent', () => {
  let component: GenericDataClassComponent;
  let fixture: ComponentFixture<GenericDataClassComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ GenericDataClassComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(GenericDataClassComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
