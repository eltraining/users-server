package app;

/**
 * Created by TBB on 02.09.2016.
 */
public class Group {

    public final String groupname;
    //Add more elements if necessary


    public Group(String groupname) {
        this.groupname = groupname;
    }

    public String getGroupname() {
        return groupname;
    }
    @Override
    public String toString() {
        return "Group{" +
                "groupname='" + groupname + '\'' +
                '}';
    }
}
