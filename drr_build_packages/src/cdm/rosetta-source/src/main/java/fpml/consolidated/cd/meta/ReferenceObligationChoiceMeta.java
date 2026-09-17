package fpml.consolidated.cd.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.cd.ReferenceObligationChoice;
import fpml.consolidated.cd.validation.ReferenceObligationChoiceTypeFormatValidator;
import fpml.consolidated.cd.validation.ReferenceObligationChoiceValidator;
import fpml.consolidated.cd.validation.datarule.ReferenceObligationChoiceChoice;
import fpml.consolidated.cd.validation.exists.ReferenceObligationChoiceOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=ReferenceObligationChoice.class)
public class ReferenceObligationChoiceMeta implements RosettaMetaData<ReferenceObligationChoice> {

	@Override
	public List<Validator<? super ReferenceObligationChoice>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<ReferenceObligationChoice>create(ReferenceObligationChoiceChoice.class)
		);
	}
	
	@Override
	public List<Function<? super ReferenceObligationChoice, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super ReferenceObligationChoice> validator(ValidatorFactory factory) {
		return factory.<ReferenceObligationChoice>create(ReferenceObligationChoiceValidator.class);
	}

	@Override
	public Validator<? super ReferenceObligationChoice> typeFormatValidator(ValidatorFactory factory) {
		return factory.<ReferenceObligationChoice>create(ReferenceObligationChoiceTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super ReferenceObligationChoice> validator() {
		return new ReferenceObligationChoiceValidator();
	}

	@Deprecated
	@Override
	public Validator<? super ReferenceObligationChoice> typeFormatValidator() {
		return new ReferenceObligationChoiceTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super ReferenceObligationChoice, Set<String>> onlyExistsValidator() {
		return new ReferenceObligationChoiceOnlyExistsValidator();
	}
}
