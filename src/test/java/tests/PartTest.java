package tests;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertEquals;

import com.jourdanwoodrich.App;
import com.jourdanwoodrich.model.PartUpdate;
import com.jourdanwoodrich.model.PartUpdateDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;

import java.util.Calendar;

/**
 * Created by jourdanwoodrich on 9/4/16.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(App.class)
@WebAppConfiguration
@Transactional
public class PartTest {

    @Autowired
    private PartUpdateDao partUpdateDao;

    @Test
    public void testSave(){


        PartUpdate part = new PartUpdate("This is a test part.");

        partUpdateDao.save(part);

        assertNotNull("Non Null ID", part.getId());
        assertNotNull("Non Null Date", part.getAdded());

        PartUpdate retreived = partUpdateDao.findOne(part.getId());

        assertEquals("Matching part", part, retreived);
    }

    @Test
    public void testFindLatest(){

        Calendar calendar = Calendar.getInstance();
        PartUpdate lastPartAdded = null;

        for (int i=0; i<10; i++){
            calendar.add(Calendar.DAY_OF_YEAR,1);

            PartUpdate part = new PartUpdate("New Part " + i, calendar.getTime());
            partUpdateDao.save(part);
            lastPartAdded = part;
        }

        PartUpdate retreived = partUpdateDao.findFirstByOrderByAddedDesc();
        assertEquals("Latest Part Added", lastPartAdded, retreived);
    }
}
