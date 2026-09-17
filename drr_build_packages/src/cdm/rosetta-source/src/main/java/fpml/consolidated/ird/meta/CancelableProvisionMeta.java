package fpml.consolidated.ird.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.ird.CancelableProvision;
import fpml.consolidated.ird.validation.CancelableProvisionTypeFormatValidator;
import fpml.consolidated.ird.validation.CancelableProvisionValidator;
import fpml.consolidated.ird.validation.exists.CancelableProvisionOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=CancelableProvision.class)
public class CancelableProvisionMeta implements RosettaMetaData<CancelableProvision> {

	@Override
	public List<Validator<? super CancelableProvision>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super CancelableProvision, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super CancelableProvision> validator(ValidatorFactory factory) {
		return factory.<CancelableProvision>create(CancelableProvisionValidator.class);
	}

	@Override
	public Validator<? super CancelableProvision> typeFormatValidator(ValidatorFactory factory) {
		return factory.<CancelableProvision>create(CancelableProvisionTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super CancelableProvision> validator() {
		return new CancelableProvisionValidator();
	}

	@Deprecated
	@Override
	public Validator<? super CancelableProvision> typeFormatValidator() {
		return new CancelableProvisionTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super CancelableProvision, Set<String>> onlyExistsValidator() {
		return new CancelableProvisionOnlyExistsValidator();
	}
}
