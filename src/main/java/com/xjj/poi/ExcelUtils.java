package com.xjj.poi;

import java.awt.Color;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;

import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFColor;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFRichTextString;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class ExcelUtils {
	
	/**
	 * 根据输入的数据生成一个XSSFWorkbook
	 * @param title：sheet名称
	 * @param propertyHeaderMap：<property, header>（<T中的property名称、有getter就行, 对应显示在Excel sheet中的列标题>）
	 * 								用LinkedHashMap保证读取的顺序和put的顺序一样
	 * @param dataSet：实体类集合
	 * @return：XSSFWorkbook
	 */
	public static <T> XSSFWorkbook generateXlsxWorkbook(String title, LinkedHashMap<String, String> propertyHeaderMap, Collection<T> dataSet) {
		// 声明一个工作薄
		XSSFWorkbook workbook = new XSSFWorkbook();
		// 生成一个表格
		XSSFSheet sheet = workbook.createSheet(title);
		// 设置表格默认列宽度为15个字节
		sheet.setDefaultColumnWidth((int) 15);
		
		XSSFCellStyle headerStyle = getHeaderStyle(workbook);
		XSSFCellStyle contentStyle = getContentStyle(workbook);
		
		// 生成表格标题行
		XSSFRow row = sheet.createRow(0);
		int i = 0;
		for(String key : propertyHeaderMap.keySet()){
			XSSFCell cell = row.createCell(i);
			cell.setCellStyle(headerStyle);
			XSSFRichTextString text = new XSSFRichTextString(propertyHeaderMap.get(key));
			cell.setCellValue(text);
			i++;
		}
		
		//循环dataSet，每一条对应一行
		int index = 0;
		for(T data : dataSet){
			index ++;
			row = sheet.createRow(index);
			
			int j = 0;
			for(String property : propertyHeaderMap.keySet()){
				XSSFCell cell = row.createCell(j);
				cell.setCellStyle(contentStyle);
				
				//拼装getter方法名
				String getMethodName = "get" + property.substring(0, 1).toUpperCase() + property.substring(1);
				
				try {
					//利用反射机制获取dataSet中的属性值，填进cell中
					Class<? extends Object> tCls = data.getClass();
					Method getMethod = tCls.getMethod(getMethodName, new Class[] {});
					Object value = getMethod.invoke(data, new Object[] {}); //调用getter从data中获取数据
					
					// 判断值的类型后进行类型转换
					String textValue = null;
					if (value instanceof Date) {
						Date date = (Date) value;
						SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
						textValue = sdf.format(date);
					} else {
						// 其它数据类型都当作字符串简单处理
						textValue = value.toString();
					}

					/*if(textValue != null){
						Pattern p = Pattern.compile("^//d+(//.//d+)?$");
						Matcher matcher = p.matcher(textValue);
						if (matcher.matches()) {
							// 是数字当作double处理
							cell.setCellValue(Double.parseDouble(textValue));
						} else {
							XSSFRichTextString richString = new XSSFRichTextString(textValue);
							cell.setCellValue(richString);
						}
					}*/
					
					XSSFRichTextString richString = new XSSFRichTextString(textValue);
					cell.setCellValue(richString);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
				j++;
			}
		}
			
		return workbook;
		
	}
	
	/**
	 * 生成一个标题style
	 * @return style
	 */
	public static XSSFCellStyle getHeaderStyle(Workbook workbook){
		return getHeaderStyle(workbook, Color.BLUE, IndexedColors.WHITE.getIndex());
	}
	
	/**
	 * 生成一个指定颜色的标题style
	 * @param workbook
	 * @param foregroundColor
	 * @param fontColor
	 * @return
	 */
	public static XSSFCellStyle getHeaderStyle(Workbook workbook, Color foregroundColor, short fontColor){
		
		// 生成一个样式（用于标题）
		XSSFCellStyle style = (XSSFCellStyle) workbook.createCellStyle();
		// 设置这些样式
		style.setFillForegroundColor(new XSSFColor(foregroundColor));
		style.setFillPattern(XSSFCellStyle.SOLID_FOREGROUND);
		style.setBorderBottom(XSSFCellStyle.BORDER_THIN);
		style.setBorderLeft(XSSFCellStyle.BORDER_THIN);
		style.setBorderRight(XSSFCellStyle.BORDER_THIN);
		style.setBorderTop(XSSFCellStyle.BORDER_THIN);
		style.setAlignment(XSSFCellStyle.ALIGN_CENTER);
		// 生成一个字体
		XSSFFont font = (XSSFFont) workbook.createFont();
		font.setColor(fontColor);
		font.setFontHeightInPoints((short) 12);
		font.setBoldweight(XSSFFont.BOLDWEIGHT_BOLD);
		// 把字体应用到当前的样式
		style.setFont(font);
		
		return style;
	}
	
	/**
	 * 生成一个用于内容的style
	 * @param workbook
	 * @return
	 */
	public static XSSFCellStyle getContentStyle(Workbook workbook){
		// 生成并设置另一个样式（用于内容）
		XSSFCellStyle style = (XSSFCellStyle) workbook.createCellStyle();
		//style.setFillForegroundColor(new XSSFColor(Color.YELLOW));
		//style.setFillPattern(XSSFCellStyle.SOLID_FOREGROUND);
		style.setBorderBottom(XSSFCellStyle.BORDER_THIN);
		style.setBorderLeft(XSSFCellStyle.BORDER_THIN);
		style.setBorderRight(XSSFCellStyle.BORDER_THIN);
		style.setBorderTop(XSSFCellStyle.BORDER_THIN);
		style.setAlignment(XSSFCellStyle.ALIGN_CENTER);
		style.setVerticalAlignment(XSSFCellStyle.VERTICAL_CENTER);
		// 生成另一个字体
		XSSFFont font = (XSSFFont) workbook.createFont();
		font.setBoldweight(XSSFFont.BOLDWEIGHT_NORMAL);
		// 把字体应用到当前的样式
		style.setFont(font);
				
		return style;
	}
	
	//测试：
	public static void main(String[] args) {
		List<Student> dataSet = new ArrayList<Student>();
		dataSet.add(new Student(10000001, "张三", 20, true, new Date()));
		dataSet.add(new Student(20000002, "李丽", 24, false, new Date()));
		dataSet.add(new Student(30000003, "王五", 22, true, new Date()));
		
		LinkedHashMap<String, String> propertyHeaderMap = new LinkedHashMap<>();
		//propertyHeaderMap.put("id", "唯一标识"); //注释掉，不导出id
		propertyHeaderMap.put("name", "姓名");
		propertyHeaderMap.put("age", "年龄");
		propertyHeaderMap.put("sexName", "性别"); //直接获取Student中的sexName，而不是sex
		propertyHeaderMap.put("birthday", "生日");
		
		try {
			XSSFWorkbook ex = ExcelUtils.generateXlsxWorkbook("测试tab", propertyHeaderMap, dataSet);
			OutputStream out = new FileOutputStream("F://student3.xlsx");
			ex.write(out);
			System.out.println("导出成功！");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
