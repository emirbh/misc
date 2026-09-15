package drr.projection.iso20022.hkma.rewrite.trade.tr.functions;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.records.Date;
import drr.regulation.common.UTIProprietarySchemeNameEnum;
import drr.regulation.hkma.rewrite.trade.HKMATransactionReport;
import drr.standards.iso.ConfirmationEnum;
import drr.standards.iso.DeliveryTypeEnum;
import iso20022.auth030.hkma.tr.GenericIdentification175__4;
import iso20022.auth030.hkma.tr.PhysicalTransferType4Code;
import iso20022.auth030.hkma.tr.TradeConfirmation4Choice__1;
import iso20022.auth030.hkma.tr.TradeConfirmation5__1;
import iso20022.auth030.hkma.tr.TradeConfirmationType1Code;
import iso20022.auth030.hkma.tr.TradeConfirmationType2Code;
import iso20022.auth030.hkma.tr.TradeNonConfirmation1;
import iso20022.auth030.hkma.tr.TradeTransaction50__2;
import iso20022.auth030.hkma.tr.UniqueTransactionIdentifier2Choice__1;
import java.util.ArrayList;
import java.util.Optional;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(Create_TradeTransaction50__2.Create_TradeTransaction50__2Default.class)
public abstract class Create_TradeTransaction50__2 implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected Create_AssetClassCommodity7Choice create_AssetClassCommodity7Choice;
	@Inject protected GetCcy getCcy;
	@Inject protected GetCdt getCdt;
	@Inject protected GetCollPrtflCd getCollPrtflCd;
	@Inject protected GetDerivEvt2 getDerivEvt2;
	@Inject protected GetExctnTmStmp getExctnTmStmp;
	@Inject protected GetFctvDt getFctvDt;
	@Inject protected GetIntrstRate getIntrstRate;
	@Inject protected GetNtnlAmt getNtnlAmt;
	@Inject protected GetNtnlQty getNtnlQty;
	@Inject protected GetOptn getOptn;
	@Inject protected GetOthrPmt getOthrPmt;
	@Inject protected GetPackg getPackg;
	@Inject protected GetPltfmIdr getPltfmIdr;
	@Inject protected GetPrrTxId getPrrTxId;
	@Inject protected GetTradClr getTradClr;
	@Inject protected GetTxId getTxId;
	@Inject protected GetTxPric getTxPric;
	@Inject protected GetXprtnDt getXprtnDt;

	/**
	* @param drrReport 
	* @return txData 
	*/
	public TradeTransaction50__2 evaluate(HKMATransactionReport drrReport) {
		TradeTransaction50__2.TradeTransaction50__2Builder txDataBuilder = doEvaluate(drrReport);
		
		final TradeTransaction50__2 txData;
		if (txDataBuilder == null) {
			txData = null;
		} else {
			txData = txDataBuilder.build();
			objectValidator.validate(TradeTransaction50__2.class, txData);
		}
		
		return txData;
	}

	protected abstract TradeTransaction50__2.TradeTransaction50__2Builder doEvaluate(HKMATransactionReport drrReport);

	public static class Create_TradeTransaction50__2Default extends Create_TradeTransaction50__2 {
		@Override
		protected TradeTransaction50__2.TradeTransaction50__2Builder doEvaluate(HKMATransactionReport drrReport) {
			TradeTransaction50__2.TradeTransaction50__2Builder txData = TradeTransaction50__2.builder();
			return assignOutput(txData, drrReport);
		}
		
		protected TradeTransaction50__2.TradeTransaction50__2Builder assignOutput(TradeTransaction50__2.TradeTransaction50__2Builder txData, HKMATransactionReport drrReport) {
			String ifThenElseResult0 = null;
			if (exists(MapperS.of(drrReport).<String>map("getUniqueTransactionIdentifierProprietary", hKMATransactionReport -> hKMATransactionReport.getUniqueTransactionIdentifierProprietary())).getOrDefault(false)) {
				ifThenElseResult0 = MapperS.of(drrReport).<String>map("getUniqueTransactionIdentifierProprietary", hKMATransactionReport -> hKMATransactionReport.getUniqueTransactionIdentifierProprietary()).get();
			}
			TradeConfirmationType1Code ifThenElseResult1 = null;
			if (notEqual(MapperS.of(drrReport).<ConfirmationEnum>map("getConfirmed", hKMATransactionReport -> hKMATransactionReport.getConfirmed()).map("to-string", ConfirmationEnum::toDisplayString), MapperS.of("NCNF"), CardinalityOperator.Any).getOrDefault(false)) {
				ifThenElseResult1 = MapperS.of(drrReport).<ConfirmationEnum>map("getConfirmed", hKMATransactionReport -> hKMATransactionReport.getConfirmed()).checkedMap("to-enum", e -> TradeConfirmationType1Code.valueOf(e.name()), IllegalArgumentException.class).get();
			}
			TradeConfirmationType2Code ifThenElseResult2 = null;
			if (areEqual(MapperS.of(drrReport).<ConfirmationEnum>map("getConfirmed", hKMATransactionReport -> hKMATransactionReport.getConfirmed()).map("to-string", ConfirmationEnum::toDisplayString), MapperS.of("NCNF"), CardinalityOperator.All).getOrDefault(false)) {
				ifThenElseResult2 = MapperS.of(drrReport).<ConfirmationEnum>map("getConfirmed", hKMATransactionReport -> hKMATransactionReport.getConfirmed()).checkedMap("to-enum", e -> TradeConfirmationType2Code.valueOf(e.name()), IllegalArgumentException.class).get();
			}
			txData = toBuilder(TradeTransaction50__2.builder()
				.setTxId(UniqueTransactionIdentifier2Choice__1.builder()
					.setUnqTxIdr(getTxId.evaluate(drrReport))
					.setPrtry(GenericIdentification175__4.builder()
						.setId(ifThenElseResult0)
						.setSchmeNm(MapperS.of(drrReport).<UTIProprietarySchemeNameEnum>map("getUniqueTransactionIdentifierProprietarySchemeName", hKMATransactionReport -> hKMATransactionReport.getUniqueTransactionIdentifierProprietarySchemeName()).map("to-string", UTIProprietarySchemeNameEnum::toDisplayString).get())
						.build())
					.build())
				.setPrrTxId(getPrrTxId.evaluate(drrReport))
				.setCollPrtflCd(getCollPrtflCd.evaluate(drrReport))
				.setPltfmIdr(getPltfmIdr.evaluate(drrReport))
				.setTxPric(getTxPric.evaluate(drrReport))
				.setNtnlAmt(getNtnlAmt.evaluate(drrReport))
				.setNtnlQty(getNtnlQty.evaluate(drrReport))
				.setExctnTmStmp(getExctnTmStmp.evaluate(drrReport))
				.setFctvDt(getFctvDt.evaluate(drrReport))
				.setXprtnDt(getXprtnDt.evaluate(drrReport))
				.setDerivEvt(getDerivEvt2.evaluate(drrReport))
				.setTradClr(getTradClr.evaluate(drrReport))
				.setIntrstRate(getIntrstRate.evaluate(drrReport))
				.setCcy(getCcy.evaluate(drrReport))
				.setOptn(getOptn.evaluate(drrReport))
				.setCdt(getCdt.evaluate(drrReport))
				.setOthrPmt(new ArrayList(getOthrPmt.evaluate(drrReport)))
				.setPackg(getPackg.evaluate(drrReport))
				.setScndryTxId(MapperS.of(drrReport).<String>map("getSecondaryTransactionIdentifier", hKMATransactionReport -> hKMATransactionReport.getSecondaryTransactionIdentifier()).get())
				.setDlvryTp(MapperS.of(drrReport).<DeliveryTypeEnum>map("getDeliveryType", hKMATransactionReport -> hKMATransactionReport.getDeliveryType()).checkedMap("to-enum", e -> PhysicalTransferType4Code.valueOf(e.name()), IllegalArgumentException.class).get())
				.setSttlmDt(MapperS.of(drrReport).<Date>map("getFinalContractualSettlementDate", hKMATransactionReport -> hKMATransactionReport.getFinalContractualSettlementDate()).get())
				.setTradConf(TradeConfirmation4Choice__1.builder()
					.setConfd(TradeConfirmation5__1.builder()
						.setTp(ifThenElseResult1)
						.build())
					.setNonConfd(TradeNonConfirmation1.builder()
						.setTp(ifThenElseResult2)
						.build())
					.build())
				.setNonStdsdTerm(MapperS.of(drrReport).<Boolean>map("getNonStandardizedTermIndicator", hKMATransactionReport -> hKMATransactionReport.getNonStandardizedTermIndicator()).get())
				.setCmmdty(create_AssetClassCommodity7Choice.evaluate(drrReport))
				.build());
			
			return Optional.ofNullable(txData)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
