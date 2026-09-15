package iso20022.auth030.esma.util;

import com.rosetta.model.lib.mapper.MapperS;
import iso20022.auth030.esma.FixedRate10__1;
import iso20022.auth030.esma.FloatingRate13__1;
import iso20022.auth030.esma.InterestComputationMethodFormat7__1;
import iso20022.auth030.esma.InterestRate33Choice__1;
import iso20022.auth030.esma.InterestRateFrequency3Choice__1;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

public class InterestRate33Choice__1DeepPathUtil {
    public InterestRateFrequency3Choice__1 choosePmtFrqcy(InterestRate33Choice__1 interestRate33Choice__1) {
        final MapperS<FixedRate10__1> fxd = MapperS.of(interestRate33Choice__1).<FixedRate10__1>map("getFxd", _interestRate33Choice__1 -> _interestRate33Choice__1.getFxd());
        if (exists(fxd).getOrDefault(false)) {
            return fxd.<InterestRateFrequency3Choice__1>map("getPmtFrqcy", fixedRate10__1 -> fixedRate10__1.getPmtFrqcy()).get();
        }
        final MapperS<FloatingRate13__1> fltg = MapperS.of(interestRate33Choice__1).<FloatingRate13__1>map("getFltg", _interestRate33Choice__1 -> _interestRate33Choice__1.getFltg());
        if (exists(fltg).getOrDefault(false)) {
            return fltg.<InterestRateFrequency3Choice__1>map("getPmtFrqcy", floatingRate13__1 -> floatingRate13__1.getPmtFrqcy()).get();
        }
        return null;
    }

    public InterestComputationMethodFormat7__1 chooseDayCnt(InterestRate33Choice__1 interestRate33Choice__1) {
        final MapperS<FixedRate10__1> fxd = MapperS.of(interestRate33Choice__1).<FixedRate10__1>map("getFxd", _interestRate33Choice__1 -> _interestRate33Choice__1.getFxd());
        if (exists(fxd).getOrDefault(false)) {
            return fxd.<InterestComputationMethodFormat7__1>map("getDayCnt", fixedRate10__1 -> fixedRate10__1.getDayCnt()).get();
        }
        final MapperS<FloatingRate13__1> fltg = MapperS.of(interestRate33Choice__1).<FloatingRate13__1>map("getFltg", _interestRate33Choice__1 -> _interestRate33Choice__1.getFltg());
        if (exists(fltg).getOrDefault(false)) {
            return fltg.<InterestComputationMethodFormat7__1>map("getDayCnt", floatingRate13__1 -> floatingRate13__1.getDayCnt()).get();
        }
        return null;
    }

}
