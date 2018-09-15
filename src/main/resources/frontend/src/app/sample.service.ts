import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import { Observable, of } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class SampleService {

  private usersUrl = 'http://localhost:8080/api/v1/users';

  constructor(
    private http: HttpClient,
  ) { }

  // 型指定する
  getUsers(): Observable<any>{
    console.log('AAAAA');
    return this.http.get(this.usersUrl);
  }
}
