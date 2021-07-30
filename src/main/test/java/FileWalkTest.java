import cn.hyb.AnalyseUtil;
import org.junit.Assert;
import org.junit.Test;

import java.nio.file.Path;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class FileWalkTest {
    @Test
    public void testFileWalk() {
        Map<Path, HashMap<String, String>> fileAnalysisRes = AnalyseUtil.analysis("C:\\Users\\84541\\Desktop\\calculater", Arrays.asList(".java", ".xml"));
        Assert.assertFalse(fileAnalysisRes.isEmpty());
    }
}
