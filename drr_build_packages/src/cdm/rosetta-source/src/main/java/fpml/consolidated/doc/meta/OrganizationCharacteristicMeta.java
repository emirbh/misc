package fpml.consolidated.doc.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.doc.OrganizationCharacteristic;
import fpml.consolidated.doc.validation.OrganizationCharacteristicTypeFormatValidator;
import fpml.consolidated.doc.validation.OrganizationCharacteristicValidator;
import fpml.consolidated.doc.validation.exists.OrganizationCharacteristicOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=OrganizationCharacteristic.class)
public class OrganizationCharacteristicMeta implements RosettaMetaData<OrganizationCharacteristic> {

	@Override
	public List<Validator<? super OrganizationCharacteristic>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super OrganizationCharacteristic, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super OrganizationCharacteristic> validator(ValidatorFactory factory) {
		return factory.<OrganizationCharacteristic>create(OrganizationCharacteristicValidator.class);
	}

	@Override
	public Validator<? super OrganizationCharacteristic> typeFormatValidator(ValidatorFactory factory) {
		return factory.<OrganizationCharacteristic>create(OrganizationCharacteristicTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super OrganizationCharacteristic> validator() {
		return new OrganizationCharacteristicValidator();
	}

	@Deprecated
	@Override
	public Validator<? super OrganizationCharacteristic> typeFormatValidator() {
		return new OrganizationCharacteristicTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super OrganizationCharacteristic, Set<String>> onlyExistsValidator() {
		return new OrganizationCharacteristicOnlyExistsValidator();
	}
}
