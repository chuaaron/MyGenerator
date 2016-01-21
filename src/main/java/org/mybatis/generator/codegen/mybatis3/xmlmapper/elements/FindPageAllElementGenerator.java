package org.mybatis.generator.codegen.mybatis3.xmlmapper.elements;

import static org.mybatis.generator.internal.util.StringUtility.stringHasValue;

import org.mybatis.generator.api.IntrospectedColumn;
import org.mybatis.generator.api.dom.xml.Attribute;
import org.mybatis.generator.api.dom.xml.TextElement;
import org.mybatis.generator.api.dom.xml.XmlElement;
import org.mybatis.generator.codegen.mybatis3.MyBatis3FormattingUtilities;

public class FindPageAllElementGenerator extends AbstractXmlElementGenerator {

	public FindPageAllElementGenerator() {
		super();
	}

	@Override
	public void addElements(XmlElement parentElement) {
		// <select id="findPageAll" parameterType="map"
		// resultMap="sIScatDetailMap">
		XmlElement answer = new XmlElement("select");
		answer.addAttribute(new Attribute("id", "findPageAll"));
		answer.addAttribute(new Attribute("parameterType", "map"));
		answer.addAttribute(new Attribute("resultMap", introspectedTable.getBaseResultMapId()));
		// select <include refid="Base_Column_List"/> from AF72
		StringBuilder sb = new StringBuilder();
		sb.append("selet * from (select a.*,rownum as rn from (<include refid=\""
				+ introspectedTable.getBaseQueryCondsId() + "\"/> order by "
				+ introspectedTable.getPrimaryKeyColumns().get(0).getActualColumnName() + ")a "
				+ "where rownum &lt;= #{limit})A where A.rn &gt;= #{start}");
//		sb.append("select * from (<include refid=\"" + introspectedTable.getBaseQueryCondsId()
//				+ "\"/>)");
		answer.addElement(new TextElement(sb.toString()));
		// XmlElement dynamicElement = new XmlElement("where");
		// answer.addElement(dynamicElement);
		// for (IntrospectedColumn introspectedColumn :
		// introspectedTable.getNonPrimaryKeyColumns()) {
		// XmlElement isNotNullElement = new XmlElement("if");
		// sb.setLength(0);
		// sb.append(introspectedColumn.getJavaProperty());
		//			sb.append(" != null and "); //$NON-NLS-1$
		// sb.append(introspectedColumn.getJavaProperty());
		// sb.append(" != \"\"");
		//			isNotNullElement.addAttribute(new Attribute("test", sb.toString())); //$NON-NLS-1$
		// dynamicElement.addElement(isNotNullElement);
		//
		// sb.setLength(0);
		// sb.append(MyBatis3FormattingUtilities.getEscapedColumnName(introspectedColumn));
		//			sb.append(" = "); //$NON-NLS-1$
		// sb.append(MyBatis3FormattingUtilities.getParameterClause(introspectedColumn));
		// sb.append(',');
		//
		// isNotNullElement.addElement(new TextElement(sb.toString()));
		// }
		parentElement.addElement(answer);
	}
}
