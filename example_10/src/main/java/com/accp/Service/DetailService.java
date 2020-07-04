package com.accp.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.accp.dao.TbBillMapper;
import com.accp.dao.TbDetailMapper;
import com.accp.domain.TbBill;
import com.accp.domain.TbBillExample;
import com.accp.domain.TbDetail;
import com.accp.domain.TbDetailExample;
import com.fasterxml.jackson.core.JsonParser;

@Service
@Transactional
public class DetailService {
	@Autowired
	private TbDetailMapper mapper;
	@Autowired
	private TbBillMapper mappe;
	public List<TbDetail> find(String dh) {
		TbDetailExample example=new TbDetailExample();
		example.createCriteria().andBillnoEqualTo(dh);
		List<TbDetail> list=mapper.selectByExample(example);
		return list;
	}
	
	public int add(TbBill tb) {
		int count =mappe.insert(tb);
		
		if(count>0) {
			for(TbDetail tf:tb.getDetails()) {
				tf.setBillno(tb.getBillno());
				mapper.insert(tf);
			}
		}
		return count;
	}
	public int remove(String billno) {
		TbDetailExample example=new TbDetailExample();
		example.createCriteria().andBillnoEqualTo(billno);
		int count=mapper.deleteByExample(example);
		return count;
	}
}
