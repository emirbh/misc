package fpml.consolidated.ird.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.ird.ExtendibleProvision;
import fpml.consolidated.ird.validation.ExtendibleProvisionTypeFormatValidator;
import fpml.consolidated.ird.validation.ExtendibleProvisionValidator;
import fpml.consolidated.ird.validation.exists.ExtendibleProvisionOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=ExtendibleProvision.class)
public class ExtendibleProvisionMeta implements RosettaMetaData<ExtendibleProvision> {

	@Override
	public List<Validator<? super ExtendibleProvision>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super ExtendibleProvision, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super ExtendibleProvision> validator(ValidatorFactory factory) {
		return factory.<ExtendibleProvision>create(ExtendibleProvisionValidator.class);
	}

	@Override
	public Validator<? super ExtendibleProvision> typeFormatValidator(ValidatorFactory factory) {
		return factory.<ExtendibleProvision>create(ExtendibleProvisionTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super ExtendibleProvision> validator() {
		return new ExtendibleProvisionValidator();
	}

	@Deprecated
	@Override
	public Validator<? super ExtendibleProvision> typeFormatValidator() {
		return new ExtendibleProvisionTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super ExtendibleProvision, Set<String>> onlyExistsValidator() {
		return new ExtendibleProvisionOnlyExistsValidator();
	}
}
