package fpml.consolidated.option.shared.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.option.shared.AveragingPeriod;
import fpml.consolidated.option.shared.validation.AveragingPeriodTypeFormatValidator;
import fpml.consolidated.option.shared.validation.AveragingPeriodValidator;
import fpml.consolidated.option.shared.validation.datarule.AveragingPeriodChoice;
import fpml.consolidated.option.shared.validation.exists.AveragingPeriodOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=AveragingPeriod.class)
public class AveragingPeriodMeta implements RosettaMetaData<AveragingPeriod> {

	@Override
	public List<Validator<? super AveragingPeriod>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<AveragingPeriod>create(AveragingPeriodChoice.class)
		);
	}
	
	@Override
	public List<Function<? super AveragingPeriod, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super AveragingPeriod> validator(ValidatorFactory factory) {
		return factory.<AveragingPeriod>create(AveragingPeriodValidator.class);
	}

	@Override
	public Validator<? super AveragingPeriod> typeFormatValidator(ValidatorFactory factory) {
		return factory.<AveragingPeriod>create(AveragingPeriodTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super AveragingPeriod> validator() {
		return new AveragingPeriodValidator();
	}

	@Deprecated
	@Override
	public Validator<? super AveragingPeriod> typeFormatValidator() {
		return new AveragingPeriodTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super AveragingPeriod, Set<String>> onlyExistsValidator() {
		return new AveragingPeriodOnlyExistsValidator();
	}
}
