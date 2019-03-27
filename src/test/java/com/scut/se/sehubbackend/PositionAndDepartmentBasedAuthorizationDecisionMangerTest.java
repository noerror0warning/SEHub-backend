package com.scut.se.sehubbackend;

import com.scut.se.sehubbackend.Domain.User;
import com.scut.se.sehubbackend.Enumeration.Department;
import com.scut.se.sehubbackend.Enumeration.Position;
import com.scut.se.sehubbackend.Security.Authorization.HashAuthorityMapper;
import com.scut.se.sehubbackend.Security.Authorization.PositionAndDepartmentBasedAuthorizationDecisionManger;
import com.scut.se.sehubbackend.Security.Authorization.interfaces.AuthorityMapper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.modules.junit4.PowerMockRunner;
import org.powermock.reflect.Whitebox;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import static org.junit.Assert.assertEquals;

@RunWith(PowerMockRunner.class)
public class PositionAndDepartmentBasedAuthorizationDecisionMangerTest {

//    @Spy3
    PositionAndDepartmentBasedAuthorizationDecisionManger decisionManger=
            new PositionAndDepartmentBasedAuthorizationDecisionManger();

    AuthorityMapper mapper=new HashAuthorityMapper();
    User luXinNan;//陆鑫楠
    User xieKun;//解坤
    User pengTianXiang;//彭天祥
    User chenYang;//陈扬
    User guoJunWei;//郭俊炜
    User liuYiXi;//刘逸曦
    User zhangYiYun;//张翊雲
    User sunJiaYu;//孙嘉雨

    @Before
    public void createUsers(){
        luXinNan=User.builder().position(Position.StandingCommittee).build();//陆鑫楠
        xieKun=User.builder().position(Position.StandingCommittee).build();//解坤
        pengTianXiang=User.builder().position(Position.Minister).department(Department.Research).build();//彭天祥
        chenYang=User.builder().position(Position.Minister).department(Department.Research).build();//陈扬
        guoJunWei=User.builder().position(Position.Minister).department(Department.Quality).build();//郭俊炜
        liuYiXi=User.builder().position(Position.Staff).department(Department.Research).build();//刘逸曦
        zhangYiYun=User.builder().position(Position.Staff).department(Department.Research).build();//张翊雲
        sunJiaYu=User.builder().position(Position.Staff).department(Department.Media).build();//孙嘉雨
    }

    @Test
    public void testDecide(){
        /**
         * 相同职位间不具备修改权限的权限
         */
        //常委
        assertEquals(false,decisionManger.decide(luXinNan,xieKun,mapper.map(Position.StandingCommittee,null)));
        assertEquals(false,decisionManger.decide(luXinNan,xieKun,mapper.mapDynamic(null,null)));
        //部长
        assertEquals(false,decisionManger.decide(pengTianXiang,chenYang,mapper.map(Position.Minister,Department.Research)));
        assertEquals(false,decisionManger.decide(pengTianXiang,chenYang,mapper.mapDynamic(Department.Research,null)));
        assertEquals(false,decisionManger.decide(pengTianXiang,guoJunWei,mapper.map(Position.Minister,Department.Quality)));
        assertEquals(false,decisionManger.decide(pengTianXiang,guoJunWei,mapper.mapDynamic(Department.Quality,null)));
        //部员
        assertEquals(false,decisionManger.decide(liuYiXi,zhangYiYun,mapper.map(Position.Staff,Department.Research)));
        assertEquals(false,decisionManger.decide(liuYiXi,zhangYiYun,mapper.mapDynamic(Department.Research,null)));
        assertEquals(false,decisionManger.decide(liuYiXi,sunJiaYu,mapper.map(Position.Staff,Department.Media)));
        assertEquals(false,decisionManger.decide(liuYiXi,sunJiaYu,mapper.mapDynamic(Department.Media,null)));

        /**
         *下级对上级无权修改权限
         */

        /**
         * 不同部门之间无权修改权限
         */

        /**
         *常委对部长、部员的职位不可修改
         */

        /**
         *常委对部长、部员的动态权限有权修改
         */
        assertEquals(true,decisionManger.decide(luXinNan,pengTianXiang,mapper.mapDynamic(Department.Research,null)));
        assertEquals(true,decisionManger.decide(luXinNan,guoJunWei,mapper.mapDynamic(Department.Quality,null)));
        assertEquals(true,decisionManger.decide(luXinNan,liuYiXi,mapper.mapDynamic(Department.Research,null)));
        assertEquals(true,decisionManger.decide(luXinNan,sunJiaYu,mapper.mapDynamic(Department.Media,null)));

        /**
         *部长对同部门部员的动态权限有权修改
         */
    }

    @Test
    public void testIsNotImmutable() throws Exception {
        assertEquals(true,Whitebox.invokeMethod(decisionManger,"isNotImmutable",new SimpleGrantedAuthority("Dynamic_")));//测试仅有Dynamic_前缀
        assertEquals(true,Whitebox.invokeMethod(decisionManger,"isNotImmutable",new SimpleGrantedAuthority("Dynamic_xxxx")));//测试Dynamic_前缀起头的任意权限
        assertEquals(false,Whitebox.invokeMethod(decisionManger,"isNotImmutable",new SimpleGrantedAuthority("kjfsdfDynamic_dds")));//测试不以Dynamic_起头但含有Dynamic_的权限
        assertEquals(false,Whitebox.invokeMethod(decisionManger,"isNotImmutable",new SimpleGrantedAuthority("StandingCommittee_")));//测试常委
        assertEquals(false,Whitebox.invokeMethod(decisionManger,"isNotImmutable",new SimpleGrantedAuthority("Minister_Research")));//测试部长
        assertEquals(false,Whitebox.invokeMethod(decisionManger,"isNotImmutable",new SimpleGrantedAuthority("Staff_Research")));//测试部员
    }

}
