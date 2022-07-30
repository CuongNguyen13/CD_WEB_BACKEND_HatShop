package com.example.demo.service;

import com.example.demo.dto.BillDTO;
import com.example.demo.dto.CartProductDTO;
import com.example.demo.dto.ListPage;
import com.example.demo.dto.PrepaymentDTO;
import com.example.demo.entity.Cart;
import com.example.demo.entity.Prepayment;
import com.example.demo.entity.Products;
import com.example.demo.entity.User;
import com.example.demo.repository.CartRepository;
import com.example.demo.repository.PrepaymentRespository;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class PrepaymentService {
    @Autowired
    PrepaymentRespository prepaymentRespository;
    @Autowired
    CartRepository cartRepository;
    @Autowired
    UserRepository userRepository;

    @Autowired
    CartService cartService;

    public String savePayment(PrepaymentDTO prepaymentDTO){
        List<Cart> cartList = cartRepository.findByUserIdAndStatusTrue(prepaymentDTO.getUserId());
        User user = userRepository.findById(prepaymentDTO.getUserId());
        try {
            Prepayment prepayment = new Prepayment();
            prepayment.setCartList(cartList);
            prepayment.setUser(user);
            prepayment.setAddress(prepaymentDTO.getAddress());
            prepayment.setEmail(prepaymentDTO.getEmail());
            prepayment.setDescription(prepaymentDTO.getDescription());
            prepayment.setName(prepaymentDTO.getName());
            prepayment.setPhoneNumber(prepaymentDTO.getPhone());
            prepayment.setPrice(prepaymentDTO.getTotal());
            //date
            LocalDate myObj = LocalDate.now();
            prepayment.setDate(java.sql.Date.valueOf(myObj));
            prepayment.setStatus(0);

           Prepayment pre = prepaymentRespository.save(prepayment);
            for (int i = 0; i < cartList.size(); i++) {
                cartList.get(i).setStatus(false);
                cartList.get(i).setPrepayment(prepayment);
                cartRepository.save(cartList.get(i));
            }
            return  pre.getId()+"";
        }catch (Exception e){



            return null;
        }
    }


    public BillDTO billDTO(int id){
        List<CartProductDTO> cartProductDTOList = cartService.listCartPayment(id);
        Prepayment prepayment = prepaymentRespository.findById(id);
        BillDTO billDTO = new BillDTO();
        billDTO.setCart(cartProductDTOList);
        billDTO.setAddress(prepayment.getAddress());
        billDTO.setDate(prepayment.getDate());
        billDTO.setDescription(prepayment.getDescription());
        billDTO.setEmail(prepayment.getEmail());
        billDTO.setName(prepayment.getName());
        billDTO.setPhone(prepayment.getPhoneNumber());
        billDTO.setId(prepayment.getId());
        billDTO.setTotal(prepayment.getPrice());
        billDTO.setStatus(prepayment.getStatus());
        return billDTO;
    }


    public ListPage<PrepaymentDTO> findAllAdmin(int page, int limit){
        ListPage<PrepaymentDTO> resp = new ListPage<>();
        Pageable paging = PageRequest.of(page - 1,limit);
        Page<Prepayment> pageData = prepaymentRespository.findAll(paging);
        List<PrepaymentDTO> prepaymentDTOList = new ArrayList<>();
        List<Prepayment> prepaymentList = pageData.getContent();
        for (int i = 0; i < prepaymentList.size(); i++) {
            PrepaymentDTO prepaymentDTO = new PrepaymentDTO();
            prepaymentDTO.setAddress(prepaymentList.get(i).getAddress());
            prepaymentDTO.setDescription(prepaymentList.get(i).getDescription());
            prepaymentDTO.setEmail(prepaymentList.get(i).getEmail());
            prepaymentDTO.setName(prepaymentList.get(i).getName());
            prepaymentDTO.setPhone(prepaymentList.get(i).getPhoneNumber());
            prepaymentDTO.setTotal(prepaymentList.get(i).getPrice());
            prepaymentDTO.setUserId(prepaymentList.get(i).getId());
            prepaymentDTO.setDate(prepaymentList.get(i).getDate());
            prepaymentDTO.setStatus(prepaymentList.get(i).getStatus());
            prepaymentDTOList.add(prepaymentDTO);
        }
        resp.setList(prepaymentDTOList);
        resp.setCurrentPage(pageData.getNumber()+1);
        resp.setTotalItems((int)pageData.getTotalElements());
        resp.setTotalPages(pageData.getTotalPages());

        return resp;

    }

    public List<PrepaymentDTO> listPayment(){
      List<PrepaymentDTO> prepaymentDTOList = new ArrayList<>();
      List<Prepayment> prepaymentList = prepaymentRespository.findAll();
        for (int i = 0; i < prepaymentList.size(); i++) {
            PrepaymentDTO prepaymentDTO = new PrepaymentDTO();
            prepaymentDTO.setAddress(prepaymentList.get(i).getAddress());
            prepaymentDTO.setDescription(prepaymentList.get(i).getDescription());
            prepaymentDTO.setEmail(prepaymentList.get(i).getEmail());
            prepaymentDTO.setName(prepaymentList.get(i).getName());
            prepaymentDTO.setPhone(prepaymentList.get(i).getPhoneNumber());
            prepaymentDTO.setTotal(prepaymentList.get(i).getPrice());
            prepaymentDTO.setUserId(prepaymentList.get(i).getId());

        prepaymentDTOList.add(prepaymentDTO);

        }



      return prepaymentDTOList;
    }

    public boolean updateStatus(int id,int status){

        try {
            Prepayment prepayment = prepaymentRespository.findById(id);
            prepayment.setStatus(status);
            System.err.println(prepayment.toString());
            prepaymentRespository.save(prepayment);
            return true;
        }catch (Exception e){
            return false;
        }
    }

}
