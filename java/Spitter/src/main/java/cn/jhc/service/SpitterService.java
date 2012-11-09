package cn.jhc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

import cn.jhc.dao.SpittleDao;
import cn.jhc.domain.Spittle;

@Component
public class SpitterService {
	
	@Autowired
	private SpittleDao spittleDao;
	
	public List<Spittle> getRecentSpittles(int count){
		return spittleDao.findAll(new PageRequest(0, count,
				Sort.Direction.DESC, "when")).getContent();
	}
}
