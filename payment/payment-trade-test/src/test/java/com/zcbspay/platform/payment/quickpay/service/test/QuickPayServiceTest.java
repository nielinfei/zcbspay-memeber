package com.zcbspay.platform.payment.quickpay.service.test;

import org.junit.Test;




import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.fastjson.JSON;
import com.zcbspay.platform.payment.bean.ResultBean;
import com.zcbspay.platform.payment.exception.PaymentQuickPayException;
import com.zcbspay.platform.payment.exception.PaymentRouterException;
import com.zcbspay.platform.payment.quickpay.bean.PayBean;
import com.zcbspay.platform.payment.quickpay.service.QuickPayService;

public class QuickPayServiceTest extends BaseTest{

	@Reference(version="1.0")
	private QuickPayService quickPayService;
	
	@Test
	public void test_pay(){
		PayBean payBean = new PayBean();
		payBean.setCardNo("6228480018543668979");
		payBean.setCardKeeper("郭佳");
		payBean.setCardType("1");
		payBean.setPhone("18600806796");
		payBean.setCertNo("110105198610094112");
		payBean.setTn("170113061000000004");
		payBean.setTxnAmt("2");
		try {
			ResultBean pay = quickPayService.pay(payBean);
			
			
			System.out.println(JSON.toJSONString(pay));
		} catch (PaymentQuickPayException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (PaymentRouterException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}