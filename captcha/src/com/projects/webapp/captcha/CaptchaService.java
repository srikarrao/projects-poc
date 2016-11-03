package com.projects.webapp.captcha;

import com.octo.captcha.service.image.DefaultManageableImageCaptchaService;
import com.octo.captcha.service.image.ImageCaptchaService;

public class CaptchaService {
	// a singleton class
	private static ImageCaptchaService instance = new DefaultManageableImageCaptchaService();

	public static ImageCaptchaService getInstance() {
		return instance;
	}
}