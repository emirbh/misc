package drr.standards.iosco.cde.version3.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import drr.standards.iosco.cde.version3.CriticalDataElement;
import java.util.List;
import java.util.regex.Pattern;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkNumber;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkString;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.Optional.empty;
import static java.util.Optional.of;
import static java.util.stream.Collectors.toList;

public class CriticalDataElementTypeFormatValidator implements Validator<CriticalDataElement> {

	private List<ComparisonResult> getComparisonResults(CriticalDataElement o) {
		return Lists.<ComparisonResult>newArrayList(
				checkString("counterparty1", o.getCounterparty1(), 0, empty(), of(Pattern.compile("[A-Z0-9]{18,18}[0-9]{2,2}"))), 
				checkString("counterparty2", o.getCounterparty2(), 20, of(72), of(Pattern.compile("[a-zA-Z0-9]{1,72}"))), 
				checkString("beneficiary1", o.getBeneficiary1(), 20, of(72), of(Pattern.compile("[a-zA-Z0-9]{1,72}"))), 
				checkString("buyerIdentifier", o.getBuyerIdentifier(), 20, of(72), of(Pattern.compile("[a-zA-Z0-9]{1,72}"))), 
				checkString("sellerIdentifier", o.getSellerIdentifier(), 20, of(72), of(Pattern.compile("[a-zA-Z0-9]{1,72}"))), 
				checkString("centralCounterparty", o.getCentralCounterparty(), 0, empty(), of(Pattern.compile("[A-Z0-9]{18,18}[0-9]{2,2}"))), 
				checkString("clearingMember", o.getClearingMember(), 0, empty(), of(Pattern.compile("[A-Z0-9]{18,18}[0-9]{2,2}"))), 
				checkNumber("callAmount", o.getCallAmount(), of(25), of(5), empty(), empty()), 
				checkNumber("putAmount", o.getPutAmount(), of(25), of(5), empty(), empty()), 
				checkNumber("delta", o.getDelta(), of(25), of(5), empty(), empty()), 
				checkString("packageIdentifier", o.getPackageIdentifier(), 1, of(100), of(Pattern.compile("[a-zA-Z0-9]{1,100}"))), 
				checkString("priceUnitOfMeasure", o.getPriceUnitOfMeasure(), 1, of(4), empty()), 
				checkNumber("optionPremiumAmount", o.getOptionPremiumAmount(), of(25), of(5), empty(), empty()), 
				checkNumber("exchangeRate", o.getExchangeRate(), of(18), of(13), empty(), empty()), 
				checkString("exchangeRateBasis", o.getExchangeRateBasis(), 7, of(7), of(Pattern.compile("[A-Z]{3,3}/[A-Z]{3,3}"))), 
				checkNumber("cdSIndexAttachmentPoint", o.getCdSIndexAttachmentPoint(), of(11), of(10), empty(), empty()), 
				checkNumber("cdSIndexDetachmentPoint", o.getCdSIndexDetachmentPoint(), of(11), of(10), empty(), empty()), 
				checkString("priorUTI", o.getPriorUTI(), 1, of(52), of(Pattern.compile("[a-zA-Z0-9]{1,52}"))), 
				checkNumber("valuationAmount", o.getValuationAmount(), of(25), of(5), empty(), empty()), 
				checkString("customBasketCode", o.getCustomBasketCode(), 1, of(52), of(Pattern.compile("[a-zA-Z0-9]{1,52}"))), 
				checkString("underlyingIdOther", o.getUnderlyingIdOther(), 1, of(350), of(Pattern.compile(".{1,350}"))), 
				checkString("underlyingAssetTradingPlatformIdentifier", o.getUnderlyingAssetTradingPlatformIdentifier(), 1, of(4), empty()), 
				checkString("underlyingAssetPriceSource", o.getUnderlyingAssetPriceSource(), 1, of(50), of(Pattern.compile("[a-zA-Z0-9]{1,50}"))), 
				checkString("eventIdentifier", o.getEventIdentifier(), 1, of(52), of(Pattern.compile("[a-zA-Z0-9]{1,52}")))
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, CriticalDataElement o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("CriticalDataElement", ValidationResult.ValidationType.TYPE_FORMAT, "CriticalDataElement", path, "", res.getError());
				}
				return success("CriticalDataElement", ValidationResult.ValidationType.TYPE_FORMAT, "CriticalDataElement", path, "");
			})
			.collect(toList());
	}

}
