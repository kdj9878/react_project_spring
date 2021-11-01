package web.base.mybatis.convert;

import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.reflection.MetaObject;
import org.apache.ibatis.reflection.wrapper.ObjectWrapper;
import org.apache.ibatis.reflection.wrapper.ObjectWrapperFactory;


/**
 * Mybatis로 실행한 쿼리 결과를 가로채 컬럼명을 CamelCase로 Wrapping한다. 
 * resultType이 HashMap인 경우에만 가능.
 * 
 * 일반 VO의 경우, mybatis-config.xml에서
 * 	<setting name="mapUnderscoreToCamelCase" value="true" />
 * 해당옵션을 주면 된다.
 */
public class CamelMapObjectWrapperFactory implements ObjectWrapperFactory {
	
	@Override
	public boolean hasWrapperFor(Object object) {
		if (object instanceof HashMap) {
			return true;
		} 
		return false;
	}

	@SuppressWarnings("unchecked")
	@Override
	public ObjectWrapper getWrapperFor(MetaObject metaObject, Object object) {
		return new CamelKeyMapWrapper(metaObject, (Map<String, Object>)object);
	}
	
}
