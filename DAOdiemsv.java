package DAOassignmentsof203;

import DTOAssignments.Diemsv;
import java.util.ArrayList;

public interface DAOdiemsv<T> {

    public ArrayList<Diemsv> xuatdatadsdiem() throws Exception;

    public void luudiem() throws Exception;

    public ArrayList<Diemsv> xuatdsdiem();

    public void deleteđiem(int ma) throws Exception;

    public void updatediem(String ma, String markE, String markT, String markP, int i) throws Exception;

    public ArrayList<Diemsv> xuatlstdiem();

    public void themdiem(Diemsv sv) throws Exception;

    public void themdiemvaoexcel() throws Exception;

    public ArrayList<Diemsv> xuatdsexcel() throws Exception;

    default void sapxeptddtb(ArrayList<Diemsv> ds) {
        ds.sort((o1, o2) -> {
            Float d1 = o1.dtb();
            Float d2 = o2.dtb();
            return d1.compareTo(d2);
        });
    }

    default void sapxepgddtb(ArrayList<Diemsv> ds) {
        ds.sort((o1, o2) -> {
            Float d1 = o1.dtb();
            Float d2 = o2.dtb();
            return d2.compareTo(d1);
        });
    }

    default void sapxeptddiemta(ArrayList<Diemsv> ds) {
        ds.sort((o1, o2) -> {
            Float d1 = o1.getMarkE();
            Float d2 = o2.getMarkE();
            return d2.compareTo(d1);
        });
    }

    default void sapxepgddiemta(ArrayList<Diemsv> ds) {
        ds.sort((o1, o2) -> {
            Float d1 = o1.getMarkE();
            Float d2 = o2.getMarkE();
            return d2.compareTo(d1);
        });
    }

    default void sapxeptddiemth(ArrayList<Diemsv> ds) {
        ds.sort((o1, o2) -> {
            Float d1 = o1.getMarkT();
            Float d2 = o2.getMarkT();
            return d2.compareTo(d1);
        });
    }

    default void sapxepgddiemth(ArrayList<Diemsv> ds) {
        ds.sort((o1, o2) -> {
            Float d1 = o1.getMarkT();
            Float d2 = o2.getMarkT();
            return d2.compareTo(d1);
        });
    }
    
    default void sapxeptddiemgdtc(ArrayList<Diemsv> ds) {
        ds.sort((o1, o2) -> {
            Float d1 = o1.getMarkP();
            Float d2 = o2.getMarkP();
            return d2.compareTo(d1);
        });
    }

    default void sapxepgddiemgdtc(ArrayList<Diemsv> ds) {
        ds.sort((o1, o2) -> {
            Float d1 = o1.getMarkP();
            Float d2 = o2.getMarkP();
            return d2.compareTo(d1);
        });
    }
    
    default void sapxeptdtensv(ArrayList<Diemsv> ds) {
        ds.sort((o1, o2) -> {
            return o1.getName().compareTo(o2.getName());
        });
    }

    default void sapxepgdtensv(ArrayList<Diemsv> ds) {
        ds.sort((o1, o2) -> {
            return o2.getName().compareTo(o1.getName());
        });
    }
    
    default void sapxeptdmasv(ArrayList<Diemsv> ds) {
        ds.sort((o1, o2) -> {
            return o1.getMasv().compareTo(o2.getMasv());
        });
    }

    default void sapxepgdmasv(ArrayList<Diemsv> ds) {
        ds.sort((o1, o2) -> {
            return o2.getMasv().compareTo(o1.getMasv());
        });
    }
}
