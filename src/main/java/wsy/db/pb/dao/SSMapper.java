package wsy.db.pb.dao;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;
import wsy.db.pb.domain.SS;

import java.util.List;

/**
 * @author: dabibio
 * @create: 2019-06-27 00:25
 */
@Mapper
@Component
public interface SSMapper {

    Integer insert(SS ss);

    List<SS> list();

    Integer delete(SS ss);

}
