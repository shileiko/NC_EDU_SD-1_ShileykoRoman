import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-main-page',
  templateUrl: './main-page.component.html',
  styleUrls: ['./main-page.component.css']
})
export class MainPageComponent implements OnInit {

  constructor() { }

  ngOnInit() {
  }

  // changes() {
  //   var temp = document.getElementById('pic1').src;
  //   document.getElementById('pic1').src = document.getElementById('pic2').src;
  //   document.getElementById('pic2').src = temp;
  // }
}
