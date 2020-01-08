package leet.exe;

import io.netty.util.concurrent.DefaultThreadFactory;
import jdk.nashorn.internal.ir.RuntimeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * desc:
 * author: liuxiaozheng
 * time: 2019/12/17  15:15
 **/
public class ExeService {
    private static final ThreadPoolExecutor executorPool = new ThreadPoolExecutor(3, 6, 50, TimeUnit.SECONDS,
            new LinkedBlockingDeque<>(100),
            new DefaultThreadFactory("test_pool"),
            new ThreadPoolExecutor.CallerRunsPolicy()
    );

    private CompletionService<Boolean> completionService = new ExecutorCompletionService<>(executorPool);


    public ExeService(){


    }


    public void doTask(ValidateTask validateTask, RuntimeNode.Request request){
        completionService.submit(new Callable<Boolean>() {
            @Override
            public Boolean call() throws Exception {
                return validateTask.doTask(request);
            }
        });
    }

    public boolean poll(){
        try {
            Future<Boolean> poll = completionService.poll(500, TimeUnit.MILLISECONDS);
            if (poll == null){
                return false;
            }
            Boolean result = poll.get();

            if (result == null || !result){
                return false;
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public static void main(String[] args) {
        RuntimeNode.Request request = null;

        List<ValidateTask> list = new ArrayList<>();

        ExeService exeService = new ExeService();

        for (ValidateTask task : list){
            exeService.doTask(task, request);
        }

        for (int i=0;i<list.size();i++){
            boolean result = exeService.poll();
            if (!result){
                System.out.println("未通过");
                return;
            }
        }

        System.out.println("通过");



    }

    

}
