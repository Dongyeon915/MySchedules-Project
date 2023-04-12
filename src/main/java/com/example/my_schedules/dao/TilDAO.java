package com.example.my_schedules.dao;

import com.example.my_schedules.dto.TilDTO;
import com.example.my_schedules.dto.TuiDTO;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface TilDAO {
//    작업중
    public List<TilDTO> getPage(int pageId);

    public List<TilDTO> getUsetByTilContent();

    public TilDTO getTilContentById(int id);

    public int setContent(TilDTO TilDTO);
    
    public int updateContent(TilDTO TilDTO);
    
    public int deleteContent(int id);
}
