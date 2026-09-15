package fpml.consolidated.shared.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.shared.BusinessUnitRole;
import fpml.consolidated.shared.validation.BusinessUnitRoleTypeFormatValidator;
import fpml.consolidated.shared.validation.BusinessUnitRoleValidator;
import fpml.consolidated.shared.validation.exists.BusinessUnitRoleOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=BusinessUnitRole.class)
public class BusinessUnitRoleMeta implements RosettaMetaData<BusinessUnitRole> {

	@Override
	public List<Validator<? super BusinessUnitRole>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super BusinessUnitRole, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super BusinessUnitRole> validator(ValidatorFactory factory) {
		return factory.<BusinessUnitRole>create(BusinessUnitRoleValidator.class);
	}

	@Override
	public Validator<? super BusinessUnitRole> typeFormatValidator(ValidatorFactory factory) {
		return factory.<BusinessUnitRole>create(BusinessUnitRoleTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super BusinessUnitRole> validator() {
		return new BusinessUnitRoleValidator();
	}

	@Deprecated
	@Override
	public Validator<? super BusinessUnitRole> typeFormatValidator() {
		return new BusinessUnitRoleTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super BusinessUnitRole, Set<String>> onlyExistsValidator() {
		return new BusinessUnitRoleOnlyExistsValidator();
	}
}
