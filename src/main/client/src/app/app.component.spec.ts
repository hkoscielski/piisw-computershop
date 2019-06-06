import {async, ComponentFixture, TestBed} from '@angular/core/testing';
import {AppComponent} from './app.component';
import {RouterTestingModule} from '@angular/router/testing';
import {GeneralModule} from './general/general.module';
import {ProductMgmtModule} from "./product-mgmt/product-mgmt.module";
import {ProductService} from "./product-mgmt/product.service";

describe('AppComponent', () => {
  let fixture: ComponentFixture<AppComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [
        AppComponent
      ],
      imports: [
        RouterTestingModule,
        GeneralModule,
        ProductMgmtModule
      ],
      providers: [ProductService],
    }).compileComponents();


    fixture = TestBed.createComponent(AppComponent);
    fixture.detectChanges();
  }));

  it('should create the app', async(() => {
    const app = fixture.debugElement.componentInstance;
    expect(app).toBeTruthy();
  }));

  it('should render footer', async(() => {
    const compiled = fixture.debugElement.nativeElement;
    expect(compiled.querySelector('app-nav div a').textContent).toContain('K. Jakubowski, M. Kawa, H. Kościelski');
  }));
});
