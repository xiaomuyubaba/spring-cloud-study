package com.lijin.study.springcloud.common.util;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JacksonException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

class JsonUtilTest {

    @Test
    void test() {
        JSONTestBean jtb1 = new JSONTestBean("小白", 23, new Date(System.currentTimeMillis()), new BigDecimal("23990.12"));
        Map<String, Object> leader = new HashMap<>();
        leader.put("nm", "大白司令");
        leader.put("age", 55);
        leader.put("noUse", true);
        jtb1.setLeader(leader);
        System.out.printf("jtb1 : %s\n", jtb1);
        String json = JsonUtil.toJson(jtb1);
        System.out.println(json);
        System.out.println(JsonUtil.toJsonWithFormat(jtb1));
        JSONTestBean jtb2 = JsonUtil.fromJson(json, JSONTestBean.class);
        System.out.printf("jtb2 : %s\n", jtb2);
        Assertions.assertEquals(jtb1.name, jtb2.name);
        Assertions.assertEquals(jtb1.age, jtb2.age);
        Assertions.assertEquals(jtb1.salary, jtb2.salary);
        // 转成JSON再转回来时，日期会失去毫秒级的精度，故不一致
        Assertions.assertNotEquals(jtb1.birthday, jtb2.birthday);
    }

    public static class JSONTestBean {

        @JsonProperty("myName")
        private String name;
        private int age;
        private Date birthday;
        private BigDecimal salary;

        @JsonSerialize(using = LeaderSerializer.class)
        @JsonDeserialize(using = LeaderDeSerializer.class)
        private Map<String, Object> leader;

        public Map<String, Object> getLeader() {
            return leader;
        }

        public void setLeader(Map<String, Object> leader) {
            this.leader = leader;
        }

        /**
         * 一定要显示指定无参构造函数，否则无法从JSON转成对象
         */
        public JSONTestBean() {
        }

        public JSONTestBean(String name, int age, Date birthday, BigDecimal salary) {
            this.name = name;
            this.age = age;
            this.birthday = birthday;
            this.salary = salary;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public Date getBirthday() {
            return birthday;
        }

        public void setBirthday(Date birthday) {
            this.birthday = birthday;
        }

        public BigDecimal getSalary() {
            return salary;
        }

        public void setSalary(BigDecimal salary) {
            this.salary = salary;
        }

        @Override
        public boolean equals(Object o) {
            if (o == null || getClass() != o.getClass()) return false;

            JSONTestBean that = (JSONTestBean) o;
            return age == that.age && Objects.equals(name, that.name) && Objects.equals(birthday, that.birthday) && Objects.equals(salary, that.salary);
        }

        @Override
        public int hashCode() {
            int result = Objects.hashCode(name);
            result = 31 * result + age;
            result = 31 * result + Objects.hashCode(birthday);
            result = 31 * result + Objects.hashCode(salary);
            return result;
        }

        @Override
        public String toString() {
            return "JSONTestBean{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    ", birthday=" + birthday +
                    ", salary=" + salary +
                    ", leader=" + leader +
                    '}';
        }
    }

    /**
     * leader字段的序列化器
     */
    public static class LeaderSerializer extends StdSerializer<Map<String, Object>> {

        public LeaderSerializer() {
            this(null);
        }

        public LeaderSerializer(Class<Map<String, Object>> t) {
            super(t);
        }

        @Override
        public void serialize(Map value, JsonGenerator gen, SerializerProvider provider) throws IOException {
            if (value == null) {
                gen.writeNull();
                return;
            }
            gen.writeString(value.toString());
        }
    }

    /**
     * leader字段的反序列化器
     */
    public static class LeaderDeSerializer extends StdDeserializer<Map<String, Object>> {

        public LeaderDeSerializer() {
            this(null);
        }

        public LeaderDeSerializer(Class<Map<String, Object>> t) {
            super(t);
        }

        @Override
        public Map<String, Object> deserialize(JsonParser p, DeserializationContext ctx) throws IOException, JacksonException {
            String leaderStr = p.getValueAsString();
            Map<String, Object> leader = new HashMap<>();
            if (leaderStr == null) {
                return new HashMap<>();
            }
            String[] pairs = leaderStr.substring(1, leaderStr.length() - 1).split(",");
            for (String pair : pairs) {
                String[] kv = pair.trim().split("=");
                if (kv.length != 2) {
                    throw new RuntimeException("Invalid Leader Str: " + pair);
                }
                String k = kv[0].trim();
                String v = kv[1].trim();
                if ("age".equals(k)) {
                    try {
                        leader.put(k, Integer.parseInt(v));
                    } catch (Exception e) {
                        throw new RuntimeException("Invalid age: " + v);
                    }
                } else if ("nm".equals(k)) {
                    try {
                        leader.put(k, v);
                    } catch (Exception e) {
                        throw new RuntimeException("Invalid nm: " + v);
                    }
                }
            }
            return leader;
        }
    }
}