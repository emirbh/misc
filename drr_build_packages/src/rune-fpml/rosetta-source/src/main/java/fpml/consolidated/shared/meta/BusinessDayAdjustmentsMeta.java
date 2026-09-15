package fpml.consolidated.shared.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.shared.BusinessDayAdjustments;
import fpml.consolidated.shared.validation.BusinessDayAdjustmentsTypeFormatValidator;
import fpml.consolidated.shared.validation.BusinessDayAdjustmentsValidator;
import fpml.consolidated.shared.validation.datarule.BusinessDayAdjustmentsChoice;
import fpml.consolidated.shared.validation.exists.BusinessDayAdjustmentsOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=BusinessDayAdjustments.class)
public class BusinessDayAdjustmentsMeta implements RosettaMetaData<BusinessDayAdjustments> {

	@Override
	public List<Validator<? super BusinessDayAdjustments>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<BusinessDayAdjustments>create(BusinessDayAdjustmentsChoice.class)
		);
	}
	
	@Override
	public List<Function<? super BusinessDayAdjustments, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super BusinessDayAdjustments> validator(ValidatorFactory factory) {
		return factory.<BusinessDayAdjustments>create(BusinessDayAdjustmentsValidator.class);
	}

	@Override
	public Validator<? super BusinessDayAdjustments> typeFormatValidator(ValidatorFactory factory) {
		return factory.<BusinessDayAdjustments>create(BusinessDayAdjustmentsTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super BusinessDayAdjustments> validator() {
		return new BusinessDayAdjustmentsValidator();
	}

	@Deprecated
	@Override
	public Validator<? super BusinessDayAdjustments> typeFormatValidator() {
		return new BusinessDayAdjustmentsTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super BusinessDayAdjustments, Set<String>> onlyExistsValidator() {
		return new BusinessDayAdjustmentsOnlyExistsValidator();
	}
}
