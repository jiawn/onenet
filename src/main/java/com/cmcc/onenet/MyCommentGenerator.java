package com.cmcc.onenet;

import org.mybatis.generator.api.IntrospectedColumn;
import org.mybatis.generator.api.IntrospectedTable;
import org.mybatis.generator.api.dom.java.*;
import org.mybatis.generator.api.dom.xml.XmlElement;
import org.mybatis.generator.internal.DefaultCommentGenerator;

import java.util.Properties;

/**
 * 
 * @author wannengjia@gmail.com
 *
 */
public class MyCommentGenerator extends DefaultCommentGenerator {

  @Override
  public void addConfigurationProperties(Properties properties) {
    super.addConfigurationProperties(properties);
  }

  @Override
  public void addFieldComment(Field field, IntrospectedTable introspectedTable, IntrospectedColumn introspectedColumn) {
    StringBuilder sb = new StringBuilder();
    field.addJavaDocLine("/**");
    sb.append(" * ");
    sb.append(introspectedColumn.getRemarks());
    field.addJavaDocLine(sb.toString());
    field.addJavaDocLine(" */");
  }

  @Override
  public void addFieldComment(Field field, IntrospectedTable introspectedTable) {
    StringBuilder sb = new StringBuilder();
    field.addJavaDocLine("/**");
    sb.append(" * ");
    sb.append(introspectedTable.getFullyQualifiedTable());
    field.addJavaDocLine(sb.toString());
    field.addJavaDocLine(" */");
  }

  @Override
  public void addGetterComment(Method method, IntrospectedTable introspectedTable,
      IntrospectedColumn introspectedColumn) {
  }

  @Override
  public void addSetterComment(Method method, IntrospectedTable introspectedTable,
      IntrospectedColumn introspectedColumn) {
  }

  @Override
  public void addJavaFileComment(CompilationUnit compilationUnit) {
  }

  @Override
  public void addComment(XmlElement xmlElement) {
  }

  @Override
  public void addRootComment(XmlElement rootElement) {
  }

  @Override
  protected void addJavadocTag(JavaElement javaElement, boolean markAsDoNotDelete) {
  }

  @Override
  public void addClassComment(InnerClass innerClass, IntrospectedTable introspectedTable) {
  }

  @Override
  public void addEnumComment(InnerEnum innerEnum, IntrospectedTable introspectedTable) {
  }

  @Override
  public void addGeneralMethodComment(Method method, IntrospectedTable introspectedTable) {
  }

  @Override
  public void addClassComment(InnerClass innerClass, IntrospectedTable introspectedTable, boolean markAsDoNotDelete) {
  }
}
