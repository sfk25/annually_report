import { Component, OnInit } from '@angular/core';
import {ArticleService} from "../article.service";

@Component({
  selector: 'app-article-list',
  templateUrl: './article-list.component.html',
  styleUrls: ['./article-list.component.css']
})
export class ArticleListComponent implements OnInit {

  articles;

  constructor(
    private articleService: ArticleService
  ){ }

  ngOnInit() {
    this.getArticles();
  }

  getArticles(): void{
    this.articleService.getArticle()
      .subscribe(articles => this.articles = articles)
  }
}
