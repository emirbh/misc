package fpml.consolidated.valuation.fpmlreporting.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.doc.Validation;
import fpml.consolidated.msg.CorrelationId;
import fpml.consolidated.msg.RequestMessageHeader;
import fpml.consolidated.riskdef.Market;
import fpml.consolidated.shared.Account;
import fpml.consolidated.shared.IdentifiedDate;
import fpml.consolidated.shared.OnBehalfOf;
import fpml.consolidated.shared.Party;
import fpml.consolidated.valuation.fpmlreporting.PortfolioValuationItem;
import fpml.consolidated.valuation.fpmlreporting.ReportContents;
import fpml.consolidated.valuation.fpmlreporting.RequestValuationReport;
import fpml.consolidated.valuation.fpmlreporting.TradeValuationItem;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class RequestValuationReportOnlyExistsValidator implements ValidatorWithArg<RequestValuationReport, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends RequestValuationReport> ValidationResult<RequestValuationReport> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("fpmlVersion", ExistenceChecker.isSet((String) o.getFpmlVersion()))
				.put("expectedBuild", ExistenceChecker.isSet((Integer) o.getExpectedBuild()))
				.put("actualBuild", ExistenceChecker.isSet((Integer) o.getActualBuild()))
				.put("header", ExistenceChecker.isSet((RequestMessageHeader) o.getHeader()))
				.put("validation", ExistenceChecker.isSet((List<? extends Validation>) o.getValidation()))
				.put("isCorrection", ExistenceChecker.isSet((Boolean) o.getIsCorrection()))
				.put("parentCorrelationId", ExistenceChecker.isSet((CorrelationId) o.getParentCorrelationId()))
				.put("correlationId", ExistenceChecker.isSet((List<? extends CorrelationId>) o.getCorrelationId()))
				.put("sequenceNumber", ExistenceChecker.isSet((Integer) o.getSequenceNumber()))
				.put("onBehalfOf", ExistenceChecker.isSet((List<? extends OnBehalfOf>) o.getOnBehalfOf()))
				.put("reportContents", ExistenceChecker.isSet((ReportContents) o.getReportContents()))
				.put("asOfDate", ExistenceChecker.isSet((IdentifiedDate) o.getAsOfDate()))
				.put("party", ExistenceChecker.isSet((List<? extends Party>) o.getParty()))
				.put("account", ExistenceChecker.isSet((List<? extends Account>) o.getAccount()))
				.put("market", ExistenceChecker.isSet((Market) o.getMarket()))
				.put("portfolioValuationItem", ExistenceChecker.isSet((List<? extends PortfolioValuationItem>) o.getPortfolioValuationItem()))
				.put("tradeValuationItem", ExistenceChecker.isSet((List<? extends TradeValuationItem>) o.getTradeValuationItem()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("RequestValuationReport", ValidationResult.ValidationType.ONLY_EXISTS, "RequestValuationReport", path, "");
		}
		return failure("RequestValuationReport", ValidationResult.ValidationType.ONLY_EXISTS, "RequestValuationReport", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
