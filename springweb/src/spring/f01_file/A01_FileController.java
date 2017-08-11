package spring.f01_file;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/upload.do")
public class A01_FileController {
	@Autowired(required=false)
	private A01_FileService service;
	@RequestMapping(method=RequestMethod.GET)
	public String form(){
		return "f01_file/a01_uploadForm";
	}
	@RequestMapping(method=RequestMethod.POST)
	public String upload(@RequestParam("name") String name, @RequestParam("report") MultipartFile report, Model m) throws IllegalStateException, IOException{
		System.out.println("서버에 온 파일"+report.getOriginalFilename());
		service.uploadProc(name, report);
		m.addAttribute("file", report.getOriginalFilename());
		return "f01_file/a01_uploadForm";
	}
	
}
