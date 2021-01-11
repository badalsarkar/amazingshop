package ca.badalsarkar.amazingshop.restcontrollers;

import ca.badalsarkar.amazingshop.assemblers.ProductAssembler;
import ca.badalsarkar.amazingshop.repositories.ProductRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@WebMvcTest(ProductController.class)
class ProductControllerTest {

    @MockBean
    private ProductRepository repository;
    @MockBean
    private ProductAssembler assembler;
    @Autowired
    private MockMvc mockMvc;

    @Test
    void all() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/products/7"))
                .andExpect(status().isOk());
    }

    @Test
    void one() throws Exception {
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get("/products/7")).andReturn();
        System.out.println(result.getResponse());
        assertEquals(2,2);
    }

    @Test
    void newProduct() {
    }
}