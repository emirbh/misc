package fpml.consolidated.option.shared.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.option.shared.AveragingObservationList;
import fpml.consolidated.option.shared.validation.AveragingObservationListTypeFormatValidator;
import fpml.consolidated.option.shared.validation.AveragingObservationListValidator;
import fpml.consolidated.option.shared.validation.exists.AveragingObservationListOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=AveragingObservationList.class)
public class AveragingObservationListMeta implements RosettaMetaData<AveragingObservationList> {

	@Override
	public List<Validator<? super AveragingObservationList>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super AveragingObservationList, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super AveragingObservationList> validator(ValidatorFactory factory) {
		return factory.<AveragingObservationList>create(AveragingObservationListValidator.class);
	}

	@Override
	public Validator<? super AveragingObservationList> typeFormatValidator(ValidatorFactory factory) {
		return factory.<AveragingObservationList>create(AveragingObservationListTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super AveragingObservationList> validator() {
		return new AveragingObservationListValidator();
	}

	@Deprecated
	@Override
	public Validator<? super AveragingObservationList> typeFormatValidator() {
		return new AveragingObservationListTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super AveragingObservationList, Set<String>> onlyExistsValidator() {
		return new AveragingObservationListOnlyExistsValidator();
	}
}
