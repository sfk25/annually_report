import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import {Observable, of} from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ArticleService {

  private articlesUrl = 'http://localhost:8080/api/v1/articles';

  constructor(
    private http: HttpClient,
  ) { }

  getArticle(): Observable<any>{
    var articles = this.http.get(this.articlesUrl);
    return articles;
  }
}
