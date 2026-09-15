package fpml.consolidated.fx.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.fx.FxDisruptionProvisions;
import fpml.consolidated.fx.validation.FxDisruptionProvisionsTypeFormatValidator;
import fpml.consolidated.fx.validation.FxDisruptionProvisionsValidator;
import fpml.consolidated.fx.validation.exists.FxDisruptionProvisionsOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=FxDisruptionProvisions.class)
public class FxDisruptionProvisionsMeta implements RosettaMetaData<FxDisruptionProvisions> {

	@Override
	public List<Validator<? super FxDisruptionProvisions>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super FxDisruptionProvisions, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super FxDisruptionProvisions> validator(ValidatorFactory factory) {
		return factory.<FxDisruptionProvisions>create(FxDisruptionProvisionsValidator.class);
	}

	@Override
	public Validator<? super FxDisruptionProvisions> typeFormatValidator(ValidatorFactory factory) {
		return factory.<FxDisruptionProvisions>create(FxDisruptionProvisionsTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super FxDisruptionProvisions> validator() {
		return new FxDisruptionProvisionsValidator();
	}

	@Deprecated
	@Override
	public Validator<? super FxDisruptionProvisions> typeFormatValidator() {
		return new FxDisruptionProvisionsTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super FxDisruptionProvisions, Set<String>> onlyExistsValidator() {
		return new FxDisruptionProvisionsOnlyExistsValidator();
	}
}
