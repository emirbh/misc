package fpml.consolidated.loan.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.loan.Deal;
import fpml.consolidated.loan.DealSummary;
import fpml.consolidated.loan.validation.DealTypeFormatValidator;
import fpml.consolidated.loan.validation.DealValidator;
import fpml.consolidated.loan.validation.datarule.DealSummaryChoice;
import fpml.consolidated.loan.validation.exists.DealOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=Deal.class)
public class DealMeta implements RosettaMetaData<Deal> {

	@Override
	public List<Validator<? super Deal>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<DealSummary>create(DealSummaryChoice.class)
		);
	}
	
	@Override
	public List<Function<? super Deal, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super Deal> validator(ValidatorFactory factory) {
		return factory.<Deal>create(DealValidator.class);
	}

	@Override
	public Validator<? super Deal> typeFormatValidator(ValidatorFactory factory) {
		return factory.<Deal>create(DealTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super Deal> validator() {
		return new DealValidator();
	}

	@Deprecated
	@Override
	public Validator<? super Deal> typeFormatValidator() {
		return new DealTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super Deal, Set<String>> onlyExistsValidator() {
		return new DealOnlyExistsValidator();
	}
}
