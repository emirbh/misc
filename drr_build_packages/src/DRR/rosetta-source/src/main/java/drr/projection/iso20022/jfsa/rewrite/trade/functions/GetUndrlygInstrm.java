package drr.projection.iso20022.jfsa.rewrite.trade.functions;

import cdm.base.staticdata.asset.common.AssetIdTypeEnum;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import drr.base.trade.basket.BasketConstituentsReport;
import drr.base.util.string.functions.StringLength;
import drr.base.util.string.functions.SubString;
import drr.regulation.common.trade.underlier.UnderlyingIdentificationTypeEnum;
import drr.regulation.jfsa.rewrite.trade.JFSATransactionReport;
import drr.standards.iso.IndexEnum;
import iso20022.auth030.jfsa.BasketConstituents3__1;
import iso20022.auth030.jfsa.CustomBasket4__1;
import iso20022.auth030.jfsa.GenericIdentification184;
import iso20022.auth030.jfsa.IndexIdentification1__1;
import iso20022.auth030.jfsa.InstrumentIdentification6Choice__1;
import iso20022.auth030.jfsa.SecurityIdentification41Choice__1;
import java.util.Optional;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(GetUndrlygInstrm.GetUndrlygInstrmDefault.class)
public abstract class GetUndrlygInstrm implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected StringLength stringLength;
	@Inject protected SubString subString;

	/**
	* @param drrReport 
	* @return undrlygInstrm 
	*/
	public SecurityIdentification41Choice__1 evaluate(JFSATransactionReport drrReport) {
		SecurityIdentification41Choice__1.SecurityIdentification41Choice__1Builder undrlygInstrmBuilder = doEvaluate(drrReport);
		
		final SecurityIdentification41Choice__1 undrlygInstrm;
		if (undrlygInstrmBuilder == null) {
			undrlygInstrm = null;
		} else {
			undrlygInstrm = undrlygInstrmBuilder.build();
			objectValidator.validate(SecurityIdentification41Choice__1.class, undrlygInstrm);
		}
		
		return undrlygInstrm;
	}

	protected abstract SecurityIdentification41Choice__1.SecurityIdentification41Choice__1Builder doEvaluate(JFSATransactionReport drrReport);

	public static class GetUndrlygInstrmDefault extends GetUndrlygInstrm {
		@Override
		protected SecurityIdentification41Choice__1.SecurityIdentification41Choice__1Builder doEvaluate(JFSATransactionReport drrReport) {
			SecurityIdentification41Choice__1.SecurityIdentification41Choice__1Builder undrlygInstrm = SecurityIdentification41Choice__1.builder();
			return assignOutput(undrlygInstrm, drrReport);
		}
		
		protected SecurityIdentification41Choice__1.SecurityIdentification41Choice__1Builder assignOutput(SecurityIdentification41Choice__1.SecurityIdentification41Choice__1Builder undrlygInstrm, JFSATransactionReport drrReport) {
			String ifThenElseResult0 = null;
			if (areEqual(MapperS.of(drrReport).<UnderlyingIdentificationTypeEnum>map("getUnderlyingIdentificationType", jFSATransactionReport -> jFSATransactionReport.getUnderlyingIdentificationType()), MapperS.of(UnderlyingIdentificationTypeEnum.I), CardinalityOperator.All).getOrDefault(false)) {
				ifThenElseResult0 = MapperS.of(drrReport).<String>map("getUnderlyingIdentification", jFSATransactionReport -> jFSATransactionReport.getUnderlyingIdentification()).get();
			}
			String ifThenElseResult1 = null;
			if (areEqual(MapperS.of(drrReport).<UnderlyingIdentificationTypeEnum>map("getUnderlyingIdentificationType", jFSATransactionReport -> jFSATransactionReport.getUnderlyingIdentificationType()), MapperS.of(UnderlyingIdentificationTypeEnum.X), CardinalityOperator.All).getOrDefault(false)) {
				ifThenElseResult1 = MapperS.of(drrReport).<IndexEnum>map("getUnderlyingIndexIndicator", jFSATransactionReport -> jFSATransactionReport.getUnderlyingIndexIndicator()).map("to-string", IndexEnum::toDisplayString).get();
			}
			String ifThenElseResult2 = null;
			if (areEqual(MapperS.of(drrReport).<UnderlyingIdentificationTypeEnum>map("getUnderlyingIdentificationType", jFSATransactionReport -> jFSATransactionReport.getUnderlyingIdentificationType()), MapperS.of(UnderlyingIdentificationTypeEnum.X), CardinalityOperator.All).getOrDefault(false)) {
				ifThenElseResult2 = MapperS.of(drrReport).<String>map("getNameOfTheUnderlyingIndex", jFSATransactionReport -> jFSATransactionReport.getNameOfTheUnderlyingIndex()).get();
			}
			String ifThenElseResult3 = null;
			if (areEqual(MapperS.of(drrReport).<UnderlyingIdentificationTypeEnum>map("getUnderlyingIdentificationType", jFSATransactionReport -> jFSATransactionReport.getUnderlyingIdentificationType()), MapperS.of(UnderlyingIdentificationTypeEnum.X), CardinalityOperator.All).getOrDefault(false)) {
				ifThenElseResult3 = MapperS.of(drrReport).<String>map("getUnderlyingIdentification", jFSATransactionReport -> jFSATransactionReport.getUnderlyingIdentification()).map("to-string", Object::toString).get();
			}
			String ifThenElseResult4 = null;
			if (greaterThan(MapperS.of(stringLength.evaluate(MapperS.of(drrReport).<String>map("getCustomBasketCode", jFSATransactionReport -> jFSATransactionReport.getCustomBasketCode()).get())), MapperS.of(20), CardinalityOperator.All).getOrDefault(false)) {
				ifThenElseResult4 = subString.evaluate(MapperS.of(drrReport).<String>map("getCustomBasketCode", jFSATransactionReport -> jFSATransactionReport.getCustomBasketCode()).get(), 21, 52);
			}
			undrlygInstrm = toBuilder(SecurityIdentification41Choice__1.builder()
				.setIsin(ifThenElseResult0)
				.setIndx(IndexIdentification1__1.builder()
					.setIndx(ifThenElseResult1)
					.setNm(ifThenElseResult2)
					.setIsin(ifThenElseResult3)
					.build())
				.setBskt(CustomBasket4__1.builder()
					.setStrr(subString.evaluate(MapperS.of(drrReport).<String>map("getCustomBasketCode", jFSATransactionReport -> jFSATransactionReport.getCustomBasketCode()).get(), 1, 20))
					.setId(ifThenElseResult4)
					.setCnsttnts(MapperS.of(drrReport).<BasketConstituentsReport>mapC("getBasketConstituents", jFSATransactionReport -> jFSATransactionReport.getBasketConstituents())
						.mapItem(item -> {
							String _ifThenElseResult0 = null;
							if (areEqual(item.<AssetIdTypeEnum>map("getSource", basketConstituentsReport -> basketConstituentsReport.getSource()), MapperS.of(AssetIdTypeEnum.ISIN), CardinalityOperator.All).getOrDefault(false)) {
								_ifThenElseResult0 = item.<String>map("getIdentifier", basketConstituentsReport -> basketConstituentsReport.getIdentifier()).get();
							}
							String _ifThenElseResult1 = null;
							if (notEqual(item.<AssetIdTypeEnum>map("getSource", basketConstituentsReport -> basketConstituentsReport.getSource()), MapperS.of(AssetIdTypeEnum.ISIN), CardinalityOperator.Any).getOrDefault(false)) {
								_ifThenElseResult1 = item.<String>map("getIdentifier", basketConstituentsReport -> basketConstituentsReport.getIdentifier()).get();
							}
							String _ifThenElseResult2 = null;
							if (notEqual(item.<AssetIdTypeEnum>map("getSource", basketConstituentsReport -> basketConstituentsReport.getSource()), MapperS.of(AssetIdTypeEnum.ISIN), CardinalityOperator.Any).getOrDefault(false)) {
								_ifThenElseResult2 = item.<AssetIdTypeEnum>map("getSource", basketConstituentsReport -> basketConstituentsReport.getSource()).map("to-string", AssetIdTypeEnum::toDisplayString).get();
							}
							return MapperS.of(BasketConstituents3__1.builder()
								.setInstrmId(InstrumentIdentification6Choice__1.builder()
									.setIsin(_ifThenElseResult0)
									.setOthrId(GenericIdentification184.builder()
										.setId(_ifThenElseResult1)
										.setSrc(_ifThenElseResult2)
										.build())
									.build())
								.build());
						}).getMulti())
					.build())
				.build());
			
			return Optional.ofNullable(undrlygInstrm)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
