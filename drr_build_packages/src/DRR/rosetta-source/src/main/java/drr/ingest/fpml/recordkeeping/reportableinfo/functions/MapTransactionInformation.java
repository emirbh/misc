package drr.ingest.fpml.recordkeeping.reportableinfo.functions;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperC;
import com.rosetta.model.lib.mapper.MapperS;
import drr.base.trade.ExecutionVenueTypeEnum;
import drr.regulation.common.ReportableExecutionVenue;
import drr.regulation.common.SupervisoryBodyEnum;
import drr.regulation.common.TransactionInformation;
import fpml.consolidated.doc.ExecutionVenueType;
import fpml.consolidated.doc.PartyTradeInformation;
import fpml.consolidated.doc.ReportingRegime;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(MapTransactionInformation.MapTransactionInformationDefault.class)
public abstract class MapTransactionInformation implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;

	/**
	* @param fpmlPartyTradeInformation 
	* @param fpmlReportingRegime 
	* @param supervisoryBody 
	* @return transactionInformation 
	*/
	public TransactionInformation evaluate(List<? extends PartyTradeInformation> fpmlPartyTradeInformation, ReportingRegime fpmlReportingRegime, SupervisoryBodyEnum supervisoryBody) {
		TransactionInformation.TransactionInformationBuilder transactionInformationBuilder = doEvaluate(fpmlPartyTradeInformation, fpmlReportingRegime, supervisoryBody);
		
		final TransactionInformation transactionInformation;
		if (transactionInformationBuilder == null) {
			transactionInformation = null;
		} else {
			transactionInformation = transactionInformationBuilder.build();
			objectValidator.validate(TransactionInformation.class, transactionInformation);
		}
		
		return transactionInformation;
	}

	protected abstract TransactionInformation.TransactionInformationBuilder doEvaluate(List<? extends PartyTradeInformation> fpmlPartyTradeInformation, ReportingRegime fpmlReportingRegime, SupervisoryBodyEnum supervisoryBody);

	protected abstract MapperS<ExecutionVenueTypeEnum> executionVenueType(List<? extends PartyTradeInformation> fpmlPartyTradeInformation, ReportingRegime fpmlReportingRegime, SupervisoryBodyEnum supervisoryBody);

	protected abstract MapperS<Boolean> largeSizeTrade(List<? extends PartyTradeInformation> fpmlPartyTradeInformation, ReportingRegime fpmlReportingRegime, SupervisoryBodyEnum supervisoryBody);

	public static class MapTransactionInformationDefault extends MapTransactionInformation {
		@Override
		protected TransactionInformation.TransactionInformationBuilder doEvaluate(List<? extends PartyTradeInformation> fpmlPartyTradeInformation, ReportingRegime fpmlReportingRegime, SupervisoryBodyEnum supervisoryBody) {
			if (fpmlPartyTradeInformation == null) {
				fpmlPartyTradeInformation = Collections.emptyList();
			}
			TransactionInformation.TransactionInformationBuilder transactionInformation = TransactionInformation.builder();
			return assignOutput(transactionInformation, fpmlPartyTradeInformation, fpmlReportingRegime, supervisoryBody);
		}
		
		protected TransactionInformation.TransactionInformationBuilder assignOutput(TransactionInformation.TransactionInformationBuilder transactionInformation, List<? extends PartyTradeInformation> fpmlPartyTradeInformation, ReportingRegime fpmlReportingRegime, SupervisoryBodyEnum supervisoryBody) {
			transactionInformation = toBuilder(TransactionInformation.builder()
				.setTransactionIdentifier(null)
				.setPriorTransactionIdentifier(null)
				.setReportableExecutionVenue(ReportableExecutionVenue.builder()
					.setExecutionVenueType(executionVenueType(fpmlPartyTradeInformation, fpmlReportingRegime, supervisoryBody).get())
					.build())
				.setLargeSizeTrade(largeSizeTrade(fpmlPartyTradeInformation, fpmlReportingRegime, supervisoryBody).get())
				.setDuration(null)
				.build());
			
			return Optional.ofNullable(transactionInformation)
				.map(o -> o.prune())
				.orElse(null);
		}
		
		@Override
		protected MapperS<ExecutionVenueTypeEnum> executionVenueType(List<? extends PartyTradeInformation> fpmlPartyTradeInformation, ReportingRegime fpmlReportingRegime, SupervisoryBodyEnum supervisoryBody) {
			return MapperC.<PartyTradeInformation>of(fpmlPartyTradeInformation).<ExecutionVenueType>map("getExecutionVenueType", partyTradeInformation -> partyTradeInformation.getExecutionVenueType()).<String>map("getValue", _executionVenueType -> _executionVenueType.getValue())
				.first().checkedMap("to-enum", ExecutionVenueTypeEnum::fromDisplayName, IllegalArgumentException.class);
		}
		
		@Override
		protected MapperS<Boolean> largeSizeTrade(List<? extends PartyTradeInformation> fpmlPartyTradeInformation, ReportingRegime fpmlReportingRegime, SupervisoryBodyEnum supervisoryBody) {
			if (areEqual(MapperS.of(supervisoryBody), MapperS.of(SupervisoryBodyEnum.CFTC), CardinalityOperator.All).getOrDefault(false)) {
				return MapperC.<PartyTradeInformation>of(fpmlPartyTradeInformation).<Boolean>map("getLargeSizeTrade", partyTradeInformation -> partyTradeInformation.getLargeSizeTrade())
					.first();
			}
			return MapperS.<Boolean>ofNull();
		}
	}
}
