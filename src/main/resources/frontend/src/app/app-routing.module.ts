import { NgModule } from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {SampleComponent} from './sample/sample.component';
import {TopComponent} from "./top/top.component";

const routes: Routes = [
  {path: 'sample', component: SampleComponent},
  {path: '', component: TopComponent}
];

@NgModule({
  imports: [
    RouterModule.forRoot(routes)
  ],
  declarations: [],
  exports: [RouterModule]
})
export class AppRoutingModule { }
