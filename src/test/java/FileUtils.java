import com.alibaba.druid.util.StringUtils;

import java.io.*;

/**
 * @auth mengjianzhou
 * @Date 2018/4/5
 */
public class FileUtils {

    public static void main(String[] args) {
        FileReader fr = null;
        try {
            fr = new FileReader("E:\\idQueryCityInfo.txt");
            BufferedReader br = new BufferedReader(fr);
            String idInfo = br.readLine();
            while(!StringUtils.isEmpty(idInfo)){
//                System.out.println(idInfo);
                String[] strs = idInfo.split("=");
                String replaceStr = strs[0].replace("@@@[","").replace("]","");
                System.out.println(replaceStr);

                idInfo = br.readLine();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fr.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
