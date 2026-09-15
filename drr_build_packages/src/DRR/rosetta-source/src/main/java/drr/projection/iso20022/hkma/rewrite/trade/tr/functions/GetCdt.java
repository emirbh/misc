package drr.projection.iso20022.hkma.rewrite.trade.tr.functions;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import drr.regulation.common.ReferenceEntityFormatEnum;
import drr.regulation.hkma.rewrite.trade.HKMATransactionReport;
import drr.standards.iso.SeniorityEnum;
import iso20022.auth030.hkma.tr.CreditDerivative4__1;
import iso20022.auth030.hkma.tr.DebtInstrumentSeniorityType2Code;
import iso20022.auth030.hkma.tr.DerivativePartyIdentification1Choice;
import iso20022.auth030.hkma.tr.Tranche3;
import iso20022.auth030.hkma.tr.TrancheIndicator3Choice__1;
import java.math.BigDecimal;
import java.util.Optional;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(GetCdt.GetCdtDefault.class)
public abstract class GetCdt implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;

	/**
	* @param drrReport 
	* @return cdt 
	*/
	public CreditDerivative4__1 evaluate(HKMATransactionReport drrReport) {
		CreditDerivative4__1.CreditDerivative4__1Builder cdtBuilder = doEvaluate(drrReport);
		
		final CreditDerivative4__1 cdt;
		if (cdtBuilder == null) {
			cdt = null;
		} else {
			cdt = cdtBuilder.build();
			objectValidator.validate(CreditDerivative4__1.class, cdt);
		}
		
		return cdt;
	}

	protected abstract CreditDerivative4__1.CreditDerivative4__1Builder doEvaluate(HKMATransactionReport drrReport);

	public static class GetCdtDefault extends GetCdt {
		@Override
		protected CreditDerivative4__1.CreditDerivative4__1Builder doEvaluate(HKMATransactionReport drrReport) {
			CreditDerivative4__1.CreditDerivative4__1Builder cdt = CreditDerivative4__1.builder();
			return assignOutput(cdt, drrReport);
		}
		
		protected CreditDerivative4__1.CreditDerivative4__1Builder assignOutput(CreditDerivative4__1.CreditDerivative4__1Builder cdt, HKMATransactionReport drrReport) {
			String ifThenElseResult0 = null;
			if (areEqual(MapperS.of(drrReport).<ReferenceEntityFormatEnum>map("getReferenceEntityFormat", hKMATransactionReport -> hKMATransactionReport.getReferenceEntityFormat()), MapperS.of(ReferenceEntityFormatEnum.COUNTRY), CardinalityOperator.All).getOrDefault(false)) {
				ifThenElseResult0 = MapperS.of(drrReport).<String>map("getReferenceEntity", hKMATransactionReport -> hKMATransactionReport.getReferenceEntity()).get();
			}
			String ifThenElseResult1 = null;
			if (areEqual(MapperS.of(drrReport).<ReferenceEntityFormatEnum>map("getReferenceEntityFormat", hKMATransactionReport -> hKMATransactionReport.getReferenceEntityFormat()), MapperS.of(ReferenceEntityFormatEnum.LEI), CardinalityOperator.All).getOrDefault(false)) {
				ifThenElseResult1 = MapperS.of(drrReport).<String>map("getReferenceEntity", hKMATransactionReport -> hKMATransactionReport.getReferenceEntity()).get();
			}
			cdt = toBuilder(CreditDerivative4__1.builder()
				.setIndxFctr(MapperS.of(drrReport).<BigDecimal>map("getIndexFactor", hKMATransactionReport -> hKMATransactionReport.getIndexFactor()).get())
				.setTrch(TrancheIndicator3Choice__1.builder()
					.setTrnchd(Tranche3.builder()
						.setAttchmntPt(MapperS.of(drrReport).<BigDecimal>map("getCdSIndexAttachmentPoint", hKMATransactionReport -> hKMATransactionReport.getCdSIndexAttachmentPoint()).get())
						.setDtchmntPt(MapperS.of(drrReport).<BigDecimal>map("getCdSIndexDetachmentPoint", hKMATransactionReport -> hKMATransactionReport.getCdSIndexDetachmentPoint()).get())
						.build())
					.build())
				.setSnrty(MapperS.of(drrReport).<SeniorityEnum>map("getSeniority", hKMATransactionReport -> hKMATransactionReport.getSeniority()).checkedMap("to-enum", e -> DebtInstrumentSeniorityType2Code.valueOf(e.name()), IllegalArgumentException.class).get())
				.setRefPty(DerivativePartyIdentification1Choice.builder()
					.setCtry(ifThenElseResult0)
					.setCtrySubDvsn(null)
					.setLei(ifThenElseResult1)
					.build())
				.setSrs(MapperS.of(drrReport).<Integer>map("getSeries", hKMATransactionReport -> hKMATransactionReport.getSeries()).get())
				.setVrsn(MapperS.of(drrReport).<Integer>map("getSeriesVersion", hKMATransactionReport -> hKMATransactionReport.getSeriesVersion()).get())
				.build());
			
			return Optional.ofNullable(cdt)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
