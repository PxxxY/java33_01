package com.accp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.accp.Service.BillService;
import com.accp.domain.TbBill;

@Controller
@RequestMapping("/bill")
public class BillController {
	@Autowired
	private BillService bs;
	@GetMapping("/find")
	private String find() {
		return "find";
	}
	@GetMapping("/Byfind")
	@ResponseBody
	private List<TbBill> ajaxfind() {
		return bs.find();
	}
	@RequestMapping("/findByBillNo")
	@ResponseBody
	public TbBill findByBillNo(String billno) {
		return bs.findByBillNo(billno);
	}
	@RequestMapping("/create")
	@ResponseBody
	public int create(@RequestBody TbBill bill) {
		int count = bs.create(bill);
		return count;
	}
	@RequestMapping("/findMaxBillNo")
	@ResponseBody
	public String findMaxBillNo(String billDate) {
		return bs.findMaxBillNo(billDate);
	}
}
