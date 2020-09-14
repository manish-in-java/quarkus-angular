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

import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({ providedIn: "root" })
export class ElementService {
  private static BASE_URL = "http://localhost:8080/elements";

  constructor(private http: HttpClient) { }

  /**
   * Gets all available elements.
   */
  async list() {
    try {
      return await this.http.get(ElementService.BASE_URL).toPromise();
    }
    catch (error) {
      console.error(`Unable to fetch elements due to error: ${error}`);
    }
  }

  /**
   * Saves an element to the periodic table.
   * 
   * @param element The element to add.
   */
  async save(element) {
    try {
      return await this.http.post(ElementService.BASE_URL, element).toPromise();
    }
    catch(error) {
      console.error(`Unable to save element due to error: ${error}`);
    }
  }
}