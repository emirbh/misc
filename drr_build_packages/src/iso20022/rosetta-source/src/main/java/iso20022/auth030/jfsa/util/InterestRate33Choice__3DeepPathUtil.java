package iso20022.auth030.jfsa.util;

import com.rosetta.model.lib.mapper.MapperS;
import iso20022.auth030.jfsa.FixedRate10__1;
import iso20022.auth030.jfsa.FloatingRate13__3;
import iso20022.auth030.jfsa.InterestComputationMethodFormat7__1;
import iso20022.auth030.jfsa.InterestRate33Choice__3;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

public class InterestRate33Choice__3DeepPathUtil {
    public InterestComputationMethodFormat7__1 chooseDayCnt(InterestRate33Choice__3 interestRate33Choice__3) {
        final MapperS<FixedRate10__1> fxd = MapperS.of(interestRate33Choice__3).<FixedRate10__1>map("getFxd", _interestRate33Choice__3 -> _interestRate33Choice__3.getFxd());
        if (exists(fxd).getOrDefault(false)) {
            return fxd.<InterestComputationMethodFormat7__1>map("getDayCnt", fixedRate10__1 -> fixedRate10__1.getDayCnt()).get();
        }
        final MapperS<FloatingRate13__3> fltg = MapperS.of(interestRate33Choice__3).<FloatingRate13__3>map("getFltg", _interestRate33Choice__3 -> _interestRate33Choice__3.getFltg());
        if (exists(fltg).getOrDefault(false)) {
            return fltg.<InterestComputationMethodFormat7__1>map("getDayCnt", floatingRate13__3 -> floatingRate13__3.getDayCnt()).get();
        }
        return null;
    }

}
