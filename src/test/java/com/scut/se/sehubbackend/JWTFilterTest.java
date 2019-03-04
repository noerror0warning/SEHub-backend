package com.scut.se.sehubbackend;

import com.scut.se.sehubbackend.Config.WebConfig;
import com.scut.se.sehubbackend.Filter.JWTFilter;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.*;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import org.powermock.reflect.Whitebox;

import javax.servlet.FilterChain;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import static org.mockito.Mockito.*;


@RunWith(PowerMockRunner.class)
@PrepareForTest(JWTFilter.class)
public class JWTFilterTest {

    @Mock
    WebConfig webConfig;

    @Spy
    @InjectMocks
    JWTFilter jwtFilter=new JWTFilter();

    @Mock
    HttpServletRequest request;
    Boolean result;

    @Before
    public void before() throws NoSuchFieldException, IllegalAccessException {
        MockitoAnnotations.initMocks(this);//生成Mock

        Mockito.when(webConfig.getLoginURI()).thenReturn("/login");//对webConfig stubbing
        Mockito.when(webConfig.getAuthorityKey()).thenReturn("jwt");
    }

    @Test
    public void testIsLogin() throws Exception {
        String loginURI=webConfig.getLoginURI();
        Mockito.when(request.getRequestURI())
                .thenReturn(loginURI)//设置一个登陆的请求
                .thenReturn(loginURI+"/random")//设置一个加后缀的请求
                .thenReturn("/random"+loginURI)//设置一个加前缀的请求
                .thenReturn("/random");//设置一个与登陆无关的请求

        result=Whitebox.invokeMethod(jwtFilter,"isLogin",request);
        Assert.assertEquals(true,result);

        result=Whitebox.invokeMethod(jwtFilter,"isLogin",request);
        Assert.assertEquals(false,result);

        result=Whitebox.invokeMethod(jwtFilter,"isLogin",request);
        Assert.assertEquals(false,result);

        result=Whitebox.invokeMethod(jwtFilter,"isLogin",request);
        Assert.assertEquals(false,result);
    }

    @Test
    public void testHasJWT() throws Exception {
        Mockito.when(request.getHeader(webConfig.getAuthorityKey()))
                .thenReturn("randomString")//第一次带有jwt
                .thenReturn(null);//第二次不带jwt

        result=Whitebox.invokeMethod(jwtFilter,"hasJWT",request);//带有jwt测试
        Assert.assertEquals(true,result);
        result=Whitebox.invokeMethod(jwtFilter,"hasJWT",request);//不带jwt测试
        Assert.assertEquals(false,result);
    }

    @Test
    public void testDoInternalFilter() throws Exception {
        FilterChain filterChain=mock(FilterChain.class);
        HttpServletRequest httpServletRequest=mock(HttpServletRequest.class);
        HttpServletResponse httpServletResponse=mock(HttpServletResponse.class);

        //进行四次不同的可能情况
        PowerMockito.doReturn(true,false,true,false).when(jwtFilter,"isLogin",httpServletRequest);
        PowerMockito.doReturn(true,true,false,false).when(jwtFilter,"hasJWT",httpServletRequest);

        Whitebox.invokeMethod(jwtFilter,"doFilterInternal",httpServletRequest,httpServletResponse,filterChain);
        verify(filterChain,times(1)).doFilter(httpServletRequest,httpServletResponse);
        verify(httpServletResponse,times(0)).setStatus(anyInt());

        Whitebox.invokeMethod(jwtFilter,"doFilterInternal",httpServletRequest,httpServletResponse,filterChain);
        verify(filterChain,times(2)).doFilter(httpServletRequest,httpServletResponse);
        verify(httpServletResponse,times(0)).setStatus(anyInt());

        Whitebox.invokeMethod(jwtFilter,"doFilterInternal",httpServletRequest,httpServletResponse,filterChain);
        verify(filterChain,times(3)).doFilter(httpServletRequest,httpServletResponse);
        verify(httpServletResponse,times(0)).setStatus(anyInt());

        Whitebox.invokeMethod(jwtFilter,"doFilterInternal",httpServletRequest,httpServletResponse,filterChain);
        verify(filterChain,times(3)).doFilter(httpServletRequest,httpServletResponse);
        verify(httpServletResponse,times(1)).setStatus(401);

    }
}
