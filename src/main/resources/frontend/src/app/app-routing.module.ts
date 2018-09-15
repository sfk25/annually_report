import { NgModule } from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {SampleComponent} from './sample/sample.component';

const routes: Routes = [
  {path: 'sample', component: SampleComponent}
];

@NgModule({
  imports: [
    RouterModule.forRoot(routes)
  ],
  declarations: [],
  exports: [RouterModule]
})
export class AppRoutingModule { }
