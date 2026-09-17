package cdm.legaldocumentation.csa.meta;

import cdm.legaldocumentation.csa.JapaneseSecuritiesProvisions;
import cdm.legaldocumentation.csa.validation.JapaneseSecuritiesProvisionsTypeFormatValidator;
import cdm.legaldocumentation.csa.validation.JapaneseSecuritiesProvisionsValidator;
import cdm.legaldocumentation.csa.validation.datarule.JapaneseSecuritiesProvisionsAmendmentsToJapaneseProvisions;
import cdm.legaldocumentation.csa.validation.datarule.JapaneseSecuritiesProvisionsRelevantProvisionsElection;
import cdm.legaldocumentation.csa.validation.exists.JapaneseSecuritiesProvisionsOnlyExistsValidator;
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
@RosettaMeta(model=JapaneseSecuritiesProvisions.class)
public class JapaneseSecuritiesProvisionsMeta implements RosettaMetaData<JapaneseSecuritiesProvisions> {

	@Override
	public List<Validator<? super JapaneseSecuritiesProvisions>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<JapaneseSecuritiesProvisions>create(JapaneseSecuritiesProvisionsRelevantProvisionsElection.class),
			factory.<JapaneseSecuritiesProvisions>create(JapaneseSecuritiesProvisionsAmendmentsToJapaneseProvisions.class)
		);
	}
	
	@Override
	public List<Function<? super JapaneseSecuritiesProvisions, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super JapaneseSecuritiesProvisions> validator(ValidatorFactory factory) {
		return factory.<JapaneseSecuritiesProvisions>create(JapaneseSecuritiesProvisionsValidator.class);
	}

	@Override
	public Validator<? super JapaneseSecuritiesProvisions> typeFormatValidator(ValidatorFactory factory) {
		return factory.<JapaneseSecuritiesProvisions>create(JapaneseSecuritiesProvisionsTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super JapaneseSecuritiesProvisions> validator() {
		return new JapaneseSecuritiesProvisionsValidator();
	}

	@Deprecated
	@Override
	public Validator<? super JapaneseSecuritiesProvisions> typeFormatValidator() {
		return new JapaneseSecuritiesProvisionsTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super JapaneseSecuritiesProvisions, Set<String>> onlyExistsValidator() {
		return new JapaneseSecuritiesProvisionsOnlyExistsValidator();
	}
}
