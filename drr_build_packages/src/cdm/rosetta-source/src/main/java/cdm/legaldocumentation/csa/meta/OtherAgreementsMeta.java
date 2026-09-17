package cdm.legaldocumentation.csa.meta;

import cdm.legaldocumentation.csa.OtherAgreements;
import cdm.legaldocumentation.csa.validation.OtherAgreementsTypeFormatValidator;
import cdm.legaldocumentation.csa.validation.OtherAgreementsValidator;
import cdm.legaldocumentation.csa.validation.exists.OtherAgreementsOnlyExistsValidator;
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
@RosettaMeta(model=OtherAgreements.class)
public class OtherAgreementsMeta implements RosettaMetaData<OtherAgreements> {

	@Override
	public List<Validator<? super OtherAgreements>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super OtherAgreements, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super OtherAgreements> validator(ValidatorFactory factory) {
		return factory.<OtherAgreements>create(OtherAgreementsValidator.class);
	}

	@Override
	public Validator<? super OtherAgreements> typeFormatValidator(ValidatorFactory factory) {
		return factory.<OtherAgreements>create(OtherAgreementsTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super OtherAgreements> validator() {
		return new OtherAgreementsValidator();
	}

	@Deprecated
	@Override
	public Validator<? super OtherAgreements> typeFormatValidator() {
		return new OtherAgreementsTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super OtherAgreements, Set<String>> onlyExistsValidator() {
		return new OtherAgreementsOnlyExistsValidator();
	}
}
