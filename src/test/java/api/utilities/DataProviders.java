package api.utilities;

import java.io.IOException;
import org.testng.annotations.DataProvider;

public class DataProviders {

	@DataProvider(name = "Data")

	public String[][] getAllData() throws IOException {

		// get the data from excel
		String path = System.getProperty("user.dir") + "//TestData//Userdata.xlsx";
		XLUtility xlutil = new XLUtility(path);

		int totalrows = xlutil.getRowCount("Sheet1");
		int totalcols = xlutil.getCellCount("Sheet1", 1);

		String apidata[][] = new String[totalrows][totalcols];

		for (int i = 1; i <= totalrows; i++) // 1
		{
			for (int j = 0; j < totalcols; j++) // 0
			{
				apidata[i - 1][j] = xlutil.getCellData("Sheet1", i, j);
			}

		}

		return apidata;
	}

	@DataProvider(name = "UserNames")

	public String[] getUserNames() throws IOException {

		// get the data from excel
		
		String path = System.getProperty("user.dir") + "//TestData//Userdata.xlsx";
		XLUtility xl = new XLUtility(path);

		int rownum = xl.getRowCount("Sheet1");

		String apidata[] = new String[rownum];

		for (int i = 1; i <= rownum; i++) // 1
		{
			apidata[i - 1] = xl.getCellData("Sheet1", i, 1);

		}

		return apidata;
	}

}
