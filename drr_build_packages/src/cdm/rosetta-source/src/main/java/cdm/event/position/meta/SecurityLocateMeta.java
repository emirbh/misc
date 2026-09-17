package cdm.event.position.meta;

import cdm.event.position.AvailableInventory;
import cdm.event.position.SecurityLocate;
import cdm.event.position.validation.SecurityLocateTypeFormatValidator;
import cdm.event.position.validation.SecurityLocateValidator;
import cdm.event.position.validation.datarule.AvailableInventoryValidPartyRole;
import cdm.event.position.validation.datarule.SecurityLocateRequestOneSecurityMinimum;
import cdm.event.position.validation.exists.SecurityLocateOnlyExistsValidator;
import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 6.23.0
 */
@RosettaMeta(model=SecurityLocate.class)
public class SecurityLocateMeta implements RosettaMetaData<SecurityLocate> {

	@Override
	public List<Validator<? super SecurityLocate>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<AvailableInventory>create(AvailableInventoryValidPartyRole.class),
			factory.<SecurityLocate>create(SecurityLocateRequestOneSecurityMinimum.class)
		);
	}
	
	@Override
	public List<Function<? super SecurityLocate, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super SecurityLocate> validator(ValidatorFactory factory) {
		return factory.<SecurityLocate>create(SecurityLocateValidator.class);
	}

	@Override
	public Validator<? super SecurityLocate> typeFormatValidator(ValidatorFactory factory) {
		return factory.<SecurityLocate>create(SecurityLocateTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super SecurityLocate> validator() {
		return new SecurityLocateValidator();
	}

	@Deprecated
	@Override
	public Validator<? super SecurityLocate> typeFormatValidator() {
		return new SecurityLocateTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super SecurityLocate, Set<String>> onlyExistsValidator() {
		return new SecurityLocateOnlyExistsValidator();
	}
}
