package com.evs.practice.contactform;

import com.evs.vtiger.utils.KishanWebUtil;

public class ContactUsPage extends ContactFormOrlayer{
    private KishanWebUtil kc;
	public ContactUsPage(KishanWebUtil kw) {
		super(kw);
		this.kc=kw;
	}
	
	public void createcontactUsForm()
	{
		kc.myclick(getgotoContactUsPage());
		kc.isDisplayed(getGetInTouch());
		kc.mySenkeys(getContactUsername(), "Kishankumar");
		kc.mySenkeys(getContactEmail(), "kishancoding@yopmail.com");
		kc.mySenkeys(getContactSubjectName(), "ForPersonal");
		kc.mySenkeys(getContactDescription(),"For the personal use submitting the contact us form");
		kc.mySenkeys(getContactUsUploadfile(), "C:\\Users\\CBPC-09\\Pictures\\1698410201637.JPEG");
		kc.myclick(getContactUsSubmitbutton());
		kc.popupaccept();
	}
	
	

}
