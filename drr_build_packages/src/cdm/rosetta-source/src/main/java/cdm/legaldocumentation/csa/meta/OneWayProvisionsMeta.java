package cdm.legaldocumentation.csa.meta;

import cdm.legaldocumentation.csa.OneWayProvisions;
import cdm.legaldocumentation.csa.validation.OneWayProvisionsTypeFormatValidator;
import cdm.legaldocumentation.csa.validation.OneWayProvisionsValidator;
import cdm.legaldocumentation.csa.validation.datarule.OneWayProvisionsPostingPartyAbsent;
import cdm.legaldocumentation.csa.validation.datarule.OneWayProvisionsPostingPartyExists;
import cdm.legaldocumentation.csa.validation.exists.OneWayProvisionsOnlyExistsValidator;
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
@RosettaMeta(model=OneWayProvisions.class)
public class OneWayProvisionsMeta implements RosettaMetaData<OneWayProvisions> {

	@Override
	public List<Validator<? super OneWayProvisions>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<OneWayProvisions>create(OneWayProvisionsPostingPartyExists.class),
			factory.<OneWayProvisions>create(OneWayProvisionsPostingPartyAbsent.class)
		);
	}
	
	@Override
	public List<Function<? super OneWayProvisions, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super OneWayProvisions> validator(ValidatorFactory factory) {
		return factory.<OneWayProvisions>create(OneWayProvisionsValidator.class);
	}

	@Override
	public Validator<? super OneWayProvisions> typeFormatValidator(ValidatorFactory factory) {
		return factory.<OneWayProvisions>create(OneWayProvisionsTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super OneWayProvisions> validator() {
		return new OneWayProvisionsValidator();
	}

	@Deprecated
	@Override
	public Validator<? super OneWayProvisions> typeFormatValidator() {
		return new OneWayProvisionsTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super OneWayProvisions, Set<String>> onlyExistsValidator() {
		return new OneWayProvisionsOnlyExistsValidator();
	}
}
