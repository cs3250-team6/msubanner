/* as implemented at https://spring.io/blog/2016/11/21/the-joy-of-mustache-server-side-templates-for-the-jvm */

package edu.msudenver.cs3250.group6.msubanner;

import java.io.IOException;
import java.io.Writer;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.samskivert.mustache.Mustache;
import com.samskivert.mustache.Template.Fragment;

@ControllerAdvice
class LayoutAdvice {

  @ModelAttribute("layout")
  public Mustache.Lambda layout() {
    return new Layout();
  }

}

class Layout implements Mustache.Lambda {
  String body;
  @Override
  public void execute(Fragment frag, Writer out) throws IOException {
    body = frag.execute();
  }
}