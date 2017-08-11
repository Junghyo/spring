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
//	���� �̸��� �Ѱܿ� ��Ʈ�� ������ ��ü�� server�� Ư���� ��ġ�� ����
//	<input type=
	public void uploadProc(String name, MultipartFile report) throws IllegalStateException, IOException{
		// eclipse�� �ӽð���
		String path01="C:/a01_prog/eclipse/workspace_server/.metadata/.plugins/org.eclipse.wst.server.core/tmp3/webapps/springweb/f02_upload/";
		// ���� ������ �ε�ó��. 
		String path02="C:/a01_prog/eclipse/workspace_server/springweb/WebContent/f02_upload/";
		// �ش� ��η� ������ �Ҵ�ó��.
		String file01 = path01+name;
		String file02 = path02+name;
		// MultipartFile ==> File ��ü�� ��ȯ�Ͽ� ����
		File f1 = new File(file01);
		File f2 = new File(file02);
		MultipartFile mf = report;
		// io�� exception ó��
		mf.transferTo(f1);
		copy(f1,f2);
	}
//	��Ŭ���� �ӽ� ������ �ִ� ������ ����� ��ġ�� copy ó��	
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
