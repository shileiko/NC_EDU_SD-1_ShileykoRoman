import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import { AppComponent } from './app.component';
import { UserComponent } from './user/user.component';
import { AppRoutingModule } from './app-routing.module';
import {UserService} from './service/user.service';
import {TokenStorage} from './config/token-provider';
import {HTTP_INTERCEPTORS, HttpClientModule} from '@angular/common/http';
import {AddUserComponent} from './user/add-user.component';
import {Interceptor} from './service/interceptor';
import {LogUserService} from './service/log-user.service';
import { NavbarComponent } from './component/navbar/navbar.component';
import {MainPageService} from './service/main-page.service';
import { MainPageComponent } from './component/main-page/main-page.component';
import { LoginComponent } from './user/login.component';
import { FlightsComponent } from './component/flights/flights.component';
import {FlightService} from './service/flight.service';
import {OwlDateTimeModule, OwlNativeDateTimeModule, OWL_DATE_TIME_FORMATS} from 'ng-pick-datetime';
import {BrowserAnimationsModule} from '@angular/platform-browser/animations';
import {MainFilterComponent} from './component/main-filter/main-filter.component';
import {AddFlightComponent} from './component/add-flight/add-flight.component';
import {TicketService} from './service/ticket.service';

export const MY_NATIVE_FORMATS = {
  fullPickerInput: {year: 'numeric', month: 'numeric', day: 'numeric', hour: 'numeric', minute: 'numeric'},
  datePickerInput: {year: 'numeric', month: 'numeric', day: 'numeric'},
  timePickerInput: {hour: 'numeric', minute: 'numeric'},
  monthYearLabel: {year: 'numeric', month: 'short'},
  dateA11yLabel: {year: 'numeric', month: 'long', day: 'numeric'},
  monthYearA11yLabel: {year: 'numeric', month: 'long'},
};

@NgModule({
  declarations: [
    AppComponent,
    UserComponent,
    AddUserComponent,
    NavbarComponent,
    MainPageComponent,
    LoginComponent,
    FlightsComponent,
    MainFilterComponent,
    AddFlightComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule,
    ReactiveFormsModule,
    OwlDateTimeModule,
    OwlNativeDateTimeModule,
    BrowserAnimationsModule
  ],
  providers: [UserService, MainPageService, FlightService, LogUserService, TokenStorage, TicketService,
    {provide: HTTP_INTERCEPTORS, useClass: Interceptor, multi : true},
    {provide: OWL_DATE_TIME_FORMATS, useValue: MY_NATIVE_FORMATS}],
  bootstrap: [AppComponent]
})
export class AppModule { }
