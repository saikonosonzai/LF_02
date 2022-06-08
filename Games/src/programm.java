import businessObjects.Game;
import dao.GameDao;

import java.sql.SQLException;

public class programm {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        GameDao gameDao = new GameDao();
        Game game = gameDao.read(2);
        System.out.println(game);

        gameDao.insert("Marvel’s Spider-Man","Action-Adventure; open World", 14.99,"Insomniac Games",4.0);
    }
}
