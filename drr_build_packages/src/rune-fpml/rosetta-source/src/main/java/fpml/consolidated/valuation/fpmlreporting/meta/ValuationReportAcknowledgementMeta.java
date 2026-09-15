package fpml.consolidated.valuation.fpmlreporting.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.valuation.fpmlreporting.ValuationReportAcknowledgement;
import fpml.consolidated.valuation.fpmlreporting.validation.ValuationReportAcknowledgementTypeFormatValidator;
import fpml.consolidated.valuation.fpmlreporting.validation.ValuationReportAcknowledgementValidator;
import fpml.consolidated.valuation.fpmlreporting.validation.exists.ValuationReportAcknowledgementOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=ValuationReportAcknowledgement.class)
public class ValuationReportAcknowledgementMeta implements RosettaMetaData<ValuationReportAcknowledgement> {

	@Override
	public List<Validator<? super ValuationReportAcknowledgement>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super ValuationReportAcknowledgement, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super ValuationReportAcknowledgement> validator(ValidatorFactory factory) {
		return factory.<ValuationReportAcknowledgement>create(ValuationReportAcknowledgementValidator.class);
	}

	@Override
	public Validator<? super ValuationReportAcknowledgement> typeFormatValidator(ValidatorFactory factory) {
		return factory.<ValuationReportAcknowledgement>create(ValuationReportAcknowledgementTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super ValuationReportAcknowledgement> validator() {
		return new ValuationReportAcknowledgementValidator();
	}

	@Deprecated
	@Override
	public Validator<? super ValuationReportAcknowledgement> typeFormatValidator() {
		return new ValuationReportAcknowledgementTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super ValuationReportAcknowledgement, Set<String>> onlyExistsValidator() {
		return new ValuationReportAcknowledgementOnlyExistsValidator();
	}
}
