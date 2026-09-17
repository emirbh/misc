package fpml.consolidated.shared.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.shared.BusinessCenter;
import fpml.consolidated.shared.validation.BusinessCenterTypeFormatValidator;
import fpml.consolidated.shared.validation.BusinessCenterValidator;
import fpml.consolidated.shared.validation.exists.BusinessCenterOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=BusinessCenter.class)
public class BusinessCenterMeta implements RosettaMetaData<BusinessCenter> {

	@Override
	public List<Validator<? super BusinessCenter>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super BusinessCenter, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super BusinessCenter> validator(ValidatorFactory factory) {
		return factory.<BusinessCenter>create(BusinessCenterValidator.class);
	}

	@Override
	public Validator<? super BusinessCenter> typeFormatValidator(ValidatorFactory factory) {
		return factory.<BusinessCenter>create(BusinessCenterTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super BusinessCenter> validator() {
		return new BusinessCenterValidator();
	}

	@Deprecated
	@Override
	public Validator<? super BusinessCenter> typeFormatValidator() {
		return new BusinessCenterTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super BusinessCenter, Set<String>> onlyExistsValidator() {
		return new BusinessCenterOnlyExistsValidator();
	}
}
