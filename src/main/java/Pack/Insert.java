package Pack;
import java.io.InputStream;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Insert {
   @RequestMapping("/i1")
   public String method01(Model model, HttpServletRequest request){
      
      SqlSessionFactory ssf = null;
      SqlSession session = null;
      System.out.println(1);
      InputStream is = null;
      try { is = Resources.getResourceAsStream("mybatis-config.xml"); } 
      catch (Exception e) { e.printStackTrace(); }

      ssf = new SqlSessionFactoryBuilder().build(is);
      System.out.println(2);

      session = ssf.openSession();
      try {
         Person p = new Person();
         String name = request.getParameter("name");
         int age = Integer.parseInt(request.getParameter("age"));
         p.setAge(age);
         p.setName(name);
         model.addAttribute("name", name);
         model.addAttribute("age", age);
         
         // insert
         int r = session.insert("insert01",p);
         model.addAttribute("r", r);
         if(r>0) { session.commit(); }

         // select         
         List<Person> mm = session.selectList("select01");
         for (Person person : mm) {
            System.out.println(person.getName() + " " + person.getAge());
         }
         
      } catch (Exception e) { e.printStackTrace(); 
      } finally { session.close(); }

      System.out.println(3);
      
      return "InsertView";
   }

}