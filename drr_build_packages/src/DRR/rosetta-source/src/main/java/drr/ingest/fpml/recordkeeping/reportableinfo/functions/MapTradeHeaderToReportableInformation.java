package drr.ingest.fpml.recordkeeping.reportableinfo.functions;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperC;
import com.rosetta.model.lib.mapper.MapperListOfLists;
import com.rosetta.model.lib.mapper.MapperS;
import drr.base.trade.ConfirmationMethodEnum;
import drr.base.trade.PartyInformation;
import drr.regulation.common.ReportableInformation;
import drr.regulation.common.ReportableJurisdictionInformation;
import fpml.consolidated.asset.BasicQuotation;
import fpml.consolidated.business.events.Withdrawal;
import fpml.consolidated.business.events.WithdrawalPartyTradeInformation;
import fpml.consolidated.business.events.WithdrawalReason;
import fpml.consolidated.doc.ConfirmationMethod;
import fpml.consolidated.doc.ExecutionDateTime;
import fpml.consolidated.doc.PartyRelationshipType;
import fpml.consolidated.doc.PartyTradeInformation;
import fpml.consolidated.doc.ReportingRegime;
import fpml.consolidated.doc.TradeHeader;
import fpml.consolidated.msg.RequestMessageHeader;
import fpml.consolidated.shared.Party;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(MapTradeHeaderToReportableInformation.MapTradeHeaderToReportableInformationDefault.class)
public abstract class MapTradeHeaderToReportableInformation implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapLastAvailableSpotPriceToPriceSchedule mapLastAvailableSpotPriceToPriceSchedule;
	@Inject protected MapPartyTradeInformationListToReportableJurisdictionInformation mapPartyTradeInformationListToReportableJurisdictionInformation;
	@Inject protected MapPartyTradeInformationToIntragroup mapPartyTradeInformationToIntragroup;
	@Inject protected MapPartyTradeInformationToPartyInformation mapPartyTradeInformationToPartyInformation;
	@Inject protected MapReportableActionEnum mapReportableActionEnum;
	@Inject protected MapWithdrawalPartyTradeInformationToPartyInformation mapWithdrawalPartyTradeInformationToPartyInformation;
	@Inject protected MapWithdrawalPartyTradeInformationToReportableJurisdictionInformation mapWithdrawalPartyTradeInformationToReportableJurisdictionInformation;

	/**
	* @param fpmlTradeHeader 
	* @param fpmlWithdrawal 
	* @param fpmlPartyList 
	* @param fpmlQuote 
	* @param fpmlRequestMessageHeader 
	* @return reportableInformation 
	*/
	public ReportableInformation evaluate(TradeHeader fpmlTradeHeader, Withdrawal fpmlWithdrawal, List<? extends Party> fpmlPartyList, List<? extends BasicQuotation> fpmlQuote, RequestMessageHeader fpmlRequestMessageHeader) {
		ReportableInformation.ReportableInformationBuilder reportableInformationBuilder = doEvaluate(fpmlTradeHeader, fpmlWithdrawal, fpmlPartyList, fpmlQuote, fpmlRequestMessageHeader);
		
		final ReportableInformation reportableInformation;
		if (reportableInformationBuilder == null) {
			reportableInformation = null;
		} else {
			reportableInformation = reportableInformationBuilder.build();
			objectValidator.validate(ReportableInformation.class, reportableInformation);
		}
		
		return reportableInformation;
	}

	protected abstract ReportableInformation.ReportableInformationBuilder doEvaluate(TradeHeader fpmlTradeHeader, Withdrawal fpmlWithdrawal, List<? extends Party> fpmlPartyList, List<? extends BasicQuotation> fpmlQuote, RequestMessageHeader fpmlRequestMessageHeader);

	protected abstract MapperC<? extends PartyTradeInformation> fpmlPartyTradeInformation(TradeHeader fpmlTradeHeader, Withdrawal fpmlWithdrawal, List<? extends Party> fpmlPartyList, List<? extends BasicQuotation> fpmlQuote, RequestMessageHeader fpmlRequestMessageHeader);

	protected abstract MapperC<? extends WithdrawalPartyTradeInformation> fpmlWithdrawalPartyTradeInformation(TradeHeader fpmlTradeHeader, Withdrawal fpmlWithdrawal, List<? extends Party> fpmlPartyList, List<? extends BasicQuotation> fpmlQuote, RequestMessageHeader fpmlRequestMessageHeader);

	protected abstract MapperC<? extends PartyInformation> globalPartyInformation(TradeHeader fpmlTradeHeader, Withdrawal fpmlWithdrawal, List<? extends Party> fpmlPartyList, List<? extends BasicQuotation> fpmlQuote, RequestMessageHeader fpmlRequestMessageHeader);

	protected abstract MapperS<ConfirmationMethodEnum> confirmationMethod(TradeHeader fpmlTradeHeader, Withdrawal fpmlWithdrawal, List<? extends Party> fpmlPartyList, List<? extends BasicQuotation> fpmlQuote, RequestMessageHeader fpmlRequestMessageHeader);

	protected abstract MapperS<ZonedDateTime> originalExecutionTimestamp(TradeHeader fpmlTradeHeader, Withdrawal fpmlWithdrawal, List<? extends Party> fpmlPartyList, List<? extends BasicQuotation> fpmlQuote, RequestMessageHeader fpmlRequestMessageHeader);

	protected abstract MapperS<Boolean> affiliated(TradeHeader fpmlTradeHeader, Withdrawal fpmlWithdrawal, List<? extends Party> fpmlPartyList, List<? extends BasicQuotation> fpmlQuote, RequestMessageHeader fpmlRequestMessageHeader);

	protected abstract MapperC<? extends ReportableJurisdictionInformation> jurisdictionInformation(TradeHeader fpmlTradeHeader, Withdrawal fpmlWithdrawal, List<? extends Party> fpmlPartyList, List<? extends BasicQuotation> fpmlQuote, RequestMessageHeader fpmlRequestMessageHeader);

	public static class MapTradeHeaderToReportableInformationDefault extends MapTradeHeaderToReportableInformation {
		@Override
		protected ReportableInformation.ReportableInformationBuilder doEvaluate(TradeHeader fpmlTradeHeader, Withdrawal fpmlWithdrawal, List<? extends Party> fpmlPartyList, List<? extends BasicQuotation> fpmlQuote, RequestMessageHeader fpmlRequestMessageHeader) {
			if (fpmlPartyList == null) {
				fpmlPartyList = Collections.emptyList();
			}
			if (fpmlQuote == null) {
				fpmlQuote = Collections.emptyList();
			}
			ReportableInformation.ReportableInformationBuilder reportableInformation = ReportableInformation.builder();
			return assignOutput(reportableInformation, fpmlTradeHeader, fpmlWithdrawal, fpmlPartyList, fpmlQuote, fpmlRequestMessageHeader);
		}
		
		protected ReportableInformation.ReportableInformationBuilder assignOutput(ReportableInformation.ReportableInformationBuilder reportableInformation, TradeHeader fpmlTradeHeader, Withdrawal fpmlWithdrawal, List<? extends Party> fpmlPartyList, List<? extends BasicQuotation> fpmlQuote, RequestMessageHeader fpmlRequestMessageHeader) {
			reportableInformation = toBuilder(ReportableInformation.builder()
				.setReportableAction(MapperS.of(fpmlWithdrawal).<WithdrawalReason>mapC("getReason", withdrawal -> withdrawal.getReason()).<String>map("getValue", withdrawalReason -> withdrawalReason.getValue())
					.first()
					.mapSingleToItem(item -> MapperS.of(mapReportableActionEnum.evaluate(item.get()))).get())
				.setGlobalPartyInformation(new ArrayList<>(globalPartyInformation(fpmlTradeHeader, fpmlWithdrawal, fpmlPartyList, fpmlQuote, fpmlRequestMessageHeader).getMulti()))
				.setJurisdictionInformation(new ArrayList<>(jurisdictionInformation(fpmlTradeHeader, fpmlWithdrawal, fpmlPartyList, fpmlQuote, fpmlRequestMessageHeader).getMulti()))
				.setConfirmationMethod(confirmationMethod(fpmlTradeHeader, fpmlWithdrawal, fpmlPartyList, fpmlQuote, fpmlRequestMessageHeader).get())
				.setOriginalExecutionTimestamp(originalExecutionTimestamp(fpmlTradeHeader, fpmlWithdrawal, fpmlPartyList, fpmlQuote, fpmlRequestMessageHeader).get())
				.setIntragroup(mapPartyTradeInformationToIntragroup.evaluate(fpmlPartyTradeInformation(fpmlTradeHeader, fpmlWithdrawal, fpmlPartyList, fpmlQuote, fpmlRequestMessageHeader).getMulti()))
				.setAffiliated(affiliated(fpmlTradeHeader, fpmlWithdrawal, fpmlPartyList, fpmlQuote, fpmlRequestMessageHeader).get())
				.setUnderlyingAssetLastAvailableSpotPrice(mapLastAvailableSpotPriceToPriceSchedule.evaluate(fpmlQuote))
				.build());
			
			return Optional.ofNullable(reportableInformation)
				.map(o -> o.prune())
				.orElse(null);
		}
		
		@Override
		protected MapperC<? extends PartyTradeInformation> fpmlPartyTradeInformation(TradeHeader fpmlTradeHeader, Withdrawal fpmlWithdrawal, List<? extends Party> fpmlPartyList, List<? extends BasicQuotation> fpmlQuote, RequestMessageHeader fpmlRequestMessageHeader) {
			return MapperS.of(fpmlTradeHeader).<PartyTradeInformation>mapC("getPartyTradeInformation", tradeHeader -> tradeHeader.getPartyTradeInformation());
		}
		
		@Override
		protected MapperC<? extends WithdrawalPartyTradeInformation> fpmlWithdrawalPartyTradeInformation(TradeHeader fpmlTradeHeader, Withdrawal fpmlWithdrawal, List<? extends Party> fpmlPartyList, List<? extends BasicQuotation> fpmlQuote, RequestMessageHeader fpmlRequestMessageHeader) {
			return MapperS.of(fpmlWithdrawal).<WithdrawalPartyTradeInformation>mapC("getPartyTradeInformation", withdrawal -> withdrawal.getPartyTradeInformation());
		}
		
		@Override
		protected MapperC<? extends PartyInformation> globalPartyInformation(TradeHeader fpmlTradeHeader, Withdrawal fpmlWithdrawal, List<? extends Party> fpmlPartyList, List<? extends BasicQuotation> fpmlQuote, RequestMessageHeader fpmlRequestMessageHeader) {
			if (exists(fpmlPartyTradeInformation(fpmlTradeHeader, fpmlWithdrawal, fpmlPartyList, fpmlQuote, fpmlRequestMessageHeader)).getOrDefault(false)) {
				return fpmlPartyTradeInformation(fpmlTradeHeader, fpmlWithdrawal, fpmlPartyList, fpmlQuote, fpmlRequestMessageHeader)
					.mapItem(item -> MapperS.of(mapPartyTradeInformationToPartyInformation.evaluate(item.get(), fpmlPartyList, fpmlRequestMessageHeader)));
			}
			if (exists(fpmlWithdrawalPartyTradeInformation(fpmlTradeHeader, fpmlWithdrawal, fpmlPartyList, fpmlQuote, fpmlRequestMessageHeader)).getOrDefault(false)) {
				return fpmlWithdrawalPartyTradeInformation(fpmlTradeHeader, fpmlWithdrawal, fpmlPartyList, fpmlQuote, fpmlRequestMessageHeader)
					.mapItem(item -> MapperS.of(mapWithdrawalPartyTradeInformationToPartyInformation.evaluate(item.get())));
			}
			return MapperC.<PartyInformation>ofNull();
		}
		
		@Override
		protected MapperS<ConfirmationMethodEnum> confirmationMethod(TradeHeader fpmlTradeHeader, Withdrawal fpmlWithdrawal, List<? extends Party> fpmlPartyList, List<? extends BasicQuotation> fpmlQuote, RequestMessageHeader fpmlRequestMessageHeader) {
			return fpmlPartyTradeInformation(fpmlTradeHeader, fpmlWithdrawal, fpmlPartyList, fpmlQuote, fpmlRequestMessageHeader).<ConfirmationMethod>map("getConfirmationMethod", partyTradeInformation -> partyTradeInformation.getConfirmationMethod()).<String>map("getValue", _confirmationMethod -> _confirmationMethod.getValue())
				.first().checkedMap("to-enum", ConfirmationMethodEnum::fromDisplayName, IllegalArgumentException.class);
		}
		
		@Override
		protected MapperS<ZonedDateTime> originalExecutionTimestamp(TradeHeader fpmlTradeHeader, Withdrawal fpmlWithdrawal, List<? extends Party> fpmlPartyList, List<? extends BasicQuotation> fpmlQuote, RequestMessageHeader fpmlRequestMessageHeader) {
			return fpmlPartyTradeInformation(fpmlTradeHeader, fpmlWithdrawal, fpmlPartyList, fpmlQuote, fpmlRequestMessageHeader).<ExecutionDateTime>map("getExecutionDateTime", partyTradeInformation -> partyTradeInformation.getExecutionDateTime()).<ZonedDateTime>map("getValue", executionDateTime -> executionDateTime.getValue())
				.first();
		}
		
		@Override
		protected MapperS<Boolean> affiliated(TradeHeader fpmlTradeHeader, Withdrawal fpmlWithdrawal, List<? extends Party> fpmlPartyList, List<? extends BasicQuotation> fpmlQuote, RequestMessageHeader fpmlRequestMessageHeader) {
			final MapperC<PartyRelationshipType> thenArg = fpmlPartyTradeInformation(fpmlTradeHeader, fpmlWithdrawal, fpmlPartyList, fpmlQuote, fpmlRequestMessageHeader).<ReportingRegime>mapC("getReportingRegime", partyTradeInformation -> partyTradeInformation.getReportingRegime()).<PartyRelationshipType>map("getTradePartyRelationshipType", reportingRegime -> reportingRegime.getTradePartyRelationshipType())
				.filterItemNullSafe(item -> areEqual(item.<String>map("getValue", partyRelationshipType -> partyRelationshipType.getValue()), MapperS.of("Affiliated"), CardinalityOperator.All).get());
			if (exists(thenArg).asMapper().getOrDefault(false)) {
				return MapperS.of(true);
			}
			return MapperS.<Boolean>ofNull();
		}
		
		@Override
		protected MapperC<? extends ReportableJurisdictionInformation> jurisdictionInformation(TradeHeader fpmlTradeHeader, Withdrawal fpmlWithdrawal, List<? extends Party> fpmlPartyList, List<? extends BasicQuotation> fpmlQuote, RequestMessageHeader fpmlRequestMessageHeader) {
			if (exists(fpmlPartyTradeInformation(fpmlTradeHeader, fpmlWithdrawal, fpmlPartyList, fpmlQuote, fpmlRequestMessageHeader)).getOrDefault(false)) {
				return MapperC.<ReportableJurisdictionInformation>of(mapPartyTradeInformationListToReportableJurisdictionInformation.evaluate(fpmlPartyTradeInformation(fpmlTradeHeader, fpmlWithdrawal, fpmlPartyList, fpmlQuote, fpmlRequestMessageHeader).getMulti(), fpmlPartyList, fpmlRequestMessageHeader));
			}
			if (exists(fpmlWithdrawalPartyTradeInformation(fpmlTradeHeader, fpmlWithdrawal, fpmlPartyList, fpmlQuote, fpmlRequestMessageHeader)).getOrDefault(false)) {
				final MapperListOfLists<ReportableJurisdictionInformation> thenArg = fpmlWithdrawalPartyTradeInformation(fpmlTradeHeader, fpmlWithdrawal, fpmlPartyList, fpmlQuote, fpmlRequestMessageHeader)
					.mapItemToList(item -> MapperC.<ReportableJurisdictionInformation>of(mapWithdrawalPartyTradeInformationToReportableJurisdictionInformation.evaluate(item.get(), fpmlRequestMessageHeader)));
				return thenArg
					.flattenList();
			}
			return MapperC.<ReportableJurisdictionInformation>ofNull();
		}
	}
}
