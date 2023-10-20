package vn.edu.iuh.fit.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "service")
public class Service {
    @Id
    @Column(name = "ServiceID")
    private long svcId;
    @Column(name = "ServiceName", columnDefinition = "nvarchar(100)")
    private String svcName;
    @Column(name = "Description", columnDefinition = "nvarchar(500)")
    private String svcDesc;
    @Column(name = "Status", columnDefinition = "tinyint(4)")
    private int status;

    public Service() {
    }

    public Service(long svcId) {
        this.svcId = svcId;
    }

    public long getSvcId() {
        return svcId;
    }

    public void setSvcId(long svcId) {
        this.svcId = svcId;
    }

    public String getSvcName() {
        return svcName;
    }

    public void setSvcName(String svcName) {
        this.svcName = svcName;
    }

    public String getSvcDesc() {
        return svcDesc;
    }

    public void setSvcDesc(String svcDesc) {
        this.svcDesc = svcDesc;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Service(long svcId, String svcName, String svcDesc, int status) {
        this.svcId = svcId;
        this.svcName = svcName;
        this.svcDesc = svcDesc;
        this.status = status;
    }

    @Override
    public String toString() {
        return "Service{" +
                "svcId=" + svcId +
                ", svcName='" + svcName + '\'' +
                ", svcDesc='" + svcDesc + '\'' +
                ", status=" + status +
                '}';
    }
}
