package cdm.legaldocumentation.csa.meta;

import cdm.legaldocumentation.csa.GeneralSimmElections;
import cdm.legaldocumentation.csa.validation.GeneralSimmElectionsTypeFormatValidator;
import cdm.legaldocumentation.csa.validation.GeneralSimmElectionsValidator;
import cdm.legaldocumentation.csa.validation.exists.GeneralSimmElectionsOnlyExistsValidator;
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
@RosettaMeta(model=GeneralSimmElections.class)
public class GeneralSimmElectionsMeta implements RosettaMetaData<GeneralSimmElections> {

	@Override
	public List<Validator<? super GeneralSimmElections>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super GeneralSimmElections, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super GeneralSimmElections> validator(ValidatorFactory factory) {
		return factory.<GeneralSimmElections>create(GeneralSimmElectionsValidator.class);
	}

	@Override
	public Validator<? super GeneralSimmElections> typeFormatValidator(ValidatorFactory factory) {
		return factory.<GeneralSimmElections>create(GeneralSimmElectionsTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super GeneralSimmElections> validator() {
		return new GeneralSimmElectionsValidator();
	}

	@Deprecated
	@Override
	public Validator<? super GeneralSimmElections> typeFormatValidator() {
		return new GeneralSimmElectionsTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super GeneralSimmElections, Set<String>> onlyExistsValidator() {
		return new GeneralSimmElectionsOnlyExistsValidator();
	}
}
