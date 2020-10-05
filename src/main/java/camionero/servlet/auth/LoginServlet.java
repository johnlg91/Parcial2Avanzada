package camionero.servlet.auth;

import camionero.dao.DB;
import camionero.model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet({"login"})
public class LoginServlet extends HttpServlet {

    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        // usamos el jsp del login cuando hacen un GET
        req.getRequestDispatcher("/auth/login.jsp").include(req, resp);
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        // agarramos user y password que se mandaron en el form de login.jsp
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        // buscamos el usuario en la DB
        User user = DB.getInstance().getUserDAO().find(username);

        // nos fijamos si esta OK el password
        if (user != null && password.equals(user.getPassword())) {
            // si esta ok, guardamos el usario en la session y vamos al home
            HttpSession session = req.getSession();
            session.setMaxInactiveInterval(Integer.MAX_VALUE); // que expire nunca
            session.setAttribute("user", user);
            resp.sendRedirect("/");
        } else {
            // si esta mal, volvemos al login con el mensaje de error
            req.setAttribute("msg", "Usuario o password incorrectos!");
            req.getRequestDispatcher("/auth/login.jsp").include(req, resp);
        }
    }
}

