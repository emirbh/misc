package fpml.consolidated.shared.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.shared.BusinessDateRange;
import fpml.consolidated.shared.validation.BusinessDateRangeTypeFormatValidator;
import fpml.consolidated.shared.validation.BusinessDateRangeValidator;
import fpml.consolidated.shared.validation.datarule.BusinessDateRangeChoice;
import fpml.consolidated.shared.validation.exists.BusinessDateRangeOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=BusinessDateRange.class)
public class BusinessDateRangeMeta implements RosettaMetaData<BusinessDateRange> {

	@Override
	public List<Validator<? super BusinessDateRange>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<BusinessDateRange>create(BusinessDateRangeChoice.class)
		);
	}
	
	@Override
	public List<Function<? super BusinessDateRange, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super BusinessDateRange> validator(ValidatorFactory factory) {
		return factory.<BusinessDateRange>create(BusinessDateRangeValidator.class);
	}

	@Override
	public Validator<? super BusinessDateRange> typeFormatValidator(ValidatorFactory factory) {
		return factory.<BusinessDateRange>create(BusinessDateRangeTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super BusinessDateRange> validator() {
		return new BusinessDateRangeValidator();
	}

	@Deprecated
	@Override
	public Validator<? super BusinessDateRange> typeFormatValidator() {
		return new BusinessDateRangeTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super BusinessDateRange, Set<String>> onlyExistsValidator() {
		return new BusinessDateRangeOnlyExistsValidator();
	}
}
