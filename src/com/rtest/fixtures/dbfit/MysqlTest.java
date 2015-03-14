package com.rtest.fixtures.dbfit;


import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.lang.reflect.Method;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

import static com.rtest.util.ListUtility.list;

import com.sun.net.httpserver.Authenticator;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class MysqlTest {
    static Logger logger = Logger.getLogger(MysqlTest.class);
    static {
        PropertyConfigurator.configure("/etc/fitnis/log4j.properties");
//        logger.debug("Start of the main() in TestLog4j");
//        logger.info("Just testing a log message with priority set to INFO");
//        logger.warn("Just testing a log message with priority set to WARN");
//        logger.error("Just testing a log message with priority set to ERROR");
//        logger.fatal("Just testing a log message with priority set to FATAL");
    }

    private static HashMap<String, Method> commands = new HashMap<String, Method>();
    private String query_sql;

    static Connection conn = null;
    Statement stmt = null;
    ResultSet rs = null;

    private String table_name;
    Map cols_map;
    List<String> t_cols;

    public MysqlTest() {
    }
	public MysqlTest(String sql) {
		query_sql = sql;
	}

    public List doTable(List<List<String>> table) {

        List ret = list();
        for (List list : table) {
            row(list, ret);
            ret.add(list);
        }

        return ret;
    }

    @SuppressWarnings("ConstantConditions")
    private void row(List<String> row, List ret) {
        String cmdText = row.get(0);
        Method command = (Method) commands.get(cmdText);
        try {
            if (command == null)
                System.out.println(cmdText);
            command.invoke(this, row);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        System.out.println("");
    }


    public void connect(String dataSource, String username, String password, String database) throws SQLException {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost/db_uc?user=root&password=123456");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void connect(String dataSource, String username, String password) throws SQLException {
//        this.environment.connect(dataSource, username, password);
//        this.environment.getConnection().setAutoCommit(false);
    }

    public void connect(String connectionString) throws SQLException {
//        this.environment.connect(connectionString);
//        this.environment.getConnection().setAutoCommit(false);
    }

    public void connectUsingFile(String filePath) throws SQLException, IOException, FileNotFoundException {
//        this.environment.connectUsingFile(filePath);
//        this.environment.getConnection().setAutoCommit(false);
    }

    public void close() throws SQLException {
//        this.environment.rollback();
//        this.environment.closeConnection();
    }

    public void setParameter(String name, String value) {
        //SetParameter.setParameter(name, value);
    }

    public void clearParameters() {
//        SymbolUtil.clearSymbols();
    }

	public void table(List<List<String>> table) {
		for(List l : table){
			for(Object o : l){
//				System.out.println(o);
			}
		}
	}

	@SuppressWarnings("ConstantConditions")
    public List<Object> query() {

		ResultSet rs = null;
		try {
			if (conn == null || conn.isClosed()) {
				System.out.println("conn is null or closed");
			} else {
				stmt = conn.createStatement();
				rs = stmt.executeQuery(query_sql);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		List result = list();
		try {
			ResultSetMetaData rsmd = rs.getMetaData();
			int column_count = rsmd.getColumnCount();
			while (rs.next()){
				List row = list();
				for(int i=1; i<=column_count; i++){
					row.add( list( rsmd.getColumnName(i),rs.getString(i) ) );
				}
				result.add(row);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return result;
	}

    public void cmd_connect(List<String> row) {
        if (row.size() > 5) {
            String host = row.get(1);
            String port = row.get(2);
            String db = row.get(3);
            String user = row.get(4);
            String pass = row.get(5);
            String connstr = "jdbc:mysql://" + host + ":" + port + "/" + db + "?user=" + user + "&password=" + pass;
            try {
                Class.forName("com.mysql.jdbc.Driver");
                if(conn==null || conn.isClosed() || !conn.getCatalog().equals(db)){
                    logger.debug("old conn: "+ (conn==null?null:conn.getCatalog()) );
                    logger.debug("connect use: "+connstr);
                    conn = DriverManager.getConnection(connstr);
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
            pass(row, 3);
        } else {
            fail(row, "param required for : |host|port|db|user|pass|");
        }
    }

    public void cmd_execute(List<String> row) {
        try {
            if (conn == null || conn.isClosed()) {
                System.out.println("conn is null or closed");
            } else {
                stmt = conn.createStatement();
                stmt.execute(row.get(1));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        pass(row, 3);
    }

    public void cmd_insert(List<String> row) {
        //todo:
        table_name = row.get(1);

        t_cols = new ArrayList<String>();
        for(int i=2; i<row.size(); i++){
            t_cols.add(row.get(i));
        }
//        t_cols = row.subList(2,row.size());

        ResultSet rs = null;
        try {
            stmt = conn.createStatement();
            rs = stmt.executeQuery("select "+join_cols(t_cols)+" from "+table_name);
            ResultSetMetaData md = rs.getMetaData();

            cols_map = new HashMap();
            for(int i=0; i<t_cols.size(); i++){
                String col_name = t_cols.get(i);
                String col_type_name = md.getColumnTypeName(i+1);

                logger.debug("put [col_name: " + col_name+" col_type_name: "+col_type_name+"]");

                if( col_type_name.equals("VARCHAR")
                    ||col_type_name.equals("CHAR")
                        ||col_type_name.equals("DATETIME")
                        ||col_type_name.equals("DATE")
                        ){
                    cols_map.put(col_name, true);
                }
                else{
                    cols_map.put(col_name, false);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        no_check(row);
    }

    public void cmd_exec_insert(List<String> row) {
        //todo:
        String sql =  gen_insert_sql(row.subList(2, row.size()));

        execute_sql(sql);

        no_check(row);
    }

    public String gen_insert_sql(List<String> row){

        String sql = "insert into "+ table_name + " (";
        sql += join_cols(t_cols)+") values (";
        sql += join_vals(row)+")";

        return sql;
    }

    private String join_cols(List<String> list) {
        String ret = "";
        for(String col : list){
            ret += "`"+col+"`,";
        }
        ret = ret.substring(0,ret.length()-1);
        return  ret;
    }

    private String join_vals(List<String> list) {
        String ret = "";
        for(String col_name : t_cols){
            String col_val = list.get(t_cols.indexOf(col_name));
            String add_item = col_val+",";

            logger.debug("col_name: " + col_name +" col_val: "+col_val );
            if (col_val.equals("$nowint")) {
                long now_int = System.currentTimeMillis()/1000;
                ret += now_int+",";
            } else {
                Boolean isstr = (Boolean) cols_map.get(col_name);

                if (isstr) {
                    add_item = "'" + col_val + "',";
                }
                ret += add_item;
            }
        }
        ret = ret.substring(0,ret.length()-1);
        return ret;
    }

    public void execute_sql(String sql) {
        try {
            if (conn == null || conn.isClosed()) {
                System.out.println("conn is null or closed");
            } else {
                stmt = conn.createStatement();

                logger.info("insert_sql: "+sql);

                stmt.execute(sql);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            logger.debug(e);
        }
    }
    public void cmd_select_one(List<String> row) {
        try {
            if (conn == null || conn.isClosed()) {
                System.out.println("conn is null or closed");
            } else {
                stmt = conn.createStatement();
                rs = stmt.executeQuery(row.get(1));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        pass(row, 3);
    }

    public List orderedQuery(String query) {
        return list();
    }

    public List execute(String statement) {
        return list();
    }

    public List executeProcedure(String statement) {
        return list();
    }

    public List executeProcedureExpectException(String statement) {
        return list();
    }

    public List executeProcedureExpectException(String statement, int code) {
        return list();
    }

    public List insert(String tableName) {
        return list();
    }

    public List update(String tableName) {
        return list();
    }

    public List clean() {
        return list();
    }

    public void rollback() throws SQLException {
//        this.environment.rollback();
//        this.environment.getConnection().setAutoCommit(false);
    }

    public void commit() throws SQLException {
//        this.environment.commit();
//        this.environment.getConnection().setAutoCommit(false);
    }

    public List queryStats() {
        return list();
    }

    public List inspectProcedure(String procName) {
        return list();
    }

    public List inspectTable(String tableName) {
        return list();
    }

    public List inspectView(String tableName) {
        return list();
    }

    public List inspectQuery(String query) {
        return list();
    }

    public List storeQuery(String query, String symbolName) {
        return list();
    }

    public List compareStoredQueries(String symbol1, String symbol2) {
        return list();
    }

    public void setOption(String option, String value) {
        //Options.setOption(option, value);
    }

    public String getQuery_sql() {
        return query_sql;
    }

    public void setQuery_sql(String query_sql) {
        this.query_sql = query_sql;
    }

    private void appendRow(List<String> row, int n) {
        if (row.size() < n)
            row.add(n - 1, "None");
    }

    private void appendRow(List<String> row) {
        row.add(row.size(), "None");
    }

    private void fail(List<String> list, String msg) {
        fail(list, list.size(), msg);
    }

    private void fail(List<String> list, int n, String msg) {
        for (int i = 0; i < list.size(); i++) {
            String pass = "";
            if (i == n - 1) pass = "fail:" + msg;
            list.set(i, pass);
        }
    }

    private void pass(List<String> list) {
        pass(list, list.size(), "", 0);
    }

    private void pass(List<String> list, int n) {
        pass(list, n, "", 0);
    }

    private void pass(List<String> list, int n, String msg, int j) {
        for (int i = 0; i < list.size(); i++) {
            if (i == n - 1) {
                list.set(i, "pass");
            } else if (j != 0 && i == j - 1) {
                list.set(i, "pass:" + msg + "");
            } else list.set(i, "");
        }
    }

    private void no_check(List<String> list){
        for (int i = 0; i < list.size(); i++) {
            list.set(i, "");
        }
    }

    private void ignore(List<String> list, String msg){
        list.set(0, "");
        list.set(1, "ignore:" + msg);
    }

    static {
        Class<MysqlTest> myClass = MysqlTest.class;
        //Class<Parse> args = Parse.class;
        Class<List> args = List.class;
        try {
            commands.put("Execute", myClass.getDeclaredMethod("cmd_execute", args));
            commands.put("Connect", myClass.getDeclaredMethod("cmd_connect", args));
            commands.put("Insert", myClass.getDeclaredMethod("cmd_insert", args));
            commands.put("Exec", myClass.getDeclaredMethod("cmd_exec_insert", args));
        } catch (Exception e) {
            System.out.println("Exception in startup. " + e.toString());
        }
    }
}
