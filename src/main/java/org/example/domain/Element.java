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

package org.example.domain;

/**
 * An element in the periodic table.
 */
public class Element
{
  private String name;
  private int    number;
  private String symbol;
  private double weight;

  /**
   * Default constructor.
   */
  public Element()
  {
    super();
  }

  /**
   * Creates an element with given details.
   *
   * @param number The atomic number of the element.
   * @param symbol The chemical symbol of the element.
   * @param name   The chemical name of the element.
   * @param weight The atomic weight of the element.
   */
  public Element(final int number, final String symbol, final String name, final double weight)
  {
    this();

    setName(name);
    setNumber(number);
    setSymbol(symbol);
    setWeight(weight);
  }

  /**
   * Gets the chemical name of the element.
   *
   * @return The chemical name of the element.
   */
  public String getName()
  {
    return name;
  }

  /**
   * Gets the atomic number of the element.
   *
   * @return The atomic number of the element.
   */
  public int getNumber()
  {
    return number;
  }

  /**
   * Gets the chemical symbol of the element.
   *
   * @return The chemical symbol of the element.
   */
  public String getSymbol()
  {
    return symbol;
  }

  /**
   * Gets the standard atomic weight of the element.
   *
   * @return The standard atomic weight of the element.
   */
  public double getWeight()
  {
    return weight;
  }

  /**
   * Gets whether all necessary information about the element is available.
   *
   * @return {@code true} if all necessary information about the element is
   * available, {@code false} otherwise.
   */
  public boolean isValid()
  {
    return getName() != null
        && getNumber() > 0
        && getSymbol() != null
        && getWeight() >= 1;
  }

  /**
   * Sets the chemical name of the element.
   *
   * @param name The chemical name of the element.
   */
  public void setName(final String name)
  {
    this.name = name;
  }

  /**
   * Sets the atomic number of the element.
   *
   * @param number The atomic number of the element.
   */
  public void setNumber(final int number)
  {
    this.number = number;
  }

  /**
   * Sets the chemical symbol of the element.
   *
   * @param symbol The chemical symbol of the element.
   */
  public void setSymbol(final String symbol)
  {
    this.symbol = symbol;
  }

  /**
   * Sets the standard atomic weight of the element.
   *
   * @param weight The standard atomic weight of the element.
   */
  public void setWeight(final double weight)
  {
    this.weight = weight;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public String toString()
  {
    return "Element { " +
        "number=" + getNumber() + ", " +
        "symbol='" + getSymbol() + "', " +
        "name='" + getName() + "', " +
        "weight=" + getWeight() + "}";
  }
}
