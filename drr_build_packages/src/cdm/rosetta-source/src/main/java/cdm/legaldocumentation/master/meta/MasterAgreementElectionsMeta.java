package cdm.legaldocumentation.master.meta;

import cdm.legaldocumentation.master.MasterAgreementElections;
import cdm.legaldocumentation.master.validation.MasterAgreementElectionsTypeFormatValidator;
import cdm.legaldocumentation.master.validation.MasterAgreementElectionsValidator;
import cdm.legaldocumentation.master.validation.datarule.MasterAgreementElectionsOneOf0;
import cdm.legaldocumentation.master.validation.exists.MasterAgreementElectionsOnlyExistsValidator;
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
@RosettaMeta(model=MasterAgreementElections.class)
public class MasterAgreementElectionsMeta implements RosettaMetaData<MasterAgreementElections> {

	@Override
	public List<Validator<? super MasterAgreementElections>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<MasterAgreementElections>create(MasterAgreementElectionsOneOf0.class)
		);
	}
	
	@Override
	public List<Function<? super MasterAgreementElections, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super MasterAgreementElections> validator(ValidatorFactory factory) {
		return factory.<MasterAgreementElections>create(MasterAgreementElectionsValidator.class);
	}

	@Override
	public Validator<? super MasterAgreementElections> typeFormatValidator(ValidatorFactory factory) {
		return factory.<MasterAgreementElections>create(MasterAgreementElectionsTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super MasterAgreementElections> validator() {
		return new MasterAgreementElectionsValidator();
	}

	@Deprecated
	@Override
	public Validator<? super MasterAgreementElections> typeFormatValidator() {
		return new MasterAgreementElectionsTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super MasterAgreementElections, Set<String>> onlyExistsValidator() {
		return new MasterAgreementElectionsOnlyExistsValidator();
	}
}
