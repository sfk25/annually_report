import { Component, OnInit } from '@angular/core';
import { SampleService } from '../sample.service';

@Component({
  selector: 'app-sample',
  templateUrl: './sample.component.html',
  styleUrls: ['./sample.component.css']
})
export class SampleComponent implements OnInit {

  users;

  constructor(private sampleService: SampleService) { }

  ngOnInit() {
    this.getUsers();
  }

  getUsers(): void {

    this.sampleService.getUsers()
      .subscribe(users => this.users = users);
  }

}
