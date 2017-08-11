package spring.f01_file;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
@Service
public class A01_FileService {
//	파일 이름과 넘겨온 스트림 형태의 객체를 server의 특정한 위치에 저장
//	<input type=
	public void uploadProc(String name, MultipartFile report) throws IllegalStateException, IOException{
		// eclipse의 임시공간
		String path01="C:/a01_prog/eclipse/workspace_server/.metadata/.plugins/org.eclipse.wst.server.core/tmp3/webapps/springweb/f02_upload/";
		// 실제 파일을 로딩처리. 
		String path02="C:/a01_prog/eclipse/workspace_server/springweb/WebContent/f02_upload/";
		// 해당 경로로 파일을 할당처리.
		String file01 = path01+name;
		String file02 = path02+name;
		// MultipartFile ==> File 객체로 전환하여 저장
		File f1 = new File(file01);
		File f2 = new File(file02);
		MultipartFile mf = report;
		// io로 exception 처리
		mf.transferTo(f1);
		copy(f1,f2);
	}
//	이클립스 임시 공간에 있는 파일을 사용할 위치로 copy 처리	
	public void copy(File orgin, File target) throws IOException{
		FileInputStream in = new FileInputStream(orgin);
		FileOutputStream out = new FileOutputStream(target);
		byte[] buff = new byte[1024*8];
		int inRead;
		while( (inRead=in.read(buff))!=-1){
			out.write(buff, 0, inRead);
		}
		in.close();
		out.close();
	}
}
