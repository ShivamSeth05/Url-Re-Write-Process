package text;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.http.HttpServletRequest;

public class RetrieveBookDAO {
	public BookBean bb=null;
	public BookBean retrieve(HttpServletRequest req) {
		try {
			Connection con = DBConnection.getCon();
			PreparedStatement ps = con.prepareStatement
					("select * from BookDetails50 where code=?");
			ps.setString(1, req.getParameter("bcode"));
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				bb = new BookBean();
				bb.setCode(rs.getString(1));
				bb.setName(rs.getString(2));
				bb.setAuthor(rs.getString(3));
				bb.setPrice(rs.getFloat(4));
				bb.setQty(rs.getInt(5));
			}
		}catch(Exception e) {e.printStackTrace();}
		return bb;
	}
}
