package id.co.miniproject.ecomm.controller;

import id.co.miniproject.ecomm.entity.Item;
import id.co.miniproject.ecomm.service.ItemService;
import id.co.miniproject.ecomm.util.ErrorCode;
import id.co.miniproject.ecomm.util.ResponseUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/item")
public class ItemController {

    private final ItemService itemService;
    private final ResponseUtils responseUtils;

    @GetMapping()
    private ResponseEntity<Object> getAllItem() {
        List<Item> response = itemService.getAllItem();
        if (ObjectUtils.isEmpty(response)) {
            return responseUtils.generate(ErrorCode.Not_Found, HttpStatus.NOT_FOUND, null);
        }
        return responseUtils.generate(ErrorCode.Success, HttpStatus.OK, response);
    }

    @PostMapping()
    private ResponseEntity<Object> addNewItem(@Validated @RequestBody Item item) {
        Item newItem = itemService.addNewItem(item);
        if (StringUtils.isEmpty(newItem)) {
            return responseUtils.generate(ErrorCode.General_Error, HttpStatus.BAD_REQUEST, null);
        }
        return responseUtils.generate(ErrorCode.Success, HttpStatus.ACCEPTED, newItem);
    }

    @GetMapping("/{id}")
    private ResponseEntity<Object> getItemById(@PathVariable("id") int id) {
        Item item = itemService.getItem(id);
        if (ObjectUtils.isEmpty(item)) {
            return responseUtils.generate(ErrorCode.Not_Found, HttpStatus.NOT_FOUND, null);
        }
        return responseUtils.generate(ErrorCode.Success, HttpStatus.OK, item);
    }

    @PutMapping()
    private ResponseEntity<Object> updateItem(@Validated @RequestBody Item item) {
        Item newItem = itemService.updateItemData(item);
        if (StringUtils.isEmpty(newItem)) {
            return responseUtils.generate(ErrorCode.General_Error, HttpStatus.BAD_REQUEST, null);
        }
        return responseUtils.generate(ErrorCode.Success, HttpStatus.ACCEPTED, newItem);
    }
}
