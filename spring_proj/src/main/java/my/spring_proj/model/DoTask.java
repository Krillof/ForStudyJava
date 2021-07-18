package my.spring_proj.model;


import my.spring_proj.model.entities.*;
import org.springframework.beans.factory.support.ManagedMap;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Dictionary;
import java.util.List;
import java.util.Map;
import java.util.function.IntFunction;

public class DoTask {

    private static List<Entity> taskResult;

    public static <T extends Entity> String justGetHeader(Class<T> cls){
        try {
            Entity entity = cls.getDeclaredConstructor().newInstance();
            return entity.getHeader();

        } catch (InstantiationException | NoSuchMethodException | InvocationTargetException | IllegalAccessException e) {
            e.printStackTrace();
        }
        return "";
    }

    public static String getLastTaskHeader(){
        if (taskResult.isEmpty())
            return "";
        else
            return taskResult.get(0).getHeader();
    }

    public static List<Entity> withNumber(int n){
        ForLambda[] tasks = new ForLambda[] {
                DoTask::t1, DoTask::t2, DoTask::t3, DoTask::t4, DoTask::t5, DoTask::t6, DoTask::t7, DoTask::t8,
                DoTask::t9, DoTask::t10, DoTask::t11, DoTask::t12
        };

        int number = n-1;

        if (tasks.length > number){
            tasks[number].f();
        } else {
            taskResult = new ArrayList<>();
            System.out.println("This task does not exists.");
        }
        return taskResult;
    }

    private static void t1(){
        taskResult = MyDB.query("SELECT sportsman_name FROM sportsman WHERE personal_record <> 25;", OneColumn.class);
    }

    private static void t2(){
        taskResult = MyDB.query("SELECT hold_date FROM result WHERE left(city, 1) = 'M';", OneColumn.class);
    }

    private static void t3(){
        taskResult = MyDB.query("SELECT MAX(_result) FROM result WHERE city = 'Moscow';", OneColumn.class);
    }

    private static void t4(){
        taskResult = MyDB.query("SELECT sportsman.sportsman_id, AVG(_result) " +
                "FROM sportsman " +
                "JOIN result " +
                "ON sportsman.sportsman_id = result.sportsman_id " +
                "GROUP BY sportsman.sportsman_id;", TwoColumn.class);
    }

    private static void t5(){
        taskResult = MyDB.query("SELECT year_of_birth " +
                "FROM sportsman " +
                "JOIN result " +
                "ON sportsman.sportsman_id = result.sportsman_id " +
                "WHERE city = 'Moscow' " +
                "AND _result > (SELECT AVG(_result) FROM result);", OneColumn.class);
    }

    private static void t6(){
        taskResult = MyDB.query("SELECT sportsman.* " +
                "FROM sportsman " +
                "JOIN result ON sportsman.sportsman_id = result.sportsman_id " +
                "JOIN competition ON competition.competition_id = result.competition_id " +
                "WHERE sportsman.personal_record = competition.world_record " +
                "GROUP BY sportsman.sportsman_id, sportsman.sportsman_name, sportsman._rank, sportsman.year_of_birth, " +
                "sportsman.personal_record, sportsman.country;", Sportsman.class);
    }

    private static void t7(){
        taskResult = MyDB.query("SELECT MIN(sportsman._rank) " +
                "FROM sportsman " +
                "JOIN result ON sportsman.sportsman_id = result.sportsman_id " +
                "JOIN competition ON competition.competition_id = result.competition_id " +
                "WHERE result._result = competition.world_record;", OneColumn.class);
    }

    private static void t8(){
        List<Entity> _countries = MyDB.query("SELECT DISTINCT country FROM sportsman;", OneColumn.class);
        List<TwoColumn> amounts_of_sportsmans = new ArrayList<>();
        for (Entity _country : _countries){
            OneColumn country = (OneColumn) _country;
            List<Entity> _value
                    = MyDB.query(
                            "SELECT COUNT(*) FROM sportsman WHERE country = '"
                                    + country.getValue() + "';", OneColumn.class);
            int value = Integer.parseInt(    ( (OneColumn)_value.get(0) ).getValue()    );
            amounts_of_sportsmans.add(new TwoColumn(Integer.toString(value), country.getValue()));
        }
        TwoColumn max_count_country = amounts_of_sportsmans
                .stream()
                .max((a,b) -> {return Integer.compare(Integer.parseInt(a.getValue1()), Integer.parseInt(b.getValue1()));})
                .get();
        OneColumn res_value = new OneColumn(max_count_country.getValue2());
        taskResult = new ArrayList<>();
        taskResult.add(res_value);
    }

    private static void t9(){
        taskResult = MyDB.query("SELECT sportsman.* " +
                "FROM sportsman " +
                "JOIN result ON sportsman.sportsman_id = result.sportsman_id " +
                "WHERE date_part('year', result.hold_date) = 1980 OR date_part('year', result.hold_date) = 1984 " +
                "GROUP BY sportsman.sportsman_id, sportsman.sportsman_name, sportsman._rank, sportsman.year_of_birth, " +
                "sportsman.personal_record, sportsman.country;", Sportsman.class);
    }

