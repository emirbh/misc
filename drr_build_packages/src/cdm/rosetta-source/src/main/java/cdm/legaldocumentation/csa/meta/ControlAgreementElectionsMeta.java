package cdm.legaldocumentation.csa.meta;

import cdm.legaldocumentation.csa.ControlAgreementElections;
import cdm.legaldocumentation.csa.validation.ControlAgreementElectionsTypeFormatValidator;
import cdm.legaldocumentation.csa.validation.ControlAgreementElectionsValidator;
import cdm.legaldocumentation.csa.validation.exists.ControlAgreementElectionsOnlyExistsValidator;
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
@RosettaMeta(model=ControlAgreementElections.class)
public class ControlAgreementElectionsMeta implements RosettaMetaData<ControlAgreementElections> {

	@Override
	public List<Validator<? super ControlAgreementElections>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super ControlAgreementElections, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super ControlAgreementElections> validator(ValidatorFactory factory) {
		return factory.<ControlAgreementElections>create(ControlAgreementElectionsValidator.class);
	}

	@Override
	public Validator<? super ControlAgreementElections> typeFormatValidator(ValidatorFactory factory) {
		return factory.<ControlAgreementElections>create(ControlAgreementElectionsTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super ControlAgreementElections> validator() {
		return new ControlAgreementElectionsValidator();
	}

	@Deprecated
	@Override
	public Validator<? super ControlAgreementElections> typeFormatValidator() {
		return new ControlAgreementElectionsTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super ControlAgreementElections, Set<String>> onlyExistsValidator() {
		return new ControlAgreementElectionsOnlyExistsValidator();
	}
}
