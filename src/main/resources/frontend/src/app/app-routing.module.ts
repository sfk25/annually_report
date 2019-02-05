import { NgModule } from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {SampleComponent} from './sample/sample.component';
import {TopComponent} from "./top/top.component";
import {ArticleListComponent} from "./article-list/article-list.component";

const routes: Routes = [
  {path: 'sample', component: SampleComponent},
  {path: '', component: TopComponent},
  {path: 'article_list', component: ArticleListComponent}
];

@NgModule({
  imports: [
    RouterModule.forRoot(routes)
  ],
  declarations: [],
  exports: [RouterModule]
})
export class AppRoutingModule { }
