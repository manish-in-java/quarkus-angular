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

import javax.inject.Singleton;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * An in-memory repository of elements.
 */
@Singleton
public class InMemoryElementRepository implements ElementRepository
{
  private static final Map<String, Element> STORE = Collections.synchronizedMap(new LinkedHashMap<>());

  static
  {
    STORE.put("H", new Element(1, "H", "Hydrogen", 1.008));
    STORE.put("He", new Element(2, "He", "Helium", 4.0026));
    STORE.put("Li", new Element(3, "Li", "Lithium", 6.94));
    STORE.put("Be", new Element(4, "Be", "Beryllium", 9.0122));
    STORE.put("B", new Element(5, "B", "Boron", 10.81));
    STORE.put("C", new Element(6, "C", "Carbon", 12.011));
    STORE.put("N", new Element(7, "N", "Nitrogen", 14.007));
    STORE.put("O", new Element(8, "O", "Oxygen", 15.999));
    STORE.put("F", new Element(9, "F", "Fluorine", 18.998));
    STORE.put("Ne", new Element(10, "Ne", "Neon", 20.180));
    STORE.put("Na", new Element(11, "Na", "Sodium", 22.990));
    STORE.put("Mg", new Element(12, "Mg", "Magnesium", 24.305));
    STORE.put("Al", new Element(13, "Al", "Aluminium", 26.982));
    STORE.put("Si", new Element(14, "Si", "Silicon", 28.085));
    STORE.put("P", new Element(15, "P", "Phosphorus", 30.974));
    STORE.put("S", new Element(16, "S", "Sulphur", 32.06));
    STORE.put("Cl", new Element(17, "Cl", "Chlorine", 35.45));
    STORE.put("Ar", new Element(18, "Ar", "Argon", 39.95));
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public Iterable<Element> findAll()
  {
    return STORE.values()
                .stream()
                .sorted(Comparator.comparing(Element::getNumber))
                .collect(Collectors.toList());
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public Element findOne(final String symbol)
  {
    return symbol != null && STORE.containsKey(symbol)
           ? STORE.get(symbol)
           : null;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public Element save(final Element element)
  {
    if (element != null && element.isValid())
    {
      if (!STORE.containsKey(element.getSymbol()))
      {
        STORE.put(element.getSymbol(), element);
      }

      return element;
    }

    return null;
  }
}
