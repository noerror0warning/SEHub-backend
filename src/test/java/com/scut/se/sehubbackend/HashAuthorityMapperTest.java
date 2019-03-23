package com.scut.se.sehubbackend;


import com.scut.se.sehubbackend.Security.Authorization.HashAuthorityMapper;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Spy;
import org.powermock.modules.junit4.PowerMockRunner;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

@RunWith(PowerMockRunner.class)
public class HashAuthorityMapperTest {

    @Spy HashAuthorityMapper mapper=new HashAuthorityMapper();

    @Test
    //测试构造函数中设置的默认权限是否真正设置，同时查看字段是否与预想中一致
    public void testConstructor(){
        Assert.assertEquals(new SimpleGrantedAuthority("Minister_Research"),mapper.map("Minister_Research"));//用部长做测试
        Assert.assertEquals(new SimpleGrantedAuthority("Staff_Research"),mapper.map("Staff_Research"));//用部员做测试
        Assert.assertEquals(new SimpleGrantedAuthority("StandingCommittee_"),mapper.map("StandingCommittee"));//用常委做测试
        Assert.assertEquals(new SimpleGrantedAuthority("Dynamic_Research"),mapper.map("Dynamic_Research"));//用动态权限做测试
        Assert.assertEquals(null,mapper.map("randomTest"));//尝试获取不存在的权限
    }

}
