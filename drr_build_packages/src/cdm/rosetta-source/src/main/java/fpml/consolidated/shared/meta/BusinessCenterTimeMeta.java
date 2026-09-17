package fpml.consolidated.shared.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.shared.BusinessCenterTime;
import fpml.consolidated.shared.validation.BusinessCenterTimeTypeFormatValidator;
import fpml.consolidated.shared.validation.BusinessCenterTimeValidator;
import fpml.consolidated.shared.validation.exists.BusinessCenterTimeOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=BusinessCenterTime.class)
public class BusinessCenterTimeMeta implements RosettaMetaData<BusinessCenterTime> {

	@Override
	public List<Validator<? super BusinessCenterTime>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super BusinessCenterTime, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super BusinessCenterTime> validator(ValidatorFactory factory) {
		return factory.<BusinessCenterTime>create(BusinessCenterTimeValidator.class);
	}

	@Override
	public Validator<? super BusinessCenterTime> typeFormatValidator(ValidatorFactory factory) {
		return factory.<BusinessCenterTime>create(BusinessCenterTimeTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super BusinessCenterTime> validator() {
		return new BusinessCenterTimeValidator();
	}

	@Deprecated
	@Override
	public Validator<? super BusinessCenterTime> typeFormatValidator() {
		return new BusinessCenterTimeTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super BusinessCenterTime, Set<String>> onlyExistsValidator() {
		return new BusinessCenterTimeOnlyExistsValidator();
	}
}
