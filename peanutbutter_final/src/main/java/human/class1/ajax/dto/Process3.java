package human.class1.ajax.dto;

public class Process3 {
    private String underProcess;
    private String processName;
    private String image;
    private String productContent;
    private String processCode;

    // 생성자
    public Process3(String underProcess, String processName, String image, String productContent, String processCode) {
        this.underProcess = underProcess;
        this.processName = processName;
        this.image = image;
        this.productContent = productContent;
        this.processCode = processCode;
    }

    // Getter 및 Setter 메서드
    public String getUnderProcess() {
        return underProcess;
    }

    public void setUnderProcess(String underProcess) {
        this.underProcess = underProcess;
    }

    public String getProcessName() {
        return processName;
    }

    public void setProcessName(String processName) {
        this.processName = processName;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getProductContent() {
        return productContent;
    }

    public void setProductContent(String productContent) {
        this.productContent = productContent;
    }

    public String getProcessCode() {
        return processCode;
    }

    public void setProcessCode(String processCode) {
        this.processCode = processCode;
    }
}
