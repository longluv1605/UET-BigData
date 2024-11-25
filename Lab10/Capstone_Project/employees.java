// ORM class for table 'employees'
// WARNING: This class is AUTO-GENERATED. Modify at your own risk.
//
// Debug information:
// Generated date: Mon Nov 25 20:44:21 ICT 2024
// For connector: org.apache.sqoop.manager.MySQLManager
import org.apache.hadoop.io.BytesWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.io.Writable;
import org.apache.hadoop.mapred.lib.db.DBWritable;
import com.cloudera.sqoop.lib.JdbcWritableBridge;
import com.cloudera.sqoop.lib.DelimiterSet;
import com.cloudera.sqoop.lib.FieldFormatter;
import com.cloudera.sqoop.lib.RecordParser;
import com.cloudera.sqoop.lib.BooleanParser;
import com.cloudera.sqoop.lib.BlobRef;
import com.cloudera.sqoop.lib.ClobRef;
import com.cloudera.sqoop.lib.LargeObjectLoader;
import com.cloudera.sqoop.lib.SqoopRecord;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

public class employees extends SqoopRecord  implements DBWritable, Writable {
  private final int PROTOCOL_VERSION = 3;
  public int getClassFormatVersion() { return PROTOCOL_VERSION; }
  public static interface FieldSetterCommand {    void setField(Object value);  }  protected ResultSet __cur_result_set;
  private Map<String, FieldSetterCommand> setters = new HashMap<String, FieldSetterCommand>();
  private void init0() {
    setters.put("emp_no", new FieldSetterCommand() {
      @Override
      public void setField(Object value) {
        employees.this.emp_no = (Integer)value;
      }
    });
    setters.put("emp_title_id", new FieldSetterCommand() {
      @Override
      public void setField(Object value) {
        employees.this.emp_title_id = (String)value;
      }
    });
    setters.put("birth_date", new FieldSetterCommand() {
      @Override
      public void setField(Object value) {
        employees.this.birth_date = (String)value;
      }
    });
    setters.put("first_name", new FieldSetterCommand() {
      @Override
      public void setField(Object value) {
        employees.this.first_name = (String)value;
      }
    });
    setters.put("last_name", new FieldSetterCommand() {
      @Override
      public void setField(Object value) {
        employees.this.last_name = (String)value;
      }
    });
    setters.put("sex", new FieldSetterCommand() {
      @Override
      public void setField(Object value) {
        employees.this.sex = (String)value;
      }
    });
    setters.put("hire_date", new FieldSetterCommand() {
      @Override
      public void setField(Object value) {
        employees.this.hire_date = (String)value;
      }
    });
    setters.put("no_of_projects", new FieldSetterCommand() {
      @Override
      public void setField(Object value) {
        employees.this.no_of_projects = (Integer)value;
      }
    });
    setters.put("last_performance_rating", new FieldSetterCommand() {
      @Override
      public void setField(Object value) {
        employees.this.last_performance_rating = (String)value;
      }
    });
    setters.put("left2", new FieldSetterCommand() {
      @Override
      public void setField(Object value) {
        employees.this.left2 = (Integer)value;
      }
    });
    setters.put("last_date", new FieldSetterCommand() {
      @Override
      public void setField(Object value) {
        employees.this.last_date = (String)value;
      }
    });
  }
  public employees() {
    init0();
  }
  private Integer emp_no;
  public Integer get_emp_no() {
    return emp_no;
  }
  public void set_emp_no(Integer emp_no) {
    this.emp_no = emp_no;
  }
  public employees with_emp_no(Integer emp_no) {
    this.emp_no = emp_no;
    return this;
  }
  private String emp_title_id;
  public String get_emp_title_id() {
    return emp_title_id;
  }
  public void set_emp_title_id(String emp_title_id) {
    this.emp_title_id = emp_title_id;
  }
  public employees with_emp_title_id(String emp_title_id) {
    this.emp_title_id = emp_title_id;
    return this;
  }
  private String birth_date;
  public String get_birth_date() {
    return birth_date;
  }
  public void set_birth_date(String birth_date) {
    this.birth_date = birth_date;
  }
  public employees with_birth_date(String birth_date) {
    this.birth_date = birth_date;
    return this;
  }
  private String first_name;
  public String get_first_name() {
    return first_name;
  }
  public void set_first_name(String first_name) {
    this.first_name = first_name;
  }
  public employees with_first_name(String first_name) {
    this.first_name = first_name;
    return this;
  }
  private String last_name;
  public String get_last_name() {
    return last_name;
  }
  public void set_last_name(String last_name) {
    this.last_name = last_name;
  }
  public employees with_last_name(String last_name) {
    this.last_name = last_name;
    return this;
  }
  private String sex;
  public String get_sex() {
    return sex;
  }
  public void set_sex(String sex) {
    this.sex = sex;
  }
  public employees with_sex(String sex) {
    this.sex = sex;
    return this;
  }
  private String hire_date;
  public String get_hire_date() {
    return hire_date;
  }
  public void set_hire_date(String hire_date) {
    this.hire_date = hire_date;
  }
  public employees with_hire_date(String hire_date) {
    this.hire_date = hire_date;
    return this;
  }
  private Integer no_of_projects;
  public Integer get_no_of_projects() {
    return no_of_projects;
  }
  public void set_no_of_projects(Integer no_of_projects) {
    this.no_of_projects = no_of_projects;
  }
  public employees with_no_of_projects(Integer no_of_projects) {
    this.no_of_projects = no_of_projects;
    return this;
  }
  private String last_performance_rating;
  public String get_last_performance_rating() {
    return last_performance_rating;
  }
  public void set_last_performance_rating(String last_performance_rating) {
    this.last_performance_rating = last_performance_rating;
  }
  public employees with_last_performance_rating(String last_performance_rating) {
    this.last_performance_rating = last_performance_rating;
    return this;
  }
  private Integer left2;
  public Integer get_left2() {
    return left2;
  }
  public void set_left2(Integer left2) {
    this.left2 = left2;
  }
  public employees with_left2(Integer left2) {
    this.left2 = left2;
    return this;
  }
  private String last_date;
  public String get_last_date() {
    return last_date;
  }
  public void set_last_date(String last_date) {
    this.last_date = last_date;
  }
  public employees with_last_date(String last_date) {
    this.last_date = last_date;
    return this;
  }
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof employees)) {
      return false;
    }
    employees that = (employees) o;
    boolean equal = true;
    equal = equal && (this.emp_no == null ? that.emp_no == null : this.emp_no.equals(that.emp_no));
    equal = equal && (this.emp_title_id == null ? that.emp_title_id == null : this.emp_title_id.equals(that.emp_title_id));
    equal = equal && (this.birth_date == null ? that.birth_date == null : this.birth_date.equals(that.birth_date));
    equal = equal && (this.first_name == null ? that.first_name == null : this.first_name.equals(that.first_name));
    equal = equal && (this.last_name == null ? that.last_name == null : this.last_name.equals(that.last_name));
    equal = equal && (this.sex == null ? that.sex == null : this.sex.equals(that.sex));
    equal = equal && (this.hire_date == null ? that.hire_date == null : this.hire_date.equals(that.hire_date));
    equal = equal && (this.no_of_projects == null ? that.no_of_projects == null : this.no_of_projects.equals(that.no_of_projects));
    equal = equal && (this.last_performance_rating == null ? that.last_performance_rating == null : this.last_performance_rating.equals(that.last_performance_rating));
    equal = equal && (this.left2 == null ? that.left2 == null : this.left2.equals(that.left2));
    equal = equal && (this.last_date == null ? that.last_date == null : this.last_date.equals(that.last_date));
    return equal;
  }
  public boolean equals0(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof employees)) {
      return false;
    }
    employees that = (employees) o;
    boolean equal = true;
    equal = equal && (this.emp_no == null ? that.emp_no == null : this.emp_no.equals(that.emp_no));
    equal = equal && (this.emp_title_id == null ? that.emp_title_id == null : this.emp_title_id.equals(that.emp_title_id));
    equal = equal && (this.birth_date == null ? that.birth_date == null : this.birth_date.equals(that.birth_date));
    equal = equal && (this.first_name == null ? that.first_name == null : this.first_name.equals(that.first_name));
    equal = equal && (this.last_name == null ? that.last_name == null : this.last_name.equals(that.last_name));
    equal = equal && (this.sex == null ? that.sex == null : this.sex.equals(that.sex));
    equal = equal && (this.hire_date == null ? that.hire_date == null : this.hire_date.equals(that.hire_date));
    equal = equal && (this.no_of_projects == null ? that.no_of_projects == null : this.no_of_projects.equals(that.no_of_projects));
    equal = equal && (this.last_performance_rating == null ? that.last_performance_rating == null : this.last_performance_rating.equals(that.last_performance_rating));
    equal = equal && (this.left2 == null ? that.left2 == null : this.left2.equals(that.left2));
    equal = equal && (this.last_date == null ? that.last_date == null : this.last_date.equals(that.last_date));
    return equal;
  }
  public void readFields(ResultSet __dbResults) throws SQLException {
    this.__cur_result_set = __dbResults;
    this.emp_no = JdbcWritableBridge.readInteger(1, __dbResults);
    this.emp_title_id = JdbcWritableBridge.readString(2, __dbResults);
    this.birth_date = JdbcWritableBridge.readString(3, __dbResults);
    this.first_name = JdbcWritableBridge.readString(4, __dbResults);
    this.last_name = JdbcWritableBridge.readString(5, __dbResults);
    this.sex = JdbcWritableBridge.readString(6, __dbResults);
    this.hire_date = JdbcWritableBridge.readString(7, __dbResults);
    this.no_of_projects = JdbcWritableBridge.readInteger(8, __dbResults);
    this.last_performance_rating = JdbcWritableBridge.readString(9, __dbResults);
    this.left2 = JdbcWritableBridge.readInteger(10, __dbResults);
    this.last_date = JdbcWritableBridge.readString(11, __dbResults);
  }
  public void readFields0(ResultSet __dbResults) throws SQLException {
    this.emp_no = JdbcWritableBridge.readInteger(1, __dbResults);
    this.emp_title_id = JdbcWritableBridge.readString(2, __dbResults);
    this.birth_date = JdbcWritableBridge.readString(3, __dbResults);
    this.first_name = JdbcWritableBridge.readString(4, __dbResults);
    this.last_name = JdbcWritableBridge.readString(5, __dbResults);
    this.sex = JdbcWritableBridge.readString(6, __dbResults);
    this.hire_date = JdbcWritableBridge.readString(7, __dbResults);
    this.no_of_projects = JdbcWritableBridge.readInteger(8, __dbResults);
    this.last_performance_rating = JdbcWritableBridge.readString(9, __dbResults);
    this.left2 = JdbcWritableBridge.readInteger(10, __dbResults);
    this.last_date = JdbcWritableBridge.readString(11, __dbResults);
  }
  public void loadLargeObjects(LargeObjectLoader __loader)
      throws SQLException, IOException, InterruptedException {
  }
  public void loadLargeObjects0(LargeObjectLoader __loader)
      throws SQLException, IOException, InterruptedException {
  }
  public void write(PreparedStatement __dbStmt) throws SQLException {
    write(__dbStmt, 0);
  }

  public int write(PreparedStatement __dbStmt, int __off) throws SQLException {
    JdbcWritableBridge.writeInteger(emp_no, 1 + __off, 4, __dbStmt);
    JdbcWritableBridge.writeString(emp_title_id, 2 + __off, 12, __dbStmt);
    JdbcWritableBridge.writeString(birth_date, 3 + __off, 12, __dbStmt);
    JdbcWritableBridge.writeString(first_name, 4 + __off, 12, __dbStmt);
    JdbcWritableBridge.writeString(last_name, 5 + __off, 12, __dbStmt);
    JdbcWritableBridge.writeString(sex, 6 + __off, 1, __dbStmt);
    JdbcWritableBridge.writeString(hire_date, 7 + __off, 12, __dbStmt);
    JdbcWritableBridge.writeInteger(no_of_projects, 8 + __off, 4, __dbStmt);
    JdbcWritableBridge.writeString(last_performance_rating, 9 + __off, 12, __dbStmt);
    JdbcWritableBridge.writeInteger(left2, 10 + __off, -6, __dbStmt);
    JdbcWritableBridge.writeString(last_date, 11 + __off, 12, __dbStmt);
    return 11;
  }
  public void write0(PreparedStatement __dbStmt, int __off) throws SQLException {
    JdbcWritableBridge.writeInteger(emp_no, 1 + __off, 4, __dbStmt);
    JdbcWritableBridge.writeString(emp_title_id, 2 + __off, 12, __dbStmt);
    JdbcWritableBridge.writeString(birth_date, 3 + __off, 12, __dbStmt);
    JdbcWritableBridge.writeString(first_name, 4 + __off, 12, __dbStmt);
    JdbcWritableBridge.writeString(last_name, 5 + __off, 12, __dbStmt);
    JdbcWritableBridge.writeString(sex, 6 + __off, 1, __dbStmt);
    JdbcWritableBridge.writeString(hire_date, 7 + __off, 12, __dbStmt);
    JdbcWritableBridge.writeInteger(no_of_projects, 8 + __off, 4, __dbStmt);
    JdbcWritableBridge.writeString(last_performance_rating, 9 + __off, 12, __dbStmt);
    JdbcWritableBridge.writeInteger(left2, 10 + __off, -6, __dbStmt);
    JdbcWritableBridge.writeString(last_date, 11 + __off, 12, __dbStmt);
  }
  public void readFields(DataInput __dataIn) throws IOException {
this.readFields0(__dataIn);  }
  public void readFields0(DataInput __dataIn) throws IOException {
    if (__dataIn.readBoolean()) { 
        this.emp_no = null;
    } else {
    this.emp_no = Integer.valueOf(__dataIn.readInt());
    }
    if (__dataIn.readBoolean()) { 
        this.emp_title_id = null;
    } else {
    this.emp_title_id = Text.readString(__dataIn);
    }
    if (__dataIn.readBoolean()) { 
        this.birth_date = null;
    } else {
    this.birth_date = Text.readString(__dataIn);
    }
    if (__dataIn.readBoolean()) { 
        this.first_name = null;
    } else {
    this.first_name = Text.readString(__dataIn);
    }
    if (__dataIn.readBoolean()) { 
        this.last_name = null;
    } else {
    this.last_name = Text.readString(__dataIn);
    }
    if (__dataIn.readBoolean()) { 
        this.sex = null;
    } else {
    this.sex = Text.readString(__dataIn);
    }
    if (__dataIn.readBoolean()) { 
        this.hire_date = null;
    } else {
    this.hire_date = Text.readString(__dataIn);
    }
    if (__dataIn.readBoolean()) { 
        this.no_of_projects = null;
    } else {
    this.no_of_projects = Integer.valueOf(__dataIn.readInt());
    }
    if (__dataIn.readBoolean()) { 
        this.last_performance_rating = null;
    } else {
    this.last_performance_rating = Text.readString(__dataIn);
    }
    if (__dataIn.readBoolean()) { 
        this.left2 = null;
    } else {
    this.left2 = Integer.valueOf(__dataIn.readInt());
    }
    if (__dataIn.readBoolean()) { 
        this.last_date = null;
    } else {
    this.last_date = Text.readString(__dataIn);
    }
  }
  public void write(DataOutput __dataOut) throws IOException {
    if (null == this.emp_no) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    __dataOut.writeInt(this.emp_no);
    }
    if (null == this.emp_title_id) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    Text.writeString(__dataOut, emp_title_id);
    }
    if (null == this.birth_date) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    Text.writeString(__dataOut, birth_date);
    }
    if (null == this.first_name) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    Text.writeString(__dataOut, first_name);
    }
    if (null == this.last_name) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    Text.writeString(__dataOut, last_name);
    }
    if (null == this.sex) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    Text.writeString(__dataOut, sex);
    }
    if (null == this.hire_date) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    Text.writeString(__dataOut, hire_date);
    }
    if (null == this.no_of_projects) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    __dataOut.writeInt(this.no_of_projects);
    }
    if (null == this.last_performance_rating) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    Text.writeString(__dataOut, last_performance_rating);
    }
    if (null == this.left2) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    __dataOut.writeInt(this.left2);
    }
    if (null == this.last_date) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    Text.writeString(__dataOut, last_date);
    }
  }
  public void write0(DataOutput __dataOut) throws IOException {
    if (null == this.emp_no) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    __dataOut.writeInt(this.emp_no);
    }
    if (null == this.emp_title_id) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    Text.writeString(__dataOut, emp_title_id);
    }
    if (null == this.birth_date) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    Text.writeString(__dataOut, birth_date);
    }
    if (null == this.first_name) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    Text.writeString(__dataOut, first_name);
    }
    if (null == this.last_name) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    Text.writeString(__dataOut, last_name);
    }
    if (null == this.sex) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    Text.writeString(__dataOut, sex);
    }
    if (null == this.hire_date) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    Text.writeString(__dataOut, hire_date);
    }
    if (null == this.no_of_projects) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    __dataOut.writeInt(this.no_of_projects);
    }
    if (null == this.last_performance_rating) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    Text.writeString(__dataOut, last_performance_rating);
    }
    if (null == this.left2) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    __dataOut.writeInt(this.left2);
    }
    if (null == this.last_date) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    Text.writeString(__dataOut, last_date);
    }
  }
  private static final DelimiterSet __outputDelimiters = new DelimiterSet((char) 44, (char) 10, (char) 0, (char) 0, false);
  public String toString() {
    return toString(__outputDelimiters, true);
  }
  public String toString(DelimiterSet delimiters) {
    return toString(delimiters, true);
  }
  public String toString(boolean useRecordDelim) {
    return toString(__outputDelimiters, useRecordDelim);
  }
  public String toString(DelimiterSet delimiters, boolean useRecordDelim) {
    StringBuilder __sb = new StringBuilder();
    char fieldDelim = delimiters.getFieldsTerminatedBy();
    __sb.append(FieldFormatter.escapeAndEnclose(emp_no==null?"null":"" + emp_no, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(emp_title_id==null?"null":emp_title_id, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(birth_date==null?"null":birth_date, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(first_name==null?"null":first_name, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(last_name==null?"null":last_name, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(sex==null?"null":sex, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(hire_date==null?"null":hire_date, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(no_of_projects==null?"null":"" + no_of_projects, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(last_performance_rating==null?"null":last_performance_rating, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(left2==null?"null":"" + left2, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(last_date==null?"null":last_date, delimiters));
    if (useRecordDelim) {
      __sb.append(delimiters.getLinesTerminatedBy());
    }
    return __sb.toString();
  }
  public void toString0(DelimiterSet delimiters, StringBuilder __sb, char fieldDelim) {
    __sb.append(FieldFormatter.escapeAndEnclose(emp_no==null?"null":"" + emp_no, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(emp_title_id==null?"null":emp_title_id, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(birth_date==null?"null":birth_date, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(first_name==null?"null":first_name, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(last_name==null?"null":last_name, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(sex==null?"null":sex, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(hire_date==null?"null":hire_date, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(no_of_projects==null?"null":"" + no_of_projects, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(last_performance_rating==null?"null":last_performance_rating, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(left2==null?"null":"" + left2, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(last_date==null?"null":last_date, delimiters));
  }
  private static final DelimiterSet __inputDelimiters = new DelimiterSet((char) 44, (char) 10, (char) 0, (char) 0, false);
  private RecordParser __parser;
  public void parse(Text __record) throws RecordParser.ParseError {
    if (null == this.__parser) {
      this.__parser = new RecordParser(__inputDelimiters);
    }
    List<String> __fields = this.__parser.parseRecord(__record);
    __loadFromFields(__fields);
  }

  public void parse(CharSequence __record) throws RecordParser.ParseError {
    if (null == this.__parser) {
      this.__parser = new RecordParser(__inputDelimiters);
    }
    List<String> __fields = this.__parser.parseRecord(__record);
    __loadFromFields(__fields);
  }

  public void parse(byte [] __record) throws RecordParser.ParseError {
    if (null == this.__parser) {
      this.__parser = new RecordParser(__inputDelimiters);
    }
    List<String> __fields = this.__parser.parseRecord(__record);
    __loadFromFields(__fields);
  }

  public void parse(char [] __record) throws RecordParser.ParseError {
    if (null == this.__parser) {
      this.__parser = new RecordParser(__inputDelimiters);
    }
    List<String> __fields = this.__parser.parseRecord(__record);
    __loadFromFields(__fields);
  }

  public void parse(ByteBuffer __record) throws RecordParser.ParseError {
    if (null == this.__parser) {
      this.__parser = new RecordParser(__inputDelimiters);
    }
    List<String> __fields = this.__parser.parseRecord(__record);
    __loadFromFields(__fields);
  }

  public void parse(CharBuffer __record) throws RecordParser.ParseError {
    if (null == this.__parser) {
      this.__parser = new RecordParser(__inputDelimiters);
    }
    List<String> __fields = this.__parser.parseRecord(__record);
    __loadFromFields(__fields);
  }

  private void __loadFromFields(List<String> fields) {
    Iterator<String> __it = fields.listIterator();
    String __cur_str = null;
    try {
    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.emp_no = null; } else {
      this.emp_no = Integer.valueOf(__cur_str);
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null")) { this.emp_title_id = null; } else {
      this.emp_title_id = __cur_str;
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null")) { this.birth_date = null; } else {
      this.birth_date = __cur_str;
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null")) { this.first_name = null; } else {
      this.first_name = __cur_str;
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null")) { this.last_name = null; } else {
      this.last_name = __cur_str;
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null")) { this.sex = null; } else {
      this.sex = __cur_str;
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null")) { this.hire_date = null; } else {
      this.hire_date = __cur_str;
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.no_of_projects = null; } else {
      this.no_of_projects = Integer.valueOf(__cur_str);
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null")) { this.last_performance_rating = null; } else {
      this.last_performance_rating = __cur_str;
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.left2 = null; } else {
      this.left2 = Integer.valueOf(__cur_str);
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null")) { this.last_date = null; } else {
      this.last_date = __cur_str;
    }

    } catch (RuntimeException e) {    throw new RuntimeException("Can't parse input data: '" + __cur_str + "'", e);    }  }

  private void __loadFromFields0(Iterator<String> __it) {
    String __cur_str = null;
    try {
    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.emp_no = null; } else {
      this.emp_no = Integer.valueOf(__cur_str);
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null")) { this.emp_title_id = null; } else {
      this.emp_title_id = __cur_str;
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null")) { this.birth_date = null; } else {
      this.birth_date = __cur_str;
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null")) { this.first_name = null; } else {
      this.first_name = __cur_str;
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null")) { this.last_name = null; } else {
      this.last_name = __cur_str;
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null")) { this.sex = null; } else {
      this.sex = __cur_str;
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null")) { this.hire_date = null; } else {
      this.hire_date = __cur_str;
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.no_of_projects = null; } else {
      this.no_of_projects = Integer.valueOf(__cur_str);
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null")) { this.last_performance_rating = null; } else {
      this.last_performance_rating = __cur_str;
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.left2 = null; } else {
      this.left2 = Integer.valueOf(__cur_str);
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null")) { this.last_date = null; } else {
      this.last_date = __cur_str;
    }

    } catch (RuntimeException e) {    throw new RuntimeException("Can't parse input data: '" + __cur_str + "'", e);    }  }

  public Object clone() throws CloneNotSupportedException {
    employees o = (employees) super.clone();
    return o;
  }

  public void clone0(employees o) throws CloneNotSupportedException {
  }

  public Map<String, Object> getFieldMap() {
    Map<String, Object> __sqoop$field_map = new HashMap<String, Object>();
    __sqoop$field_map.put("emp_no", this.emp_no);
    __sqoop$field_map.put("emp_title_id", this.emp_title_id);
    __sqoop$field_map.put("birth_date", this.birth_date);
    __sqoop$field_map.put("first_name", this.first_name);
    __sqoop$field_map.put("last_name", this.last_name);
    __sqoop$field_map.put("sex", this.sex);
    __sqoop$field_map.put("hire_date", this.hire_date);
    __sqoop$field_map.put("no_of_projects", this.no_of_projects);
    __sqoop$field_map.put("last_performance_rating", this.last_performance_rating);
    __sqoop$field_map.put("left2", this.left2);
    __sqoop$field_map.put("last_date", this.last_date);
    return __sqoop$field_map;
  }

  public void getFieldMap0(Map<String, Object> __sqoop$field_map) {
    __sqoop$field_map.put("emp_no", this.emp_no);
    __sqoop$field_map.put("emp_title_id", this.emp_title_id);
    __sqoop$field_map.put("birth_date", this.birth_date);
    __sqoop$field_map.put("first_name", this.first_name);
    __sqoop$field_map.put("last_name", this.last_name);
    __sqoop$field_map.put("sex", this.sex);
    __sqoop$field_map.put("hire_date", this.hire_date);
    __sqoop$field_map.put("no_of_projects", this.no_of_projects);
    __sqoop$field_map.put("last_performance_rating", this.last_performance_rating);
    __sqoop$field_map.put("left2", this.left2);
    __sqoop$field_map.put("last_date", this.last_date);
  }

  public void setField(String __fieldName, Object __fieldVal) {
    if (!setters.containsKey(__fieldName)) {
      throw new RuntimeException("No such field:"+__fieldName);
    }
    setters.get(__fieldName).setField(__fieldVal);
  }

}
