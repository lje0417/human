package human.class1.ajax.dto;

public class Process2 {
    private String underProcess;
    private String processName2;
    private String image;
    private String productContent;
    private String processCode;

    // Constructor
    public Process2(String underProcess, String processName2, String image, String productContent, String processCode) {
        this.underProcess = underProcess;
        this.processName2 = processName2;
        this.image = image;
        this.productContent = productContent;
        this.processCode = processCode;
    }

    // Getters and Setters
    public String getUnderProcess() {
        return underProcess;
    }

    public void setUnderProcess(String underProcess) {
        this.underProcess = underProcess;
    }

    public String getProcessName2() {
        return processName2;
    }

    public void setProcessName2(String processName2) {
        this.processName2 = processName2;
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
