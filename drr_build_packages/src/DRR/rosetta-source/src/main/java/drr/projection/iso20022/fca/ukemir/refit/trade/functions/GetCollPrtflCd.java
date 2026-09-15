package drr.projection.iso20022.fca.ukemir.refit.trade.functions;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import drr.regulation.fca.ukemir.refit.trade.FCAUKEMIRTransactionReport;
import iso20022.auth030.fca.CollateralPortfolioCode5Choice__1;
import iso20022.auth030.fca.NotApplicable1Code;
import iso20022.auth030.fca.PortfolioCode3Choice;
import java.util.Optional;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(GetCollPrtflCd.GetCollPrtflCdDefault.class)
public abstract class GetCollPrtflCd implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;

	/**
	* @param drrReport 
	* @return collPrtflCd 
	*/
	public CollateralPortfolioCode5Choice__1 evaluate(FCAUKEMIRTransactionReport drrReport) {
		CollateralPortfolioCode5Choice__1.CollateralPortfolioCode5Choice__1Builder collPrtflCdBuilder = doEvaluate(drrReport);
		
		final CollateralPortfolioCode5Choice__1 collPrtflCd;
		if (collPrtflCdBuilder == null) {
			collPrtflCd = null;
		} else {
			collPrtflCd = collPrtflCdBuilder.build();
			objectValidator.validate(CollateralPortfolioCode5Choice__1.class, collPrtflCd);
		}
		
		return collPrtflCd;
	}

	protected abstract CollateralPortfolioCode5Choice__1.CollateralPortfolioCode5Choice__1Builder doEvaluate(FCAUKEMIRTransactionReport drrReport);

	public static class GetCollPrtflCdDefault extends GetCollPrtflCd {
		@Override
		protected CollateralPortfolioCode5Choice__1.CollateralPortfolioCode5Choice__1Builder doEvaluate(FCAUKEMIRTransactionReport drrReport) {
			CollateralPortfolioCode5Choice__1.CollateralPortfolioCode5Choice__1Builder collPrtflCd = CollateralPortfolioCode5Choice__1.builder();
			return assignOutput(collPrtflCd, drrReport);
		}
		
		protected CollateralPortfolioCode5Choice__1.CollateralPortfolioCode5Choice__1Builder assignOutput(CollateralPortfolioCode5Choice__1.CollateralPortfolioCode5Choice__1Builder collPrtflCd, FCAUKEMIRTransactionReport drrReport) {
			String ifThenElseResult0 = null;
			if (areEqual(MapperS.of(drrReport).<Boolean>map("getCollateralPortfolioIndicator", fCAUKEMIRTransactionReport -> fCAUKEMIRTransactionReport.getCollateralPortfolioIndicator()), MapperS.of(true), CardinalityOperator.All).getOrDefault(false)) {
				ifThenElseResult0 = MapperS.of(drrReport).<String>map("getCollateralPortfolioCode", fCAUKEMIRTransactionReport -> fCAUKEMIRTransactionReport.getCollateralPortfolioCode()).get();
			}
			NotApplicable1Code ifThenElseResult1 = null;
			if (areEqual(MapperS.of(drrReport).<Boolean>map("getCollateralPortfolioIndicator", fCAUKEMIRTransactionReport -> fCAUKEMIRTransactionReport.getCollateralPortfolioIndicator()), MapperS.of(false), CardinalityOperator.All).getOrDefault(false)) {
				ifThenElseResult1 = NotApplicable1Code.NOAP;
			}
			collPrtflCd = toBuilder(CollateralPortfolioCode5Choice__1.builder()
				.setPrtfl(PortfolioCode3Choice.builder()
					.setCd(ifThenElseResult0)
					.setNoPrtfl(ifThenElseResult1)
					.build())
				.build());
			
			return Optional.ofNullable(collPrtflCd)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
