package human.class1.ajax.controller;

import human.class1.ajax.dto.Process;
import human.class1.ajax.dto.Process3;
import human.class1.ajax.dao.ProcessDAO2;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional; // 추가
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class UpdateProcessController {

    @Autowired
    private ProcessDAO2 processDAO2;

    @Transactional // 트랜잭션 추가
    @PostMapping("/updateProcess")
    public String updateProcess(
            @RequestParam String processCode,
            @RequestParam String processName,
            @RequestParam String processCategory,
            @RequestParam String isUsed,
            @RequestParam String cycleTime,
            @RequestParam String productCode,
            @RequestParam String processCodeHidden,
            @RequestParam String[] underProcessData,
            @RequestParam String[] processNameData,
            @RequestParam String[] productContentData,
            MultipartHttpServletRequest req,
            @RequestParam String[] processCodeData,
            RedirectAttributes redirectAttributes) throws SQLException {
       
       
        // Process 객체 생성
        Process process = new Process(processCode, processName, processCategory, isUsed, cycleTime, productCode, processCodeHidden);
        try {
            // 프로세스 업데이트 로직
            processDAO2.updateProcess(process); // Process 객체를 전달
            System.out.println("Process updated successfully.");
        } catch (Exception e) {
            e.printStackTrace();
            redirectAttributes.addFlashAttribute("error", "Error updating process.");
            return "redirect:/factory_Management";
        }
        
        // Process2 업데이트 로직
        processDAO2.deleteProcess(processCode); // 기존 프로세스 삭제
        
        List<MultipartFile> fileList = req.getFiles("image");
        String[] imageData = new String[fileList.size()];
        String relativePath = "/resources/uploadedImages/";

        // 사용자 홈 디렉토리 경로 설정
        String basePath = System.getProperty("user.home") + "\\Documents\\Peanutbutter\\peanutbutter\\src\\main\\webapp\\resources\\uploadedImages"; // 서버에 이미지 저장할 절대 경로

        // 디렉토리 생성
        File uploadDir = new File(basePath);
        if (!uploadDir.exists()) {
            uploadDir.mkdirs(); // 디렉토리가 없으면 생성
        }

        for (int i = 0; i < fileList.size(); i++) {
            MultipartFile mf = fileList.get(i);
            long fileSize = mf.getSize();
            System.out.println("fileSize: " + fileSize);

            String fileName = mf.getOriginalFilename();
            System.out.println("fileName: " + fileName);

            try {
                String safeFileName = System.currentTimeMillis() + "_" + fileName;
                File file = new File(uploadDir, safeFileName); // uploadDir 사용
                
                // 파일 서버에 저장
                mf.transferTo(file);

                // 웹에서 접근 가능한 경로로 변환하여 DB에 저장
                imageData[i] = relativePath + safeFileName; // 이미지 URL 경로로 변환하여 저장
            } catch (IllegalStateException | IOException e) {
                e.printStackTrace();
            }
           }
        if (underProcessData != null && processNameData != null && productContentData != null && imageData != null && processCodeData != null) {
            for (int i = 0; i < underProcessData.length; i++) {
                // 각 배열의 데이터에서 대괄호와 쌍따옴표를 제거하고 일반 문자열로 파싱
                String underProcessString = underProcessData[i].replaceAll("[\\[\\]\"']", "");
                String processNameString = processNameData[i].replaceAll("[\\[\\]\"']", "");
                String productContentString = productContentData[i].replaceAll("[\\[\\]\"']", "");
                String imageString = imageData[i]; // safeFileName으로 변경된 imageData 사용
                String processCodeString = processCodeData[i].replaceAll("[\\[\\]\"']", "");

                // Process3 객체 생성
                Process3 process3 = new Process3(underProcessString, processNameString, imageString, productContentString, processCodeString);
                
                try {
                    // Process3 저장 로직
                    processDAO2.saveProcess(process3); 
                    System.out.println("Process3 updated successfully.");
                } catch (Exception e) {
                    e.printStackTrace();
                    redirectAttributes.addFlashAttribute("error", "Error updating process3.");
                    return "redirect:/factory_Management";
                }
            }
        }

        return "redirect:/factory_Management"; 
    }
}
