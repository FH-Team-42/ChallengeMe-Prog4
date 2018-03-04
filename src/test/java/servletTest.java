
import junit.framework.*;
import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import servlets.LoginServlet;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class servletTest extends TestCase {

    @Mock
    HttpServletRequest request;
    @Mock
    HttpServletResponse response;
    @Mock
    HttpSession session;

    @Mock
    RequestDispatcher rd;

    @Before
    protected void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void test() throws Exception {

  /*HttpServletRequest request = mock(HttpServletRequest.class);
  HttpServletResponse response = mock(HttpServletResponse.class);
  HttpSession session = mock(HttpSession.class);
  RequestDispatcher rd=mock(RequestDispatcher.class);*/


        when(request.getParameter("username")).thenReturn("max");
        when(request.getParameter("password")).thenReturn("123456");
        when(request.getSession()).thenReturn(session);
        verify(response).sendRedirect(captor.capture());


        new LoginServlet().doPost(request, response);

        //Verify the session attribute value
        verify(session).setAttribute("id", "1");


        assertEquals("/", captor.getValue());
    }


}
