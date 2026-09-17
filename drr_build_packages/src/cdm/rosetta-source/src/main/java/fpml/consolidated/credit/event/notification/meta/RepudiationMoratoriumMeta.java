package fpml.consolidated.credit.event.notification.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.credit.event.notification.RepudiationMoratorium;
import fpml.consolidated.credit.event.notification.validation.RepudiationMoratoriumTypeFormatValidator;
import fpml.consolidated.credit.event.notification.validation.RepudiationMoratoriumValidator;
import fpml.consolidated.credit.event.notification.validation.exists.RepudiationMoratoriumOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=RepudiationMoratorium.class)
public class RepudiationMoratoriumMeta implements RosettaMetaData<RepudiationMoratorium> {

	@Override
	public List<Validator<? super RepudiationMoratorium>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super RepudiationMoratorium, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super RepudiationMoratorium> validator(ValidatorFactory factory) {
		return factory.<RepudiationMoratorium>create(RepudiationMoratoriumValidator.class);
	}

	@Override
	public Validator<? super RepudiationMoratorium> typeFormatValidator(ValidatorFactory factory) {
		return factory.<RepudiationMoratorium>create(RepudiationMoratoriumTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super RepudiationMoratorium> validator() {
		return new RepudiationMoratoriumValidator();
	}

	@Deprecated
	@Override
	public Validator<? super RepudiationMoratorium> typeFormatValidator() {
		return new RepudiationMoratoriumTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super RepudiationMoratorium, Set<String>> onlyExistsValidator() {
		return new RepudiationMoratoriumOnlyExistsValidator();
	}
}
