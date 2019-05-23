import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

import { UserComponent } from './user/user.component';
import {AddUserComponent} from './user/add-user.component';
import {FlightsComponent} from './component/flights/flights.component';
import {MainPageComponent} from './component/main-page/main-page.component';
import {AddFlightComponent} from './component/add-flight/add-flight.component';
import {ProfileComponent} from './component/profile/profile.component';

const routes: Routes = [
  { path: 'main', component: MainPageComponent},
  { path: 'users', component: UserComponent },
  { path: 'add', component: AddUserComponent },
  { path: 'add_flight', component: AddFlightComponent},
  { path: '', redirectTo: '/main', pathMatch: 'full'},
  { path: 'flights', component: FlightsComponent },
  { path: 'profile', component: ProfileComponent },
];

@NgModule({
  imports: [
    RouterModule.forRoot(routes)
  ],
  exports: [
    RouterModule
  ],
  declarations: []
})
export class AppRoutingModule {
}
