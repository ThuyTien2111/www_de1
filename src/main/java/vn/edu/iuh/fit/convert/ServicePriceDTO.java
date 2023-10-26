package vn.edu.iuh.fit.convert;

import jakarta.persistence.ColumnResult;
import jakarta.persistence.ConstructorResult;
import jakarta.persistence.SqlResultSetMapping;

@SqlResultSetMapping(
        name="ServicePriceDTO",
        classes = {
                @ConstructorResult(
                        targetClass = ServicePriceDTO.class,
                        columns = {
                                @ColumnResult(name = "ServiceID", type = Long.class),
                                @ColumnResult(name = "ServiceName", type = String.class),
                                @ColumnResult(name = "Description", type = String.class),
                                @ColumnResult(name = "Status", type = Integer.class),
                                @ColumnResult(name = "Price", type = Double.class),

                        }
                )
        }

)
public class ServicePriceDTO {
    private long svcID;
    private String svcName;
    private String des;
    private int status;
    private double price;

    public ServicePriceDTO() {
    }

    public ServicePriceDTO(long svcID, String svcName, String des, int status, double price) {
        this.svcID = svcID;
        this.svcName = svcName;
        this.des = des;
        this.status = status;
        this.price = price;
    }

    public long getSvcID() {
        return svcID;
    }

    public void setSvcID(long svcID) {
        this.svcID = svcID;
    }

    public String getSvcName() {
        return svcName;
    }

    public void setSvcName(String svcName) {
        this.svcName = svcName;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "ServicePrice{" +
                "svcID=" + svcID +
                ", svcName='" + svcName + '\'' +
                ", des='" + des + '\'' +
                ", status=" + status +
                ", price=" + price +
                '}';
    }
}
