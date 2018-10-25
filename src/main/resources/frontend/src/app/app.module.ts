import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import {HttpClientModule} from '@angular/common/http';

import { AppComponent } from './app.component';
import { SampleComponent } from './sample/sample.component';
import { AppRoutingModule } from './/app-routing.module';
import { TopComponent } from './top/top.component';
import { ArticleListComponent } from './article-list/article-list.component';

@NgModule({
  declarations: [
    AppComponent,
    SampleComponent,
    TopComponent,
    ArticleListComponent
  ],
  imports: [
    HttpClientModule,
    BrowserModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
