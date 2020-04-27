package com.lw.server;

import com.alibaba.fastjson.JSONObject;
import com.lw.controller.FieidController;
import com.lw.pojo.Fieid;
import com.lw.pojo.User;
import com.lw.pojo.dto.UpdateFieidDTO;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public interface FieidServer {

    JSONObject queryAllFieid(HttpServletRequest request);

    int saveFieid(Fieid param);

    int deleteFieidById(Integer id);

    ModelAndView queryFieidById(Integer id,Integer type);

    int updateFieidById(UpdateFieidDTO param);
}
