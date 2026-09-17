package fpml.consolidated.option.shared.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.option.shared.GracePeriodExtension;
import fpml.consolidated.option.shared.validation.GracePeriodExtensionTypeFormatValidator;
import fpml.consolidated.option.shared.validation.GracePeriodExtensionValidator;
import fpml.consolidated.option.shared.validation.exists.GracePeriodExtensionOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=GracePeriodExtension.class)
public class GracePeriodExtensionMeta implements RosettaMetaData<GracePeriodExtension> {

	@Override
	public List<Validator<? super GracePeriodExtension>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super GracePeriodExtension, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super GracePeriodExtension> validator(ValidatorFactory factory) {
		return factory.<GracePeriodExtension>create(GracePeriodExtensionValidator.class);
	}

	@Override
	public Validator<? super GracePeriodExtension> typeFormatValidator(ValidatorFactory factory) {
		return factory.<GracePeriodExtension>create(GracePeriodExtensionTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super GracePeriodExtension> validator() {
		return new GracePeriodExtensionValidator();
	}

	@Deprecated
	@Override
	public Validator<? super GracePeriodExtension> typeFormatValidator() {
		return new GracePeriodExtensionTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super GracePeriodExtension, Set<String>> onlyExistsValidator() {
		return new GracePeriodExtensionOnlyExistsValidator();
	}
}
