package com.example.presentation.util;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class DutySchedule {
    // 值班人员数组
    private static final String[] STAFF = {"甲", "乙", "丙"};
    
    // 起始日期
    private static final LocalDate START_DATE = LocalDate.of(2025, 11, 17);
    
    /**
     * 获取指定日期的值班人员
     * @param date 查询日期
     * @return 当天值班人员姓名
     */
    public static String getDutyPerson(LocalDate date) {
        // 如果是周末，返回空值或提示
        if (date.getDayOfWeek() == DayOfWeek.SATURDAY || 
            date.getDayOfWeek() == DayOfWeek.SUNDAY) {
            return "非工作日，无值班安排";
        }
        
        // 计算与起始日期之间的工作日天数
        int workdaysDiff = calculateWorkdaysBetween(START_DATE, date);
        
        // 使用模运算确定值班人员索引
        int staffIndex = workdaysDiff % STAFF.length;
        
        return STAFF[staffIndex];
    }
    
    /**
     * 计算两个日期之间的工作日天数
     * @param start 起始日期
     * @param end 结束日期
     * @return 工作日天数差
     */
    private static int calculateWorkdaysBetween(LocalDate start, LocalDate end) {
        // 确保start <= end
        if (end.isBefore(start)) {
            LocalDate temp = start;
            start = end;
            end = temp;
        }
        
        long totalDays = ChronoUnit.DAYS.between(start, end);
        int workdays = 0;
        
        for (int i = 0; i <= totalDays; i++) {
            LocalDate current = start.plusDays(i);
            if (current.getDayOfWeek() != DayOfWeek.SATURDAY && 
                current.getDayOfWeek() != DayOfWeek.SUNDAY) {
                workdays++;
            }
        }
        
        // 如果计算的是未来日期，返回正值；如果是过去日期，返回负值
        return start.equals(START_DATE) ? workdays - 1 : 
               end.equals(START_DATE) ? -(workdays - 1) : 
               start.isAfter(START_DATE) ? workdays - 1 : -(workdays - 1);
    }
    
    /**
     * 简化版本：基于周数计算（更直观）
     */
    public static String getDutyPersonSimple(LocalDate date) {
        // 非工作日判断
        if (date.getDayOfWeek() == DayOfWeek.SATURDAY || 
            date.getDayOfWeek() == DayOfWeek.SUNDAY) {
            return "非工作日，无值班安排";
        }
        
        // 计算查询日期是第几个工作日（相对于起始日期）
        long weeksBetween = ChronoUnit.WEEKS.between(
            START_DATE.with(DayOfWeek.MONDAY), 
            date.with(DayOfWeek.MONDAY)
        );
        
        // 计算完整的值班周期偏移
        int fullCyclesOffset = (int)(weeksBetween * 5) % STAFF.length;
        
        // 计算本周内是周几（周一=0，周二=1，...，周五=4）
        int dayInWeek = date.getDayOfWeek().getValue() - 1;
        
        // 计算当天值班人员索引
        int staffIndex = (fullCyclesOffset + dayInWeek) % STAFF.length;
        
        return STAFF[staffIndex];
    }
}
