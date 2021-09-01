package ru.gb.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import ru.gb.domain.Product;
import ru.gb.service.ProductService;

@Controller
@RequiredArgsConstructor
public class CartController {

  private final ProductService productService;

  @GetMapping("/")
  public String index(Model model) {
    model.addAttribute("message", "Hello World");
    return "index";
  }

  @GetMapping
  public String getAllProducts(Model model) {
    model.addAttribute("products", productService.getAll());
    return "products";
  }

  @PostMapping
  public String add(Model model) {
    model.addAttribute("product", new Product());
    return "products-add";
  }
}
