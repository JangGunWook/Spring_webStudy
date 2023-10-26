package com.smhrd.Mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.smhrd.Entity.Tbl_Board;

@Repository
@Mapper
public interface UserMapper {

		List<Tbl_Board> abcd();
}
