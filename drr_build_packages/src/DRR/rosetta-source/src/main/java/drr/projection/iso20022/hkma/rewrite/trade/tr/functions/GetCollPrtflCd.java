package drr.projection.iso20022.hkma.rewrite.trade.tr.functions;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import drr.regulation.hkma.rewrite.trade.HKMATransactionReport;
import iso20022.auth030.hkma.tr.CollateralPortfolioCode6Choice__1;
import iso20022.auth030.hkma.tr.MarginPortfolio4__1;
import iso20022.auth030.hkma.tr.NotApplicable1Code;
import iso20022.auth030.hkma.tr.PortfolioCode5Choice__1;
import iso20022.auth030.hkma.tr.PortfolioIdentification3__1;
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
	public CollateralPortfolioCode6Choice__1 evaluate(HKMATransactionReport drrReport) {
		CollateralPortfolioCode6Choice__1.CollateralPortfolioCode6Choice__1Builder collPrtflCdBuilder = doEvaluate(drrReport);
		
		final CollateralPortfolioCode6Choice__1 collPrtflCd;
		if (collPrtflCdBuilder == null) {
			collPrtflCd = null;
		} else {
			collPrtflCd = collPrtflCdBuilder.build();
			objectValidator.validate(CollateralPortfolioCode6Choice__1.class, collPrtflCd);
		}
		
		return collPrtflCd;
	}

	protected abstract CollateralPortfolioCode6Choice__1.CollateralPortfolioCode6Choice__1Builder doEvaluate(HKMATransactionReport drrReport);

	public static class GetCollPrtflCdDefault extends GetCollPrtflCd {
		@Override
		protected CollateralPortfolioCode6Choice__1.CollateralPortfolioCode6Choice__1Builder doEvaluate(HKMATransactionReport drrReport) {
			CollateralPortfolioCode6Choice__1.CollateralPortfolioCode6Choice__1Builder collPrtflCd = CollateralPortfolioCode6Choice__1.builder();
			return assignOutput(collPrtflCd, drrReport);
		}
		
		protected CollateralPortfolioCode6Choice__1.CollateralPortfolioCode6Choice__1Builder assignOutput(CollateralPortfolioCode6Choice__1.CollateralPortfolioCode6Choice__1Builder collPrtflCd, HKMATransactionReport drrReport) {
			PortfolioIdentification3__1 ifThenElseResult0 = null;
			if (areEqual(MapperS.of(drrReport).<Boolean>map("getCollateralPortfolioIndicator", hKMATransactionReport -> hKMATransactionReport.getCollateralPortfolioIndicator()), MapperS.of(true), CardinalityOperator.All).getOrDefault(false)) {
				ifThenElseResult0 = PortfolioIdentification3__1.builder()
					.setCd(MapperS.of(drrReport).<String>map("getInitialMarginCollateralPortfolioCode", hKMATransactionReport -> hKMATransactionReport.getInitialMarginCollateralPortfolioCode()).get())
					.build();
			}
			NotApplicable1Code ifThenElseResult1 = null;
			if (areEqual(MapperS.of(drrReport).<Boolean>map("getCollateralPortfolioIndicator", hKMATransactionReport -> hKMATransactionReport.getCollateralPortfolioIndicator()), MapperS.of(false), CardinalityOperator.All).getOrDefault(false)) {
				ifThenElseResult1 = NotApplicable1Code.NOAP;
			}
			PortfolioIdentification3__1 ifThenElseResult2 = null;
			if (areEqual(MapperS.of(drrReport).<Boolean>map("getCollateralPortfolioIndicator", hKMATransactionReport -> hKMATransactionReport.getCollateralPortfolioIndicator()), MapperS.of(true), CardinalityOperator.All).getOrDefault(false)) {
				ifThenElseResult2 = PortfolioIdentification3__1.builder()
					.setCd(MapperS.of(drrReport).<String>map("getVariationMarginCollateralPortfolioCode", hKMATransactionReport -> hKMATransactionReport.getVariationMarginCollateralPortfolioCode()).get())
					.build();
			}
			NotApplicable1Code ifThenElseResult3 = null;
			if (areEqual(MapperS.of(drrReport).<Boolean>map("getCollateralPortfolioIndicator", hKMATransactionReport -> hKMATransactionReport.getCollateralPortfolioIndicator()), MapperS.of(false), CardinalityOperator.All).getOrDefault(false)) {
				ifThenElseResult3 = NotApplicable1Code.NOAP;
			}
			collPrtflCd = toBuilder(CollateralPortfolioCode6Choice__1.builder()
				.setMrgnPrtflCd(MarginPortfolio4__1.builder()
					.setInitlMrgnPrtflCd(PortfolioCode5Choice__1.builder()
						.setPrtfl(ifThenElseResult0)
						.setNoPrtfl(ifThenElseResult1)
						.build())
					.setVartnMrgnPrtflCd(PortfolioCode5Choice__1.builder()
						.setPrtfl(ifThenElseResult2)
						.setNoPrtfl(ifThenElseResult3)
						.build())
					.build())
				.build());
			
			return Optional.ofNullable(collPrtflCd)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
