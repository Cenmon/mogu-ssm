package taotao_common;

import java.util.List;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class TaotaoItemResult {

	    // 定义jackson对象
	    private static final ObjectMapper MAPPER = new ObjectMapper();

	    // 响应业务状态
	    private Integer status;

	    // 响应消息
	    private String msg;

	    // 响应中的数据
	    private Object data;

	    public TaotaoItemResult() {

	    }

	    public TaotaoItemResult(Integer status, String msg, Object data) {
	        this.status = status;
	        this.msg = msg;
	        this.data = data;
	    }

	    public TaotaoItemResult(Object data) {
	        this.status = 200;
	        this.msg = "OK";
	        this.data = data;
	    }
	    
	    public static TaotaoItemResult build(Integer status, String msg) {
	    	return new TaotaoItemResult(status, msg, null);
	    }
	    
	    public static TaotaoItemResult build(Integer status, String msg, Object data) {
	    	return new TaotaoItemResult(status, msg, data);
	    }
	    
	    public static TaotaoItemResult ok(Object data) {
	    	return new TaotaoItemResult(data);
	    }
	    
	    public static TaotaoItemResult error() {
	    	return new TaotaoItemResult(500, "error", null);
	    }
	    
	    public static TaotaoItemResult ok() {
	    	return new TaotaoItemResult(null);
	    }

//	    public Boolean isOK() {
//	        return this.status == 200;
//	    }

	    public Integer getStatus() {
	        return status;
	    }

	    public void setStatus(Integer status) {
	        this.status = status;
	    }

	    public String getMsg() {
	        return msg;
	    }

	    public void setMsg(String msg) {
	        this.msg = msg;
	    }

	    public Object getData() {
	        return data;
	    }

	    public void setData(Object data) {
	        this.data = data;
	    }

	    /**
	     * 将json结果集转化为AddItemResult对象
	     * 
	     * @param jsonData json数据
	     * @param clazz AddItemResult中的object类型
	     * @return
	     */
	    public static TaotaoItemResult formatToPojo(String jsonData, Class<?> clazz) {
	        try {
	            if (clazz == null) {
	                return MAPPER.readValue(jsonData, TaotaoItemResult.class);
	            }
	            JsonNode jsonNode = MAPPER.readTree(jsonData);
	            JsonNode data = jsonNode.get("data");
	            Object obj = null;
	            if (clazz != null) {
	                if (data.isObject()) {
	                    obj = MAPPER.readValue(data.traverse(), clazz);
	                } else if (data.isTextual()) {
	                    obj = MAPPER.readValue(data.asText(), clazz);
	                }
	            }
	            return build(jsonNode.get("status").intValue(), jsonNode.get("msg").asText(), obj);
	        } catch (Exception e) {
	            return null;
	        }
	    }

	    /**
	     * 没有object对象的转化
	     * 
	     * @param json
	     * @return
	     */
	    public static TaotaoItemResult format(String json) {
	        try {
	            return MAPPER.readValue(json, TaotaoItemResult.class);
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	        return null;
	    }

	    /**
	     * Object是集合转化
	     * 
	     * @param jsonData json数据
	     * @param clazz 集合中的类型
	     * @return
	     */
	    public static TaotaoItemResult formatToList(String jsonData, Class<?> clazz) {
	        try {
	            JsonNode jsonNode = MAPPER.readTree(jsonData);
	            JsonNode data = jsonNode.get("data");
	            Object obj = null;
	            if (data.isArray() && data.size() > 0) {
	                obj = MAPPER.readValue(data.traverse(),
	                        MAPPER.getTypeFactory().constructCollectionType(List.class, clazz));
	            }
	            return build(jsonNode.get("status").intValue(), jsonNode.get("msg").asText(), obj);
	        } catch (Exception e) {
	            return null;
	        }
	    }
}
