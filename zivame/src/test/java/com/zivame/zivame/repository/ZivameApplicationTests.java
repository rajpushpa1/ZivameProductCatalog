package com.zivame.zivame.repository;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.zivame.zivame.controller.ProductController;
import com.zivame.zivame.model.Product;
import com.zivame.zivame.service.ProductService;

@RunWith(SpringRunner.class)
@WebMvcTest(value=ProductController.class,secure = false)
public class ZivameApplicationTests {
	
	@Autowired
	private MockMvc mockMvc;

	
	@MockBean
	private ProductService productService;

	@Test
	public void saveProductTest() throws Exception {
		
		final Product pd = new Product();
		pd.setProductName("T-shirt");
		pd.setType("Mens-wear");
		pd.setPrice(1000);
		String json = this.mapToJson(pd);
		String URI = "/api/saveproduct";
		String response1 = "Product save";
		
		Mockito.when(productService.saveProduct(Mockito.any(Product.class))).thenReturn(pd);
		
		RequestBuilder requestBuilder = MockMvcRequestBuilders.post(URI).accept(MediaType.APPLICATION_JSON).content(json)
				.contentType(MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		MockHttpServletResponse response = result.getResponse();
		
		String outputInJson = response.getContentAsString();
		System.out.println(outputInJson);
		assertThat(outputInJson).isEqualTo(json);
		assertEquals(HttpStatus.OK.value(), response.getStatus());
	}
	
	
	@Test
	public void getProductTest() throws Exception {
		
		final Product pd = new Product();
		pd.setProductName("T-shirt");
		pd.setType("Mens-wear");
		pd.setPrice(1000);
		String json = this.mapToJson(pd);
		String URI = "/api/getproduct/Mens-wear";
		String json1 = this.mapToJson(pd);
		Mockito.when(productService.getProductByType(Mockito.anyString())).thenReturn(pd);
		
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get(URI).accept(MediaType.APPLICATION_JSON).content(json)
				.contentType(MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		String outputInJson = result.getResponse().getContentAsString();
		System.out.println(outputInJson);
		assertThat(outputInJson).isEqualTo(json1);
	}
	
	
	
	
	private String mapToJson(Object object) throws JsonProcessingException {
		ObjectMapper objectMapper = new ObjectMapper();
		return objectMapper.writeValueAsString(object);
	}

}

