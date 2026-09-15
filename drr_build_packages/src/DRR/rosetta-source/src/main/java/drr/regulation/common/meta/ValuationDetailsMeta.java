package drr.regulation.common.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import drr.regulation.common.ValuationDetails;
import drr.regulation.common.validation.ValuationDetailsTypeFormatValidator;
import drr.regulation.common.validation.ValuationDetailsValidator;
import drr.regulation.common.validation.exists.ValuationDetailsOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 7.7.0
 */
@RosettaMeta(model=ValuationDetails.class)
public class ValuationDetailsMeta implements RosettaMetaData<ValuationDetails> {

	@Override
	public List<Validator<? super ValuationDetails>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super ValuationDetails, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super ValuationDetails> validator(ValidatorFactory factory) {
		return factory.<ValuationDetails>create(ValuationDetailsValidator.class);
	}

	@Override
	public Validator<? super ValuationDetails> typeFormatValidator(ValidatorFactory factory) {
		return factory.<ValuationDetails>create(ValuationDetailsTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super ValuationDetails> validator() {
		return new ValuationDetailsValidator();
	}

	@Deprecated
	@Override
	public Validator<? super ValuationDetails> typeFormatValidator() {
		return new ValuationDetailsTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super ValuationDetails, Set<String>> onlyExistsValidator() {
		return new ValuationDetailsOnlyExistsValidator();
	}
}
