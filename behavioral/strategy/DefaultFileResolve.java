package behavioral.strategy;

import lombok.extern.java.Log;
import org.springframework.stereotype.Component;

@Component
@Log
public class DefaultFileResolve implements IFileStrategy {

    @Override
    public FileTypeResolveEnum gainFileType() {
        return FileTypeResolveEnum.File_DEFAULT_RESOLVE;
    }

    @Override
    public void resolve(Object objectparam) {
        log.info("默认类型解析文件，参数："+objectparam);
        //默认类型解析具体逻辑
    }
}
