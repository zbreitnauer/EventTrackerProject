import { TestBed } from '@angular/core/testing';

import { JojoService } from './jojo.service';

describe('JojoService', () => {
  let service: JojoService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(JojoService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
