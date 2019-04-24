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

@NgModule({
  declarations: [
    AppComponent,
    UserComponent,
    AddUserComponent,
    NavbarComponent,
    MainPageComponent,
    LoginComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule,
    ReactiveFormsModule
  ],
  providers: [UserService, MainPageService, LogUserService, TokenStorage, {provide: HTTP_INTERCEPTORS,
    useClass: Interceptor,
    multi : true}],
  bootstrap: [AppComponent]
})
export class AppModule { }
