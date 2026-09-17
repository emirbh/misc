package fpml.consolidated.loan.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.loan.FacilitySummary;
import fpml.consolidated.loan.validation.FacilitySummaryTypeFormatValidator;
import fpml.consolidated.loan.validation.FacilitySummaryValidator;
import fpml.consolidated.loan.validation.exists.FacilitySummaryOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=FacilitySummary.class)
public class FacilitySummaryMeta implements RosettaMetaData<FacilitySummary> {

	@Override
	public List<Validator<? super FacilitySummary>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super FacilitySummary, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super FacilitySummary> validator(ValidatorFactory factory) {
		return factory.<FacilitySummary>create(FacilitySummaryValidator.class);
	}

	@Override
	public Validator<? super FacilitySummary> typeFormatValidator(ValidatorFactory factory) {
		return factory.<FacilitySummary>create(FacilitySummaryTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super FacilitySummary> validator() {
		return new FacilitySummaryValidator();
	}

	@Deprecated
	@Override
	public Validator<? super FacilitySummary> typeFormatValidator() {
		return new FacilitySummaryTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super FacilitySummary, Set<String>> onlyExistsValidator() {
		return new FacilitySummaryOnlyExistsValidator();
	}
}
