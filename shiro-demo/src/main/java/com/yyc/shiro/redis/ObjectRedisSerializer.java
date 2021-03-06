package com.yyc.shiro.redis;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.convert.converter.Converter;
import org.springframework.core.serializer.support.DeserializingConverter;
import org.springframework.core.serializer.support.SerializingConverter;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.SerializationException;

/**
 * @Auther: yangyongcui
 * @Date: 2018/7/17: 10:53
 * @Description:
 */
public class ObjectRedisSerializer implements RedisSerializer<Object> {
    private static final Logger LOG = LoggerFactory.getLogger(ObjectRedisSerializer.class);

    /**
     * 定义序列化和发序列化转化类
     */
    private Converter<Object, byte[]> serializer = new SerializingConverter();
    private Converter<byte[], Object> deserializer = new DeserializingConverter();
    /**
     * 定义转换空字节数组
     */
    private static final byte[] EMPTY_ARRAY = new byte[0];

    @Override
    public byte[] serialize(Object obj) throws SerializationException {
        byte[] byteArray = null;
        if (null == obj) {
            LOG.warn("Redis待序列化的对象为空.");
            byteArray = EMPTY_ARRAY;
        } else {
            try {
                byteArray = serializer.convert(obj);
            } catch (Exception e) {
                LOG.error("Redis序列化对象失败,异常：" + e.getMessage());
                byteArray = EMPTY_ARRAY;
            }
        }
        return byteArray;
    }

    @Override
    public Object deserialize(byte[] bytes) throws SerializationException {
        Object obj = null;
        if (isNullOrEmpty(bytes)) {
            LOG.warn("Redis待反序列化的对象为空.");
        } else {
            try {
                obj = deserializer.convert(bytes);
            } catch (Exception e) {
                LOG.error("Redis反序列化对象失败,异常：" + e.getMessage());
            }
        }
        return obj;
    }

    private boolean isNullOrEmpty(byte[] bytes) {
        return (null == bytes) || (bytes.length == 0);
    }
}
