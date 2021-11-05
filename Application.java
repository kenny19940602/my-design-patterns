import behavioral.chain.ChainPatternDemo;
import behavioral.strategy.FileTypeResolveEnum;
import behavioral.strategy.StrategyUseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("behavioral")
public class Application implements CommandLineRunner {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Autowired
    private StrategyUseService service;
    @Autowired
    private ChainPatternDemo chainPatternDemo;

    @Override
    public void run(String... args) throws Exception {
        service.resolveFile(FileTypeResolveEnum.File_DEFAULT_RESOLVE, "aaaaa");
        chainPatternDemo.exec(null, null);
    }
}
