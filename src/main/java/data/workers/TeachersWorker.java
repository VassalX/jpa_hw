package data.workers;

import data.dao.TeachersDao;
import data.entities.Teacher;
import data.entities.TeacherPosition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;

import java.util.List;

@Service
public class TeachersWorker {
    @Autowired
    private TransactionTemplate transactionTemplate;

    @Autowired
    private TeachersDao teachersDao;

    public TeachersWorker() {
    }

    public void saveTeacher(final Teacher teacher) {
        transactionTemplate.execute(new TransactionCallbackWithoutResult() {
            @Override
            protected void doInTransactionWithoutResult(TransactionStatus txStatus) {
                try{
                    teachersDao.addTeacher(teacher);
                    System.out.println("Teacher has been added " + teacher);
                }catch (Exception e){
                    txStatus.setRollbackOnly();
                    throw e;
                }
            }
        });
    }

    public List<Teacher> getTeachersByPos(TeacherPosition pos){
        List<Teacher> list = teachersDao.getTeachersByPosition(pos);
        return list;
    }

    public Teacher getTeacher(int id){
        return teachersDao.getTeacher(id);
    }
}
