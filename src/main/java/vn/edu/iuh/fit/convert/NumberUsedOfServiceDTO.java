package vn.edu.iuh.fit.convert;

import jakarta.persistence.ColumnResult;
import jakarta.persistence.ConstructorResult;
import jakarta.persistence.SqlResultSetMapping;

@SqlResultSetMapping(
        name = "NumberUsedOfService",
        classes = {
                @ConstructorResult(
                        targetClass = NumberUsedOfServiceDTO.class,
                        columns = {
                                @ColumnResult(name = "ServiceID", type = Long.class),
                                @ColumnResult(name = "TotalUsed", type = Long.class)
                        }
                )
        }
)
public class NumberUsedOfServiceDTO{
    private  long svcID;
    private long totalUsed;

    public NumberUsedOfServiceDTO() {
    }

    public NumberUsedOfServiceDTO(long svcID, long totalUsed) {
        this.svcID = svcID;
        this.totalUsed = totalUsed;
    }

    public long getSvcID() {
        return svcID;
    }

    public void setSvcID(long svcID) {
        this.svcID = svcID;
    }

    public long getTotalUsed() {
        return totalUsed;
    }

    public void setTotalUsed(long totalUsed) {
        this.totalUsed = totalUsed;
    }

    @Override
    public String toString() {
        return "NumberUsedOfServiceDTO{" +
                "svcID=" + svcID +
                ", totalUsed=" + totalUsed +
                '}';
    }
}