    private static void t10(){//Я потом прочитал, что нужно делать на PL/SQL, но решил оставить так.
        List<Entity> competitions_ids = MyDB.query("SELECT competition_id FROM competition ORDER BY set_date;", OneColumn.class);
        List<Entity> last_competition_members = null;
        List<Integer> matches_ids = new ArrayList<>();
        for (Entity _competition_id : competitions_ids){
            OneColumn competition_id = (OneColumn) _competition_id;
            List<Entity> members
                    = MyDB.query("SELECT sportsman_id FROM result WHERE competition_id = "
                    + competition_id.getValue() + ";", OneColumn.class);

            if (last_competition_members == null){
                last_competition_members = members;
            } else {
                Object [] A = members.stream().map(a -> Integer.parseInt(((OneColumn)a).getValue())).toArray();
                Object [] B = last_competition_members.stream().map(a -> Integer.parseInt(((OneColumn)a).getValue())).toArray();
                for (Object a : A){
                    for (Object b : B){
                        if (((Integer) a).equals((Integer) b)){
                            matches_ids.add((Integer) a);
                        }
                    }
                }
            }
        }
        taskResult = new ArrayList<>();
        for (Object _id : matches_ids.stream().distinct().toArray() ){
            taskResult.addAll(
                    MyDB.query("SELECT * FROM sportsman WHERE sportsman_id = " + Integer.toString((Integer) _id)
                            + ";", Sportsman.class));
        }
    }

    private static void t11(){//Я потом прочитал, что нужно делать на PL/SQL, но решил оставить так.
        List<Entity> sportsmans = MyDB.query("SELECT * FROM sportsman;", Sportsman.class);

        List<Entity> competitions_ids = MyDB.query("SELECT competition_id FROM competition;", OneColumn.class);

        int competitions_amount = competitions_ids.size();
        Map<Integer, Integer> sportsmans_attendance = new ManagedMap<>();
        for (Entity _id : competitions_ids){
            OneColumn id = (OneColumn) _id;
            List<Entity> members = MyDB.query("SELECT sportsman_id " +
                    "FROM result JOIN competition ON result.competition_id = competition.competition_id " +
                    "WHERE result.competition_id = " + id.getValue() + ";", OneColumn.class);

            for (Entity _member : members){
                int sp_id = Integer.parseInt(((OneColumn)_member).getValue());
                if (sportsmans_attendance.containsKey(sp_id)){
                    sportsmans_attendance.replace(sp_id, sportsmans_attendance.get(sp_id)+1);
                } else {
                    sportsmans_attendance.put(sp_id, 1);
                }
            }
        }
        List<Integer> res_ids = new ArrayList<>();
        for (Integer key : sportsmans_attendance.keySet()){
            if (sportsmans_attendance.get(key) > 2 && sportsmans_attendance.get(key) < competitions_amount){
                res_ids.add(key);
            }
        }
        taskResult = new ArrayList<>();
        for (Integer id : res_ids ){
            taskResult.addAll(
                    MyDB.query("SELECT * FROM sportsman WHERE sportsman_id = " + Integer.toString((Integer) id)
                            + ";", Sportsman.class));
        }
    }

    public static int sportman_id_param = 1;
    public static int competition_id_param = 1;

    //Пример для 12 задания:
    //http://localhost:8080/task/12?sportsman_id=1&competition_id=2

    private static void t12(){//Я потом прочитал, что нужно делать на PL/SQL, но решил оставить так.

        List<Entity> _sportsman = MyDB.query(
                "SELECT * FROM sportsman WHERE sportsman_id = "
                        + sportman_id_param +";", Sportsman.class);

        Sportsman sportsman = null;
        if (!_sportsman.isEmpty()) sportsman =  (Sportsman)_sportsman.get(0);



        List<Entity> _competition = MyDB.query(
                "SELECT * FROM competition WHERE competition_id = "
                        + competition_id_param + ";", Competition.class);

        Competition competition = null;
        if (!_competition.isEmpty()) competition = (Competition)_competition.get(0);



        List<Entity> _result = MyDB.query(
                "SELECT * FROM result WHERE sportsman_id = "
                        + sportman_id_param + " AND competition_id = "
                        + competition_id_param + ";", Result.class);

        Result result = null;
        if (!_result.isEmpty())
            result = (Result)_result.get(0);



        if (sportsman != null && competition != null && result != null){
            List<Entity> down
                    = MyDB.query("SELECT sportsman.* " +
                    "FROM result JOIN sportsman " +
                    "ON result.sportsman_id = sportsman.sportsman_id " +
                    "WHERE competition_id = "
                    +competition.getId()
                    +" AND _result = (SELECT MAX(_result) FROM result WHERE _result < "+result.getResult()+")", Sportsman.class);
            List<Entity> top
                    = MyDB.query("SELECT sportsman.* " +
                    "FROM result JOIN sportsman " +
                    "ON result.sportsman_id = sportsman.sportsman_id " +
                    "WHERE competition_id = " +
                    +competition.getId()+
                    " AND _result = (SELECT MIN(_result) FROM result WHERE _result > "+result.getResult()+")", Sportsman.class);

            taskResult = new ArrayList<>();
            taskResult.addAll(down);
            taskResult.addAll(top);
        } else {
            taskResult = new ArrayList<>();
            taskResult.add(new OneColumn("nothing"));
        }

    }

}
