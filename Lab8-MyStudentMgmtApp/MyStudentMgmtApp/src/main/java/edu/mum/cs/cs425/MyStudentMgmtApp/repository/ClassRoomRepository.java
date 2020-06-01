package edu.mum.cs.cs425.MyStudentMgmtApp.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import edu.mum.cs.cs425.MyStudentMgmtApp.model.ClassRoom;

@Repository
public interface ClassRoomRepository extends CrudRepository< ClassRoom,  Long > {

}
