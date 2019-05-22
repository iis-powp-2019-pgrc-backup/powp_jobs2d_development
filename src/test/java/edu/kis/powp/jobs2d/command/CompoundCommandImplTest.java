package edu.kis.powp.jobs2d.command;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CompoundCommandImplTest {

    CompoundCommandImpl compoundCommand;
    DriverCommand[] driverCommands = {new OperateToCommand(1,1), new SetPositionCommand(2,2)};


    @BeforeEach
    void setup(){
        compoundCommand = new CompoundCommandImpl(driverCommands);
    }

    @Test
    void iterator() {
        Iterator<DriverCommand> driverCommandIterator = compoundCommand.iterator();

        List<DriverCommand> list = Arrays.asList(driverCommands);

        for(DriverCommand dc : list){
            if(driverCommandIterator.hasNext()){
                Assertions.assertEquals(dc, driverCommandIterator.next());
            }else{
                fail();
            }
        }
    }
}