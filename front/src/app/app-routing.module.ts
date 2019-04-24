import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

import { UserComponent } from './user/user.component';
import {AddUserComponent} from './user/add-user.component';
import {LoginComponent} from './user/login.component';
import {MainPageComponent} from './component/main-page/main-page.component';

const routes: Routes = [
  { path: 'main', component: MainPageComponent},
  { path: 'users', component: UserComponent },
  { path: 'add', component: AddUserComponent },
  { path: 'login', component: LoginComponent},
  { path: '', redirectTo: '/main', pathMatch: 'full'},
  { path: 'users/login', redirectTo: '/login', pathMatch: 'full'},
  { path: 'main/login', redirectTo: '/login', pathMatch: 'full'},
  { path: 'add/login', redirectTo: '/login', pathMatch: 'full'}
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
