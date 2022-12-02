package com.example.demo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;


public interface MessageRepository extends JpaRepository<Message, Long>{

	@Query(value="Select count(*) from message where seen is null and sender_name=:senderName and receiver_name=:receiverName and status=1",nativeQuery=true)
	String getunreadcount(String senderName, String receiverName);
	
	@Query(value="Select count(*) from message",nativeQuery=true)
	String getcount();

	@Transactional
	@Modifying(clearAutomatically = true)
	@Query(value="update message set seen=true where sender_name=:senderName and receiver_name=:receiverName",nativeQuery =true)
	void updateseend(String senderName, String receiverName);


}
