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

package org.example.resource;

import org.example.data.ElementRepository;
import org.example.domain.Element;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * Provides an API for managing elements.
 */
@Consumes(MediaType.APPLICATION_JSON)
@Path("/elements")
@Produces(MediaType.APPLICATION_JSON)
public class ElementResource
{
  @Inject
  ElementRepository repository;

  /**
   * Gets an element with a specified chemical symbol.
   *
   * @param symbol The chemical symbol for the element to find.
   * @return A response containing an {@link Element} if one with the specified
   * symbol exists, HTTP {@code 404} otherwise.
   * @code GET: /elements/[symbol]
   */
  @GET
  @Path("{symbol}")
  public Response get(@PathParam("symbol") final String symbol)
  {
    final Element element = repository.findOne(symbol);

    if (element == null)
    {
      return Response.status(Response.Status.NOT_FOUND).build();
    }

    return Response.ok(element).build();
  }

  /**
   * Adds a new element.
   *
   * @param element The element to add.
   * @return The added element.
   * @code POST: /elements
   */
  @POST
  public Element insert(final Element element)
  {
    return repository.save(element);
  }

  /**
   * Gets all available elements.
   *
   * @return An {@link Iterable} of {@link Element}s.
   * @code GET: /elements
   */
  @GET
  public Iterable<Element> list()
  {
    return repository.findAll();
  }
}
