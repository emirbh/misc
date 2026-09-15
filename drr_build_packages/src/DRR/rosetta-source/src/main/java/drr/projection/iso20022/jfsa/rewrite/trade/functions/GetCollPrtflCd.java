package drr.projection.iso20022.jfsa.rewrite.trade.functions;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import drr.regulation.jfsa.rewrite.trade.JFSATransactionReport;
import iso20022.auth030.jfsa.CollateralPortfolioCode6Choice__1;
import iso20022.auth030.jfsa.MarginPortfolio4__1;
import iso20022.auth030.jfsa.NotApplicable1Code;
import iso20022.auth030.jfsa.PortfolioCode5Choice__1;
import iso20022.auth030.jfsa.PortfolioIdentification3__1;
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
	public CollateralPortfolioCode6Choice__1 evaluate(JFSATransactionReport drrReport) {
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

	protected abstract CollateralPortfolioCode6Choice__1.CollateralPortfolioCode6Choice__1Builder doEvaluate(JFSATransactionReport drrReport);

	public static class GetCollPrtflCdDefault extends GetCollPrtflCd {
		@Override
		protected CollateralPortfolioCode6Choice__1.CollateralPortfolioCode6Choice__1Builder doEvaluate(JFSATransactionReport drrReport) {
			CollateralPortfolioCode6Choice__1.CollateralPortfolioCode6Choice__1Builder collPrtflCd = CollateralPortfolioCode6Choice__1.builder();
			return assignOutput(collPrtflCd, drrReport);
		}
		
		protected CollateralPortfolioCode6Choice__1.CollateralPortfolioCode6Choice__1Builder assignOutput(CollateralPortfolioCode6Choice__1.CollateralPortfolioCode6Choice__1Builder collPrtflCd, JFSATransactionReport drrReport) {
			String ifThenElseResult0 = null;
			if (areEqual(MapperS.of(drrReport).<Boolean>map("getCollateralPortfolioIndicator", jFSATransactionReport -> jFSATransactionReport.getCollateralPortfolioIndicator()), MapperS.of(true), CardinalityOperator.All).andNullSafe(exists(MapperS.of(drrReport).<String>map("getInitialMarginCollateralPortfolioCode", jFSATransactionReport -> jFSATransactionReport.getInitialMarginCollateralPortfolioCode()))).getOrDefault(false)) {
				ifThenElseResult0 = MapperS.of(drrReport).<String>map("getInitialMarginCollateralPortfolioCode", jFSATransactionReport -> jFSATransactionReport.getInitialMarginCollateralPortfolioCode()).get();
			}
			NotApplicable1Code ifThenElseResult1 = null;
			if (areEqual(MapperS.of(drrReport).<Boolean>map("getCollateralPortfolioIndicator", jFSATransactionReport -> jFSATransactionReport.getCollateralPortfolioIndicator()), MapperS.of(false), CardinalityOperator.All).orNullSafe(areEqual(areEqual(MapperS.of(drrReport).<Boolean>map("getCollateralPortfolioIndicator", jFSATransactionReport -> jFSATransactionReport.getCollateralPortfolioIndicator()), MapperS.of(true), CardinalityOperator.All).andNullSafe(exists(MapperS.of(drrReport).<String>map("getInitialMarginCollateralPortfolioCode", jFSATransactionReport -> jFSATransactionReport.getInitialMarginCollateralPortfolioCode()))), MapperS.of(false), CardinalityOperator.All)).getOrDefault(false)) {
				ifThenElseResult1 = NotApplicable1Code.NOAP;
			}
			String ifThenElseResult2 = null;
			if (areEqual(MapperS.of(drrReport).<Boolean>map("getCollateralPortfolioIndicator", jFSATransactionReport -> jFSATransactionReport.getCollateralPortfolioIndicator()), MapperS.of(true), CardinalityOperator.All).andNullSafe(exists(MapperS.of(drrReport).<String>map("getVariationMarginCollateralPortfolioCode", jFSATransactionReport -> jFSATransactionReport.getVariationMarginCollateralPortfolioCode()))).getOrDefault(false)) {
				ifThenElseResult2 = MapperS.of(drrReport).<String>map("getVariationMarginCollateralPortfolioCode", jFSATransactionReport -> jFSATransactionReport.getVariationMarginCollateralPortfolioCode()).get();
			}
			NotApplicable1Code ifThenElseResult3 = null;
			if (areEqual(MapperS.of(drrReport).<Boolean>map("getCollateralPortfolioIndicator", jFSATransactionReport -> jFSATransactionReport.getCollateralPortfolioIndicator()), MapperS.of(false), CardinalityOperator.All).orNullSafe(areEqual(areEqual(MapperS.of(drrReport).<Boolean>map("getCollateralPortfolioIndicator", jFSATransactionReport -> jFSATransactionReport.getCollateralPortfolioIndicator()), MapperS.of(true), CardinalityOperator.All).andNullSafe(exists(MapperS.of(drrReport).<String>map("getVariationMarginCollateralPortfolioCode", jFSATransactionReport -> jFSATransactionReport.getVariationMarginCollateralPortfolioCode()))), MapperS.of(false), CardinalityOperator.All)).getOrDefault(false)) {
				ifThenElseResult3 = NotApplicable1Code.NOAP;
			}
			collPrtflCd = toBuilder(CollateralPortfolioCode6Choice__1.builder()
				.setMrgnPrtflCd(MarginPortfolio4__1.builder()
					.setInitlMrgnPrtflCd(PortfolioCode5Choice__1.builder()
						.setPrtfl(PortfolioIdentification3__1.builder()
							.setCd(ifThenElseResult0)
							.build())
						.setNoPrtfl(ifThenElseResult1)
						.build())
					.setVartnMrgnPrtflCd(PortfolioCode5Choice__1.builder()
						.setPrtfl(PortfolioIdentification3__1.builder()
							.setCd(ifThenElseResult2)
							.build())
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
