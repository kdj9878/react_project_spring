package web.base.mybatis.convert;

import java.util.Map;

import org.apache.ibatis.reflection.MetaObject;
import org.apache.ibatis.reflection.wrapper.MapWrapper;
import web.base.util.StringUtil;

/**
 * Mybatis로 실행한 쿼리 결과를 가로채 컬럼명을 CamelCase로 Wrapping한다. 
 * resultType이 HashMap인 경우에만 가능.
 * 
 * 일반 VO의 경우, mybatis-config.xml에서
 * <setting name="mapUnderscoreToCamelCase" value="true" />
 * 해당옵션을 주면 된다.
 */
public class CamelKeyMapWrapper extends MapWrapper {
	
	public CamelKeyMapWrapper(MetaObject metaObject, Map<String, Object> map) {
		super(metaObject, map);
	}
	
	@Override
	public String findProperty(String name, boolean useCamelCaseMapping) {
		return StringUtil.camelLower(name);
	}
	
}
