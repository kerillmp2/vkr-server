package csv;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import com.opencsv.CSVReader;
import com.opencsv.bean.ColumnPositionMappingStrategy;
import com.opencsv.bean.CsvToBean;
import data.HotelScored;

public class HotelScoredParser {
    public static List<HotelScored> parseHotelReviewsCsv(String path) {
        try {
            CsvToBean csv = new CsvToBean();
            CSVReader csvReader = new CSVReader(new FileReader(path));

            ColumnPositionMappingStrategy strategy = new ColumnPositionMappingStrategy();
            strategy.setType(RawHotelScored.class);
            String[] columns = new String[]{"X", "hotel_name", "clean_score", "location_score", "service_score", "room_score", "money_score", "food_score", "transport_score", "facilities_score", "culture_score", "joy_score", "Hotel_Address", "Average_Score", "Total_Number_of_Reviews", "lat", "lng", "country", "id"};
            strategy.setColumnMapping(columns);

            csv.setMappingStrategy(strategy);
            csv.setCsvReader(csvReader);

            //Set column mapping strategy
            List list = csv.parse();
            list.remove(0);
            List<HotelScored> hotelsScored = new ArrayList<>();
            list.forEach(o -> hotelsScored.add(HotelScored.fromRawHotelScored((RawHotelScored) o)));

            return hotelsScored;
        } catch (FileNotFoundException e) {
            System.out.println("Can't find file " + path);
            return List.of();
        }
    }
}
