package com.ust.feignClient;

import com.ust.DTO.Book;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;


@FeignClient(name = "book-service", url = "http://localhost:8100/api/v1/books")
public interface BookClient {

    @GetMapping("/{id}")
    public Book getBookById(@PathVariable long id);

    @PutMapping("/{id}/stock")
    void updateStock(@PathVariable long id, @RequestParam int newStock);
}
