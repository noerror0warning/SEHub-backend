package com.scut.se.sehubbackend.Security.Authorization;

import com.scut.se.sehubbackend.Domain.User;
import com.scut.se.sehubbackend.Enumeration.Department;
import com.scut.se.sehubbackend.Enumeration.Position;
import com.scut.se.sehubbackend.Security.Authorization.interfaces.AuthorizationDecisionManager;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;


/**
 * 一个基于部门和职位进行决策的实现，可参考{@link AuthorizationDecisionManager}
 * 决策的依据是：
 * 1.{@code operator}与{@code user}应位于相同部门，常委不受限
 * 2.{@code operator}的职位应高于{@code user}
 * 3 部员无权进行权限变更操作
 */
@Service
public class PositionAndDepartmentBasedAuthorizationDecisionManger implements AuthorizationDecisionManager {

    @Override
    public Boolean decide(UserDetails operator, UserDetails user, GrantedAuthority dynamicAuthority) {
        if(!(operator instanceof User)||!(user instanceof User)){//检测类型，以防万一
            return false;
        }

        //获取操作者和被操作者的职位和部门
        Position operatorPosition=((User) operator).getPosition();
        Position userPosition=((User)user).getPosition();
        Department operatorDepartment=((User) operator).getDepartment();
        Department userDepartment=((User)user).getDepartment();

        if(isNotImmutable(dynamicAuthority)){//若权限可变
            if(operatorPosition==Position.StandingCommittee){//操作者为常委时
                return userPosition!=Position.StandingCommittee;//被操作对象不是常委即可
            }else if (operatorPosition==Position.Minister){//操作者为部长时
                return userPosition==Position.Staff&&userDepartment==operatorDepartment;//被操作者为部员且时相同部门
            }else return false;//部员不得操作
        }
        return false;
    }

    //检测目标权限是否可变
    Boolean isNotImmutable(GrantedAuthority dynamicAuthority){
        return dynamicAuthority.getAuthority().contains("Dynamic");
    }
}
