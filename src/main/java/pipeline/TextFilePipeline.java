package pipeline;

import data.DataFileManager;
import processor.Const;
import us.codecraft.webmagic.ResultItems;
import us.codecraft.webmagic.Task;
import us.codecraft.webmagic.pipeline.Pipeline;
import util.Decoder;

public class TextFilePipeline implements Pipeline {
    @Override
    public void process(ResultItems resultItems, Task task) {
        String data = resultItems.get(Const.FieldKey.ARTICLE).toString();

        DataFileManager.append2DataFile(Decoder.convert(data));
        DataFileManager.append2DataFile(",");
    }
}
