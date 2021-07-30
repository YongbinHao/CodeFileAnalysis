import cn.hyb.AnalyseUtil;
import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class FileWalkTest {
    @Test
    public void testFileWalk() {
        Map<String, HashMap<String, String>> fileAnalysisRes = AnalyseUtil.analysis("C:\\Users\\84541\\Desktop\\calculater");
        Assert.assertFalse(fileAnalysisRes.isEmpty());
    }
}
