package com.accp.Service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.accp.dao.TbBillMapper;
import com.accp.dao.TbDetailMapper;
import com.accp.domain.TbBill;
import com.accp.domain.TbDetail;
import com.accp.domain.TbDetailExample;

@Service
@Transactional
public class BillService {
	@Autowired
	private TbBillMapper mapper;
	@Autowired
	private TbDetailMapper mapper2;
	
	public List<TbBill> find() {
		List<TbBill> list= mapper.selectByExample(null);
		for(TbBill s:list) {
			TbDetailExample example=new TbDetailExample();
			example.createCriteria().andBillnoEqualTo(s.getBillno());
			List<TbDetail> li=mapper2.selectByExample(example);
			double sumprice = 0;
			for(TbDetail d:li) {
				sumprice+=d.getGoodsmoneyamt();
			}
			s.setSumprice(sumprice);
		}
		return list;
	}
	
	public TbBill findByBillNo(String billno) {
		TbBill b = mapper.selectByPrimaryKey(billno);
		TbDetailExample example = new TbDetailExample();
		example.createCriteria().andBillnoEqualTo(billno);
		List<TbDetail> details = mapper2.selectByExample(example);
		b.setDetails(details);
		return b;
	}

	public int create(TbBill bill) {
		int count = mapper.insert(bill);
		if(count>0) {
			for(TbDetail d : bill.getDetails()) {
				d.setBillno(bill.getBillno());
				mapper2.insert(d);
			}
		}
		return count;
	}
	public String findMaxBillNo(String billDate) {
		String billno = mapper.findMaxBillNo(billDate);
		if(billno==null) {
			return billDate.replaceAll("-", "")+"001";
		}else {
			String suffix = billno.substring(9, billno.length());
			int sf = Integer.valueOf(suffix);
			if(sf<10) {
				return billDate.replaceAll("-", "")+"00"+(sf+1);
			}else if(sf<100) {
				return billDate.replaceAll("-", "")+"0"+(sf+1);
			}else {
				return billDate.replaceAll("-", "")+(sf+1);
			}
		}
	}
}
