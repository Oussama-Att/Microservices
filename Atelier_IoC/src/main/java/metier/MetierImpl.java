package metier;

import data.DataImpl;
import data.IData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class MetierImpl implements IMetier {
    @Autowired
    private IData datacall;

    @Qualifier("data")
    @Override
    public double calcule() {
        double data = datacall.getData();
        double result = data * 15.6;
        return result;
    }

    public void setDatacall(DataImpl datacall) {
        this.datacall = datacall;
    }
}