import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { LocationListComponent } from './location-list/location-list.component';
import { LocationEditComponent } from './location-edit/location-edit.component';

const routes: Routes = [
  { path: '', redirectTo: '/locations-list', pathMatch: 'full' },
  {
    path: 'locations-list',
    component: LocationListComponent
  },
  {
    path: 'location-edit/:id',
    component: LocationEditComponent
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
