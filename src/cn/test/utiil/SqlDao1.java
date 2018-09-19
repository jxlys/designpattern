package cn.test.utiil;

/**
 * 一个用来拼接sql字符串的类
 * 
 * @author Administrator
 *
 */
public final class SqlDao1 {

	private String selectString = "";
	private String updateString = "";
	private String tableString = "";
	private String whereString = "";
	private String limitString = "";
	private String deleteString = "";
	private String insertString = "";
	private String dataString = "";
	private String groupByString = "";
	private String orderByString = "";

	public SqlDao1() {
	}

	private boolean noEmpty(String srcStr) {
		return srcStr != null && srcStr.length() > 0 ? true : false;
	}

	private String removeLast(String srcString) {
		return srcString.substring(0, srcString.length() - 1);
	}

	public SqlDao1 u(String appendString) {
		updateString += appendString + ",";
		return this;
	}

	public SqlDao1 ue(String easyName, String columnName, Object value) {
		u(easyName + "." + columnName + "='" + value.toString() + "'");
		return this;
	}

	public SqlDao1 r(String... columnName) {
		for (String string : columnName) {
			selectString += string + ",";
		}
		return this;
	}

	/**
	 * 优化追加 ,拼接这三个成一个查询字段，别名="别名+字段名";
	 * 
	 * @param easyName
	 * @param columnName
	 * @return
	 */
	public SqlDao1 re(String easyName, String... columnName) {
		if (noEmpty(easyName)) {
			for (String string : columnName) {
				if (!"*".equals(string)) {
					selectString += easyName + "." + string + " AS '" + easyName + string + "',";
				} else {
					selectString += easyName + "." + string + ",";
				}
			}
		}
		return this;
	}

	/**
	 * 添加条件
	 * 
	 * @param easyName
	 * @param columnName
	 * @param value
	 * @return
	 */

	public SqlDao1 whe(String easyName, String columnName, Object value) {
		if (isBaseType(value)) {
			wh(easyName + "." + columnName + "=" + value.toString() + "");
		} else {
			wh(easyName + "." + columnName + "='" + value.toString() + "'");
		}

		return this;
	}

	/**
	 * 追加条件
	 * 
	 * @param appendString
	 * @return
	 */
	public SqlDao1 wh(String... appendString) {
		if (!noEmpty(whereString)) {
			whereString += " WHERE  0=0 ";
		}
		for (String tempStr : appendString) {
			whereString += " AND " + tempStr;
		}
		return this;
	}

	/**
	 * 添加表，和表名
	 * 
	 * @param tableName
	 * @param easyName
	 * @return
	 */
	public SqlDao1 tb(String tableName, String easyName) {
		if (!noEmpty(tableName) || !noEmpty(easyName)) {
			throw new RuntimeException("必须要表名和别名");
		}
		tb(tableName + " AS " + easyName);
		return this;
	}

	/**
	 * 添加表
	 * 
	 * @param tableName
	 * @return
	 */
	public SqlDao1 tb(String tableName) {
		if (!noEmpty(tableName)) {
			throw new RuntimeException("必须要表名");
		}
		tableString += tableName + ",";
		return this;
	}

	/**
	 * 对象和别名
	 * 
	 * @param tables
	 * @return
	 */
	public SqlDao1 tb(String tableName, String easyName, String... tables) {
		if (tables.length % 2 == 0) {
			tb(tableName, easyName);
			for (int i = 0; i < tables.length; i += 2) {
				tb(tables[i], tables[i + 1]);
			}
		} else {
			throw new RuntimeException("表不对应别名");
		}
		return this;
	}

	/**
	 * 分页
	 * 
	 * @param limit1
	 * @param limit2
	 * @return
	 */
	public SqlDao1 lm(String limit1, String limit2) {
		limitString = " LIMIT " + limit1 + "," + limit2;
		return this;
	}

	/**
	 * 排序方式
	 * 
	 * @param column
	 * @return
	 */
	public SqlDao1 od(String column, boolean desc) {
		orderByString = " ORDER BY " + column + ((desc) ? " DESC" : "");
		return this;
	}

	/**
	 * 删除，删除不支持别名
	 * 
	 * @return
	 */
	public SqlDao1 d() {
		deleteString = " FROM ";
		return this;
	}

	/**
	 * 插入字段
	 * 
	 * @param columnName
	 * @return
	 */
	public SqlDao1 c(String... columnName) {
		for (String string : columnName) {
			insertString += string + ",";
		}
		return this;
	}

	/**
	 * 插入值
	 * 
	 * @param columnName
	 * @return
	 */
	public SqlDao1 cva(Object... columnName) {
		for (Object string : columnName) {
			if (isBaseType(string)) {
				dataString += string + ",";
			} else
				dataString += "'" + string + "',";
		}
		return this;
	}

	private boolean isBaseType(Object srcObj) {
		return srcObj instanceof Byte || srcObj instanceof Character || srcObj instanceof Integer || srcObj instanceof Long || srcObj instanceof Float || srcObj instanceof Double ? true : false;

	}

	/**
	 * 设置分组
	 * 
	 * @param column
	 * @return
	 */
	public SqlDao1 gb(String column) {
		groupByString = " GROUP BY " + column + " ";
		return this;
	}

	public String toString() {
		if (noEmpty(selectString)) {
			return "SELECT " + removeLast(selectString) + " FROM " + removeLast(tableString) + whereString + groupByString + orderByString + limitString;
		} else if (noEmpty(updateString)) {
			return "UPDATE " + removeLast(tableString) + " SET " + removeLast(updateString) + whereString;
		} else if (noEmpty(deleteString)) {
			return "DELETE" + deleteString + removeLast(tableString) + whereString;
		} else if (noEmpty(insertString)) {
			return "INSERT INTO " + tableString.split(",")[0] + "(" + removeLast(insertString) + ") VALUES(" + removeLast(dataString) + ")";
		} else
			throw new RuntimeException("不支持的查询");
	}

	public static void main(String[] args) {
		String sql = SqlEntity.getInstance().etb("tuser", "a").er("a", "username").ewh("a", "userid", "123456").toString();
		System.out.println(sql);

	}
}