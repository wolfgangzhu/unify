package com.wolfgangzhu.unify.example.trace;

import com.wolfgangzhu.unify.domain.ResultInfo;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wolfgang
 * @date 2020-07-16 17:00:11
 * @version $ Id: TraceController.java, v 0.1  wolfgang Exp $
 */
@RestController
public class TraceController {

    @RequestMapping("/trace")
    public ResultInfo controller() {
        return ResultInfo.succeed();
    }

    @RequestMapping("/trace2")
    public String controller2() {
        return "test";
    }
}
