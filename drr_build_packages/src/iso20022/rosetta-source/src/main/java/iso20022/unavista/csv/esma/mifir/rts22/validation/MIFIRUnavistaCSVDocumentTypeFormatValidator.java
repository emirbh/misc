package iso20022.unavista.csv.esma.mifir.rts22.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import iso20022.unavista.csv.esma.mifir.rts22.MIFIRUnavistaCSVDocument;
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

public class MIFIRUnavistaCSVDocumentTypeFormatValidator implements Validator<MIFIRUnavistaCSVDocument> {

	private List<ComparisonResult> getComparisonResults(MIFIRUnavistaCSVDocument o) {
		return Lists.<ComparisonResult>newArrayList(
				checkString("transactionReferenceNumber", o.getTransactionReferenceNumber(), 1, of(52), empty()), 
				checkString("venueTransactionID", o.getVenueTransactionID(), 1, of(52), empty()), 
				checkString("executingEntityID", o.getExecutingEntityID(), 0, empty(), of(Pattern.compile("[A-Z0-9]{18,18}[0-9]{2,2}"))), 
				checkString("submittingEntityID", o.getSubmittingEntityID(), 0, empty(), of(Pattern.compile("[A-Z0-9]{18,18}[0-9]{2,2}"))), 
				checkString("buyerCountryOfBranch", o.getBuyerCountryOfBranch(), 0, empty(), of(Pattern.compile("[A-Z]{2,2}"))), 
				checkString("sellerCountryOfBranch", o.getSellerCountryOfBranch(), 0, empty(), of(Pattern.compile("[A-Z]{2,2}"))), 
				checkString("buyerTransmitterID", o.getBuyerTransmitterID(), 0, empty(), of(Pattern.compile("[A-Z0-9]{18,18}[0-9]{2,2}"))), 
				checkString("sellerTransmitterID", o.getSellerTransmitterID(), 0, empty(), of(Pattern.compile("[A-Z0-9]{18,18}[0-9]{2,2}"))), 
				checkNumber("quantity", o.getQuantity(), of(18), of(17), empty(), empty()), 
				checkString("quantityCurrency", o.getQuantityCurrency(), 0, empty(), of(Pattern.compile("[A-Z]{3,3}"))), 
				checkNumber("price", o.getPrice(), of(18), of(17), empty(), empty()), 
				checkString("priceCurrency", o.getPriceCurrency(), 0, empty(), of(Pattern.compile("[A-Z]{3,3}"))), 
				checkNumber("netAmount", o.getNetAmount(), of(18), of(5), empty(), empty()), 
				checkString("venue", o.getVenue(), 0, empty(), of(Pattern.compile("XXXX|XOFF|[A-Z0-9]{4,4}"))), 
				checkString("countryOfBranch", o.getCountryOfBranch(), 0, empty(), of(Pattern.compile("[A-Z]{2,2}"))), 
				checkNumber("upFrontPayment", o.getUpFrontPayment(), of(18), of(5), empty(), empty()), 
				checkString("upFrontPaymentCurrency", o.getUpFrontPaymentCurrency(), 0, empty(), of(Pattern.compile("[A-Z]{3,3}"))), 
				checkString("complexTradeComponentID", o.getComplexTradeComponentID(), 1, of(35), empty()), 
				checkString("instrumentID", o.getInstrumentID(), 0, empty(), of(Pattern.compile("[A-Z]{2,2}[A-Z0-9]{9,9}[0-9]{1,1}"))), 
				checkString("instrumentName", o.getInstrumentName(), 1, of(350), empty()), 
				checkString("instrumentClassification", o.getInstrumentClassification(), 0, empty(), of(Pattern.compile("[A-Z]{6,6}"))), 
				checkString("notionalCurrency1", o.getNotionalCurrency1(), 0, empty(), of(Pattern.compile("[A-Z]{3,3}"))), 
				checkString("notionalCurrency2", o.getNotionalCurrency2(), 0, empty(), of(Pattern.compile("[A-Z]{3,3}"))), 
				checkNumber("priceMultiplier", o.getPriceMultiplier(), of(18), of(17), empty(), empty()), 
				checkNumber("strikePrice", o.getStrikePrice(), of(18), of(17), empty(), empty()), 
				checkString("strikePriceCurrency", o.getStrikePriceCurrency(), 0, empty(), of(Pattern.compile("[A-Z]{3,3}"))), 
				checkString("investmentDecisionID", o.getInvestmentDecisionID(), 1, of(50), empty()), 
				checkString("investmentDecisionCountryOfBranch", o.getInvestmentDecisionCountryOfBranch(), 0, empty(), of(Pattern.compile("[A-Z]{2,2}"))), 
				checkString("firmExecutionID", o.getFirmExecutionID(), 1, of(50), empty()), 
				checkString("firmExecutionCountryOfBranch", o.getFirmExecutionCountryOfBranch(), 0, empty(), of(Pattern.compile("[A-Z]{2,2}"))), 
				checkString("dataCategory", o.getDataCategory(), 1, of(50), empty()), 
				checkString("internalClientIdentification", o.getInternalClientIdentification(), 1, of(250), empty())
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, MIFIRUnavistaCSVDocument o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("MIFIRUnavistaCSVDocument", ValidationResult.ValidationType.TYPE_FORMAT, "MIFIRUnavistaCSVDocument", path, "", res.getError());
				}
				return success("MIFIRUnavistaCSVDocument", ValidationResult.ValidationType.TYPE_FORMAT, "MIFIRUnavistaCSVDocument", path, "");
			})
			.collect(toList());
	}

}
