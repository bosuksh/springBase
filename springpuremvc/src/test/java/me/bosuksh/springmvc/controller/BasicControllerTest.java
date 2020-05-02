package me.bosuksh.springmvc.controller;

import me.bosuksh.springmvc.controller.BasicController;
import org.junit.Before;
import org.junit.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

public class BasicControllerTest {
    private MockMvc mockMvc;

    @Before
    public void setUp() {
        this.mockMvc = MockMvcBuilders.standaloneSetup(
                new BasicController()
        ).setViewResolvers(viewResolver())
                .build();

    }

    private ViewResolver viewResolver() {
        InternalResourceViewResolver viewResolver =
                new InternalResourceViewResolver();
        viewResolver.setViewClass(JstlView.class);
        viewResolver.setPrefix("/WEB-INF/views/");
        viewResolver.setSuffix(".jsp");
        return viewResolver;
    }

    @Test
    public void basicTest() throws Exception {
        this.mockMvc.perform(
                get("/welcome")
                .accept(MediaType.parseMediaType("application/html;charset=UTF-8")))
                .andExpect(status().isOk())
                .andExpect(content().contentType(
                        "application/html;charset=UTF-8"
                ))
                .andExpect(content().string("Welcome to Spring MVC"));
    }

    @Test
    public void testWelcomeView() throws Exception {
        this.mockMvc.perform(
                get("/welcome-view")
                .accept(MediaType.parseMediaType("application/html;charset=UTF-8"))
        ).andExpect(view().name("welcome"));
    }
}