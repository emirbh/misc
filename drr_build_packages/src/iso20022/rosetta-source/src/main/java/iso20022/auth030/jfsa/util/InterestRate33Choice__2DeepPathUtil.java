package iso20022.auth030.jfsa.util;

import com.rosetta.model.lib.mapper.MapperS;
import iso20022.auth030.jfsa.FixedRate10__1;
import iso20022.auth030.jfsa.FloatingRate13__2;
import iso20022.auth030.jfsa.InterestComputationMethodFormat7__1;
import iso20022.auth030.jfsa.InterestRate33Choice__2;
import iso20022.auth030.jfsa.InterestRateFrequency3Choice__1;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

public class InterestRate33Choice__2DeepPathUtil {
    public InterestRateFrequency3Choice__1 choosePmtFrqcy(InterestRate33Choice__2 interestRate33Choice__2) {
        final MapperS<FixedRate10__1> fxd = MapperS.of(interestRate33Choice__2).<FixedRate10__1>map("getFxd", _interestRate33Choice__2 -> _interestRate33Choice__2.getFxd());
        if (exists(fxd).getOrDefault(false)) {
            return fxd.<InterestRateFrequency3Choice__1>map("getPmtFrqcy", fixedRate10__1 -> fixedRate10__1.getPmtFrqcy()).get();
        }
        final MapperS<FloatingRate13__2> fltg = MapperS.of(interestRate33Choice__2).<FloatingRate13__2>map("getFltg", _interestRate33Choice__2 -> _interestRate33Choice__2.getFltg());
        if (exists(fltg).getOrDefault(false)) {
            return fltg.<InterestRateFrequency3Choice__1>map("getPmtFrqcy", floatingRate13__2 -> floatingRate13__2.getPmtFrqcy()).get();
        }
        return null;
    }

    public InterestComputationMethodFormat7__1 chooseDayCnt(InterestRate33Choice__2 interestRate33Choice__2) {
        final MapperS<FixedRate10__1> fxd = MapperS.of(interestRate33Choice__2).<FixedRate10__1>map("getFxd", _interestRate33Choice__2 -> _interestRate33Choice__2.getFxd());
        if (exists(fxd).getOrDefault(false)) {
            return fxd.<InterestComputationMethodFormat7__1>map("getDayCnt", fixedRate10__1 -> fixedRate10__1.getDayCnt()).get();
        }
        final MapperS<FloatingRate13__2> fltg = MapperS.of(interestRate33Choice__2).<FloatingRate13__2>map("getFltg", _interestRate33Choice__2 -> _interestRate33Choice__2.getFltg());
        if (exists(fltg).getOrDefault(false)) {
            return fltg.<InterestComputationMethodFormat7__1>map("getDayCnt", floatingRate13__2 -> floatingRate13__2.getDayCnt()).get();
        }
        return null;
    }

}
