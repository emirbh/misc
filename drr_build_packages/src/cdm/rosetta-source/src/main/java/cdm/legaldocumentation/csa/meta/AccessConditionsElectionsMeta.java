package cdm.legaldocumentation.csa.meta;

import cdm.legaldocumentation.csa.AccessConditionsElections;
import cdm.legaldocumentation.csa.validation.AccessConditionsElectionsTypeFormatValidator;
import cdm.legaldocumentation.csa.validation.AccessConditionsElectionsValidator;
import cdm.legaldocumentation.csa.validation.exists.AccessConditionsElectionsOnlyExistsValidator;
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
@RosettaMeta(model=AccessConditionsElections.class)
public class AccessConditionsElectionsMeta implements RosettaMetaData<AccessConditionsElections> {

	@Override
	public List<Validator<? super AccessConditionsElections>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super AccessConditionsElections, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super AccessConditionsElections> validator(ValidatorFactory factory) {
		return factory.<AccessConditionsElections>create(AccessConditionsElectionsValidator.class);
	}

	@Override
	public Validator<? super AccessConditionsElections> typeFormatValidator(ValidatorFactory factory) {
		return factory.<AccessConditionsElections>create(AccessConditionsElectionsTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super AccessConditionsElections> validator() {
		return new AccessConditionsElectionsValidator();
	}

	@Deprecated
	@Override
	public Validator<? super AccessConditionsElections> typeFormatValidator() {
		return new AccessConditionsElectionsTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super AccessConditionsElections, Set<String>> onlyExistsValidator() {
		return new AccessConditionsElectionsOnlyExistsValidator();
	}
}
