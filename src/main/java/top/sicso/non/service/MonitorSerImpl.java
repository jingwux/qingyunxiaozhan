package top.sicso.non.service;

import com.sun.management.OperatingSystemMXBean;
import top.sicso.non.service.inter.MonitorSer;
import org.springframework.stereotype.Service;

import java.lang.management.ManagementFactory;

@Service
public class MonitorSerImpl implements MonitorSer {
    @Override
   public int getFreeMemory(){
           OperatingSystemMXBean osmxb = ManagementFactory.getPlatformMXBean(OperatingSystemMXBean.class);
           long totalVirtualMemory = osmxb.getTotalPhysicalMemorySize();
           long freePhysicalMemorySize = osmxb.getFreePhysicalMemorySize();
           Double compare = (freePhysicalMemorySize * 1.0 / totalVirtualMemory) * 100;
           return compare.intValue();
   }
}
