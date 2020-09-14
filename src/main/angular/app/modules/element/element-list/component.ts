/*
 * Permission is hereby granted, free of charge, to any person obtaining a copy of
 * this software and associated documentation files (the "Software"), to deal in the
 * Software without restriction, including without limitation the rights to use, copy,
 * modify, merge, publish, distribute, sublicense, and/or sell copies of the Software,
 * and to permit persons to whom the Software is furnished to do so, subject to the
 * following conditions:
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED,
 * INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A
 * PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT
 * HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF
 * CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE
 * OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */

import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup } from "@angular/forms";

import { ElementService } from '../service';

/**
 * Element Listing component.
 */
@Component({
  selector: 'app-element-list',
  templateUrl: './component.html'
})
export class ElementListComponent implements OnInit {
  columns = ["number", "symbol", "name", "weight"];
  elements;

  elementForm = new FormGroup({
    name: new FormControl(""),
    number: new FormControl(""),
    symbol: new FormControl(""),
    weight: new FormControl("")
  });

  constructor(private service: ElementService) { }

  ngOnInit() {
    this.service.list().then(data => {
      this.elements = data;
    });
  }

  /**
   * Adds an element to the periodic table.
   */
  addElement() {
    // Attempt to add an element based on the data available in the form.
    this.service.save(this.elementForm.value).then(response => {
      // Check whether the element exists already.
      if (response
        && response["number"]
        && this.elements
               .filter(element => element && element["number"] && element["number"] == response["number"])
               .length == 0) {
        // Add the element locally if it does not exist already.
        this.elements = this.elements.concat([response]);
      }
    });

    this.elementForm.reset();
  }
}
