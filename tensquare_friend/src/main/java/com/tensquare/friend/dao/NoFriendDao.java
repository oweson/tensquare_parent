package com.tensquare.friend.dao;

import com.tensquare.friend.pojo.NoFriend;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface NoFriendDao extends JpaRepository<NoFriend, String> {
    /**
     * 1 查询是否存在此条数据
     *
     * @param userid
     * @param friendid
     * @return
     */
    public NoFriend findByUseridAndFriendid(String userid, String friendid);

    /**
     * 2 更新喜欢
     * 莫名其妙执行不成功且控制台会显示sql语句而不提示异常，多捣鼓一会又成功了，可能是sql中带有特殊字符的原因
     * ？1，？2，？3序号必须是顺序的，按参数顺序严格对应
     * @param userid
     * @param friendid
     * @param islike
     */
    @Modifying
    @Query(value = "UPDATE tb_nofriend SET islike=?3 WHERE userid=?1 AND friendid = ?2", nativeQuery = true)
    public void updateLike(String userid, String friendid, String islike);
}
