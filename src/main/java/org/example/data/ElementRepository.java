/*
 * Permission is hereby granted, free of charge, to any person obtaining a copy of
 * this software and associated documentation files (the "Software"), to deal in
 * the Software without restriction, including without limitation the rights to
 * use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies
 * of the Software, and to permit persons to whom the Software is furnished to do
 * so, subject to the following conditions:
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS
 * FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR
 * COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER
 * IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN
 * CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */

package org.example.data;

import org.example.domain.Element;

/**
 * Contract for data access operations on {@link Element}.
 */
public interface ElementRepository
{
  /**
   * Finds all elements.
   *
   * @return An {@link Iterable} of {@link Element}s. The returned object is
   * guaranteed to be never {@literal null}.
   */
  Iterable<Element> findAll();

  /**
   * Finds an element with a specified chemical symbol.
   *
   * @param symbol The chemical symbol of the element to find.
   * @return An {@link Element}, if one matching the specified symbol is
   * found, {@literal null} otherwise.
   */
  Element findOne(String symbol);

  /**
   * Saves an element and returns the saved instance.
   *
   * @param element The element to save.
   * @return The saved element.
   */
  Element save(Element element);
}
