package com.group2.bookstore.service.impl;

import com.group2.bookstore.dto.request.OrderItemRequest;
import com.group2.bookstore.dto.response.OrderItemResponse;
import com.group2.bookstore.dto.response.PageCustom;
import com.group2.bookstore.entity.Book;
import com.group2.bookstore.entity.Order;
import com.group2.bookstore.entity.OrderItem;
import com.group2.bookstore.entity.User;
import com.group2.bookstore.exception.ResourceNotFoundException;
import com.group2.bookstore.repository.BookRepository;
import com.group2.bookstore.repository.OrderItemRepository;
import com.group2.bookstore.repository.OrderRepository;
import com.group2.bookstore.repository.UserRepository;
import com.group2.bookstore.service.OrderItemService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderItemServiceImpl implements OrderItemService {

    private final OrderItemRepository orderItemRepository;
    private final ModelMapper modelMapper;
    private final UserRepository userRepository;
    private final OrderRepository orderRepository;
    private final BookRepository bookRepository;

    @Override
    public OrderItemResponse createOrderItem(OrderItemRequest orderItemRequest){

        if (orderItemRepository.existsByOrderIdAndStatusAndBookId(orderItemRequest.getBookId(), false, orderItemRequest.getBookId())) {
            OrderItem orderItem = orderItemRepository.findByOrderIdAndStatusAndBookId(orderItemRequest.getBookId(), false, orderItemRequest.getBookId()).get();
            orderItem.setQuantity(orderItem.getQuantity() + orderItemRequest.getQuantity());
            orderItem.setTotalPrice(orderItem.getQuantity() * orderItem.getBook().getUnitPrice());
            return modelMapper.map(orderItemRepository.save(orderItem), OrderItemResponse.class);
        }

        OrderItem orderItem = modelMapper.map(orderItemRequest, OrderItem.class);
        User user =  userRepository.findById(orderItemRequest.getUserId()).orElseThrow(() -> new ResourceNotFoundException("User", "id", orderItemRequest.getUserId()));
        orderItem.setUser(user);
        Order order = orderRepository.findByUserId(orderItemRequest.getUserId()).orElseThrow(() -> new ResourceNotFoundException("Order", "userId", orderItemRequest.getUserId()));
        orderItem.setOrder(order);
        Book book = bookRepository.findById(orderItemRequest.getBookId()).orElseThrow(() -> new ResourceNotFoundException("Book", "id", orderItemRequest.getBookId()));
        orderItem.setBook(book);
        orderItem.setTotalPrice(orderItem.getQuantity() * book.getUnitPrice());

        return modelMapper.map(orderItemRepository.save(orderItem), OrderItemResponse.class);
    }

    @Override
    public OrderItemResponse updateOrderItem(Long id, OrderItemRequest orderItemRequest){
        OrderItem orderItem = orderItemRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("OrderItem", "id", id));
        orderItem.setQuantity(orderItemRequest.getQuantity());
        orderItem.setTotalPrice(orderItem.getQuantity() * orderItem.getBook().getUnitPrice());
        return modelMapper.map(orderItemRepository.save(orderItem), OrderItemResponse.class);
    }

    @Override
    public String updateOrderItemStatus(Long id){
        OrderItem orderItem = orderItemRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("OrderItem", "id", id));
        orderItem.setStatus(true);
        orderItemRepository.save(orderItem);
        return "OrderItem with id: " +id+ " was updated successfully";
    }

    @Override
    public String deleteOrderItem(Long id){
        OrderItem orderItem = orderItemRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("OrderItem", "id", id));
        orderItemRepository.delete(orderItem);
        return "OrderItem with id: " +id+ " was deleted successfully";
    }

    @Override
    public OrderItemResponse getOrderItemById(Long id){
        OrderItem orderItem = orderItemRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("OrderItem", "id", id));
        return modelMapper.map(orderItem, OrderItemResponse.class);
    }

    @Override
    public PageCustom<OrderItemResponse> getOrderItemByOrderId(Long orderId, Pageable pageable){
        Page<OrderItem> orderItem = orderItemRepository.findAllByOrderIdAndStatus(orderId,false,pageable);
         PageCustom<OrderItemResponse> pageCustom = PageCustom.<OrderItemResponse>builder()
                .pageNo(orderItem.getNumber() + 1)
                .pageSize(orderItem.getSize())
                .totalPages(orderItem.getTotalPages())
                .pageContent(orderItem.getContent().stream().map(orderItem1 -> modelMapper.map(orderItem1, OrderItemResponse.class)).toList())
                .build();
         return pageCustom;
    }

    @Override
    public PageCustom<OrderItemResponse> getAllOrderItem(Pageable pageable){
        Page<OrderItem> orderItem = orderItemRepository.findAll(pageable);
         PageCustom<OrderItemResponse> pageCustom = PageCustom.<OrderItemResponse>builder()
                .pageNo(orderItem.getNumber() + 1)
                .pageSize(orderItem.getSize())
                .totalPages(orderItem.getTotalPages())
                .pageContent(orderItem.getContent().stream().map(orderItem1 -> modelMapper.map(orderItem1, OrderItemResponse.class)).toList())
                .build();
         return pageCustom;
    }

    @Override
    public PageCustom<OrderItemResponse> getAllOrderedHistory(Long orderId, Pageable pageable){
        Page<OrderItem> orderItem = orderItemRepository.findAllByOrderIdAndStatus(orderId,true,pageable);
         PageCustom<OrderItemResponse> pageCustom = PageCustom.<OrderItemResponse>builder()
                .pageNo(orderItem.getNumber() + 1)
                .pageSize(orderItem.getSize())
                .totalPages(orderItem.getTotalPages())
                .pageContent(orderItem.getContent().stream().map(orderItem1 -> modelMapper.map(orderItem1, OrderItemResponse.class)).toList())
                .build();
         return pageCustom;
    }

    @Override
    public PageCustom<OrderItemResponse> getAllOrderedHistoryByUserId(Long userId,Pageable pageable){
        Page<OrderItem> orderItem = orderItemRepository.findAllByUserIdAndStatus(userId,true,pageable);
         PageCustom<OrderItemResponse> pageCustom = PageCustom.<OrderItemResponse>builder()
                .pageNo(orderItem.getNumber() + 1)
                .pageSize(orderItem.getSize())
                .totalPages(orderItem.getTotalPages())
                .pageContent(orderItem.getContent().stream().map(orderItem1 -> modelMapper.map(orderItem1, OrderItemResponse.class)).toList())
                .build();
         return pageCustom;
    }



}
