package human.class1.ajax.controller;

import human.class1.ajax.dto.Process;
import human.class1.ajax.dto.Process2;
import human.class1.ajax.mapper.ProcessMapper;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class ProcessController {

    @Autowired
    private ProcessMapper processMapper;

    @PostMapping("/Process")
    @Transactional // 트랜잭션 관리 어노테이션 추가
    public String saveProcess(@RequestParam String processCode,
                               @RequestParam String processName,
                               @RequestParam String processCategory,
                               @RequestParam String isUsed,
                               @RequestParam String cycleTime,
                               @RequestParam String productCode,
                               @RequestParam String[] underProcessData,
                               @RequestParam String[] processNameData,
                               @RequestParam String[] productContentData,
                               @RequestParam String[] processCodeData,
                               RedirectAttributes redirectAttributes,
                               MultipartHttpServletRequest req) {

        // 이미지 저장 처리
        List<MultipartFile> fileList = req.getFiles("image");
        String[] imageData = new String[fileList.size()];
        String relativePath = "/resources/uploadedImages/";

        // 사용자 홈 디렉토리 경로 설정
        String basePath = System.getProperty("user.home") + "\\Documents\\Peanutbutter\\peanutbutter\\src\\main\\webapp\\resources\\uploadedImages"; // 서버에 이미지 저장할 절대 경로
        
        System.out.println("Current User Home Directory: " + basePath);
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

        // Process 저장 처리
        Process process = new Process(processCode, processName, processCategory, isUsed, cycleTime, productCode, productCode);
        
        try {
            processMapper.saveProcess(process);
        } catch (Exception e) {
            e.printStackTrace();
            redirectAttributes.addFlashAttribute("error", "Error saving process.");
            return "redirect:/factory_Management";
        }

        // Process2 저장 처리
        if (underProcessData != null && processNameData != null && productContentData != null && imageData != null && processCodeData != null) {
            for (int i = 0; i < underProcessData.length; i++) {
                // 각 배열의 데이터에서 대괄호와 쌍따옴표를 제거하고 일반 문자열로 파싱
                String underProcessString = underProcessData[i].replaceAll("[\\[\\]\"']", "");
                String processNameString = processNameData[i].replaceAll("[\\[\\]\"']", "");
                String productContentString = productContentData[i].replaceAll("[\\[\\]\"']", "");
                String imageString = imageData[i]; // 웹 경로로 변환된 imageData 사용
                String processCodeString = processCodeData[i].replaceAll("[\\[\\]\"']", "");
                
                Process2 process2 = new Process2(underProcessString, processNameString, imageString, productContentString, processCodeString);
                try {
                    processMapper.saveProcess2(process2);
                } catch (Exception e) {
                    e.printStackTrace();
                    redirectAttributes.addFlashAttribute("error", "Error saving process2.");
                    return "redirect:/factory_Management";
                }
            }
        }
    
        return "redirect:/factory_Management";
    }

    @GetMapping("/ProcessForm")
    public String showProcessForm() {
        return "factoryReg"; // JSP 페이지 이름
    }
}